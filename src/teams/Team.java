package teams;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import entities.Block;
import entities.Shooter;
import main.BWPanel;

public abstract class Team {
	
	protected List<Block> blocks = new ArrayList<>();
	
/*	public Team() {
		
		
		
	}*/
	
	public void draw(Graphics2D g2d) {
		
		blocks.forEach(b -> b.draw(g2d));		
		
	}

}
