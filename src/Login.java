import java.util.Scanner;
import java.io.Console;

/*
 * Class Login:
 *      - Class ini merupakan tempat untuk user melakukan login. dalam class ini terdapat 1 method yakni bernama login
 *        dalam method login terdapat opsi untuk login dan keluar (exit program). method ini merupakan method pertama yang
 *        dipanggil dalam program restoran ini. 
 * 
 *      - Kemudian pada class ini terdapat banyak variabel-variabel yang digunakan untuk melakukan proses login.
 *        pada method login ini, user akan dimintai input username dan password. yang nantinya akan digunakan untuk 
 *        menentukan user itu termasuk ke tipe apa (admin/customer).
 * 
 *      - Method login ini memiliki tipe return integer yakni (1/2) untuk mengindikasikan tipe
 *        user yang masuk itu apa (admin/customer). ini diatur pada class main.
 *        
 *        
 */

public class Login {
    public static int login() {
        Fitur.clearScreen();
        Console console = System.console();
        Scanner input = new Scanner(System.in);
        int pilih = Fitur.validasiInteger(
                "\n======================================================\n"
                        + "||     Selamat Datang di Program Restoran Online !  ||\n"
                        + "======================================================\n"
                        + "|| 1. Login                                         ||\n"
                        + "|| 2. Keluar                                        ||\n"
                        + "======================================================\n"
                        + "  Pilihan anda : ",
                "Maaf input anda salah, Pilih opsi yang tersedia !", 1, 2);
        if (pilih == 1) {
            while (true) {
                Fitur.clearScreen();
                System.out.print("====================================\n");
                System.out.print("||          Login Page            ||\n");
                System.out.print("====================================\n");
                System.out.print("  Username : ");
                String username = input.nextLine();
                char[] pass = console.readPassword("  Password : ");
                String password = new String(pass);
                if (username.equals(Admin.idAdmin) && password.equals(Admin.pwAdmin)) {
                    Fitur.clearScreen();
                    return 1;
                } else if (username.equals(Customer.idCostumer) && password.equals(Customer.pwCostumer)) {
                    Fitur.clearScreen();
                    return 2;
                } else {
                    int ulang = Fitur.validasiInteger(
                            "\nUsername atau Password yang Anda masukkan salah ! \nMasukkan 1 untuk ulang input, atau 2 untuk kembali ke menu awal \nPilihan anda : ",
                            "Maaf input anda salah, Pilih opsi yang tersedia !",
                            1, 2);
                    if (ulang == 1) {
                        continue;
                    } else if (ulang == 2) {
                        login();
                    }
                }
            }
        } else if (pilih == 2) {
            System.exit(0);
        }
        return 0;
    }
}
