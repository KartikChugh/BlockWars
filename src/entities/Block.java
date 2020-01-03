package entities;

public abstract class Block extends Tile {
	
	private boolean moving = false;

	public Block(int row, int col, String imgName) {
		super(row, col, imgName);
	}
	
	public final void move(int newRow, int newCol) {
		row = newRow;
		col = newCol;
		recalculateCoords();
	}
	
	protected static String getImgName(String skinName, String shadeName) {
		return "imgs/" + skinName + "/" + shadeName + ".png";
	}

}
