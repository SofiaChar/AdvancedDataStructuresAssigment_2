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
        System.out.printf("}");
    }

    @Override
    public A2Direction[] rotateRight() {
        A2Direction[] rotatedDirection = new A2Direction[size];
        for(int i = 0; i < rotatedDirection.length; i++) {
            if(direction[i] == A2Direction.LEFT) {
                rotatedDirection[i] = A2Direction.UP;
                System.out.print("UP ");
            }
            if(direction[i] == A2Direction.RIGHT) {
                rotatedDirection[i] = A2Direction.DOWN;
                System.out.print("DOWN ");
            }
            if(direction[i] == A2Direction.UP){
                rotatedDirection[i] = A2Direction.RIGHT;
                System.out.print("RIGHT ");
            }
            if(direction[i] == A2Direction.DOWN){
                rotatedDirection[i] = A2Direction.LEFT;
                System.out.print("LEFT ");
            }
        }
        return rotatedDirection;
    }

    @Override
    public int widthOfItinerary() {
        int xValue = 0;
        int rightX = 0;
        int leftX = 0;
        for(int i = 0; i < direction.length; i++) {
            if(direction[i] == A2Direction.LEFT) {
                xValue--;
                if(xValue < leftX) leftX = xValue;
            }
            if(direction[i] == A2Direction.RIGHT) {
                xValue++;
                if(xValue > rightX) rightX = xValue;
            }
        }
        return rightX - leftX;
    }

    @Override
    public int heightOfItinerary() {
        int yValue = 0;
        int rightY = 0;
        int leftY = 0;
        for(int i = 0; i < direction.length; i++) {
            if(direction[i] == A2Direction.DOWN) {
                yValue--;
                if(yValue < leftY) leftY = yValue;
            }
            if(direction[i] == A2Direction.UP) {
                yValue++;
                if(yValue > rightY) rightY = yValue;
            }
        }
        return rightY - leftY;
    }

    @Override
    public int[] getIntersections() {
        return new int[0];
    }

}
