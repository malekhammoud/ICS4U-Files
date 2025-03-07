import java.util.Scanner;

public class RPSLS {
    String[] options = {"Rock", "Paper", "Scissors", "Lizard", "Spock"};
    static int[][] winners = {
            {-1, 1, 0, 0, 0},
            {0, -1, 0, 0, 0},
            {1, 0, -1, 0, 0},
            {1, 0, 0, -1, 0},
            {0, 0, 0, 0, -1},
    };
    public static int winner(int a, int b){
        return(winners[a][b]);
    }
    public static void main(String[] args) {
        System.out.println("""
                Rock, Paper, Scissors, Lizard, Spock
                ====================================
                Rules of the Game:
                You will choose your throw. I will choose my throw. The winner will be determined based on the the following rules:
                ROCK breaks SCISSORS and crushes LIZARD
                PAPER covers ROCK and disproves SPOCK
                SCISSORS cuts PAPER and decapitates LIZARD
                LIZARD poisons SPOCK and eats PAPER
                SPOCK breaks SCISSORS and vaporizes ROCK
                ==========================================
                """);
        int count = 0;
        int wins = 0;
        int loses = 0;
        int ties = 0;
            while (true){
                int computer =(int) (Math.random()*5)-1;
                try{
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Choice: ");
                    int input = sc.nextInt();
                    if (input < 0 || input > 5){
                        throw new Exception();
                    };
                    int win = winner(input, computer);
                    if (win == 0){
                        System.out.println("you win!");
                        wins+=1;
                    }else if (win == 1){
                        System.out.println("you lose!");
                        loses+=1;
                    }else{
                        System.out.println("tie!");
                        ties+=1;
                    }
                    count++;

                    System.out.print("Would you like to play again? (Y/N): ");
                    String in = sc.nextLine();
                    if (in.startsWith("N")){
                        break;
                    }


                } catch (Exception e) {
                    System.out.println("Invalid input!");
                    continue;
                }
            }
            System.out.printf("Win: %d Losses: $d ties:%d\n",wins, loses, ties);
    }
}
