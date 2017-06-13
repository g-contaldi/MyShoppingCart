package it.dstech.service;

import java.text.DecimalFormat;
import java.util.ArrayList;

import it.dstech.model.Item;

public class ServiceItemImpl implements ServiceItem {

	DecimalFormat df = new DecimalFormat("0.00");

	@Override
	public ArrayList<Item> initializeStock() {
		ArrayList<Item> listItems = new ArrayList<>();
		listItems.add(new Item(1, "Book", 12.49, false, false));
		listItems.add(new Item(1, "Music CD", 14.99, true, false));
		listItems.add(new Item(1, "Chocolate Bar", 0.85, false, false));
		listItems.add(new Item(1, "Imported box of chocolates", 10.00, false, true));
		listItems.add(new Item(1, "Imported bottle of perfume", 47.50, true, true));
		listItems.add(new Item(1, "Imported bottle of perfume", 27.99, true, true));
		listItems.add(new Item(1, "Bottle of perfume", 18.99, true, false));
		listItems.add(new Item(1, "Packet of headache pills", 9.75, false, false));
		listItems.add(new Item(1, "Box of imported chocolates ", 11.25, false, true));
		return listItems;
	}

	@Override
	public void printStock(ArrayList<Item> listItems) {
		int i = 1;
		for (Item item : listItems) {
			System.out.println(i + " - " + item);
			i++;
		}
	}

	@Override
	public ArrayList<Item> fillBasketOne() {
		ArrayList<Item> basketOne = new ArrayList<>();
		basketOne.add(new Item(1, "Book", 12.49, false, false));
		basketOne.add(new Item(1, "Music CD", 14.99, true, false));
		basketOne.add(new Item(1, "Chocolate Bar", 0.85, false, false));
		return basketOne;
	}

	@Override
	public ArrayList<Item> fillBasketTwo() {
		ArrayList<Item> basketTwo = new ArrayList<>();
		basketTwo.add(new Item(1, "Imported box of chocolates", 10.00, false, true));
		basketTwo.add(new Item(1, "Imported bottle of perfume", 47.50, true, true));
		return basketTwo;
	}

	@Override
	public ArrayList<Item> fillBasketThree() {
		ArrayList<Item> basketThree = new ArrayList<>();
		basketThree.add(new Item(1, "Imported bottle of perfume", 27.99, true, true));
		basketThree.add(new Item(1, "Bottle of perfume", 18.99, true, false));
		basketThree.add(new Item(1, "Packet of headache pills", 9.75, false, false));
		basketThree.add(new Item(1, "Box of imported chocolates ", 11.25, false, true));
		return basketThree;
	}

	@Override
	public void printBasket(ArrayList<Item> listItem) {
		double salesTax = 0;
		double total = 0;
		for (Item item : listItem) {
			System.out.println(item);
			if (item.isTaxed())
				salesTax += item.getSalesTax();
			if (item.isImported())
				salesTax += item.getImportTax();
			total += item.getPrice();
		}
		System.out.println("Sales Taxes: " + df.format(roundTax(salesTax)));
		System.out.println("Total: " + df.format(roundTotal(total)));
		System.out.println("***************");

	}

	@Override
	public double roundTax(double num) {
		return Math.round(num * 20) / 20.0;
	}

	@Override
	public double roundTotal(double num) {
		return Math.round(num * 100.0) / 100.0;
	}

}
