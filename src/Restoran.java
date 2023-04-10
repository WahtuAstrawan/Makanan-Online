import java.util.ArrayList;
import java.util.HashMap;

public class Restoran {
    private String nama = "-";
    private String alamat = "-";

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama(){
        return nama;
    }
    public String getAlamat(){
        return alamat;
    }
    HashMap<String, ArrayList<String>> Makanan = new HashMap<>();
    HashMap<String, ArrayList<String>> Minuman = new HashMap<>();

    public static void lihatRestoran(Restoran lihat){
        System.out.printf("Nama Restoran   : %s\n", lihat.getNama());
        System.out.printf("Alamat Restoran : %s", lihat.getAlamat());
    }
}
