package com.michaelwayne.paint;

import com.michaelwayne.room.Room;

public class PaintRequirement {
	
	private long paintPerSquareMetre;
	private Room room;
	
	/**
	 * Sets the values required to calculate the paint requirement.
	 * 
	 * @param paintPerSquareMetre The amount of paint required per square metre.
	 * @param room A populated instance of a room implementation.
	 */
	public PaintRequirement(long paintPerSquareMetre, Room room) throws IllegalArgumentException {
		// Validate parameters
		if(paintPerSquareMetre < 0) {
			throw new IllegalArgumentException("Paint per square metre should not be negative!");
		} else if(room == null) {
			throw new IllegalArgumentException("Room cannot be null!");
		}
		
		// Set values
		this.paintPerSquareMetre = paintPerSquareMetre;
		this.room = room;
	}
	
	public long calculate() {
		// TODO Add calculation logic
		return 0;
	}
	
}
