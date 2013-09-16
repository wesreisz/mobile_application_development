package com.wesleyreisz.mobiledev.collectionsapi;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTester {
	@Test
	public void myTest(){
		List<String>names = new LinkedList<String>();
		names.add("wes");
		names.add("kim");
		names.add("justin");
		names.add("leanne");
		names.add("tyler");
		
		Assert.assertEquals("tyler leanne justin kim wes ", StringUtils.print(names));
	}
	
	@Test
	public void myTest1(){
		List<String>names = new ArrayList<String>();
		names.add("wes");
		names.add("kim");
		names.add("justin");
		names.add("leanne");
		names.add("tyler");
		
		Assert.assertEquals("wes kim justin leanne tyler ", StringUtils.print(names));
	}
	
	@Test
	public void myTest2(){
		List<String>names = new ArrayList<String>();
		names.add("wes");
		names.add("kim");
		names.add("justin");
		names.add("leanne");
		names.add("tyler");
		
		Collections.sort(names);
		
		Assert.assertEquals("justin kim leanne tyler wes ", StringUtils.print(names));
	}
}

