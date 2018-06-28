package by.htp.entity;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Client implements Comparable<Client> {
	private int id = 0;

	private String name;
	private Date date = new Date(0);
	private Date dateEnterQueue;
	TreeMap<Date, PredictionResult> HistoryPredictions = new TreeMap<>();

	public Date getDateEnterQueue() {
		return dateEnterQueue;
	}

	public void setDateEnterQueue(Date dateEnterQueue) {
		this.dateEnterQueue = dateEnterQueue;
	}

	private static boolean cheak = false;
	private Predection targetPrediction;

	public Predection getTargetPrediction() {
		return targetPrediction;
	}

	public void setTargetPrediction(Predection targetPrediction) {
		this.targetPrediction = targetPrediction;
	}

	public int getId() {
		return id++;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TreeMap<Date, PredictionResult> getHistoryPredictions() {
		return HistoryPredictions;
	}

	public void setHistoryPredictions(TreeMap<Date, PredictionResult> historyPredictions) {
		HistoryPredictions = historyPredictions;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static Client creatClient(BaseClient baseClient) {
		Client client = new Client();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter name Client");
		client.setName(sc.nextLine());
		System.out.println("Enter Client prediction target");
		Predection temp = new Predection();
		temp.setTarget(sc.nextLine());
		client.targetPrediction = temp;

		baseClient.getBaseClint().add(client);

		return client;
	}

	public static Client chooseClient(BaseClient baseClient) {
		if (!(baseClient.getBaseClint().isEmpty())) {

			int ch = 0;
			for (int i = 0; i < baseClient.getBaseClint().size(); i++) {
				System.out.println("Index Client=" + (i + 1));
				System.out.println(baseClient.getBaseClint().get(i));

			}
			Client chooseClient = null;
			Scanner sc = new Scanner(System.in);
			do {
				cheak = false;
				try {
					System.out.println("Enter index Client");

					ch = Integer.parseInt(sc.nextLine());
					chooseClient = baseClient.getBaseClint().get(ch - 1);
				} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
					System.out.println("Incorect enter index, try again");

					cheak = true;
				}
			} while (cheak);

			return chooseClient;
		} else {
			System.out.println("Client Base Empty");
			return null;
		}

	}

	@Override
	public int compareTo(Client o) {

		return (int) (this.dateEnterQueue.getTime() - o.getDateEnterQueue().getTime());
	}

	@Override
	public String toString() {
		SimpleDateFormat sd = new SimpleDateFormat("dd.MM.yyyy");
		return "Name Client= " + name + ", Date of last prediction= "
				+ (date.equals(new Date(0)) ? "never" : sd.format(date)) + ", Interesting prediction= "
				+ targetPrediction.getTarget();
	}
}
