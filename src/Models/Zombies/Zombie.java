public class Zombie extends Model {
    int health;
    int damage;

    public Zombie(Vector2 position, Grid grid) {
        super("Zombie", "🧟", position, 1, grid);
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
        if (health <= 0) {
            getGrid().remove(this);
        }
    }

    public void start() {
        Utils.startThread(() -> {
            while (true) {
                Model model = getGrid().contains(Plant.class, new Vector2(getPosition().getX(), getPosition().getY() - 1));
                if (!(model instanceof Plant)) {
                    Utils.wait(5000);
                    getGrid().remove(this);
                    getPosition().setY(getPosition().getY() - 1);
                    getGrid().place(this);
                } else {

                }
            }
        });
    }
}
