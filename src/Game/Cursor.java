import java.util.Arrays;

public class Cursor extends Model {
    public Cursor(Grid grid) {
        super("Cursor", "__", new Vector2(), Integer.MAX_VALUE, grid);
    }

    public void blink() {
        Utils.startThread(() -> {
            while (true) {
                getGrid().remove(this);
                Utils.wait(500);
                getGrid().place(this);
                Utils.wait(500);
            }
        });
    }
}
