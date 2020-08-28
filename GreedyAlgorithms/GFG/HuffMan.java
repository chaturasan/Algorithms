/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    private int frequency;
    char character = '-';
    private Node left = null;
    private Node right = null;
    
    Node(int frequency, char character) {
        this.frequency = frequency;
        this.character = character;
    }
    
    Node(int frequency) {
        this.frequency = frequency;    
    }
    
    public int getFrequency() {
        return this.frequency;
    }
    
    public char getCharacter() {
        return this.character;
    }
    
    public void setLeftNode(Node left) {
        this.left = left;
    }
    
    public void setRightNode(Node right) {
        this.right = right;
    }
    
    public Node getLeftNode() {
        return this.left;
    }
    
    public Node getRightNode() {
        return this.right;
    }
    
    
}

public class HuffMan {
    
    private static void printCode(Node node, String code) {
        if(node.getLeftNode() == null && node.getRightNode() == null && Character.isLetter(node.getCharacter())) {
            System.out.print(code.toString() + " ");
            return;
        }
        
        printCode(node.getLeftNode(), code + "0");
        printCode(node.getRightNode(), code + "1");
    }
    
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = Integer.parseInt(scanner.nextLine().trim());
		while(t-- > 0) {
		    char[] characters = scanner.nextLine().trim().toCharArray();
		    String[] frequencies = scanner.nextLine().trim().split(" ");
		    int totalCharacters = frequencies.length;
		    PriorityQueue<Node> priorityQueue = new PriorityQueue<>(totalCharacters, new Comparator<Node>() {
           
           @Override
           public int compare(Node n1, Node n2) {
               return n1.getFrequency() - n2.getFrequency();
           }
            
        }); 
		       
		    for(int ind = 0; ind < totalCharacters; ind++) {
		        Node node = new Node(Integer.parseInt(frequencies[ind]), characters[ind]);
		        priorityQueue.add(node);
		    }
		    
		    Node root = null;
		    while(priorityQueue.size() > 1) {
		        Node leastFrequencyNode = priorityQueue.poll();
		        Node secondLeastFrequencyNode = priorityQueue.poll();
		        int sumFrequency = leastFrequencyNode.getFrequency() +
		                            secondLeastFrequencyNode.getFrequency();
		        root = new Node(sumFrequency);
		        root.setLeftNode(leastFrequencyNode);
		        root.setRightNode(secondLeastFrequencyNode);
		        
		        priorityQueue.add(root);
		    }
		    printCode(root, "");
		    System.out.println();
		}
	
		
	}
}