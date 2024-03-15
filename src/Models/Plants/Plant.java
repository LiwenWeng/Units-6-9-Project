public class Plant extends Model {
    int health;
    double fireRate;
    public Plant(String name, String symbol, Vector2 position, int renderPriority, int health, double fireRate) {
        super(name, symbol, position, renderPriority);
        this.health = health;
        this.fireRate = fireRate;
    }
}