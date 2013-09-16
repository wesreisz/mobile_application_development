package com.wesleyreisz.mobiledev.collectionsapi;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class StringUtils {

	public static String print(List<String> names) {
		StringBuffer sb = new StringBuffer();
		Iterator<String> it;
		if(names instanceof LinkedList<?>){
			LinkedList<String> llnames = (LinkedList<String>) names;
			it = (Iterator<String>)llnames.descendingIterator();
		}else{
			it = names.iterator();
		}
		
		while(it.hasNext()){
			sb.append(it.next() + " ");
		}
		
		return sb.toString();
	}

}
