package by.htp.run;

import java.util.Map;
import java.util.Queue;

import by.htp.entity.Answer;
import by.htp.entity.Client;
import by.htp.entity.FortuneTeller;
import by.htp.entity.PredictionResult;
import by.htp.queue.MainQueue;
import by.htp.queue.WaitQueue;

public class Run {

	public void reception(MainQueue mainQueue, FortuneTeller fortuneTeller, WaitQueue waitQuety) {

		if ((!(mainQueue.getMainQueue().isEmpty())) && (!(fortuneTeller.getPredections().isEmpty()))) {
			Client tempClient = mainQueue.getMainQueue().poll();

			if ((fortuneTeller.getScorePrediction() < 11)
					&& (fortuneTeller.getAdmissionDate().getTime() - tempClient.getDate().getTime()) > 604800000) {
				Answer chooseAnsewer = doAnswer(fortuneTeller, tempClient);
				fortuneTeller.addBaseProcessedClients(tempClient);
				doPredictionResult(tempClient, chooseAnsewer);

				fortuneTeller.setScorePrediction(fortuneTeller.getScorePrediction() + 1);

				if (!(chooseAnsewer.getAnswer().equals("The predictor has no prediction"))) {
					System.out.println("The reception was successful, the client " + tempClient.getName()
							+ " with targer prediction= " + tempClient.getTargetPrediction().getTarget()
							+ " get a answer= " + chooseAnsewer.getAnswer());
				} else {
					System.out.println("the predictor has no prediction for a client " + tempClient.getName()
							+ " with such a prediction purpose");

				}

				System.out.println();
				System.out.println(
						"The predictor can take" + (fortuneTeller.getScorePrediction() - 10) + " more customers today");

			} else {

				System.out.println("The predictor can not accept the client, client add to wait queue");
				waitQuety.getWaitQuety().add(tempClient);
			}

		} else {
			System.out.println("Queue of client or predections is empty");

		}

	}

	private Answer doAnswer(FortuneTeller fortuneTeller, Client tempClient) {

		if (fortuneTeller.getPredections().containsKey(tempClient.getTargetPrediction())) {
			Queue<Answer> tempAnswer = fortuneTeller.getPredections().get(tempClient.getTargetPrediction());

			Answer[] arrayAnswer = new Answer[tempAnswer.size()];
			tempAnswer.toArray(arrayAnswer);
			Answer chooseAnsewer = arrayAnswer[(int) ((Math.random() * (arrayAnswer.length - 1)))];
			return chooseAnsewer;
		} else {

			Answer chooseAnsewer = new Answer();
			chooseAnsewer.setAnswer("The predictor has no prediction");
			return chooseAnsewer;

		}
	}

	private void doPredictionResult(Client tempClient, Answer chooseAnsewer) {

		PredictionResult predictionResultTemp = new PredictionResult();
		predictionResultTemp.getPredictionResult().put(tempClient.getTargetPrediction(), chooseAnsewer);

		tempClient.getHistoryPredictions().put(tempClient.getDate(), predictionResultTemp);

	}

}
