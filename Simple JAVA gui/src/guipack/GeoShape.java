package guipack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ShapeFactory{
	static GeoShape createShape(String kind, int x, int y, int size) {
		if(kind.equalsIgnoreCase("rect")){
			return new Rect(x, y, size);
		}
		else if (kind.equalsIgnoreCase("circle")){
			return new Circle(x, y, size);
		}
		else if(kind.equalsIgnoreCase("triangle")) {
			return new Triangle(x,y,size);
		}
		else
			return null;
		}	
}

abstract class GeoShape{
	int x,y,size;
	
	public GeoShape(int x, int y, int size) {
		this.x = x; this.y = y; this.size = size;
	}
	
	public abstract void draw(Graphics g);
}

class Rect extends GeoShape{

	public Rect(int x, int y, int size) {
		super(x, y, size);
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics g) {
		g.drawRect(x, y, size, size);
	}
}

class Circle extends GeoShape{

	public Circle(int x, int y, int size) {
		super(x, y, size);
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics g) {
		g.drawOval(x, y, size, size);
	}
}

class Triangle extends GeoShape{

	public Triangle(int x, int y, int size) {
		super(x, y, size);
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics g) {
		g.drawPolygon(new int[] {( x - (size/2)), x, (x + (size/2))}, new int[] {(y + size), y, (y + size)}, 3);
	} 
}

