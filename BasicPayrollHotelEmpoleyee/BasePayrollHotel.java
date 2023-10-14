import java.util.Scanner;

public class BasePayrollHotel {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name, position;
        int salary_position, working_hours, overtime, bonuses, deductions, insurance;
        double gaji_pokok, gaji_kotor, gaji_bersih;

        System.out.println("__________ Input Your Personal Data __________");
        System.out.print("Input employee Name \t: ");
        name = sc.nextLine();
        System.out.print("Input employee position : ");
        position = sc.nextLine();
        System.out.print("Input Salary position \t: ");
        salary_position = sc.nextInt();
        System.out.print("Input Working Hours \t: ");
        working_hours = sc.nextInt();
        System.out.print("Input overtime \t \t: ");
        overtime = sc.nextInt();
        System.out.print("Input bonuses \t \t: ");
        bonuses = sc.nextInt();
        System.out.print("Input deductions \t: ");
        deductions = sc.nextInt();
        System.out.print("Input insurance \t: ");
        insurance = sc.nextInt();

        gaji_pokok = salary_position * working_hours;
        gaji_kotor = gaji_pokok + overtime + bonuses;

        gaji_bersih = gaji_kotor - deductions - insurance;
        
        System.out.println("\t");
        System.out.println("__________ Payroll Hotel employee __________");
        System.out.println("Name of hotel employee \t: "+ name);
        System.out.println("Current position \t: "+ position);
        System.out.println("Total salary \t \t: "+ gaji_kotor);
        System.out.println("Total net salary \t: "+ gaji_bersih);
    }
}