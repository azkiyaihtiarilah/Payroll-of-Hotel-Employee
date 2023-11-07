import java.util.Scanner;

public class Selection1Student {

    public static void main(String[] args) {
        Scanner input01 = new Scanner(System.in);

        System.out.print("Input a Number = ");
        int number = input01.nextInt();

        if(number%2 == 0){
            System.out.println(number+" is an even number!");
        }else{
            System.out.println(number+ "is an odd number!");
        }
    }
}
