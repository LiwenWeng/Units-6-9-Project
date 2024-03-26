import java.util.ArrayList;

public class Grid {
    private ArrayList<ArrayList<ArrayList<Model>>> map;
    private ArrayList<Lawnmower> lawnmowers;

    public Grid() {
        map = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            map.add(new ArrayList<>());
            for (int j = 0; j < 8; j++) {
                map.get(i).add(new ArrayList<>());
                map.get(i).get(j).add(new Model(new Vector2(i, j), this));
            }
        }
        lawnmowers = new ArrayList<>();
        spawnLawnMowers();
    }

    public ArrayList<ArrayList<ArrayList<Model>>> getMap() {
        return map;
    }

    public void printMap() {
        int count = 0;
        System.out.println(" ___________________________ ");
        for (ArrayList<ArrayList<Model>> row : map) {
            if (count != 2) {
                System.out.print(Utils.color("| ", "Pink"));
            } else {
                System.out.print(Utils.color("| ", "Brown"));
            }
            count++;
            for (ArrayList<Model> column : row) {
                Model highestRender = column.get(0);
                for (Model model : column) {
                    if (model.getRenderPriority() > highestRender.getRenderPriority()) {
                        highestRender = model;
                    }
                }
                System.out.print(highestRender.getSymbol() + " ");
            }
            System.out.print("__");
            System.out.println();
        }
        System.out.println(" ___________________________ ");
    }

    public void place(Model model) {
        map.get(model.getPosition().getX()).get(model.getPosition().getY()).add(model);
    }

    public void remove(Model model) {
        map.get(model.getPosition().getX()).get(model.getPosition().getY()).remove(model);
    }

    private void spawnLawnMowers() {
        for (int i = 0; i < 5; i++) {
            lawnmowers.add(new Lawnmower(new Vector2(i, 0), this));
            place(lawnmowers.get(i));
        }
    }

    public void spawnZombies(int num) {
        for (int i = 0; i < num; i++) {
            place(new Zombie(new Vector2(5, (int) (Math.random() * 6)), this));
            Utils.wait(1000);
        }
    }
}