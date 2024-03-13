public class Zombie extends Model {
    int health;
    int damage;

    public Zombie(Vector2 position) {
        super("Zombie", "🧟", position, 1);
        this.health = 200;
        this.damage = 100;
    }
}
