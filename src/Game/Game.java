import java.util.Scanner;

public class Game {
    private int sun;
    private Grid grid;
    private Scanner scanner;
    private int wave;

    public Game() {
        sun = 50;
        grid = new Grid();
        scanner = new Scanner(System.in);
        wave = 1;
    }

    public void start() {
        updateMap();
        spawnSun();
        grid.getLawnmowers().get(0).activate();

    }

    public int getSun() {
        return sun;
    }

    public void printPlantBar() {
        Sunflower sunflower = new Sunflower(null, grid);
        Peashooter peashooter = new Peashooter(null, grid);
        Wallnut wallnut = new Wallnut(null, grid);
        Cherrybomb cherrybomb = new Cherrybomb(null, grid);
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
            return "999";
        } else {
            return String.valueOf(sun);
        }
    }

    // TODO: make a gameOver variable
    public void spawnSun() {
        Utils.newThread(() -> {
            while (true) {
                Sun sun = new Sun(new Vector2(), grid);
                sun.dropSun();
                Utils.wait(10000);
            }
        });
    }

    public void updateMap() {
        Utils.newThread(() -> {
            while (true) {
                printPlantBar();
                grid.printMap();
                Utils.wait(500);
                System.out.println("`");
            }
        });
    }

    public void wave() {
        grid.spawnZombies(wave * 2);
        wave++;
    }
}
