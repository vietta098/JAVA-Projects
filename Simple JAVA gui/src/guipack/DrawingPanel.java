package guipack;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class DrawingPanel extends JPanel {
	
	private GraphicsPanel pnlGraphic = new GraphicsPanel();
	private JScrollPane scroll = new JScrollPane(pnlGraphic);
	private JPanel shapePanel, optPanel;
	private JButton btnTria, btnCir, btnRect, clrBtn, okBtn;
	private JTextField txtField;
	private JLabel label;
	
	public DrawingPanel() {
		super();
		setup();
	}

	
	private void setup() {
		scroll.setPreferredSize(new Dimension(450, 270));
		
		shapePanel = new JPanel();
		optPanel = new JPanel();
		
		
		btnTria = new JButton("Triangle");
		btnCir = new JButton("Circle");
		btnRect = new JButton("Rectangle");
		
		clrBtn = new JButton("WipeOut");
		okBtn = new JButton("OK");
		
		txtField = new JTextField(2);
		label = new JLabel("Insert Size");
		
		shapePanel.add(btnCir);
		shapePanel.add(btnTria);
		shapePanel.add(btnRect);	
		optPanel.add(clrBtn);
		optPanel.add(label);
		optPanel.add(txtField);
		optPanel.add(okBtn);
		
		this.setLayout(new BorderLayout());
		this.add(scroll, BorderLayout.CENTER);
		this.add(shapePanel, BorderLayout.NORTH);
		this.add(optPanel, BorderLayout.SOUTH);
		
		btnTria.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlGraphic.setShape("triangle");
			}});
		
		btnCir.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlGraphic.setShape("circle");
			}});
		
		btnRect.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlGraphic.setShape("rect");
			}});
		
		clrBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlGraphic.setBackground(null);
				pnlGraphic.clear();
			}
		});
		
		okBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String input = txtField.getText();
				int convert = Integer.parseInt(input);
				pnlGraphic.setSize(convert);
			}
				
		});
		
	}
}
