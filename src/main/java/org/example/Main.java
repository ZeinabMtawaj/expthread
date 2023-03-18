package org.example;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        StudentService studentService = new StudentService();
        ArrayList<StudentThread> list = new ArrayList<StudentThread>();
        for (int i=0; i<10; i++) {
            Student student = new Student("std"+i);
            StudentThread studentThread = new StudentThread(student, studentService);
            studentThread.start();
            list.add(studentThread);

        }
        for (StudentThread studentThread : list){
            try {
                studentThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("time "+(endTime-startTime));


        Student student = new Student("peace");
       ExecutorService executorService =Executors.newFixedThreadPool(10);
       executorService.submit(() -> studentService.save(student));

//        Future<String> future = executorService.submit(() -> studentService.save(student));
//        future.get();
//        executorService.shutdown(); // it will wait the current running tasks to end  and stop others to submit then terminate all
 //         executorService.isTerminated();
//        executorService.shutdownNow();
//        executorService.awaitTermination(15, TimeUnit.SECONDS);
//        executorService.shutdownNow();





    }
}