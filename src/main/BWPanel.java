package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

import entities.Barrier;
import entities.Path;
import entities.Tile;

public final class BWPanel extends JPanel {
	
	public static final int WIDTH = 700;
    public static final int HEIGHT = 700;
    private static final int TPS_DESIRED = 100;
    public static final int ROWS = 11;
    public static final int COLS = 11;
    
    private final Timer timer; 
    private final Tile[][] tiles;
    
    // temporary
    private final String[] barrierPositions = {"1,1","1,2","1,3","2,1","5,9","5,10","6,8","6,9","6,10","7,4","8,4"};
	
	BWPanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);

        tiles = new Tile[ROWS][COLS];	
        timer = new Timer(1000/TPS_DESIRED, this::tick);
        
        init();
        timer.start();
	}
	
	private void init() {
		
		final List<String> barrierPositionsList = Arrays.asList(barrierPositions);
		
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				
				tiles[i][j] = new Path(i, j);
				
				if (barrierPositionsList.contains(i + "," + j)) {
					tiles[i][j] = new Barrier(i, j);
				}
				
			}
			
		}
		
	}

	private void tick(ActionEvent e) {
		repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				tiles[i][j].draw(g2d);
			}
		}
    }

}
