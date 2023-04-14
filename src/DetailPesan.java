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
