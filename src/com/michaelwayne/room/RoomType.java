package com.michaelwayne.room;

/**
 * Stores the types of implemented room. 
 * 
 * @author Michael
 * 
 */
public enum RoomType {
	// Common cuboid shaped room
	CUBOID(3, new String[] {"height", "width", "depth"});
	
	// The number of dimensions
	private int dimensions;
	// The names of each dimension, for display
	private String[] dimensionNames;

	RoomType(int dimensions, String[] dimensionNames) {
		this.dimensions = dimensions;
		this.dimensionNames = dimensionNames;
	}
	
	public int getDimensions() {
		return this.dimensions;
	}
	
	/**
	 * Ensures the number of dimension names matches the integer value.
	 * 
	 * If the number of Strings is less than the number of dimensions,
	 * default Strings are added in.
	 * 
	 * If the number of Strings is greater than the number of
	 * dimensions, the extra Strings are omitted.
	 * 
	 * This validation primarily avoids developer error.
	 * 
	 * @return A String array representing the names of each dimension.
	 */
	public String[] getDimensionNames() {
		// Create a new array with the correct length
		String[] outputNames = new String[this.dimensions];
		
		// Populate new array
		for(int stringIndex = 0; 
				stringIndex < outputNames.length; 
				stringIndex++) {
			if(this.dimensionNames == null 
					|| stringIndex >= this.dimensionNames.length) {
				// Dimension String not found, insert default value
				outputNames[stringIndex] = "dimension " + stringIndex;
			} else {
				// Map dimension string
				outputNames[stringIndex] = this.dimensionNames[stringIndex];
			}
		}
		
		return outputNames;
	}
}
