package com.wesleyreisz.mobiledev.twolist.trie;

import java.util.HashMap;
import java.util.Map;

public class Node<T> {
    private Character nodeKey;
    private T nodeValue;
    private boolean terminal;
    private Map<Character, Node<T>> children = new HashMap<Character, Node<T>>();
     
    public Character getNodeKey() {
        return nodeKey;
    }
 
    public void setNodeKey(Character nodeKey) {
        this.nodeKey = nodeKey;
    }
 
    public T getNodeValue() {
        return nodeValue;
    }
 
    public void setNodeValue(T nodeValue) {
        this.nodeValue = nodeValue;
    }
     
    public boolean isTerminal() {
        return terminal;
    }
 
    public void setTerminal(boolean terminal) {
        this.terminal = terminal;
    }
 
    public Map<Character, Node<T>> getChildren() {
        return children;
    }
 
    public void setChildren(Map<Character, Node<T>> children) {
        this.children = children;
    }
}