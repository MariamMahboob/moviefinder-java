import javax.swing.JFrame;

import java.awt.GridBagLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.io.IOException;

import java.util.List;


public class MainWindow {

	private JFrame frmMoviefinder;
	private JTextField textField;
	private JTable resultList;
	private LockedTableModel ltm;
	private DatabaseConnector dc = new DatabaseConnector();
	private JMenuItem mntmEdit = new JMenuItem("Edit");
	private JMenuItem mntmLogin = new JMenuItem("Login");
	private JMenuItem mntmLogout = new JMenuItem("Log out");
	private JMenuItem mntmAddNew = new JMenuItem("Add New");
	private JButton btnGetInfo;
	private JComboBox ratingBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmMoviefinder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		AdminRights();
		initialize();
	}
	public void AdminRights() {
		// Used for testing.
		// AdminLogin.adminRights = true;
		if(AdminLogin.ReturnStatus()) { mntmEdit.setVisible(true); mntmLogin.setVisible(false); mntmLogout.setVisible(true); mntmAddNew.setVisible(true); }
		else { mntmEdit.setVisible(false); mntmLogout.setVisible(false); mntmAddNew.setVisible(false); }
	}
	/**
	 * Initialize the contents of the frame.
	 * Lots of auto generated windowbuilder code.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frmMoviefinder = new JFrame();
		frmMoviefinder.setTitle("MovieFinder");
		frmMoviefinder.setBounds(100, 100, 400, 600);
		frmMoviefinder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		frmMoviefinder.getContentPane().setLayout(gridBagLayout);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(5, 5, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		frmMoviefinder.getContentPane().add(textField, gbc_textField);
				
		JComboBox genreBox = new JComboBox();
		DefaultComboBoxModel bm = new DefaultComboBoxModel();
		bm.addElement("All");
		
		for(int i=0; i<dc.GetGenres().size(); i++) {
			// Get genres in database using GetGenres() method.
			bm.addElement(dc.GetGenres().get(i));
		}
		
		genreBox.setModel(bm);
		GridBagConstraints gbc_genreBox = new GridBagConstraints();
		gbc_genreBox.insets = new Insets(5, 0, 5, 5);
		gbc_genreBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_genreBox.gridx = 1;
		gbc_genreBox.gridy = 0;
		frmMoviefinder.getContentPane().add(genreBox, gbc_genreBox);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnGetInfo.setVisible(true);
				// Clears table of previous search.
				if(ltm.getRowCount() != 0) {
					int rowsToRemove = ltm.getRowCount();
					for(int i = rowsToRemove-1; i>=0; i--) {
						ltm.removeRow(i);
					}
				}

				List<Movie> results = dc.getMovie(textField.getText(), genreBox.getSelectedItem().toString(), ratingBox.getSelectedItem().toString());
				// For each result of getMovie create a new row with the vaules fetched.
				for(Movie s : results) {
					ltm.addRow(new Object[] {
							s.id,
							s.title,
							s.genre,
							s.rating
					});
				}
			}
		});
		// Create values for Rating combobox.
		DefaultComboBoxModel bm2 = new DefaultComboBoxModel();
		bm2.addElement("Rating");
		for(int i=10; i>=1; i--) { bm2.addElement(i); }
		
		ratingBox = new JComboBox();
		ratingBox.setModel(bm2);
		
		GridBagConstraints gbc_ratingBox = new GridBagConstraints();
		gbc_ratingBox.insets = new Insets(5, 0, 5, 5);
		gbc_ratingBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_ratingBox.gridx = 2;
		gbc_ratingBox.gridy = 0;
		frmMoviefinder.getContentPane().add(ratingBox, gbc_ratingBox);
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(5, 0, 5, 0);
		gbc_btnSearch.gridx = 3;
		gbc_btnSearch.gridy = 0;
		frmMoviefinder.getContentPane().add(btnSearch, gbc_btnSearch);
		
		// Create values used in the result JTable.
		ltm = new LockedTableModel(
					new Object[][] { },
					new String[] { "ID", "Title", "Genre", "Rating" }
				);
		// Adjustments for JTable behaviour.
		resultList = new JTable();
		resultList.setModel(ltm);
		resultList.removeColumn(resultList.getColumnModel().getColumn(0));
		resultList.getColumnModel().getColumn(0).setPreferredWidth(250);
		resultList.getColumnModel().getColumn(1).setPreferredWidth(75);
		resultList.getColumnModel().getColumn(2).setPreferredWidth(75);
		resultList.setAutoCreateRowSorter(true);
		resultList.getTableHeader().setReorderingAllowed(false);
		resultList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPane = new JScrollPane(resultList);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(1, 5, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		frmMoviefinder.getContentPane().add(scrollPane, gbc_scrollPane);
		
		btnGetInfo = new JButton("Get Info");
		btnGetInfo.setVisible(false);
		btnGetInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DetailsWindow dw;
				// Call DetailWindows with the selected row index as argument.
				try {
					int modelRow = resultList.convertRowIndexToModel(resultList.getSelectedRow());
					dw = new DetailsWindow((int) resultList.getModel().getValueAt(modelRow, 0));
					dw.setVisible(true);
					dw.setLocationRelativeTo(frmMoviefinder);
				} catch (IOException e) {
					// e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnGetInfo = new GridBagConstraints();
		gbc_btnGetInfo.insets = new Insets(0, 1, 1, 1);
		gbc_btnGetInfo.fill = GridBagConstraints.BOTH;
		gbc_btnGetInfo.gridwidth = 4;
		gbc_btnGetInfo.gridx = 0;
		gbc_btnGetInfo.gridy = 2;
		frmMoviefinder.getContentPane().add(btnGetInfo, gbc_btnGetInfo);
		
		JMenuBar menuBar = new JMenuBar();
		frmMoviefinder.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// DIE
				System.exit(1);
			}
		});
		mnFile.add(mntmQuit);
		
		JMenu mnAdmin = new JMenu("Admin");
		menuBar.add(mnAdmin);
		
		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Admin Login window
				AdminLogin al = new AdminLogin();
				al.setVisible(true);
				al.setLocationRelativeTo(frmMoviefinder);
				frmMoviefinder.dispose();
			}
		});
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin.adminRights = false;
				frmMoviefinder.dispose();
				MainWindow.main(null);
			}
		});
		
		mnAdmin.add(mntmLogin);
		mnAdmin.add(mntmLogout);
		mntmEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int modelRow = resultList.convertRowIndexToModel(resultList.getSelectedRow());
				EditMovie em = new EditMovie((int) resultList.getModel().getValueAt(modelRow, 0));
				em.setVisible(true);
			}
		});
		
		mntmAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddMovie am = new AddMovie();
				am.setVisible(true);
			}
		});
		mnAdmin.add(mntmAddNew);
		mnAdmin.add(mntmEdit);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnAbout.add(mntmAbout);
	}
}
