package it.dstech.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import it.dstech.model.Item;
import it.dstech.service.ServiceItem;
import it.dstech.service.ServiceItemImpl;

public class TestClass {

	public static void main(String[] args) throws InterruptedException {

		ServiceItem service = new ServiceItemImpl();

		ArrayList<Item> stock = service.initializeStock();

		ArrayList<Item> myShoppingCart = new ArrayList<>();

		Scanner in = new Scanner(System.in);

		System.out.println("***BENVENUTO***");
		System.out.println("Cosa vuoi fare?");
		int scelta = 0;

		do {
			try {
				System.out.println("----------------");
				System.out.println("1 - Esegui test");
				System.out.println("2 - Vai al negozio");
				System.out.println("3 - Esci dal programma");

				scelta = in.nextInt();
				in.nextLine();

				switch (scelta) {

				case 1:
					System.out.println("********\n* TEST *\n********");
					service.printBasket(service.fillBasketOne());
					service.printBasket(service.fillBasketTwo());
					service.printBasket(service.fillBasketThree());
					break;

				case 2:
					int choose;
					do {
						System.out.println("----------------");
						System.out.println("1 - Seleziona gli articoli da aggiungere al carrello");
						System.out.println("2 - Vai al carrello");
						System.out.println("3 - Torna indietro");

						choose = in.nextInt();
						in.nextLine();

						switch (choose) {
						case 1:
							service.printStock(stock);
							System.out.println("----------------");
							System.out.println("Scegli l'articolo o premi 0 per tornare indietro");
							int a = in.nextInt();
							in.nextLine();
							if (a == 0)
								break;
							Item item = stock.get(a - 1);
							stock.remove(item);
							myShoppingCart.add(item);
							System.out.println(item.getName() + " è stato aggiunto al carrello!");
							break;

						case 2:
							if (myShoppingCart.isEmpty()) {
								System.out.println("Il carrello è vuoto!");
								break;
							}
							service.printBasket(myShoppingCart);
							System.out.println("1 - Continua con gli acquisti");
							System.out.println("2 - Vai al checkout");
							System.out.println("3 - Svuota carrello");
							int b = in.nextInt();
							in.nextLine();
							switch (b) {
							case 1:
								break;

							case 2:
								System.out.println("Vuoi procedere all'acquisto? s/n");
								String c = in.nextLine();
								if (c.equals("s".toLowerCase())) {
									System.out.println("Verrai reindirizzato al sito per il pagamento......");
									TimeUnit.SECONDS.sleep(5);
									System.out.println("----------------");
									System.out.println("Pagamento andato a buon fine! Grazie per averci visitato");
									TimeUnit.SECONDS.sleep(3);
									myShoppingCart.clear();
									stock.clear();
									stock = service.initializeStock();
									break;
								} else
									break;
							case 3:
								myShoppingCart.clear();
								stock.clear();
								stock = service.initializeStock();
								System.out.println("Il carrello è stato svuotato");
								break;
							default:
								System.out.println("Non hai effettuato un scelta valida!");
								break;
							}
							break;

						case 3:
							break;
						default:
							System.out.println("Non hai effettuato un scelta valida!");
							break;
						}
					} while (choose != 3);
					break;

				case 3:
					in.close();
					System.out.println("***GRAZIE PER AVER VISITATO IL NOSTRO STORE***");
					break;
				default:
					System.out.println("Non hai effettuato un scelta valida!");
					break;
				}
			} catch (Exception e) {
				System.out.println("Non hai effettuato un scelta valida!");
				in.nextLine();
			}
		} while (scelta != 3);

	}

}
