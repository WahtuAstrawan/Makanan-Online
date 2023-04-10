import java.util.Scanner;

public class Admin {
    public static int aksi = 0; // Digunakan untuk melakukan track pada aksi yang dilakukan oleh admin

    public void menuAdmin() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\t Menu Admin");
            System.out.println("1. Lihat Restoran ");
            System.out.println("2. Tambah Restoran");
            System.out.println("3. Hapus Restoran");
            System.out.println("4. Logout ");
            System.out.print("Pilihan anda : ");
            String masukkan = input.nextLine();
            if (masukkan.matches("\\d+")) {
                int pilih = Integer.parseInt(masukkan);
                if (pilih == 1) {

                } else if (pilih == 2) {

                } else if (pilih == 3) {

                } else if (pilih == 4) {
                    Login.login();
                    Login.clearScreen();
                } else {
                    System.out.println("Maaf input Anda salah, Tolong masukkan angka yang tersedia ! ");
                    Login.getChar();
                    Login.clearScreen();
                }
            } else {
                System.out.println("Maaf input Anda salah, Tolong masukkan angka ! ");
                Login.getChar();
                Login.clearScreen();
            }
        }
    }
}
