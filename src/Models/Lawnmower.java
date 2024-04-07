public class Lawnmower extends Model {
    public Lawnmower(Vector2 position, Grid grid) {
        super("Lawn Mower", "🚜", position, 1, grid);
    }

    public void activate() {
        Utils.startThread(() -> {
            while (true) {
                Model model = getGrid().contains(Zombie.class, new Vector2(getPosition().getX(), getPosition().getY() + 1));
                if (model instanceof Zombie) {
                    while (getPosition().getY() < 7) {

                        getGrid().remove(this);
                        getPosition().setY(getPosition().getY() + 1);
                        getGrid().place(this);
                        model = getGrid().contains(Zombie.class, new Vector2(getPosition().getX(), getPosition().getY()));
                        if (model instanceof Zombie) {
                            ((Zombie) model).takeDamage(10000);
                        }
                        Utils.wait(300);
                    }
                    getGrid().remove(this);
                    break;
                }
            }
        });
    }
}
