package Bagian3.kontak;

public class Kontak {
    private String nama;
    private String nomorTelepon;
    private String email; // Tambahan atribut baru (Poin 2)

    // Constructor yang disesuaikan
    public Kontak(String nama, String nomorTelepon, String email) {
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
        this.email = email;
    }

    // Getter
    public String getNama() {
        return nama;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public String getEmail() {
        return email;
    }

    // Mengubah objek menjadi format baris teks untuk disimpan ke berkas
    public String keBaris() {
        return nama + "," + nomorTelepon + "," + email; 
    }

    // Menampilkan informasi lengkap kontak ke layar
    public void info() {
        System.out.println("Nama    : " + nama);
        System.out.println("Telepon : " + nomorTelepon);
        System.out.println("Email   : " + email);
    }
}
