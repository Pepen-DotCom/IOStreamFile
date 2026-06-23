package Bagian3.kontak;

import java.io.*;
import java.util.ArrayList;

public class BukuKontak {
    private ArrayList<Kontak> daftarKontak;
    private String namaFile = "kontak.txt";

    public BukuKontak() {
        daftarKontak = new ArrayList<>();
        muatDariBerkas(); // Otomatis memuat data saat objek dibuat
    }

    // ==========================================
    // POIN 1: Method Cari Kontak
    // ==========================================
    public void cariKontak(String nama) {
        boolean ditemukan = false;
        for (Kontak k : daftarKontak) {
            if (k.getNama().equalsIgnoreCase(nama)) {
                System.out.println("\n[Kontak Ditemukan]");
                k.info();
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("\n[Info] Kontak dengan nama '" + nama + "' tidak ditemukan.");
        }
    }

    // ==========================================
    // POIN 3: Method Hapus Kontak
    // ==========================================
    public void hapusKontak(String nama) {
        boolean ditemukan = false;
        for (int i = 0; i < daftarKontak.size(); i++) {
            if (daftarKontak.get(i).getNama().equalsIgnoreCase(nama)) {
                daftarKontak.remove(i);
                ditemukan = true;
                System.out.println("\n[Sukses] Kontak '" + nama + "' berhasil dihapus.");
                break;
            }
        }

        if (ditemukan) {
            simpanKeBerkas(); // Simpan perubahan ke file jika ada yang dihapus
        } else {
            System.out.println("\n[Gagal] Kontak '" + nama + "' tidak ditemukan, tidak ada yang dihapus.");
        }
    }

    // ==========================================
    // POIN 2: Muat Berkas dengan Pemisahan 3 Bagian
    // ==========================================
    public void muatDariBerkas() {
        daftarKontak.clear();
        File file = new File(namaFile);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(namaFile))) {
            String baris;
            while ((baris = reader.readLine()) != null) {
                // Memecah menjadi 3 bagian: nama, nomorTelepon, email
                String[] bagian = baris.split(",", 3); 
                if (bagian.length == 3) {
                    Kontak k = new Kontak(bagian[0], bagian[1], bagian[2]);
                    daftarKontak.add(k);
                }
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca berkas: " + e.getMessage());
        }
    }

    // Method helper untuk menyimpan data ke dalam berkas
    public void simpanKeBerkas() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaFile))) {
            for (Kontak k : daftarKontak) {
                writer.write(k.keBaris());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Gagal menyimpan ke berkas: " + e.getMessage());
        }
    }

    // Method helper untuk menampilkan seluruh isi buku kontak saat ini
    public void tampilkanSemua() {
        if (daftarKontak.isEmpty()) {
            System.out.println("Buku kontak kosong.");
            return;
        }
        System.out.println("\n=== DAFTAR KONTAK SAAT INI ===");
        for (Kontak k : daftarKontak) {
            k.info();
            System.out.println("-------------------------");
        }
    }

    // Method helper untuk menambah kontak baru lewat Main
    public void tambahKontak(Kontak k) {
        daftarKontak.add(k);
        simpanKeBerkas();
    }
}
