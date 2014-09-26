package de.spiel.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class StartView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartView frame = new StartView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartView() {
		setType(Type.POPUP);
		setResizable(false);
		setTitle("Willkommen beim Ebbelwoi Unternehmensplanspiel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblEbbelwoiUnternehmensplanspiel = new JLabel(
				"Spieleranzahl festlegen");
		lblEbbelwoiUnternehmensplanspiel.setFont(new Font("Arial", Font.BOLD,
				18));
		lblEbbelwoiUnternehmensplanspiel
				.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblEbbelwoiUnternehmensplanspiel, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblSpieleranzahl = new JLabel("Spieleranzahl:");
		lblSpieleranzahl.setBounds(10, 13, 78, 15);
		lblSpieleranzahl.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(lblSpieleranzahl);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2",
				"3", "4", "5" }));
		comboBox.setSelectedIndex(2);
		comboBox.setBounds(98, 11, 50, 20);
		panel.add(comboBox);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 39, 242, 100);
		panel.add(panel_1);

		JLabel lblSpieler = new JLabel("Spieler 1:");
		lblSpieler.setBounds(10, 10, 52, 15);
		lblSpieler.setFont(new Font("Arial", Font.PLAIN, 12));

		textField = new JTextField();
		textField.setBounds(72, 8, 159, 20);
		textField.setColumns(10);

		JLabel lblSpieler_2 = new JLabel("Spieler 3:");
		lblSpieler_2.setBounds(10, 72, 52, 15);
		lblSpieler_2.setFont(new Font("Arial", Font.PLAIN, 12));

		textField_1 = new JTextField();
		textField_1.setBounds(72, 39, 159, 20);
		textField_1.setColumns(10);

		JLabel lblSpieler_1 = new JLabel("Spieler 2:");
		lblSpieler_1.setBounds(10, 41, 52, 15);
		lblSpieler_1.setFont(new Font("Arial", Font.PLAIN, 12));

		textField_2 = new JTextField();
		textField_2.setBounds(72, 70, 159, 20);
		textField_2.setColumns(10);
		panel_1.setLayout(null);
		panel_1.add(lblSpieler);
		panel_1.add(textField);
		panel_1.add(lblSpieler_2);
		panel_1.add(textField_1);
		panel_1.add(lblSpieler_1);
		panel_1.add(textField_2);

		JButton btnSpielStarten = new JButton("Spiel starten");
		btnSpielStarten.setBounds(137, 144, 115, 23);
		panel.add(btnSpielStarten);

		JButton btnAbbrechen = new JButton("Abbrechen");

		btnAbbrechen.setBounds(10, 144, 115, 23);
		panel.add(btnAbbrechen);
	}
}
