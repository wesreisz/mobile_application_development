package com.wesleyreisz.mobiledev.twolist;

import java.util.ArrayList;
import java.util.List;

import com.wesleyreisz.mobiledev.twolist.trie.Trie;
import com.wesleyreisz.mobiledev.twolist.trie.TrieImpl;

public class MyUtils<T> {
	
	public List<List<T>> compareList(List<T> group1, List<T> group2) {
		List<List<T>> results = new ArrayList<List<T>>();
		results.add(getDifference(group1, group2));
		results.add(getDifference(group2, group1));
		return results;
	}
	
	private List<T> getDifference(List<T> group1, List<T> group2){
		Trie<T> trie = new TrieImpl<T>();
		for(T item:group1){
			trie.add(String.valueOf(item), item);
		}
		
		List<T> results =new ArrayList<T>();
		for(T item:group2){
			if(trie.find(String.valueOf(item))==null){
				results.add(item);
			}
		}
		return results;
	}
}
