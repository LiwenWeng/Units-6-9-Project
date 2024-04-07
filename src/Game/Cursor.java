import jdk.jshell.execution.Util;

public class Cursor extends Model {
    public Cursor(Grid grid) {
        super("Cursor", Utils.color("__", "Red"), new Vector2(0, 1), Integer.MAX_VALUE, grid);
        getGrid().place(this);
    }

    public void start() {
        blink();
        collectSun();
    }

    public void move(String input) {
        int x = getPosition().getX();
        int y = getPosition().getY();
        switch (input) {
            case "w":
                if (x == 0) break;
                setPosition(new Vector2(x-1, y));
                break;
            case "s":
                if (x == 4) break;
                setPosition(new Vector2(x+1, y));
                break;
            case "a":
                if (y == 1) break;
                setPosition(new Vector2(x, y-1));
                break;
            case "d":
                if (y == 7) break;
                setPosition(new Vector2(x, y+1));
                break;
        }
    }

    private void blink() {
        Utils.startThread(() -> {
            while (true) {
                setRenderPriority(Integer.MIN_VALUE);
                Utils.wait(500);
                setRenderPriority(Integer.MAX_VALUE);
                Utils.wait(500);
            }
        });
    }

    private void collectSun() {
        Utils.startThread(() -> {
            while (true) {
                Model model = getGrid().contains("Sun", getPosition());
                if (model != null) {
                    Game.sun += Sun.AMOUNT;
                    Sun.sunOnMap--;
                    getGrid().remove(model);
                }
            }
        });
    }
}
