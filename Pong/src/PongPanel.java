import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
public class PongPanel extends JPanel {
	private static final Color BACKGROUND = Color.BLACK;
	private BufferedImage myImage;
	private Graphics Pong;
	private Puck puck;
	private Racket p1;
	private Racket p2;
	private Timer t;
	private static int p1_score = 0;
	private static int p2_score = 0;

	public PongPanel(){
			
			myImage = new BufferedImage(800,350,BufferedImage.TYPE_INT_RGB);
			
			Pong = myImage.getGraphics();
			
			Pong.setColor(BACKGROUND);
			Pong.fillRect(0, 0, 800, 350);
			puck = new Puck(500,200,50,Color.WHITE);
			p1 = new Racket(Color.WHITE,20,100,40,100);
			p2 = new Racket(Color.WHITE,720,100,40,100);
			addKeyListener(new P1Key());
			setFocusable(true);
			addKeyListener(new P2Key());
			setFocusable(true);
	}
	
    public void paintComponent(Graphics g)
    {
    	
     g.drawImage(myImage, 0, 0, 800, 350, null);
  	 
  	
		
    }
    
    public void stepAnimation(){

			  Pong.setColor(BACKGROUND);
     	       Pong.fillRect(0,0,800,350);
     	       p1.draw(Pong);     
     	       p2.draw(Pong);
     	       puck.move(800,350);
     	       
     	       BumperCollision.collide(p1, puck);
     	       BumperCollision.collide(p2, puck);
     	       p1.draw(Pong);
     	       p2.draw(Pong);
     	       puck.draw(Pong); 
     	       
     	       p1_score = puck.p1score;
     	       p2_score = puck.p2score;
     	       Pong.setColor(Color.BLACK);
     	       repaint();
			
		
    	
    }
    
    
	 private class P1Key extends KeyAdapter
     {
         public void keyPressed(KeyEvent e)
         {
          if(e.getKeyCode() == KeyEvent.VK_W){
          	 p1.setY( p1.getY()-15 );
          }
          if(e.getKeyCode() == KeyEvent.VK_S){
              p1.setY( p1.getY()+15 );
          }   

         }
     }
	 
	 
	 private class P2Key extends KeyAdapter
     {
         public void keyPressed(KeyEvent e)
         {
          if(e.getKeyCode() == KeyEvent.VK_UP){
          	 p2.setY( p2.getY()-15 );
          }
          if(e.getKeyCode() == KeyEvent.VK_DOWN){
              p2.setY( p2.getY()+15 );
          }   

         }
     }
    
}
