import java.util.Scanner;

public class Selection2Student {
    public static void main(String[] args) {
        Scanner input01 = new Scanner(System.in);

        System.out.print("Nilai Uas        :");
        float finalExam = input01.nextFloat();
        System.out.print("Nilai Uts        :");
        float midExam = input01.nextFloat();
        System.out.print("Nilai kuis       :");
        float quiz = input01.nextFloat();
        System.out.print("Nilai tugas      :");
        float assigment = input01.nextFloat();

        float total = (finalExam * 0.4F) + (midExam * 0.3F) + (quiz * 0.1F) + (assigment * 0.2F);
        String message = total < 65 ? "Retake" : "Pass";

        if (total > 100) {
            message = "Invalid";
        } else if (total > 79) {
            message = "A (4.0) - Kualifikasi: Sangat Baik";
        } else if (total > 73) {
            message = "B+ (3.5) - Kualifikasi: Lebih dari Baik";
        } else if (total > 65) {
            message = "B (3.0) - Kualifikasi: Baik";
        } else if (total > 60) {
            message = "C+ (2.5) - Kualifikasi: Lebih dari Cukup";
        } else if (total > 50) {
            message = "C (2.0) - Kualifikasi: Cukup";
        } else if (total > 39) {
            message = "D (1.0) - Kualifikasi: Kurang";
        } else {
            message = "E (0.0) - Kualifikasi: Gagal";
        }

        System.out.println("Final grade = " + total + " and the decission is " + message);
    }
}