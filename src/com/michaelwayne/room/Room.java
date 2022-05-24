package com.michaelwayne.room;

import java.util.List;

/**
 * Defines a template room object.
 * 
 * A room will always require its volume, floor area and wall area to 
 * be calculated. However, the dimensions of the room, and the formula
 * used for the calculation can vary depending on the type of room.
 * 
 * This class should not be a singleton, as in future the program
 * could be improved to calculate several rooms.
 * 
 * @author Michael
 * 
 */
public abstract class Room {
	
	/**
	 * Validates the input dimensions to protect child classes.
	 * 
	 * @param dimensions The dimensions of the room.
	 */
	public Room(List<Long> dimensions) throws IllegalArgumentException {
		
		// Check dimensions array is defined
		if(dimensions == null) {
			throw new IllegalArgumentException("Input dimensions array is not defined! (null array)");
		}
		
		// Loop through and check dimensions for invalid input
		for(Long dimension : dimensions) {
			if(dimension == null) {
				throw new IllegalArgumentException("One or more input dimensions are missing!");
			} else if(dimension < 0) {
				throw new IllegalArgumentException("One or more input dimensions is negative!");
			}
		}
		
	}
	
	/**
	 * Calculates the volume of the room.
	 * 
	 * @return The volume of the room.
	 */
	public abstract long calculateVolume();
	
	/**
	 * Calculates the floor area of the room.
	 * 
	 * @return The floor area of the room.
	 */
	public abstract long calculateFloorArea();
	
	/**
	 * Calculates the wall area of the room.
	 * 
	 * @return The wall area of the room.
	 */
	public abstract long calculateWallArea();

}
