package BasicFiles;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;

public class arraylist {
    public static void main(String[] args) {
        ArrayList<Integer> numbers= new ArrayList<Integer>();
        numbers.add(10);
        numbers.add(10);
        System.out.println(numbers.get(1));
        if(numbers.get(0) == numbers.get(1)){
            System.out.println("Same value!");
        }else if(numbers.get(0) > numbers.get(1)){
            System.out.println("The first is bigger then the second");
        }else{
            System.out.println("The Second is bigger then the second");
        }
    }
}
