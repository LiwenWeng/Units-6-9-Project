public class Model {
    private String symbol;
    private String name;
    private Vector2 vector;
    public Model(String symbol, String name, int x, int y) {
        this.vector = new Vector2(x, y);
        this.symbol = symbol;
        this.name = name;
    }
}
