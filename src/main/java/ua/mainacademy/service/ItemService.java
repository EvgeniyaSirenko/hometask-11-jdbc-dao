package ua.mainacademy.service;

import ua.mainacademy.dao.ItemDAO;
import ua.mainacademy.model.Item;

import java.util.List;
import java.util.Optional;

public class ItemService {
	public static Optional<Item> findItemById(Integer id) {
		return ItemDAO.findItemById(id);
	}
	
	public static Item create(Item item) {
		return ItemDAO.create(item);
	}
	
	public static Item update(Item item) {
		return ItemDAO.update(item);
	}
	
	public static List<Item> findByName(String name) {
		return ItemDAO.findItemByName(name);
	}
	
	public static void delete(Integer id) {
		ItemDAO.delete(id);
	}
	
}
