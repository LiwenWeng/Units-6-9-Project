import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Plant extends Model {
    private int health;
    private boolean isAlive;
    private final int COST;
    private final int FIRE_RATE;
    private static final Map<Integer, Integer> PLANT_INFO = new HashMap<>();
    static {
        PLANT_INFO.put(1, 50);
        PLANT_INFO.put(2, 100);
        PLANT_INFO.put(3, 50);
        PLANT_INFO.put(4, 150);
    }

    public Plant(String name, String symbol, Vector2 position, int renderPriority, Grid grid, int health, int cost, int fireRate) {
        super(name, symbol, position, renderPriority, grid);
        this.health = health;
        this.COST = cost;
        this.FIRE_RATE = fireRate;
        isAlive = true;
    }

    public int getCost() {
        return COST;
    }

    public int getHealth() {
        return health;
    }

    public int getFireRate() {
        return FIRE_RATE;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            getGrid().remove(this);
            isAlive = false;
        }
    }

    public boolean isAlive() {
        return isAlive;
    }

    public static void spawn(Grid grid, Vector2 position, int num) {
        if (grid.contains(new Class[]{Plant.class, Zombie.class}, position) == null) {
            if (Game.sun < PLANT_INFO.get(num)) return;
            Game.sun -= PLANT_INFO.get(num);
            switch (num) {
                case 1:
                    grid.place(new Sunflower(position, grid));
                    break;
                case 2:
                    grid.place(new Peashooter(position, grid));
                    break;
                case 3:
                    grid.place(new Wallnut(position, grid));
                    break;
                case 4:
                    grid.place(new Cherrybomb(position, grid));
                    break;
            }
        }
    }
}