package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        super(emailId,Integer.MAX_VALUE);
        calendar=new ArrayList<>();
        // The inboxCapacity is equal to the maximum value an integer can store.

    }

    public void addMeeting(Meeting meeting){
        calendar.add(meeting);
        //add the meeting to calendar

    }

    public int findMaxMeetings(){
        if(calendar.size()==0) return 0;
        Collections.sort(calendar,(a,b)-> {
            if(a.getStartTime().isAfter(b.getStartTime())) return 1;
            else if(a.getStartTime().isBefore(b.getStartTime())) return -1;
            else return 0;
        });
        int cnt=0;
        LocalTime pStart=calendar.get(0).getStartTime();
        LocalTime pEnd=calendar.get(0).getEndTime();
        int n=calendar.size();
        for(int i=1;i<n;i++){
            LocalTime cStart=calendar.get(i).getStartTime();
            LocalTime cEnd=calendar.get(i).getEndTime();
            if(cStart.isAfter(pEnd)){
                cnt++;
                pStart=cStart;
                pEnd=cEnd;
            }else{
                //means overlapping..
                if(pEnd.isAfter(cEnd)){
                    pStart=cStart;
                    pEnd=cEnd;
                }
            }
        }
        return cnt+1;

        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am

    }
}
