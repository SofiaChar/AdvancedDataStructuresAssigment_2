public class MyHashTable<AnyType> implements A2HashTable <AnyType>{

    public double maxLoadFactor;
    public int tableLength; //size of the table
    public int numberOfElements; //number of elements in the table
    public AnyType[] hashTable;
    public int[] cellsStatus; // 0 is empty; 1 is reserved; -1 is deleted

    public MyHashTable (double loadFactor){
        maxLoadFactor = loadFactor;
        setHashTable();
    }

    public void setHashTable(){
        hashTable = (AnyType[])new Object[10];
        tableLength = 10;
        numberOfElements = 0;
        cellsStatus = new int[tableLength];
        for(int i = 0; i < tableLength; i++)
            cellsStatus[i] = 0;
    }

    private void rehash() {
        System.out.print("\n\nREHASHING");
        numberOfElements = 0;
        tableLength *= 2;
        tableLength = nextPrime(tableLength);
        AnyType[] rehashedTable = (AnyType[]) new Object[tableLength];
        AnyType[] tempTable = hashTable;
        hashTable = rehashedTable;
        rehashedTable = tempTable;

        cellsStatus = new int[tableLength];

        for(int i = 0; i < tableLength; i++)
            cellsStatus[i] = 0;

        for(int i = 0; i < rehashedTable.length; i++) {
            if(rehashedTable[i] != null)
                this.insert(rehashedTable[i]);
        }
    }

    public void showTableInfo(){
        System.out.println("\n\nThe length of the table is " + tableLength);
        System.out.println("The number of elements is " + numberOfElements);
        System.out.println("The load factor is " + (double) numberOfElements / tableLength);
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
        int hashCode = element.hashCode();
        for(int i = 0; i < tableLength; i++) {
            if(hashTable[(hashCode + i * i) % tableLength] == null) {
                numberOfElements++;
//                showTableInfo();
                hashTable[(hashCode + i * i) % tableLength] = element;
                cellsStatus[(hashCode + i * i) % tableLength] = 1;
                if((double) numberOfElements / tableLength > maxLoadFactor)
                    rehash();
                return;
            }
        }
        rehash();
        insert(element);
        return;
    }

    @Override
    public void delete(Object element) {
        int hashCode = element.hashCode();
        for(int i = 0; i < tableLength; i++) {
            if(hashTable[(hashCode + i * i) % tableLength].equals(element)) {
                numberOfElements--;
                cellsStatus[(hashCode + i * i) % tableLength] = -1;
                hashTable[(hashCode + i * i) % tableLength] = null;
                return;
            }
        }
    }

    @Override
    public boolean contains(Object element) {
        int hashCode = element.hashCode();
        for(int i = 0; i < tableLength; i++) {
            if(cellsStatus[(hashCode + i * i) % tableLength] == 0)
                return false;
            if(hashTable[(hashCode + i * i) % tableLength].equals(element))
                return true;
        }
        return false;
    }

    @Override
    public int getLengthOfArray() {
        return tableLength;
    }
}
