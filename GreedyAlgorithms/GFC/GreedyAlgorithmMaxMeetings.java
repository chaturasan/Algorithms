import java.util.*;
import java.lang.*;
import java.io.*;


class Meeting {
    private int start, end;
    
    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    int getStart() {
        return start;
    }
    
    int getEnd() {
        return end;
    }
    
}

public class GreedyAlgorithmMaxMeetings {
    
    static void sortMeetings(Meeting[] meetings) {
        Arrays.sort(meetings, new Comparator<Meeting>() {
           
           @Override
           public int compare(Meeting meeting1, Meeting meeting2) {
               return meeting1.getEnd() - meeting2.getEnd();
           }
            
        });
    }
    
    static int getMaximumMeetings(Meeting[] meetings) {
        int i = 0;
        int numberOfMeetings = 1;
        for(int j = 1; j < meetings.length; j++) {
            if(meetings[j].getStart() >= meetings[i].getEnd()) {
                i = j;
                numberOfMeetings++;
            }
        }
        return numberOfMeetings;
    }
    
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = Integer.parseInt(scanner.nextLine().trim());
		while(t-- > 0) {
		    int sizeOfArray = Integer.parseInt(scanner.nextLine().trim());
		    String[] startTime = new String[sizeOfArray];
		    String[] endTime = new String[sizeOfArray];
		    startTime = scanner.nextLine().trim().split(" ");
		    endTime = scanner.nextLine().trim().split(" ");
		    Meeting[] meetings = new Meeting[sizeOfArray];
		    for(int ind = 0; ind < sizeOfArray; ind++) {
		        meetings[ind] = new Meeting(Integer.parseInt(startTime[ind]), Integer.parseInt(endTime[ind]));
		    }
		    sortMeetings(meetings);
		    System.out.println(getMaximumMeetings(meetings));
		}
	}
}