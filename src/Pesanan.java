import java.util.ArrayList;

public class Pesanan {
    private String namaCustomer;
    private String idResto;
    private String namaResto;
    private String alamatResto;
    private double jarakAntar;
    private ArrayList<DetailPesan> daftarMenuPerPesanan;
    private int totalHarga;

    public Pesanan(String idResto, String namaResto, String alamatResto) {
        this.idResto = idResto;
        this.namaResto = namaResto;
        this.alamatResto = alamatResto;
        daftarMenuPerPesanan = new ArrayList<>();
        totalHarga = ((int) (jarakAntar * Customer.biayaOngkirPerKm));
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
        int hargaTotalMenu = 0;
        for (int i = 0; i < daftarMenuPerPesanan.size(); i++) {
            DetailPesan menuPesanan = daftarMenuPerPesanan.get(i);
            hargaTotalMenu += menuPesanan.getTotalHarga();
        }
        return totalHarga + hargaTotalMenu;
    }
}
