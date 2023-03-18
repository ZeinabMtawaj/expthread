package org.example;

public class StudentThread extends Thread{
    public Student student;
    public StudentService studentService;

    public StudentThread(Student student, StudentService studentService){
        this.student = student;
        this.studentService = studentService;

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        this.studentService.save(this.student);
    }
}
