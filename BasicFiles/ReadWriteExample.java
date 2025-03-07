package BasicFiles;
import java.io.*;
import java.util.Scanner;
public class ReadWriteExample {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File myFile = new File("fun.txt");
        Scanner sc = new Scanner(System.in);
		try {
            //The true is to set to append mode
			FileWriter fout = new FileWriter(myFile, true);
			BufferedWriter writer = new BufferedWriter(fout);

			//write info to file
			String input = "";

			do {
				System.out.print("Enter some text (Q to quit): ");
				input = sc.nextLine();
                System.out.print("test");
				if (input.equalsIgnoreCase("Q")) break;
				writer.write(input + "\n");
			}while (!input.equalsIgnoreCase("Q"));

			writer.close();
			fout.close();
			System.out.println("File writing successful.");

		} catch (IOException e) {
			System.out.print("Error writing to file: ");
			System.out.println(e.getMessage());
		}

        //Reading from file
        try {
            FileReader fin = new FileReader(new File("names.txt"));
            BufferedReader reader = new BufferedReader(fin);

            //read information from file
            String line = "";
            System.out.println("Here is the info in your file: ");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
            fin.close();

        } catch (FileNotFoundException e) {
            System.out.print("Error accessing file: ");
            System.out.println(e.getMessage());
        }catch (IOException e) {
            System.out.print("Error reading file: ");
            System.out.println(e.getMessage());
        }
    }

}
