
public class MyMeasure implements A2Measure {

/*
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
*/

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

        // To heapify a subtree rooted with node i which is
        // an index in array[]. n is size of heap
        void heapify(int array[], int n, int i) {
            int largest = i; // Initialize largest as root
            int l = 2 * i + 1; // left = 2*i + 1
            int r = 2 * i + 2; // right = 2*i + 2

            // If left child is larger than root
            if (l < n && array[l] > array[largest])
                largest = l;

            // If right child is larger than largest so far
            if (r < n && array[r] > array[largest])
                largest = r;

            // If largest is not root
            if (largest != i) {
                int swap = array[i];
                array[i] = array[largest];
                array[largest] = swap;

                // Recursively heapify the affected sub-tree
                heapify(array, n, largest);
            }
        }


        void printArray(int array[]) {
            int n = array.length;
            for (int i = 0; i < n; ++i)
                System.out.print(array[i] + " ");
            System.out.println();
        }
    }

    @Override
    public boolean isSameCollection(int[] array1, int[] array2) {
        int N = array1.length;
        int M = array2.length;

        if (N != M)
            return false;
        else {
            HeapSort obj = new HeapSort();
            obj.sort(array1);
            obj.sort(array2);
            System.out.print("Sorted array1 ");
            obj.printArray(array1);
            System.out.print("\nSorted array2 ");
            obj.printArray(array2);

            for (int i = 0; i < N; i++)
                if (array1[i] != array2[i])
                    return false;
        }
        return true;
    }
}
