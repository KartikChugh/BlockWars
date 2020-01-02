package teams;

import entities.Shooter;
import main.BWPanel;

public class Human extends Team {
	
	public Human() {
		super();
		blocks.add(new Shooter(BWPanel.ROWS-2,1)); // TODO replace
	}

}
