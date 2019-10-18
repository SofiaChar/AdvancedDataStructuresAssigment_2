
public class MyMeasure implements A2Measure {


    public static void selectionSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int min_i = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                int tmp = array[i];
                array[i] = array[min_i];
                array[min_i] = tmp;
            }
        }
    }

    @Override
    public boolean isSameCollection(int[] array1, int[] array2) {
        int N = array1.length;
        int M = array2.length;

        if (N != M)
            return false;

        selectionSort(array1);
        selectionSort(array2);

        for (int i = 0; i < N; i++)
            if (array1[i] != array2[i])
                return false;

        return true;
    }



}
