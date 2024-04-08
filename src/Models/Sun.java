public class Sun extends Model {
    public static final int AMOUNT = 25;
    public static int sunOnMap = 0;
    private volatile boolean collected;

    public Sun(Vector2 position, Grid grid) {
        super("Sun", "☀️", position, 2, grid);
        collected = false;
    }

    public boolean isCollected() {
        return collected;
    }

    public void collect() {
        collected = true;
    }

    public void dropSun() {
       Utils.startThread(() -> {
           getPosition().setY(1);
           int c = (int) (Math.random() * 6);
           for (int i = 0; i < c && !collected; i++) {
               setPosition(new Vector2(i, getPosition().getY()));
               Utils.wait(750);
           }
           getGrid().remove(
                   this,
                   (v) -> {
                       Utils.startThread(() -> Utils.wait(v));
                       while (true) {
                           if (!collected) continue;
                           if (getGrid().remove(this)) break;
                       }
                   },
                   20000
           );
           sunOnMap--;
       });
    }
}
