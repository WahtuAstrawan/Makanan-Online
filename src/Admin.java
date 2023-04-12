import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    final public static String idAdmin = "admin", pwAdmin = "wahtuGanteng";

    public static int menuAdmin(ArrayList<Restoran> daftarRestoran) {
        Scanner input = new Scanner(System.in);
        while (true) {
            Fitur.clearScreen();
            int pilih = Fitur.validasiInteger(
                    "\t Menu Admin\n1. Lihat Restoran\n2. Tambah Restoran\n3. Hapus Restoran\n4. Kembali ke Login\nPilihan anda : ",
                    "Maaf input anda salah, Pilih menu yang tersedia !",
                    1,
                    4);
            if (pilih == 1) {
                Fitur.clearScreen();
                if (daftarRestoran.isEmpty()) {
                    System.out.println("Belum ada data Restoran !\nMohon ditambahkan terlebih dahulu !");
                    Fitur.getChar("Tekan enter untuk kembali ke menu admin ! ");
                } else {
                    System.out.println("Daftar Restoran yang Tersedia : ");
                    for (int i = 0; i < daftarRestoran.size(); i++) {
                        Restoran restoran = daftarRestoran.get(i);
                        System.out.printf("%d. Nama Restoran : %s \n   Alamat Restoran : %s \n", i + 1,
                                restoran.getNama(),
                                restoran.getAlamat());
                    }
                    int pilihResto = Fitur.validasiInteger(
                            "\nPilih Detail Restoran yang akan dilihat !\nPilihan anda : ",
                            "Maaf input anda salah, Pilih restoran yang tersedia !", 1,
                            daftarRestoran.size());
                    Restoran restoran = daftarRestoran.get(pilihResto - 1);
                    Fitur.clearScreen();
                    System.out.printf("Nama Restoran   : %s\n", restoran.getNama());
                    System.out.printf("Alamat Restoran : %s\n", restoran.getAlamat());
                    restoran.printMakanan();
                    restoran.printMinuman();
                    Fitur.getChar("Tekan enter untuk kembali ke menu admin ! ");
                }
            } else if (pilih == 2) {
                while (true) {
                    Fitur.clearScreen();
                    int pilihOpsi = Fitur.validasiInteger(
                            "Opsi tambah restoran : \n1. Tambah Restoran Baru\n2. Tambah Menu di Restoran yang sudah ada \n3. Kembali ke Menu admin\nPilihan anda : ",
                            "Maaf input anda salah, Pilih opsi yang tersedia !",
                            1, 3);
                    if (pilihOpsi == 1) {
                        Fitur.clearScreen();
                        System.out.println("* Tambahkan data restoran *");
                        System.out.print("Nama Restoran   : ");
                        String namaRestoran = input.nextLine();
                        System.out.print("Alamat Restoran : ");
                        String alamatRestoran = input.nextLine();
                        Restoran restoranBaru = new Restoran(namaRestoran, alamatRestoran);
                        System.out.println("\n* Tambahkan menu restoran *");
                        int jumlahData = Fitur.validasiInteger(
                                "Berapa jumlah data makanan dan minuman yang akan ditambahkan pada restoran diatas ?\nJawab : ",
                                "Input data tidak boleh kurang atau sama dengan nol !",
                                1, Integer.MAX_VALUE);
                        for (int i = 0; i < jumlahData; i++) {
                            System.out.print("Masukkan nama makanan : ");
                            String makanan = input.nextLine();
                            int hargaMakan = Fitur.validasiInteger("Masukkan harga makanan (Rp): ",
                                    "Input harga tidak boleh kurang atau sama dengan nol !", 1,
                                    Integer.MAX_VALUE);
                            Menu menuMakanBaru = new Menu(makanan, hargaMakan);
                            restoranBaru.tambahMenuMakanan(menuMakanBaru);
                            System.out.print("Masukkan nama minuman : ");
                            String minuman = input.nextLine();
                            int hargaMinum = Fitur.validasiInteger("Masukkan harga minuman (Rp): ",
                                    "Input harga tidak boleh kurang atau sama dengan nol !", 1,
                                    Integer.MAX_VALUE);
                            Menu menuMinumBaru = new Menu(minuman, hargaMinum);
                            restoranBaru.tambahMenuMinuman(menuMinumBaru);
                        }
                        daftarRestoran.add(restoranBaru);
                        Fitur.clearScreen();
                        System.out.println("Data berhasil ditambahkan ! ");
                        Fitur.getChar("Tekan enter untuk kembali ke menu admin ! ");
                        break;

                    } else if (pilihOpsi == 2 && !(daftarRestoran.isEmpty())) {
                        Fitur.clearScreen();
                        System.out.println("Daftar Restoran yang Tersedia : ");
                        for (int i = 0; i < daftarRestoran.size(); i++) {
                            Restoran restoran = daftarRestoran.get(i);
                            System.out.printf("%d. Nama Restoran : %s \n   Alamat Restoran : %s \n", i + 1,
                                    restoran.getNama(),
                                    restoran.getAlamat());
                        }
                        int pilihResto = Fitur.validasiInteger(
                                "Pilih Restoran yang akan ditambahkan menunya\nPilihan anda : ",
                                "Maaf input anda salah, Pilih restoran yang tersedia !", 1,
                                daftarRestoran.size());
                        Fitur.clearScreen();
                        Restoran restoran = daftarRestoran.get(pilihResto - 1);
                        int pilihData = Fitur.validasiInteger(
                                "Opsi tambah data menu : \n1. Makanan \n2. Minuman\n3. Makanan dan Minuman\nPilihan anda : ",
                                "Maaf input anda salah, Pilih opsi yang tersedia !",
                                1, 3);
                        if (pilihData == 1) {
                            Fitur.clearScreen();
                            int banyak = Fitur.validasiInteger(
                                    "Berapa banyak data makanan yang akan ditambahkan ?\nJawab : ",
                                    "Input data tidak boleh kurang atau sama dengan nol !", 1,
                                    Integer.MAX_VALUE);
                            for (int i = 0; i < banyak; i++) {
                                System.out.print("\n Masukkan nama makanan : ");
                                String makanan = input.nextLine();
                                int harga = Fitur.validasiInteger("Masukkan harga makanan (Rp): ",
                                        "Input harga tidak boleh kurang atau sama dengan nol !", 1,
                                        Integer.MAX_VALUE);
                                Menu menuBaru = new Menu(makanan, harga);
                                restoran.tambahMenuMakanan(menuBaru);
                            }
                            System.out.println("\nData berhasil ditambahkan ! ");
                            Fitur.getChar("Tekan enter untuk kembali ke menu admin ! ");
                            break;
                        } else if (pilihData == 2) {
                            Fitur.clearScreen();
                            int banyak = Fitur.validasiInteger(
                                    "Berapa banyak data minuman yang akan ditambahkan ?\nJawab : ",
                                    "Input data tidak boleh kurang atau sama dengan nol !", 1,
                                    Integer.MAX_VALUE);
                            for (int i = 0; i < banyak; i++) {
                                System.out.print("Masukkan nama minuman : ");
                                String minuman = input.nextLine();
                                int harga = Fitur.validasiInteger("Masukkan harga minuman (Rp): ",
                                        "Input harga tidak boleh kurang atau sama dengan nol !", 1,
                                        Integer.MAX_VALUE);
                                Menu menuBaru = new Menu(minuman, harga);
                                restoran.tambahMenuMinuman(menuBaru);
                            }
                            System.out.println("Data berhasil ditambahkan ! ");
                            Fitur.getChar("Tekan enter untuk kembali ke menu admin ! ");
                            break;
                        } else if (pilihData == 3) {
                            Fitur.clearScreen();
                            int banyak = Fitur.validasiInteger(
                                    "Berapa banyak data makanan dan minuman yang akan ditambahkan ?\nJawab : ",
                                    "Input data tidak boleh kurang atau sama dengan nol !", 1,
                                    Integer.MAX_VALUE);
                            for (int i = 0; i < banyak; i++) {
                                System.out.print("Masukkan nama makanan : ");
                                String makanan = input.nextLine();
                                int hargaMakan = Fitur.validasiInteger("Masukkan harga makanan (Rp): ",
                                        "Input harga tidak boleh kurang atau sama dengan nol !", 1,
                                        Integer.MAX_VALUE);
                                Menu menuMakanBaru = new Menu(makanan, hargaMakan);
                                restoran.tambahMenuMakanan(menuMakanBaru);
                                System.out.print("Masukkan nama minuman : ");
                                String minuman = input.nextLine();
                                int hargaMinum = Fitur.validasiInteger("Masukkan harga minuman (Rp): ",
                                        "Input harga tidak boleh kurang atau sama dengan nol !", 1,
                                        Integer.MAX_VALUE);
                                Menu menuMinumBaru = new Menu(minuman, hargaMinum);
                                restoran.tambahMenuMinuman(menuMinumBaru);
                            }
                            System.out.println("Data berhasil ditambahkan ! ");
                            Fitur.getChar("Tekan enter untuk kembali ke menu admin ! ");
                            break;
                        }
                    } else if (pilihOpsi == 2 && daftarRestoran.isEmpty()) {
                        System.out.println(
                                "Maaf belum ada data restoran yang tersimpan\nMohon pilih opsi tambah restoran baru !");
                        Fitur.getChar(
                                "Maaf belum ada data restoran yang tersimpan\nMohon pilih opsi tambah restoran baru ! \nTekan enter untuk kembali ke pilihan opsi ! ");
                    } else if (pilihOpsi == 3) {
                        break;
                    }
                }
            } else if (pilih == 3) {
                Fitur.clearScreen();
                while (true) {
                    int pilihOpsi = Fitur.validasiInteger(
                            "========================\n Opsi hapus restoran : \n========================\n1. Hapus Restoran\n2. Hapus menu pada restoran yang ada\n3. Kembali ke Menu admin\n========================\nPilihan anda : ",
                            "Maaf input anda salah, Pilih opsi yang tersedia !", 1, 3);
                    if (pilihOpsi == 1 && daftarRestoran.isEmpty()) {
                        System.out.println(
                                "Tidak ada data restoran yang tersedia untuk dihapus !\nMohon tambahkan data restoran terlebih dahulu !");
                        Fitur.getChar("Tekan enter untuk kembali ke menu admin ! ");
                        break;
                    } else if (pilihOpsi == 1 && !(daftarRestoran.isEmpty())) {
                        Fitur.clearScreen();
                        System.out.println("Daftar Restoran yang Tersedia : ");
                        for (int i = 0; i < daftarRestoran.size(); i++) {
                            Restoran restoran = daftarRestoran.get(i);
                            System.out.printf("%d. Nama Restoran   : %s \n   Alamat Restoran : %s \n", i + 1,
                                    restoran.getNama(),
                                    restoran.getAlamat());
                        }
                        int pilihResto = Fitur.validasiInteger(
                                "Pilih Restoran yang akan dihapus \nPilihan anda : ",
                                "Maaf input anda salah, Pilih restoran yang tersedia !", 1,
                                daftarRestoran.size());
                        Restoran restoran = daftarRestoran.get(pilihResto - 1);
                        System.out.printf(
                                "Apakah anda yakin ingin menghapus semua data restoran dengan nama : %s yang beralamat di %s ?",
                                restoran.getNama(), restoran.getAlamat());
                        char yakin = Fitur.validasiChar();
                        if (yakin == 'y') {
                            daftarRestoran.remove(pilihResto - 1);
                            System.out.println("Data restoran berhasil dihapus !");
                            Fitur.getChar("Tekan enter untuk kembali ke menu admin !");
                            Fitur.clearScreen();
                            break;
                        } else {
                            Fitur.getChar("Tekan enter untuk kembali ke opsi hapus !");
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
                        System.out.println("Daftar Restoran yang Tersedia : ");
                        for (int i = 0; i < daftarRestoran.size(); i++) {
                            Restoran restoran = daftarRestoran.get(i);
                            System.out.printf("%d. Nama Restoran   : %s \n   Alamat Restoran : %s \n", i + 1,
                                    restoran.getNama(),
                                    restoran.getAlamat());
                        }
                        int pilihResto = Fitur.validasiInteger(
                                "Pilih data menu Restoran yang akan dihapus \nPilihan anda : ",
                                "Maaf input anda salah, Pilih restoran yang tersedia !", 1,
                                daftarRestoran.size());
                        Restoran restoran = daftarRestoran.get(pilihResto - 1);
                        int pilihData = Fitur.validasiInteger(
                                "Opsi hapus data menu :\n1. Makanan \n2. Minuman\nPilihan anda : ",
                                "Maaf input anda salah, Pilih opsi yang tersedia !", 1,
                                2);
                        if (pilihData == 1 && !(restoran.getMenuMakanan().isEmpty())) {
                            restoran.printMakanan();
                            int pilihMakanHapus = Fitur.validasiInteger(
                                    "Pilih nomor makanan yang akan dihapus \nPilihan anda : ",
                                    "Maaf input anda salah, Pilih opsi yang tersedia !", 1,
                                    restoran.getMenuMakanan().size());
                            restoran.getMenuMakanan().remove(pilihMakanHapus - 1);
                            System.out.println("Data menu makanan berhasil dihapus !");
                            Fitur.getChar("Tekan enter untuk kembali ke menu hapus !");
                            Fitur.clearScreen();
                        } else if (pilihData == 2 && !(restoran.getMenuMinuman().isEmpty())) {
                            restoran.printMinuman();
                            int pilihMinumHapus = Fitur.validasiInteger(
                                    "Pilih nomor minuman yang akan dihapus \nPilihan anda : ",
                                    "Maaf input anda salah, Pilih opsi yang tersedia !", 1,
                                    restoran.getMenuMinuman().size());
                            restoran.getMenuMinuman().remove(pilihMinumHapus - 1);
                            System.out.println("Data menu minuman berhasil dihapus !");
                            Fitur.getChar("Tekan enter untuk kembali ke menu hapus !");
                            Fitur.clearScreen();
                        } else if (pilihData == 1 && restoran.getMenuMakanan().isEmpty()) {
                            System.out.println(
                                    "Data makanan pada restoran yang anda pilih tidak ditemukan, \nMohon isi data makanan terlebih dahulu pada menu tambah restoran ! ");
                            Fitur.getChar("Tekan enter untuk kembali ke menu admin");
                            break;
                        } else if (pilihData == 2 && restoran.getMenuMinuman().isEmpty()) {
                            System.out.println(
                                    "Data minuman pada restoran yang anda pilih tidak ditemukan, \nMohon isi data minuman terlebih dahulu pada menu tambah restoran ! ");
                            Fitur.getChar("Tekan enter untuk kembali ke menu admin");
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