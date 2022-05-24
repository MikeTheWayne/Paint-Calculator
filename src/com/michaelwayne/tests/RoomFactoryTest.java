package com.michaelwayne.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.michaelwayne.room.RoomFactory;
import com.michaelwayne.room.RoomType;

public class RoomFactoryTest {
	
	private RoomFactory roomFactory = new RoomFactory();

	@Test
	public void testRoomFactory_expectedValues_shouldInstantiateCorrectly() {
		List<Long> dimensions = Arrays.asList(4000L, 5000L, 20L);
		
		this.roomFactory.create(RoomType.CUBOID, dimensions);
	}
	
	@Test
	public void testRoomFactory_noRoomType_shouldInstantiateCorrectly() {
		List<Long> dimensions = Arrays.asList(4000L, 5000L, 20L);
		
		this.roomFactory.create(null, dimensions);
	}
	
	@Test
	public void testRoomFactory_emptyList_shouldInstantiateCorrectly() {
		List<Long> dimensions = Arrays.asList();
		
		this.roomFactory.create(RoomType.CUBOID, dimensions);
	}
	
	@Test
	public void testRoomFactory_nullValue_shouldThrow_IllegalArgumentException() {
		List<Long> dimensions = Arrays.asList(4000L, null, 20L);
		
		assertThrows(IllegalArgumentException.class,
				() -> this.roomFactory.create(RoomType.CUBOID, dimensions));
	}
	
	@Test
	public void testRoomFactory_nullArray_shouldThrow_IllegalArgumentException() {
		List<Long> dimensions = null;
		
		assertThrows(IllegalArgumentException.class,
				() -> this.roomFactory.create(RoomType.CUBOID, dimensions));
	}
	
	@Test
	public void testRoomFactory_negativeArgument_shouldThrow_IllegalArgumentException() {
		List<Long> dimensions = Arrays.asList(4000L, -5000L, 20L);
		
		assertThrows(IllegalArgumentException.class,
				() -> this.roomFactory.create(RoomType.CUBOID, dimensions));
	}
	
}
