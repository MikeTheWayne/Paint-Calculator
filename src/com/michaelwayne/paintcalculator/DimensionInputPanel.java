package com.michaelwayne.paintcalculator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A JPanel acting as an input field for a dimension.
 * 
 * @author Michael
 *
 */
public class DimensionInputPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabel dimensionLabel;
	private JTextField input;
	
	/**
	 * Sets up the JPanel, along with its components.
	 * 
	 * @param dimensionName The name of the dimension to be input.
	 */
	public DimensionInputPanel(String dimensionName) {
		// Ensure the dimensionName parameter isn't null
		if(dimensionName == null) {
			dimensionName = "";
		}
		
		final int MAX_INPUT_LENGTH = 18;
		
		this.dimensionLabel = new JLabel("Enter " + dimensionName);
		this.input = new JTextField(MAX_INPUT_LENGTH);
		
		this.add(dimensionLabel);
		this.add(input);
	}
	
	/**
	 * Gets and returns the user input from the text field.
	 * 
	 * @return The user input String.
	 */
	public String getInputText() {
		return this.input.getText();
	}

}
