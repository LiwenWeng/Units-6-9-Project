public class Plant extends Model {
    private int health;
    private int cost;
    private double fireRate;

    public Plant(String name, String symbol, Vector2 position, int renderPriority, int health, int cost, double fireRate) {
        super(name, symbol, position, renderPriority);
        this.health = health;
        this.cost = cost;
        this.fireRate = fireRate;
    }

    public int getCost() {
        return cost;
    }
}