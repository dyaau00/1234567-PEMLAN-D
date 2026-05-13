import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class Copy {
    public static void main(String[] args) {
        // 1. Data Tim B dari file Sort sebelumnya
        Integer[] TBtimB = {170, 167, 165, 166, 168, 175, 172, 171, 168, 169};
        List<Integer> listTimB = new ArrayList<>(Arrays.asList(TBtimB));

        // 2. Lakukan Sorting dulu (karena instruksinya dari data yang sudah urut)
        Collections.sort(listTimB);
        System.out.println("Tim B setelah di-sort: " + listTimB);

        // 3. Proses Copy ke Tim C
        // Kita buat ArrayList baru dengan isi yang sama dengan listTimB
        List<Integer> listTimC = new ArrayList<>(listTimB);

        // 4.Cetak
        System.out.println("--- Hasil Copy ke Tim C ---");
        System.out.println("Seluruh anggota Tim C: " + listTimC);
        System.out.println("Jumlah anggota Tim C: " + listTimC.size());
    }
}