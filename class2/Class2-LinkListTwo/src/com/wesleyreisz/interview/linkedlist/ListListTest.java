package com.wesleyreisz.interview.linkedlist;


import junit.framework.Assert;

import org.junit.Test;

public class ListListTest {

	@Test
	public void linkedListTest() {
		String names2Evaluate = "wes kim justin leanne ";
		MyLinkedList list = new MyLinkedList();
		list.add("wes");
		list.add("kim");
		list.add("justin");
		list.add("leanne");
		
		Assert.assertEquals(
			names2Evaluate, 
			list.print()
		);
	}
}
