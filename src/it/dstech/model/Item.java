package it.dstech.model;

import java.text.DecimalFormat;

public class Item {

	private int qty;

	private String name;

	private double price;

	private boolean taxed;

	private double salesTax;

	private boolean imported;

	private double importTax;

	public Item(int qty, String name, double price, boolean taxed, boolean imported) {
		this.qty = qty;
		this.name = name;
		this.price = price;
		this.taxed = taxed;
		if (taxed == true) {
			this.salesTax = (price / 100) * 10;
			this.price += roundTax(this.salesTax);
		}
		this.imported = imported;
		if (imported == true) {
			this.importTax = (price / 100) * 5;
			this.price += roundTax(this.importTax);
		}
	}

	private double roundTax(double num) {
		return Math.round(num * 20) / 20.0;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isTaxed() {
		return taxed;
	}

	public void setTaxed(boolean taxed) {
		this.taxed = taxed;
	}

	public double getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(double salesTax) {
		this.salesTax = salesTax;
	}

	public boolean isImported() {
		return imported;
	}

	public void setImported(boolean imported) {
		this.imported = imported;
	}

	public double getImportTax() {
		return importTax;
	}

	public void setImportTax(double importTax) {
		this.importTax = importTax;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		return qty + "x " + name + ": " + df.format(price);
	}

}
