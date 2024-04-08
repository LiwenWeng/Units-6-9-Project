public class Model {
    private String symbol;
    private String name;
    private Vector2 position;
    private int renderPriority;
    private Grid grid;

    public Model(String name, String symbol, Vector2 position, int renderPriority, Grid grid) {
        this.position = position;
        this.symbol = symbol;
        this.name = name;
        this.renderPriority = renderPriority;
        this.grid = grid;
    }

    public Model(Vector2 position, Grid grid) {
        this("Grass", Utils.color("__", "Green"), position, 0, grid);
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        grid.remove(this);
        this.position = position;
        grid.place(this);
    }

    public int getRenderPriority() {
        return renderPriority;
    }

    public void setRenderPriority(int renderPriority) {
        this.renderPriority = renderPriority;
    }

    public Grid getGrid() {
        return grid;
    }
}
