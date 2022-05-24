package com.michaelwayne.tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.michaelwayne.room.Room;
import com.michaelwayne.room.RoomFactory;
import com.michaelwayne.room.RoomType;

public class CuboidRoomTest {

	private RoomFactory roomFactory = new RoomFactory();
	
	List<Long> dimensions1 = Arrays.asList(4000L, 5000L, 20L);
	List<Long> dimensions2 = Arrays.asList(2000L, 300L, 90000L);
	
	Room room1 = roomFactory.create(RoomType.CUBOID, dimensions1);
	Room room2 = roomFactory.create(RoomType.CUBOID, dimensions2);
	
	@Test
	public void testCuboidRoom_expectedValues_shouldCalculateVolumeCorrectly() {
		assertEquals(room1.calculateVolume(), 400_000_000L);
		assertEquals(room2.calculateVolume(), 54_000_000_000L);
	}
	
	@Test
	public void testCuboidRoom_expectedValues_shouldCalculateFloorAreaCorrectly() {
		assertEquals(room1.calculateFloorArea(), 100_000L);
		assertEquals(room2.calculateFloorArea(), 27_000_000L);
	}
	
	@Test
	public void testCuboidRoom_expectedValues_shouldCalculateWallAreaCorrectly() {
		assertEquals(room1.calculateWallArea(), 40_160_000);
		assertEquals(room2.calculateWallArea(), 361_200_000L);
	}
	
	@Test
	public void testCuboidRoom_notEnoughValues_shouldCalculatAllValuesZero() {
		List<Long> dimensions = Arrays.asList(4000L, 5000L);
		
		Room room = roomFactory.create(RoomType.CUBOID, dimensions);
		
		assertEquals(room.calculateVolume(), 0);
		assertEquals(room.calculateFloorArea(), 0);
		assertEquals(room.calculateWallArea(), 0);
	}
	
}
