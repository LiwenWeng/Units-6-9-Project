public class Peashooter extends Plant {
    private Projectile projectile;

    public Peashooter(Vector2 position, Grid grid) {
        super("Peashooter", "🌱", position, 1, grid, 300, 100, 1500);
        projectile = new Projectile("Pea", "🍐", position, 2, 20, grid);
        start();
    }

    public void start() {
        Utils.startThread(() -> {
            while (isAlive()) {

                getGrid().place(projectile);
                while (projectile.getPosition().getY() < 7) {
                    getGrid().remove(projectile);
                    projectile.getPosition().setY(projectile.getPosition().getY() + 1);
                    getGrid().place(projectile);
                    Model model = getGrid().contains(Zombie.class, new Vector2(getPosition().getX(), getPosition().getY()));
                    if (model instanceof Zombie) {
                        ((Zombie) model).takeDamage(projectile.getDamage());
                        break;
                    }
                    Utils.wait(200);
                }
                getGrid().remove(projectile);
                Utils.wait(getFireRate());
            }
        });
    }
}
