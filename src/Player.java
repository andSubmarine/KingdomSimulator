/**
 * Class details:
 *
 * @author Andreas Blanke, blan@itu.dk
 * @version 21-10-2016.
 * @project KingdomSimulator
 */
public class Player {
    private String name;
    private Kingdom kingdom;

    public Player(String name) {
        this.name = name;
        this.kingdom = new Kingdom();
    }


}
