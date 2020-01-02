package main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public final class BlockWars {
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(BlockWars::initFrame);
    }

    private static void initFrame() {

        final JFrame frame = new JFrame("Block Wars");
        frame.getContentPane().add(new BWPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

    }

}
