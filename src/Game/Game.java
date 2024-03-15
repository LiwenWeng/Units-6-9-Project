import java.util.Scanner;

public class Game {
    int sun;

    public Game() {}

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
        String sunString = " 000 ";


        String brownBar = Utils.color("|", "Brown");
        System.out.println(Utils.color(" __________________________", "Brown"));
        System.out.println(brownBar + "  ☀️ " + brownBar + " 🌻 " + brownBar + " 🌱 " + brownBar + " 🌰 " + brownBar + " 🍒 " + brownBar);
        System.out.println(brownBar + sunString + brownBar + " " + sunflower.getCost() + " " + brownBar + " " + peashooter.getCost() + " " + brownBar + " " + wallnut.getCost() + " " + brownBar + " " + cherrybomb.getCost() + brownBar);
    }
}
