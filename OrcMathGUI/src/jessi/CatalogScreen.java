package jessi;

import java.util.List;

import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {

	private TextField descriptionBox;
	private TextField name;
	private TextField price;
	
	public CatalogScreen(int width, int height) {
		super(width,height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		descriptionBox = new TextField(40,40,100,100, "H","L");
		viewObjects.add(descriptionBox);
		
		name = new TextField(120, 40, 100, 100, "");
		viewObjects.add(name);
		
		price = new TextField(120,120,100,100,"");
	}


}
