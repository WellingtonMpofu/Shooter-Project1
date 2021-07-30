
package shooter.project1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;


public class Main extends JFrame implements Runnable {
    //Declaring variables:
    Image dbImage;
    Graphics dbg;
    int xDirection, yDirection;
    int x,y;
   
    Rectangle bullet;
    Rectangle bullet2;
    boolean shot, readyToShoot;
    int bx, by;
    Blocks block =new Blocks();
   
    
    
    //Constructor:
    public Main(){
        setTitle("Welloe");
        setSize(700,600);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLUE);
        x =350;
        y =559;
        addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() ==KeyEvent.VK_LEFT){
                    setXdirection(-1);
                    
                }
                if(e.getKeyCode() ==KeyEvent.VK_RIGHT){
                     setXdirection(+1);
                    
                }
                if(e.getKeyCode() ==KeyEvent.VK_SPACE){
                    if(bullet ==null){
                        readyToShoot =true;
                    }
                    if(readyToShoot){
                        bx =x+30;
                        by =y-20;
                        bullet =new Rectangle(bx,by,12,10);
                        shot =true;
                    }
                                       
                }
                
            }
             public void keyReleased(KeyEvent e){
                 if(e.getKeyCode() ==KeyEvent.VK_LEFT){
                    setXdirection(0);
                    
                }
                if(e.getKeyCode() ==KeyEvent.VK_RIGHT){
                     setXdirection(0);
                    
                }
                if(e.getKeyCode() ==KeyEvent.VK_SPACE){
                    
                }
            
            }

        });
           
    }
    //Methods to implement Threads:
    public void setXdirection(int xDirection){
        this.xDirection =xDirection;
        
    }
    
    public void move(){
        this.x +=xDirection;
       
        //Collision Detection for the gun:
       if(x <=0){
           x=0;
       }
       if(x>=630){
           x=630;
       }
            
    
    }
    public void shoot(){
        if(shot){
            bullet.y--;
        }
    }

    @Override
    public void paint(Graphics g){
        dbImage =createImage(getWidth(), getHeight());
        dbg =dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
        
    }
    
    public void paintComponent(Graphics g){
        //Draw componets:
        g.setColor(Color.BLACK);
        g.fillRect(x, y, 70, 20);
        g.fillRect(x+30, y-20,12 , 20);
        //Setting up block:
        g.setColor(Color.WHITE);
        block.draw(g);

        if(shot){
            g.setColor(Color.RED);
            g.fillRect(bullet.x, bullet.y, bullet.width , bullet.height);
            if(bullet.intersects(block.blocks[0])){
                block.blocks[0]    =new Rectangle(-100-100,0,0,0);
                bullet =new Rectangle(0,0,0,0);
            }
            else if(bullet.intersects(block.blocks[1])){
                block.blocks[1]    =new Rectangle(-100-100,0,0,0);
                bullet =new Rectangle(0,0,0,0);
            }
             else if(bullet.intersects(block.blocks[2])){
                block.blocks[2]    =new Rectangle(-100-100,0,0,0);
                bullet =new Rectangle(0,0,0,0);
            }
             else if(bullet.intersects(block.blocks[3])){
                block.blocks[3]    =new Rectangle(-100-100,0,0,0);
                bullet =new Rectangle(0,0,0,0);
            }
             else if(bullet.intersects(block.blocks[4])){
                block.blocks[4]    =new Rectangle(-100-100,0,0,0);
                bullet =new Rectangle(0,0,0,0);
            }
             else if(bullet.intersects(block.blocks[5])){
                block.blocks[5]    =new Rectangle(-100-100,0,0,0);
                bullet =new Rectangle(0,0,0,0);
            }
         
           

        }
       
        repaint();
        
        
    }


    @Override
    public void run() {
      
            try{
                while(true){
                    move();
                    shoot();
                    Thread.sleep(2);
                    
                }
                
            }
        
            catch(InterruptedException e){
                System.err.println(e.getMessage());
                
            }
        }
    
    public static void main(String[] args) {
        Main game =new Main();
        Thread gun =new Thread(game);
        gun.start();
        Thread Blocks =new Thread(game.block);
        Blocks.start();
      
    }
                  
}
