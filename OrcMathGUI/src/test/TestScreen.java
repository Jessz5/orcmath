package test;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;



public class TestScreen extends FullFunctionScreen {

	private TextLabel displayScore;
	private TextLabel displayTime;
	private Button button;
	private int start;
	private int countDown;
	private int count;
	private Timer timer;
	
	public TestScreen(int width, int height) {
		super(width, height);
		count = 0;
		start = 4;
		countDown = 6;
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		displayScore = new TextLabel(20, 20, 150, 200, "Score: 0"); 
		viewObjects.add(displayScore);
		displayTime = new TextLabel(20, 20, 150, 300, "Time: ");
		viewObjects.add(displayTime);
		timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				start --;
				if(start == 0) {
					displayScore.setText("Go!");
					button.setText("Click Me");
				}else if(start > 0) {
					displayScore.setText(""+start);
				}
				if(start <= 0) {
					countDown --;
					displayTime.setText("Time left: " +countDown);
					if(countDown == 0) {
						button.setText("Done");
						button.setEnabled(false);
						timer.cancel();
					}
				}
				
			}
		};
		button = new Button(100, 300, 100, 100, "Ready", new Action() {
			
			@Override
			public void act() {
				if(start <= 0) {
					count++;
					displayScore.setText("Score: "+count);
				}else {
					timer.schedule(task, 0, 1000);
				}
				
			}
		});
		
		viewObjects.add(button);

	}

}