package com.michaelwayne.room;

import java.util.List;

/**
 * Contains factory methods for creating room objects.
 * 
 * @author Michael
 *
 */
public class RoomFactory {

	/**
	 * Creates a room object based on the type of room requested.
	 * 
	 * The default room is a CuboidRoom type.
	 * 
	 * @param roomType The type of room to create.
	 * @param dimensions The input dimensions for the room.
	 * @return A room object.
	 */
	public Room create(RoomType roomType, List<Long> dimensions) {
		switch(roomType) {
		case CUBOID:
			return new CuboidRoom(dimensions);
		default:
			return new CuboidRoom(dimensions);
		}
	}
	
}
