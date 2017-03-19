import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PongSuperPanel extends JPanel {
	PongScoreboard ps;
	PongPanel pp;
	Timer t;
	
	PongSuperPanel(){
		ps = new PongScoreboard(new pause(),new reset());
		pp = new PongPanel();
		setLayout(new BorderLayout());
		add(ps, BorderLayout.NORTH);
		add(pp,BorderLayout.CENTER);
		t = new Timer(3, new Listener());
	}
	
	private class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			pp.stepAnimation();
			
		}
		
	}
	
	
	private class pause implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	private class reset implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
