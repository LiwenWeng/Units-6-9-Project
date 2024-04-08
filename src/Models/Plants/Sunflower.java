public class Sunflower extends Plant{
    public Sunflower(Vector2 position, Grid grid) {
        super("Sunflower", "🌻",position, 1, grid, 600, 50, 2400);
        start();
    }

    private void start() {
        Utils.startThread(() -> {
            while (isAlive() && !Game.gameOver) {
                if (getPosition() == null) continue;
                Utils.wait(12000);
                spawnSun();
                Utils.wait(12000);
            }
        });
    }

    private void spawnSun() {
        Utils.startThread(() -> {
            Sun sun = new Sun(this.getPosition(), getGrid());
            getGrid().place(sun);
            getGrid().remove(sun, 20000);
        });

    }


}