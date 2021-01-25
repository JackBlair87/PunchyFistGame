import javax.swing.JFrame; //For the JFrame

public class TheGame{
   private static StevePanel steve;
   
   public static void main(String[] args){
      JFrame frame = new JFrame("Day 1 - Punchy Fist Game");
      frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //Full screen
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      steve = new StevePanel();
      frame.getContentPane().add(steve);
      frame.setVisible(true);
      steve.begin();
   }
}