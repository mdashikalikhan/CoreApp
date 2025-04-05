package com.interview.schedude;

import java.util.Arrays;
import java.util.List;

public class TaskSchedule {
    public static void main(String[] args) {
        List<Task> tasks = Arrays.asList(
                new Task(0,8,30),
                new Task(1, 5, 10),
                new Task(2, 10, 5),
                new Task(3, 3, 25)
        );

        System.out.println(scheduler(tasks));

    }

    static List<Integer> scheduler(List<Task> tasks){
        tasks.sort((a,b)->Double.compare((double) b.getPriority()/b.time, (double) a.getPriority()/a.time));
        return tasks.stream().map(t->t.getId()).toList();
    }
}

 class Task{
    int id;
    int priority;
    int time;

    public Task(int id, int priority, int time){
        this.id = id;
        this.priority = priority;
        this.time = time;
    }

     public int getId() {
         return id;
     }

     public int getPriority() {
         return priority;
     }

     public int getTime() {
         return time;
     }
 }

