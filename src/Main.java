

public class Main {
    private static A2Direction[] array;
    private static A2Itinerary<A2Direction> itinerary;

    public static void main(String[] args) {

//        System.out.println("Exercise 1 ------------------------------------");
//        MyHashTable hashTable = new MyHashTable(0.5);
//        hashTable.insert(1);
//        hashTable.insert(3);
//        hashTable.insert(5);
//        hashTable.insert(6);
//        hashTable.insert(7);
//        hashTable.insert(12);
//        hashTable.insert(13);
//        hashTable.delete(12);


        System.out.println("\n\nExercise 2 ------------------------------------");
        array = new A2Direction[10];
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

        itinerary = new MyItinerary(array);

        ((MyItinerary) itinerary).outputDirection();

        int tmp = itinerary.widthOfItinerary();
        System.out.println("\nThe width of Iterary is " + tmp);

        tmp = itinerary.heightOfItinerary();
        System.out.println("The height of Iterary is " + tmp);

        System.out.print("Right rotated direction is: ");
        itinerary.rotateRight();
        System.out.print("\nGet intersections: ");
        itinerary.getIntersections();


        System.out.println("\n\nExercise 3 ------------------------------------");

//        A2Measure measure = new MyMeasure();
//
//        int array1[] = { 3, 2, 5, 2, 5, 77, 8 };
//        int array2[] = { 2, 3, 5, 5, 2, 8, 77 };
//
//        if (measure.isSameCollection(array1, array2))
//            System.out.println("Yes");
//        else
//            System.out.println("No");




        System.out.println("End of Exercise 3 ------------------------------------");


    }
}


