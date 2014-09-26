package de.spiel.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class FinalView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalView frame = new FinalView();
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
	public FinalView() {
		setTitle("Ebbelwoi Unternehmensplanspiel - Ergebnis");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Gesamt\u00FCbersicht", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tabbedPane_1);

		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("Umsatz", null, panel_4, null);

		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("Gewinn / Verlust", null, panel_5, null);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Spieler 1", null, panel_1, null);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Spieler 2", null, panel_2, null);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Spieler 3", null, panel_3, null);
	}

}
