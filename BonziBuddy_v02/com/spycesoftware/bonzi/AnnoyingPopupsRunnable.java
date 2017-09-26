package com.spycesoftware.bonzi;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AnnoyingPopupsRunnable implements Runnable{
	
	@Override
	public void run() {
		JFrame frame = new JFrame("DONG HAS BEEN EXPANDED");
		JLabel image = new JLabel(new ImageIcon(this.getClass().getResource("/assets/bonzi_best.png")));
		ImageIcon img = new ImageIcon(this.getClass().getResource("/assets/icon.png"));
	       
		image.setSize(500, 500);
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		frame.setSize(500, 500);
		frame.add(image);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setIconImage(img.getImage());
		frame.setLocation((int) Math.floor(Math.random() * (w - 500)), (int) Math.floor(Math.random() * (h- 500)));
		
		frame.setVisible(true);
	}

}
