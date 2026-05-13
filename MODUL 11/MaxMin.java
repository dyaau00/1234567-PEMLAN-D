import java.util.List;
import java.util.Arrays;
import java.util.Collections;
public class MaxMin {
    public static void main(String[] args) {
        // 1. TIM A & BB
        Integer[] BBtimA = {50, 60, 56, 55, 60, 70, 66, 56, 72, 56};

        // 1.1. Mencari nilai maksimum dan minimum BB Tim A
        List<Integer> listTimA = Arrays.asList(BBtimA);
        Integer maxBBTimA = Collections.max(listTimA);
        Integer minBBTimA = Collections.min(listTimA);
        System.out.printf("Nilai maksimum BB timA: %d\n", maxBBTimA);
        System.out.printf("Nilai minimum BB timA: %d\n", minBBTimA);
        System.out.println();

        // 2. TIM B & BB
        Integer[] BBtimB = {66, 60, 59, 58, 58, 71, 68, 68, 65, 60};

        // 2.1. Mencari nilai maksimum dan minimum BB Tim B
        List<Integer> listTimB = Arrays.asList(BBtimB);
        Integer maxBBTimB = Collections.max(listTimB);
        Integer minBBTimB = Collections.min(listTimB);
        System.out.printf("Nilai maksimum BB timB: %d\n", maxBBTimB);
        System.out.printf("Nilai minimum BB timB: %d\n", minBBTimB);
        System.out.println();

        // 3. TIM A & TB
        Integer[] TBtimA = {168, 170, 165, 168, 172, 170, 169, 165, 171, 166};

        // 3.1. Sortir berdasarkan tinggi badan (turun)
        List<Integer> listTBTimA = Arrays.asList(TBtimA);
         Integer maxTBTimA = Collections.max(listTBTimA);
        Integer minTBTimA = Collections.min(listTBTimA);
        System.out.printf("Nilai maksimum TB timA: %d\n", maxTBTimA);
        System.out.printf("Nilai minimum TB timA: %d\n", minTBTimA);
        System.out.println();
    
        // 4. TIM B & TB
        Integer[] TBtimB = {170, 167, 165, 166, 168, 175, 172, 171, 168, 169};

        // 4.1. Mencari nilai maksimum dan minimum TB Tim B
        List<Integer> listTBTimB = Arrays.asList(TBtimB);
        Integer maxTBTimB = Collections.max(listTBTimB);
        Integer minTBTimB = Collections.min(listTBTimB);
        System.out.printf("Nilai maksimum TB timB: %d\n", maxTBTimB);
        System.out.printf("Nilai minimum TB timB: %d\n", minTBTimB);
    }   
}