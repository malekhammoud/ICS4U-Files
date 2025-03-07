package BasicFiles;

import java.util.Scanner;

public class encryption {
    static String encrypt(String plainText, int encrypt) {
        String cycleabc;
        String cycle;
        if (encrypt == 0) {
            cycleabc = "abcdefghijklmnopqrstuvwxyz";
            cycle = "defghijklmnopqrstuvwxyzabc";
        }else {
            cycle = "abcdefghijklmnopqrstuvwxyz";
            cycleabc = "defghijklmnopqrstuvwxyzabc";
        }
        String encryptedText = "";
        for (int i = 0; i < plainText.length(); i++) {
            char currentChar = plainText.charAt(i);
            int currentCharIndex = cycle.indexOf(currentChar);
            if (currentCharIndex == -1) {
                encryptedText += currentChar;
            }else{
                encryptedText+= cycleabc.charAt(currentCharIndex);
            }
        }
        return encryptedText;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            try{
                System.out.println("Encrypt[0] or Decrypt[1]");
                int status = Integer.valueOf(sc.nextLine());

                System.out.println("Enter text: ");
                String plainText = sc.nextLine();
                String encryptedText = encrypt(plainText, status);
                System.out.println(encryptedText);

            }catch(Exception e){
                System.out.println("Invalid input!");
                System.out.println(e);
                continue;
            }
        }
    }
}
