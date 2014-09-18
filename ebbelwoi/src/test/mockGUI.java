package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.border.BevelBorder;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.SystemColor;

public class mockGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mockGUI frame = new mockGUI();
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
	public mockGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1071, 532);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnDatei = new JMenu("Datei");
		menuBar.add(mnDatei);
		
		JMenuItem mntmBeenden = new JMenuItem("Beenden");
		mnDatei.add(mntmBeenden);
		
		JMenu mnHilfe = new JMenu("Hilfe");
		menuBar.add(mnHilfe);
		
		JMenuItem mntmber = new JMenuItem("\u00DCber");
		mnHilfe.add(mntmber);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBorder(null);
		contentPane.add(tabbedPane);
		
		JPanel panStart = new JPanel();
		tabbedPane.addTab("Start", null, panStart, null);
		panStart.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitleStart = new JLabel("Herzlich willkommen beim Unternehmensplanspiel \"Apfelweinkelterei\"");
		lblTitleStart.setEnabled(false);
		lblTitleStart.setBackground(SystemColor.text);
		lblTitleStart.setVerticalAlignment(SwingConstants.TOP);
		lblTitleStart.setLabelFor(panStart);
		lblTitleStart.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitleStart.setFont(new Font("Tahoma", Font.BOLD, 18));
		panStart.add(lblTitleStart, BorderLayout.NORTH);
		
		JEditorPane dtrpnHalloUndWillkommen = new JEditorPane();
		dtrpnHalloUndWillkommen.setEnabled(false);
		dtrpnHalloUndWillkommen.setBackground(SystemColor.text);
		dtrpnHalloUndWillkommen.setText("Hallo und willkommen zu unserem Unternehmensplanspiel \"Apfelweinkelterei\".\r\n\r\nHier k\u00F6nnte eine gerkl\u00F6rung zu der ganzen kiste stehen daraufhin ist unten ein button der mit \"Jetzt spielen\" beschriftet sein k\u00F6nnte, somit in den unternehmenstab springt und die anderen tabs enabled");
		dtrpnHalloUndWillkommen.setEditable(false);
		panStart.add(dtrpnHalloUndWillkommen, BorderLayout.CENTER);
		
		JPanel panUnternehmen = new JPanel();
		tabbedPane.addTab("Unternehmen", null, panUnternehmen, null);
		tabbedPane.setEnabledAt(1, false);
		panUnternehmen.setLayout(new BoxLayout(panUnternehmen, BoxLayout.X_AXIS));
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		panUnternehmen.add(tabbedPane_1);
		
		JPanel panLieferanten = new JPanel();
		tabbedPane.addTab("Lieferanten", null, panLieferanten, null);
		tabbedPane.setEnabledAt(2, false);
		panLieferanten.setLayout(new BoxLayout(panLieferanten, BoxLayout.X_AXIS));
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		panLieferanten.add(tabbedPane_2);
		
		JPanel panKunden = new JPanel();
		tabbedPane.addTab("Kunden", null, panKunden, null);
		tabbedPane.setEnabledAt(3, false);
		
		JPanel panMitarbeiter = new JPanel();
		tabbedPane.addTab("Mitarbeiter", null, panMitarbeiter, null);
		tabbedPane.setEnabledAt(4, false);
	}

}
