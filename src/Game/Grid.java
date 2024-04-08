import java.util.ArrayList;
import java.util.function.Consumer;

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

    public void place(Model model, Vector2 position) {
        map.get(position.getX()).get(position.getY()).add(model);
    }

    public boolean remove(Model model) {
        ArrayList<Model> models = map.get(model.getPosition().getX()).get(model.getPosition().getY());
        if (!models.contains(model)) return false;
        map.get(model.getPosition().getX()).get(model.getPosition().getY()).remove(model);
        return true;
    }

    public boolean remove(Model model, int delay) {
        Utils.wait(delay);
        ArrayList<Model> models = map.get(model.getPosition().getX()).get(model.getPosition().getY());
        if (!models.contains(model)) return false;
        map.get(model.getPosition().getX()).get(model.getPosition().getY()).remove(model);
        return true;
    }

    public boolean remove(Model model, Consumer<Integer> callback, Integer value) {
        callback.accept(value);
        ArrayList<Model> models = map.get(model.getPosition().getX()).get(model.getPosition().getY());
        if (!models.contains(model)) return false;
        map.get(model.getPosition().getX()).get(model.getPosition().getY()).remove(model);
        return true;
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

    public <T> Model contains(Class<T>[] types, Vector2 position) {
        try {
            for (Model model : map.get(position.getX()).get(position.getY())) {
                if (model == null) continue;
                for (Class<T> type : types) {
                    if (type.isInstance(model)) return model;
                }
            }
        } catch (Exception ignored) {}

        return null;
    }

    public <T> boolean laneContains(Class<T> type, Vector2 position) {
        try {
            for (int i = position.getY()+1; i < 7; i++) {
                if (contains(type, new Vector2(position.getX(), i)) != null) {
                    return true;
                }
            }
        } catch (Exception ignored) {}
        return false;
    }

    private void spawnLawnMowers() {
        for (int i = 0; i < 5; i++) {
            lawnmowers.add(new Lawnmower(new Vector2(i, 0), this));
            place(lawnmowers.get(i));
        }
    }

    public void spawnZombies(int num) {
        Utils.startThread(() -> {
            for (int i = 0; i < num; i++) {
                Zombie zombie = new Zombie(new Vector2((int) (Math.random() * 5), 7), this);
                place(zombie);
                Utils.wait((int) (Math.random() * 5000) + 500);
            }
        });
    }
}