public class Sunflower extends Plant {
    private Sun sun;
    public Sunflower(Vector2 position) {
        super("Sunflower", "🌻",position, 1, 600, 24);
        sun = new Sun(position);
    }


}