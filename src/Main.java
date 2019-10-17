

public class Main {
    public static void main(String[] args) {
//        MyHashTable hashTable = new MyHashTable(0.5);
//        hashTable.insert(1);
//        hashTable.insert(3);
//        hashTable.insert(5);
//        hashTable.insert(6);
//        hashTable.insert(7);
//        hashTable.insert(12);
//        hashTable.insert(13);
//        hashTable.delete(12);

        MyItinerary it = new MyItinerary();
        it.addDirection('L');
        it.addDirection('R');
        it.addDirection('R');
        it.addDirection('D');
        it.addDirection('U');
        it.print();
    }
}
