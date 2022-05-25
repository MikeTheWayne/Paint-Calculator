package com.michaelwayne.paintcalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import com.michaelwayne.paint.PaintRequirement;
import com.michaelwayne.room.Room;
import com.michaelwayne.room.RoomFactory;
import com.michaelwayne.room.RoomType;

/**
 * Triggers the calculation upon a user action.
 * 
 * In this case, it will be called by a button press.
 * 
 * @author Michael
 *
 */
public class CalculateActionListener implements ActionListener {
	
	private List<DimensionInputPanel> inputPanels;
	private DimensionInputPanel paintInputPanel;
	private RoomType roomType;
	private Window window;
	
	private RoomFactory roomFactory;
	
	public CalculateActionListener(List<DimensionInputPanel> inputPanels,
			DimensionInputPanel paintInputPanel,
			RoomType roomType,
			Window window) {
		// Check for null parameters, set default values if so
		if(inputPanels == null) {
			this.inputPanels = new ArrayList<DimensionInputPanel>();
		} else {
			this.inputPanels = inputPanels;
		}
		
		if(paintInputPanel == null) {
			this.paintInputPanel = new DimensionInputPanel("");
		} else {
			this.paintInputPanel = paintInputPanel;
		}
		
		// Assign values
		this.roomType = roomType;
		this.window = window;
		
		this.roomFactory = new RoomFactory();
	}

	/**
	 * Handles a button press.
	 * 
	 * Reads the input, performs the calculations, then outputs the
	 * results.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Get input
		List<Long> dimensions = this.getDimensionsFromInput();
		long paint = this.sanitiseInput(this.paintInputPanel.getInputText());
		
		// Perform calculation
		Room room = roomFactory.create(this.roomType, dimensions);
		PaintRequirement paintRequirement = new PaintRequirement(paint, room);	
		
		// Display calculation
		this.window.setVolume(room.calculateVolume());
		this.window.setFloorArea(room.calculateFloorArea());
		this.window.setPaintAmount(paintRequirement.calculate());
	}
	
	/**
	 * Loops through input panels, sanitises, and validates user input
	 * 
	 * @return A list of input dimensions, as longs.
	 */
	private List<Long> getDimensionsFromInput() {
		List<Long> dimensions = new ArrayList<Long>();
		
		for(DimensionInputPanel inputPanel : this.inputPanels) {
			// Read in input, replace decimal points (this will need to be improved in future)
			String input = inputPanel.getInputText();
			
			long dimension = this.sanitiseInput(input);
			
			dimensions.add(dimension);
		}
		
		return dimensions;
	}
	
	/**
	 * Attempts to sanitise input and return a long.
	 * 
	 * @param input The input to sanitise.
	 * @return A long value from the input, or 0 if unsuccessful.
	 */
	private long sanitiseInput(String input) {
		if(input == null) {
			return 0;
		}
		
		long output = 0;
		
		try {
			output = Long.parseLong(input.replace(".", ""));
		} catch (NumberFormatException ex) {
			// Simulated log output (in future this will be displayed to the user instead of logged)
			System.out.println("Failed to process input.");
		}
		
		return output;
	}

}
