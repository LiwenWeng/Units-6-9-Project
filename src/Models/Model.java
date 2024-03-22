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

    public Model(Vector2 position) {
        this("Grass", Utils.color("__", "Green"), position, 0, new Grid());
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

    public Grid getGrid() {
        return grid;
    }

//    public boolean overlaps(Model model) {
//        return grid.getMap().get(getPosition().getX()).get(getPosition().getY()).contains(model);
//    }

}
