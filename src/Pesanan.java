import java.util.ArrayList;

/*
 * Class Pesanan:
 *      - Class ini merupakan tempat untuk menyimpan data pesanan customer. yang berisi nama customer,
 *        id restoran, nama restoran, alamat restoran, jarak antar, dan arraylist dari class DetailPesan yang bernama
 *        daftar menu per pesanan. Semua data ini berguna untuk user bertipe customer pada saat akan membuat 
 *        dan melihat pesanan.
 * 
 *      - Kemudian pada class ini juga ada konstruktor yang berguna pada saat menginisialisasi class ini
 *        (id resto yang didapat nanti di class restoran yang dipilih, nama, dan alamat restoran)
 *        diikuti dengan getter dan setter yang berguna untuk mendapatkan dan mengeset data yang ada.
 * 
 *      - Disini juga ada method getTotalHarga yang berfungsi untuk mendapatkan harga total dari sebuah pesanan
 *        pada method tersebut diperlukan variabel biayaOngkirPerKm dari class customer, jarak antar customer dan 
 *        total harga dari masing-masing class Detail Pesan yang tersimpan pada array list daftar menu per pesanan
 *        setelah itu method ini akan menreturn total harga dari sebuah pesanan.
 *        
 */

public class Pesanan {
    private String namaCustomer;
    private String idResto;
    private String namaResto;
    private String alamatResto;
    private double jarakAntar;
    private ArrayList<DetailPesan> daftarMenuPerPesanan;

    public Pesanan(String idResto, String namaResto, String alamatResto) {
        this.idResto = idResto;
        this.namaResto = namaResto;
        this.alamatResto = alamatResto;
        daftarMenuPerPesanan = new ArrayList<>();
    }

    public String getNamaCustomer() {
        return namaCustomer;
    }

    public String getIdResto() {
        return idResto;
    }

    public String getNamaResto() {
        return namaResto;
    }

    public String getAlamatResto() {
        return alamatResto;
    }

    public double getJarakAntar() {
        return jarakAntar;
    }

    public ArrayList<DetailPesan> getDaftarMenuPerPesanan() {
        return daftarMenuPerPesanan;
    }

    public void tambahDaftarMenuPerPesanan(DetailPesan pesan) {
        daftarMenuPerPesanan.add(pesan);
    }

    public void setJarakAntar(double jarakAntar) {
        this.jarakAntar = jarakAntar;
    }

    public void setNamaCustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    public int getTotalHarga() {
        int hargaTotalMenu = (int) (jarakAntar * Customer.biayaOngkirPerKm);
        for (int i = 0; i < daftarMenuPerPesanan.size(); i++) {
            DetailPesan menuPesanan = daftarMenuPerPesanan.get(i);
            hargaTotalMenu += menuPesanan.getTotalHarga();
        }
        return hargaTotalMenu;
    }
}
