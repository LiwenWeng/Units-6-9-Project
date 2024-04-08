public class Zombie extends Model {
    private int health;
    private int damage;
    private boolean isAlive;

    public Zombie(Vector2 position, Grid grid) {
        super("Zombie", "🧟", position, 1, grid);
        this.health = 200;
        this.damage = 100;
        isAlive = true;
        start();
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
            isAlive = false;
        }
    }

    private void start() {
        Utils.startThread(() -> {
            while (isAlive) {
                Model model = getGrid().contains(Plant.class, new Vector2(getPosition().getX(), getPosition().getY() - 1));
                if (!(model instanceof Plant)) {
                    Utils.wait(7000);
                    getGrid().remove(this);
                    if (getPosition().getY() == 0) {
                        Game.gameOver = true;
                        break;
                    }
                    getPosition().setY(getPosition().getY() - 1);
                    getGrid().place(this);
                } else {
                    Utils.wait(1000);
                    ((Plant) model).takeDamage(damage);
                }
            }
            getGrid().remove(this);
        });
    }
}
