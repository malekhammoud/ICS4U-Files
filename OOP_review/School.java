package OOP_review;

import java.util.*;
/**
 * Write a program to create a class called “School” with attributes for students, teachers, and classes,
 * and methods to add and remove students and teachers, and to create classes.
 */
public class School {
    ArrayList<String> students = new ArrayList<String>();
    ArrayList<String> teachers= new ArrayList<String>();
    ArrayList<String> classes= new ArrayList<String>();
    School(String[] students, String[] teachers, String[] classes) {
        for (String student: students) {
            this.students.add(student);
        }
        for (String teacher: teachers) {
            this.teachers.add(teacher);
        }
        for (String clas: classes) {
            this.classes.add(clas);
        }
    }

    //The rest is easy!!


}
