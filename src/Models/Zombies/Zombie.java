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
                if (model == null) {
                    boolean plantInFront = false;
                    for (int i = 0; i < 80; i++) {
                        model = getGrid().contains(Plant.class, new Vector2(getPosition().getX(), getPosition().getY() - 1));
                        if (model != null) {
                            plantInFront = true;
                            break;
                        }
                        Utils.wait(100);
                    }

                    if (!plantInFront) {
                        getGrid().remove(this);
                        if (getPosition().getY() == 0) {
                            Game.gameOver = true;
                            break;
                        }
                        getPosition().setY(getPosition().getY() - 1);
                        getGrid().place(this);
                    }
                } else {
                    Utils.wait(1000);
                    ((Plant) model).takeDamage(damage);
                }
            }
            getGrid().remove(this);
        });
    }
}
