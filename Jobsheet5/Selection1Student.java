import java.util.Scanner;

public class Selection1Student {

    public static void main(String[] args) {
        Scanner input01 = new Scanner(System.in);

        System.out.print("Input a Number = ");
        int number = input01.nextInt();

        String result = (number % 2 == 0) ? (number + " is an even number!") : (number + " is an odd number!");

        System.out.println(result);
    }
}