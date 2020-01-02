package teams;

import entities.Shooter;
import main.BWPanel;

public class CPU extends Team {
	
	public CPU(String skinName) {
		super(skinName);
		blocks.add(new Shooter(1, BWPanel.COLS-1, skinName));
	}
	
	@Override
	public void beginTurn() {
		System.out.println("CPU finished its turn.");
	}

}
