    // Phil Ero 15JUL08
    
    public class BumperCollision
   {
      private static double nearestX;	// used to approximate what point of the Racket  
      private static double nearestY;  // a Puck collided with
   
       public static void collide(Racket Racket, Puck Puck)
      {
         // see if the Puck hit the Racket!
         if(Racket.inBumper(Puck))
         {	   	
            // back the Puck up until it is just outside the Racket
            while(Racket.inBumper(Puck))
            {
               Puck.setX(Puck.getX() - Puck.getDx()/10.0);
               Puck.setY(Puck.getY() - Puck.getDy()/10.0);
            }
            
            // find the point on the edge of the Racket closest to the Puck
            findImpactPoint(Racket, Puck);
         	
            double ux=nearestX-Puck.getX();
            double uy=nearestY-Puck.getY();
            double ur=Math.sqrt(ux*ux+uy*uy);
            ux/=ur;
            uy/=ur;
            int dx=(int)Puck.getDx();
            int dy=(int)Puck.getDy();
            double dot_1= ux*dx+uy*dy;
            double dot_2=-uy*dx+ux*dy;
            dot_1*=-1; // this is the actual "bounce"
            double[] d = new double[2];
            d[0]=dot_1*ux-dot_2*uy;      //vector math
            d[1]=dot_1*uy+dot_2*ux;      //vector math
            dx=(int)Math.round(d[0]);
            dy=(int)Math.round(d[1]);
            Puck.setDx(dx);
            Puck.setDy(dy);
         }
      }
      
       private static void findImpactPoint(Racket Racket, Puck Puck)
      {
          // first assume the nw corner is closest
         nearestX = Racket.getX();  
         nearestY = Racket.getY();
         
         // now work around the edge of the Racket looking for a closer point
         for (int x = Racket.getX(); x <= Racket.getX() + Racket.getXWidth(); x++)  // top & bottom edges
         {
            updateIfCloser(x, Racket.getY(), Puck);
            updateIfCloser(x, Racket.getY() + Racket.getYWidth(), Puck);
         }
         for (int y = Racket.getY(); y <= Racket.getY() + Racket.getYWidth(); y++)  // right & left edges
         {
            updateIfCloser(Racket.getX(), y, Puck);
            updateIfCloser(Racket.getX() + Racket.getXWidth(), y, Puck);
         }
      }
         
      // makes (x,y) the nearest point if it is closer to the Puck
       private static void updateIfCloser(int x, int y, Puck b)
      {
         if(distance(x, y, b.getX(), b.getY()) < distance(nearestX, nearestY, b.getX(), b.getY()))
         {
            nearestX = x;
            nearestY = y;
         }
      }
          
      // returns distance between (x1, y1) and (x2, y2)
       private static double distance(double x1, double y1, double x2, double y2)
      {
         return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
      }	
   }