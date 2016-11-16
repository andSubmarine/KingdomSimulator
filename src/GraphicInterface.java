import jdk.nashorn.internal.scripts.JO;

import java.awt.*;
import java.awt.event.*;
import java.util.InputMismatchException;
import javax.swing.*;

/**
 * Class details:
 *
 * @author Andreas Blanke, blan@itu.dk
 * @version 25-10-2016.
 * @project KingdomSimulator
 */
public class GraphicInterface {
    private JFrame window;
    private JLabel lordsDetails, religionDetails, citizenDetails;
    private FactionGraphs graphPanel;

    public GraphicInterface() {
        makeFrame();
    }

    public void makeFrame() {
        window = new JFrame("Kingdom Simulator");
        window.setPreferredSize(new Dimension(640,480));
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Setup of window
        createMenu();       // creates the MenuBar and its contents
        createContent();    // creates content on the page
        pack(true);         // packs and sets the visibility of the window
    }

    private void createMenu() {
        // Setup of the menubar
        JMenuBar menubar = new JMenuBar();
        window.setJMenuBar(menubar);

        /* --- File Menu --- */
        JMenu fileMenu = new JMenu("Run...");
        menubar.add(fileMenu);

        // Open file menu item
        JMenuItem openItem = new JMenuItem("Change values");
        openItem.addActionListener(
                (ActionEvent e) -> {
                    Main.update();
                }
        );
        fileMenu.add(openItem);

        // Quit file menu item
        JMenuItem quitItem = new JMenuItem("Close program");
        quitItem.addActionListener(
                (ActionEvent e) -> {
                    Main.quit();
                }
        );
        fileMenu.add(quitItem);

        /* --- Help Menu --- */
        JMenu helpMenu = new JMenu("Help");
        menubar.add(helpMenu);

        // Get help menu item
        JMenuItem helpItem = new JMenuItem("Get Help");
        helpItem.addActionListener(
                (ActionEvent e) -> {
                    // TODO: Implement and Use Help Class
                }
        );
        helpMenu.add(helpItem);
    }

    private void createContent() {
        Container contentPane = window.getContentPane();
        contentPane.setLayout(new BorderLayout());

        // -- Creating a label on top --
        JPanel descPane = new JPanel();
        JLabel descLabel = new JLabel("This graphic shows the power levels of the Factions in the Kingdom");
        descPane.add(descLabel);
        contentPane.add(descPane, BorderLayout.PAGE_START);

        /* --- Creating the graphic for the factions --- */
        graphPanel = new FactionGraphs();
        graphPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        contentPane.add(graphPanel, BorderLayout.CENTER);

        /* --- Creating the footer of the graphic that includes the values of the factions --- */
        JPanel variablesPanel = new JPanel();
        variablesPanel.setLayout(new FlowLayout());

        // Creates the three labels
        lordsDetails = new JLabel();
        religionDetails = new JLabel();
        citizenDetails = new JLabel();

        // Updates their info and adds them to the panel
        updateFactionDetails(50,0,0);
        variablesPanel.add(lordsDetails);
        variablesPanel.add(religionDetails);
        variablesPanel.add(citizenDetails);

        // Adds the footer to the content pane
        contentPane.add(variablesPanel, BorderLayout.PAGE_END);
    }

    public int[] valuesPrompt() {
        int[] array = new int[3];
        boolean complete = false;
        while (!complete) {
        try {
            array[0] = promptInputInt("Lord Faction");
            array[1] = promptInputInt("Religion Faction");
            array[2] = promptInputInt("Citizen Faction");
            complete = true;
        } catch (InputMismatchException e) {
            //custom title, error icon
            JOptionPane.showMessageDialog(window,
                    "User input was not an integer.",
                    "Trying again...",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(window,
                    e.getMessage(),
                    "Trying again...",
                    JOptionPane.ERROR_MESSAGE);
        }}
        return array;
    }

    private int promptInputInt(String factionName) throws Exception{
        String input = JOptionPane.showInputDialog("Please enter the new value for the "+factionName +
                                                    "." + "\n (An integer in the range from 0-100)");
        int value = Integer.parseInt(input);
        if (value <= 100 && 0 <= value) {
            return value;
        } else {
            throw new Exception("You have to enter a new value in the range from 0-100");
        }

    }

    public void update(int lordPower, int religionPower, int citizenPower) {
        updateFactionDetails(lordPower, religionPower, citizenPower);
        updateGraphs(lordPower, religionPower, citizenPower);
        pack(true);
    }

    private void updateFactionDetails(int lordPower, int religionPower, int citizenPower) {
        String divider = " |";
        lordsDetails.setText("Lord Faction: " + lordPower + divider);
        religionDetails.setText("Religion Faction: " + religionPower + divider);
        citizenDetails.setText("Citizen Faction: " + citizenPower);
    }

    private void updateGraphs(int lordPower, int religionPower, int citizenPower) {
        graphPanel.setValues(lordPower,religionPower,citizenPower);
    }

    public void pack(boolean visible) {
        window.pack();
        window.setVisible(visible);
    }
}
