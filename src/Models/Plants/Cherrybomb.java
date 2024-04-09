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
            Utils.wait(2000);
            int zombiesKilled = 0;
            for (int i = -1; i <= 1 && zombiesKilled < 8; i++) {
                for (int j = -1; j <= 1 && zombiesKilled < 8; j++) {
                    for (Model zombie : getGrid().getAllOfTypeAtPos(
                            Zombie.class,
                            new Vector2(
                                    getPosition().getX() + i,
                                    getPosition().getY() + j
                            )
                    )) {
                        ((Zombie) zombie).takeDamage(10000);
                        zombiesKilled++;
                    }
                }
            }
            Utils.wait(500);
            super.takeDamage(damage);
        });
    }



}