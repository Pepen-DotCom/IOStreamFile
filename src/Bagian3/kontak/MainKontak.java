package Bagian2.bacatulis;

public class MainKontak {
    public static void main(String[] args) {
        BukuKontak buku = new BukuKontak();

        // 1. Memasukkan sampel data awal (Menguji Constructor & Atribut Baru)
        System.out.println("--- Mengisi data awal ke berkas ---");
        buku.tambahKontak(new Kontak("Budi", "0812345", "budi@email.com"));
        buku.tambahKontak(new Kontak("Andi", "0856789", "andi@email.com"));
        buku.tambahKontak(new Kontak("Siti", "0899999", "siti@email.com"));

        // Menampilkan kondisi awal kontak
        buku.tampilkanSemua();

        // 2. Menguji Poin 1: cariKontak(String nama)
        System.out.println("\n=== UJI POIN 1: CARI KONTAK ===");
        buku.cariKontak("Andi");  // Skenario kontak ada
        buku.cariKontak("Zuki");  // Skenario kontak tidak ada

        // 3. Menguji Poin 3: hapusKontak(String nama)
        System.out.println("\n=== UJI POIN 3: HAPUS KONTAK ===");
        buku.hapusKontak("Andi"); // Menghapus Andi, otomatis memanggil simpanKeBerkas()

        // Tampilkan semua kembali untuk memastikan data 'Andi' benar-benar terhapus
        buku.tampilkanSemua();
    }
}