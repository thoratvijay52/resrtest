package com.system.rest.resttest.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestFuture {

	public static void main(String[] args) throws Exception {

		Future<Integer> futureTask = new SquareCalculator().calculate(10);
		while (!futureTask.isDone()) {
			System.out.println("Calculating...");
		    Thread.sleep(300);
		}

		Integer result = futureTask.get();
		System.out.println("result:" +result);
	}
}

class SquareCalculator {

	ExecutorService executor = Executors.newSingleThreadExecutor();

	public Future<Integer> calculate(Integer input) {
		return executor.submit(() -> {
			Thread.sleep(1000);
			return input * input;
		});

	}

}