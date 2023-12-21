import java.util.Scanner;
import java.util.Date;

/**
 * Payrollv7
 */
public class FinalProject {

    //import from java util
    static Scanner sc = new Scanner(System.in);
    static Date tanggal = new Date();

    //variabel statis untuk menyimpan true or false 
    static boolean menuProcess, mainProcess, validationAdmin, validationKaryawan;

    //variabel statis untuk case
    static int menu;

    //variabel statis untuk menyimpan objek 
    static String[] nama = new String[100];
    static int[] id = new int[100];
    static String gender[] = new String[100];
    static String jenisK;
    static int[] age = new int[100];
    static String alamat[] = new String[100];
    static String jobTitle[] = new String[100];
    static int jamLembur[] = new int[100];
    static int[] gajiDesember = new int[100];

    //variabel statis untuk menyimpan objek role multilevel
    static String[][] userMain = { { "admin", "employee" }, { "1234", "5678" } };
    static String[][] getUser = new String[2][2];

    //variabel statis untuk menyimpan objek ranah gaji
    static int hitungPegawai = 2, gajiPokok, tunjangan, lembur = 10000, gajiLembur, pajak = 0;
    static int[] totalGaji = new int[100];

    //variabel statis untuk menyimpan objek
    static int displayAll;
    static double pajakBilangan;

    //inisialisasi statis mengisi data master karyawan
    static {
        for (int i = 0; i <= hitungPegawai; i++) {

            nama[0] = "Azkiya";
            id[0] = 101;
            gender[0] = "Female";
            age[0] = 21;
            alamat[0] = "Jl. Kepundung No. 123";
            jobTitle[0] = "A";
            jamLembur[0] = 5;
            gajiDesember[0] = calculateSalary(0);

            nama[1] = "Amilil";
            id[1] = 102;
            gender[1] = "Male";
            age[1] = 25;
            alamat[1] = "Jl. Coklat No. 456";
            jobTitle[1] = "B";
            jamLembur[1] = 3;
            gajiDesember[1] = calculateSalary(1);

            nama[2] = "Kiki";
            id[2] = 101;
            gender[2] = "Male";
            age[2] = 28;
            alamat[2] = "Jl. Contoh No. 123";
            jobTitle[2] = "C";
            jamLembur[2] = 5;
            gajiDesember[2] = calculateSalary(2);

            nama[3] = "Muhammad";
            id[3] = 302;
            gender[3] = "Male";
            age[3] = 25;
            alamat[3] = "Jl. Contoh No. 456";
            jobTitle[3] = "D";
            jamLembur[3] = 3;
            gajiDesember[3] = calculateSalary(3);
        }
        hitungPegawai++;
    }

    // validation Admin function
    static boolean validationAdmin(String username, String password) {
        return username.equals(userMain[0][0]) && password.equals(userMain[1][0]);
    }

    // validation Karyawan function
    static boolean validationKaryawan(String username, String password) {
        return username.equals(userMain[0][1]) && password.equals(userMain[1][1]);
    }

    //calculate Salary Karyawan function
    static int calculateSalary(int index) {

        totalGaji[index] = gajiPokok + tunjangan + gajiLembur - pajak;
        gajiDesember[index] = totalGaji[index];

        return totalGaji[index];
    }

    //calculate Gaji Karyawan function
    static void perhitungan(int x) {
        if (jobTitle[x].equalsIgnoreCase("a")) {
            gajiPokok = 1000000;
            tunjangan = 500000;
        } else if (jobTitle[x].equalsIgnoreCase("b")) {
            gajiPokok = 1500000;
            tunjangan = 700000;
        } else if (jobTitle[x].equalsIgnoreCase("c")) {
            gajiPokok = 2000000;
            tunjangan = 900000;
        } else if (jobTitle[x].equalsIgnoreCase("d")) {
            gajiPokok = 2500000;
            tunjangan = 1200000;
        }

        gajiLembur = jamLembur[x] * lembur;
        totalGaji[x] = (gajiPokok + tunjangan + gajiLembur);

    }

    //calculate tax
    static void cekPajak(int x) {
        if (totalGaji[x] > 450000) {
            pajak = 5;
        } else if (totalGaji[x] > 1250000) {
            pajak = 15;
        } else if (totalGaji[x] > 2050000) {
            pajak = 25;
        }

        int totalPajak = totalGaji[x] * pajak / 100;
        totalGaji[x] -= totalPajak;
    }

    // login page admin function
    static void loginPageAdmin() {
        System.out.println(" ════════════════════════════════════════════════════════════════ ");
        System.out.println("                           LOGIN                                  ");
        System.out.println(" ════════════════════════════════════════════════════════════════ ");

        System.out.print("Masukan Username : ");
        getUser[0][0] = sc.nextLine();
        System.out.print("Masukan Password : ");
        getUser[1][0] = sc.nextLine();
        System.out.println();
        validationAdmin = validationAdmin(getUser[0][0], getUser[1][0]);
    }

    // login page karywan
    static void loginKaryawan() {
        System.out.println(" ════════════════════════════════════════════════════════════════ ");
        System.out.println("                           LOGIN                                  ");
        System.out.println(" ════════════════════════════════════════════════════════════════ ");

        System.out.print("Masukan Username : ");
        getUser[0][0] = sc.nextLine();
        System.out.print("Masukan Password : ");
        getUser[1][0] = sc.nextLine();
        System.out.println();
        validationKaryawan = validationKaryawan(getUser[0][0], getUser[1][0]);
    }

    // data karyawan function
    static void employeeData() {
        int kode = 0;
        do {
            System.out.println();
            System.out.println("============================================");
            System.out.println("             Employee Data Menu             ");
            System.out.println("============================================");
            System.out.println(" [1] Input Employee Data                    ");
            System.out.println(" [2] Show Employee Data                     ");
            System.out.println(" [3] Edit Employee Data                     ");
            System.out.println(" [4] Total Employee Data                    ");
            System.out.println(" [5] Back                                   ");
            System.out.println("============================================");
            System.out.print("Enter Choice\t: ");
            kode = sc.nextInt();
            sc.nextLine();
            System.out.println("");
            if (kode == 1) {
                int j;
                //tring find to empty space(slot)
                for (j = 0; j < nama.length; j++) {
                    if (nama[j] == null) {
                        break; // Found an empty slot, break the loop
                    }
                }
                //handling when the Array is Full
                if (j == nama.length) {
                    System.out.println("Cannot add more, The Employee data is full! ");
                    continue; // Go back to the main loop
                }

                // Input data into the first empty slot
                System.out.print("Employee Name\t: ");
                nama[j] = sc.nextLine();
                System.out.print("Number ID\t: ");
                id[j] = sc.nextInt();
                System.out.print("Gender (M/F)\t: ");
                sc.nextLine(); // Consume the newline character
                jenisK = sc.nextLine();
                System.out.print("Age\t\t: ");
                age[j] = sc.nextInt();
                System.out.print("Address\t\t: ");
                sc.nextLine(); // Consume the newline character
                alamat[j] = sc.nextLine();

                //Select job title
                System.out.println("-----------------------------");
                System.out.println("          Job Title          ");
                System.out.println("-----------------------------");
                System.out.println("  A = Housekeeping           ");
                System.out.println("  B = Bartender              ");
                System.out.println("  C = Front Office           ");
                System.out.println("  D = Manager                ");
                System.out.println("-----------------------------");
                System.out.print("Class Input |A|B|C|D|: ");
                jobTitle[j] = sc.nextLine();
                System.out.print("Input Overtime Time (Hours): ");
                jamLembur[j] = sc.nextInt();

                //select gender 
                if (jenisK.equalsIgnoreCase("f")) {
                    gender[j] = "Female";
                } else if (jenisK.equalsIgnoreCase("m")) {
                    gender[j] = "Male";
                } else {
                    gender[j] = "Neutral Gender"; //kesalahan input jenis atau menyembunyikan identitas
                }
                //menambahkan nilai dari jumlah total karyawan - karyawan baru diinputkan
                hitungPegawai++;

            //show data employee
            } if (kode == 2) {
                for (int i = 0; i <= hitungPegawai; i++) {
                    System.out.println("══════════════════════════════════════════════");
                    System.out.println("   Employee Name   : " + nama[i] + "                 ");
                    System.out.println("   Class Employee  : " + jobTitle[i] + "                        ");
                    System.out.println("   Number ID       : " + id[i] + "                      ");
                    System.out.println("   Gender          : " + gender[i] + "                ");
                    System.out.println("   Address         : " + alamat[i] + "       ");
                    System.out.println("   Age             : " + age[i] + "                       ");
                    System.out.println("══════════════════════════════════════════════");
                }
            //edit data employee
            } else if (kode == 3) {
                System.out.print("Enter Employee Name : ");
                String nama2 = sc.nextLine();
                for (int i = 0; i <= hitungPegawai; i++) {
                    if (nama[i].equalsIgnoreCase(nama2)) {
                        //adding biodata
                        System.out.print("Employee Name     : ");
                        nama[i] = sc.nextLine();
                        System.out.print("Number ID         : ");
                        id[i] = sc.nextInt();
                        System.out.print("Gender (M/F)      : ");
                        jenisK = sc.nextLine();
                        sc.nextLine();
                        System.out.print("Age               : ");
                        age[i] = sc.nextInt();
                        System.out.print("Address           : ");
                        sc.nextLine();
                        alamat[i] = sc.nextLine();
                        // select Job Title
                        System.out.println("-----------------------------");
                        System.out.println("         Job Title           ");
                        System.out.println("-----------------------------");
                        System.out.println("  A = Housekeeping           ");
                        System.out.println("  B = Bartender              ");
                        System.out.println("  C = Front Office           ");
                        System.out.println("  D = Manager                ");
                        System.out.println("-----------------------------");
                        System.out.print("Class Input |A|B|C|D|: ");
                        jobTitle[i] = sc.nextLine();
                        System.out.print("Input Overtime Time (Hours) : ");
                        jamLembur[i] = sc.nextInt();

                        //select gender
                        if (jenisK.equalsIgnoreCase("f")) {
                            gender[i] = "Female";
                        } else if (jenisK.equalsIgnoreCase("m")) {
                            gender[i] = "Male";
                        } else {
                            gender[i] = "Neutral Gender";
                        }
                        break;
                    //tidak menemukan data yang sesuai
                    } else if (i == hitungPegawai) {
                        System.out.println("The Name You Entered is Not Registered!");
                    }
                }
            //Calculating total employee
            } else if (kode == 4) {
                int housekeeping = 0, bartender = 0,  frontOffice = 0, manajer = 0;
                for (int i = 0; i <= hitungPegawai; i++) {
                    if (jobTitle[i].equalsIgnoreCase("a")) {
                        housekeeping++;
                    } else if (jobTitle[i].equalsIgnoreCase("b")) {
                        bartender++;
                    } else if (jobTitle[i].equalsIgnoreCase("c")) {
                        frontOffice++;
                    } else if (jobTitle[i].equalsIgnoreCase("d")) {
                        manajer++;
                    }
                }
                System.out.println("-----------------------------------------------------------------");
                System.out.println(
                                   "                   Total Number of Employees                    ");
                System.out.println("-----------------------------------------------------------------");

                System.out.println(" Total Number of Housekeeping          : " + housekeeping + " Employee ");
                System.out.println(" Total Number of Bartender             : " + bartender + " Employee    ");
                System.out.println(" Total Number of Front Office          : " + frontOffice + " Employee  ");
                System.out.println(" Total Number of Managers              : " + manajer + " Employee      ");
                System.out.println("------------------------------------------------------------------");
                System.out.println(" Total Number of Employees             : " + (hitungPegawai + 1) + " Employee");
                System.out.println("------------------------------------------------------------------");
            }
        //keluar dari program
        } while (kode != 5);
    }

    //cetak slip
    static void cetakSlip(int x) {
        perhitungan(x);
        cekPajak(x);

        System.out.println("-------------------------------------------------------------");
        System.out.println("                      Employee Pay Slip                      ");
        System.out.println("-------------------------------------------------------------");

        System.out.printf(" Date                 : %s \n", tanggal);
        System.out.printf(" Name                 : %s \n", nama[x]);
        System.out.printf(" Base Salary          : Rp.%s \n", +gajiPokok);
        System.out.printf(" Overtime Salary      : Rp.%s \n", gajiLembur);
        System.out.printf(" Allowance Money      : Rp.%s \n", tunjangan);
        System.out.printf(" Tax (Percentage)     : %s \n", pajak + "%");
        System.out.printf(" Tax (Numeric)        : Rp.%s \n", pajakBilangan);
        System.out.printf(" Salary Received      : Rp.%s \n", totalGaji[x]);
        System.out.println("------------------------------------------------------------");
        System.out.println();
    }

    //Employee calculating function
    static void calculateSlry() {
        System.out.println("-------------------------------------------------------------");
        System.out.println("              Employee Salary Calculation                ");
        System.out.println("-----------------------------------------------------------");

        // Display the input prompt in a box for displayAll
        System.out.println("════════════════════════════════════════════════════════════");
        System.out.println(" Display salaries for all employees? |1 for Yes|2 for Selection|: ");
        System.out.println("════════════════════════════════════════════════════════════");
        System.out.print("Enter here: ");
        int displayAll = sc.nextInt();
        sc.nextLine(); // Consume the newline character
           
            if (displayAll == 1) {
                // Display salaries for all employees
                for (int i = 0; i <= hitungPegawai; i++) {
                    cetakSlip(i);
                    pajakBilangan = (pajak / 100.0) * totalGaji[i];
                }
            } else {
                // Display salary for a specific employee
                System.out.print("Enter Employee Name : ");
                String nama2 = sc.nextLine();
                for (int i = 0; i <= hitungPegawai; i++) {
                    pajakBilangan = (pajak / 100.0) * totalGaji[i];
                    if (nama[i].equalsIgnoreCase(nama2)) {
                        cetakSlip(i);
                        break;
                    } else if (i == hitungPegawai) {
                        System.out.println("The Name You Entered is Not Registered!");
                    }
                }
       
        } // Consume the newline character

    }

    //Employee report function
    static void report() {
        // Display the input prompt in a box for displayAll
        System.out.println("════════════════════════════════════════════════════════════");
        System.out.println("                 Employee Report All Data                ");
        System.out.println("════════════════════════════════════════════════════════════");
        
        // Display salaries for all employees
        for (int i = 0; i <= hitungPegawai; i++) {
            cetakSlip(i);
            pajakBilangan = (pajak / 100.0) * totalGaji[i];
        }
    }

    //Sreaching function
    static void searching() {
        System.out.println("-----------------------------------------");
        System.out.println("              Search Options             ");
        System.out.println("-----------------------------------------");
        System.out.println(" [1] Search by Name                      ");
        System.out.println(" [2] Search by Employee Number           ");
        System.out.println(" [3] Cancel                              ");
        System.out.println("-----------------------------------------");
        System.out.print("Enter Choice |1|2|3|: ");

        int masukan = sc.nextInt();
        sc.nextLine();
        int cari = 0;

        if (masukan == 1) {
            System.out.print("Enter Employee Name  : ");
            String nama2 = sc.nextLine();
            System.out.println("");
            for (int i = 0; i <= hitungPegawai; i++) {
                if (nama[i].equalsIgnoreCase(nama2)) {
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("                       Search Results                     ");
                    System.out.println("----------------------------------------------------------");

                    System.out.println(" Employee Name    : " + nama[i] + "                           |");
                    System.out.println(" Job Title            : " + jobTitle[i] + "                                    |");
                    System.out.println(" Gender           : " + gender[i] + "                            |");
                    System.out.println(" Address          : " + alamat[i] + "                   |");
                    System.out.println(" Age              : " + age[i] + "                                   |");
                    System.out.println(" Employee Number  : " + id[i] + "                                  |");
                    System.out.println("-----------------------------------------------------------");
                    break;
                } else if (i == hitungPegawai) {
                    System.out.println("The Name You Entered is Not Registered!");
                }
            }
        } else if (masukan == 2) {
            System.out.print("Enter Employee Number : ");
            cari = sc.nextInt();
            for (int i = 0; i <= hitungPegawai; i++) {
                if (id[i] == cari) {
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("                       Search Results                      ");
                    System.out.println("-----------------------------------------------------------");
                    System.out.println(" Employee Name    : " + nama[i] + "                           ");
                    System.out.println(" Job Title        : " + jobTitle[i] + "                                    ");
                    System.out.println(" Gender           : " + gender[i] + "                            ");
                    System.out.println(" Address          : " + alamat[i] + "                   ");
                    System.out.println(" Age              : " + age[i] + "                                   ");
                    System.out.println(" Employee Number  : " + id[i] + "                                  ");
                    System.out.println("-----------------------------------------------------------");
                } else if (i == hitungPegawai) {
                    System.out.println("The Name You Entered is Not Registered!");
                }
            }
        }

    }

    public static void main(String[] args) {
        String line = "=================================================================";
        System.out.printf("\n    WELCOME TO THE HOTEL EMPLOYEE PAYROLL SYSTEM \n", line, line);
        System.out.println();

        mainProcess = true;
        System.out.println();

        while (mainProcess) {
            // Menambahkan warna dan font
            System.out.println("PLEASE LOGIN TO CONTINUE ACCESSING THE PROGRAM");
            System.out.println("═════════════════════════════════════════════════");
            System.out.println(" 1. Login Admin                                  ");
            System.out.println(" 2. Login Employee                               ");
            System.out.println(" 3. Exit Program                               ");
            System.out.println("═════════════════════════════════════════════════");
            System.out.print("Select Menu |1|2|3|: ");
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    menuProcess = true;
                    loginPageAdmin();
                    if (validationAdmin) {
                        System.out.println(    "                      Welcome Admin!                        ");

                        while (menuProcess) {
                            System.out.println("=================================================================");
                            System.out.println("                    MENU SELECTIONS                                 ");
                            System.out.println("=================================================================");
                            System.out.println(" [1] Employee Data                                               ");
                            System.out.println(" [2] Salary Calculation                                            ");
                            System.out.println(" [3] Search                                                   ");
                            System.out.println(" [4] Report                                                    ");
                            System.out.println(" [5] Keluar                                                      ");
                            System.out.println("=================================================================");
                            System.out.print("Masukan Menu Pilihan Anda |1|2|3|4|5|: ");
                            menu = sc.nextInt();
                            System.out.println();

                            switch (menu) {
                                case 1:
                                    employeeData();;
                                    System.out.println();
                                    break;
                                case 2:
                                    calculateSlry();
                                    System.out.println();
                                    break;
                                case 3:
                                    searching();
                                    System.out.println();
                                    break;
                                case 4:
                                    report();
                                    System.out.println("This is All Payroll Employee Data Report");
                                    break;
                                case 5:
                                    menuProcess = false;
                                    break;
                                default:
                                    System.out.println();
                                    System.out.println(
                                            "Menu tidak valid! Silahkan Pilih menu dengan benar");
                                    System.out.println();
                                    break;
                            }
                    } 
                }
                case 2:
                    menuProcess = true;
                    loginKaryawan();
                    if (validationKaryawan) {
                        System.out.println("=================================================================");
                        System.out.println("                       Welcome Employees!                        ");
                        System.out.println("=================================================================");

                        while (menuProcess) {
                            employeeData();
                            }
                }
                case 3:
                    menuProcess = true;
                    System.out.println("Thank you for the transaction <3");
                    break;
            }break;   
        }
    }
}