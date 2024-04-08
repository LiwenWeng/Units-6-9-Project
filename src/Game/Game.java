import javax.xml.transform.stream.StreamSource;
import java.util.*;

public class Game {
    public static int sun;
    private Grid grid;
    private Scanner scanner;
    private int wave;
    private Cursor cursor;
    private volatile Queue<String> inputQueue;
    public volatile static boolean gameOver;
    private Sunflower sunflower;
    private Peashooter peashooter;
    private Wallnut wallnut;
    private Cherrybomb cherrybomb;

    public Game() {
        sun = 50;
        grid = new Grid();
        scanner = new Scanner(System.in);
        wave = 1;
        cursor = new Cursor(grid);
        inputQueue = new LinkedList<>();
        gameOver = false;
        sunflower = new Sunflower(null, grid);
        peashooter = new Peashooter(null, grid);
        wallnut = new Wallnut(null, grid);
        cherrybomb = new Cherrybomb(null, grid);
    }

    public void start() {
        spawnSun();
        wave();
        addInputsToQueue();
        cursor.start();
        while (!gameOver) {
            updateMap();
            handleInputs();
            Utils.wait(500);
        }
    }

    public int getSun() {
        return sun;
    }

    public void printPlantBar() {
        String sunString =  " " + formatSun(sun) + " ";
        String brownBar = Utils.color("|", "Brown");
        System.out.println(Utils.color(" __________________________", "Brown"));
        System.out.println(brownBar + "  ☀️ " + brownBar + " 🌻 " + brownBar + " 🌱 " + brownBar + " 🌰 " + brownBar + " 🍒 " + brownBar);
        System.out.println(brownBar + sunString + brownBar + " " + sunflower.getCost() + " " + brownBar + " " + peashooter.getCost() + " " + brownBar + " " + wallnut.getCost() + " " + brownBar + " " + cherrybomb.getCost() + brownBar);
    }

    private String formatSun(int sun) {
        if (sun / 10 <= 0) {
            return "00" + sun;
        } else if (sun / 100 <= 0) {
            return "0" + sun;
        } else if (sun >= 1000) {
            Game.sun = 999;
            return "999";
        } else {
            return String.valueOf(sun);
        }
    }

    // TODO: make a gameOver variable
    public void spawnSun() {
        Utils.startThread(() -> {
            while (true) {
                if (Sun.sunOnMap > 5) continue;
                Sun sun = new Sun(new Vector2(), grid);
                sun.dropSun();
                Sun.sunOnMap++;
                Utils.wait(10000);
            }
        });
    }

    public void updateMap() {
        Utils.clear();
        printPlantBar();
        grid.printMap();
    }
//call to update map from other classes instead of on loop?
//    public static void update() {
//        System.out.println("`");
//        printPlantBar();
//        grid.printMap();
//        Utils.wait(500);
//    }

    public void wave() {

        Utils.startThread(() -> {
            while (true) {
                grid.spawnZombies((int) (wave * 1.25));
                wave++;
                Utils.wait(wave * 15000);
            }
        });
    }

    private void addInputsToQueue() {
        Utils.startThread(() -> {
            while (true) {
                String userInput = scanner.nextLine();
                inputQueue.add(userInput);
            }
        });
    }

    private void handleInputs() {
        System.out.print("> ");

        if (!inputQueue.isEmpty()) {
            String input = inputQueue.poll();
            assert input != null;
            if (new ArrayList<>(List.of(new String[]{"w", "a", "s", "d"})).contains(input.toLowerCase())) {
                cursor.move(input.toLowerCase());
            } else if (!input.isEmpty() && Integer.parseInt(input) > 0 && Integer.parseInt(input) < 5) {
                Plant.spawn(grid, cursor.getPosition(), Integer.parseInt(input));
            }
        }
    }
}
