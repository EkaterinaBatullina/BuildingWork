package a.work;
import static a.work.Work.endsOfThreads;
import static a.work.Work.startsOfThreads;
import static a.work.Work.threads;

import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ekaterina
 */
public class Brigade {
    String name;
    List<Integer> jobs;

        public Brigade(String name, List<Integer> jobs) {
            this.name = name;
            this.jobs = jobs;
        }

        public void playingTime() {
            int time = 0;
            for (int i = 1; i < jobs.size(); i++) {
               if (startsOfThreads[jobs.get(i)] - endsOfThreads[jobs.get(i-1)] > 0) {
                    time += startsOfThreads[jobs.get(i)] - endsOfThreads[jobs.get(i-1)];
                }
            }
            System.out.println("Бригада " + name + " играла в домино: " + time);
        }
    
    
}
