package OIB_Internsship_Projects;
// Number Guessing Game.
import java.util.*;
class game{
    int si,ui,guesses=0;

    //Using constructor to generate random numbers
    game(){
        Random r = new Random();
        this.si = r.nextInt(100)+1;
    }

    public boolean UserInput() {
        if(guesses < 10) {
            System.out.println("Guess the Number:- ");
            this.ui = Task_2.takeIntegerInput(100);
            guesses++;
            return false;
        }
        else {
            System.out.println("You have Exceeded the Number of Attempts. Try Again!\n");
            return true;
        }
    }

    //Checking the Guesses
    public boolean CorrectGuess() {
        if(si == ui) {
            System.out.println("Congratulations! Your Guess is Correct "+si+" in "+guesses+" Guesses");
            switch(guesses) {
                case 1:
                    System.out.println("--Score is 100--");
                    break;
                case 2:
                    System.out.println("--Score is 90--");
                    break;
                case 3:
                    System.out.println("--Score is 80--");
                    break;
                case 4:
                    System.out.println("--Score is 70--");
                    break;
                case 5:
                    System.out.println("--Score is 60--");
                    break;
                case 6:
                    System.out.println("--Score is 50--");
                    break;
                case 7:
                    System.out.println("--Score is 40--");
                    break;
                case 8:
                    System.out.println("--Score is 30--");
                    break;
                case 9:
                    System.out.println("--Score is 20--");
                    break;
                case 10:
                    System.out.println("--Score is 10--");
                    break;
            }
            System.out.println();
            return true;
        }
        else if(guesses < 10 && ui > si) {
            if(ui-si>10) {
                System.out.println("Its too High");
            }
            else {
                System.out.println("Its High but Quite near");
            }
        }
        else if(guesses < 10 && ui < si) {
            if(ui-si>10) {
                System.out.println("Its Too Less");
            }
            else {
                System.out.println("Its less");
            }
        }
        return false;
    }
}

//The Main Class
public class Task_2 {
    //Exception handling and input handling part

    public static int takeIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;

        while(!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag=true;

                if(flag && input > limit || input < 1) {
                    System.out.println("Pick a number between 1 to"+limit);
                    flag = false;
                }
            }
            catch(Exception e) {
                System.out.println("Enter Integer only !");
                flag=false;
            }
        };
        return input;
    }
    //main method
    public static void main(String[] args) {
        System.out.println("Enter 1 to Start and 2 for Exit");
        int choice = takeIntegerInput(2);
        int nextround = 1;
        int totalrounds = 0;
        System.out.println("1.Let's Start the Game \n2. Exit");
        System.out.println("Enter your choice below : ");

        if(choice == 1) {
            while(nextround == 1) {
                //Object of class
                game g = new game();
                boolean isMatched = false;
                boolean islimitcross = false;
                System.out.println("\n Round "+ ++totalrounds+" Starts here...");

                //Correct Guesses Check
                while(!isMatched && !islimitcross) {
                    islimitcross = g.UserInput();
                    isMatched = g.CorrectGuess();
                }
            }
            //User Input for next round
            System.out.println("1. Next Round\n2.Exit");
            System.out.println("Enter Your Choice: ");
            nextround = takeIntegerInput(2);
            if( nextround !=1) {
                System.exit(0);
            }

        }
        else {
            System.exit(0);
        }
    }
}
