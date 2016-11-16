/**
 * Class details:
 *
 * @author Andreas Blanke, blan@itu.dk
 * @version 21-10-2016.
 * @project KingdomSimulator
 */
public class Treasury {
    /* FIELDS AND CONSTANTS */
    private int balance;    // credits

    /* CONSTRUCTORS */
    public Treasury(int startBalance) {
        balance = startBalance;
    }

    /* MUTATOR METHODS */
    public void addCredits(int credits) {
        if (credits > 0) balance += credits;
    }

    public void useCredits(int credits) {
        if (credits > 0) balance -= credits;
    }

    /* ACCESSOR METHODS */
    public int getBalance() {
        return balance;
    }
}
