import java.util.ArrayList;

public class Grid {
    private static ArrayList<ArrayList<ArrayList<Model>>> map;
    private ArrayList<Lawnmower> lawnmowers;

    public Grid() {
        map = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            map.add(new ArrayList<>());
            for (int j = 0; j < 8; j++) {
                map.get(i).add(new ArrayList<>());
                map.get(i).get(j).add(new Model(new Vector2(i, j)));
            }
        }
        lawnmowers = new ArrayList<>();
        spawnLawnMowers();


        //test code
        Sun sun = new Sun(new Vector2(3, 3));
        sun.dropSun();

        lawnmowers.get(0).activate();
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
    public static void place(Model model) {
        map.get(model.getPosition().getX()).get(model.getPosition().getY()).add(model);
    }

    public static void remove(Model model) {
        map.get(model.getPosition().getX()).get(model.getPosition().getY()).remove(model);
    }

    private void spawnLawnMowers() {
        Lawnmower lawnmower1 = new Lawnmower(new Vector2(0, 0));
        Lawnmower lawnmower2 = new Lawnmower(new Vector2(1, 0));
        Lawnmower lawnmower3 = new Lawnmower(new Vector2(2, 0));
        Lawnmower lawnmower4 = new Lawnmower(new Vector2(3, 0));
        Lawnmower lawnmower5 = new Lawnmower(new Vector2(4, 0));
        lawnmowers.add(lawnmower1);
        lawnmowers.add(lawnmower2);
        lawnmowers.add(lawnmower3);
        lawnmowers.add(lawnmower4);
        lawnmowers.add(lawnmower5);
        for (Lawnmower lawnmower : lawnmowers) {
            place(lawnmower);
        }
    }
}
