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
        String sunString = " 000 ";


        String brownBar = Utils.color("|", "Brown");
        System.out.println(Utils.color(" __________________________", "Brown"));
        System.out.println(brownBar + "  ☀️ " + brownBar + " 🌻 " + brownBar + " 🌱 " + brownBar + " 🌰 " + brownBar + " 🍒 " + brownBar);
        System.out.println(brownBar + sunString + brownBar + " 50 " + brownBar + " 100 " + brownBar + " 50 " + brownBar + " 150" + brownBar);
    }
}
