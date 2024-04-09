import java.util.*;

public class Game {
    public static int sun;
    private Grid grid;
    private Scanner scanner;
    private int wave;
    private Cursor cursor;
    private MenuScreen menuScreen;
    private volatile Queue<String> inputQueue;
    public volatile static boolean gameOver;
    private Sunflower sunflower;
    private Peashooter peashooter;
    private Wallnut wallnut;
    private Cherrybomb cherrybomb;
    private final double ZOMBIE_MULTIPLIER;

    public Game() {
        sun = 5000;
        grid = new Grid();
        scanner = new Scanner(System.in);
        wave = 100;
        cursor = new Cursor(grid);
        menuScreen = new MenuScreen(scanner);
        inputQueue = new LinkedList<>();
        gameOver = false;
        sunflower = new Sunflower();
        peashooter = new Peashooter();
        wallnut = new Wallnut();
        cherrybomb = new Cherrybomb();
        ZOMBIE_MULTIPLIER = 1.25;
    }

    public void start() {
        menuScreen.start();
        spawnSun();
        wave();
        addInputsToQueue();
        cursor.start();
        while (!gameOver) {
            updateMap();
            System.out.println(Utils.color("Wave: " + wave, "Red"));
            handleInputs();
            Utils.wait(500);
        }
        printEndScreen();
        System.exit(0);
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

    public void spawnSun() {
        Utils.startThread(() -> {
            while (!Game.gameOver) {
                if (Sun.sunOnMap > 5) continue;
                Sun sun = new Sun(new Vector2(), grid);
                sun.dropSun();
                Sun.sunOnMap++;
                Utils.wait(7500);
            }
        });
    }

    public void updateMap() {
        Utils.clear();
        printPlantBar();
        grid.printMap();
    }

    public void wave() {
        Utils.startThread(() -> {
            Utils.wait(10000);
            while (!Game.gameOver) {
                wave++;
                grid.spawnZombies((int) (wave * ZOMBIE_MULTIPLIER));
                Utils.wait(15000 + wave  * 10000);
            }
        });
    }

    private void addInputsToQueue() {
        Utils.startThread(() -> {
            while (!Game.gameOver) {
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

            int intInput;
            try {
                intInput = Integer.parseInt(input);
            } catch (Exception e) {
                intInput = -1;
            }

            if (new ArrayList<>(List.of(new String[]{"w", "a", "s", "d"})).contains(input.toLowerCase())) {
                cursor.move(input.toLowerCase());
            } else if (intInput > 0 && intInput < 5) {
                Plant.spawn(grid, cursor.getPosition(), Integer.parseInt(input));
            }
        }
    }

    private void printEndScreen() {
        Utils.clear();
        String gameOverText = """
                ╔═╗╔═╗╔╦╗╔═╗  ╔═╗╦  ╦╔═╗╦═╗┬
                ║ ╦╠═╣║║║║╣   ║ ║╚╗╔╝║╣ ╠╦╝│
                ╚═╝╩ ╩╩ ╩╚═╝  ╚═╝ ╚╝ ╚═╝╩╚═o
                ------------------
                """;
        System.out.println(Utils.color(gameOverText, "Red"));
        System.out.println("Waves survived: " + wave);
    }
}
