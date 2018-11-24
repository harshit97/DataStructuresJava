package com.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean wordEnd;
    public String longest_word;
    public int curr_max;
    TrieNode () {
        children = new HashMap<>();
        wordEnd = false;
        longest_word="";
        curr_max = 0;
    }
    
    public void insert (String word, TrieNode root) {
        int count = 0;
        TrieNode current = this;
        char wordArray[] = word.toCharArray();
        for (char ch : wordArray) {
            TrieNode node = current.children.get(ch);
            if (node == null) {
            	count++;
            	if (count>1) {
            		return;
            	}
                node = new TrieNode();
                current.children.put (ch, node);
            }
            current = node;
        }
        current.wordEnd = true;
        if ((count==1) && (word.length() > root.curr_max)) {
            root.longest_word = word;
            root.curr_max = word.length();
        }
        else if (count==1 && word.length()==root.curr_max) {
            root.longest_word = (word.compareTo(root.longest_word)==-1)?root.longest_word:word;
        }
    }
}
class Solution {
    public static String longestWord(String[] words) {
        TrieNode root = new TrieNode ();
        for (String word : words) {
            root.insert (word, root);
        }
        return root.longest_word;
    }
    public static void main (String args[]) {
    	String wString [] = {"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
    	ArrayList<String> sortedString = new ArrayList<>();
    	for (String string : wString) {
    		sortedString.add(string);
    	}
    	Collections.sort(sortedString);
    	Object obj[] = sortedString.toArray();
    	for (int i=0;i<obj.length;i++) {
    		wString[i] = (String)obj[i];
    	}
    	System.out.println(longestWord(wString));
    }
}
