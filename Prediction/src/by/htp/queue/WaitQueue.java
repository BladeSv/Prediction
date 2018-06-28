package by.htp.queue;

import java.util.PriorityQueue;

import by.htp.entity.Client;

public class WaitQueue {
	PriorityQueue<Client> waitQuety = new PriorityQueue<Client>();

	public PriorityQueue<Client> getWaitQuety() {
		return waitQuety;
	}

	public void setWaitQuety(PriorityQueue<Client> waitQuety) {
		this.waitQuety = waitQuety;
	}

	public void outWaitQueue() {
		if (!(waitQuety.isEmpty())) {
			for (Client c : waitQuety) {

				System.out.println("Clients in wait queue");
				System.out.println(c);

			}
		} else {
			System.out.println("Wait queue is empty");
		}
	}

	public void delWaitQueue() {
		if (!(waitQuety.isEmpty())) {
			waitQuety.remove();
			System.out.println("Client delete from wait base");

		} else {

			System.out.println("Wait queue is empty");
		}

	}
}
