public class Grid {
    private Model[][] map;

    public Grid() {
        map = new Model[5][9];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = new Model(new Vector2(i, j));
            }
        }
    }

    public void printMap() {
        for (Model[] models : map) {
            for (Model model : models) {
                System.out.print(model.getSymbol() + " ");
            }
            System.out.println();
        }
    }


}
