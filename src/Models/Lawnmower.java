public class Lawnmower extends Model {
    public Lawnmower(Vector2 position, Grid grid) {
        super("Lawn Mower", "🚜", position, 1, grid);
    }

    public void activate() {
        Runnable runnable = () -> {
            while (getPosition().getY() < 7) {
                getGrid().remove(this);
                getPosition().setY(getPosition().getY() + 1);
                getGrid().place(this);
                Utils.wait(300);
            }
            getGrid().remove(this);
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
