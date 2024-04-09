import java.util.Scanner;

public class MenuScreen {
    private Scanner scanner;

    public MenuScreen(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        int choice = menu();
        while (choice != 2) {
            if (choice == 0) {
                break;
            } else if (choice == 1) {
                credits();
                choice = menu();
            }
        }
        if (choice == 2) System.exit(0);
    }

    private int menu() {
        int currentIndex = 0;
        String input = " ";
        String[] options = new String[]{
                "> " + "[" + Utils.color(" PLAY ", "Green") + "]",
                "  " + "[" + Utils.color(" CREDITS ", "Blue") + "]",
                "  " + "[" + Utils.color(" LEAVE ", "Red") + "]"
        };

        while (!input.isEmpty()) {
            Utils.clear();
            String GAME_NAME = Utils.color("""
                      ____          _    _         __   _____   ___ _          _
                     |_  /___ _ __ | |__(_)___ ___ \\ \\ / / __| | _ \\ |__ _ _ _| |_ ___
                      / // _ \\ '  \\| '_ \\ / -_|_-<  \\ V /\\__ \\ |  _/ / _` | ' \\  _(_-<
                     /___\\___/_|_|_|_.__/_\\___/__/   \\_/ |___/ |_| |_\\__,_|_||_\\__/__/
                                                                                     
                    """, "Green");
            System.out.println(GAME_NAME);
            for (String option : options) {
                System.out.println(option + "\n");
            }
            input = scanner.nextLine().toLowerCase();

            if (input.equals("s")) {
                if (currentIndex == options.length-1) {
                    options[options.length-1] = options[options.length-1].replace("> ", "  ");
                    options[0] = options[0].replace("  ", "> ");
                    currentIndex = 0;
                } else {
                    options[currentIndex] = options[currentIndex].replace("> ", "  ");
                    options[currentIndex + 1] = options[currentIndex + 1].replace("  ", "> ");
                    currentIndex++;
                }
            } else if (input.equals("w")) {
                if (currentIndex == 0) {
                    options[options.length-1] = options[options.length-1].replace("  ", "> ");
                    options[0] = options[0].replace("> ", "  ");
                    currentIndex = options.length-1;
                } else {
                    options[currentIndex] = options[currentIndex].replace("> ", "  ");
                    options[currentIndex - 1] = options[currentIndex - 1].replace("  ", "> ");
                    currentIndex--;
                }
            }
        }

        return currentIndex;
    }

    private void credits() {
        Utils.clear();
        System.out.println(Utils.color("""
  ___ ___ ___ ___ ___ _____ ___ 
 / __| _ \\ __|   \\_ _|_   _/ __|
| (__|   / _|| |) | |  | | \\__ \\
 \\___|_|_\\___|___/___| |_| |___/

----------------
                                       """, "Blue"));

        System.out.println("Made by: Oscar Chong, Ojiro Moy, and Liwen Weng");
        scanner.nextLine();
    }
}
