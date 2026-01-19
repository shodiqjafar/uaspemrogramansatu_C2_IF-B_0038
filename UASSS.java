import java.util.Scanner;

public class UASSS {

    public static void main(String[] args) {

        Scanner PARR = new Scanner(System.in);

        int maxData = 100;
       
        String[] nama = new String[maxData];
        String[] jenis = new String[maxData];
        int[] hari = new int[maxData];
        double[] totalBiaya = new double[maxData];
        String[] kategori = new String[maxData];

        int jumlahData = 0;
        int pilihan;

        do {
            System.out.println("\n=== SISTEM PENYEWAAN KENDARAAN ===");
            System.out.println("1. DATA PENYEWAAAN KENDARAAN");
            System.out.println("2. DATA PENYEWAAN");
            System.out.println("3. RINGKASANN RENTAL");
            System.out.println("4. KELUAR");
            System.out.print("PILIH MENU DIATAS: ");
            pilihan = PARR.nextInt();
            PARR.nextLine();

            switch (pilihan) {

                case 1:
                    
                 for (int i = 0; i < 1; i++) {
                System.out.println("\nData Penyewaan ke-" + (jumlahData + 1));
                System.out.print("Nama Penyewa: ");
                 nama[jumlahData] = PARR.nextLine();

                 System.out.print("Jenis Kendaraan (Motor/Mobil/Minibus): ");            
                 jenis[jumlahData] = PARR.nextLine();

                        System.out.print("Jumlah Hari Sewa: ");
                        hari[jumlahData] = PARR.nextInt();
                        PARR.nextLine();

                        double tarif = 0;
            
                        switch (jenis[jumlahData].toLowerCase()) {
                            case "motor":
                                tarif = 75000;
                                break;
                            case "mobil":
                                tarif = 250000;
                          break;
                            case "minibus":
                                tarif = 400000;
                                break;
                            default:
                                System.out.println("Jenis kendaraan tidak valid!");
                                tarif = 0;
                        }

                        double total = tarif * hari[jumlahData];
                        
                        if (hari[jumlahData] > 3) {
                            total = total - (total * 0.15);
                            System.out.println("SELAMAT ANDA DAPAT DISKON 15%!!!");
                        }

                        totalBiaya[jumlahData] = total;
                       
                        if (total < 300000) {
                            kategori[jumlahData] = "EKONOMIS";
                        } else if (total <= 750000) {
                            kategori[jumlahData] = "STANDAR";
                        } else {
                            kategori[jumlahData] = "PREMIUM";
                        }

                        jumlahData++;
                    }
                    break;

                case 2:
                    if (jumlahData == 0) {
                        System.out.println("\n DATA BELUM TERSEDIA");
                    } else {
                        System.out.println("\n=== DATA PENYEWAAN ===");
                        for (int i = 0; i < jumlahData; i++) {
                            System.out.println(
                                (i + 1) + ". " +
                                nama[i] + " | " +
                                jenis[i] + " | " +
                                hari[i] + " hari | Rp" +
                                totalBiaya[i] + " | " +
                                kategori[i]
                            );
                        }
                    }
                    break;

                case 3:
                    if (jumlahData == 0) {
                        System.out.println("\n BELUM DAPAT DITAMPILKAN ");
                    } else {
                        double totalSemua = 0;

                        for (int i = 0; i < jumlahData; i++) {
                            totalSemua += totalBiaya[i];
                        }

                        double rataRata = totalSemua / jumlahData;

                        System.out.println("\n=== RINGKASAN RENTAL ===");
                        System.out.println("Total Penyewaan : " + jumlahData);
                        System.out.println("Rata-rata Biaya : Rp" + rataRata);
                    }
                    break;

                case 4:
                    System.out.println("\nTerima kasih telah menggunakan program ini.");
                    System.out.println("Total penyewaan tercatat: " + jumlahData + totalBiaya);
                    
                    break;

                default:
                    System.out.println("\nMenu tidak tersedia!");
            }
        } while (pilihan != 4);
    }
}
