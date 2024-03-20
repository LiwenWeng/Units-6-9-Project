import java.util.Scanner;

public class Game {
    private int sun;
    private Grid map;
    private Scanner scanner;

    public Game() {
        sun = 50;
        map = new Grid();
        scanner = new Scanner(System.in);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        Grid grid = new Grid();
        spawnSun();
        while (true) {
            printPlantBar();
            grid.printMap();
            Utils.clearScreen();
            Utils.wait(100);
        }

    }

    public int getSun() {
        return sun;
    }

    public void printPlantBar() {
        Sunflower sunflower = new Sunflower(null);
        Peashooter peashooter = new Peashooter(null, map);
        Wallnut wallnut = new Wallnut(null);
        Cherrybomb cherrybomb = new Cherrybomb(null);
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

    public void spawnSun() {
        Runnable runnable = () -> {
            while (true) {
                Sun sun = new Sun(new Vector2(), map);
                sun.dropSun();
                Utils.wait(10000);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
