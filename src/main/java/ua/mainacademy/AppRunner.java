package ua.mainacademy;

import ua.mainacademy.model.Item;
import ua.mainacademy.service.ItemService;

import java.util.logging.Logger;

public class AppRunner {
	private static final Logger LOG = Logger.getLogger(AppRunner.class.getName());
	
	public static void main(String[] args) {
		
		Item item = new Item();
		item.setName("что");
		item.setCode(123456);
		item.setPrice(5);
		
		LOG.info(ItemService.create(item).toString());
		//ItemService.delete(7);
		//ItemService.update(8, "другое", 789789, 11);
		//LOG.info(ItemService.findItemById(8).toString());
		//LOG.info(ItemService.findItemByName("другое").toString());
	}
}
