package myStuff;

public class MoveJessi implements MoveInterfaceJessi {

	private ButtonInterfaceJessi button;
	
	public MoveJessi(ButtonInterfaceJessi bIndex) {
		this.button = bIndex;
	}

	@Override
	public ButtonInterfaceJessi getButton() {
		return button;
	}
}
