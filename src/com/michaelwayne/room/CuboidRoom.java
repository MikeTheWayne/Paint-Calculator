package com.michaelwayne.room;

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

		// TODO Deal with out of bounds issues (not enough dimensions provided)
		
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
