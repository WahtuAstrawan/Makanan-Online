import java.util.ArrayList;

public class Restoran {
    private String nama;
    private String alamat;
    private ArrayList<Menu> menuMakanan;
    private ArrayList<Menu> menuMinuman;

    public Restoran(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
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
