package teams;

import entities.Shooter;
import main.BWPanel;

public class CPU extends Team {
	
	public CPU() {
		super();
		blocks.add(new Shooter(1,BWPanel.COLS-1));
	}

}
