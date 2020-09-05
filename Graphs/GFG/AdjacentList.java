/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;


class AdjacentList {
    
    private static void addVerticesToList(List<ArrayList<Integer>> adjacentList, int v1, int v2) {
        adjacentList.get(v1).add(v2);
        adjacentList.get(v2).add(v1);
    }
    
    private static void printAdjacentList(List<ArrayList<Integer>> adjacentList) {
        for(int i = 0; i < adjacentList.size(); i++) {
            System.out.print(i);
            for(int j=0 ; j < adjacentList.get(i).size(); j++) {
                System.out.print("-> " + adjacentList.get(i).get(j));
            }
            System.out.println();
        }
    }
    
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0) {
            int V = scanner.nextInt();
            int E = scanner.nextInt();
            List<ArrayList<Integer>> adjacentList = new ArrayList<>(V);
            for(int i= 0; i < V; i++)
                adjacentList.add(new ArrayList<Integer>());
            for(int i = 0; i < E; i++) {
                int v1 = scanner.nextInt();                
                int v2 = scanner.nextInt();
                addVerticesToList(adjacentList, v1, v2);
            }
            
            printAdjacentList(adjacentList);
}
	}
}