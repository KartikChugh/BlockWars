package entities;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import main.BWPanel;

public abstract class Tile {
	
	//private int row;
	//private int col;
	
	private int width = 48;
	private int height = 48;
	private int x;
	private int y;
	
	private String imgName;
	
	public Tile(int row, int col, String imgName) {
		
		int tilesWidth = width * BWPanel.COLS;
		int widthRemaining = BWPanel.WIDTH - tilesWidth;
		int xStart = widthRemaining/2;
		
		this.x = xStart + width*col;
		this.y = (BWPanel.HEIGHT - (height * BWPanel.ROWS))/2 + height*row;
		
		this.imgName = imgName;
	}

	public void draw(Graphics2D g2d) {
		
		final Image img = new ImageIcon(imgName).getImage();
		g2d.drawImage(img, x, y, null);
		
		
	}

}
