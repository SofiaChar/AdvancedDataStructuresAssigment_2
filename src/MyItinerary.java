public class MyItinerary implements A2Itinerary<A2Direction> {

    private A2Direction[] direction;
    private int size;

    public MyItinerary(A2Direction[] inputDirections){
        direction = inputDirections;
        size = direction.length;
    }

    public void outputDirection() {
        for(int i = 0; i < size; i++) {
            if(direction[i] == A2Direction.RIGHT)
                System.out.print("RIGHT ");
            if(direction[i] == A2Direction.LEFT)
                System.out.print("LEFT ");
            if(direction[i] == A2Direction.UP)
                System.out.print("UP ");
            if(direction[i] == A2Direction.DOWN)
                System.out.print("DOWN ");
        }
    }

    @Override
    public A2Direction[] rotateRight() {
        A2Direction[] rotatedDirection = new A2Direction[size];
        for(int i = 0; i < size; i++) {
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
        for(int i = 0; i < size; i++) {
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
        for(int i = 0; i < size; i++) {
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
        Coordinates current = new Coordinates();
        current.xVal = 0;
        current.yVal = 0;

        int[] result = new int[size];

        MyHashTable<Coordinates> coords = new MyHashTable<>(0.75);
//        Coordinates smth = new Coordinates();

//        smth.xVal = 0;
//        smth.yVal = 0;
        Coordinates[] way = new Coordinates[size];

        for(int i = 0; i < size; i++) {
            if (direction[i] == A2Direction.RIGHT)
                current.xVal++;
            if (direction[i] == A2Direction.LEFT)
                current.xVal--;
            if (direction[i] == A2Direction.UP)
                current.yVal++;
            if (direction[i] == A2Direction.DOWN)
                current.yVal--;
            Coordinates tmp = new Coordinates();
            tmp.xVal = current.xVal;
            tmp.yVal = current.yVal;
            way[i] = tmp;
        }

        int count = 0;
//        coords.insert(smth);
        for(int i = 0; i < size; i++) {
            if(coords.contains(way[i])) {
                result[count] = i;
                count++;
            }
            else {
                coords.insert(way[i]);
            }
        }

        int[] finalans = new int[count];
        for(int i = 0; i < count; ++i) {
            System.out.print(result[i] + " ");
            finalans[i] = result[i];
        }

        return finalans;
    }


    public class Coordinates {

        public int xVal;
        public int yVal;


        @Override
        public int hashCode() {
            return Math.abs(2 * xVal + yVal * yVal + 5);
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null || !(obj instanceof Coordinates))
                return false;

            if(obj == this)
                return true;

            Coordinates tObj = (Coordinates) obj;

            return this.xVal == tObj.xVal && this.yVal == tObj.yVal;
        }
    }

}

