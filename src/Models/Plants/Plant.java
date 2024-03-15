public class Plant extends Model {
    private int health;
    private int cost;

    public Plant(String name, String symbol, Vector2 position, int renderPriority, int health, int cost) {
        super(name, symbol, position, renderPriority);
        this.health = health;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}