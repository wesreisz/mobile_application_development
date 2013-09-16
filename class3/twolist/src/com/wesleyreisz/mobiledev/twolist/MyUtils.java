package com.wesleyreisz.mobiledev.twolist;

import java.util.ArrayList;
import java.util.List;

import com.wesleyreisz.mobiledev.twolist.strategies.ITwoListStrategy;
import com.wesleyreisz.mobiledev.twolist.strategies.SimpleForRemovalStrategyImpl;

public class MyUtils<T> {
	private ITwoListStrategy<T> strategy;
	
	
	public MyUtils(){
		strategy = new SimpleForRemovalStrategyImpl<T>();
	}
	
	public MyUtils(ITwoListStrategy<T> strategy){
		this.strategy = strategy;
	}
	
	public List<List<T>> compareList(List<T> group1, List<T> group2) {
		List<List<T>> results = new ArrayList<List<T>>();
		results.add(getDifference(group1, group2));
		results.add(getDifference(group2, group1));
		return results;
	}
	
	private List<T> getDifference(List<T> group1, List<T> group2){
		return strategy.processList(group1, group2);
	}
}
