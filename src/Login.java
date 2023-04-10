import java.util.ArrayList;
import java.util.Scanner;
import java.io.Console;

public class Login {
    public static void login() {
        Scanner input = new Scanner(System.in);
        String idCostumer = "pelanggan", pwCostumer = "mamat123", idAdmin = "admin", pwAdmin = "wahtuGanteng";
        while (true) {
            System.out.println("Selamat Datang di Program Restoran ! ");
            System.out.println("1. Login ");
            System.out.println("2. Keluar ");
            System.out.print("Pilihan anda : ");
            String masukkan = input.nextLine();
            if (masukkan.matches("\\d+")) {
                int pilih = Integer.parseInt(masukkan);
                if (pilih == 1) {
                    while (true) {
                        clearScreen();
                        System.out.println("\t Login Page");
                        System.out.print("Username : ");
                        String username = input.nextLine();
                        // Console console = System.console();
                        // char[] pass = console.readPassword("Password : ");
                        // String password = new String(pass); "Hanya bisa pada terminal (membuat input password tidak terlihat)"
                        System.out.print("Password : ");
                        String password = input.nextLine();
                        if (username.equals(idAdmin) && password.equals(pwAdmin)) {
                            clearScreen();
                            Admin adm = new Admin();
                            adm.menuAdmin();
                            break;
                        } else if (username.equals(idCostumer) && password.equals(pwCostumer)) {
                            clearScreen();
                            Customer cstm = new Customer();
                            cstm.menuCustomer();
                            break;
                        } else {
                            System.out.println("Username atau Password yang Anda masukkan salah ! ");
                            getChar();
                        }
                    }
                    break;
                } else if (pilih == 2) {
                    System.exit(0);
                    break;
                } else {
                    System.out.println("Maaf input Anda salah, Tolong masukkan angka yang tersedia ! ");
                    getChar();
                }
            } else {
                System.out.println("Maaf input Anda salah, Tolong masukkan angka ! ");
                getChar();
                clearScreen();
            }
        }
    }

    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }

    public static void getChar() {
        Scanner input = new Scanner(System.in);
        System.out.print("   Tekan enter untuk mengulang ! ");
        String enter = input.nextLine();
    }
}
