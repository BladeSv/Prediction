package by.htp.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

public class BaseClient {
	List<Client> baseClient = new ArrayList<>();

	public List<Client> getBaseClint() {
		return baseClient;
	}

	public void setBaseClint(List<Client> baseClint) {
		this.baseClient = baseClint;
	}

	public void outBaseClient() {

		for (int i = 0; i < baseClient.size(); i++) {
			System.out.println("Index Client=" + (i + 1));
			System.out.println(baseClient.get(i));
		}
	}

	public void outHistoryPredictions() {

		boolean cheak = false;
		SimpleDateFormat sd = new SimpleDateFormat("dd.MM.yyyy");

		for (int i = 0; i < baseClient.size(); i++) {
			System.out.println("Index Client=" + (i + 1));
			System.out.println(baseClient.get(i));
		}
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		Client chooseClient = null;
		do {
			cheak = false;
			try {
				System.out.println("Enter index Client");

				ch = Integer.parseInt(sc.nextLine());
				chooseClient = baseClient.get(ch - 1);
			} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
				System.out.println("Incorect enter index, try again");

				cheak = true;
			}
		} while (cheak);

		if (!(chooseClient.getHistoryPredictions().isEmpty())) {

			for (Entry<Date, PredictionResult> s : chooseClient.getHistoryPredictions().entrySet()) {
				System.out.println("Date prediction= " + sd.format(s.getKey()));

				s.getValue().getPredictionResult().forEach(
						(k, l) -> System.out.println("prediction= " + k.getTarget() + ", answer= " + l.getAnswer()));

			}

		} else {
			System.out.println("History predictions this client empty");
		}

	}

}
