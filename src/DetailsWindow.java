import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;


@SuppressWarnings("serial")
public class DetailsWindow extends JFrame{

	private DatabaseConnector dc = new DatabaseConnector();

	DetailsWindow(int movieid) throws IOException {
		Movie movie = dc.getMovieDetailsList(movieid);
		
		setTitle(movie.title);
		setBounds(100, 100, 700, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblIcon = new JLabel("");
		GridBagConstraints gbc_lblIcon = new GridBagConstraints();
		gbc_lblIcon.anchor = GridBagConstraints.NORTH;
		gbc_lblIcon.gridheight = 7;
		gbc_lblIcon.insets = new Insets(5, 5, 0, 5);
		gbc_lblIcon.gridx = 0;
		gbc_lblIcon.gridy = 0;
		getContentPane().add(lblIcon, gbc_lblIcon);
		
		JLabel lblDirector = new JLabel("Director:");
		GridBagConstraints gbc_lblDirector = new GridBagConstraints();
		gbc_lblDirector.anchor = GridBagConstraints.EAST;
		gbc_lblDirector.insets = new Insets(5, 0, 5, 5);
		gbc_lblDirector.gridx = 1;
		gbc_lblDirector.gridy = 0;
		getContentPane().add(lblDirector, gbc_lblDirector);
		
		JLabel director = new JLabel(movie.director);
		GridBagConstraints gbc_director = new GridBagConstraints();
		gbc_director.anchor = GridBagConstraints.WEST;
		gbc_director.insets = new Insets(5, 0, 5, 0);
		gbc_director.gridx = 2;
		gbc_director.gridy = 0;
		getContentPane().add(director, gbc_director);
		
		JLabel lblRating = new JLabel("Rating:");
		GridBagConstraints gbc_lblRating = new GridBagConstraints();
		gbc_lblRating.anchor = GridBagConstraints.EAST;
		gbc_lblRating.insets = new Insets(0, 0, 5, 5);
		gbc_lblRating.gridx = 1;
		gbc_lblRating.gridy = 1;
		getContentPane().add(lblRating, gbc_lblRating);
		
		JLabel rating = new JLabel(movie.rating+"/10");
		GridBagConstraints gbc_rating = new GridBagConstraints();
		gbc_rating.anchor = GridBagConstraints.WEST;
		gbc_rating.insets = new Insets(0, 0, 5, 0);
		gbc_rating.gridx = 2;
		gbc_rating.gridy = 1;
		getContentPane().add(rating, gbc_rating);
		
		JLabel lblGenre = new JLabel("Genre:");
		GridBagConstraints gbc_lblGenre = new GridBagConstraints();
		gbc_lblGenre.anchor = GridBagConstraints.EAST;
		gbc_lblGenre.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenre.gridx = 1;
		gbc_lblGenre.gridy = 2;
		getContentPane().add(lblGenre, gbc_lblGenre);
		
		JLabel genre = new JLabel(movie.genre);
		GridBagConstraints gbc_genre = new GridBagConstraints();
		gbc_genre.anchor = GridBagConstraints.WEST;
		gbc_genre.insets = new Insets(0, 0, 5, 0);
		gbc_genre.gridx = 2;
		gbc_genre.gridy = 2;
		getContentPane().add(genre, gbc_genre);
		
		JLabel lblRunTime = new JLabel("Run time:");
		GridBagConstraints gbc_lblRunTime = new GridBagConstraints();
		gbc_lblRunTime.anchor = GridBagConstraints.EAST;
		gbc_lblRunTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblRunTime.gridx = 1;
		gbc_lblRunTime.gridy = 3;
		getContentPane().add(lblRunTime, gbc_lblRunTime);
		
		JLabel runtime = new JLabel(movie.runtime + " minutes");
		GridBagConstraints gbc_runtime = new GridBagConstraints();
		gbc_runtime.anchor = GridBagConstraints.WEST;
		gbc_runtime.insets = new Insets(0, 0, 5, 0);
		gbc_runtime.gridx = 2;
		gbc_runtime.gridy = 3;
		getContentPane().add(runtime, gbc_runtime);
		
		JLabel lblReleaseDate = new JLabel("Release Date:");
		GridBagConstraints gbc_lblReleaseDate = new GridBagConstraints();
		gbc_lblReleaseDate.anchor = GridBagConstraints.EAST;
		gbc_lblReleaseDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblReleaseDate.gridx = 1;
		gbc_lblReleaseDate.gridy = 4;
		getContentPane().add(lblReleaseDate, gbc_lblReleaseDate);
		
		JLabel releasedate = new JLabel(movie.release_date);
		GridBagConstraints gbc_releasedate = new GridBagConstraints();
		gbc_releasedate.anchor = GridBagConstraints.WEST;
		gbc_releasedate.insets = new Insets(0, 0, 5, 0);
		gbc_releasedate.gridx = 2;
		gbc_releasedate.gridy = 4;
		getContentPane().add(releasedate, gbc_releasedate);
		
		JLabel lblPlot = new JLabel("Plot:");
		GridBagConstraints gbc_lblPlot = new GridBagConstraints();
		gbc_lblPlot.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblPlot.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlot.gridx = 1;
		gbc_lblPlot.gridy = 5;
		getContentPane().add(lblPlot, gbc_lblPlot);
		
		GetImage image = new GetImage();
		try {
			lblIcon.setIcon(image.get(movie.imagepath));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			lblIcon.setIcon(image.noIcon());
		}
		
		JTextArea textArea = new JTextArea(movie.plot);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setBorder(LineBorder.createGrayLineBorder());
		textArea.setBackground(new Color(240,240,240));
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 2;
		gbc_textArea.gridy = 5;
		getContentPane().add(textArea, gbc_textArea);
		
		JMenuBar menuBar = new JMenuBar();		
		JMenu mnAdmin = new JMenu("Admin");		
		JMenuItem mntmEdit = new JMenuItem("Edit");
		mntmEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditMovie em = new EditMovie(movie.id);
				em.setVisible(true);
			}
		});
		if(AdminLogin.ReturnStatus()) { setJMenuBar(menuBar); menuBar.add(mnAdmin); mnAdmin.add(mntmEdit); }

	}
	
	public static BufferedImage resize(BufferedImage image, int width, int height) {
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
		Graphics2D g2d = (Graphics2D) bi.createGraphics();
		g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
		g2d.drawImage(image, 0, 0, width, height, null);
		g2d.dispose();
		return bi;
	}

}
