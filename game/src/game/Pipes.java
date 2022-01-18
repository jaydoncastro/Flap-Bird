package game;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Pipes {
	public int x = 0;
	public int y = 0;
	private int x2 = 0,y2 = 0;
	private Image img; // image of the frog
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

	public Pipes() {
	img = getImage("/imgs/pipe.png"); //load the image based on the filename "ground.png"
		init(x, y);    
		
		x = 800;
		y = 300;
		
		init(x, y);
		
	}
	
	
	public int getPX() {
		return x;
	}

	public void setPX(int x) {
		this.x = x;
	}

	public int getPY() {
		return y;
	}

	public void setPipey(int y) {
		this.y = y;
	}

	
	
	public void paint(Graphics g) {
		//using a Graphics2D to draw images
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		x = x-20;
		tx.setToTranslation(x, y);
		update();
	}
	
	
	
	
	
	private void update() {
		if(x <= -80) {
			x = 810;
			y = (int) (Math.random()*(601)+200);
		}
		tx.setToTranslation(x, y);
		tx.scale(0.2, 0.5);
	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(0.5, 1);
	}

	// converts image to make it drawable in paint
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Ground.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}