import java.util.Scanner;
import java.util.regex.Pattern;
import java.security.SecureRandom;

/*
 * Class Fitur:
 *      - Class ini merupakan tempat untuk menyimpan method-method yang diperlukan pada program restoran online.
 *        
 *      - Method clear screen untuk membersihkan layar console pada saat menjalankan program.
 * 
 *      - Method get char yang berfungsi untuk menghentikan program sebentar dan melanjutkannya lagi bila user
 *        menekan tombol enter. 
 * 
 *      - Method validasi integer berfungsi untuk menerima input dari user dan menvalidasinya agar
 *        hanya bertipe integer dan berada pada range yang diberikan pada parameter method. 
 *        kemudian hasilnya akan direturn dengan tipe integer.
 * 
 *      - Method validasi char berfungsi untuk menerima input dari user dan menvalidasinya agar inputan dari user hanya bernilai y/n. 
 *        dan hasilnya akan di return dalam bentuk char.
 * 
 *      - Method id generator merupakan method yang berfungsi untuk mengenerate id dengan panjang tertentu (didapat dari parameter)
 *        yang nantinya akan digunakan pada setiap data restoran dan menu. dan hasilnya akan direturn dalam bentuk string
 * 
 *      - Method validasi double berfungsi untuk menerima input dari user dan menvalidasikannya agar bertipe double
 *        dan masukkannya lebih dari 0 dan nantinya akan digunakan user untuk memasukkan jarak antar pada saat membuat pesanan.
 *        hasilnya akan direturn dalam bentuk double.
 *        
 */

public class Fitur {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void getChar(String petunjuk) {
        Scanner input = new Scanner(System.in);
        System.out.print(petunjuk);
        String enter = input.nextLine();
    }

    public static int validasiInteger(String petunjuk, String outrange, int range1, int range2) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print(petunjuk);
            String masukkan = input.nextLine();
            if (masukkan.matches("\\d+")) {
                int pilih = Integer.parseInt(masukkan);
                if ((pilih >= range1) && (pilih <= range2)) {
                    return pilih;
                } else {
                    System.out.println(outrange);
                    getChar("Tekan enter untuk mengulang ! ");
                }
            } else {
                System.out.println("Maaf input Anda salah, Tolong masukkan angka ! ");
                getChar("Tekan enter untuk mengulang ! ");
            }
        }
    }

    public static char validasiChar() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("\nMasukkan (y/n) : ");
            String yakin = input.nextLine();
            if (yakin.length() != 1) {
                System.out.println("Maaf input anda salah, Mohon ikuti petunjuk !");
            } else if ((yakin.length() == 1) && (yakin.charAt(0) == 'y' || yakin.charAt(0) == 'n')) {
                return yakin.charAt(0);
            } else {
                System.out.println("Maaf input anda salah, Mohon ikuti petunjuk !");
            }
        }
    }

    public static String idGenerator(int panjang) {
        final String NOMOR = "0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < panjang; i++) {
            int indexAcak = random.nextInt(NOMOR.length());
            char nomorAcak = NOMOR.charAt(indexAcak);
            sb.append(nomorAcak);
        }
        return sb.toString();
    }

    public static double validasiDouble() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Jawab (Km) : ");
            String masukkan = input.nextLine();
            if (Pattern.matches("\\d+(\\.\\d+)?", masukkan)) {
                double nilai = Double.parseDouble(masukkan);
                if (nilai > 0) {
                    return nilai;
                } else {
                    System.out.print("Jarak antara lokasi antar tidak boleh kurang atau sama dengan nol !\n");
                }
            } else {
                System.out.println("Maaf input anda salah, Mohon ikuti petunjuk !");
            }
        }
    }
}
