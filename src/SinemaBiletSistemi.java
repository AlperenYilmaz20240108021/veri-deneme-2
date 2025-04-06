import java.util.Scanner;

public class SinemaBiletSistemi {

    static final int MAX_FILM = 10;
    static final int MAX_MUSTERI = 20;

    static String[] filmAdlari = new String[MAX_FILM];
    static int[] filmSureleri = new int[MAX_FILM];
    static String[] filmTurleri = new String[MAX_FILM];

    static String[] musteriAdlari = new String[MAX_MUSTERI];
    static String[] musteriEmailleri = new String[MAX_MUSTERI];

    static int[][] biletler = new int[MAX_MUSTERI][MAX_FILM];

    static int filmSayisi = 0;
    static int musteriSayisi = 0;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            menuGoster();
            int secim = scanner.nextInt();
            scanner.nextLine(); // Enter'ı tüket

            switch (secim) {
                case 1:
                    filmEkle();
                    break;
                case 2:
                    musteriEkle();
                    break;
                case 3:
                    biletSat();
                    break;
                case 4:
                    filmleriListele();
                    break;
                case 5:
                    musterileriListele();
                    break;
                case 6:
                    biletleriListele();
                    break;
                case 0:
                    System.out.println("Sistemden çıkılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    static void menuGoster() {
        System.out.println("\nSinema Bilet Sistemi");
        System.out.println("1. Film Ekle");
        System.out.println("2. Müşteri Ekle");
        System.out.println("3. Bilet Sat");
        System.out.println("4. Filmleri Listele");
        System.out.println("5. Müşterileri Listele");
        System.out.println("6. Biletleri Listele");
        System.out.println("0. Çıkış");
        System.out.print("Seçiminiz: ");
    }

    static void filmEkle() {
        if (filmSayisi < MAX_FILM) {
            System.out.print("Film Adı: ");
            filmAdlari[filmSayisi] = scanner.nextLine();
            System.out.print("Film Süresi (dakika): ");
            filmSureleri[filmSayisi] = scanner.nextInt();
            scanner.nextLine(); // Enter'ı tüket
            System.out.print("Film Türü: ");
            filmTurleri[filmSayisi] = scanner.nextLine();
            filmSayisi++;
            System.out.println("Film eklendi.");
        } else {
            System.out.println("Maksimum film sayısına ulaşıldı!");
        }
    }

    static void musteriEkle() {
        if (musteriSayisi < MAX_MUSTERI) {
            System.out.print("Müşteri Adı: ");
            musteriAdlari[musteriSayisi] = scanner.nextLine();
            System.out.print("Müşteri E-posta: ");
            musteriEmailleri[musteriSayisi] = scanner.nextLine();
            musteriSayisi++;
            System.out.println("Müşteri eklendi.");
        } else {
            System.out.println("Maksimum müşteri sayısına ulaşıldı!");
        }
    }

    static void biletSat() {
        if (musteriSayisi > 0 && filmSayisi > 0) {
            System.out.println("Müşteriler:");
            for (int i = 0; i < musteriSayisi; i++) {
                System.out.println((i + 1) + ". " + musteriAdlari[i]);
            }
            System.out.print("Müşteri Seçin (1-" + musteriSayisi + "): ");
            int musteriSecimi = scanner.nextInt() - 1;

            System.out.println("Filmler:");
            for (int i = 0; i < filmSayisi; i++) {
                System.out.println((i + 1) + ". " + filmAdlari[i]);
            }
            System.out.print("Film Seçin (1-" + filmSayisi + "): ");
            int filmSecimi = scanner.nextInt() - 1;

            biletler[musteriSecimi][filmSecimi] = 1;
            System.out.println("Bilet satıldı.");
        } else {
            System.out.println("Önce müşteri ve film ekleyin!");
        }
    }

    static void filmleriListele() {
        if (filmSayisi > 0) {
            System.out.println("\nFilmler:");
            for (int i = 0; i < filmSayisi; i++) {
                System.out.println((i + 1) + ". " + filmAdlari[i] + " (" + filmSureleri[i] + " dk, " + filmTurleri[i] + ")");
            }
        } else {
            System.out.println("Henüz film eklenmedi!");
        }
    }

    static void musterileriListele() {
        if (musteriSayisi > 0) {
            System.out.println("\nMüşteriler:");
            for (int i = 0; i < musteriSayisi; i++) {
                System.out.println((i + 1) + ". " + musteriAdlari[i] + " (" + musteriEmailleri[i] + ")");
            }
        } else {
            System.out.println("Henüz müşteri eklenmedi!");
        }
    }

    static void biletleriListele() {
        if (musteriSayisi > 0) {
            System.out.println("\nBiletler:");
            for (int i = 0; i < musteriSayisi; i++) {
                System.out.print(musteriAdlari[i] + ": ");
                for (int j = 0; j < filmSayisi; j++) {
                    if (biletler[i][j] == 1) {
                        System.out.print(filmAdlari[j] + ", ");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("Henüz bilet satılmadı!");
        }
    }
}