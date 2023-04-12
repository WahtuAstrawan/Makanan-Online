import java.util.Scanner;

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
                clearScreen();
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

}
