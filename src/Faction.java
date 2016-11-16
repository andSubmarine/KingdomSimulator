import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class details:
 *
 * @author Andreas Blanke, blan@itu.dk
 * @version 21-10-2016.
 * @project KingdomSimulator
 */
public class Faction {
    /* FIELDS AND CONSTANTS */
    private HashMap<String,Actor> actors;
    private String factionName;
    private int politicalPower;
    public static final int MAX_POWER = 100;

    /* CONSTRUCTORS */

    public Faction(String factionName, int startPower) {
        this.factionName = factionName;
        actors = new HashMap<>();
        politicalPower = startPower;
    }

    /* MUTATOR METHODS */
    public void changePower(int power) {
        if (power < MAX_POWER) {
            politicalPower += power;
            if (politicalPower > MAX_POWER) politicalPower = MAX_POWER;
        }
    }

    public void addActor(Actor actor) {
        actors.put(actor.getName(),actor);
    }

    /* ACCESSOR METHODS */
    public Actor getActor(String name) {
        return actors.get(name);
    }

    public String getFactionName(){
        return factionName;
    }
}
