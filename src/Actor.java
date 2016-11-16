/**
 * Class details:
 *
 * @author Andreas Blanke, blan@itu.dk
 * @version 21-10-2016.
 * @project KingdomSimulator
 */
public class Actor {
    private String title;
    private String name;

    public Actor(String title, String name) {
        this.title = title;
        this.name = name;
    }

    public void changeTitle(String newTitle) {
        title = newTitle;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return title + " " + name;
    }

}
