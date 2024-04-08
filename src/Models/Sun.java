public class Sun extends Model {
    public static final int AMOUNT = 25;
    public static int sunOnMap = 0;

    public Sun(Vector2 position, Grid grid) {
        super("Sun", "☀️", position, 2, grid);
    }

    public void dropSun() {
       Utils.startThread(() -> {
           getPosition().setY((int) (Math.random() * 7) + 1);
           int c = (int) (Math.random() * 6);
           for (int i = 0; i < c; i++) {
               setPosition(new Vector2(i, getPosition().getY()));
               Utils.wait(750);
           }
           getGrid().remove(this, 20000);
           sunOnMap--;
       });
    }
}
