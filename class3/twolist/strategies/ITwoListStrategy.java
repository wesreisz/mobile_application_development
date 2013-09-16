package com.wesleyreisz.mobiledev.twolist.strategies;

import java.util.List;

public interface ITwoListStrategy<T> {
	public List<T> processList(List<T> group1, List<T> group2);
}
