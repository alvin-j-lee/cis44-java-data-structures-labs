//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Random;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        int n=5;
        Random rand = new Random();

        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(10);
            b[i] = rand.nextInt(10);

            c[i] = a[i] * b[i];
        }

        System.out.println("Array a: " + Arrays.toString(a));
        System.out.println("Array b: " + Arrays.toString(b));
        System.out.println("Array c (a*b): " + Arrays.toString(c));
    }
}