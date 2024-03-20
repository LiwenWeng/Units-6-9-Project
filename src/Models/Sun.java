import java.util.ArrayList;

public class Sun extends Model {
    private Grid map;
    private int amount;

    public Sun(Vector2 position, Grid map) {
        super("Sun", "☀️", position, 2);
        this.amount = 25;
        this.map = map;
    }

    public void dropSun() { //drops sun from sky; sometimes doesn't work
        Runnable runnable = () -> {
            getPosition().setY((int) (Math.random() * 8));
            int c = (int) (Math.random() * 5);
            for (int i = 0; i < c; i++) {
                map.remove(this);
                getPosition().setX(i);
                map.place(this);
                Utils.wait(1000);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
