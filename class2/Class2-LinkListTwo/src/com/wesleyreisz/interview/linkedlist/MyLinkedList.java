package com.wesleyreisz.interview.linkedlist;

public class MyLinkedList {
	private Node backTraceNode = null;
	private Node firstNode = null;

	public void add(String input) {
		Node tmpNode = new Node(input);
		if(backTraceNode!=null){
			backTraceNode.setPointerNode(tmpNode);
		}else{
			firstNode=tmpNode;
		}
		backTraceNode = tmpNode;
	}

	public String print() {
		StringBuffer result = new StringBuffer();
		Node tmpNode = firstNode;
		while(tmpNode!=null){
			result.append(tmpNode.getValue() + " ");
			tmpNode =tmpNode.getPointerNode();
		}
		return result.toString();
	}

}
