import java.util.ArrayList;

/*
 * Class Main:
 *      - Mehtod main adalah untuk menjalankan program. dimulai dengan membuat arraylist dari class
 *        Restoran dan class Pesanan untuk keperluan data pada program.
 * 
 *      - Kemudian variabel/atribut int ulang untuk mengulang program ke login jika
 *        user memilih untuk kembali ke login (logout).
 * 
 *      - Dilanjutkan dengan pemanggilan login dalam do while untuk keperluan mengulang
 *        ke login. hasil return dari login akan disimpan pada variabel jenisUser untuk
 *        menentukan user tersebut termasuk admin atau customer. setelah itu akan diarahkan
 *        ke menu yang sesuai.
 */

public class Main {
    public static void main(String[] args) {
        ArrayList<Restoran> daftarRestoran = new ArrayList<Restoran>();
        ArrayList<Pesanan> daftarPesanan = new ArrayList<Pesanan>();
        int ulang = 0;
        do {
            int jenisUser = Login.login();
            if (jenisUser == 1) {
                ulang = Admin.menuAdmin(daftarRestoran);
            } else if (jenisUser == 2) {
                ulang = Customer.menuCustomer(daftarRestoran, daftarPesanan);
            }
        } while (ulang == 1);
    }
}