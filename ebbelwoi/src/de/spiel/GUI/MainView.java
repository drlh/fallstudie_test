package de.spiel.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField textField;
	private JTable table_3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table_4;
	private JTable table_5;
	private JTextField textField_3;
	private JTable table_6;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		setTitle("Ebbelwoi - Unternehmensplanspiel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 609);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnDatei = new JMenu("Datei");
		menuBar.add(mnDatei);

		JMenuItem mntmBeenden = new JMenuItem("Beenden");
		mnDatei.add(mntmBeenden);

		JMenu mnHilfe = new JMenu("Hilfe");
		menuBar.add(mnHilfe);

		JMenuItem mntmAnleitung = new JMenuItem("Anleitung");
		mnHilfe.add(mntmAnleitung);

		JMenuItem mntmber = new JMenuItem("\u00DCber");
		mnHilfe.add(mntmber);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JToolBar toolBar = new JToolBar();
		toolBar.setRollover(true);
		contentPane.add(toolBar, BorderLayout.NORTH);

		JButton btnRundeBeenden = new JButton("Runde Beenden");
		toolBar.add(btnRundeBeenden);

		JToggleButton tglbtnSpieler = new JToggleButton("Spieler 1");
		tglbtnSpieler.setIcon(null);
		tglbtnSpieler.setBackground(new Color(51, 255, 0));
		tglbtnSpieler.setSelected(true);
		toolBar.add(tglbtnSpieler);

		JToggleButton tglbtnSpieler_1 = new JToggleButton("Spieler 2");
		toolBar.add(tglbtnSpieler_1);

		JToggleButton tglbtnSpieler_2 = new JToggleButton("Spieler 3");
		toolBar.add(tglbtnSpieler_2);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		tabbedPane.addTab("\u00DCbersicht", null, panel, null);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Mitarbeiter", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		panel_2.add(tabbedPane_1);

		JPanel panel_8 = new JPanel();
		tabbedPane_1.addTab("Einkauf", null, panel_8, null);
		panel_8.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_8.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(new Object[][] {
				{ "Azubi", "1. Lehrjahr" }, { "Azubi", "2. Lehrjahr" },
				{ "Geselle", null }, { "Meister", null }, }, new String[] {
				"Mitarbeitertyp", "Details" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(98);
		scrollPane.setViewportView(table);

		JPanel panel_13 = new JPanel();
		panel_8.add(panel_13, BorderLayout.EAST);
		GridBagLayout gbl_panel_13 = new GridBagLayout();
		gbl_panel_13.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_13.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_13.columnWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_13.rowWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_13.setLayout(gbl_panel_13);

		JButton btnMitarbeiterHinzufge = new JButton(
				"Mitarbeiter hinzuf\u00FCgen");
		GridBagConstraints gbc_btnMitarbeiterHinzufge = new GridBagConstraints();
		gbc_btnMitarbeiterHinzufge.insets = new Insets(0, 0, 5, 5);
		gbc_btnMitarbeiterHinzufge.gridx = 1;
		gbc_btnMitarbeiterHinzufge.gridy = 0;
		panel_13.add(btnMitarbeiterHinzufge, gbc_btnMitarbeiterHinzufge);

		JButton btnMitarbeiterEntfernen = new JButton("Mitarbeiter entfernen");
		GridBagConstraints gbc_btnMitarbeiterEntfernen = new GridBagConstraints();
		gbc_btnMitarbeiterEntfernen.insets = new Insets(0, 0, 5, 5);
		gbc_btnMitarbeiterEntfernen.gridx = 1;
		gbc_btnMitarbeiterEntfernen.gridy = 1;
		panel_13.add(btnMitarbeiterEntfernen, gbc_btnMitarbeiterEntfernen);

		JPanel panel_9 = new JPanel();
		tabbedPane_1.addTab("Verkauf", null, panel_9, null);
		panel_9.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_9.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] {
				{ "Geselle", null }, { "Meister", null }, { "Meister", null },
				{ "Geselle", "" }, { "Azubi", "3. Lehrjahr" },
				{ "Azubi", "2. Lehrjahr" }, }, new String[] { "Mitarbeitertyp",
				"Details" }));
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(table_1);

		JPanel panel_14 = new JPanel();
		panel_9.add(panel_14, BorderLayout.EAST);
		GridBagLayout gbl_panel_14 = new GridBagLayout();
		gbl_panel_14.columnWidths = new int[] { 141, 0 };
		gbl_panel_14.rowHeights = new int[] { 23, 0, 0 };
		gbl_panel_14.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_14.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_14.setLayout(gbl_panel_14);

		JButton btnMitarbeiterHinzufgen = new JButton(
				"Mitarbeiter hinzuf\u00FCgen");
		GridBagConstraints gbc_btnMitarbeiterHinzufgen = new GridBagConstraints();
		gbc_btnMitarbeiterHinzufgen.insets = new Insets(0, 0, 5, 0);
		gbc_btnMitarbeiterHinzufgen.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnMitarbeiterHinzufgen.gridx = 0;
		gbc_btnMitarbeiterHinzufgen.gridy = 0;
		panel_14.add(btnMitarbeiterHinzufgen, gbc_btnMitarbeiterHinzufgen);

		JButton btnMitarbeiterEntfernen_1 = new JButton("Mitarbeiter entfernen");
		GridBagConstraints gbc_btnMitarbeiterEntfernen_1 = new GridBagConstraints();
		gbc_btnMitarbeiterEntfernen_1.gridx = 0;
		gbc_btnMitarbeiterEntfernen_1.gridy = 1;
		panel_14.add(btnMitarbeiterEntfernen_1, gbc_btnMitarbeiterEntfernen_1);

		JPanel panel_10 = new JPanel();
		tabbedPane_1.addTab("Lager", null, panel_10, null);
		panel_10.setLayout(new MigLayout("", "[]", "[]"));

		JPanel panel_11 = new JPanel();
		tabbedPane_1.addTab("Marketing", null, panel_11, null);
		panel_11.setLayout(new MigLayout("", "[]", "[]"));

		JPanel panel_12 = new JPanel();
		tabbedPane_1.addTab("Produktion", null, panel_12, null);
		panel_12.setLayout(new MigLayout("", "[]", "[]"));

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Einkauf", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.gridheight = 11;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 0;
		panel_1.add(scrollPane_2, gbc_scrollPane_2);

		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
				new Object[][] { { "Pink Lady \u00C4pfel", "1.00", "kg" },
						{ "Etiketten", "0.30", "stk" },
						{ "Flaschen", "0.45", "stk" }, }, new String[] {
						"Produktbezeichnung", "Preis in \u20AC", "pro ME" }));
		table_2.getColumnModel().getColumn(0).setPreferredWidth(118);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(45);
		scrollPane_2.setViewportView(table_2);

		JPanel panel_15 = new JPanel();
		GridBagConstraints gbc_panel_15 = new GridBagConstraints();
		gbc_panel_15.gridheight = 4;
		gbc_panel_15.fill = GridBagConstraints.BOTH;
		gbc_panel_15.gridx = 0;
		gbc_panel_15.gridy = 11;
		panel_1.add(panel_15, gbc_panel_15);
		GridBagLayout gbl_panel_15 = new GridBagLayout();
		gbl_panel_15.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_15.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_15.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_15.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_15.setLayout(gbl_panel_15);

		JLabel lblBestellung = new JLabel("Bestellung");
		lblBestellung.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblBestellung = new GridBagConstraints();
		gbc_lblBestellung.insets = new Insets(0, 0, 5, 5);
		gbc_lblBestellung.gridx = 0;
		gbc_lblBestellung.gridy = 0;
		panel_15.add(lblBestellung, gbc_lblBestellung);

		JLabel lblProdukt = new JLabel("Produkt:");
		GridBagConstraints gbc_lblProdukt = new GridBagConstraints();
		gbc_lblProdukt.anchor = GridBagConstraints.EAST;
		gbc_lblProdukt.insets = new Insets(0, 0, 5, 5);
		gbc_lblProdukt.gridx = 0;
		gbc_lblProdukt.gridy = 1;
		panel_15.add(lblProdukt, gbc_lblProdukt);

		JLabel lblPinkLadypfel = new JLabel("Pink Lady \u00C4pfel");
		GridBagConstraints gbc_lblPinkLadypfel = new GridBagConstraints();
		gbc_lblPinkLadypfel.anchor = GridBagConstraints.WEST;
		gbc_lblPinkLadypfel.insets = new Insets(0, 0, 5, 0);
		gbc_lblPinkLadypfel.gridx = 1;
		gbc_lblPinkLadypfel.gridy = 1;
		panel_15.add(lblPinkLadypfel, gbc_lblPinkLadypfel);

		JLabel lblMenge = new JLabel("Menge:");
		GridBagConstraints gbc_lblMenge = new GridBagConstraints();
		gbc_lblMenge.anchor = GridBagConstraints.EAST;
		gbc_lblMenge.insets = new Insets(0, 0, 5, 5);
		gbc_lblMenge.gridx = 0;
		gbc_lblMenge.gridy = 2;
		panel_15.add(lblMenge, gbc_lblMenge);

		textField = new JTextField();
		textField.setText("150");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		panel_15.add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblPreis = new JLabel("Preis in \u20AC:");
		GridBagConstraints gbc_lblPreis = new GridBagConstraints();
		gbc_lblPreis.anchor = GridBagConstraints.EAST;
		gbc_lblPreis.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreis.gridx = 0;
		gbc_lblPreis.gridy = 3;
		panel_15.add(lblPreis, gbc_lblPreis);

		JLabel label = new JLabel("150.00");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.gridx = 1;
		gbc_label.gridy = 3;
		panel_15.add(label, gbc_label);

		JButton btnBeschaffungVornehmen = new JButton("Beschaffung vornehmen");
		GridBagConstraints gbc_btnBeschaffungVornehmen = new GridBagConstraints();
		gbc_btnBeschaffungVornehmen.anchor = GridBagConstraints.WEST;
		gbc_btnBeschaffungVornehmen.gridx = 1;
		gbc_btnBeschaffungVornehmen.gridy = 4;
		panel_15.add(btnBeschaffungVornehmen, gbc_btnBeschaffungVornehmen);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Verkauf", null, panel_3, null);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JScrollPane scrollPane_3 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.gridheight = 13;
		gbc_scrollPane_3.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridx = 0;
		gbc_scrollPane_3.gridy = 0;
		panel_3.add(scrollPane_3, gbc_scrollPane_3);

		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
				new Object[][] {
						{ "Pink Lady \u00C4pfel", "150", "kg", "Rohstoff" },
						{ "Ebbelwoi ", "500", "Liter", "FE" },
						{ "Ebbelwoi Sauergespritzt", "250", "Flaschen", "FE" }, },
				new String[] { "Produktbezeichnung", "Menge", "ME", "Kategorie" }));
		table_3.getColumnModel().getColumn(0).setPreferredWidth(124);
		table_3.getColumnModel().getColumn(1).setPreferredWidth(62);
		table_3.getColumnModel().getColumn(2).setPreferredWidth(65);
		table_3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_3.setViewportView(table_3);

		JPanel panel_16 = new JPanel();
		GridBagConstraints gbc_panel_16 = new GridBagConstraints();
		gbc_panel_16.fill = GridBagConstraints.BOTH;
		gbc_panel_16.gridx = 0;
		gbc_panel_16.gridy = 13;
		panel_3.add(panel_16, gbc_panel_16);
		GridBagLayout gbl_panel_16 = new GridBagLayout();
		gbl_panel_16.columnWidths = new int[] { 98, 86, 39, 21, 35, 56, 186, 0 };
		gbl_panel_16.rowHeights = new int[] { 60, 17, 20, 20, 20, 35, 14, 0 };
		gbl_panel_16.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_16.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		panel_16.setLayout(gbl_panel_16);

		JLabel lblAngebot = new JLabel("Angebot");
		lblAngebot.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblAngebot = new GridBagConstraints();
		gbc_lblAngebot.anchor = GridBagConstraints.WEST;
		gbc_lblAngebot.insets = new Insets(0, 0, 5, 5);
		gbc_lblAngebot.gridx = 0;
		gbc_lblAngebot.gridy = 0;
		panel_16.add(lblAngebot, gbc_lblAngebot);

		JLabel lblProdukt_1 = new JLabel("Produkt:");
		GridBagConstraints gbc_lblProdukt_1 = new GridBagConstraints();
		gbc_lblProdukt_1.anchor = GridBagConstraints.WEST;
		gbc_lblProdukt_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblProdukt_1.gridx = 0;
		gbc_lblProdukt_1.gridy = 1;
		panel_16.add(lblProdukt_1, gbc_lblProdukt_1);

		JLabel lblEbbelwoi = new JLabel("Ebbelwoi");
		GridBagConstraints gbc_lblEbbelwoi = new GridBagConstraints();
		gbc_lblEbbelwoi.anchor = GridBagConstraints.WEST;
		gbc_lblEbbelwoi.insets = new Insets(0, 0, 5, 5);
		gbc_lblEbbelwoi.gridx = 1;
		gbc_lblEbbelwoi.gridy = 1;
		panel_16.add(lblEbbelwoi, gbc_lblEbbelwoi);

		JLabel lblKunde = new JLabel("Kunde:");
		GridBagConstraints gbc_lblKunde = new GridBagConstraints();
		gbc_lblKunde.anchor = GridBagConstraints.WEST;
		gbc_lblKunde.insets = new Insets(0, 0, 5, 5);
		gbc_lblKunde.gridx = 3;
		gbc_lblKunde.gridy = 1;
		panel_16.add(lblKunde, gbc_lblKunde);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Aldi",
				"Globus", "Restaurant zum br\u00FCllenden Hirsch" }));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 1;
		panel_16.add(comboBox, gbc_comboBox);

		JLabel lblMenge_1 = new JLabel("Menge:");
		GridBagConstraints gbc_lblMenge_1 = new GridBagConstraints();
		gbc_lblMenge_1.anchor = GridBagConstraints.WEST;
		gbc_lblMenge_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblMenge_1.gridx = 0;
		gbc_lblMenge_1.gridy = 2;
		panel_16.add(lblMenge_1, gbc_lblMenge_1);

		textField_1 = new JTextField();
		textField_1.setText("300");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		panel_16.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JLabel lblKundentyp = new JLabel("Kundentyp:");
		GridBagConstraints gbc_lblKundentyp = new GridBagConstraints();
		gbc_lblKundentyp.anchor = GridBagConstraints.WEST;
		gbc_lblKundentyp.insets = new Insets(0, 0, 5, 5);
		gbc_lblKundentyp.gridx = 3;
		gbc_lblKundentyp.gridy = 2;
		panel_16.add(lblKundentyp, gbc_lblKundentyp);

		JLabel lblDiscounter = new JLabel("Discounter");
		GridBagConstraints gbc_lblDiscounter = new GridBagConstraints();
		gbc_lblDiscounter.anchor = GridBagConstraints.WEST;
		gbc_lblDiscounter.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiscounter.gridx = 4;
		gbc_lblDiscounter.gridy = 2;
		panel_16.add(lblDiscounter, gbc_lblDiscounter);

		JLabel lblPreisIn = new JLabel("Preis in \u20AC pro ME:");
		GridBagConstraints gbc_lblPreisIn = new GridBagConstraints();
		gbc_lblPreisIn.anchor = GridBagConstraints.WEST;
		gbc_lblPreisIn.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreisIn.gridx = 0;
		gbc_lblPreisIn.gridy = 3;
		panel_16.add(lblPreisIn, gbc_lblPreisIn);

		textField_2 = new JTextField();
		textField_2.setText("0.80");
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 3;
		panel_16.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);

		JLabel lblGesamtpreis = new JLabel("Gesamtpreis(\u20AC):\r\n");
		lblGesamtpreis.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblGesamtpreis = new GridBagConstraints();
		gbc_lblGesamtpreis.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblGesamtpreis.insets = new Insets(0, 0, 5, 5);
		gbc_lblGesamtpreis.gridx = 0;
		gbc_lblGesamtpreis.gridy = 5;
		panel_16.add(lblGesamtpreis, gbc_lblGesamtpreis);

		JLabel lblNewLabel = new JLabel("240");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 5;
		panel_16.add(lblNewLabel, gbc_lblNewLabel);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Lager", null, panel_4, null);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		JScrollPane scrollPane_4 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_4 = new GridBagConstraints();
		gbc_scrollPane_4.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_4.gridx = 0;
		gbc_scrollPane_4.gridy = 0;
		panel_4.add(scrollPane_4, gbc_scrollPane_4);

		table_4 = new JTable();
		table_4.setModel(new DefaultTableModel(new Object[][] {
				{ "Pink Lady \u00C4pfel", "50", "Kilogramm", "5" },
				{ "Braunglasflaschen 1 Liter", "350", "St\u00FCck", "5" },
				{ "Etiketten", "300", "St\u00FCck", "4" },
				{ "Ebbelwoi Sauergespritzt", "250", "Flaschen", "6" },
				{ "Ebbelwoi", "500", "Liter", "6" },
				{ "Flaschendeckel", "250", "St\u00FCck", "4" }, },
				new String[] { "Produktbezeichnung", "Menge", "ME",
						"Qulit\u00E4t" }));
		table_4.getColumnModel().getColumn(0).setPreferredWidth(139);
		table_4.getColumnModel().getColumn(1).setPreferredWidth(53);
		table_4.getColumnModel().getColumn(2).setPreferredWidth(55);
		table_4.getColumnModel().getColumn(3).setPreferredWidth(43);
		table_4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_4.setViewportView(table_4);

		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Produktion", null, panel_5, null);
		panel_5.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		panel_5.add(tabbedPane_2);

		JPanel panel_17 = new JPanel();
		tabbedPane_2.addTab("Maschinen", null, panel_17, null);
		GridBagLayout gbl_panel_17 = new GridBagLayout();
		gbl_panel_17.columnWidths = new int[] { 0, 0 };
		gbl_panel_17.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0 };
		gbl_panel_17.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_17.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_17.setLayout(gbl_panel_17);

		JScrollPane scrollPane_5 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_5 = new GridBagConstraints();
		gbc_scrollPane_5.gridheight = 12;
		gbc_scrollPane_5.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_5.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_5.gridx = 0;
		gbc_scrollPane_5.gridy = 0;
		panel_17.add(scrollPane_5, gbc_scrollPane_5);

		table_5 = new JTable();
		table_5.setModel(new DefaultTableModel(new Object[][] {
				{ "Typ1", "2", "2014", "8" }, { "Typ3", "1", "2008", "6" }, },
				new String[] { "Maschinentyp", "Ausbaustufe",
						"Anschaffungsjahr", "Abschreibedauer" }));
		table_5.getColumnModel().getColumn(0).setPreferredWidth(111);
		table_5.getColumnModel().getColumn(2).setPreferredWidth(130);
		table_5.getColumnModel().getColumn(3).setPreferredWidth(102);
		scrollPane_5.setViewportView(table_5);

		JPanel panel_19 = new JPanel();
		GridBagConstraints gbc_panel_19 = new GridBagConstraints();
		gbc_panel_19.fill = GridBagConstraints.BOTH;
		gbc_panel_19.gridx = 0;
		gbc_panel_19.gridy = 12;
		panel_17.add(panel_19, gbc_panel_19);

		JButton btnMaschineKaufen = new JButton("Maschine kaufen");
		panel_19.add(btnMaschineKaufen);

		JButton btnMaschineVerkaufen = new JButton("Maschine verkaufen");
		panel_19.add(btnMaschineVerkaufen);

		JPanel panel_18 = new JPanel();
		tabbedPane_2.addTab("Produzieren", null, panel_18, null);
		GridBagLayout gbl_panel_18 = new GridBagLayout();
		gbl_panel_18.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_18.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_18.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_18.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_18.setLayout(gbl_panel_18);

		JLabel lblProduzieren = new JLabel("Produzieren");
		lblProduzieren.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblProduzieren = new GridBagConstraints();
		gbc_lblProduzieren.insets = new Insets(0, 0, 5, 5);
		gbc_lblProduzieren.gridx = 0;
		gbc_lblProduzieren.gridy = 0;
		panel_18.add(lblProduzieren, gbc_lblProduzieren);

		JLabel lblMaschine = new JLabel("Maschine:");
		GridBagConstraints gbc_lblMaschine = new GridBagConstraints();
		gbc_lblMaschine.anchor = GridBagConstraints.EAST;
		gbc_lblMaschine.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaschine.gridx = 0;
		gbc_lblMaschine.gridy = 1;
		panel_18.add(lblMaschine, gbc_lblMaschine);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {
				"Typ1: Ausbaustufe 1", "Typ1: Ausbaustufe 2",
				"Typ1: Ausbaustufe 3", "Typ2: Ausbaustufe 1",
				"Typ2: Ausbaustufe 2", "Typ2: Ausbaustufe 3",
				"Typ3: Ausbaustufe 1", "Typ3: Ausbaustufe 2",
				"Typ3: Ausbaustufe 3" }));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.anchor = GridBagConstraints.WEST;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 1;
		panel_18.add(comboBox_1, gbc_comboBox_1);

		JLabel lblRohstoff = new JLabel("Rohstoff:");
		GridBagConstraints gbc_lblRohstoff = new GridBagConstraints();
		gbc_lblRohstoff.anchor = GridBagConstraints.EAST;
		gbc_lblRohstoff.insets = new Insets(0, 0, 5, 5);
		gbc_lblRohstoff.gridx = 0;
		gbc_lblRohstoff.gridy = 2;
		panel_18.add(lblRohstoff, gbc_lblRohstoff);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {
				"Pink Lady \u00C4pfel", "Boskoop \u00C4pfel" }));
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.anchor = GridBagConstraints.WEST;
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_2.gridx = 1;
		gbc_comboBox_2.gridy = 2;
		panel_18.add(comboBox_2, gbc_comboBox_2);

		JLabel lblEinsatzMenge = new JLabel("Einsatz Menge:");
		GridBagConstraints gbc_lblEinsatzMenge = new GridBagConstraints();
		gbc_lblEinsatzMenge.anchor = GridBagConstraints.EAST;
		gbc_lblEinsatzMenge.insets = new Insets(0, 0, 5, 5);
		gbc_lblEinsatzMenge.gridx = 0;
		gbc_lblEinsatzMenge.gridy = 3;
		panel_18.add(lblEinsatzMenge, gbc_lblEinsatzMenge);

		textField_3 = new JTextField();
		textField_3.setText("50");
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.anchor = GridBagConstraints.WEST;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 3;
		panel_18.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);

		JButton btnProduzieren = new JButton("Produzieren");
		GridBagConstraints gbc_btnProduzieren = new GridBagConstraints();
		gbc_btnProduzieren.anchor = GridBagConstraints.WEST;
		gbc_btnProduzieren.gridx = 1;
		gbc_btnProduzieren.gridy = 4;
		panel_18.add(btnProduzieren, gbc_btnProduzieren);

		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Marketing", null, panel_6, null);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[] { 0, 0 };
		gbl_panel_6.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0 };
		gbl_panel_6.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_6.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_6.setLayout(gbl_panel_6);

		JScrollPane scrollPane_6 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_6 = new GridBagConstraints();
		gbc_scrollPane_6.gridheight = 12;
		gbc_scrollPane_6.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_6.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_6.gridx = 0;
		gbc_scrollPane_6.gridy = 0;
		panel_6.add(scrollPane_6, gbc_scrollPane_6);

		table_6 = new JTable();
		table_6.setModel(new DefaultTableModel(new Object[][] {
				{ "Onlinewerbung", "1500" }, { "Flyer", "4000" }, },
				new String[] { "Webungstyp", "Investition in \u20AC" }));
		table_6.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_6.setViewportView(table_6);

		JPanel panel_20 = new JPanel();
		GridBagConstraints gbc_panel_20 = new GridBagConstraints();
		gbc_panel_20.fill = GridBagConstraints.BOTH;
		gbc_panel_20.gridx = 0;
		gbc_panel_20.gridy = 12;
		panel_6.add(panel_20, gbc_panel_20);
		GridBagLayout gbl_panel_20 = new GridBagLayout();
		gbl_panel_20.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_20.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_20.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_20.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_20.setLayout(gbl_panel_20);

		JLabel lblWerbungBuchen = new JLabel("Werbung buchen");
		lblWerbungBuchen.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblWerbungBuchen = new GridBagConstraints();
		gbc_lblWerbungBuchen.insets = new Insets(0, 0, 5, 5);
		gbc_lblWerbungBuchen.gridx = 0;
		gbc_lblWerbungBuchen.gridy = 0;
		panel_20.add(lblWerbungBuchen, gbc_lblWerbungBuchen);

		JLabel lblWerbetyp = new JLabel("Werbetyp:");
		GridBagConstraints gbc_lblWerbetyp = new GridBagConstraints();
		gbc_lblWerbetyp.anchor = GridBagConstraints.EAST;
		gbc_lblWerbetyp.insets = new Insets(0, 0, 5, 5);
		gbc_lblWerbetyp.gridx = 0;
		gbc_lblWerbetyp.gridy = 1;
		panel_20.add(lblWerbetyp, gbc_lblWerbetyp);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] { "Flyer",
				"Merchandise", "Magazine", "Online", "TV" }));
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.anchor = GridBagConstraints.WEST;
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_3.gridx = 1;
		gbc_comboBox_3.gridy = 1;
		panel_20.add(comboBox_3, gbc_comboBox_3);

		JLabel lblInvestition = new JLabel("Investition in \u20AC:");
		GridBagConstraints gbc_lblInvestition = new GridBagConstraints();
		gbc_lblInvestition.anchor = GridBagConstraints.EAST;
		gbc_lblInvestition.insets = new Insets(0, 0, 5, 5);
		gbc_lblInvestition.gridx = 0;
		gbc_lblInvestition.gridy = 2;
		panel_20.add(lblInvestition, gbc_lblInvestition);

		textField_4 = new JTextField();
		textField_4.setText("4000");
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.anchor = GridBagConstraints.WEST;
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 2;
		panel_20.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);

		JButton btnInvestieren = new JButton("Investieren");
		GridBagConstraints gbc_btnInvestieren = new GridBagConstraints();
		gbc_btnInvestieren.anchor = GridBagConstraints.WEST;
		gbc_btnInvestieren.gridx = 1;
		gbc_btnInvestieren.gridy = 4;
		panel_20.add(btnInvestieren, gbc_btnInvestieren);
	}

}
