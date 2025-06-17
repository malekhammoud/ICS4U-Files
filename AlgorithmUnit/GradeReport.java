package AlgorithmUnit;
import java.io.*;
import java.util.Scanner;

public class GradeReport {

    /**
     * Sorts student data from highest mark to lowest mark
     * @param mark		Array storing all student marks
     * @param names		Array storing all student names
     * @param grades	Array storing all student letter grades
     */
    static void sortStudents(int[] mark, String[] names, char[] grades) {
        for (int i = 0; i < mark.length; i++) {
            for (int j = i; j < mark.length; j++) {
                if (mark[j] > mark[i]) {
                    /*
                     * If we need to swap students around, swap in all 3 arrays
                     */
                    int tempM = mark[i];
                    mark[i] = mark[j];
                    mark[j] = tempM;

                    String tempN = names[i];
                    names[i] = names[j];
                    names[j] = tempN;

                    char tempG = grades[i];
                    grades[i] = grades[j];
                    grades[j] = tempG;
                }
            }
        }
    }


    public static void main(String[] args) {
        char[] grades;
        String[] names;
        int[] marks;
        Scanner input = new Scanner(System.in);

        //Prompt user for class size and set sizes of all arrays
        System.out.print("How many students in the class? ");
        int numStud = input.nextInt();
        input.nextLine();
        grades = new char[numStud];
        names = new String[numStud];
        marks = new int[numStud];

        //Prompt user for each student's information
        for (int i = 0; i < marks.length; i++) {
            System.out.println("===================================================");
            System.out.printf("Enter name for Student %d: ", (i+1));
            names[i] = input.nextLine();
            System.out.printf("Enter %s's Mark: ", names[i]);
            marks[i] = input.nextInt();
            input.nextLine();
            int n = marks[i] / 10;

            //Determine the letter grade. Use + for A+ and ! for an invalid mark
            switch(n) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4: grades[i] = 'F'; break;
                case 5: grades[i] = 'D'; break;
                case 6: grades[i] = 'C'; break;
                case 7: grades[i] = 'B'; break;
                case 8: grades[i] = 'A'; break;
                case 9:
                case 10:grades[i] = '+'; break;
                default: grades[i] = '!'; break;
            }
        }

        //Sort data from highest mark to lowest mark
        sortStudents(marks, names, grades);

        try {
            FileWriter fout = new FileWriter(new File("report.txt"));
            BufferedWriter writer = new BufferedWriter(fout);

            //Write data to file, each student with their own line
            for (int i = 0; i < marks.length; i++) {
                String line = names[i] + "\t" + marks[i] + "%\t" + grades[i];
                line = line.replace("+", "A+");
                line = line.replace("!", "Invalid");
                writer.write(line);
                writer.newLine();
            }
            writer.close();
            fout.close();
            System.out.println("File writing successful.");
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }
    }

}

