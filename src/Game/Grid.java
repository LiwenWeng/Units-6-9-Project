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

    public ArrayList<Lawnmower> getLawnmowers() {
        return lawnmowers;
    }

    public void printMap() {
        int count = 0;
        System.out.println(" ___________________________ ");
        for (ArrayList<ArrayList<Model>> row : map) {
            if (count != 2) {
                System.out.print(Utils.color("| ", "Brick"));
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
        ArrayList<Model> models = map.get(model.getPosition().getX()).get(model.getPosition().getY());
        if (!models.contains(model)) return;
        map.get(model.getPosition().getX()).get(model.getPosition().getY()).remove(model);
    }

    public void remove(Model model, int delay) {
        Utils.wait(delay);
        ArrayList<Model> models = map.get(model.getPosition().getX()).get(model.getPosition().getY());
        if (!models.contains(model)) return;
        map.get(model.getPosition().getX()).get(model.getPosition().getY()).remove(model);
    }

    public Model contains(String modelName, Vector2 position) {
        try {
            for (Model model : map.get(position.getX()).get(position.getY())) {
                if (model == null) continue;
                if (model.getName().equals(modelName)) return model;
            }
        } catch (Exception ignored) {}

        return null;
    }

    public <T> Model contains(Class<T> type, Vector2 position) {
        try {
            for (Model model : map.get(position.getX()).get(position.getY())) {
                if (model == null) continue;
                if (type.isInstance(model)) return model;
            }
        } catch (Exception ignored) {}

        return null;
    }

    private void spawnLawnMowers() {
        for (int i = 0; i < 5; i++) {
            lawnmowers.add(new Lawnmower(new Vector2(i, 0), this));
            place(lawnmowers.get(i));
            lawnmowers.get(i).activate();
        }
    }

    public void spawnZombies(int num) {
        Utils.startThread(() -> {
            for (int i = 0; i < num; i++) {
                Zombie zombie = new Zombie(new Vector2((int) (Math.random() * 5), 7), this);
                place(zombie);
                zombie.start();
                Utils.wait((int) (Math.random() * 5000) + 500);
            }
        });
    }
}