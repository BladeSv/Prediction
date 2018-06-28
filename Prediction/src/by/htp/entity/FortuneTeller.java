package by.htp.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;

public class FortuneTeller {
	private int scorePrediction = 0;
	Map<Date, Client> BaseProcessedClients = new HashMap<>();
	LinkedHashMap<Predection, Queue<Answer>> Predections = new LinkedHashMap<>();
	private Date admissionDate = new Date();

	public int getScorePrediction() {
		return scorePrediction;
	}

	public void setScorePrediction(int scorePrediction) {
		this.scorePrediction = scorePrediction;
	}

	private static boolean check = false;

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	public Map<Date, Client> getBaseProcessedClients() {
		return BaseProcessedClients;
	}

	public void setBaseProcessedClients(Map<Date, Client> baseProcessedClients) {
		BaseProcessedClients = baseProcessedClients;
	}

	public LinkedHashMap<Predection, Queue<Answer>> getPredections() {
		return Predections;
	}

	public void setPredections(LinkedHashMap<Predection, Queue<Answer>> predections) {
		Predections = predections;
	}

	public void addAdmissionDate() {

		do {
			check = false;
			System.out.println("Enter admission Date, dd.mm.yyyy");
			SimpleDateFormat sf = new SimpleDateFormat("dd.MM.yyyy");
			Scanner sc = new Scanner(System.in);
			try {
				admissionDate = sf.parse(sc.nextLine());
			} catch (ParseException e) {
				System.out.println("Incorrect enter time format, try again");

				check = true;
			}

		} while (check);

		scorePrediction = 0;

	}

	public void addPredections() {
		check = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter prediction");
		Predection predection = new Predection();
		predection.setTarget(sc.nextLine());
		Queue<Answer> answers = new PriorityQueue<>();

		do {
			System.out.println("Add answer to prediction?, 1-Yes,2-No");
			try {
				int t = Integer.parseInt(sc.nextLine());
				switch (t) {
				case 1:
					System.out.println("Enter answer");
					Answer answ = new Answer();
					answ.setAnswer(sc.nextLine());
					answers.add(answ);
					check = true;
					break;
				case 2:
					check = false;

				}
			} catch (java.lang.NumberFormatException e) {
				System.out.println("Incorrect enter format, try again\" ");
				e.getStackTrace();
				check = true;
			}

		} while (check);

		Predections.put(predection, answers);

	}

	public void outPrediction() {

		if (!(Predections.isEmpty())) {
			Set<Predection> keyP = Predections.keySet();
			for (Predection p : keyP) {
				System.out.println("Predection= " + p.getTarget());
				PriorityQueue<Answer> queueTemp = (PriorityQueue) Predections.get(p);
				System.out.println("Answers:");

				for (Answer a : queueTemp) {
					System.out.println(a.getAnswer());

				}

			}
		} else {
			System.out.println("Predictions base is empty");
		}
	}

	public void outBaseProcessedClients() {
		if (!(BaseProcessedClients.isEmpty())) {
			SimpleDateFormat sd = new SimpleDateFormat("dd.MM.yyyy");

			BaseProcessedClients.forEach(
					(k, v) -> System.out.println("Date reception " + sd.format(k) + " Client name= " + v.getName()));

		} else {
			System.out.println("Customer base is empty");
		}

	}

	public void addBaseProcessedClients(Client client) {
		Date temp = new Date();
		temp.setDate(admissionDate.getDate());
		temp.setMonth(admissionDate.getMonth());
		temp.setYear(admissionDate.getYear());
		client.setDate(temp);
		BaseProcessedClients.put(temp, client);

	}

}
