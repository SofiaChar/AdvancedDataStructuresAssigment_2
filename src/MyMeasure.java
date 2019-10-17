import java.util.Arrays;

public class MyMeasure implements A2Measure {


    @Override
    public boolean isSameCollection(int[] array1, int[] array2){
        int n = array1.length;
        int m = array2.length;

        if (n != m)
            return false;

        Arrays.sort(array1);
        Arrays.sort(array2);

        for (int i = 0; i < n; i++)
            if (array1[i] != array2[i])
                return false;

        // If all elements were same.
        return true;
    }
//
    @Override
    public int minDifferences(int[] array1, int[] array2){
        return 0;
    }

   // public int[] getPercentileRange(int[] arr, int lower, int upper) {}
}
