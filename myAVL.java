package hw5;

public class myAVL {

    private AVLNode root;

    private AVL<ObjectPoint> avlX = new AVL<ObjectPoint>();//create an avl object for x's
    private AVL<ObjectPoint> avlY = new AVL<ObjectPoint>();//create an avl object for y's

    public myAVL(){
        this.avlX = avlX; //construct x point
        this.avlY = avlY;///construct y point
    }

    public void insert(ObjectPoint data){ // insert the same coordinate to both avl trees, each time with different leading var.
        avlX.insert(data.getX(),data);
        avlY.insert(data.getY(),data);
    }

    // get function for private vars
    public AVL<ObjectPoint> getAvlX(){
        return this.avlX;
    }

    public AVL<ObjectPoint> getAvlY(){
        return this.avlY;
    }

}
