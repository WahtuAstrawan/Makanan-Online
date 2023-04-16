
/*
 * Class Menu:
 *      - Class ini merupakan tempat untuk menyimpan data menu. class ini bertujuan untuk menyimpan data-data
 *        dari sebuah menu, mulai dari nama, harga, dan id menu. nantinya class menu ini akan digunakan sebagai arraylist
 *        di class restoran dengan nama menuMakanan dan menuMinuman.
 * 
 *      - Kemudian pada class ini memiliki konstuktor nama dan harga pada saat menginisialisasikannya. 
 *        untuk mendapatkan id menu pada konstuktor, class ini memanggil method id generator dari class fitur dengan panjang
 *        6 karakter (pada parameter saat memanggil) sebagai id menu dari data makanan/minuman yang nantinya tersimpan.
 *        
 */

public class Menu {
    private String nama;
    private int harga;
    private String idMenu;

    public Menu(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
        this.idMenu = Fitur.idGenerator(6);
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public String getIdMenu() {
        return idMenu;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}