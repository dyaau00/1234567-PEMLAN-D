import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// Membuat class Anggota untuk membungkus data TB dan BB
class Anggota {
    int tb;
    int bb;

    public Anggota(int tb, int bb) {
        this.tb = tb;
        this.bb = bb;
    }

    // Overriding toString supaya pas dicetak hasilnya rapi
    @Override
    public String toString() {
        return String.format("(TB: %d, BB: %d)", tb, bb);
    }
}

public class BinarySearch {
    public static void main(String[] args) {
        // POIN A. ARRAY LIST
        ArrayList<Anggota> timA = new ArrayList<>();
        ArrayList<Anggota> timB = new ArrayList<>();

        // Memasukkan data Tim A dari tabel
        timA.add(new Anggota(168, 50));
        timA.add(new Anggota(170, 60));
        timA.add(new Anggota(165, 56));
        timA.add(new Anggota(168, 55));
        timA.add(new Anggota(172, 60));
        timA.add(new Anggota(170, 70));
        timA.add(new Anggota(169, 66));
        timA.add(new Anggota(165, 56));
        timA.add(new Anggota(171, 72));
        timA.add(new Anggota(166, 56));

        // Memasukkan data Tim B dari tabel
        timB.add(new Anggota(170, 66));
        timB.add(new Anggota(167, 60));
        timB.add(new Anggota(165, 59));
        timB.add(new Anggota(166, 58));
        timB.add(new Anggota(168, 58));
        timB.add(new Anggota(175, 71));
        timB.add(new Anggota(172, 68));
        timB.add(new Anggota(171, 68));
        timB.add(new Anggota(168, 65));
        timB.add(new Anggota(169, 60));

        System.out.println("Data Tim A: " + timA);
        System.out.println("Data Tim B: " + timB);

        // --- POIN B: Mencari jumlah pemain TB 168cm dan 160cm ---
        // 1. Wajib Urutkan Tim B berdasarkan Tinggi Badan (TB) secara Ascending
        Collections.sort(timB, Comparator.comparingInt(a -> a.tb));
        System.out.println("Tim B Terurut (TB): " + timB);

        // 2. Cari target 168 cm
        int target1 = 168;
        int hasil1 = hitungPemainTB(timB, target1);
        System.out.println("Jumlah pemain dengan TB " + target1 + " cm: " + hasil1);

        // 3. Cari target 160 cm
        int target2 = 160;
        int hasil2 = hitungPemainTB(timB, target2);
        System.out.println("Jumlah pemain dengan TB " + target2 + " cm: " + hasil2);

        // --- POIN C: Mencari jumlah pemain BB 56kg dan 53kg di Tim A ---
        // 1. Wajib Urutkan Tim A berdasarkan Berat Badan (BB) secara Ascending
        Collections.sort(timA, Comparator.comparingInt(a -> a.bb));
        System.out.println("\nTim A Terurut (BB): " + timA);

        // 2. Cari target 56 kg
        int targetBB1 = 56;
        int hasilBB1 = hitungPemainBB(timA, targetBB1);
        System.out.println("Jumlah pemain dengan BB " + targetBB1 + " kg di Tim A: " + hasilBB1);

        // 3. Cari target 53 kg
        int targetBB2 = 53;
        int hasilBB2 = hitungPemainBB(timA, targetBB2);
        System.out.println("Jumlah pemain dengan BB " + targetBB2 + " kg di Tim A: " + hasilBB2);

        // --- POIN D: Cek apakah ada pemain Tim A yang sama dengan Tim B ---
        System.out.println("\n--- POIN D (Pengecekan Kesamaan Pemain) ---");
        
        // 1. Urutkan Tim B berdasarkan TB sebagai referensi pencarian
        Collections.sort(timB, Comparator.comparingInt(b -> b.tb));
        
        boolean adaYangSama = false;

        // 2. Iterasi setiap anggota di Tim A
        for (Anggota pemainA : timA) {
            // Gunakan Binary Search untuk cari TB pemainA di dalam Tim B
            int indexCek = Collections.binarySearch(timB, pemainA, Comparator.comparingInt(b -> b.tb));
            
            // Jika index >= 0 artinya TB-nya ditemukan di Tim B
            if (indexCek >= 0) {
                // Karena Binary Search hanya menjamin TB sama, kita cek manual BB-nya
                if (timB.get(indexCek).bb == pemainA.bb) {
                    System.out.println("Ketemu! Pemain Tim A " + pemainA + " sama persis dengan pemain di Tim B.");
                    adaYangSama = true;
                }
            }
        }

        if (!adaYangSama) {
            System.out.println("Tidak ada pemain di Tim A yang memiliki TB dan BB yang sama dengan pemain di Tim B.");
        }
    }

    // Method untuk Binary Search dan menghitung jumlah kemunculan
    public static int hitungPemainTB(ArrayList<Anggota> list, int target) {
        // Kita gunakan dummy object untuk pencarian karena list isinya objek Anggota
        Anggota targetObj = new Anggota(target, 0); 
        
        // Binary Search berdasarkan property tb
        int index = Collections.binarySearch(list, targetObj, Comparator.comparingInt(a -> a.tb));

        if (index < 0) { return 0; }

        // Kalau ketemu, kita cek ke kiri dan kanan karena mungkin ada data kembar
        int count = 1;
        
        // Cek ke kiri
        for (int i = index - 1; i >= 0 && list.get(i).tb == target; i--) { count++; }
        // Cek ke kanan
        for (int i = index + 1; i < list.size() && list.get(i).tb == target; i++) { count++; }
        return count;
    }

        // Method khusus untuk menghitung jumlah pemain berdasarkan Berat Badan
    public static int hitungPemainBB(ArrayList<Anggota> list, int target) {
        // Dummy object dengan BB target untuk pencarian
        Anggota targetObj = new Anggota(0, target); 
        
        // Binary Search menggunakan comparator BB
        int index = Collections.binarySearch(list, targetObj, Comparator.comparingInt(a -> a.bb));

        if (index < 0) return 0;

        int count = 1;
        // Cek tetangga kiri
        for (int i = index - 1; i >= 0 && list.get(i).bb == target; i--) count++;
        // Cek tetangga kanan
        for (int i = index + 1; i < list.size() && list.get(i).bb == target; i++) count++;

        return count;
    }
}