import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JEditorPane;

public class gui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		TodoList myToDoList = new TodoList();
		Scanner sc = new Scanner(System.in);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();

		panel.setBounds(10, 11, 264, 57);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Add (a), Retrieve (r) a task, View (v) or quit (q)?");
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("a");

		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("r");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("v");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("q");
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(10, 79, 264, 71);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		// buttion action litsener
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Enter task's name --> ");
				String name = sc.nextLine();
				System.out.println("Enter time --> ");
				String time = sc.nextLine();
				myToDoList.addTask(name);
				myToDoList.addTime(time);
			}
		});
		
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Enter time --> ");
				String input = sc.nextLine();				
				System.out.println(myToDoList.returnTask(input));
			}
				
		});
	
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(myToDoList.returnAll());
			}
				
		});
		

		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
			}
				
		});
	}
}
