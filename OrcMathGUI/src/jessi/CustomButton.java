package jessi;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class CustomButton extends Button {
	
	private String s1;
	private String s2;
	private Color color;

	public CustomButton(int x, int y) {
		super(x, y, 40, 80, "", null);
	}
	
	public void drawButton(Graphics2D g, boolean hover){
		g.setColor(Color.black);
		g.drawString(s1, 40, 40);
		g.drawString(s2, 60, 40);
		
		g.setColor(color);
		g.drawRect(80, 40, 100, 150);
		
	}
	
	public void updateString1(String string){
		s1 = string;
	}

	public void updateString2(String string){
		s2 = string;
	}

	public void setIconColor(Color color){
		this.color = color;
	}

}