package com.wesleyreisz.mobiledev.twolist;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;


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
		
		List<ArrayList<String>> results = new MyUtils().compareList(group1,group2);
		
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
}
