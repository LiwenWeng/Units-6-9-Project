public class Peashooter extends Plant {
    private Projectile projectile;
    private Grid map;

    public Peashooter(Vector2 position, Grid map) {
        super("Peashooter", "🌱", position, 1, 300, 100, 1500);
        projectile = new Projectile("Pea", "🍐", position, 2, 20, map);
        this.map = map;
    }

    public void shoot() {
        while (getHealth() > 0) {
            map.place(projectile);
            while (projectile.getPosition().getY() < 7) {
                map.remove(projectile);
                projectile.getPosition().setY(projectile.getPosition().getY() + 1);
                map.place(projectile);
                Utils.wait(300);
            }
            map.remove(projectile);
            Utils.wait(getFireRate());
        }
    }
}