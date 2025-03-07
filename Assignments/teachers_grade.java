package Assignments;

import javax.swing.text.StyledEditorKit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.io.*;
import java.util.Scanner;

public class teachers_grade {
    /**
     * @param mark the mark input as an int
     * @return string: the grade
     */
    static String grade(int mark){
        if (mark >= 90){
            return "A+";
        }
        else if (mark >= 80){
            return "A";
        }
        else if (mark >= 70){
            return "B";
        }
        else if (mark >= 60){
            return "C";
        }
        else if (mark >= 50){
            return "D";
        }
        else if (mark >= 0){
            return "F";
        }
        else{
            return ".";
        }
    }

    /**
     * @param filename the file name
     * @return an array of string for the names of the students
     */
    static String[] getfilenames(String filename){
        int count = 0;
        try {
            FileReader fin = new FileReader(new File(filename));
            BufferedReader reader = new BufferedReader(fin);

            //read names from file
            String line = "";

            while ((line = reader.readLine()) != null) {
                count ++;
            }
            reader.close();
            fin.close();

            FileReader fin2 = new FileReader(new File(filename));
            BufferedReader reader2 = new BufferedReader(fin2);
            String[] students_names = new String[count];
            count = 0;
            line = "";
            while ((line = reader2.readLine()) != null) {
                students_names[count] = line;
                count ++;
            }
            reader2.close();
            fin2.close();
            return students_names;
        } catch (IOException e) {
            System.out.println("There was an error reading the file, Sorry!");
            return null;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Get the file name input
        System.out.println("""
               Teacher’s Gradebook
               ==================================""");
        System.out.print("Enter file name:");
        String students = sc.nextLine();
        //remove spaces
        students = students.replaceAll(" ","");

        String[] student_names = getfilenames(students);

        if (student_names != null){
            System.out.print("""
                   ...
                   Class load complete. 
                   ==================================
                   """);
            int[] student_marks = new int[student_names.length];
            String[] student_grade= new String[student_names.length];


            boolean stop_program = false;
            //Loop though all the names in the list and get the marks for them form the user
            for (int i = 0; i < student_names.length; i++) {
                    try {
                        System.out.print("Enter the mark for " + student_names[i] + ": ");
                        int mark = sc.nextInt();
                        student_marks[i] = mark;
                        student_grade[i] = grade(mark);
                        if (mark < 0 || mark>100){
                            throw new Exception();
                        }
                    }
                    catch(Exception e) {
                        System.out.println("Wrong input!");
                        stop_program = true;
                        break;
                    }
            }
            //lopo though the grades and marks and names and add them to grades.txt
            if (! stop_program){
                System.out.println("==================================");
                for (int i = 0; i < student_names.length; i++) {
                    System.out.printf("%s %s %s \n",student_names[i], student_marks[i], student_grade[i]);
                }
                System.out.println("==================================");

                try{
                    FileWriter fout = new FileWriter("grades.txt", true);
                    BufferedWriter writer = new BufferedWriter(fout);

                    //write info to file
                    String input = "";
                    for (int i = 0; i < student_names.length; i++) {
                        writer.write(student_names[i] +" "+ student_marks[i] +" " + student_grade[i]+"\n");
                    }

                    writer.close();
                    fout.close();
                    System.out.print("""
                            Report successfully saved to file: grades.txt
                            ==================================
                            Session Terminated...Goodbye 
                            """);
                }catch(IOException e){
                    System.out.println("no"+ e);
                }
            }
        }


    }
}
