import java.util.ArrayList;

/*
 * Class Restoran:
 *      - Class ini merupakan tempat untuk menyimpan data dari restoran. pada class ini terdapat beberapa atribut
 *        yakni nama, alamat, dan id resto. kemudian terdapat juga 2 arraylist bertipe class menu yang bernama menuMakanan
 *        dan menuMinuman untuk menyimpan data dari menu makanan dan minuman.
 * 
 *      - Kemudian pada class ini juga ada konstruktor yang berguna pada saat menginisialisasi class ini
 *        pada konstuktor ada nama, alamat, id resto yang didapat dari class fitur method id generator dengan
 *        panjang id sebanyak 4 karakter, arraylist menu makanan dan minuman.
 * 
 *      - Pada class ini juga terdapat 2 method yakni print makanan dan minuman. method print makanan berfungsi
 *        untuk menampilkan semua data yang ada di arraylist menuMakanan. begitu juga dengan method print minuman
 *        yang berfungsi untuk menampilkan semua data yang ada di array list menuMiunuman. kedua method ini akan
 *        dipanggil pada class admin dan customer untuk memperlihatkan user data makanan dan minuman yang tersedia.
 *        
 */

public class Restoran {
    private String nama;
    private String alamat;
    private String idResto;
    private ArrayList<Menu> menuMakanan;
    private ArrayList<Menu> menuMinuman;

    public Restoran(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
        this.idResto = Fitur.idGenerator(4);
        menuMakanan = new ArrayList<>();
        menuMinuman = new ArrayList<>();
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getIdResto() {
        return idResto;
    }

    public ArrayList<Menu> getMenuMakanan() {
        return menuMakanan;
    }

    public ArrayList<Menu> getMenuMinuman() {
        return menuMinuman;
    }

    public void tambahMenuMakanan(Menu menu) {
        menuMakanan.add(menu);
    }

    public void tambahMenuMinuman(Menu menu) {
        menuMinuman.add(menu);
    }

    public void printMakanan() {
        System.out.println("\nMenu Makanan : ");
        for (int i = 0; i < menuMakanan.size(); i++) {
            System.out.printf("%d. Nama  : %s \n   Harga : Rp.%d\n", i + 1, menuMakanan.get(i).getNama(),
                    menuMakanan.get(i).getHarga());
        }
    }

    public void printMinuman() {
        System.out.println("\nMenu Minuman : ");
        for (int i = 0; i < menuMinuman.size(); i++) {
            System.out.printf("%d. Nama  : %s \n   Harga : Rp.%d\n", i + 1, menuMinuman.get(i).getNama(),
                    menuMinuman.get(i).getHarga());
        }
    }
}
