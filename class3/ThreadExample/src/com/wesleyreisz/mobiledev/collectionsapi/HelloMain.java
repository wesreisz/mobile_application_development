package com.wesleyreisz.mobiledev.collectionsapi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HelloMain {
	public static void main(String[] args){
		HelloFlood flood = new HelloFlood();
		//Thread thread = new Thread(new HelloFlood());
		//thread.start();
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.submit(flood);
		executor.submit(flood);
		executor.submit(flood);
		executor.submit(flood);
		executor.submit(flood);
		executor.shutdown();
		
		
		for(int i=0;i<100;i++){
			System.out.println("Hello From the main: " + i);
		}
		
	}
}
