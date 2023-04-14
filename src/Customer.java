import java.util.Scanner;
import java.util.ArrayList;

public class Customer {
    final public static String idCostumer = "pelanggan", pwCostumer = "mamat123";
    final public static int biayaOngkirPerKm = 3000;

    public static int menuCustomer(ArrayList<Restoran> daftarRestoran, ArrayList<Pesanan> daftarPesanan) {
        Scanner input = new Scanner(System.in);
        while (true) {
            Fitur.clearScreen();
            int pilih = Fitur.validasiInteger("===================================\n"
                    + "||          Menu Customer        ||\n"
                    + "===================================\n"
                    + "|| 1. Buat Pesanan               ||\n"
                    + "|| 2. Lihat Pesanan              ||\n"
                    + "|| 3. Kembali ke Login           ||\n"
                    + "===================================\n"
                    + "   Pilihan anda : ", "Maaf input anda salah, Pilih menu yang tersedia !", 1, 3);
            if (pilih == 1) {
                Fitur.clearScreen();
                if (daftarRestoran.isEmpty()) {
                    Fitur.clearScreen();
                    System.out.println("Belum ada daftar Restoran yang tersedia !\n");
                    Fitur.getChar("Tekan enter untuk kembali ke menu customer ! ");
                } else {
                    Fitur.clearScreen();
                    System.out.println("\n==============================================\n"
                            + "||        Daftar Restoran yang Tersedia      ||\n"
                            + "===============================================");
                    for (int i = 0; i < daftarRestoran.size(); i++) {
                        Restoran restoran = daftarRestoran.get(i);
                        System.out.printf("  %d. Nama Restoran   : %s \n     Alamat Restoran : %s \n", i + 1,
                                restoran.getNama(), restoran.getAlamat());
                    }
                    int pilihResto = Fitur.validasiInteger(
                            "\nPilih Restoran yang akan dibuat pesanannya ! \nPilihan anda : ",
                            "Maaf input anda salah, Pilih restoran yang tersedia !", 1, daftarRestoran.size());
                    Restoran restoran = daftarRestoran.get(pilihResto - 1);
                    Pesanan pesanan = new Pesanan(restoran.getIdResto(), restoran.getNama(), restoran.getAlamat());
                    while (true) {
                        Fitur.clearScreen();
                        System.out.printf("Nama Restoran : %s \nAlamat Restoran : %s\n\n", restoran.getNama(),
                                restoran.getAlamat());
                        int pilihMenu = Fitur.validasiInteger(
                                "===================================\n"
                                        + "||       Pilih menu tersedia     ||\n"
                                        + "===================================\n"
                                        + "|| 1. Makanan                    ||\n"
                                        + "|| 2. Minuman                    ||\n"
                                        + "===================================\n"
                                        + "  Pilihan anda : ",
                                "Maaf input anda salah, Pilih opsi yang tersedia !", 1,
                                2);
                        if (pilihMenu == 1) {
                            restoran.printMakanan();
                            int pilihMakanPesan = Fitur.validasiInteger("\nPilih makanan yang akan anda pesan : ",
                                    "Maaf input anda salah, Pilih menu makanan yang tersedia !", 1,
                                    restoran.getMenuMakanan().size());
                            int jumlahPesanMakan = Fitur.validasiInteger(
                                    "\nBerapa jumlah makanan yang akan di pesan dari makanan yang dipilih ? : ",
                                    "Jumlah pesan makanan tidak boleh kurang atau sama dengan nol ! ", 1,
                                    Integer.MAX_VALUE);
                            System.out.print("\nApakah anda akan memesan makanan atau minuman yang lain lagi ? ");
                            char ulang = Fitur.validasiChar();
                            Menu menu = restoran.getMenuMakanan().get(pilihMakanPesan - 1);
                            DetailPesan pesan = new DetailPesan(menu.getNama(), menu.getHarga(), menu.getIdMenu(),
                                    jumlahPesanMakan);
                            pesanan.tambahDaftarMenuPerPesanan(pesan);
                            if (ulang == 'y') {
                                continue;
                            } else {
                                System.out.printf(
                                        "Masukkan jarak antara lokasi anda dengan alamat dari restoran %s yakni dari : %s\n",
                                        restoran.getNama(), restoran.getAlamat());
                                double jarakAntar = Fitur.validasiDouble();
                                pesanan.setJarakAntar(jarakAntar);
                                System.out.print("Masukkan nama anda : ");
                                String namaCustomer = input.nextLine();
                                pesanan.setNamaCustomer(namaCustomer);
                                daftarPesanan.add(pesanan);
                                System.out.println("\n*** Pesanan berhasil dibuat ! ***");
                                Fitur.getChar("Tekan enter untuk kembali ke menu customer ! ");
                                break;
                            }
                        } else if (pilihMenu == 2) {
                            restoran.printMinuman();
                            int pilihMinumPesan = Fitur.validasiInteger("\nPilih minuman yang akan anda pesan : ",
                                    "Maaf input anda salah, Pilih menu makanan yang tersedia !", 1,
                                    restoran.getMenuMinuman().size());
                            int jumlahPesanMinum = Fitur.validasiInteger(
                                    "\nBerapa jumlah minuman yang akan di pesan dari minuman yang dipilih ? : ",
                                    "Jumlah pesan minuman tidak boleh kurang atau sama dengan nol ! ", 1,
                                    Integer.MAX_VALUE);
                            System.out.print("\nApakah anda akan memesan makanan atau minuman yang lain lagi ? ");
                            char ulang = Fitur.validasiChar();
                            Menu menu = restoran.getMenuMinuman().get(pilihMinumPesan - 1);
                            DetailPesan pesan = new DetailPesan(menu.getNama(), menu.getHarga(), menu.getIdMenu(),
                                    jumlahPesanMinum);
                            pesanan.tambahDaftarMenuPerPesanan(pesan);
                            if (ulang == 'y') {
                                continue;
                            } else {
                                System.out.printf(
                                        "Masukkan jarak antara lokasi anda dengan alamat dari restoran %s yakni dari : %s\n",
                                        restoran.getNama(), restoran.getAlamat());
                                double jarakAntar = Fitur.validasiDouble();
                                pesanan.setJarakAntar(jarakAntar);
                                System.out.print("Masukkan nama anda : ");
                                String namaCustomer = input.nextLine();
                                pesanan.setNamaCustomer(namaCustomer);
                                daftarPesanan.add(pesanan);
                                System.out.println("\n*** Pesanan berhasil dibuat ! ***");
                                Fitur.getChar("Tekan enter untuk kembali ke menu customer ! ");
                                break;
                            }
                        }
                    }
                }

            } else if (pilih == 2) {
                Fitur.clearScreen();
                if (daftarPesanan.isEmpty()) {
                    Fitur.clearScreen();
                    System.out.println("Belum ada data pesanan customer, Mohon dibuat terlebih dahulu !\n");
                    Fitur.getChar("Tekan enter untuk kembali ke menu customer ! ");
                } else {
                    Fitur.clearScreen();
                    System.out.println("\n===============================================\n"
                            + "||           Daftar Pesanan Customer         ||\n"
                            + "===============================================");
                    for (int i = 0; i < daftarPesanan.size(); i++) {
                        Pesanan pesanan = daftarPesanan.get(i);
                        System.out.printf("   %d. Pesanan dengan nama customer : %s\n", i + 1,
                                pesanan.getNamaCustomer());
                    }
                    int pilihPesanan = Fitur.validasiInteger(
                            "\nPilih pesanan yang akan dilihat detailnya ! \nPilihan anda : ",
                            "Maaf input anda salah, Pilih pesanan yang tersedia !", 1, daftarPesanan.size());
                    Pesanan pesanan = daftarPesanan.get(pilihPesanan - 1);
                    Fitur.clearScreen();
                    System.out.printf("===============================================\n");
                    System.out.printf("||           Detail Pesanan Customer         ||\n");
                    System.out.printf("===============================================\n");
                    System.out.printf("   Nama Customer   : %s \n", pesanan.getNamaCustomer());
                    System.out.printf("===============================================\n");
                    System.out.printf("  Nama Restoran   : %s \n", pesanan.getNamaResto());
                    System.out.printf("  Alamat Restoran : %s \n", pesanan.getAlamatResto());
                    System.out.printf("  ID Restoran     : %s \n", pesanan.getIdResto());
                    System.out.printf("===============================================\n");
                    System.out.printf("  Menu Pesanan : \n");
                    for (int i = 0; i < pesanan.getDaftarMenuPerPesanan().size(); i++) {
                        DetailPesan detailPesan = pesanan.getDaftarMenuPerPesanan().get(i);
                        System.out.printf("   %d. ID Menu   : %s \n", i + 1, detailPesan.getIdMenu());
                        System.out.printf("      Nama Menu : %s \n", detailPesan.getNama());
                        System.out.printf("      Harga     : Rp.%d \n", detailPesan.getHarga());
                        System.out.printf("      Qty       : %d \n\n", detailPesan.getQtyMenu());
                    }
                    System.out.printf("===============================================\n");
                    System.out.printf("  Jarak ke lokasi antar : %,.2f km\n", pesanan.getJarakAntar());
                    System.out.printf("  Biaya ongkir/km       : Rp.%d\n", Customer.biayaOngkirPerKm);
                    System.out.printf("===============================================\n");
                    System.out.printf("  Total Harga Pesanan   : Rp.%d\n", pesanan.getTotalHarga());
                    Fitur.getChar("\n\nTekan enter untuk kembali ke menu customer !");
                }
            } else if (pilih == 3) {
                return 1;
            }
        }
    }
}
