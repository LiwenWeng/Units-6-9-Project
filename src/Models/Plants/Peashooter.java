public class Peashooter extends Plant {
    private Projectile projectile;

    public Peashooter(Vector2 position, Grid grid) {
        super("Peashooter", "🌱", position, 1, grid, 300, 100, 1500);
        projectile = new Projectile("Pea", "🍐", position, 2, 20, grid, this);
        start();
    }

    public void start() {
        Utils.startThread(() -> {
            while (isAlive()) {
                if (!getGrid().laneContains(Zombie.class, getPosition())) continue;
                projectile.start();
                Utils.wait(getFireRate());
            }
        });
    }
}
