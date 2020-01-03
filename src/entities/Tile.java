package entities;

import java.awt.*;

import javax.swing.ImageIcon;

import main.BWPanel;

public abstract class Tile {
	
	public int row;
	public int col;
	
	private final int width = 48;
	private final int height = 48;
	private int x;
	private int y;
	private String imgName;
	
	public Tile(int row, int col, String imgName) {	
		this.row = row;
		this.col = col;
		recalculateCoords();
		this.imgName = imgName;
	}
	
	protected final void recalculateCoords() {
		this.x = (BWPanel.WIDTH - (width * BWPanel.COLS))/2 + width*col;
		this.y = (BWPanel.HEIGHT - (height * BWPanel.ROWS))/2 + height*row;
	}

	public final void draw(Graphics2D g2d) {
		
		final Image img = new ImageIcon(imgName).getImage();
		g2d.drawImage(img, x, y, null);
		
	}

	public final boolean isClicked(Point clickPoint) {
		boolean selected = new Rectangle(x, y, width, height).contains(clickPoint);
//		if (selected) {
//			handleSelection();
//		}
		return selected;
	}

	protected void handleSelection() {
		return; // do nothing by default
	}

}
