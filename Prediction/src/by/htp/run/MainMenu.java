package by.htp.run;

import java.util.Scanner;

import by.htp.entity.BaseClient;
import by.htp.entity.Client;
import by.htp.entity.FortuneTeller;
import by.htp.queue.MainQueue;
import by.htp.queue.WaitQueue;

public class MainMenu {

	public void mainMenu() {
		FortuneTeller fortuneTeller = new FortuneTeller();
		MainQueue mainQuety = new MainQueue();
		Run run = new Run();
		WaitQueue waitQuety = new WaitQueue();
		BaseClient baseClient = new BaseClient();
		int menu = 0;
		Scanner sc = new Scanner(System.in);

		do {
			try {
				System.out.println();
				System.out.println("Hello i'm predictor \"AHALAI MAHALAI\" ");
				System.out.println();

				System.out.println("1. Enter reception Date");
				System.out.println("---------------------------------------------------------------------");
				System.out.println("2. See all predictions");
				System.out.println("3. Add prediction and answers");
				System.out.println("4. See customer base");
				System.out.println("---------------------------------------------------------------------");
				System.out.println("5. See Client Base");
				System.out.println("6. Add new Client to MainQuety and client Base");
				System.out.println("7. Add from Client from Base to MainQuety, choose index of Client");
				System.out.println("8. See client history predictions");
				System.out.println("---------------------------------------------------------------------");
				System.out.println("9. Reception");
				System.out.println("---------------------------------------------------------------------");
				System.out.println("10. See clients in main queue");
				System.out.println("11. See clients in wait queue");
				System.out.println("12. Delete client from wait queue");
				System.out.println("---------------------------------------------------------------------");
				System.out.println("13. Exit");

				menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1:

					fortuneTeller.addAdmissionDate();
					mainQuety.getMainQueue().clear();
					waitQuety.getWaitQuety().clear();
					break;
				case 2:

					fortuneTeller.outPrediction();
					break;
				case 3:

					fortuneTeller.addPredections();
					break;
				case 4:

					fortuneTeller.outBaseProcessedClients();
					break;
				case 5:

					baseClient.outBaseClient();
					break;

				case 6:
					mainQuety.addMainQueue(Client.creatClient(baseClient), fortuneTeller);
					break;

				case 7:

					mainQuety.addMainQueue(Client.chooseClient(baseClient), fortuneTeller);

					break;
				case 8:

					fortuneTeller.outBaseProcessedClients();
					break;
				case 9:

					run.reception(mainQuety, fortuneTeller, waitQuety);
					break;

				case 10:

					mainQuety.outMainQueue();
					break;
				case 11:

					waitQuety.outWaitQueue();
					break;

				case 12:

					waitQuety.delWaitQueue();
					break;

				case 13:
					System.exit(0);
					break;
				default:
					System.out.println("Enter the number of the menu item");
					break;
				}
			} catch (java.lang.NumberFormatException e) {
				System.out.println("Incorrect enter format-Integer, try again");
			}

		} while (true);

	}

}
