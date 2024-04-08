import java.util.Arrays;

public class Plant extends Model {
    private int health;
    private int cost;
    private int fireRate;
    private boolean isAlive;

    public Plant(String name, String symbol, Vector2 position, int renderPriority, Grid grid, int health, int cost, int fireRate) {
        super(name, symbol, position, renderPriority, grid);
        this.health = health;
        this.cost = cost;
        this.fireRate = fireRate;
        isAlive = true;
    }

    public int getCost() {
        return cost;
    }

    public int getHealth() {
        return health;
    }

    public int getFireRate() {
        return fireRate;
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