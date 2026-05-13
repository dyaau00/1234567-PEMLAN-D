import java.util.List;
import java.util.Arrays;
import java.util.Collections;
public class SortBB {
    public static void main(String[] args) {
        // 1. TIM A
        Integer[] timA = {50, 60, 56, 55, 60, 70, 66, 56, 72, 56};

        // 1.1. Sortir berdasarkan berat badan (naik)
        List<Integer> listTimA = Arrays.asList(timA);
        System.out.printf("Sebelum sorting naik timA:%s\n", listTimA);
        Collections.sort(listTimA);
        System.out.printf("Setelah sorting naik timA:%s\n", listTimA);

        // 1.2. Sortir berdasarkan berat badan (turun)
        System.out.printf("Sebelum sorting turun timA:%s\n", listTimA);
        Collections.sort(listTimA, Collections.reverseOrder());
        System.out.printf("Setelah sorting turun timA:%s\n", listTimA);
    
        // 2. TIM B
        Integer[] timB = {66, 60, 59, 58, 58, 71, 68, 68, 65, 60};

        // 2.1. Sortir berdasarkan berat badan (naik)
        List<Integer> listTimB = Arrays.asList(timB);
        System.out.printf("Sebelum sorting naik timB:%s\n", listTimB);
        Collections.sort(listTimB);
        System.out.printf("Setelah sorting naik timB:%s\n", listTimB);

        // 2.2. Sortir berdasarkan berat badan (turun)
        System.out.printf("Sebelum sorting turun timB:%s\n", listTimB);
        Collections.sort(listTimB, Collections.reverseOrder());
        System.out.printf("Setelah sorting turun timB:%s\n", listTimB);
    }   
}