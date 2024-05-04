package a.work;

import static a.work.Work.endsOfThreads;
import static a.work.Work.startsOfThreads;
import static a.work.Work.threads;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ekaterina
 */
public class Task implements Runnable {
        int id;
        String name;
        int duration;
        List<Integer> dependencies;

        public Task(int id, String name, int duration, List<Integer> dependencies) {
            this.id = id;
            this.name = name;
            this.duration = duration;
            this.dependencies = dependencies;
        }

        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            try {
                for (Integer dependency : dependencies) {
                    threads[dependency].join();
                }
            } catch (InterruptedException e) {
                e.getMessage();
            }

            System.out.println("Start " + name);
            long startCurrentTime = System.currentTimeMillis();

            try {
                Thread.sleep(1000 * duration);
            } catch (InterruptedException ex) {
                Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
            }
 
            long endCurrentTime = System.currentTimeMillis();
            long endTime = System.currentTimeMillis();
            System.out.println("End " + name);
            endsOfThreads[id] = (endTime - startTime) / 1000;
            startsOfThreads[id] = (endsOfThreads[id] - (endCurrentTime - startCurrentTime) / 1000);
        }
    }

