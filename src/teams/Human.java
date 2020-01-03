package teams;

import entities.Shooter;
import main.BWPanel;

public class Human extends Team {
	
	public Human(String skinName) {
		super(skinName);
		blocks.add(new Shooter(BWPanel.ROWS-2, 1, skinName)); // TODO replace
	}
	
/*	@Override
	public void beginTurn() {
		
	}*/

}
