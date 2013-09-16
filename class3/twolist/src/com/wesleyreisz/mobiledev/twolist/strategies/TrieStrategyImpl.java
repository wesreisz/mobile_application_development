package com.wesleyreisz.mobiledev.twolist.strategies;

import java.util.ArrayList;
import java.util.List;

import com.wesleyreisz.mobiledev.twolist.trie.Trie;
import com.wesleyreisz.mobiledev.twolist.trie.TrieImpl;

public class TrieStrategyImpl<T> implements ITwoListStrategy<T> {

	@Override
	public List<T> processList(List<T> group1, List<T> group2) {
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
