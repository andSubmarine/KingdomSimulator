import java.util.*;

/**
 * Class details:
 *
 * @author Andreas Blanke, blan@itu.dk
 * @version 21-10-2016.
 * @project KingdomSimulator
 */
public class Kingdom {
    /* FIELDS AND CONSTANTS */
    private Treasury treasury;
    private ArrayList<Faction> factions;

    /* CONSTRUCTORS */
    public Kingdom(int startCredits, int lordPower, int citizenPower, int religionPower) {
        treasury = new Treasury(startCredits);
        factions = new ArrayList<>();

        Faction lordFaction = new Faction("LORD_FACTION",lordPower);
        lordFaction.addActor(new Actor("Lord", "Treacherous"));
        Faction citizenFaction = new Faction("CITIZEN_FACTION",citizenPower);
        lordFaction.addActor(new Actor("Merchant", "Greedy"));
        Faction religionFaction = new Faction("RELIGION_FACTION",religionPower);
        lordFaction.addActor(new Actor("Bishop", "Hypocrite"));

        factions.add(lordFaction);
        factions.add(citizenFaction);
        factions.add(religionFaction);
    }

    public Kingdom() {
        this(100,40,20,40);
    }

    /* MUTATOR METHODS */
    public void changePowers(int lordPower, int citizenPower, int religionPower) {
        for (Faction faction : factions) {
            switch (faction.getFactionName()) {
                case "LORD_FACTION":
                    faction.changePower(lordPower);
                    break;
                case "CITIZEN_FACTION":
                    faction.changePower(citizenPower);
                    break;
                case "RELIGION_FACTION":
                    faction.changePower(religionPower);
                    break;
            }
        }
    }

    public int getFactionID(String factionName) {
        int index = 0;
        switch (factionName) {
            case "LORD_FACTION":
                index = 0;
                break;
            case "CITIZEN_FACTION":
                index = 1;
                break;
            case "RELIGION_FACTION":
                index = 2;
                break;
        }
        return index;
    }

    public void addActor(String factionName, Actor actor) {
        factions.get(getFactionID(factionName)).addActor(actor);
    }

    /* ACCESSOR METHODS */
    public Actor getActor(String factionName, String actorName){
        Actor actor;
        int factionID = getFactionID(factionName);
        actor = factions.get(factionID).getActor(actorName);
        return actor;
    }

    public int getBalance() {
        return treasury.getBalance();
    }
}
