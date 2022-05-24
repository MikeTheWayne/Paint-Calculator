package com.michaelwayne.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.michaelwayne.paint.PaintRequirement;
import com.michaelwayne.room.Room;
import com.michaelwayne.room.RoomFactory;
import com.michaelwayne.room.RoomType;

public class PaintRequirementTest {
	
	private RoomFactory roomFactory = new RoomFactory();
	
	private List<Long> dimensions = Arrays.asList(4000L, 5000L, 20L);
	
	private Room room = roomFactory.create(RoomType.CUBOID, dimensions);
	
	@Test
	public void testPaintRequirement_expectedValues_shouldInstantiateCorrectly() {
		new PaintRequirement(5L, room);
	}
	
	@Test
	public void testPaintRequirement_negativePaintPerSquareMetre_shouldThrow_IllegalArgumentException() {
		assertThrows(IllegalArgumentException.class,
				() -> new PaintRequirement(-5L, room));
	}
	
	@Test
	public void testPaintRequirement_nullRoom_shouldThrow_IllegalArgumentException() {
		assertThrows(IllegalArgumentException.class,
				() -> new PaintRequirement(5L, null));
	}
	
	@Test
	public void testPaintRequirement_expectedValues_shouldCalculateCorrectly() {
		PaintRequirement paintRequirement = new PaintRequirement(5L, room);
		
		assertEquals(paintRequirement.calculate(), 200_800_000L);
	}
	
	@Test
	public void testPaintRequirement_zeroRoomValues_shouldCalculateCorrectly() {
		List<Long> dimensions = Arrays.asList(4000L, 5000L);
		
		Room room = roomFactory.create(RoomType.CUBOID, dimensions);
		
		PaintRequirement paintRequirement = new PaintRequirement(5L, room);
		
		assertEquals(paintRequirement.calculate(), 200_000_000L);
	}
	
}
