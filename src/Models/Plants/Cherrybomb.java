public class Cherrybomb extends Plant {
    public Cherrybomb(Vector2 position, Grid grid) {
        super("Cherrybomb", "🍒", position, 1, grid, 1, 150, 0);
        this.takeDamage(100);
    }

    public Cherrybomb() {
        super("Cherrybomb", "🍒", null, 1, null, 1, 150, 0);
    }

    @Override
    public void takeDamage(int damage) {
        Utils.startThread(() -> {
            Utils.wait(500);
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    Model model = getGrid().contains(
                            Zombie.class,
                            new Vector2(
                                    getPosition().getX() + i,
                                    getPosition().getY() + j
                            )
                    );
                    if (model != null) {
                        ((Zombie) model).takeDamage(10000);
                    }
                }
            }
            Utils.wait(500);
            super.takeDamage(damage);
        });
    }



}