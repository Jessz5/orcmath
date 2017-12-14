package jessi;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class Pac extends Component {

	public Pac(int x, int y, int w, int h) {
		super(40, 40, 100, 140);

	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.blue);
		g.drawRect(0, 0, getWidth(), getHeight());
	}

}
