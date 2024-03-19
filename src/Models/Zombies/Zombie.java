public class Zombie extends Model {
    int health;
    int damage;

    public Zombie(Vector2 position) {
        super("Zombie", "🧟", position, 1);
        this.health = 200;
        this.damage = 100;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }
}
