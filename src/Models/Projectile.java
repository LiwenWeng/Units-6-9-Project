import jdk.jshell.execution.Util;

public class Projectile extends Model {
    private int damage;
    private Plant parent;

    public Projectile(String name, String symbol, Vector2 position, int renderPriority, int damage, Grid grid, Plant parent) {
        super(name, symbol, position, renderPriority, grid);
        this.damage = damage;
        this.parent = parent;
    }

    public int getDamage() {
        return damage;
    }

    public void start() {
        setPosition(parent.getPosition());
        Utils.startThread(() -> {
            while (getPosition().getY() < 7) {
                setPosition(new Vector2(parent.getPosition().getX(),  getPosition().getY()+1));
                Model model = getGrid().contains(Zombie.class, getPosition());
                if (model != null) {
                    ((Zombie) model).takeDamage(damage);
                    break;
                }
                Utils.wait(200);
            }
            getGrid().remove(this);
        });

    }
}
