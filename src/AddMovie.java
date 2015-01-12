import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;
import java.awt.Insets;


@SuppressWarnings("serial")
public class AddMovie extends JFrame {

	private JTextField titleField;
	private JTextField directorField;
	private JTextField ratingField;
	private JTextField genreField;
	private JTextField runtimeField;
	private JTextArea plotArea;
	private JButton btnSave;
	private JButton btnCancel;
	private com.toedter.calendar.JDateChooser btnDate;
	private DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	private JLabel lblUrl;
	private JTextField urlField;

	/**
	 * Create the application.
	 */
	public AddMovie() {
		DatabaseConnector dc = new DatabaseConnector();
				
		setBounds(100, 100, 600, 400);
		setTitle("Edit Movie");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 70, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblTitle = new JLabel("Title:");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.EAST;
		gbc_lblTitle.insets = new Insets(5, 5, 5, 5);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		getContentPane().add(lblTitle, gbc_lblTitle);
		
		titleField = new JTextField();
		GridBagConstraints gbc_titleField = new GridBagConstraints();
		gbc_titleField.gridwidth = 2;
		gbc_titleField.insets = new Insets(5, 0, 5, 0);
		gbc_titleField.fill = GridBagConstraints.HORIZONTAL;
		gbc_titleField.gridx = 1;
		gbc_titleField.gridy = 0;
		getContentPane().add(titleField, gbc_titleField);
		titleField.setColumns(10);
		
		JLabel lblDirector = new JLabel("Director:");
		GridBagConstraints gbc_lblDirector = new GridBagConstraints();
		gbc_lblDirector.anchor = GridBagConstraints.EAST;
		gbc_lblDirector.insets = new Insets(0, 5, 5, 5);
		gbc_lblDirector.gridx = 0;
		gbc_lblDirector.gridy = 1;
		getContentPane().add(lblDirector, gbc_lblDirector);
		
		directorField = new JTextField();
		GridBagConstraints gbc_directorField = new GridBagConstraints();
		gbc_directorField.gridwidth = 2;
		gbc_directorField.insets = new Insets(0, 0, 5, 0);
		gbc_directorField.fill = GridBagConstraints.HORIZONTAL;
		gbc_directorField.gridx = 1;
		gbc_directorField.gridy = 1;
		getContentPane().add(directorField, gbc_directorField);
		directorField.setColumns(10);
		
		JLabel lblRating = new JLabel("Rating:");
		GridBagConstraints gbc_lblRating = new GridBagConstraints();
		gbc_lblRating.anchor = GridBagConstraints.EAST;
		gbc_lblRating.insets = new Insets(0, 5, 5, 5);
		gbc_lblRating.gridx = 0;
		gbc_lblRating.gridy = 2;
		getContentPane().add(lblRating, gbc_lblRating);
		
		ratingField = new JTextField();
		GridBagConstraints gbc_ratingField = new GridBagConstraints();
		gbc_ratingField.gridwidth = 2;
		gbc_ratingField.insets = new Insets(0, 0, 5, 0);
		gbc_ratingField.fill = GridBagConstraints.HORIZONTAL;
		gbc_ratingField.gridx = 1;
		gbc_ratingField.gridy = 2;
		getContentPane().add(ratingField, gbc_ratingField);
		ratingField.setColumns(10);
		
		JLabel lblGenre = new JLabel("Genre:");
		GridBagConstraints gbc_lblGenre = new GridBagConstraints();
		gbc_lblGenre.anchor = GridBagConstraints.EAST;
		gbc_lblGenre.insets = new Insets(0, 5, 5, 5);
		gbc_lblGenre.gridx = 0;
		gbc_lblGenre.gridy = 3;
		getContentPane().add(lblGenre, gbc_lblGenre);
		
		genreField = new JTextField();
		GridBagConstraints gbc_genreField = new GridBagConstraints();
		gbc_genreField.gridwidth = 2;
		gbc_genreField.insets = new Insets(0, 0, 5, 0);
		gbc_genreField.fill = GridBagConstraints.HORIZONTAL;
		gbc_genreField.gridx = 1;
		gbc_genreField.gridy = 3;
		getContentPane().add(genreField, gbc_genreField);
		genreField.setColumns(10);
		
		JLabel lblRuntime = new JLabel("Run time:");
		GridBagConstraints gbc_lblRuntime = new GridBagConstraints();
		gbc_lblRuntime.anchor = GridBagConstraints.EAST;
		gbc_lblRuntime.insets = new Insets(0, 5, 5, 5);
		gbc_lblRuntime.gridx = 0;
		gbc_lblRuntime.gridy = 4;
		getContentPane().add(lblRuntime, gbc_lblRuntime);
		
		runtimeField = new JTextField();
		GridBagConstraints gbc_runtimeField = new GridBagConstraints();
		gbc_runtimeField.gridwidth = 2;
		gbc_runtimeField.insets = new Insets(0, 0, 5, 0);
		gbc_runtimeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_runtimeField.gridx = 1;
		gbc_runtimeField.gridy = 4;
		getContentPane().add(runtimeField, gbc_runtimeField);
		runtimeField.setColumns(10);
		
		JLabel lblReleaseDate = new JLabel("Release Date:");
		GridBagConstraints gbc_lblReleaseDate = new GridBagConstraints();
		gbc_lblReleaseDate.anchor = GridBagConstraints.EAST;
		gbc_lblReleaseDate.insets = new Insets(0, 5, 5, 5);
		gbc_lblReleaseDate.gridx = 0;
		gbc_lblReleaseDate.gridy = 5;
		getContentPane().add(lblReleaseDate, gbc_lblReleaseDate);
		
		btnDate = new com.toedter.calendar.JDateChooser();
		btnDate.setDateFormatString("yyyy-MM-dd");
		GridBagConstraints gbc_btnDate = new GridBagConstraints();
		gbc_btnDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDate.gridwidth = 2;
		gbc_btnDate.insets = new Insets(0, 0, 5, 0);
		gbc_btnDate.gridx = 1;
		gbc_btnDate.gridy = 5;
		getContentPane().add(btnDate, gbc_btnDate);
		
		JLabel lblPlot = new JLabel("Plot:");
		GridBagConstraints gbc_lblPlot = new GridBagConstraints();
		gbc_lblPlot.insets = new Insets(0, 5, 5, 5);
		gbc_lblPlot.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblPlot.gridx = 0;
		gbc_lblPlot.gridy = 6;
		getContentPane().add(lblPlot, gbc_lblPlot);
		
		plotArea = new JTextArea();
		plotArea.setBorder(LineBorder.createGrayLineBorder());
		plotArea.setWrapStyleWord(true);
		plotArea.setLineWrap(true);
		GridBagConstraints gbc_plotArea = new GridBagConstraints();
		gbc_plotArea.gridwidth = 2;
		gbc_plotArea.insets = new Insets(0, 0, 5, 0);
		gbc_plotArea.fill = GridBagConstraints.BOTH;
		gbc_plotArea.gridx = 1;
		gbc_plotArea.gridy = 6;
		getContentPane().add(plotArea, gbc_plotArea);
		plotArea.setColumns(10);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Movie m = new Movie();
				m.title = titleField.getText();
				m.rating = ratingField.getText();
				m.genre = genreField.getText();
				m.director = directorField.getText();
				m.plot = plotArea.getText();
				m.runtime = Integer.parseInt(runtimeField.getText());
				m.release_date = dateformat.format(btnDate.getDate());
				m.imagepath = urlField.getText();
				
				if(dc.insertMovie(m)) {
					javax.swing.JOptionPane.showMessageDialog(null, "Success! You ma dawg!");
					dispose();
				} else {
					javax.swing.JOptionPane.showMessageDialog(null, "Something went wrong. Try again buddy.");
				}
			}
		});
		
		lblUrl = new JLabel("Poster URL:");
		GridBagConstraints gbc_lblUrl = new GridBagConstraints();
		gbc_lblUrl.anchor = GridBagConstraints.EAST;
		gbc_lblUrl.insets = new Insets(0, 0, 5, 5);
		gbc_lblUrl.gridx = 0;
		gbc_lblUrl.gridy = 7;
		getContentPane().add(lblUrl, gbc_lblUrl);
		
		urlField = new JTextField();
		GridBagConstraints gbc_urlField = new GridBagConstraints();
		gbc_urlField.gridwidth = 2;
		gbc_urlField.insets = new Insets(0, 0, 5, 0);
		gbc_urlField.fill = GridBagConstraints.HORIZONTAL;
		gbc_urlField.gridx = 1;
		gbc_urlField.gridy = 7;
		getContentPane().add(urlField, gbc_urlField);
		urlField.setColumns(10);
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.anchor = GridBagConstraints.EAST;
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.gridx = 1;
		gbc_btnSave.gridy = 8;
		getContentPane().add(btnSave, gbc_btnSave);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.anchor = GridBagConstraints.WEST;
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 8;
		getContentPane().add(btnCancel, gbc_btnCancel);
	}
}
