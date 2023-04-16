
/*
 * Class Detail Pesan:
 *      - Class ini merupakan tempat untuk menyimpan data detail pesanan, yang nantinya akan dipakai sebagai arraylist
 *        bertipe class ini di class Pesanan. class ini merupakan turunan dari class menu dengan data nama dan harga yang
 *        diturunkan dari class menu. selain itu class ini juga memiliki id menu, dan kuantitas menu yang nantinya akan
 *        digunakan untuk data pada pesanan, dan mendapatkan total harga dari menu
 * 
 *      - Kemudian pada class ini juga ada konstruktor yang berguna pada saat menginisialisasi class ini
 *        diikuti dengan getter dan setter yang berguna untuk mendapatkan dan mengeset data yang ada.   
 *        
 */

public class DetailPesan extends Menu {
    private int qtyMenu;
    private String idMenu;

    public DetailPesan(String nama, int harga, String idMenu, int qtyMenu) {
        super(nama, harga);
        this.idMenu = idMenu;
        this.qtyMenu = qtyMenu;
    }

    public int getQtyMenu() {
        return qtyMenu;
    }

    public String getIdMenu() {
        return idMenu;
    }

    public void setQtyMenu(int qtyMenu) {
        this.qtyMenu = qtyMenu;
    }

    public int getTotalHarga() {
        return getHarga() * qtyMenu;
    }
}
