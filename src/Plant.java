public class Plant extends Model {
    int health;

    public Plant(String name, String symbol, Vector2 position, int renderPriority, int health) {
        super(name, symbol, position, renderPriority);
        this.health = health;
    }
}
