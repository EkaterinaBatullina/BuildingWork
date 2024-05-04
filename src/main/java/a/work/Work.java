/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package a.work;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ekaterina
 */
public class Work {
    
    public static Thread[] threads;
    public static Long[] endsOfThreads;
    public static Long[] startsOfThreads;

    public static void main(String[] args) {
        
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(0,"Начало работ", 0, new ArrayList<>())); // 0
        tasks.add(new Task(1,"Проект", 7, List.of(0))); // 1
        tasks.add(new Task(2, "Изготовление окон", 7, List.of(1))); // 2
        tasks.add(new Task(3, "Изготовление дверей", 7, List.of(1))); // 3
        tasks.add(new Task(4,"Возведение фундамента", 14, List.of(1))); // 4
        tasks.add(new Task(5,"Прокладка коммуникаций", 4, List.of(4))); // 5
        tasks.add(new Task(6,"Возведение стен", 14, List.of(4))); // 6
        tasks.add(new Task(7,"Возведение крыши", 3, List.of(6))); // 7
        tasks.add(new Task(8,"Установка окон", 1, List.of(2, 7))); // 8
        tasks.add(new Task(9,"Установка дверей", 1, List.of(3, 7))); // 9
        tasks.add(new Task(10,"Установка отопительных приборов (батарей)", 3, List.of(5, 8, 9))); // 10
        tasks.add(new Task(11,"Прокладка электропроводки", 3, List.of(5, 7))); // 11
        tasks.add(new Task(12,"Отделка стен и потолка", 7, List.of(8, 9, 11))); // 12
        tasks.add(new Task(13,"Отделка пола", 7, List.of(12))); // 13
        tasks.add(new Task(14,"Установка осветительных приборов", 1, List.of(12))); // 14
        tasks.add(new Task(15,"Установка сантехники", 2, List.of(5, 11, 12))); // 15
        tasks.add(new Task(16,"Завершение строительства", 0, List.of(13))); // 16

        threads = new Thread[tasks.size()];
        endsOfThreads = new Long[tasks.size()];
        startsOfThreads = new Long[tasks.size()];

        
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < tasks.size(); i++) {
            threads[i] = new Thread(tasks.get(i));
            threads[i].start();
        }
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } 
        catch (InterruptedException e) {
            e.getMessage();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Работа выполнена за: " + (endTime - startTime) / 1000 + " дней");

        
        List<Brigade> brigades = new ArrayList<>();
        brigades.add(new Brigade("Каменщики", List.of(1, 4, 6)));
        brigades.add(new Brigade("Плотники", List.of(1, 2, 3, 7, 8, 9)));
        brigades.add(new Brigade("Сантехники", List.of(1, 5, 10, 15)));
        brigades.add(new Brigade("Штукатуры", List.of(1, 12, 13)));
        brigades.add(new Brigade("Электрики", List.of(1, 11, 14)));

        for (int i = 0; i < brigades.size(); i++) {
            brigades.get(i).playingTime();
        }
    }


}
