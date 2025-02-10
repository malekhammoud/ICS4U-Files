package BasicFiles;

import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class calculator {
    public static double multipliy(double a, double b) {
        return a*b;
    }
    public static double divide(double a, double b) {
        return a/b;
    }
    public static int subtract(int a, int b) {
        return a - b;
    }
    public static double subtract(double a, double b) {
        return a - b;
    }
    public static int add(int a, int b) {
        return a + b;
    }
    public static double add(double a, double b) {
        return a + b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the equation, (sperated by spaces): ");
        String command = sc.nextLine();
        String[] tokens = command.split("");
        String[] parsedTokens = new String[tokens.length];
        boolean split = false;
        String handel = "";
        int count = 0;

        for (int i = 0; i < tokens.length; i++) {
            if(i+1 < tokens.length){
                if(!(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("x") || tokens[i].equals("/") || i == tokens.length-1 )) {
                    handel += tokens[i];
                }
                else {
                    parsedTokens[count] = handel;
                    count += 1;
                    parsedTokens[count] = tokens[i];
                    count += 1;
                    handel = "";
                }}
            else{
                handel += tokens[i];
                parsedTokens[count] = handel;
            }
        }
        for (int j = 0; j < parsedTokens.length; j++) {
            if (parsedTokens[j] != null) {
                System.out.print(parsedTokens[j]+' ');
            }
        }
        System.out.println();
        double total = 0;
        String operator = "+";
        tokens = parsedTokens;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i]==null){
                break;
            }
            if (tokens[i].equals("+")){
                operator = "+";
            }else if(tokens[i].equals("-")){
                operator = "-";
            }else if(tokens[i].equals("x")){
                operator = "x";
            }else if(tokens[i].equals("/")){
                operator = "/";
            }
            else if (! tokens.equals(" ")){
                if (operator.equals("+")){
                    total = add(total, Integer.valueOf(tokens[i]));
                }else if (operator.equals("-")){
                    total = subtract(total, Integer.valueOf(tokens[i]));
                }else if (operator.equals("x")){
                    total = multipliy(total, Integer.valueOf(tokens[i]));
                }else if (operator.equals("/")){
                    total = divide(total, Double.valueOf(tokens[i]).doubleValue());
                }
            }
        }
        System.out.println("The answer is: " + total);

    }
}
