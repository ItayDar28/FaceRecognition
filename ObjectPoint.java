package hw5;

public class ObjectPoint implements ObjectWithCoordinates {// class which describe a single point in the space of the input object.
    //declaring variables
    private int x,y;
    private ObjectPoint data;
    private String name;

    //constructor

    public ObjectPoint(String name,int x, int y){
        this.x = x;
        this.y = y;
        this.name = name;
    }

    //getters - for private programming

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public ObjectPoint getData() {
        return data;
    }

    public String getName(){
        return name;
    }

    //repr the object by: | NAME X=000 Y=000 | as required.

    public String toString(){
        return  this.name + " X=" + String.valueOf(x) + " Y=" +String.valueOf(y);
    }
}
