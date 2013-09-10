package com.wesleyreisz.android.class3.anoninnerclassexample;

public class ThreeFiftyImpl implements IEngine {
	private static double MULTIPLIER = 1.2;
	@Override
	public double move(double speed) {
		return MULTIPLIER*speed;
	}
}
