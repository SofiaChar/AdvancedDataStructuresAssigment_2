import java.util.Arrays;

public class MyMeasure implements A2Measure {

    @Override
    public boolean isSameCollection(int[] array1, int[] array2){
        int n = array1.length;
        int m = array2.length;

        // If lengths of array are not equal means array are not equal
        if (n != m)
            return false;

        // Sort both arrays
        Arrays.sort(array1);
        Arrays.sort(array2);

        // Linearly compare elements
        for (int i = 0; i < n; i++)
            if (array1[i] != array2[i])
                return false;

        // If all elements were same.
        return true;
    }

   // public int minDifferences(int[] array1, int[] array2){}

   // public int[] getPercentileRange(int[] arr, int lower, int upper) {}
}
