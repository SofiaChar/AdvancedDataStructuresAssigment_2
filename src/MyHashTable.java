public class MyHashTable<AnyType> implements A2HashTable <AnyType>{

    public double maxLoadFactor;
    public int m; //size of the table
    public int n; //number of elements in the table
    public AnyType[] hashTable;
    public int[] cellsStatus; // 0 is empty; 1 is reserved; -1 is deleted

    public MyHashTable (double loadFactor){
        maxLoadFactor = loadFactor;
        setHashTable();
    }

    public void setHashTable(){
        hashTable = (AnyType[])new Object[10];
        m = 10;
        n = 0;
        cellsStatus = new int[m];
        for(int i = 0; i < m; i++)
            cellsStatus[i] = 0;
    }

    private void rehash() {

        System.out.println("\nREHASHING");
        n = 0;
        m *= 2;
        m = nextPrime(m);
        AnyType[] rehashedTable = (AnyType[]) new Object[m];
        AnyType[] tempTable = hashTable;
        hashTable = rehashedTable;
        rehashedTable = tempTable;

        cellsStatus = new int[m];

        for(int i = 0; i < m; i++)
            cellsStatus[i] = 0;

        for(int i = 0; i < rehashedTable.length; i++) {
            if(rehashedTable[i] != null)
                this.insert(rehashedTable[i]);
        }
//        showTableInfo();
    }

    private void showTableInfo(){
        System.out.println("\n\nThe length of the table is " + m);
        System.out.println("The number of elements is " + n);
        System.out.println("The load factor is " + (double) n / m);
        System.out.print("Here are all of the elements ");
        for(int i = 0; i < hashTable.length; i++) {
            if (cellsStatus[i] == 1)
                System.out.print(" "+ hashTable[i]);
        }
    }

    private static int nextPrime(int n) {
        if(n <= 0)
            n = 3;
        if(n % 2 == 0)
            n++;
        for( ; !isPrime( n ); n += 2)
            ;
        return n;
    }

    private static boolean isPrime(int n) {
        if(n == 2 || n == 3)
            return true;

        if(n == 1 || n % 2 == 0)
            return false;

        for(int i = 3; i * i <= n; i += 2)
            if(n % i == 0)
                return false;
        return true;
    }

    @Override
    public void insert(AnyType element) {
        int hash = element.hashCode();
        for(int i = 0; i < m; i++) {
            if(hashTable[(hash + i * i) % m] == null) {
                n++;
                showTableInfo();
                hashTable[(hash + i * i) % m] = element;
                cellsStatus[(hash + i * i) % m] = 1;
                if((double) n / m > maxLoadFactor)
                    rehash();
//                showTableInfo();
                return;
            }
        }
        rehash();
        insert(element);
        return;
    }

    @Override
    public void delete(Object element) {
        int hash = element.hashCode();
        for(int i = 0; i < m; i++) {
            if(hashTable[(hash + i * i) % m].equals(element)) {
                n--;
                cellsStatus[(hash + i * i) % m] = -1;
                hashTable[(hash + i * i) % m] = null;
                return;
            }
        }
    }

    @Override
    public boolean contains(Object element) {
        int hash = element.hashCode();
        for(int i = 0; i < m; i++) {
            if(hashTable[(hash + i * i) % m].equals(element))
                return true;
        }
        return false;
    }

    @Override
    public int getLengthOfArray() {
        return m;
    }
}


//import java.lang.reflect.Array;
//
//public class MyHashTable <AnyType> implements A2HashTable <AnyType> {
//
//    public MyHashTable(Double mLambda)
//    {
//        table = (AnyType[])new Object[5];
//        lambda = mLambda;
//        size = 5;
//        elementCount = 0;
//        info = new char[size];
//        for(int i = 0; i < size; ++i)
//            info[i] = 'e';
//    }
//
//    @Override
//    public void insert(AnyType element) {
//        ++elementCount;
//        int hash = element.hashCode();
//        for(int i = 0; i < size; ++i)
//        {
//            if(table[(hash + i * i) % size] == null)
//            {
//                table[(hash + i * i) % size] = element;
//                info[(hash + i * i) % size] = 'b';
//                if(lambda * size < (double)elementCount)
//                {
//                    rehash();
//                }
//                return;
//            }
//        }
//
//        rehash();
//        insert(element);
//    }
//
//    @Override
//    public boolean contains(AnyType element) {
//        int hash = element.hashCode();
//        for(int i = 0; i < size; ++i)
//        {
//            if(info[(hash + i * i) % size] == 'e')
//                return false;
//
//            if(table[(hash + i * i) % size].equals(element))
//                return true;
//        }
//
//        return false;
//    }
//
//    @Override
//    public void delete(AnyType element) {
//        int hash = element.hashCode();
//        for(int i = 0; i < size; ++i)
//        {
//            if(table[(hash + i * i) % size].equals(element))
//            {
//                info[(hash + i * i) % size] = 'd';
//                table[(hash + i * i) % size] = null;
//                return;
//            }
//        }
//        System.out.println("Error deleting a non existing element");
//    }
//
//    @Override
//    public int getLengthOfArray() {
//        return size;
//    }
//
//    private boolean isPrime(int n)
//    {
//        for(int i = 2; i * i <= n; ++i)
//        {
//            if(n % i == 0)
//                return false;
//        }
//        return true;
//    }
//
//    private int getNextPrime(int n)
//    {
//        for(int i = n; ; i += 2)
//        {
//            if(isPrime(i)) {
//                return i;
//            }
//        }
//    }
//
//    private void rehash()
//    {
//        elementCount = 0;
//        size *= 2;
//        ++size;
//        size = getNextPrime(size);
//        AnyType[] newTable = (AnyType[]) new Object[size];
//        info = new char[size];
//        for(int i = 0; i < size; ++i)
//        {
//            info[i] = 'e';
//        }
//        AnyType[] tmp = table;
//        table = newTable;
//        newTable = tmp;
//
//        for(int i = 0; i < newTable.length; ++i)
//        {
//            if(newTable[i] != null)
//                this.insert(newTable[i]);
//        }
//
//    }
//
//    private double lambda;
//    private AnyType[] table;
//    private int size;
//    private int elementCount;
//    private char[] info;
//
//}
