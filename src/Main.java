/**
 * Class details:
 * @author Andreas Blanke, blan@itu.dk
 * @version 21-10-2016.
 * @project KingdomSimulator
 */
public class Main {
    private static Player player;
    private static GraphicInterface gui;

    public static void main(String[] args) {
        // TODO: Implement program startup
        // TODO: Implement GUI
        player = new Player("Mr. Player");
        gui = new GraphicInterface();
    }

    public static void quit() {
        System.exit(0);
    }

    public static void open() {

    }

    public static void update() {
        int[] values = gui.valuesPrompt();
        gui.update(values[0],values[1],values[2]);
    }

    /* USED FOR TESTING ONLY
    public static void timeoffSet(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/
}
