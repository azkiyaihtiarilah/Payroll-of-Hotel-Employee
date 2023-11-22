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
            // Membersihkan newline karakter
            sc.nextLine(); 

            // Membuat array untuk menyimpan data karyawan
            String[] names = new String[numEmployees];
            String[] positions = new String[numEmployees];
            int[] salaryPositions = new int[numEmployees];
            int[] workingHours = new int[numEmployees];
            int[] overtimeHours = new int[numEmployees];
            int[] bonusesArray = new int[numEmployees];
            int[] deductionsArray = new int[numEmployees];
            int[] insuranceArray = new int[numEmployees];
            double[] gajiPokokArray = new double[numEmployees];
            double[] gajiKotorArray = new double[numEmployees];
            double[] gajiBersihArray = new double[numEmployees];

            for (int j = 0; j < numEmployees; j++) {
                System.out.println("\nInput Employee " + (j + 1) + " Data:");
                System.out.print("Input Employee Name \t: ");
                names[j] = sc.nextLine();
                System.out.print("Input Employee Position (director, manager, staff): ");
                positions[j] = sc.nextLine();
                System.out.print("Input Salary Position \t: ");
                salaryPositions[j] = sc.nextInt();
                System.out.print("Input Working Hours \t: ");
                workingHours[j] = sc.nextInt();
                System.out.print("Input Overtime Hours \t: ");
                overtimeHours[j] = sc.nextInt();
                System.out.print("Input Bonuses \t\t: ");
                bonusesArray[j] = sc.nextInt();
                System.out.print("Input Deductions \t: ");
                deductionsArray[j] = sc.nextInt();
                System.out.print("Input Insurance \t: ");
                insuranceArray[j] = sc.nextInt();
                sc.nextLine(); // Membersihkan newline karakter

                if (positions[j].equalsIgnoreCase("director")) {
                    gajiPokokArray[j] = salaryPositions[j] * workingHours[j];
                } else if (positions[j].equalsIgnoreCase("manager")) {
                    gajiPokokArray[j] = salaryPositions[j] * workingHours[j] + overtimeHours[j] + bonusesArray[j];
                } else if (positions[j].equalsIgnoreCase("staff")) {
                    gajiPokokArray[j] = salaryPositions[j] * workingHours[j] + overtimeHours[j];
                } else {
                    System.out.println("Invalid position, setting gaji_pokok to 0.");
                    gajiPokokArray[j] = 0;
                }

                gajiKotorArray[j] = gajiPokokArray[j] + bonusesArray[j];
                gajiBersihArray[j] = gajiKotorArray[j] - deductionsArray[j] - insuranceArray[j];

                System.out.println("\nPayroll Hotel Employee " + (j + 1) + " Data:");
                System.out.println("Name of Hotel Employee \t: " + names[j]);
                System.out.println("Current Position \t\t: " + positions[j]);
                System.out.println("Total Salary \t \t\t: " + gajiKotorArray[j]);
                System.out.println("Total Net Salary \t\t: " + gajiBersihArray[j]);
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
