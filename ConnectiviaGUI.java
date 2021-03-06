/* ConnectiviaGUI.java
 * Connectivia Game
 * Group: Caylene Parrish, Brenna Carver, Stephanie Frankian
 * Written by: Caylene Parrish
 * 
 * Purpose: The ConnectiviaGUI class sets up the GUI layout of the Connectivia application.
 * It sets up the main window by creating a Tabbed Pane with 3 tabs (the game, instructions,
 * and the match history) and populates each one with information from its respective Panel class.
 * 
 */
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class ConnectiviaGUI {
  public ConnectiviaGUI(Game game){
    //creates the overall JFrame that contains everything
    JFrame frame = new JFrame("Connectivia"); 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JTabbedPane tabbed = new JTabbedPane();
    BoardPanel boardpanel = new BoardPanel(game);
    tabbed.addTab("Connectivia!", boardpanel);
    tabbed.addTab("Instructions", new AboutPanel());
    //game is reinitialized. unless pass the linkedlists above as params here and in match so they dont
    //change with the Game recreation in BoardPanel
    tabbed.addTab("Match History", new MatchHistoryPanel(boardpanel.playerOneWins, boardpanel.playerTwoWins)); 
    
    //necessary to make the GUI visible
    frame.setResizable(false);
    frame.setPreferredSize(new Dimension(650,650));
    frame.getContentPane().add(tabbed);
    frame.pack();
    frame.setVisible(true);
  }
  
  //main method for testing
  public static void main(String[] args){
    Game g = new Game("presidential_trivia.txt");
    ConnectiviaGUI gui = new ConnectiviaGUI(g);    
  }
}