package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.swing.JPanel;
import javax.swing.Timer;

import entities.Barrier;
import entities.Block;
import entities.Path;
import entities.Tile;
import entities.Tileset;
import teams.CPU;
import teams.Human;
import teams.Team;
import teams.Team.PlayState;

public final class BWPanel extends JPanel {
	
	public static final int WIDTH = 700;
    public static final int HEIGHT = 700;
    private static final int TPS_DESIRED = 100;
    public static final int ROWS = 11;
    public static final int COLS = 11;
    
    private final Timer timer; 
    private final Tileset tileset;
    private Team team1, team2;
    
	
	BWPanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
        //setBackground(Color.WHITE);
        addMouseListener(new aMouseListener());
        
        
        
        tileset = new Tileset(ROWS, COLS);
        timer = new Timer(1000/TPS_DESIRED, this::tick);
        
        init();
        timer.start();
	}
	
	private void init() {
		tileset.initialize();
		team1 = new Human("red");
        team2 = new CPU("blue");
        team1.playState = PlayState.SELECT_BLOCK;
	}

	private void tick(ActionEvent e) {
		repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2d = (Graphics2D) g;
        
        tileset.draw(g2d);        
        team1.draw(g2d);
        team2.draw(g2d);
    }
    
    private class aMouseListener extends MouseAdapter {
    	
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		final Point clickPoint = e.getPoint();
    		
    		Block block;
    		if ((block = team1.getClickedBlock(clickPoint)) == null) {
    			block = team2.getClickedBlock(clickPoint);
    		}
/*    		if (tile == null) {
    			tile = tileset.getClickedTile(clickPoint);
    		}*/
    		
    		System.out.println(block);
    		
    	}
    	
    }

}
