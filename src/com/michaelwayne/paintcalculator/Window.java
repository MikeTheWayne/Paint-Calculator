package com.michaelwayne.paintcalculator;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.michaelwayne.room.RoomType;

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
	
	private RoomType selectedRoomType = RoomType.CUBOID;
	
	private List<DimensionInputPanel> inputPanels;
	
	private JPanel inputDisplayPanel;
	
	public Window() {
		setupFrame();
		setupInput();
	}
	
	/**
	 * Sets up the JFrame
	 */
	private void setupFrame() {
		final String TITLE = "Paint Calculator by Michael Wayne";
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setTitle(TITLE);
		
		BoxLayout boxLayout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
		this.setLayout(boxLayout);
	}
	
	/**
	 * Creates a new panel for displaying the inputs
	 */
	private void setupInputDisplayPanel() {
		
		this.inputDisplayPanel = new JPanel();
		
		BoxLayout boxLayout = new BoxLayout(this.inputDisplayPanel, BoxLayout.Y_AXIS);
		this.inputDisplayPanel.setLayout(boxLayout);
		
		this.add(inputDisplayPanel);
		
	}
	
	/**
	 * Sets up the input fields
	 */
	private void setupInput() {
		
		// Setup input
		setupInputDisplayPanel();
		
		// Add panels for each individual dimension
		this.inputPanels = new ArrayList<DimensionInputPanel>();
		
		String[] names = this.selectedRoomType.getDimensionNames();
		
		for(int inputCount = 0; 
				inputCount < selectedRoomType.getDimensions(); 
				inputCount++) {
			DimensionInputPanel inputPanel = new DimensionInputPanel(names[inputCount]);
			
			// Add panel to list for getting input later
			this.inputPanels.add(inputPanel);
			// Add panel to screen
			this.inputDisplayPanel.add(inputPanel);
		}
	}
	
}
