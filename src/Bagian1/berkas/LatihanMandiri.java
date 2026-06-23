package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class LatihanMandiri {
    public static void main(String[] args) {

        // 1. Objek File laporan.txt
        File laporan = new File("laporan.txt");

        if (laporan.exists()) {
            System.out.println("1. Berkas laporan.txt ada. Ukuran: " 
                    + laporan.length() + " byte.");
        } else {
            System.out.println("1. Berkas laporan.txt tidak ditemukan.");
        }

        // 2. Membuat folder arsip
        File folder = new File("arsip");

        if (folder.mkdir()) {
            System.out.println("2. Folder 'arsip' berhasil dibuat.");
        } else {
            System.out.println("2. Gagal membuat folder 'arsip' (mungkin sudah ada).");
        }

        // 3. Membuat dan menghapus sementara.txt
        File sementara = new File("sementara.txt");

        try {
            // Membuat berkas
            if (sementara.createNewFile()) {
                System.out.println("3. Berkas sementara.txt dibuat.");
            }

            // Status sebelum dihapus
            System.out.println("Status sebelum dihapus: " + sementara.exists());

            // Hapus berkas
            if (sementara.delete()) {
                System.out.println("3. Berkas sementara.txt dihapus.");
            }

            // Status sesudah dihapus
            System.out.println("Status sesudah dihapus: " + sementara.exists());

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}