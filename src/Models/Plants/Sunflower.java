public class Sunflower extends Plant{
    public Sunflower(Vector2 position, Grid grid) {
        super("Sunflower", "🌻", position, 1, grid, 600, 50, 2400);
        start();
    }

    public Sunflower() {
        super("Sunflower", "🌻", null, 1, null, 600, 50, 2400);
        start();
    }

    private void start() {
        Utils.startThread(() -> {
            while (isAlive() && !Game.gameOver) {
                if (getPosition() == null) continue;
                Utils.wait(9000);
                spawnSun();
                Utils.wait(9000);
            }
        });
    }

    private void spawnSun() {
        Utils.startThread(() -> {
            Sun sun = new Sun(this.getPosition(), getGrid());
            getGrid().place(sun);
            sun.removeSun(15000);
        });

    }
}