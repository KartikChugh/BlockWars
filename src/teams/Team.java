package teams;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import entities.Block;
import entities.Shooter;
import main.BWPanel;

public abstract class Team {
	
	protected List<Block> blocks = new ArrayList<>();
	protected String skinName; // TODO useful?
	
	public Team(String skinName) {
		
		this.skinName = skinName;
		
	}
	
	public void draw(Graphics2D g2d) {
		blocks.forEach(b -> b.draw(g2d));		
	}
	
	public abstract void beginTurn();

}
