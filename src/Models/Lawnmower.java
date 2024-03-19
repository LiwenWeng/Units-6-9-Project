public class Lawnmower extends Model {
    private Grid map;

    public Lawnmower(Vector2 position, Grid map) {
        super("Lawn Mower", "🚜", position, 1);
        this.map = map;
    }

    public void activate() {
        while (getPosition().getY() < 7) {
            map.remove(this);
            getPosition().setY(getPosition().getY() + 1);
            map.place(this);
            Utils.wait(300);
        }
        map.remove(this);
    }
}
