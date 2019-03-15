import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;



public class GUIAppView implements AppView {
	
	
	GUIAppView(){
	}
	
	public void run() {
		JFrame f = new AppFrame();
	}
}

class AppFrame extends JFrame {
	JPanel panel;
	
	public AppFrame() {
		
	}
	
	public void frameInit() {
		super.frameInit();
		this.setLayout(new BorderLayout());
		
		panel = new AppPanel();
		this.add(panel);
		
		this.setSize(800, 800);
	
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}

class AppPanel extends JPanel{

	private JScrollPane scroll,scroll2;
	JPanel pnlGetInput, pnlDisplay, pnlDisplay2;
	private JButton btnGetFile, btnSort;
	private JTextArea txtResult, txtDisplay, txtResult2;
	private JTextField txtFileName, txtWord;
	
	
	private DataHandler data;
	
	//WordHandler word;
	
	public AppPanel() {
		super();
		setup();
	}
	
	private void setup() {

	
		pnlGetInput = new JPanel();
		pnlDisplay = new JPanel();
		pnlDisplay2 = new JPanel();
	
		
		btnGetFile = new JButton("Get File & Analyze");
		btnSort = new JButton("Sort words based on frequency");
		
		txtResult = new JTextArea(18,20);
		txtDisplay = new JTextArea( 50,50 );
		txtResult2 = new JTextArea(1,20);
		txtResult2.setText("Selected Word Frequency Display Here");
		
		
		txtFileName = new JTextField(5);
		txtWord = new JTextField(5);
		
		scroll = new JScrollPane(txtDisplay);
		scroll2= new JScrollPane(txtResult);
		
		pnlGetInput.add(txtFileName);
		pnlGetInput.add(btnGetFile);
		pnlGetInput.setBorder(BorderFactory.createTitledBorder("This is for input"));
		
		pnlDisplay.setLayout(new BorderLayout());
		pnlDisplay.add(scroll2, BorderLayout.WEST);
		pnlDisplay.add(scroll, BorderLayout.EAST);
		pnlDisplay.setBorder(BorderFactory.createTitledBorder("This is for display"));
		
		
		pnlDisplay2.add(txtWord);
		pnlDisplay2.add(txtResult2);
		pnlDisplay2.add(btnSort);
		pnlDisplay2.setBorder(BorderFactory.createTitledBorder("Additional"));
		
		
		this.setLayout(new BorderLayout());
		this.add(pnlGetInput, BorderLayout.NORTH);
		this.add(pnlDisplay, BorderLayout.CENTER);
		this.add(pnlDisplay2, BorderLayout.SOUTH);
		
		addIn();
		addIn2();
	}
	
	public void addIn() {
		btnGetFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				data = new DataHandler();
				data.getData(txtFileName.getText());
				txtDisplay.setText(data.getTextIn());
				txtResult.setText(data.getDocumentAsString());
			}		
		});
	}
	
	public void addIn2() {
		btnSort.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				data = new DataHandler();
				data.getData(txtFileName.getText());
				
				String in = Integer.toString(data.searchData(txtWord.getText()));
				txtResult2.setText(in);
			
				
			}
			
		});
	}
		
}

