package ua.mainacademy.dao;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.mainacademy.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


class ItemDAOTest {
	
	private static List<Item> items;
	
	@BeforeAll
	public static void setData() {
		items = new ArrayList<>();
	}
	
	@AfterAll
	public static void deleteData() {
		items.forEach(item -> ItemDAO.delete(item.getId()));
	}
	
	
	@Test
	void findItemById() {
		Item testItem = Item.builder()
				.name("testName")
				.code(111111)
				.price(11)
				.build();
		Item savedItem = ItemDAO.create(testItem);
		items.add(savedItem);
		Optional<Item> foundItem = ItemDAO.findItemById(savedItem.getId());
		assertTrue(foundItem.isPresent());
	}
	
	@Test
	void create() {
		Item testItem = Item.builder()
				.name("testName")
				.code(111111)
				.price(11)
				.build();
		Item createdItem = ItemDAO.create(testItem);
		items.add(createdItem);
		assertNotNull(createdItem.getId());
		assertEquals(testItem.getName(), createdItem.getName());
	}
	
	@Test
	void update() {
		Item testItem = Item.builder()
				.name("testName")
				.code(111111)
				.price(5)
				.build();
		Item savedItem = ItemDAO.create(testItem);
		Item readyForUpdate = Item.builder()
				.id(savedItem.getId())
				.name("updatedName")
				.code(111222)
				.price(6)
				.build();
		Item updatedItem = ItemDAO.update(readyForUpdate);
		items.add(updatedItem);
		Optional<Item> foundItem = ItemDAO.findItemById(updatedItem.getId());
		if (foundItem.isPresent()) {
			assertNotEquals(savedItem.getName(), foundItem.get().getName());
			assertEquals(savedItem.getId(), foundItem.get().getId());
		} else {
			fail("Updated item was not found");
		}
	}
	
	@Test
	void delete() {
		Item testItem = Item.builder()
				.name("testName")
				.code(111111)
				.price(5)
				.id(100)
				.build();
		Item savedItem = ItemDAO.create(testItem);
		Optional<Item> foundItem = ItemDAO.findItemById(savedItem.getId());
		assertTrue(foundItem.isPresent());
		ItemDAO.delete(savedItem.getId());
		foundItem = ItemDAO.findItemById(savedItem.getId());
		assertFalse(foundItem.isPresent());
	}
}