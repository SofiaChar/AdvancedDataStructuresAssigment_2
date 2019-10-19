

public class Main {

    public static void main(String[] args) {

        System.out.print("Exercise 1 ------------------------------------");
        MyHashTable hashTable = new MyHashTable(0.5);
        hashTable.insert(1);
        hashTable.showTableInfo();
        hashTable.insert(3);
        hashTable.showTableInfo();
        hashTable.insert(5);
        hashTable.showTableInfo();
        hashTable.insert(6);
        hashTable.showTableInfo();
        hashTable.insert(7);
        hashTable.showTableInfo();
        hashTable.insert(12);
        hashTable.showTableInfo();
        hashTable.insert(13);
        hashTable.showTableInfo();
        hashTable.delete(12);
        hashTable.showTableInfo();

        if(hashTable.contains(11))
            System.out.print("\n*Contains");
        else
            System.out.print("\n*Does not Contain");


        System.out.println("\n\nExercise 2 ------------------------------------");
        A2Direction[] array = new A2Direction[10];
        array[0] = A2Direction.LEFT;
        array[1] = A2Direction.DOWN;
        array[2] = A2Direction.RIGHT;
        array[3] = A2Direction.DOWN;
        array[4] = A2Direction.LEFT;
        array[5] = A2Direction.UP;
        array[6] = A2Direction.LEFT;
        array[7] = A2Direction.UP;
        array[8] = A2Direction.RIGHT;
        array[9] = A2Direction.UP;

        A2Itinerary<A2Direction> itinerary = new MyItinerary(array);

        ((MyItinerary) itinerary).outputDirection();

        int tmp = itinerary.widthOfItinerary();
        System.out.println("\n*The width of Iterary is " + tmp);

        tmp = itinerary.heightOfItinerary();
        System.out.println("*The height of Iterary is " + tmp);

        System.out.print("*Right rotated direction is: ");
        itinerary.rotateRight();
        System.out.print("\nGet intersections: ");
        itinerary.getIntersections();


        System.out.println("\n\nExercise 3 ------------------------------------");

        A2Measure measure = new MyMeasure();

        int array1[] = {2,5,3,9};
        int array2[] = {15,12,1,3};
        int arr[] = {20, 16, 2, 4, 10, 6, 12, 8, 14, 18, 25};

        if (measure.isSameCollection(array1, array2))
        System.out.println("*Yes");
        else
            System.out.println("*No");

        System.out.println("*The squared sum of the differences is " + measure.minDifferences(array1,array2));

        int temp[] = measure.getPercentileRange(arr, 0, 25);
        System.out.print("*The Percentile Range is ");
        for (int i=0; i< temp.length; i++)
            System.out.print(temp[i] + " ");
    }
}


