public class Peashooter extends Plant {
    Projectile projectile;
    public Peashooter(Vector2 position) {
        super("Peashooter", "🌱", position, 1, 300, 100, 1500);
        projectile = new Projectile("Pea", "🍐", position, 2, 20);
    }

    public void shoot() {
        while (getHealth() > 0) {
            Grid.place(projectile);
            while (projectile.getPosition().getY() < 7) {
                Grid.remove(projectile);
                projectile.getPosition().setY(projectile.getPosition().getY() + 1);
                Grid.place(projectile);
                try {
                    Thread.sleep(300);
                } catch (Exception e) {

                }
            }
            Grid.remove(projectile);
            try {
                Thread.sleep(getFireRate());
            } catch (Exception e) {

            }
        }
    }
}
