package org.example;

public class StudentService {
    public void save(Student student){
        System.out.println("saving student: "+(student._name));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("saving Completed: "+(student._name));

    }
}
