package entities;

public class Shooter extends Block {
	
	private static final String SHADE_NAME = "med";

	public Shooter(int row, int col, String skinName) {
		super(row, col, getImgName(skinName, SHADE_NAME));
	}

	

}
