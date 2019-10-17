public class MyItinerary implements A2Itinerary<A2Direction> {

    A2Direction[] direction;
    int size;

    public MyItinerary(){
        size = 0;
        direction = new A2Direction[50];
    }

    public void addDirection(char d){
        if (d == 'L') direction[size] = A2Direction.LEFT;
        if (d == 'R') direction[size] = A2Direction.RIGHT;
        if (d == 'U') direction[size] = A2Direction.UP;
        if (d == 'D') direction[size] = A2Direction.DOWN;
        size++;
    }

    void print()
    {
        System.out.printf("{");
        for(int i = 0; i < direction.length; ++i)
        {
            if(direction[i] == A2Direction.RIGHT)
                System.out.printf("RIGHT,");
            if(direction[i] == A2Direction.LEFT)
                System.out.printf("LEFT,");
            if(direction[i] == A2Direction.UP)
                System.out.printf("UP,");
            if(direction[i] == A2Direction.DOWN)
                System.out.printf("DOWN,");
        }
    }

    @Override
    public A2Direction[] rotateRight() {
        return new A2Direction[0];
    }

    @Override
    public int widthOfItinerary() {
        return 0;
    }

    @Override
    public int heightOfItinerary() {
        return 0;
    }

    @Override
    public int[] getIntersections() {
        return new int[0];
    }


}
