public class Plant extends Model {
    private int health;
    private int cost;
    private int fireRate;

    public Plant(String name, String symbol, Vector2 position, int renderPriority, Grid grid, int health, int cost, int fireRate) {
        super(name, symbol, position, renderPriority, grid);
        this.health = health;
        this.cost = cost;
        this.fireRate = fireRate;
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
}