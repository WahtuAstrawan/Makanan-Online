import java.util.Scanner;
import java.util.regex.Pattern;
import java.security.SecureRandom;

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
