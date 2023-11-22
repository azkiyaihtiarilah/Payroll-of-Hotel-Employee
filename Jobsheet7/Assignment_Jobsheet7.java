import java.util.Scanner;

public class Assignment_Jobsheet7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numEmployees;
        int i = 0;
        char continueInput;

        do {
            System.out.print("Enter the number of employees: ");
            numEmployees = sc.nextInt();
            sc.nextLine(); // Membersihkan newline karakter

            for (int j = 0; j < numEmployees; j++) {
                String name, position;
                int salary_position, working_hours, overtime, bonuses, deductions, insurance;
                double gaji_pokok, gaji_kotor, gaji_bersih;

                System.out.println("\nInput Employee " + (j + 1) + " Data:");
                System.out.print("Input Employee Name \t: ");
                name = sc.nextLine();
                System.out.print("Input Employee Position (director, manager, staff): ");
                position = sc.nextLine();
                System.out.print("Input Salary Position \t: ");
                salary_position = sc.nextInt();
                System.out.print("Input Working Hours \t: ");
                working_hours = sc.nextInt();
                System.out.print("Input Overtime Hours \t: ");
                overtime = sc.nextInt();
                System.out.print("Input Bonuses \t\t: ");
                bonuses = sc.nextInt();
                System.out.print("Input Deductions \t: ");
                deductions = sc.nextInt();
                System.out.print("Input Insurance \t: ");
                insurance = sc.nextInt();
                sc.nextLine(); // Membersihkan newline karakter

                if (position.equalsIgnoreCase("director")) {
                    gaji_pokok = salary_position * working_hours;
                } else if (position.equalsIgnoreCase("manager")) {
                    gaji_pokok = salary_position * working_hours + overtime + bonuses;
                } else if (position.equalsIgnoreCase("staff")) {
                    gaji_pokok = salary_position * working_hours + overtime;
                } else {
                    System.out.println("Invalid position, setting gaji_pokok to 0.");
                    gaji_pokok = 0;
                }

                gaji_kotor = gaji_pokok + bonuses;
                gaji_bersih = gaji_kotor - deductions - insurance;

                System.out.println("\nPayroll Hotel Employee " + (j + 1) + " Data:");
                System.out.println("Name of Hotel Employee \t: " + name);
                System.out.println("Current Position \t\t: " + position);
                System.out.println("Total Salary \t \t\t: " + gaji_kotor);
                System.out.println("Total Net Salary \t\t: " + gaji_bersih);
            }

            System.out.print("\nDo you want to input data for more employees? (y/n): ");
            continueInput = sc.next().charAt(0);
            sc.nextLine(); // Membersihkan newline karakter

            if (continueInput == 'n' || continueInput == 'N') {
                break; // Menghentikan loop jika pengguna memilih 'n' atau 'N'
            } else if (continueInput != 'y' && continueInput != 'Y') {
                System.out.println("Invalid input. Exiting program.");
                return; // Menghentikan program jika input tidak valid
            }

            i++;
        } while (true);

        System.out.println("Thank you for using the Payroll System!");
    }
}
