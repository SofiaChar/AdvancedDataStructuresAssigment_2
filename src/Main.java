

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
        System.out.println("End of Exercise 1 ------------------------------------");

        System.out.println("Exercise 2 ------------------------------------");

        System.out.println("End of Exercise 2 ------------------------------------");

        System.out.println("Exercise 3 ------------------------------------");

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
