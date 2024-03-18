import java.util.Scanner;

public class Game {
    int sun;

    public Game() {
        this.sun = 100;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        Grid grid = new Grid();
        printPlantBar();
        grid.printMap();
        scanner.nextLine();

    }

    public int getSun() {
        return sun;
    }

    public void printPlantBar() {
        Sunflower sunflower = new Sunflower(null);
        Peashooter peashooter = new Peashooter(null);
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
            return sun + "";
        }
    }
}
