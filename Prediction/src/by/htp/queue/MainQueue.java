package by.htp.queue;

import java.util.Date;
import java.util.PriorityQueue;

import by.htp.entity.Client;
import by.htp.entity.FortuneTeller;

public class MainQueue {
	PriorityQueue<Client> mainQueue = new PriorityQueue<Client>();

	public PriorityQueue<Client> getMainQueue() {
		return mainQueue;
	}

	public void setMainQueue(PriorityQueue<Client> mainQueue) {
		this.mainQueue = mainQueue;
	}

	public void addMainQueue(Client client, FortuneTeller fortuneTeller) {

		Date temp = new Date();
		temp.setDate(fortuneTeller.getAdmissionDate().getDate());
		temp.setMonth(fortuneTeller.getAdmissionDate().getMonth());
		temp.setYear(fortuneTeller.getAdmissionDate().getYear());
		client.setDateEnterQueue(temp);
		mainQueue.add(client);

	}

	public void outMainQueue() {
		if (!(mainQueue.isEmpty())) {
			for (Client c : mainQueue) {

				System.out.println("Clients in main queue");
				System.out.println(c);
			}
		} else {
			System.out.println("Main queue is empty");
		}

	}
}
