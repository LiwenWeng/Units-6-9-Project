public class Projectile extends Model {
    private int damage;

    public Projectile(String name, String symbol, Vector2 position, int renderPriority, int damage, Grid grid) {
        super(name, symbol, position, renderPriority, grid);
        this.damage = damage;
    }

    public void hitTarget(Zombie zombie) {
        if (getGrid().getMap().get(getPosition().getX()).get(getPosition().getY()).contains(zombie)) {
            zombie.takeDamage(damage);
            getGrid().remove(this);
        }
    }
}
