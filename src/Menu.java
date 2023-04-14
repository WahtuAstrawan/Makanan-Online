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