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
        this("Grass", Utils.color("__", "Green"), position, 0);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public int getRenderPriority() {
        return renderPriority;
    }

    public void setRenderPriority(int renderPriority) {
        this.renderPriority = renderPriority;
    }
}
