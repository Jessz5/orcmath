package myStuff;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreen extends ClickableScreen implements Runnable {
	
	private TextLabel label;
	private ButtonInterface[] buttons;
	private ProgressInterface progress;
	private ArrayList<MoveInterface> seq;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;

	public SimonScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterface b: buttons) {
			viewObjects.add(b);
		}
		progress = (ProgressInterface) getProcess();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		seq = new ArrayList<MoveInterface>();
		//add 2 moves to start
		lastSelectedButton = -1;
		seq.add(randomMove());
		seq.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
		
	}
	
	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterface getProcess() {
		// TODO Auto-generated method stub
		return null;
	}

	private MoveInterface randomMove() {
		int bIndex = (int)(Math.random()*buttons.length);
		while(bIndex == lastSelectedButton) {
			bIndex = (int)(Math.random()*buttons.length);
		}
		return getMove(bIndex);
	}


	/**
	Placeholder until partner finishes implementation of MoveInterface
	*/
	private MoveInterface getMove(int bIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	private void addButtons() {
		int numberOfButtons = 6;
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
