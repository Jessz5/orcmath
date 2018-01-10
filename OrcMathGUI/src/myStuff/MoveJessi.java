package myStuff;

public class MoveJessi implements MoveInterfaceJessi {

	private ButtonInterfaceJessi button;
	
	public MoveJessi(ButtonInterfaceJessi button) {
		this.button = button;
	}

	@Override
	public ButtonInterfaceJessi getButton() {
		return button;
	}
}
