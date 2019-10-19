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
//        System.out.println("FirstIndex " + firstIndex);

        int lastIndex = (int) Math.ceil((upper * sizeOfArray)/100);
//        System.out.println("SecondIndex " + lastIndex);

        int [] result = new int[lastIndex-firstIndex];
        int count = 0;
        for (int i = firstIndex; i < lastIndex; i++) {
            result[count] = arr[i];
            count++;
        }

//        for (int i = 0; i < result.length; i++)
//            System.out.println("Result["+i+"]"+result[i]);

        return result;
    }

    public class HeapSort {

        public void sort(int array[]) {
            int N = array.length;

            // Build heap (rearrange array)
            for (int i = N / 2 - 1; i >= 0; i--)
                heapify(array, N, i);

            // One by one extract an element from heap
            for (int i = N - 1; i >= 0; i--) {
                // Move current root to end
                int temp = array[0];
                array[0] = array[i];
                array[i] = temp;

                // call max heapify on the reduced heap
                heapify(array, i, 0);
            }
        }

        void heapify(int array[], int size, int root) {
            int theBiggest = root; // Initialize largest as root
            int left = 2 * root + 1; // left = 2*root + 1
            int right = 2 * root + 2; // right = 2*root + 2

            // If left child is larger than root
            if (left < size && array[left] > array[theBiggest])
                theBiggest = left;

            // If right child is larger than largest so far
            if (right < size && array[right] > array[theBiggest])
                theBiggest = right;

            // If largest is not a root
            if (theBiggest != root) {
                int swap = array[root];
                array[root] = array[theBiggest];
                array[theBiggest] = swap;

                // Recursively heapify the affected sub-tree
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
