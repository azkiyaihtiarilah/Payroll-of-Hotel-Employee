import java.util.Scanner;

public class Old {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    private static final String MANAGER_USERNAME = "manager";
    private static final String MANAGER_PASSWORD = "manager123";

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        login(); // Perform login

        int numEmployees;
        char continueInput;

        do {
            System.out.print("Enter the number of employees: ");
            numEmployees = sc.nextInt();
            sc.nextLine(); // Clear newline character

            // Employee data arrays
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

            // Input employee data
            inputEmployeeData(numEmployees, names, positions, salaryPositions, workingHours, overtimeHours,
                    bonusesArray, deductionsArray, insuranceArray, gajiPokokArray, gajiKotorArray, gajiBersihArray);

            // Display payroll information
            displayPayrollInformation(numEmployees, names, positions, gajiKotorArray, gajiBersihArray);

            // Generate payroll receipt
            generatePayrollReceipt(numEmployees, names, positions, gajiKotorArray, gajiBersihArray);

            // Ask if the user wants to input data for more employees
            System.out.print("\nDo you want to input data for more employees? (y/n): ");
            continueInput = sc.next().charAt(0);
            sc.nextLine(); // Clear newline character

        } while (continueInput == 'y' || continueInput == 'Y');

        System.out.println("Thank you for using the Payroll System!");
    }

    private static void login() {
        System.out.println("Login to Payroll System");

        // Loop for login attempts
        for (int attempts = 3; attempts > 0; attempts--) {
            System.out.print("Enter username: ");
            String username = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();

            // Check login credentials
            if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                System.out.println("Login successful as Admin.");
                return;
            } else if (username.equals(MANAGER_USERNAME) && password.equals(MANAGER_PASSWORD)) {
                System.out.println("Login successful as Manager.");
                return;
            } else {
                System.out.println("Invalid credentials. Attempts left: " + (attempts - 1));
            }
        }

        System.out.println("Login failed. Exiting program.");
        System.exit(0);
    }

    private static void inputEmployeeData(int numEmployees, String[] names, String[] positions,
            int[] salaryPositions, int[] workingHours, int[] overtimeHours, int[] bonusesArray,
            int[] deductionsArray, int[] insuranceArray, double[] gajiPokokArray, double[] gajiKotorArray,
            double[] gajiBersihArray) {
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
            sc.nextLine(); // Clear newline character

            // Calculate base salary based on position
            calculateBaseSalary(j, positions, salaryPositions, workingHours, overtimeHours, bonusesArray, gajiPokokArray);

            // Calculate gross and net salary
            calculateSalary(j, gajiPokokArray, bonusesArray, deductionsArray, insuranceArray, gajiKotorArray, gajiBersihArray);
        }
    }

    private static void calculateBaseSalary(int j, String[] positions, int[] salaryPositions, int[] workingHours,
            int[] overtimeHours, int[] bonusesArray, double[] gajiPokokArray) {
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
    }

    private static void calculateSalary(int j, double[] gajiPokokArray, int[] bonusesArray, int[] deductionsArray,
            int[] insuranceArray, double[] gajiKotorArray, double[] gajiBersihArray) {
        gajiKotorArray[j] = gajiPokokArray[j] + bonusesArray[j];
        gajiBersihArray[j] = gajiKotorArray[j] - deductionsArray[j] - insuranceArray[j];
    }

    private static void displayPayrollInformation(int numEmployees, String[] names, String[] positions,
            double[] gajiKotorArray, double[] gajiBersihArray) {
        for (int j = 0; j < numEmployees; j++) {
            System.out.println("\nPayroll Hotel Employee " + (j + 1) + " Data:");
            System.out.println("Name of Hotel Employee \t: " + names[j]);
            System.out.println("Current Position \t\t: " + positions[j]);
            System.out.println("Total Salary \t \t\t: " + gajiKotorArray[j]);
            System.out.println("Total Net Salary \t\t: " + gajiBersihArray[j]);
        }
    }

    private static void generatePayrollReceipt(int numEmployees, String[] names, String[] positions,
            double[] gajiKotorArray, double[] gajiBersihArray) {
        System.out.println("\nPayroll Receipts:");

        for (int j = 0; j < numEmployees; j++) {
            System.out.println("\nPayroll Receipt for Hotel Employee " + (j + 1) + ":");
            System.out.println("Name of Hotel Employee \t: " + names[j]);
            System.out.println("Current Position \t\t: " + positions[j]);
            System.out.println("Total Salary \t \t\t: " + gajiKotorArray[j]);
            System.out.println("Total Net Salary \t\t: " + gajiBersihArray[j]);
        }
    }
}
