import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PongScoreboard extends JPanel {
	JButton pause, reset;
	JPanel score, games, buttons;
	JLabel game, score1,score2;
	int gamesPlayed,scoreP1,scoreP2;
	
	public PongScoreboard(ActionListener p, ActionListener r){
		gamesPlayed = 0;
		
		scoreP1 = 0;
		scoreP2 = 0;
		
		Font f = new Font("Monospaced", Font.PLAIN, 15);
		Color c = Color.WHITE;
		setLayout(new GridLayout(3,1));
		setBackground(Color.WHITE);;
		
		games.setLayout(new GridLayout(2,1,5,5));
		JLabel label = new JLabel("Games Played:");	
		label.setFont(f);
		label.setForeground(c);
		games.add(label);
		game = new JLabel(""+gamesPlayed);
		game.setForeground(c);
		game.setFont(f);
		games.add(game);
		add(games);
		
		score.setLayout(new  GridLayout(3,1,3,3));
		score1=new JLabel(""+scoreP1);
		score1.setForeground(c);
		score1.setFont(f);
		score.add(score1);
		JLabel label2 = new JLabel(" | ");
		label2.setFont(f);
		label2.setForeground(c);
		score2=new JLabel(""+scoreP2);
		score2.setFont(f);
		score2.setForeground(c);
		score.add(score2);
		add(score);
		
		buttons = new JPanel();
		buttons.setLayout(new GridLayout(2,1));
		pause = new JButton("Pause");
		pause.setFont(f);
		pause.setBackground(c);
		pause.addActionListener(p);
		buttons.add(pause);
		reset = new JButton("reset");
		reset.setFont(f);
		reset.setBackground(c);
		buttons.add(reset);
		reset.addActionListener(r);
		add(buttons);}
	
	
		public void update(int s1, int s2){
			scoreP1 = s1;
			scoreP2 = s2;
			if(scoreP1 == 7){
				scoreP1 = 0;
				scoreP2 = 0;
				gamesPlayed++;
			}
			if(scoreP2 == 7){
				scoreP2 = 0;
				scoreP1 = 0;
				gamesPlayed++;
				
			}
			score1.setText(""+scoreP1);
			score2.setText(""+scoreP2);
			game.setText(""+gamesPlayed);
		}

		public int getScoreP1() {
			return scoreP1;
		}

		public void setScoreP1(int scoreP1) {
			this.scoreP1 = scoreP1;
		}

		public int getScoreP2() {
			return scoreP2;
		}

		public void setScoreP2(int scoreP2) {
			this.scoreP2 = scoreP2;
		}
		
		
	
}
