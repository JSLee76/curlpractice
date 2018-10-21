package curlpractice;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.math.*;

public class ButtonBall2 extends JPanel { 
	double radius = 30;
	double loc_X = 200;
	double loc_Y = 600;
	
	public double dx = 0.2;
	public double dy = -5;
	
	static final double friction = 0.005;
	
	ButtonBall2(){
		setLayout(new FlowLayout());



				
			
		
		JButton bt1 = new JButton("Release Ball!");
		

		
		bt1.addMouseListener(new MouseAdapter() {
			boolean flag = false;
			double startTime, endTime, holdTime;
			public void mousePressed(MouseEvent e) {
				startTime = System.nanoTime();
				flag = true;				
			}
			public void mouseReleased(MouseEvent e) {
				if(flag) {
					endTime = System.nanoTime();
					flag = false;
					holdTime = (endTime - startTime)/Math.pow(10, 9);
					dy = -holdTime;
					while(!(dx==0 && dy==0)) {
						loc_X = loc_X + dx;
						loc_Y = loc_Y + dy;
						System.out.println(loc_X);
						double theta = Math.atan2(dy, dx);
							
						if (Math.abs(dx)<friction) dx=0; else dx = dx - friction*Math.cos(theta);
						if (Math.abs(dy)<friction) dy=0; else dy = dy - friction*Math.sin(theta);
							
						repaint();
						setVisible(true);
							
						try {
							Thread.sleep(100);
						} catch(InterruptedException ex) {
								
							}
						}
				}

			}
			
		});
		add(bt1);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillOval((int)(loc_X-radius),(int)(loc_Y-radius), 2*(int)radius, 2*(int)radius);
	}
	
}



class MyFrame2 extends JFrame {
	MyFrame2(){
		setSize(400, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setDefaultLookAndFeelDecorated(true);
		setTitle("Button for Release"); 
	}
	public void setBallPanel2(ButtonBall2 b) {
		this.setContentPane(b);
	}
	

}



