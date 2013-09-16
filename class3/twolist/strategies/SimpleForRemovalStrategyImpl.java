package com.wesleyreisz.mobiledev.twolist.strategies;

import java.util.ArrayList;
import java.util.List;

public class SimpleForRemovalStrategyImpl<T> implements ITwoListStrategy<T> {

	@Override
	public List<T> processList(List<T> group1, List<T> group2) {
		List<T> tmpResult = new ArrayList<T>(group2);
		for(T result:group1){
			tmpResult.remove(result);
		}
		return tmpResult;
	}
}
