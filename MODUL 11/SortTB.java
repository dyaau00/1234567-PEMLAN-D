import java.util.List;
import java.util.Arrays;
import java.util.Collections;
public class SortTB {
    public static void main(String[] args) {
        // 1. TIM A
        Integer[] timA = {168, 170, 165, 168, 172, 170, 169, 165, 171, 166};

        // 1.1. Sortir berdasarkan tinggi badan (naik)
        List<Integer> listTimA = Arrays.asList(timA);
        System.out.printf("Sebelum sorting naik timA:%s\n", listTimA);
        Collections.sort(listTimA);
        System.out.printf("Setelah sorting naik timA:%s\n", listTimA);

        // 1.2. Sortir berdasarkan tinggi badan (turun)
        System.out.printf("Sebelum sorting turun timA:%s\n", listTimA);
        Collections.sort(listTimA, Collections.reverseOrder());
        System.out.printf("Setelah sorting turun timA:%s\n", listTimA);
    
        // 2. TIM B
        Integer[] timB = {170, 167, 165, 166, 168, 175, 172, 171, 168, 169};

        // 2.1. Sortir berdasarkan tinggi badan (naik)
        List<Integer> listTimB = Arrays.asList(timB);
        System.out.printf("Sebelum sorting naik timB:%s\n", listTimB);
        Collections.sort(listTimB);
        System.out.printf("Setelah sorting naik timB:%s\n", listTimB);

        // 2.2. Sortir berdasarkan tinggi badan (turun)
        System.out.printf("Sebelum sorting turun timB:%s\n", listTimB);
        Collections.sort(listTimB, Collections.reverseOrder());
        System.out.printf("Setelah sorting turun timB:%s\n", listTimB);
    }   
}