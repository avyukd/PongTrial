import java.awt.Color;
import java.awt.Graphics;

public class Puck {
	private double myX;   // x and y coordinates of center
    private double myY;
    private double myDiameter;
    private Color myColor; 
    private double myRadius;
    private double dx;      
	  private double dy;
	 public int p1score;
	  public int p2score;
   // constructors
    public Puck()     //default constructor
    {
       myX = 200;
       myY = 200;
       myDiameter = 25;
       myColor = Color.BLACK;
       myRadius = myDiameter/2;
       dx = Math.random() * 2-1;  // horizontal
       while(dx == 0){dx = Math.random() * 2-1;}
	    dy = Math.random() * 2-1; 
	    while(dy == 0){dy = Math.random() * 2-1;}
	    p1score =0;
	    p2score = 0;
    }
    public Puck(double x, double y, double d, Color c)
    {
       myX = x;
       myY = y;
       myDiameter = d;
       myColor = c;
       myRadius = d/2;
       dx = Math.random() * 2-1;  // horizontal
       while(dx == 0){dx = Math.random() * 2-1;}
	    dy = Math.random() * 2-1; 
	    while(dy == 0){dy = Math.random() * 2-1;}
	    p1score =0;
	    p2score = 0;
    }
  // accessor methods
    public double getX() 
    { 
       return myX;
    }
    public double getY()      
    { 
       return myY;
    }
    public double getDiameter() 
    { 
       return myDiameter;
    }
    public Color getColor() 
    { 
       return myColor;
    }
    public double getRadius() 
    { 
       return myRadius;
    }
 // modifier methods
    public void setX(double x)
    {
       myX = x;
    } 
    public void setY(double y)
    {
       myY =y;
    } 
    public void setColor(Color c)
    {
       myColor = c;
    }
    public void setDiameter(double d)
    {
       myDiameter = d;
       myRadius = d/2;
    }
    public void setRadius(double r)
    {
       myRadius = r;
       myDiameter = 2*r;
    }
    
    public void setRandomDX(){
    	 dx = Math.random() * 2-1;  // horizontal
         while(dx == 0){dx = Math.random() * 2-1;}
  	  
    }
    
    public void setRandomDY(){
    	  dy = Math.random() * 2-1; 
    	    while(dy == 0){dy = Math.random() * 2-1;}
    }
    
 
  public double getDx() {
		return dx;
	}
	public void setDx(double dx) {
		this.dx = dx;
	}
	public double getDy() {
		return dy;
	}
	public void setDy(double dy) {
		this.dy = dy;
	}
	//	 instance methods
    public void draw(Graphics myBuffer) 
    {
       myBuffer.setColor(myColor);
       myBuffer.fillOval((int)(getX() - getRadius()), (int)(getY()-getRadius()), (int)getDiameter(), (int)getDiameter());
    }
    
    public void move(double rightEdge, double bottomEdge)
	   {
		       setX(getX()+ dx); 
		       setY(getY()+dy);
		    
		       if(getX() >= rightEdge - getRadius())  //hit right edge
		       {
		          p1score++;
		          setX(400);
		          setY(175);
		          dx = 0;
		          dy = 0;
		       }
		       else if(getX() <= 0 + getRadius())  //hit right edge
		       {
		         p2score++;
		         setX(400);
		          setY(175);
		          
		          
		          dx = 0;
		          dy = 0;
		       }
		       
		       
		       
		       if(getY() >= bottomEdge - getRadius())  //hit right edge
		       {
		         setY(bottomEdge - getRadius());
		        
		         dy = dy * -1; 
		         
		       }
		       else if(getY() <= 0+getRadius()){
		    	   setY(0+getRadius());
		    	   dy = dy*-1;
		    	 
		       }
		       
		
		       
	  }
}
