public class Projectile extends Model {
    private int damage;
    private Grid grid;
    public Projectile(String name, String symbol, Vector2 position, int renderPriority, int damage, Grid grid) {
        super(name, symbol, position, renderPriority);
        this.damage = damage;
        this.grid = grid;
    }

    public void hitTarget(Zombie zombie) {
        if (grid.getMap().get(getPosition().getX()).get(getPosition().getY()).contains(zombie)) {
            zombie.takeDamage(damage);
            grid.remove(this);
        }
    }
}
