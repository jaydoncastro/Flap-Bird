package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Runner extends JPanel implements KeyListener, ActionListener, MouseListener{
	//I'm just the shell of a man, and a shell of who I was or could've been
	int numberOfPipes = 2;
	public boolean Started;
	
	Pipes2[] toppipes = new Pipes2[4];
	Pipes botpipes = new Pipes();
	Bird Bird = new Bird();
	Ground foreground = new Ground();
	Gameover deathscreen = new Gameover();
	StartScreen start = new StartScreen();
	
	
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		
		
		
		if(Started == false) {
			start.paint(g);
		}
		
		
		
		
	
		
		if(Started == true) {
			if(Bird.isDeath() == false) {
			foreground.paint(g);
			Bird.paint(g);
			botpipes.paint(g);
			
			//if(pipex >= 0) {
			//	numberOfPipes++;
			//	System.out.println("pipe gone");
			//}
		}
	
			
		if(Bird.isDeath() == true) {
			deathscreen.paint(g);
		
		}
		
		
		}
 }
	
	
	
	
	

	


	









	public Runner() {
		JFrame f = new JFrame("Frame");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800,600);
		f.add(this);
		f.addKeyListener(this);
		f.addMouseListener(this);
		
		t = new Timer(16, this);
		t.start();
		f.setVisible(true);
		
	
		
	}

	public static void main(String[] args) {
		
		Runner f = new Runner();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	Timer t;

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(Started == false) {
			Started = true;
		}
		
		if(Started == true) {
		Bird.Jump();
		}
	}




	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
