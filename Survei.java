import java.util.Scanner;

public class Survei {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int JUMLAH_RESPONDEN = 10;
        final int JUMLAH_PERTANYAAN = 6;

        int[][] survei = new int[JUMLAH_RESPONDEN][JUMLAH_PERTANYAAN];

        for (int i = 0; i < survei.length; i++) {
            System.out.println("Responden ke-" + (i + 1));

            for (int j = 0; j < survei[i].length; j++) {
                System.out.print("Jawaban pertanyaan " + (j + 1) + " (1-5): ");
                survei[i][j] = sc.nextInt();

                while (survei[i][j] < 1 || survei[i][j] > 5) {
                    System.out.print("Jawaban harus 1 sampai 5. Ulangi: ");
                    survei[i][j] = sc.nextInt();
                }
            }
        }

        double totalKeseluruhan = 0;

        System.out.println("\n========================================");
        System.out.println("Rata-rata nilai setiap responden:");

        for (int i = 0; i < survei.length; i++) {
            double totalPerResponden = 0;

            for (int j = 0; j < survei[i].length; j++) {
                totalPerResponden += survei[i][j];
            }

            totalKeseluruhan += totalPerResponden;
            System.out.println("Responden " + (i + 1) + ": " + totalPerResponden / survei[i].length);
        }

        System.out.println("\n========================================");
        System.out.println("Rata-rata nilai setiap pertanyaan:");

        for (int j = 0; j < survei[0].length; j++) {
            double totalPerPertanyaan = 0;

            for (int i = 0; i < survei.length; i++) {
                totalPerPertanyaan += survei[i][j];
            }

            System.out.println("Pertanyaan " + (j + 1) + ": " + totalPerPertanyaan / survei.length);
        }

        System.out.println("\n========================================");
        System.out.println("Rata-rata nilai keseluruhan: "
                + totalKeseluruhan / (JUMLAH_RESPONDEN * JUMLAH_PERTANYAAN));
    }
}
