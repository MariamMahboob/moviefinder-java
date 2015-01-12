import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class GetImage {
	Icon icon = null;

	public Icon get(String imagepath) throws IOException {
		URL url = new URL(imagepath);
		BufferedImage bi = resize(ImageIO.read(url), 214, 317);
		icon = new ImageIcon(bi);
		return icon;
	}
	
	public Icon noIcon() throws IOException {
		File f = new File(System.getProperty("user.dir")+File.separator+"pictures"+File.separator+"imagenotfound.jpg");
		BufferedImage bi = resize(ImageIO.read(f), 214, 317);
		icon = new ImageIcon(bi);
		return icon;
	}
	
	private static final BufferedImage resize(BufferedImage image, int width, int height) {
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
		Graphics2D g2d = (Graphics2D) bi.createGraphics();
		g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
		g2d.drawImage(image, 0, 0, width, height, null);
		g2d.dispose();
		return bi;
	} 
}
