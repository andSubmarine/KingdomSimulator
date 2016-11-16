import com.sun.org.apache.regexp.internal.RE;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Class details:
 *
 * @author Andreas Blanke, blan@itu.dk
 * @version 25-10-2016.
 * @project KingdomSimulator
 */
public class FactionGraphs extends JComponent {
    private int lordPower, religionPower, citizenPower;
    private int lordPos, religionPos, citizenPos;

    // Constants
    private static final Color LORD_COLOR = Color.RED;
    private static final Color RELIGION_COLOR = Color.CYAN;
    private static final Color CITIZEN_COLOR = Color.ORANGE;
    public static final int WIDTH = 100;

    public FactionGraphs (int lordPower, int religionPower, int citizenPower) {
        this.lordPower = lordPower;
        this.religionPower = religionPower;
        this.citizenPower = citizenPower;
        this.lordPos = 60;
        this.religionPos = lordPos + WIDTH * 2;
        this.citizenPos = religionPos + WIDTH * 2;
    }

    public FactionGraphs() {
        this(0,0,0);
    }

    public void paint(Graphics g) {
        this.clear(g);
        int height;

        // Draw lord graph
        g.setColor(LORD_COLOR);
        height = (lordPower + 10) * 3;
        g.fillRect(lordPos,350-height,WIDTH,height);

        // Draw religion graph
        g.setColor(RELIGION_COLOR);
        height = (religionPower + 10) * 3;
        g.fillRect(religionPos,350-height,WIDTH, height);

        // Draw citizen graph
        g.setColor(CITIZEN_COLOR);
        height = (citizenPower + 10) * 3;
        g.fillRect(citizenPos,350-height,WIDTH, height);
    }

    private void clear(Graphics g) {
        // Clear painted area
        g.setColor(Color.WHITE);
        g.fillRect(0,0,this.getWidth(), this.getHeight());
    }

    public void update(Graphics g) {
        this.paint(g);
    }

    public void setValues(int newLordPow, int newRelPow, int newCitPow) {
        lordPower = setValue(newLordPow);
        religionPower = setValue(newRelPow);
        citizenPower = setValue(newCitPow);
        update(this.getGraphics());
    }

    private int setValue(int newValue) {
        int value = newValue;
        if (value < 0) value = 0;
        if (value > Faction.MAX_POWER) value = Faction.MAX_POWER;
        return value;
    }

}
