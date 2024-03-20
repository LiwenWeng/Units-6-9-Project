public class Projectile extends Model {
    private int damage;
    private Grid map;

    public Projectile(String name, String symbol, Vector2 position, int renderPriority, int damage, Grid map) {
        super(name, symbol, position, renderPriority);
        this.damage = damage;
        this.map = map;
    }

    public void hitTarget(Zombie zombie) {
//        if (map.get(getPosition().getX()).get(getPosition().getY()).contains(zombie)) {
//            zombie.takeDamage(damage);
//            map.remove(this);
//        }
    }
}