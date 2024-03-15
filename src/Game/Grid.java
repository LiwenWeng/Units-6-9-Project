import java.util.ArrayList;

public class Grid {
    ArrayList<ArrayList<ArrayList<Model>>> map;

    public Grid() {
        map = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            map.add(new ArrayList<>());
            for (int j = 0; j < 8; j++) {
                map.get(i).add(new ArrayList<>());
                map.get(i).get(j).add(new Model(new Vector2(i, j)));
            }
        }
        spawnLawnMowers();
    }

    public void printMap() {
        for (ArrayList<ArrayList<Model>> row : map) {
            for (ArrayList<Model> column : row) {
                Model highestRender = column.get(0);
                for (Model model : column) {
                    if (model.getRenderPriority() > highestRender.getRenderPriority()) {
                        highestRender = model;
                    }
                }
                System.out.print(highestRender.getSymbol() + " ");
            }
            System.out.println();
        }
    }
    public void place(Model model) {
        map.get(model.getPosition().getX()).get(model.getPosition().getY()).add(model);
    }

    private void spawnLawnMowers() {
        place(new LawnMower(new Vector2(0, 0)));
        place(new LawnMower(new Vector2(1, 0)));
        place(new LawnMower(new Vector2(2, 0)));
        place(new LawnMower(new Vector2(3, 0)));
        place(new LawnMower(new Vector2(4, 0)));
    }
}
