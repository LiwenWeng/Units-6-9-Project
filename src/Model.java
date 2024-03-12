public class Model {
    private String symbol;
    private String name;
    private Vector2 position;
    private int renderPriority;

    public Model(String name, String symbol, Vector2 position, int renderPriority) {
        this.position = position;
        this.symbol = symbol;
        this.name = name;
        this.renderPriority = renderPriority;
    }

    public Model(Vector2 position) {
        this("Grass", Utils.color("_", "Green"), position, 0);
    }
}
