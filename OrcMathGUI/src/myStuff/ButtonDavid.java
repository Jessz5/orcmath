package myStuff;

import java.awt.Color;

import guiTeacher.Utilities;
import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonDavid extends Button implements ButtonInterfaceJessi {

	public ButtonDavid(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
	}

	@Override
	public void setColor(Color color) {
		setBackground(color);
	}

	@Override
	public void highlight() {
		Color gotColor = getBackgroundColor();
		setBackground(Utilities.lighten(gotColor, 50));
	}

	@Override
	public void dim() {
		Color gotColor = getBackgroundColor();
		setBackground(Utilities.lighten(gotColor, -50));
		
	}

}
