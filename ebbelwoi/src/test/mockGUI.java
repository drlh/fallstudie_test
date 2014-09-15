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

public class mockGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirmenname;

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
		setBounds(100, 100, 829, 507);
		
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
		lblTitleStart.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleStart.setFont(new Font("Tahoma", Font.BOLD, 18));
		panStart.add(lblTitleStart, BorderLayout.NORTH);
		
		JPanel panStartContent = new JPanel();
		panStart.add(panStartContent, BorderLayout.CENTER);
		
		JLabel lblBeschFirmenname = new JLabel("Firmenname:");
		lblBeschFirmenname.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtFirmenname = new JTextField();
		txtFirmenname.setHorizontalAlignment(SwingConstants.CENTER);
		txtFirmenname.setColumns(10);
		
		JLabel lblBeschStandort = new JLabel("Standort:");
		panStartContent.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panStartContent.add(lblBeschFirmenname);
		panStartContent.add(txtFirmenname);
		panStartContent.add(lblBeschStandort);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Frankfurt", "Limburg", "Wetter"}));
		panStartContent.add(comboBox);
		
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
