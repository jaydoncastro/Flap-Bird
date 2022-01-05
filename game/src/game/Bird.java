package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Bird implements MouseListener {

	
	private int x;
	private int by;
	private int vx;
	private int vy;
	private int y;
	private Image img;
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	private static int scoreCount = 0;
	public boolean Death;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	
	public Bird() {
		img = getImage("/imgs/bird.png");
		x = 200;
		y = 275;
		vy = 3;
		init(x, y);
	}
	
	
	public void Jump() {
		y -= 50;
		vy = -5;
		
	}
	
	
	
	
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;		
		g2.drawImage(img, tx, null);
		y+=vy;
		vy++;
		
		if(y >= 800) {
			Death = true;
		}
		tx.setToTranslation(x, y);

	}
	
	
	public boolean isDeath() {
		return Death;
	}



	public void setDeath(boolean death) {
		Death = death;
	}



	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Bird.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
