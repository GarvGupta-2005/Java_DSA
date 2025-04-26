package Greedy.Medium_Hard;

import java.util.*;

public class N_Meetings {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.

    // Class to represent a meeting with start time, end time, and position
    class meeting {
        int start;
        int end;
        int pos;

        // Constructor to initialize meeting details
        meeting(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    // Comparator class to sort meetings based on their end time
    class meetingComparator implements Comparator<meeting> {
        @Override
        public int compare(meeting o1, meeting o2) {
            // Sort based on the end time (ascending order)
            if (o1.end < o2.end)
                return -1;
            else if (o1.end > o2.end)
                return 1;
            // If end times are the same, sort based on position (ascending order)
            else if (o1.pos < o2.pos)
                return -1;
            return 1;
        }
    }

    public int maxMeetings(int start[], int end[]) {
        // List to store meeting objects
        ArrayList<meeting> meet = new ArrayList<>();

        // Variable to keep track of the maximum number of meetings
        int ans = 1;

        // Populate the list with meeting objects
        for (int i = 0; i < start.length; i++)
            meet.add(new meeting(start[i], end[i], i + 1));

        // Create an instance of the comparator
        meetingComparator mc = new meetingComparator();

        // Sort the meetings based on their end time
        Collections.sort(meet, mc);

        // List to store the order of meetings that can be conducted
        ArrayList<Integer> answer = new ArrayList<>();
        
        // Add the first meeting's position to the answer list
        answer.add(meet.get(0).pos);

        // Variable to track the last meeting's end time
        int limit = meet.get(0).end;

        // Iterate through the meetings and select the ones that can be conducted
        for (int i = 1; i < start.length; i++) {
            // If the current meeting starts after the last selected meeting ends
            if (meet.get(i).start > limit) {
                // Update the end time limit
                limit = meet.get(i).end;
                
                // Add the current meeting's position to the answer list
                answer.add(meet.get(i).pos);

                // Increment the count of selected meetings
                ans++;
            }
        }

        // Return the maximum number of meetings that can be scheduled
        return ans;
    }
}
