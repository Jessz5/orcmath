package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class ProgressJessi extends Component implements ProgressInterfaceJessi{


	private int round;
	private boolean game;
	private int seq;
	private int x;
	private int y;
	
	public ProgressJessi(int x, int y, int w, int h) {
		super(x, y, w, h);
		game=true;
		round=1;
		seq=1;
		this.x=x;
		this.y=y;
		update();
	}

	@Override
	public void gameOver() {
		game=false;
		update();

	}

	@Override
	public void setRound(int i) {
		round=i;
		update();
	}

	@Override
	public void setSequenceSize(int i) {
		seq=i;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		clear();
		if(game) {
			g.setColor(Color.black);
			g.drawString("Round: "+round, x, y);
			g.drawString("Sequence: "+seq,x, y+20);
		}else {
			g.setColor(Color.black);
			g.drawString("Game over", x, y);
		}

	}

}