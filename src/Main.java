

public class Main {
    public static void main(String[] args) {

        System.out.println("Exercise 1 ------------------------------------");
        MyHashTable hashTable = new MyHashTable(0.5);
        hashTable.insert(1);
        hashTable.insert(3);
        hashTable.insert(5);
        hashTable.insert(6);
        hashTable.insert(7);
        hashTable.insert(12);
        hashTable.insert(13);
        hashTable.delete(12);


        System.out.println("\n\nExercise 2 ------------------------------------");

        MyItinerary it = new MyItinerary();
        it.addDirection('L');
        it.addDirection('D');
        it.addDirection('D');
        it.addDirection('R');
        it.addDirection('U');
        it.addDirection('L');
        it.print();
        int tmp = it.widthOfItinerary();
        System.out.println("\nThe width of Iterary is " + tmp);
        tmp = it.heightOfItinerary();
        System.out.println("The height of Iterary is " + tmp);



        System.out.println("\nExercise 3 ------------------------------------");

        MyMeasure measure = new MyMeasure();
        int array1[] = { 3, 5, 2, 5, 2 };
        int array2[] = { 2, 3, 5, 5, 2 };

        if (measure.isSameCollection(array1, array2))
            System.out.println("Yes");
        else
            System.out.println("No");


        System.out.println("End of Exercise 3 ------------------------------------");


    }
}
