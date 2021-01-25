import javax.swing.*; //For Panel
import java.awt.*; //For graphics
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.*;
//Crate, TNT, Money

//OOP (Object Oriented Programming)

//Draw the block
//Tracking position
//Status 

// Top Left (0, 0) (x, y)
//top right (100, 0) (x, y) 
//bottom left (0, 100)
// Bottom Right (100, 100) (x, y)

public class FallingObject{
  // Physics
  private int x;
  private int y;
  private int velocity;
  private String barrelType;

  // Graphics
  private BufferedImage barrel;
  private String barrel_dir = "Punchy Fist Game/images/BARREL.png"; //image name
  private String money_dir = "Punchy Fist Game/images/MONEY.png"; //image name
  private String tnt_dir = "Punchy Fist Game/images/TNT.png"; //image name

  public FallingObject(){
    double random = Math.random(); // (0 to 1)
    if(random > 0.5){
      barrelType = "BARREL";
      try{
         barrel = ImageIO.read(new File(barrel_dir));
      }catch(Exception e) { 
        System.out.println("Error Barrel");
      }
    }
    else if(random > 0.25){
      barrelType = "TNT";
      try{
        barrel = ImageIO.read(new File(tnt_dir));
      }catch(Exception e) { 
        System.out.println("Error TNT");
      }
    }
    else{
      barrelType = "MONEY";
      try{
        barrel = ImageIO.read(new File(money_dir));
      }catch(Exception e) { 
        System.out.println("Error Money");
      }
    }

    y = -32;
    x = (int) (Math.random() * 800);
    velocity = (int) (Math.random() * 2) + 3;
  }

  public void update(double deltaTime){
    y += velocity * deltaTime;
    // System.out.println(y);
  }

  public void draw(Graphics g){
    int width = 64;
    int height = 64;
    g.drawImage(barrel, x - width/2, y - width/2, width, height, null);
  } 

  public boolean hitGround(){
    return false;
  }

  public String toString(){
    return "Crate is type: " + barrelType + " and has velocity " + velocity + " and Barrel Image" + barrel.toString();
  }
}