package com.spycesoftware.bonzi;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.spycesoftware.util.loop.LogMethod;
import com.spycesoftware.util.loop.Loop;

public class Bonzi {
		public JFrame frame;
		private JPanel panel;
		private JButton btn;
		private JLabel bonziPicture;
		private boolean expanded;
		public Loop bonziAnimationLoop;
		private Runnable bonziAnimationRunnable;
		public boolean bonziAnimationExpanded;
		public Loop annoyingPopups;
		public Runnable annoyingPopupsRunnable;
	   

		public void expandDong(){
	       if(!expanded){
	    	   try{
	    		   Sequencer sequencer = MidiSystem.getSequencer();
	    		   sequencer.open();
	    		   
	    		   URL url = this.getClass().getResource("/assets/Bonzi Buddy - All Star.mid");

	    		   sequencer.setSequence(MidiSystem.getSequence(url));
	    	       sequencer.setLoopCount(5);  
	    	       sequencer.start();

	    	   }catch(Exception e){
	    		   System.err.println(e);
	    	   }
	               
	               
	               expanded = true;
	               upadteBonziPicture("/assets/bonzi_expanded.png");
	               btn.setText("dong has been expanded");
	               btn.setEnabled(false);
	               
	               bonziAnimationLoop.start();
	               annoyingPopups.start();
	               
	       }
		}
	   
		public void upadteBonziPicture(String url){
	       bonziPicture.setIcon(new ImageIcon(this.getClass().getResource(url)));
		}
		
		public void openWindow(){
		       frame = new JFrame("Bonzi");
		       btn = new JButton("clik here to expand his dong");
		       bonziPicture = new JLabel();
		       upadteBonziPicture("/assets/bonzi_normal.png");
		       
		       bonziAnimationRunnable = new BonziAnimationRunnable(this);
		       bonziAnimationLoop = new Loop("Bonzi Animation", 200, bonziAnimationRunnable, LogMethod.START_STOP);
		       
		       annoyingPopupsRunnable = new AnnoyingPopupsRunnable();
		       annoyingPopups = new Loop("Annoying Popups", 1000, annoyingPopupsRunnable, LogMethod.START_STOP);
		       
		       panel = new JPanel();
		       
		       //Button Listener
		       btn.addActionListener(new ActionListener(){
		           public void actionPerformed(ActionEvent e){
		               expandDong();
		           }    
		       });
		       btn.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		       btn.setBackground(Color.GREEN);
		       btn.setBorder(null);
		       
		       panel.add(bonziPicture);
		       panel.add(btn);
		       panel.setBackground(Color.pink);
		       panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS ) );
		       panel.setAlignmentY(java.awt.Component.CENTER_ALIGNMENT);
		       
		       frame.add(panel);
		       frame.pack();
		       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		       ImageIcon img = new ImageIcon(this.getClass().getResource("/assets/icon.png"));
		       frame.setIconImage(img.getImage());
		       frame.setResizable(false);
		       
		       frame.setVisible(true);
			}
}
