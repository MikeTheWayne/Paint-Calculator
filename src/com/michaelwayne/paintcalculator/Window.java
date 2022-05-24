package com.michaelwayne.paintcalculator;

import javax.swing.JFrame;

/**
 * JFrame for displaying Swing components.
 * 
 * These components will be used to get user input, allow them to
 * initiate calculations, and view the program's output.
 * 
 * @author Michael
 *
 */
public class Window extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private static final int WINDOW_WIDTH = 720;
	private static final int WINDOW_HEIGHT = 480;
	
	public Window() {
		setupFrame();
	}
	
	/**
	 * Sets up the JFrame
	 */
	private void setupFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	
}
