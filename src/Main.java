import java.util.ArrayList;

public class Main {
    // ======================================
    public static void main(String[] args) {
        ArrayList<Restoran> daftarRestoran = new ArrayList<Restoran>();
        int ulang = 0;
        do {
            int jenisUser = Login.login();
            if (jenisUser == 1) {
                ulang = Admin.menuAdmin(daftarRestoran);
            } else if (jenisUser == 2) {
                ulang = Customer.menuCustomer(daftarRestoran);
            }
        } while (ulang == 1);
    }
}