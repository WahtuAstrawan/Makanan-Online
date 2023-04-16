import java.util.ArrayList;
import java.util.Scanner;

/*
 * Class Admin:
 *      - Class admin ini berfungsi untuk menyediakan menu atau fitur yang tersedia untuk 
 *        user yang bertipe admin. pada class ini ada 1 method yakni method menuAdmin
 *        pada method ini ada menu admin yang terdiri dari fitur lihat, tambah, dan hapus restoran.
 *        method ini memiliki 1 parameter yakni arraylist yang bertipe class Restoran, nantinya
 *        parameter ini akan digunakan untuk fitur fitur yang tersedia pada menu admin ini.
 *        
 *      - Artribut/variabel yang tersedia pada class ini lumayan banyak karena untuk keperluan
 *        pemilihan menu admin oleh user (untuk semua fitur admin pada method menu admin). 
 *        tetapi yang bersifat public hanya 2 yakni id admin dan pw admin, kedua variabel ini
 *        nantinya akan digunakan pada class login untuk menvertifikasi tipe login dari user.
 * 
 *      - Kemudian pada menu admin ini akan terlihat tampilan menu, user akan memilih fitur apa
 *        yang akan digunakan. mulai dari fitur lihat restoran yang berfungsi untuk melihat data
 *        restoran yang tersedia pada program. kemudian fitur tambah restoran yang berfungsi untuk
 *        menambahkan data restoran pada program, data ini akan disimpan pada arraylist daftar restoran
 *        yang nantinya akan digunakan juga pada menu customer. selanjutnya ada fitur hapus restoran
 *        yang berfungsi untuk menghapus data restoran yang ada pada program.
 * 
 *      - Mehtod menu admin memiliki return type integer (1) untuk mengindikasikan bahwa user ingin kembali ke login
 *        yang diatus pada class main
 *     
 */

public class Admin {
        final public static String idAdmin = "admin", pwAdmin = "wahtu123";

        public static int menuAdmin(ArrayList<Restoran> daftarRestoran) {
                Scanner input = new Scanner(System.in);
                while (true) {
                        Fitur.clearScreen();
                        int pilih = Fitur.validasiInteger("\n===================================\n"
                                        + "||       Menu Admin Restoran     ||\n"
                                        + "===================================\n"
                                        + "|| 1. Lihat Restoran             ||\n"
                                        + "|| 2. Tambah Restoran            ||\n"
                                        + "|| 3. Hapus Restoran             ||\n"
                                        + "|| 4. Kembali ke Login           ||\n"
                                        + "===================================\n"
                                        + "  Pilihan anda : ",
                                        "Maaf input anda salah, Pilih menu yang tersedia !",
                                        1,
                                        4);
                        if (pilih == 1) {
                                Fitur.clearScreen();
                                if (daftarRestoran.isEmpty()) {
                                        System.out.println(
                                                        "Belum ada data Restoran !\nMohon ditambahkan terlebih dahulu !\n");
                                        Fitur.getChar("Tekan enter untuk kembali ke menu admin ! ");
                                } else {
                                        System.out.println("\n==============================================\n"
                                                        + "||        Daftar Restoran yang Tersedia      ||\n"
                                                        + "===============================================");
                                        for (int i = 0; i < daftarRestoran.size(); i++) {
                                                Restoran restoran = daftarRestoran.get(i);
                                                System.out.printf(
                                                                "  %d. Nama Restoran   : %s \n     Alamat Restoran : %s \n",
                                                                i + 1,
                                                                restoran.getNama(),
                                                                restoran.getAlamat());
                                        }
                                        int pilihResto = Fitur.validasiInteger(
                                                        "\nPilih Detail Restoran yang akan dilihat !\nPilihan anda : ",
                                                        "Maaf input anda salah, Pilih restoran yang tersedia !", 1,
                                                        daftarRestoran.size());
                                        Restoran restoran = daftarRestoran.get(pilihResto - 1);
                                        Fitur.clearScreen();
                                        System.out.println("===============================================");
                                        System.out.println("||               Detail Restoran             ||");
                                        System.out.println("===============================================");
                                        System.out.printf("Nama Restoran   : %s\n", restoran.getNama());
                                        System.out.printf("Alamat Restoran : %s\n", restoran.getAlamat());
                                        System.out.println("===============================================");
                                        restoran.printMakanan();
                                        restoran.printMinuman();
                                        System.out.println("\n===============================================");
                                        Fitur.getChar("Tekan enter untuk kembali ke menu admin ! ");
                                }
                        } else if (pilih == 2) {
                                while (true) {
                                        Fitur.clearScreen();
                                        int pilihOpsi = Fitur.validasiInteger(
                                                        "\n===============================================\n"
                                                                        + "||            Opsi Tambah Restoran           ||\n"
                                                                        + "===============================================\n"
                                                                        + "|| 1. Tambah Restoran baru                   ||\n"
                                                                        + "|| 2. Tambah Menu di Restoran yang sudah ada ||\n"
                                                                        + "|| 3. Kembali ke Menu admin                  ||\n"
                                                                        + "===============================================\n"
                                                                        + "  Pilihan anda : ",
                                                        "Maaf input anda salah, Pilih opsi yang tersedia !",
                                                        1, 3);
                                        if (pilihOpsi == 1) {
                                                Fitur.clearScreen();
                                                System.out.println(
                                                                "\n================================================\n"
                                                                                + "||           Tambahkan data restoran          ||\n"
                                                                                + "================================================");
                                                System.out.print(" Nama Restoran   : ");
                                                String namaRestoran = input.nextLine();
                                                System.out.print(" Alamat Restoran : ");
                                                String alamatRestoran = input.nextLine();
                                                Restoran restoranBaru = new Restoran(namaRestoran, alamatRestoran);
                                                System.out.println("\n*** Tambahkan menu restoran ***");
                                                int jumlahData = Fitur.validasiInteger(
                                                                "\nBerapa jumlah data makanan dan minuman yang \nakan ditambahkan pada restoran diatas ?\nJawab : ",
                                                                "Input data tidak boleh kurang atau sama dengan nol !",
                                                                1, Integer.MAX_VALUE);
                                                for (int i = 0; i < jumlahData; i++) {
                                                        System.out.print("Masukkan nama makanan : ");
                                                        String makanan = input.nextLine();
                                                        int hargaMakan = Fitur.validasiInteger(
                                                                        "Masukkan harga makanan (Rp): ",
                                                                        "Input harga tidak boleh kurang atau sama dengan nol !",
                                                                        1,
                                                                        Integer.MAX_VALUE);
                                                        Menu menuMakanBaru = new Menu(makanan, hargaMakan);
                                                        restoranBaru.tambahMenuMakanan(menuMakanBaru);
                                                        System.out.print("Masukkan nama minuman : ");
                                                        String minuman = input.nextLine();
                                                        int hargaMinum = Fitur.validasiInteger(
                                                                        "Masukkan harga minuman (Rp): ",
                                                                        "Input harga tidak boleh kurang atau sama dengan nol !",
                                                                        1,
                                                                        Integer.MAX_VALUE);
                                                        Menu menuMinumBaru = new Menu(minuman, hargaMinum);
                                                        restoranBaru.tambahMenuMinuman(menuMinumBaru);
                                                }
                                                daftarRestoran.add(restoranBaru);
                                                Fitur.clearScreen();
                                                System.out.println("*** Data berhasil ditambahkan ! ***\n");
                                                Fitur.getChar("Tekan enter untuk kembali ke menu admin ! ");
                                                break;

                                        } else if (pilihOpsi == 2 && !(daftarRestoran.isEmpty())) {
                                                Fitur.clearScreen();
                                                System.out.println("\n==============================================\n"
                                                                + "||        Daftar Restoran yang Tersedia      ||\n"
                                                                + "===============================================");
                                                for (int i = 0; i < daftarRestoran.size(); i++) {
                                                        Restoran restoran = daftarRestoran.get(i);
                                                        System.out.printf(
                                                                        "    %d. Nama Restoran   : %s \n       Alamat Restoran : %s \n",
                                                                        i + 1,
                                                                        restoran.getNama(),
                                                                        restoran.getAlamat());
                                                }
                                                int pilihResto = Fitur.validasiInteger(
                                                                "\nPilih Restoran yang akan ditambahkan menunya\nPilihan anda : ",
                                                                "Maaf input anda salah, Pilih restoran yang tersedia !",
                                                                1,
                                                                daftarRestoran.size());
                                                Restoran restoran = daftarRestoran.get(pilihResto - 1);
                                                int pilihData = Fitur.validasiInteger(
                                                                "\n===============================================\n"
                                                                                + "||            Opsi Tambah Data Menu          ||\n"
                                                                                + "===============================================\n"
                                                                                + "|| 1. Makanan                                ||\n"
                                                                                + "|| 2. Minuman                                ||\n"
                                                                                + "|| 3. Makanan dan Minuman                    ||\n"
                                                                                + "===============================================\n"
                                                                                + "  Pilihan anda : ",
                                                                "Maaf input anda salah, Pilih opsi yang tersedia !",
                                                                1, 3);
                                                if (pilihData == 1) {
                                                        Fitur.clearScreen();
                                                        int banyak = Fitur.validasiInteger(
                                                                        "Berapa banyak data makanan yang akan ditambahkan ?\nJawab : ",
                                                                        "Input data tidak boleh kurang atau sama dengan nol !",
                                                                        1,
                                                                        Integer.MAX_VALUE);
                                                        for (int i = 0; i < banyak; i++) {
                                                                System.out.print("\n Masukkan nama makanan : ");
                                                                String makanan = input.nextLine();
                                                                int harga = Fitur.validasiInteger(
                                                                                "Masukkan harga makanan (Rp): ",
                                                                                "Input harga tidak boleh kurang atau sama dengan nol !",
                                                                                1,
                                                                                Integer.MAX_VALUE);
                                                                Menu menuBaru = new Menu(makanan, harga);
                                                                restoran.tambahMenuMakanan(menuBaru);
                                                        }
                                                        System.out.println("\n*** Data berhasil ditambahkan ! *** ");
                                                        Fitur.getChar("Tekan enter untuk kembali ke menu admin ! ");
                                                        break;
                                                } else if (pilihData == 2) {
                                                        Fitur.clearScreen();
                                                        int banyak = Fitur.validasiInteger(
                                                                        "Berapa banyak data minuman yang akan ditambahkan ?\nJawab : ",
                                                                        "Input data tidak boleh kurang atau sama dengan nol !",
                                                                        1,
                                                                        Integer.MAX_VALUE);
                                                        for (int i = 0; i < banyak; i++) {
                                                                System.out.print("Masukkan nama minuman : ");
                                                                String minuman = input.nextLine();
                                                                int harga = Fitur.validasiInteger(
                                                                                "Masukkan harga minuman (Rp): ",
                                                                                "Input harga tidak boleh kurang atau sama dengan nol !",
                                                                                1,
                                                                                Integer.MAX_VALUE);
                                                                Menu menuBaru = new Menu(minuman, harga);
                                                                restoran.tambahMenuMinuman(menuBaru);
                                                        }
                                                        System.out.println("\n*** Data berhasil ditambahkan ! *** ");
                                                        Fitur.getChar("Tekan enter untuk kembali ke menu admin ! ");
                                                        break;
                                                } else if (pilihData == 3) {
                                                        Fitur.clearScreen();
                                                        int banyak = Fitur.validasiInteger(
                                                                        "Berapa banyak data makanan dan minuman \nyang akan ditambahkan ?\nJawab : ",
                                                                        "Input data tidak boleh kurang atau sama dengan nol !",
                                                                        1,
                                                                        Integer.MAX_VALUE);
                                                        for (int i = 0; i < banyak; i++) {
                                                                System.out.print("Masukkan nama makanan : ");
                                                                String makanan = input.nextLine();
                                                                int hargaMakan = Fitur.validasiInteger(
                                                                                "Masukkan harga makanan (Rp): ",
                                                                                "Input harga tidak boleh kurang atau sama dengan nol !",
                                                                                1,
                                                                                Integer.MAX_VALUE);
                                                                Menu menuMakanBaru = new Menu(makanan, hargaMakan);
                                                                restoran.tambahMenuMakanan(menuMakanBaru);
                                                                System.out.print("Masukkan nama minuman : ");
                                                                String minuman = input.nextLine();
                                                                int hargaMinum = Fitur.validasiInteger(
                                                                                "Masukkan harga minuman (Rp): ",
                                                                                "Input harga tidak boleh kurang atau sama dengan nol !",
                                                                                1,
                                                                                Integer.MAX_VALUE);
                                                                Menu menuMinumBaru = new Menu(minuman, hargaMinum);
                                                                restoran.tambahMenuMinuman(menuMinumBaru);
                                                        }
                                                        System.out.println("\n*** Data berhasil ditambahkan ! *** ");
                                                        Fitur.getChar("Tekan enter untuk kembali ke menu admin ! ");
                                                        break;
                                                }
                                        } else if (pilihOpsi == 2 && daftarRestoran.isEmpty()) {
                                                System.out.println(
                                                                "\nMaaf belum ada data restoran yang tersimpan\nMohon pilih opsi tambah restoran baru !");
                                                Fitur.getChar(
                                                                "\nTekan enter untuk kembali ke pilihan opsi ! ");
                                        } else if (pilihOpsi == 3) {
                                                break;
                                        }
                                }
                        } else if (pilih == 3) {
                                Fitur.clearScreen();
                                while (true) {
                                        int pilihOpsi = Fitur.validasiInteger(
                                                        "\n===============================================\n"
                                                                        + "||             Opsi Hapus Restoran           ||\n"
                                                                        + "===============================================\n"
                                                                        + "|| 1. Hapus Restoran                         ||\n"
                                                                        + "|| 2. Hapus menu pada restoran yang ada      ||\n"
                                                                        + "|| 3. Kembali ke Menu admin                  ||\n"
                                                                        + "===============================================\n"
                                                                        + "  Pilihan anda : ",
                                                        "Maaf input anda salah, Pilih opsi yang tersedia !", 1, 3);
                                        if (pilihOpsi == 1 && daftarRestoran.isEmpty()) {
                                                System.out.println(
                                                                "Tidak ada data restoran yang tersedia untuk dihapus !\nMohon tambahkan data restoran terlebih dahulu !");
                                                Fitur.getChar("Tekan enter untuk kembali ke menu admin ! ");
                                                break;
                                        } else if (pilihOpsi == 1 && !(daftarRestoran.isEmpty())) {
                                                Fitur.clearScreen();
                                                System.out.println("\n===============================================\n"
                                                                + "||        Daftar Restoran yang Tersedia      ||\n"
                                                                + "===============================================");
                                                for (int i = 0; i < daftarRestoran.size(); i++) {
                                                        Restoran restoran = daftarRestoran.get(i);
                                                        System.out.printf(
                                                                        "  %d. Nama Restoran   : %s \n     Alamat Restoran : %s \n",
                                                                        i + 1,
                                                                        restoran.getNama(),
                                                                        restoran.getAlamat());
                                                }
                                                int pilihResto = Fitur.validasiInteger(
                                                                "\nPilih Restoran yang akan dihapus \nPilihan anda : ",
                                                                "Maaf input anda salah, Pilih restoran yang tersedia !",
                                                                1,
                                                                daftarRestoran.size());
                                                Restoran restoran = daftarRestoran.get(pilihResto - 1);
                                                System.out.printf(
                                                                "\nApakah anda yakin ingin menghapus semua data restoran \nDengan nama : %s dengan alamat : %s ?",
                                                                restoran.getNama(), restoran.getAlamat());
                                                char yakin = Fitur.validasiChar();
                                                if (yakin == 'y') {
                                                        daftarRestoran.remove(pilihResto - 1);
                                                        System.out.println(
                                                                        "*** Data restoran berhasil dihapus ! ***\n");
                                                        Fitur.getChar("Tekan enter untuk kembali ke menu admin !");
                                                        Fitur.clearScreen();
                                                        break;
                                                } else {
                                                        Fitur.getChar("\nTekan enter untuk kembali ke opsi hapus !");
                                                        Fitur.clearScreen();
                                                }
                                        } else if (pilihOpsi == 2 && daftarRestoran.isEmpty()) {
                                                Fitur.clearScreen();
                                                System.out.println(
                                                                "Tidak ada data restoran yang tersedia untuk dihapus !\nMohon tambahkan data restoran terlebih dahulu !");
                                                Fitur.getChar("Tekan enter untuk kembali ke menu admin ! ");
                                                break;
                                        } else if (pilihOpsi == 2 && !(daftarRestoran.isEmpty())) {
                                                Fitur.clearScreen();
                                                System.out.println("\n==============================================\n"
                                                                + "||        Daftar Restoran yang Tersedia      ||\n"
                                                                + "===============================================");
                                                for (int i = 0; i < daftarRestoran.size(); i++) {
                                                        Restoran restoran = daftarRestoran.get(i);
                                                        System.out.printf(
                                                                        "  %d. Nama Restoran   : %s \n     Alamat Restoran : %s \n",
                                                                        i + 1,
                                                                        restoran.getNama(),
                                                                        restoran.getAlamat());
                                                }
                                                int pilihResto = Fitur.validasiInteger(
                                                                "\nPilih data menu Restoran yang akan dihapus \nPilihan anda : ",
                                                                "Maaf input anda salah, Pilih restoran yang tersedia !",
                                                                1,
                                                                daftarRestoran.size());
                                                Restoran restoran = daftarRestoran.get(pilihResto - 1);
                                                int pilihData = Fitur.validasiInteger(
                                                                "===================================\n"
                                                                                + "||      Opsi Hapus data Menu     ||\n"
                                                                                + "===================================\n"
                                                                                + "|| 1. Makanan                    ||\n"
                                                                                + "|| 2. Minuman                    ||\n"
                                                                                + "===================================\n"
                                                                                + "  Pilihan anda : ",
                                                                "Maaf input anda salah, Pilih opsi yang tersedia !", 1,
                                                                2);
                                                if (pilihData == 1 && !(restoran.getMenuMakanan().isEmpty())) {
                                                        Fitur.clearScreen();
                                                        restoran.printMakanan();
                                                        int pilihMakanHapus = Fitur.validasiInteger(
                                                                        "\nPilih nomor makanan yang akan dihapus \nPilihan anda : ",
                                                                        "Maaf input anda salah, Pilih opsi yang tersedia !",
                                                                        1,
                                                                        restoran.getMenuMakanan().size());
                                                        restoran.getMenuMakanan().remove(pilihMakanHapus - 1);
                                                        System.out.println(
                                                                        "\n*** Data menu makanan berhasil dihapus ! ***");
                                                        Fitur.getChar("\nTekan enter untuk kembali ke menu hapus !");
                                                        Fitur.clearScreen();
                                                } else if (pilihData == 2 && !(restoran.getMenuMinuman().isEmpty())) {
                                                        Fitur.clearScreen();
                                                        restoran.printMinuman();
                                                        int pilihMinumHapus = Fitur.validasiInteger(
                                                                        "\nPilih nomor minuman yang akan dihapus \nPilihan anda : ",
                                                                        "Maaf input anda salah, Pilih opsi yang tersedia !",
                                                                        1,
                                                                        restoran.getMenuMinuman().size());
                                                        restoran.getMenuMinuman().remove(pilihMinumHapus - 1);
                                                        System.out.println(
                                                                        "\n*** Data menu minuman berhasil dihapus ! ***");
                                                        Fitur.getChar("\nTekan enter untuk kembali ke menu hapus !");
                                                        Fitur.clearScreen();
                                                } else if (pilihData == 1 && restoran.getMenuMakanan().isEmpty()) {
                                                        Fitur.clearScreen();
                                                        System.out.println(
                                                                        "Data makanan pada restoran yang anda pilih tidak ditemukan, \nMohon isi data makanan terlebih dahulu pada menu tambah restoran ! ");
                                                        Fitur.getChar("\nTekan enter untuk kembali ke menu admin");
                                                        break;
                                                } else if (pilihData == 2 && restoran.getMenuMinuman().isEmpty()) {
                                                        System.out.println(
                                                                        "Data minuman pada restoran yang anda pilih tidak ditemukan, \nMohon isi data minuman terlebih dahulu pada menu tambah restoran ! ");
                                                        Fitur.getChar("\nTekan enter untuk kembali ke menu admin");
                                                        break;
                                                }
                                        } else if (pilihOpsi == 3) {
                                                break;
                                        }
                                }
                        } else if (pilih == 4) {
                                return 1;
                        }
                }
        }
}