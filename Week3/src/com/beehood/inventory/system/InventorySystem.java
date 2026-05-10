package com.beehood.inventory.system;

import java.util.HashMap;

import com.beehood.inventory.model.Item;

public class InventorySystem {

	private HashMap<Integer, Item> map = new HashMap<>();

	public void add(int id, String name, double price, int quantity) {

		map.put(id, new Item(id, name, price, quantity));
		System.out.println("Item added.");
	}

	public boolean exists(int id) {
		return map.containsKey(id);
	}

	public void view() {

		if (map.isEmpty()) {
			System.out.println("No items found.");
			return;
		}

		for (Item i : map.values()) {
			System.out.println(i);
		}
	}

	public void search(int id) {

		Item i = map.get(id);

		if (i != null) {
			System.out.println("Found: " + i);
		} else {
			System.out.println("Item not found.");
		}
	}

	public void update(int id, String name, double price, int quantity) {

		Item i = map.get(id);

		if (i == null) {
			System.out.println("Item not found.");
			return;
		}

		i.setName(name);
		i.setPrice(price);
		i.setQuantity(quantity);
		System.out.println("Updated successfully.");
	}

	public void delete(int id) {

		if (map.remove(id) != null) {
			System.out.println("Deleted successfully.");
		} else {
			System.out.println("Item not found.");
		}
	}

}