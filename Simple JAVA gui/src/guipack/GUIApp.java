package guipack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GUIApp {
	
	public static void main(String[] args) {
		JFrame frame = new AppFrame("HelloJSwingWorld");
		
	}
}


class AppFrame extends JFrame{
	
	JPanel pnlGraphics;
	
	public AppFrame(String title) {
		super(title);
	}
	
	public void frameInit() {
		super.frameInit();
		this.setLayout(new BorderLayout());
		pnlGraphics = new DrawingPanel();
		pnlGraphics.setBorder(BorderFactory.createTitledBorder("Hello"));
		this.add(pnlGraphics);
		
		/*
		 * this method get the size of the screen and
		 * used it on the frame.
		 * */
		Toolkit tk = Toolkit.getDefaultToolkit();
			int xsize  = (int) tk.getScreenSize().getWidth();
			int ysize  = (int) tk.getScreenSize().getHeight();
			
		this.setSize(xsize, ysize);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class GraphicsPanel extends JPanel{
	private int size, numItems = 0;
	private String shape;
	private ArrayList<GeoShape> shapes = new ArrayList<GeoShape>();
	
	public GraphicsPanel(){
		super();
		this.addMouseListener(new MsListener());
		
		/*
		 * set based case
		 * */
		shape = "triangle";								
		size = 50;									
	}
	
	public void clear(){
		shapes.clear();
	}
	
	public void setShape(String shape) {
		this.shape = shape;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
		
	public int getNumItems(){
		return numItems;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		for(GeoShape g1 : shapes) {
			g1.draw(g);
		}
		
	}
	
	class MsListener extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			GeoShape s = ShapeFactory.createShape(shape, e.getX(), e.getY(), size);
			Graphics g = getGraphics();
			s.draw(g);
			
			/*
			 * add to the array so it wont disappear;
			 * */
			shapes.add(s);
		
		}
	}
}



