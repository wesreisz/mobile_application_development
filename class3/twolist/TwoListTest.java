package com.wesleyreisz.mobiledev.twolist;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import junit.framework.Assert;

import org.junit.Test;

import com.wesleyreisz.mobiledev.twolist.strategies.TrieStrategyImpl;


public class TwoListTest {

	@Test
	public void test() {
		List<String> group1 = new ArrayList<String>();
		group1.add("wes");
		group1.add("kim");
		group1.add("sam");
		group1.add("chris");
		
		List<String> group2 = new ArrayList<String>();
		group2.add("tom");
		group2.add("sam");
		group2.add("chris");
		group2.add("wes");
		
		List<ArrayList<String>> results = 
			new MyUtils().compareList(group1,group2);
		
		ArrayList<String> result1 = new ArrayList<String>();
		result1.add("tom");
		Assert.assertEquals(result1, results.get(0));
		
		ArrayList<String> result2 = new ArrayList<String>();
		result2.add("kim");
		Assert.assertEquals(result2, results.get(1));
	}
	
	@Test
	public void test1(){
		List<Integer> group1 = new ArrayList<Integer>();
		group1.add(2);
		group1.add(6);
		group1.add(8);
		group1.add(5);
		
		List<Integer> group2 = new ArrayList<Integer>();
		group2.add(2);
		group2.add(6);
		group2.add(7);
		group2.add(5);
		group2.add(14);
		
		List<ArrayList<String>> results = new MyUtils().compareList(group1,group2);
		
		ArrayList<Integer> result1 = new ArrayList<Integer>();
		result1.add(7);
		result1.add(14);
		Assert.assertEquals(result1, results.get(0));
		
		ArrayList<Integer> result2 = new ArrayList<Integer>();
		result2.add(8);
		Assert.assertEquals(result2, results.get(1));
	}
	
	@Test
	public void test2() {
		List<String> group1 = new ArrayList<String>();
		group1.add("wes");
		group1.add("kim");
		group1.add("sam");
		group1.add("chris");
		
		List<String> group2 = new ArrayList<String>();
		group2.add("tor");
		group2.add("sam");
		group2.add("chris");
		group2.add("wes");
		
		List<ArrayList<String>> results = 
				new MyUtils(new TrieStrategyImpl<String>())
					.compareList(group1,group2);
		
		ArrayList<String> result1 = new ArrayList<String>();
		result1.add("tor");
		Assert.assertEquals(result1, results.get(0));
		
		ArrayList<String> result2 = new ArrayList<String>();
		result2.add("kim");
		Assert.assertEquals(result2, results.get(1));
	}
	
	@Test
	public void test3(){
		List<Integer> group1 = new ArrayList<Integer>();
		group1.add(2);
		group1.add(6);
		group1.add(8);
		group1.add(5);
		group1.add(24);
		group1.add(13);
		group1.add(14);
		
		List<Integer> group2 = new ArrayList<Integer>();
		group2.add(2);
		group2.add(6);
		group2.add(7);
		group2.add(5);
		group2.add(13);
		group2.add(16);
		
		List<ArrayList<String>> results = 
				new MyUtils(new TrieStrategyImpl<String>())
					.compareList(group1,group2);
		
		ArrayList<Integer> result1 = new ArrayList<Integer>();
		result1.add(7);
		result1.add(16);
		Assert.assertEquals(result1, results.get(0));
		
		ArrayList<Integer> result2 = new ArrayList<Integer>();
		result2.add(8);
		result2.add(24);
		result2.add(14);
		Assert.assertEquals(result2, results.get(1));
	}
	
	@Test
	public void test4(){
		long count = new Date().getTime();
		List<Integer> group1 = new ArrayList<Integer>();
		for(int i=0;i<20;i++){
			Random rand = new Random(++count);
			group1.add((int)(rand.nextInt(20)));
		}
		
		List<Integer> group2 = new ArrayList<Integer>();
		for(int i=0;i<20;i++){
			Random rand = new Random(++count);
			group2.add((int)(rand.nextInt(20)));
		}
		
		List<ArrayList<String>> results = 
				new MyUtils(new TrieStrategyImpl<String>())
					.compareList(group1,group2);
		
		Assert.assertEquals(true, results.get(0)!=null);
		System.out.println("Matches: " + (group1.size()-results.get(0).size()) + " Nonmatches: " +  results.get(0).size());
		
		Assert.assertEquals(true, results.get(1)!=null);
		System.out.println("Matches: " + (group2.size()-results.get(1).size()) + " Nonmatches: " +  results.get(1).size());
	}
	
	
}
