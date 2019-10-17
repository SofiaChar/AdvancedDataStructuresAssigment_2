public class MyHashTable<AnyType> implements A2HashTable <AnyType>{

    public double maxLoadFactor;
    public int M; //size of the table
    public int N; //number of elements in the table
    public AnyType[] theTable;
    public int[] cellsStatus; // 0 is empty; 1 is reserved; -1 is deleted

    public MyHashTable (double loadFactor){
        maxLoadFactor = loadFactor;
        setHashTable();
    }

    public void setHashTable(){
        theTable = (AnyType[])new Object[5];
        M = 5;
        N = 0;
        cellsStatus = new int[M];
        for(int i = 0; i < M; i++){
            cellsStatus[i] = 0;
            System.out.println(cellsStatus[i]);}
    }

    @Override
    public void insert(AnyType element) {
        int hash = element.hashCode();
        for(int i = 0; i < M; i++) {
            if(theTable[(hash + i * i) % M] == null) {
                N++;
                theTable[(hash + i * i) % M] = element;
                cellsStatus[(hash + i * i) % M] = 1;
                if((double)N / M > maxLoadFactor)
                    rehash();
                showTableInfo();
                return;
            }
        }

        rehash();
        insert(element);
        return;
    }

    private void rehash() {
        System.out.println("\nREHASHING");
        N = 0;
        M *= 2;
        M = nextPrime(M);
        AnyType[] rehashedTable = (AnyType[]) new Object[M];
        AnyType[] tempTable = theTable;
        theTable = rehashedTable;
        rehashedTable = tempTable;

        cellsStatus = new int[M];
        for(int i = 0; i < M; i++)
            cellsStatus[i] = 0;

        //WARNING REFACTOR THIS!!!!!!!-------------------------------

        for(int i = 0; i < rehashedTable.length; i++) {
            if(rehashedTable[i] != null)
                this.insert(rehashedTable[i]);
        }
        showTableInfo();
    }

    private void showTableInfo(){
        System.out.println("\n\nThe length of the table is " + M);
        System.out.println("The number of elements is " + N);
        System.out.println("The load factor is " + (double)N/M);
        System.out.print("Here are all of the elements ");
        for(int i = 0; i < theTable.length; i++) {
            if (cellsStatus[i] == 1)
                System.out.print(" "+ theTable[i]);
        }
    }

    @Override
    public void delete(Object element) {
        int hash = element.hashCode();
        for(int i = 0; i < M; i++) {
            if(theTable[(hash + i * i) % M].equals(element)) {
                N--;
                cellsStatus[(hash + i * i) % M] = -1;
                theTable[(hash + i * i) % M] = null;
                return;
            }
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
    public boolean contains(Object element) {
        int hash = element.hashCode();
        for(int i = 0; i < M; i++) {
            if(theTable[(hash + i * i) % M].equals(element))
                return true;
        }
        return false;
    }

    @Override
    public int getLengthOfArray() {
        return M;
    }
}
