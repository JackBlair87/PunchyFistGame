import javax.swing.*; //For Panel
import java.awt.*; //For graphics
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.*;

public class StevePanel extends JPanel {
  public static BufferedImage world;
  private String dir = "Punchy Fist Game/images/BACKGROUND.png"; // image name
  private BufferedImage mImage;

  // Crates
  ArrayList<FallingObject> crates = new ArrayList<FallingObject>();
  Steve s = new Steve();

  public StevePanel() {

    try {
      world = ImageIO.read(new File(dir));
    } catch (Exception e) {
      System.out.println("Error");
    }
  }

  public void begin() {
    long lastLoopTime = System.nanoTime();
    final int TARGET_FPS = 30;
    final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
    double lastFpsTime = 0;
    int fps = 0;

    while (s.alive && s.money < 20.0 ) { // loop forever
      long now = System.nanoTime();
      long updateLength = now - lastLoopTime;
      lastLoopTime = now;
      double delta = updateLength / ((double) OPTIMAL_TIME);

      if (now % 120 == 0) {
        FallingObject newCrate = new FallingObject();
        crates.add(newCrate);
      }


      // Stuff
      s.update(delta);
      for (int x = 0; x < crates.size(); x++) {
        crates.get(x).update(delta);
      }
      repaint();

      try {
        Thread.sleep((lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000); // Try to wait
      } catch (Exception e) {
        // System.out.println("Something went wrong.");
      }
    }

    //Game ends
    //Display you loose 
    //End the game
  }

  @Override
  public void paintComponent(Graphics g) {
    draw();
    g.drawImage(mImage, 0, 0, getWidth(), getHeight(), null);

  }

  public void draw() {
    mImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
    Graphics g = mImage.getGraphics();
    // draw here

    g.drawImage(world, 0, 0, getWidth(), getHeight(), null);
    s.draw(g);
    for (FallingObject crate : crates) {
      crate.draw(g);
      // System.out.println(crate.toString());
    }

  }
}