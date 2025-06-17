import java.io.*;

/**
 * Create a WordCounter program that reads in the text from a file and counts the number of words in the text.
 * Consider a word to be any sequence of 1+ letters that ends with a non-letter symbol.
 * For example, "forty-nine" would be considered 2 words, since they are separated by the non-letter symbol "-".
 */
public class WordCounter {

    public static void main(String[] args) {
        File story = new File("AlgorithmUnit/story.txt");
        final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String line;	//stores a line of text from the file
        char[] letters;	//stores each character in line
        int numWords = 0;	//counts number of words in total in file

        try {
            FileReader in = new FileReader(story);
            BufferedReader reader = new BufferedReader(in);
            //Read in each line of the file, one at at time
            while ((line = reader.readLine()) != null) {
                int  wordsPerLine = 1;	//count total words in a single line of text
                letters = line.toUpperCase().toCharArray();

                /*
                 * Look through the text for non-letter symbols. These will be used to separate words
                 * Ignore multiple non-letter symbols in a row. For example, ", " would separate 2 words, not 3
                 * Don't count punctuation at the end of lines either
                 */
                for (int i = 0; i < letters.length; i++) {
                    //Check if a symbol is a non-letter and NOT the last symbol in a line
                    if (ALPHA.indexOf(letters[i]) < 0 && i+1 < letters.length) {
                        //Make sure we account for multiple non-letters in a row
                        if (ALPHA.indexOf(letters[i+1]) >= 0) {
                            wordsPerLine ++;
                        }
                    }
                }
                //increase total word count for the program
                numWords += wordsPerLine;
            }

            reader.close();
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Can't find the file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }

        //Display result of counting
        System.out.println("The text has " + numWords + " words.");
    }

}
