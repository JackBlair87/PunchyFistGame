import javax.swing.*; //For Panel
import java.awt.*; //For graphics
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.*;
import java.awt.event.KeyEvent;

public class Steve {
  // Physics
  private int x;
  private int y;
  private int velocity;
  
  public boolean punching;
  public int hp = 20;
  public double money = 0.00;
  public boolean alive = true;


  //Graphics
  private BufferedImage steve;
  private BufferedImage punching_steve;
  private String steve_dir = "Punchy Fist Game/images/STEVE.png"; // image name
  private String steve_punching_dir = "Punchy Fist Game/images/PUNCHING_STEVE.png"; // image name

  public Steve() {
    System.out.println("Steve starts out with: " + hp + "");
    punching = false;
    x = 400;
    y = 550;
    try{
        steve = ImageIO.read(new File(steve_dir));
      }catch(Exception e) { 
        System.out.println("Error Steve");
      }
    try{
        punching_steve = ImageIO.read(new File(steve_punching_dir));
      }catch(Exception e) { 
        System.out.println("Error Punching Steve");
      }
  }

  public void update(double deltaTime) {
    x += velocity * deltaTime;
    // System.out.println(y);
  }

  public void draw(Graphics g) {
    int width = 286;
    int height = 176;
    if(punching == false){
      g.drawImage(steve, x - width / 2, y - width / 2, width, height, null);
    }
    else{
      g.drawImage(punching_steve, x - width / 2, y - width / 2, width, height, null);
    }
  }

  public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT){
          velocity = -10;
          System.out.println("Hello");
        }
        if (key == KeyEvent.VK_RIGHT)
          velocity = 10;
        if (key == KeyEvent.VK_SPACE){
          punching = true;
          //Punching
        }
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT)
          velocity = 0;
        if (key == KeyEvent.VK_RIGHT)
          velocity = 0;
        if (key == KeyEvent.VK_SPACE){
          punching = false;
        }
    }

  public void hitBy(String barrel_type){
    if(barrel_type == "BARREL") {
      hp -= 5;
      System.out.println("Steve was hit by a barrel, now has " + hp + " HP!!");
    } 
    else if(barrel_type == "TNT"){
      hp -= 10;
      System.out.println("Steve was hit by a TNT, now has " + hp + " HP!!");
    }
    else if(barrel_type == "MONEY"){
      hp -= 3;
      System.out.println("Steve was hit by MONEY, now has " + hp + " HP!!");
    }

    if(hp <= 0){
      alive = false;
    }
  }

  public void punched(String barrel_type){
    if(barrel_type == "BARREL") {
      if(Math.random() <= 0.25){
        hp += 3;
        System.out.println("Steve punched a barrel, now has " + hp + " HP!!");
      }
    } 
    else if(barrel_type == "TNT"){
      hp -= 5;
      System.out.println("Steve punched TNT, now has " + hp + " HP!!");
    }
    else if(barrel_type == "MONEY"){
      money += 0.50;
      System.out.println("Steve punched MONEY, now has " + money + " Money!!");
    }

    if(hp <= 0){
      alive = false;
    }
  }

}