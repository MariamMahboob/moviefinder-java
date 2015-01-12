import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



@SuppressWarnings("serial")
public class EditMovie extends JFrame {

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
	private JButton btnDelete;

	/**
	 * Create the application.
	 */
	public EditMovie(int movieid) {
		DatabaseConnector dc = new DatabaseConnector();
		Movie movie = dc.getMovieDetailsList(movieid);
				
		setBounds(100, 100, 600, 400);
		setTitle("Edit Movie");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 70, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblTitle = new JLabel("Title:");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.EAST;
		gbc_lblTitle.insets = new Insets(5, 5, 5, 5);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		getContentPane().add(lblTitle, gbc_lblTitle);
		
		titleField = new JTextField(movie.title);
		GridBagConstraints gbc_titleField = new GridBagConstraints();
		gbc_titleField.gridwidth = 3;
		gbc_titleField.insets = new Insets(5, 0, 5, 5);
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
		
		directorField = new JTextField(movie.director);
		GridBagConstraints gbc_directorField = new GridBagConstraints();
		gbc_directorField.gridwidth = 3;
		gbc_directorField.insets = new Insets(0, 0, 5, 5);
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
		
		ratingField = new JTextField(movie.rating);
		GridBagConstraints gbc_ratingField = new GridBagConstraints();
		gbc_ratingField.gridwidth = 3;
		gbc_ratingField.insets = new Insets(0, 0, 5, 5);
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
		
		genreField = new JTextField(movie.genre);
		GridBagConstraints gbc_genreField = new GridBagConstraints();
		gbc_genreField.gridwidth = 3;
		gbc_genreField.insets = new Insets(0, 0, 5, 5);
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
		
		runtimeField = new JTextField(Integer.toString(movie.runtime));
		GridBagConstraints gbc_runtimeField = new GridBagConstraints();
		gbc_runtimeField.gridwidth = 3;
		gbc_runtimeField.insets = new Insets(0, 0, 5, 5);
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
		try {
			btnDate.setDate(dateformat.parse(movie.release_date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GridBagConstraints gbc_btnDate = new GridBagConstraints();
		gbc_btnDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDate.gridwidth = 3;
		gbc_btnDate.insets = new Insets(0, 0, 5, 5);
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
		
		plotArea = new JTextArea(movie.plot);
		plotArea.setBorder(LineBorder.createGrayLineBorder());
		plotArea.setWrapStyleWord(true);
		plotArea.setLineWrap(true);
		GridBagConstraints gbc_plotArea = new GridBagConstraints();
		gbc_plotArea.gridwidth = 3;
		gbc_plotArea.insets = new Insets(0, 0, 5, 5);
		gbc_plotArea.fill = GridBagConstraints.BOTH;
		gbc_plotArea.gridx = 1;
		gbc_plotArea.gridy = 6;
		getContentPane().add(plotArea, gbc_plotArea);
		plotArea.setColumns(10);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Movie editedmovie = new Movie();
				editedmovie.id = movie.id;

				editedmovie.title 			= titleField.getText();
				editedmovie.director 		= directorField.getText();
				editedmovie.rating 			= ratingField.getText();
				editedmovie.genre 			= genreField.getText();
				editedmovie.runtime 		= Integer.parseInt(runtimeField.getText());
				editedmovie.release_date 	= dateformat.format(btnDate.getDate());
				editedmovie.plot 			= plotArea.getText();
				editedmovie.imagepath		= urlField.getText();
				
				if(dc.updateMovieDetails(editedmovie)) {
					javax.swing.JOptionPane.showMessageDialog(null, "Success! You the man!");
					dispose();
				} else {
					javax.swing.JOptionPane.showMessageDialog(null, "You did bad. Try again!");
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
		
		urlField = new JTextField(movie.imagepath);
		GridBagConstraints gbc_urlField = new GridBagConstraints();
		gbc_urlField.gridwidth = 3;
		gbc_urlField.insets = new Insets(0, 0, 5, 5);
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
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 8;
		getContentPane().add(btnCancel, gbc_btnCancel);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Movie deletemovie = new Movie();
				deletemovie.id = movie.id;
				
				deletemovie.title 			= titleField.getText();
				deletemovie.director 		= directorField.getText();
				deletemovie.rating 			= ratingField.getText();
				deletemovie.genre 			= genreField.getText();
				deletemovie.runtime 		= Integer.parseInt(runtimeField.getText());
				deletemovie.release_date 	= dateformat.format(btnDate.getDate());
				deletemovie.plot 			= plotArea.getText();
				deletemovie.imagepath		= urlField.getText();
			
				if(dc.DeleteMovie(deletemovie)) {
					javax.swing.JOptionPane.showMessageDialog(null, "Successfully Deleted!");
					dispose();
				} else {
					javax.swing.JOptionPane.showMessageDialog(null, "Error, Try again!");
				}
			}
		});
			
		
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.anchor = GridBagConstraints.WEST;
		gbc_btnDelete.insets = new Insets(0, 0, 0, 5);
		gbc_btnDelete.gridx = 3;
		gbc_btnDelete.gridy = 8;
		getContentPane().add(btnDelete, gbc_btnDelete);
	}
}
