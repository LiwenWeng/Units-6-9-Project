import java.util.ArrayList;

public class Projectile extends Model {
    private int damage;

    public Projectile(String name, String symbol, Vector2 position, int renderPriority, int damage, Grid grid) {
        super(name, symbol, position, renderPriority, grid);
        this.damage = damage;
    }

    public void hitTarget() {
        ArrayList<Model> tile = getGrid().getMap().get(getPosition().getX()).get(getPosition().getY());
        for (Model model : tile) {
            if (model instanceof Zombie) {
                ((Zombie) model).takeDamage(damage);
                getGrid().remove(this);
            }
        }
    }
}
