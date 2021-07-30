
package shooter.project1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Blocks implements Runnable{
    
    Rectangle blocks[] =new Rectangle[6];
    int xDirection, yDirection;
    
    //Constructor:
    public Blocks(){
        blocks[0] =new Rectangle(300,-100,20,20);
        blocks[1] =new Rectangle(100,-100,20,20);
        blocks[2] =new Rectangle(50, -100,20,20);
        blocks[3] =new Rectangle(600,-150,20,20);
        blocks[4] =new Rectangle(500,150,20,20);
        blocks[5] =new Rectangle(150,-150,20,20);
       
        
    }

    public void setXdirection(int xDirection){
        this.xDirection =xDirection;
    }
    public void setYdirection(int yDirection){
        this.yDirection =yDirection;
        
    }
    public void move(){
        for(Rectangle block :blocks){
            block.y++;
        
    }
    }
    
    public void draw(Graphics g){
        for(Rectangle block :blocks){
            g.setColor(Color.WHITE);
            g.fillRect(block.x, block.y, block.width, block.height);
        }
    }

    @Override
    public void run() {
        while(true){
            try{
                move();
                Thread.sleep(10);
                
            }
            catch(InterruptedException e){
                System.err.println(e.getMessage());
            }
        }
        
    }
  
}
