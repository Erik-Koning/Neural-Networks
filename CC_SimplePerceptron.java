//Erik Koning
//Jan 29th, 2018
//CMPE 452


/*
This is a supervised learning ANN model

Multilayer feedforward Perceptron implementation for identifing a flower type based on dimensions

Process:
1. provide perceptron with inputs which there is a known anser
2. Sum of inputs and weight to Perceptron =x0*w0+x1*w1...+xn*wn
3. Activation function(to determine value as result of sum)    a(sum) = {1,0} for example
	2.1 could use a sign function: a(sum)  =  	{sum>=0, 1
												 sum<0 , -1}
4. based on the perceptrons result, we know the answer so we can calculate an error, error = desired - given
5. new weight according to error, W0 = W0 + ChangeInWeight(this "steers" weight to correct weight)
		changeInWeight = Error * input
		New Weight = Weight + Error * input * learning rate(like 0.1.... typically. So it doesnt jump around alot)
6. back to step1

*/
import java.awt.*;       // Using AWT's Graphics and Color			abstract window toolkit
import java.awt.event.*; // Using AWT event classes and listener interfaces
import javax.swing.*;    // Using Swing's components and containers
import javax.swing.*;
import java.awt.geom.Ellipse2D;

import Components.Perceptron;
import Components.Point;
import Components.MyJPanel;

public class CC_SimplePerceptron extends JComponent { 
	public static final int maxD = 800;
	public static Perceptron p = new Perceptron();
	public static Point[] points = new Point[100];			//100 element array of type Point to hold data


	public static void main(String[] args){
		JFrame frame = new JFrame("Draw Ellipse Demo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(new CC_SimplePerceptron());
        frame.pack();
        frame.setSize(new Dimension(maxD, maxD));
        frame.setVisible(true);


		System.out.println("Point initialiations");
		//initializing 100 random points
		for(int i = 0; i < points.length; i++){
			points[i] = new Point();				//random point
			System.out.println("Point " + i + " =" + points[i].getX() + ", " + points[i].getY());
		}

		float[] inputs = {-1f,0.5f};				//0.5f to indicate its float not double
		int guess = p.guess(inputs);

		System.out.println(guess);
		return;
	}
 
   // Constructor to set up the GUI components and event handlers
   public CC_SimplePerceptron() {
   	System.out.println("Def constructor");
   }

   @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setPaint(Color.RED);
        g2.setStroke(new BasicStroke(5.0f));
        for(int i = 0; i < points.length; i++){
        	g2.fill(new Ellipse2D.Double(points[i].getX(), points[i].getY(), 8, 8));
        }
    }
}


   /**
    * Define inner class DrawCanvas, which is a JPanel used for custom drawing.
    */
   // private class DrawCanvas extends JPanel {
   //    // Override paintComponent to perform your own painting
   //    @Override
   //    public void paintComponent(Graphics g) {
   //       super.paintComponent(g);     // paint parent's background
   //       setBackground(Color.WHITE);  // set background color for this JPanel
 
   //       // Your custom painting codes. For example,
   //       // Drawing primitive shapes

   //       for(Point p: point){
   //       	g.setColor(Color.BLACK);    // set the drawing color
   //       	g.drawOval(p.x, p.y, 10, 10);

   //       	g.setColor(Color.BLUE);    // set the drawing color
   //       	g.fillOval(p.x, p.y, 20, 20);
   //       }

   //       // g.setColor(Color.BLACK);    // set the drawing color
   //       // g.drawLine(30, 40, 100, 200);
   //       // g.drawOval(150, 180, 10, 10);
   //       // g.drawRect(200, 210, 20, 30);
   //       // g.setColor(Color.RED);       // change the drawing color
   //       // g.fillOval(300, 310, 30, 50);
   //       // g.fillRect(400, 350, 60, 50);
   //       // // Printing texts
   //       // g.setColor(Color.BLACK);
   //       // g.setFont(new Font("Monospaced", Font.PLAIN, 12));
   //       // g.drawString("Testing custom drawing ...", 10, 20);
   //    }
   // }
