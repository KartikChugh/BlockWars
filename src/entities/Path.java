package entities;

public class Path extends Tile {
	
	private static final String IMG_NAME = "imgs/white.png";

	public Path(int row, int col) {
		super(row, col, IMG_NAME);
	}
	
	@Override
	public boolean isWalkable() {
		return true; //TODO should be false usually
	}

}
