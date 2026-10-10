import java.util.Scanner;

public class StudiKasus227 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String namaMahasiswa;
        String jenisKegiatan;
        String dokumen;
        int peringkatJuara;
        int statusPkm;
        int jumlahKurang;
        String daftarKurang;

        System.out.print("Nama mahasiswa  : ");
        namaMahasiswa = scanner.nextLine();

        System.out.print("Jenis kegiatan (BELMAWA/BAKORMA/MANDIRI/PKM/LAINNYA) : ");
        jenisKegiatan = scanner.nextLine();

        // TINGKAT 1: cek jenis kegiatan
        if (jenisKegiatan.equalsIgnoreCase("BELMAWA")
                || jenisKegiatan.equalsIgnoreCase("BAKORMA")
                || jenisKegiatan.equalsIgnoreCase("Mandiri")) {

            // ===== Cabang lomba =====
            System.out.print("Peringkat juara : ");
            peringkatJuara = scanner.nextInt();
            scanner.nextLine(); // buang sisa Enter setelah nextInt

            // TINGKAT 2: cek juara
            if (peringkatJuara >= 1 && peringkatJuara <= 3) {

                System.out.print("Dokumen (Surat Tugas, Sertifikat, Foto Kegiatan, Poster Kegiatan) : ");
                dokumen = scanner.nextLine().toLowerCase();

                jumlahKurang = 0;
                daftarKurang = "";

                // TINGKAT 3: cek tiap dokumen wajib
                if (!dokumen.contains("surat tugas")) {
                    jumlahKurang++;
                    daftarKurang += (daftarKurang.isEmpty() ? "" : ", ") + "Surat Tugas";
                }
                if (!dokumen.contains("sertifikat")) {
                    jumlahKurang++;
                    daftarKurang += (daftarKurang.isEmpty() ? "" : ", ") + "Sertifikat";
                }
                if (!dokumen.contains("foto kegiatan")) {
                    jumlahKurang++;
                    daftarKurang += (daftarKurang.isEmpty() ? "" : ", ") + "Foto Kegiatan";
                }
                if (!dokumen.contains("poster kegiatan")) {
                    jumlahKurang++;
                    daftarKurang += (daftarKurang.isEmpty() ? "" : ", ") + "Poster Kegiatan";
                }

                // TINGKAT 3: cek kelengkapan
                if (jumlahKurang == 0) {
                    System.out.println("Status : Dokumen lengkap. Berhak memperoleh dana penghargaan (Juara "
                            + peringkatJuara + ").");
                } else {
                    System.out.println("Status : Dokumen tidak lengkap (kurang " + jumlahKurang
                            + " dokumen). Dana penghargaan tidak diberikan.");
                    System.out.println("Dokumen yang kurang : " + daftarKurang);
                }

            } else {
                System.out.println("Status : Tidak memperoleh dana penghargaan (hanya untuk Juara 1/2/3).");
            }

        } else if (jenisKegiatan.equalsIgnoreCase("PKM")) {

            // ===== Cabang PKM =====
            System.out.print("Status pendanaan PKM (1 = lolos, 0 = tidak lolos) : ");
            statusPkm = scanner.nextInt();
            scanner.nextLine(); // buang sisa Enter setelah nextInt

            // TINGKAT 2: cek lolos pendanaan
            if (statusPkm == 1) {

                System.out.print("Dokumen (Surat Tugas, Sertifikat, Foto Kegiatan, Poster Kegiatan) : ");
                dokumen = scanner.nextLine().toLowerCase();

                jumlahKurang = 0;
                daftarKurang = "";

                // TINGKAT 3: cek tiap dokumen wajib
                if (!dokumen.contains("surat tugas")) {
                    jumlahKurang++;
                    daftarKurang += (daftarKurang.isEmpty() ? "" : ", ") + "Surat Tugas";
                }
                if (!dokumen.contains("sertifikat")) {
                    jumlahKurang++;
                    daftarKurang += (daftarKurang.isEmpty() ? "" : ", ") + "Sertifikat";
                }
                if (!dokumen.contains("foto kegiatan")) {
                    jumlahKurang++;
                    daftarKurang += (daftarKurang.isEmpty() ? "" : ", ") + "Foto Kegiatan";
                }
                if (!dokumen.contains("poster kegiatan")) {
                    jumlahKurang++;
                    daftarKurang += (daftarKurang.isEmpty() ? "" : ", ") + "Poster Kegiatan";
                }

                // TINGKAT 3: cek kelengkapan
                if (jumlahKurang == 0) {
                    System.out.println("Status : Dokumen lengkap. Berhak memperoleh dana penghargaan (PKM lolos pendanaan).");
                } else {
                    System.out.println("Status : Dokumen tidak lengkap (kurang " + jumlahKurang
                            + " dokumen). Dana penghargaan tidak diberikan.");
                    System.out.println("Dokumen yang kurang : " + daftarKurang);
                }

            } else {
                System.out.println("Status : Tidak memperoleh dana penghargaan (PKM tidak lolos pendanaan).");
            }

        } else if (jenisKegiatan.equalsIgnoreCase("Lainnya")) {

            // ===== Cabang Lainnya =====
            System.out.println("Status : Tidak memperoleh dana penghargaan (jenis kegiatan tidak termasuk ketentuan).");

        } else {
            System.out.println("Status : Jenis kegiatan tidak dikenali.");
        }

        scanner.close();
    }
}