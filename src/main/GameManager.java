package main;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import entities.*;
import teams.*;

public final class GameManager {
	
	private final Tileset tileset;
	private List<Team> teams;
	private int turn;
	private boolean selectedBlock;
	private Block selection;
	
	public GameManager(int rows, int cols) {
		
		selection = null;
		selectedBlock = false;
		turn = 0;
		
		tileset = new Tileset(rows, cols);
		tileset.initialize();
		teams = new ArrayList<>();
		teams.add(new Human("red"));
		teams.add(new CPU("blue"));
	}
	
	public void handleClick(Point pt) {
		
		final Team current = teams.get(turn);
		final List<Team> others = new ArrayList<>(teams);
		others.remove(turn);
		
		//System.out.println("Current team: " + current);
		//System.out.println("Other teams: " + others);
		
		Tile potentialSelection;
		
		// Block selection
		if (!selectedBlock) {			
			potentialSelection = current.getClickedBlock(pt);
			if (potentialSelection != null) {
				System.out.println("Selected block: " + potentialSelection);
				selection = (Block) potentialSelection;
				selectedBlock = true;
			}
			return;
		}
		
		
		
		// Target block selection
		for (Team other : others) {
			potentialSelection = other.getClickedBlock(pt);
			if (potentialSelection != null) {
				System.out.println("Selected target block: " + potentialSelection);
				selectedBlock = false;
				nextTurn();
				return;
			}
		}
		
		// Target tile selection
		potentialSelection = tileset.getClickedTile(pt);
		if (potentialSelection != null) {
			System.out.println("Selected target tile: " + potentialSelection);
			selection.move(potentialSelection.row, potentialSelection.col);
			selectedBlock = false;
			nextTurn();
			return;
		}
		
		
	}
	
	private void nextTurn() {
		turn++;
		turn %= teams.size();
	}

	public void draw(Graphics2D g2d) {
		tileset.draw(g2d);
		for (Team team : teams) {
			team.draw(g2d);
		}
		
	}

}
