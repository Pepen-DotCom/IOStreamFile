package Bagian2.bacatulis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LatihanMandiri {

    public static void main(String[] args) {
        String namaFile = "hari.txt";

        // ==========================================
        // 1. Tulis 5 nama hari ke dalam berkas, lalu baca & tampilkan
        // ==========================================
        System.out.println("--- Poin 1: Menulis 5 Hari Pertama ---");
        String[] limaHari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaFile))) {
            for (String hari : limaHari) {
                writer.write(hari);
                writer.newLine();
            }
            System.out.println("Selesai menulis ke " + namaFile);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis berkas: " + e.getMessage());
        }

        // Baca dan tampilkan hasil Poin 1
        bacaDanTampilkanFile(namaFile);


        // ==========================================
        // 2. Tambahkan (append) 2 nama hari lagi, lalu tampilkan seluruhnya
        // ==========================================
        System.out.println("\n--- Poin 2: Menambahkan 2 Hari Lagi ---");
        String[] duaHariLagi = {"Sabtu", "Minggu"};
        
        // Perhatikan argumen 'true' pada FileWriter untuk mengaktifkan mode append (menambah tanpa menghapus)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaFile, true))) {
            for (String hari : duaHariLagi) {
                writer.write(hari);
                writer.newLine();
            }
            System.out.println("Selesai menambahkan hari baru.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menambahkan data: " + e.getMessage());
        }

        // Baca dan tampilkan hasil Poin 2
        bacaDanTampilkanFile(namaFile);


        // ==========================================
        // 3. Baca berkas lalu hitung total barisnya
        // ==========================================
        System.out.println("\n--- Poin 3: Menghitung Jumlah Baris ---");
        int jumlahBaris = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(namaFile))) {
            while (reader.readLine() != null) {
                jumlahBaris++;
            }
            System.out.println("Jumlah total baris di dalam berkas " + namaFile + " adalah: " + jumlahBaris);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menghitung baris: " + e.getMessage());
        }
    }

    /**
     * Helper method untuk membaca berkas dan menampilkan isinya ke layar
     */
    private static void bacaDanTampilkanFile(String namaFile) {
        System.out.println("Isi berkas saat ini:");
        try (BufferedReader reader = new BufferedReader(new FileReader(namaFile))) {
            String baris;
            while ((baris = reader.readLine()) != null) {
                System.out.println("- " + baris);
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca berkas: " + e.getMessage());
        }
    }
}