public class Sun extends Model {
    private int amount;

    public Sun(Vector2 position) {
        super("Sun", "☀️", position, 2);
        this.amount = 25;
    }

    public void dropSun() { //drops sun from sky; sometimes doesn't work
        Runnable runnable = () -> {
//            getPosition().setY((int) (Math.random() * 8));
//            for (int i = 0; i < (int) (Math.random() * 5); i++) {
//                Grid.remove(this);
//                getPosition().setX(i);
//                Grid.place(this);
//                try {
//                    Thread.sleep(1000);
//                } catch (Exception e) {
//
//                }
//            }
            getPosition().setY((int) 7);
            for (int i = 0; i < (int) 5; i++) {
                System.out.println(this.getPosition());
                Grid.remove(this);
                getPosition().setX(i);
                Grid.place(this);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
