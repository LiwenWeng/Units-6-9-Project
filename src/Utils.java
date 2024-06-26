import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Utils {
    private Utils() {}

    public static Map<String, String> Colors = new HashMap<>();
    public static String reset = "\u001b[0m";
    public static String bold = "\u001b[1m";
    static {
        Colors.put("Red", "\u001b[38;5;196m");
        Colors.put("Green", "\u001b[38;5;46m");
        Colors.put("Blue", "\u001b[38;5;51m");
        Colors.put("DarkBlue", "\u001b[38;5;21m");
        Colors.put("Yellow", "\u001b[38;5;226m");
        Colors.put("Purple", "\u001b[38;5;93m");
        Colors.put("Pink", "\u001b[38;5;201m");
        Colors.put("Gray", "\u001b[38;5;240m");
        Colors.put("Brown", "\u001b[38;2;92;54;11m");
        Colors.put("Brick", "\u001b[38;2;207;83;83m");
        Colors.put("RedBG", "\u001b[48;5;196m");
        Colors.put("Bold", "\u001b[1m");

    }

    public static String color(String text, String color) {
        return Colors.get(color) + text + reset;
    }

    public static String color(int num, String color) {
        return Colors.get(color) + num + reset;
    }

    public static String color(String text, String color, boolean bold) {
        return Colors.get(color) + Utils.bold + text + reset;
    }

    public static void clearLine() {
        System.out.print("\u001b[1A\u001b[2K");
    }

    public static void clearScreen() {
        System.out.print("\u001b[2J\u001b[1000A");
    }

    public static String bold(String text) {
        return bold + text + reset;
    }

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception ignored) {

        }
    }

    public static <T> void delay(int ms, Consumer<T> callback, T value) {
        startThread(() -> {
            wait(ms);
            callback.accept(value);
        });
    }

    public static void startThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public static void clear() {
        System.out.println("``");
    }
}