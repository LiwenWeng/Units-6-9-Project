import java.util.ArrayList;

public class Grid {


    public Grid() {
        map = new Model[5][9];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = new Model(new Vector2(i, j));
            }
        }
        place(new LawnMower(new Vector2(0, 0)));
        place(new LawnMower(new Vector2(2, 4)));
        place(new LawnMower(new Vector2(3, 1)));
        place(new LawnMower(new Vector2(4, 2)));
        place(new LawnMower(new Vector2(1, 7)));
    }

    public void printMap() {
        for (Model[] models : map) {
            for (Model model : models) {
                System.out.print(model.getSymbol() + " ");
            }
            System.out.println();
        }
    }
    public void place(Model model) {
        map[model.getPosition().getX()][model.getPosition().getY()] = model;
    }


}
