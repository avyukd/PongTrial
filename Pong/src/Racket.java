
import java.awt.Color;
import java.awt.Graphics;

public class Racket {
	
	private Color myColor;
	private int myXwidth;
	private int myYwidth;
	private int x;
	private int y;
	
	
	public Racket(){
		myColor = Color.MAGENTA;
		x = 200;
		y = 200;
		myXwidth = 50;
		myYwidth = 75;
		
	}
	
	public Racket(Color c, int x,int y,int myX,int myY){
		myColor = c;
		this.x = x;
		this.y = y;
		myXwidth  =myX;
		myYwidth = myY;
	}
	
	public int getX(){
		return x;
		
	}
	public int getY(){
		return y;
		
	}
	public int getXWidth(){
		return myXwidth;
		
	}
	public int getYWidth(){
		return myYwidth;
		
	}
	public void setX(int x){
		this.x = x;
		
	}
	public void setY(int y){
		this.y = y;
		
	}
	public void setXWidth(int xw){
		myXwidth = xw;
		
	}
	public void setYWidth(int yw){
		myYwidth = yw;
		
	}
	public void draw(Graphics g){
		g.setColor(myColor);
		g.fillRect(getX(), getY(), getXWidth(), getYWidth());
	}
	
	public void jump(){
		setX((int)(((Math.random()*400)))-getXWidth());
		setY((int)(((Math.random()*400)))-getYWidth());
	}

	public boolean inBumper(Puck dot) {
		// TODO Auto-generated method stub
		for(int x = getX(); x <= getX() + getXWidth(); x++)   //starts at upper left corner(x,y)
            for(int y = getY(); y <= getY() + getYWidth(); y++)
               if(distance(x, y, dot.getX(), dot.getY()) <= dot.getRadius() ) //checks every point on the bumper
                  return true;            
         return false;
	}
	 private double distance(double x1, double y1, double x2, double y2)
     {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
     }	


}