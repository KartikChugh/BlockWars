package main;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.*;

import entities.*;
import teams.*;

public final class GameManager {
	
	private final Tileset tileset;
	private List<Team> teams;
	private int turn;
	private Block selectedBlock;
	
	public GameManager(int rows, int cols) {
		
		selectedBlock = null;
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
	
		
		// Block selection
		if (selectedBlock == null) {			
			Optional<Block> optionalSelection = current.getClickedBlock(pt);
			if (optionalSelection.isPresent()) {
				selectBlock(optionalSelection.get());
			}
			return;
		}
		
		
		// Target block selection
		for (Team other : others) {
			Optional<Block> optionalSelection = other.getClickedBlock(pt);
			if (optionalSelection.isPresent()) {
				selectTargetBlock(optionalSelection.get());
				return;
			}
		}
		
		// Target tile selection
		Optional<Tile> optionalSelection = tileset.getClickedTile(pt);
		if (optionalSelection.isPresent()) {
			selectTargetTile(optionalSelection.get());
			return;
		}
	}
	
	private void selectBlock(Block selection) {
		System.out.println("Selected block: " + selection);
		
		selectedBlock = selection;
		//TODO markWalkablePaths();
	}
	
	private void selectTargetBlock(Block selection) {
		System.out.println("Selected target block: " + selection);
		
		nextTurn();
	}
	
	private void selectTargetTile(Tile selection) {
		System.out.println("Selected target tile: " + selection);
		
		if (selection.isWalkable()) {
			selectedBlock.move(selection.row, selection.col);
			nextTurn();
		}

	}
	
	private void nextTurn() {
		selectedBlock = null;
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
