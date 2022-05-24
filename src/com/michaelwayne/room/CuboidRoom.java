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
	 * Sets the three dimension parameters for the room.
	 * 
	 * Assumes the room is a regular cuboid.
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

	@Override
	public long calculateVolume() {
		// TODO Implement calculation
		return 0;
	}

	@Override
	public long calculateFloorArea() {
		// TODO Implement calculation
		return 0;
	}

	@Override
	public long calculateWallArea() {
		// TODO Implement calculation
		return 0;
	}
	
}
