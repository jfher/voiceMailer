package mailSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class UserInterface {

	private JFrame frmVoiceMailer;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.frmVoiceMailer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVoiceMailer = new JFrame();
		frmVoiceMailer.setTitle("Voice Mailer");
		frmVoiceMailer.setResizable(false);
		frmVoiceMailer.setBounds(100, 100, 399, 371);
		frmVoiceMailer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVoiceMailer.getContentPane().setLayout(new BoxLayout(frmVoiceMailer.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		frmVoiceMailer.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		TextArea textArea = new TextArea();
		textArea.setMaximumSize(new Dimension(720, 32767));
		textArea.setEditable(false);
		panel_1.add(textArea);
		panel_1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textArea}));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.SOUTH);
		
		textField = new JTextField();
		textField.setAlignmentX(Component.RIGHT_ALIGNMENT);
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		panel_3.add(textField);
		textField.setColumns(30);
		
		JButton btnNewButton_4 = new JButton("<--'");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_3.add(btnNewButton_4);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.EAST);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(null);
		
		JButton btnNewButton = new JButton("7");
		btnNewButton.setBounds(41, 11, 89, 23);
		panel_5.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("8");
		btnNewButton_1.setBounds(140, 11, 89, 23);
		panel_5.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("9");
		btnNewButton_2.setBounds(239, 11, 89, 23);
		panel_5.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("<--");
		btnNewButton_3.setBounds(239, 94, 89, 23);
		panel_5.add(btnNewButton_3);
		
		JButton button = new JButton("#");
		button.setBounds(41, 94, 89, 23);
		panel_5.add(button);
		
		JButton button_1 = new JButton("6");
		button_1.setBounds(239, 38, 89, 23);
		panel_5.add(button_1);
		
		JButton button_2 = new JButton("5");
		button_2.setBounds(140, 38, 89, 23);
		panel_5.add(button_2);
		
		JButton button_3 = new JButton("4");
		button_3.setBounds(41, 38, 89, 23);
		panel_5.add(button_3);
		
		JButton button_4 = new JButton("3");
		button_4.setBounds(239, 66, 89, 23);
		panel_5.add(button_4);
		
		JButton button_5 = new JButton("2");
		button_5.setBounds(140, 66, 89, 23);
		panel_5.add(button_5);
		
		JButton button_6 = new JButton("1");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_6.setBounds(41, 66, 89, 23);
		panel_5.add(button_6);
		
		JButton button_9 = new JButton("0");
		button_9.setBounds(140, 94, 89, 23);
		panel_5.add(button_9);
	}

}
