package com.wesleyreisz.mobiledev.linkedlist;

public class MyNodeList {
	private Node nextNode = null;
	private Node firstNode = null;
	public void add(String value) {
		Node tmpNode = new Node(value);	
		if(nextNode!=null){
			nextNode.setPointerNode(tmpNode);
		}else{
			firstNode = tmpNode;
		}
		nextNode = tmpNode;
	}

	public String print() {
		StringBuffer sb = new StringBuffer();
		Node tmpNode = this.firstNode;
		while (tmpNode!=null){
			sb.append(tmpNode.getValue() + " ");
			tmpNode = tmpNode.getPointerNode();
		}
		return sb.toString();
	}
}
