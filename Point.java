package Components;

import java.util.*;
import java.awt.*;  

public class Point {		//makes it available throughout classes
	public float x;
	public float y;
	public int label;
	int min = 0;
	int max = 800;
	Random r = new Random();

	public Point(){
		x = min + r.nextFloat() * (max - min);
		y = min + r.nextFloat() * (max - min);

		if(x>y){
			label = 1;		//points above trend line of x>y
		}
		else{
			label = -1;		//points below trend line
		}
	}

	public float getX(){
		return x;
	}

	public float getY(){
		return y;
	}

	// public void show(){
	// 	stroke(0);
	// 	if(label ==1 ){
	// 		fill(255);
	// 	}
	// 	else{
	// 		fill(0);
	// 	}
	// 	ellipse(x,y,8,8);
	// }
}