public class Projectile extends Model {
    int damage;
    public Projectile(String name, String symbol, Vector2 position, int renderPriority, int damage) {
        super(name, symbol, position, renderPriority);
        this.damage = damage;
    }


}
