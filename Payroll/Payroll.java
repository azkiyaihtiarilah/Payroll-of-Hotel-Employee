import java.util.Scanner;

public class Payroll {

    // Array untuk menyimpan data karyawan
    public static String[][] dataKaryawan = {
            {"Azkiya", "Direktur", "5000000"},
            {"Amilil", "Manager", "4000000"},
            {"Kiki", "Staff", "3000000"}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login
        String jabatanLogin = login();

        if (jabatanLogin != null) {
            int menu;
            do {
                // Menampilkan menu sesuai jabatan
                System.out.println("\n=== Menu ===");
                if (jabatanLogin.equalsIgnoreCase("Direktur")) {
                    System.out.println("1. Kalkulasi Gaji");
                }
                System.out.println("2. Pencarian Data Karyawan");
                System.out.println("3. Exit");
                System.out.print("Pilih menu (1/2/3): ");
                menu = scanner.nextInt();

                switch (menu) {
                    case 1:
                        if (jabatanLogin.equalsIgnoreCase("Direktur")) {
                            kalkulasiGaji();
                        } else {
                            System.out.println("Anda tidak memiliki hak akses untuk fitur ini.");
                        }
                        break;
                    case 2:
                        cariDataKaryawan();
                        break;
                }
            } while (menu != 3);
        }
    }

    // Fungsinya untuk login dan mengembalikan jabatan
    public static String login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        
        for (String[] karyawan : dataKaryawan) {
            if (username.equalsIgnoreCase(karyawan[0]) && password.equals("password")) {
                System.out.println("Login berhasil!");
                return karyawan[1]; // Mengembalikan jabatan
            }
        }

        System.out.println("Login gagal. Coba lagi.");
        return null;
    }

    
    // untuk kalkulasi gaji
    public static void kalkulasiGaji() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama karyawan: ");
        String namaKaryawan = scanner.nextLine();

    // Cari karyawan berdasarkan nama
        int indexKaryawan = -1;
            for (int i = 0; i < dataKaryawan.length; i++) {
                if (namaKaryawan.equalsIgnoreCase(dataKaryawan[i][0])) {
                indexKaryawan = i;
                break;
            }
        }

    if (indexKaryawan != -1) {
        String jabatan = dataKaryawan[indexKaryawan][1];
        double gajiPokok = Double.parseDouble(dataKaryawan[indexKaryawan][2]);

        // Input bonus gaji
        System.out.print("Masukkan bonus gaji: ");
        double bonusGaji = scanner.nextDouble();

        // Input pemotongan gaji
        System.out.print("Masukkan pemotongan gaji: ");
        double pemotonganGaji = scanner.nextDouble();

        // Input asuransi
        System.out.print("Masukkan asuransi: ");
        double asuransi = scanner.nextDouble();

        // Kalkulasi gaji
        double gajiTotal = gajiPokok + bonusGaji - pemotonganGaji - asuransi;

        // Tampilkan kuitansi gaji
        tampilkanKuitansi(namaKaryawan, jabatan, gajiTotal, gajiPokok);
    } else {
        System.out.println("Karyawan tidak ditemukan.");
    }
}


    // untuk mencari data karyawan
    public static void cariDataKaryawan() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama karyawan: ");
        String namaKaryawan = scanner.nextLine();

        // Cari karyawan berdasarkan nama
        int indexKaryawan = -1;
        for (int i = 0; i < dataKaryawan.length; i++) {
            if (namaKaryawan.equalsIgnoreCase(dataKaryawan[i][0])) {
                indexKaryawan = i;
                break;
            }
        }

        if (indexKaryawan != -1) {
            System.out.println("\nData Karyawan:");
            System.out.println("Nama: " + dataKaryawan[indexKaryawan][0]);
            System.out.println("Jabatan: " + dataKaryawan[indexKaryawan][1]);
            System.out.println("Gaji Pokok: " + dataKaryawan[indexKaryawan][2]);
        } else {
            System.out.println("Karyawan tidak ditemukan.");
        }
    }

    // untuk menampilkan kuitansi gaji
    public static void tampilkanKuitansi(String nama, String jabatan, double gajiTotal, double gajiPokok) {
        System.out.println("\n=== Kuitansi Gaji ===");
        System.out.println("Nama: " + nama);
        System.out.println("Jabatan: " + jabatan);
        System.out.println("Gaji Pokok: " + gajiPokok);
        System.out.println("Gaji Total: " + gajiTotal);
    }
}
