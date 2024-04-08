import java.util.ArrayList;

public class Projectile extends Model {
    private int damage;

    public Projectile(String name, String symbol, Vector2 position, int renderPriority, int damage, Grid grid) {
        super(name, symbol, position, renderPriority, grid);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
