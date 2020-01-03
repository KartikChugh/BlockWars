package teams;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import entities.Block;

public abstract class Team {
	
//	public enum PlayState {
//		WAIT, SELECT_BLOCK, SELECT_TARGET,
//	}
	
	//public PlayState playState = PlayState.WAIT;
	protected List<Block> blocks = new ArrayList<>();
	protected String skinName; // TODO useful?
	
	public Team(String skinName) {
		
		this.skinName = skinName;
		
	}
	
	public void draw(Graphics2D g2d) {
		blocks.forEach(b -> b.draw(g2d));		
	}
	
	//public abstract void beginTurn();
	
/*	public boolean handleClick(Point clickPoint) {
//		if (playState == PlayState.WAIT) {
//			return false;
//		}
		for (Block block : blocks) {
			if (block.isClicked(clickPoint)) {
				
				return true;
			}
		}
		return false;
	}*/
	
	public Block getClickedBlock(Point pt) {
		for (Block block : blocks) {
			if (block.isClicked(pt)) {
				return block;
			}
        }
		return null;
	}

}
