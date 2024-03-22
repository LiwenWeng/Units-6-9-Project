public class Peashooter extends Plant {
    private Projectile projectile;

    public Peashooter(Vector2 position, Grid grid) {
        super("Peashooter", "🌱", position, 1, grid, 300, 100, 1500);
        projectile = new Projectile("Pea", "🍐", position, 2, 20, grid);
    }

    public void shoot() {
        while (getHealth() > 0) {
            getGrid().place(projectile);
            while (projectile.getPosition().getY() < 7) {
                getGrid().remove(projectile);
                projectile.getPosition().setY(projectile.getPosition().getY() + 1);
                getGrid().place(projectile);
                projectile.hitTarget();
                Utils.wait(200);
            }
            getGrid().remove(projectile);
            Utils.wait(getFireRate());
        }
    }
}
