public class Peashooter extends Plant {
    Projectile projectile;
    public Peashooter(Vector2 position) {
        super("Peashooter", "🌱", position, 1, 300, 1.5);
        projectile = new Projectile("Pea", "🍐", position, 2, 20);
    }
}
