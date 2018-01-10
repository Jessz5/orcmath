package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonJessi extends Button implements ButtonInterfaceJessi {

	private Color color;
	private boolean highlighted;
	private int x;
	private int y;

	public ButtonJessi(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, "", action);
		this.x=x;
		this.y=y;
		highlighted=false;
		update();
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		if(highlighted) {
			g.setColor(Color.black);
			g.fillRect(x,y,getWidth(),getHeight());
		}else {
			g.setColor(color);
			g.fillRect(x,y,getWidth(),getHeight());
		}
	}

	@Override
	public void setColor(Color color) {
		this.color=color;
		update();
	}

	@Override
	public void highlight() {
		highlighted=true;
		update();
	}

	@Override
	public void dim() {
		highlighted=false;
		update();
	}
}