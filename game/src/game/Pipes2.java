package game;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Pipes2 {
	public int pipex = 0,pipey = 0;
	
	private Image img; // image of the frog
	private AffineTransform tx = AffineTransform.getTranslateInstance(pipex, pipey);

	public Pipes2() {
	img = getImage("/imgs/pipe2.png"); //load the image based on the filename "ground.png"
		init(pipex, pipey);    
		
		pipex = 800;
		pipey = 100;
		
		init(pipex, pipey);
		
	}
	
	
	public int getPipex() {
		return pipex;
	}

	public void setPipex(int pipex) {
		this.pipex = pipex;
	}

	public int getPipey() {
		return pipey;
	}

	public void setPipey(int pipey) {
		this.pipey = pipey;
	}

	
	
	public void paint(Graphics g) {
		//using a Graphics2D to draw images
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		pipex = pipex-5;
		tx.setToTranslation(pipex, pipey);
		update();
	}
	
	
	
	
	
	private void update() {
		if(pipex <= -80) {
			pipex = 810;
			pipey = (int) (Math.random()*(601)+200);
		}
		tx.setToTranslation(pipex, pipey);
		tx.scale(0.2, 0.5);
	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(0.5, 1);
	}

	
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