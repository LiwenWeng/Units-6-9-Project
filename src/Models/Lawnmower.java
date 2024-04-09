public class Lawnmower extends Model {
    public Lawnmower(Vector2 position, Grid grid) {
        super("Lawn Mower", "🚜", position, 1, grid);
        start();
    }

    private void start() {
        Utils.startThread(() -> {
            while (true) {
                Model model = getGrid().contains(Zombie.class, new Vector2(getPosition().getX(), getPosition().getY() + 1));
                if (model instanceof Zombie) {
                    Utils.wait(4000);
                    model = getGrid().contains(Zombie.class, new Vector2(getPosition().getX(), getPosition().getY() + 1));
                    if (!(model instanceof Zombie)){
                        break;
                    }
                    while (getPosition().getY() < 7) {
                        getGrid().remove(this);
                        getPosition().setY(getPosition().getY() + 1);
                        getGrid().place(this);
                        for (Model zombie : getGrid().getAllOfTypeAtPos(Zombie.class, getPosition())) {
                            ((Zombie) zombie).takeDamage(10000);
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
