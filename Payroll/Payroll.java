import java.util.Scanner;

public class Payroll {
    // Array untuk menyimpan data karyawan
    public static String[][] dataKaryawan = new String[10][5]; // Ukuran array dapat disesuaikan
    public static int jumlahKaryawan = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input data karyawan
        inputDataKaryawan(scanner);

        // Login
        System.out.println("\n=== Silahkan Login ===\n");
        String jabatanLogin = login();

        if (jabatanLogin != null) {
            int menu;
            do {
                // Menampilkan menu sesuai jabatan
                System.out.println("\n=== Selamat Datang ===");
                System.out.println("\n=== Menu ===");
                System.out.println("1. Kalkulasi Gaji");
                System.out.println("2. Pencarian Data Karyawan");
                System.out.println("3. Laporan Gaji Bulanan");
                System.out.println("4. Exit");
                System.out.print("Pilih menu (1/2/3/4): ");
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
                    case 3:
                        if (jabatanLogin.equalsIgnoreCase("Direktur")) {
                            laporanGajiBulanan();
                        } else {
                            System.out.println("Anda tidak memiliki hak akses untuk fitur ini.");
                        }
                        break;
                }
            } while (menu != 4);
        }
    }

    private static void inputDataKaryawan(Scanner scanner) {
        System.out.print("Masukkan jumlah karyawan yang akan diinput: ");
        int jumlahInput = scanner.nextInt();

        for (int i = 0; i < jumlahInput; i++) {
            scanner.nextLine(); // Membersihkan newline dari buffer
            System.out.println("\nMasukkan data karyawan ke-" + (i + 1) + ":");
            System.out.print("Nama: ");
            dataKaryawan[jumlahKaryawan][0] = scanner.nextLine();
            System.out.print("Jabatan: ");
            dataKaryawan[jumlahKaryawan][1] = scanner.nextLine();
            System.out.print("Gaji Pokok: ");
            dataKaryawan[jumlahKaryawan][2] = scanner.nextLine();
            System.out.print("Nomor Induk Pegawai: ");
            dataKaryawan[jumlahKaryawan][3] = scanner.nextLine();
            System.out.print("Jenis Kepegawaian: ");
            dataKaryawan[jumlahKaryawan][4] = scanner.nextLine();
            jumlahKaryawan++;
        }
    }

    private static void laporanGajiBulanan() {
        System.out.println("\n=== Laporan Gaji Bulanan ===");
        for (int i = 0; i < jumlahKaryawan; i++) {
            String nama = dataKaryawan[i][0];
            String jabatan = dataKaryawan[i][1];
            double gajiPokok = Double.parseDouble(dataKaryawan[i][2]);

            // Placeholder for additional calculations (bonus, deductions, etc.) if needed

            // Example: Calculate monthly total (assuming 12 months)
            double gajiBulanan = gajiPokok * 12;

            // Display the monthly salary for each employee
            System.out.println("Nama: " + nama + ", Jabatan: " + jabatan + ", Gaji Bulanan: " + gajiBulanan);
        }
    }

    private static void cariDataKaryawan() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama karyawan yang ingin dicari: ");
        String namaKaryawan = scanner.nextLine();

        // Cari karyawan berdasarkan nama
        boolean found = false;
        for (String[] karyawan : dataKaryawan) {
            if (namaKaryawan.equalsIgnoreCase(karyawan[0])) {
                found = true;
                System.out.println("\nData Karyawan:");
                System.out.println("Nama: " + karyawan[0]);
                System.out.println("Jabatan: " + karyawan[1]);
                System.out.println("Gaji Pokok: " + karyawan[2]);
                System.out.println("Nomor Induk Pegawai: " + karyawan[3]);
                System.out.println("Jenis Kepegawaian: " + karyawan[4]);
                break;
            }
        }

        if (!found) {
            System.out.println("Karyawan dengan nama '" + namaKaryawan + "' tidak ditemukan.");
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
                System.out.println("\n    Login berhasil!");
                return karyawan[1]; // Mengembalikan jabatan
            }
        }

        System.out.println("Login gagal. Coba lagi.");
        return null;
    }

    // untuk kalkulasi gaji
    public static void kalkulasiGaji() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama karyawan    : ");
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
            System.out.print("Masukkan bonus gaji       : ");
            double bonusGaji = scanner.nextDouble();

            // Input pemotongan gaji
            System.out.print("Masukkan pemotongan gaji  : ");
            double pemotonganGaji = scanner.nextDouble();

            // Input asuransi
            System.out.print("Masukkan asuransi         : ");
            double asuransi = scanner.nextDouble();

            // Perhitungan pajak (contoh: 10% dari gaji pokok)
            double pajak = 0.1 * gajiPokok;

            // Perhitungan tunjangan (contoh: 5% dari gaji pokok)
            double tunjangan = 0.05 * gajiPokok;

            // Input jumlah lembur
            System.out.print("Masukkan jumlah lembur (jam): ");
            int jamLembur = scanner.nextInt();

            // Perhitungan lembur (contoh: 1 jam lembur = 50000)
            double lembur = 50000 * jamLembur;

            // Kalkulasi gaji total
            double gajiTotal = gajiPokok + bonusGaji - pemotonganGaji - asuransi - pajak + tunjangan + lembur;

            // Tampilkan kuitansi gaji
            tampilkanKuitansi(namaKaryawan, jabatan, gajiTotal, gajiPokok, bonusGaji, pemotonganGaji, asuransi, pajak, tunjangan, lembur, indexKaryawan);
        } else {
            System.out.println("Karyawan tidak ditemukan.");
        }
    }

    // untuk menampilkan kuitansi gaji
    public static void tampilkanKuitansi(String nama, String jabatan, double gajiTotal, double gajiPokok,
            double bonusGaji, double pemotonganGaji, double asuransi, double pajak, double tunjangan, double lembur, int index) {
        System.out.println("\n=== Kuitansi Gaji ===");
        System.out.println("Nama                : " + nama);
        System.out.println("Jabatan             : " + jabatan);
        System.out.println("Gaji Pokok          : " + gajiPokok);
        System.out.println("Bonus Gaji          : " + bonusGaji);
        System.out.println("Pemotongan Gaji     : " + pemotonganGaji);
        System.out.println("Asuransi            : " + asuransi);
        System.out.println("Pajak               : " + pajak);
        System.out.println("Tunjangan           : " + tunjangan);
        System.out.println("Lembur              : " + lembur);
        System.out.println("Gaji Total          : " + gajiTotal);
        System.out.println("Nomor Induk Pegawai : " + dataKaryawan[index][3]);
        System.out.println("Jenis Kepegawaian   : " + dataKaryawan[index][4]);
    }
}
