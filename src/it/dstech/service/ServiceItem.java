package it.dstech.service;

import java.util.ArrayList;

import it.dstech.model.Item;

public interface ServiceItem {

	ArrayList<Item> initializeStock();

	void printStock(ArrayList<Item> listItems);

	ArrayList<Item> fillBasketOne();

	ArrayList<Item> fillBasketTwo();

	ArrayList<Item> fillBasketThree();

	void printBasket(ArrayList<Item> listItem);

	double roundTax(double num);

	double roundTotal(double num);

}
