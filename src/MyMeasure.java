public class MyMeasure implements A2Measure {

    @Override
    public boolean isSameCollection(int[] array1, int[] array2) {
        int sizeOfArray1 = array1.length;
        int sizeOfArray2 = array2.length;

        if (sizeOfArray1 != sizeOfArray2)
            return false;
        else {
            HeapSort obj = new HeapSort();
            obj.sort(array1);
            obj.sort(array2);
            System.out.print("Sorted array1: ");
            obj.printArray(array1);
            System.out.print("Sorted array2: ");
            obj.printArray(array2);

            for (int i = 0; i < sizeOfArray1; i++)
                if (array1[i] != array2[i])
                    return false;
        }
        return true;
    }

    @Override
    public int minDifferences(int[] array1, int[] array2) {
        int sizeOfArray1 = array1.length;
        int sizeOfArray2 = array2.length;

        if (sizeOfArray1 != sizeOfArray2){
            System.out.println("\nError minDifferences! Should be same size arrays");
            return -1;
        }
        HeapSort obj = new HeapSort();
        obj.sort(array1);
        obj.sort(array2);

        int squaredDiff = 0;
        for (int i = 0; i < sizeOfArray1; i++)
            squaredDiff += Math.pow((array2[i]-array1[i]), 2);

        return squaredDiff;
    }

    @Override
    public int[] getPercentileRange(int[] arr, int lower, int upper) {
        int sizeOfArray = arr.length;

        HeapSort obj = new HeapSort();

        obj.sort(arr);
        System.out.print("Sorted arr: ");
        obj.printArray(arr);

        int firstIndex =  (int) Math.floor((lower * sizeOfArray)/100);

        int lastIndex = (int) Math.ceil((upper * sizeOfArray)/100);

        int [] result = new int[lastIndex-firstIndex];
        int count = 0;
        for (int i = firstIndex; i < lastIndex; i++) {
            result[count] = arr[i];
            count++;
        }

        return result;
    }

    public class HeapSort {

        public void sort(int array[]) {
            int size = array.length;

            for (int i = size / 2 - 1; i >= 0; i--)
                heapify(array, size, i);

            for (int i = size - 1; i >= 0; i--) {
                int temp = array[0];
                array[0] = array[i];
                array[i] = temp;

                heapify(array, i, 0);
            }
        }

        void heapify(int array[], int size, int root) {
            int theBiggest = root;
            int left = 2 * root + 1;
            int right = 2 * root + 2;

            if (left < size && array[left] > array[theBiggest])
                theBiggest = left;

            if (right < size && array[right] > array[theBiggest])
                theBiggest = right;

            if (theBiggest != root) {
                int swap = array[root];
                array[root] = array[theBiggest];
                array[theBiggest] = swap;

                heapify(array, size, theBiggest);
            }
        }

        void printArray(int array[]) {
            int size = array.length;
            for (int i = 0; i < size; i++)
                System.out.print(array[i] + " ");
            System.out.println();
        }
    }


}
