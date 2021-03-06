package entities;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.*;

public final class Tileset {
	
	private final Tile[][] tiles;
	private final int m, n;
	
	// TODO replace
    private final String[] barrierPositions = {"1,1","1,2","1,3","2,1","5,9","5,10","6,8","6,9","6,10","7,4","8,4"};
	
	public Tileset(int rows, int cols) {
		tiles = new Tile[rows][cols];	
		m = rows;
		n = cols;
	}

	public void initialize() {
		
		final List<String> barrierPositionsList = Arrays.asList(barrierPositions);
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				
				tiles[i][j] = new Path(i, j);
				
				if (barrierPositionsList.contains(i + "," + j)) {
					tiles[i][j] = new Barrier(i, j);
				}
			}
		}
		
	}
	
	public void draw(Graphics2D g2d) {
		for (Tile[] row : tiles) {
        	for (Tile tile : row) {
        		tile.draw(g2d);
        	}
        }
	}

	public Optional<Tile> getClickedTile(Point pt) {
		for (Tile[] row : tiles) {
        	for (Tile tile : row) {
        		if (tile.isClicked(pt)) {
        			return Optional.of(tile);
        		}
        	}
        }
		return Optional.empty();
	}	

}
