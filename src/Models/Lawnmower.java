public class Lawnmower extends Model {
    public Lawnmower(Vector2 position) {
        super("Lawn Mower", "🚜", position, 1);
    }

    public void activate() {
        while (getPosition().getY() < 7) {
            Grid.remove(this);
            getPosition().setY(getPosition().getY() + 1);
            Grid.place(this);
            try {
                Thread.sleep(300);
            } catch (Exception e) {

            }
        }
        Grid.remove(this);
    }
}
