package test;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class Test1 extends FullFunctionScreen {
	
	private Button win;
	private Button lose;
	private TextLabel msg;

	public Test1(int width, int height) {
		super(width,height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		win = new Button (50,50,50,50, "Win",Color.YELLOW, new Action() {
			
			@Override
			public void act() {
				msg = new TextLabel(150, 100, 300, 350, "You win");
				viewObjects.add(msg);
				lose.setEnabled(false);
				win.setEnabled(false);
				
			}
		});
		viewObjects.add(win);
		lose = new Button (50,150,50,50, "Lose",Color.GRAY, new Action() {
			
			@Override
			public void act() {
				msg = new TextLabel(150, 100, 300, 350, "You lost");
				viewObjects.add(msg);
				lose.setEnabled(false);
				win.setEnabled(false);
				
			}
		});
		viewObjects.add(lose);
	}

}
