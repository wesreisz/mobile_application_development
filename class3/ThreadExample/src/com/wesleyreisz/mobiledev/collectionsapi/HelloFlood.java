package com.wesleyreisz.mobiledev.collectionsapi;

public class HelloFlood implements Runnable {

	@Override
	public synchronized void run() {
		for(int i=0;i<100;i++){
			System.out.println("Hello Storm: " + i );
		}
	}
}
