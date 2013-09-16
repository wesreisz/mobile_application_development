package com.wesleyreisz.mobiledev.twolist;

import java.util.ArrayList;
import java.util.List;

public class MyUtils<T> {
	public List<List<T>> compareList(List<T> group1, List<T> group2) {
		List<List<T>> results = new ArrayList<List<T>>();
		results.add(getDifference(group1, group2));
		results.add(getDifference(group2, group1));
		return results;
	}
	
	private List<T> getDifference(List<T> group1, List<T> group2){
		List<T> tmpResult = new ArrayList<T>(group2);
		for(T result:group1){
			tmpResult.remove(result);
		}
		return tmpResult;
	}
}
