package com.spycesoftware.bonzi;

import java.awt.Toolkit;

public class BonziAnimationRunnable implements Runnable{
	Bonzi bonzi;
	
	public BonziAnimationRunnable(Bonzi bonzi){
		this.bonzi = bonzi;
	}
	
	@Override
	public void run() {
		if(bonzi.bonziAnimationExpanded){
			bonzi.upadteBonziPicture("/assets/bonzi_normal.png");
			bonzi.bonziAnimationExpanded = false;
			
			bonzi.frame.setLocation( 
				(int) ((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.4), 
				(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - 300);
		}else{
			bonzi.upadteBonziPicture("/assets/bonzi_expanded.png");
			bonzi.bonziAnimationExpanded = true;
			bonzi.frame.setLocation( 
				(int) ((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.10), 
				((int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - 300));
		}
	}
	
}
