package com.michaelwayne.room;

import java.util.ArrayList;
import java.util.List;

/**
 * A type of room which takes the shape of a uniform cuboid.
 * 
 * @author Michael
 *
 */
public class CuboidRoom extends Room {

	private long height;
	private long width;
	private long depth;
	
	/**
	 * Validates and sets the three dimension parameters for the room.
	 * 
	 * If too few dimensions have been passed into the constructor,
	 * default values of zero are set.
	 * 
	 * @param height The height of the room.
	 * @param width The width of the room.
	 * @param depth The depth of the room.
	 */
	public CuboidRoom(List<Long> dimensions) {
		super(dimensions);

		final int MIN_DIMENSIONS = 3;
		final long DEFAULT_VALUE = 0L;
		
		// Validate list is of correct type to have values added
		if(dimensions.size() < MIN_DIMENSIONS
				&& dimensions instanceof ArrayList == false) {
			ArrayList<Long> arrayDimensions = new ArrayList<Long>();
			arrayDimensions.addAll(dimensions);
			
			dimensions = arrayDimensions;
		}

		// Add in default dimensions if too few have been provided
		for(int dimensionCount = dimensions.size();
				dimensionCount < MIN_DIMENSIONS;
				dimensionCount++) {
			dimensions.add(DEFAULT_VALUE);
		}
		
		// Assign values from first three items in the dimensions input
		final int HEIGHT_INDEX = 0;
		final int WIDTH_INDEX = 1;
		final int DEPTH_INDEX = 2;
		
		this.height = dimensions.get(HEIGHT_INDEX);
		this.width = dimensions.get(WIDTH_INDEX);
		this.depth = dimensions.get(DEPTH_INDEX);
	}

	/**
	 * Calculates the volume of the room.
	 * 
	 * @return The volume of the room.
	 */
	@Override
	public long calculateVolume() {
		return height * width * depth;
	}

	/**
	 * Calculates the floor area of the room.
	 * 
	 * @return The floor area of the room.
	 */
	@Override
	public long calculateFloorArea() {
		return width * depth;
	}

	/**
	 * Calculates the area of all walls in the room.
	 * 
	 * Works out the area of the width wall and the depth wall, then
	 * multiplies the result by two, as both walls will have an
	 * identical twin in a cuboid.
	 * 
	 * @return The area of all walls in the room.
	 */
	@Override
	public long calculateWallArea() {
		final int IDENTICAL_WALLS = 2;
		
		return IDENTICAL_WALLS * height * (width + depth);
	}
	
}
