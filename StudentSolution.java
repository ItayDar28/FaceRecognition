package hw5;

import java.util.ArrayList;
import java.util.List;

public class StudentSolution  implements MyInterface {

    private myAVL tree = new myAVL();

    public myAVL getTree() {
        return tree;
    }

    public int getLeader(ObjectPoint object, String s){
        if (s == "y")
            return object.getY();
        else
            return object.getX();
    }

    @Override
    public void insertDataFromDBFile(String objectName, int objectX, int objectY) {
        ObjectPoint temp = new ObjectPoint(objectName, objectX, objectY);
        tree.insert(temp);
    }

    @Override
    public String[] firstSolution(int leftTopX, int leftTopY, int rightBottomX,
                                  int rightBottomY) {

        HashTable table = new HashTable(11); //new hash in capacity 11

        ArrayList<ObjectPoint> arr1 = getTree().getAvlX().range(leftTopX, rightBottomX); //open a new array of the points x in avl
        ArrayList<ObjectPoint> arr2 = getTree().getAvlY().range(leftTopY, rightBottomY); //open a new array of the points x in avl

        for (int i = 0; i < arr1.size(); i++) {
            table.insert(arr1.get(i)); //insert for the hash the points inside the square
        }

        // 2(log(n) + m1 + m2) = O(log(n) + m1 + m2)

        String[] arr = new String[Math.min(arr1.size(), arr2.size())];//new array of in size of the min between arr1,arr2
        int j = 0;
        for (int i = 0; i < arr2.size(); i++) { //find which points in array x compatible to y
            if (table.search(arr2.get(i).getX(), arr2.get(i).getY()) != null) {
                arr[j] = arr2.get(i).toString();
                j++;
            }
        }
        return arr;
    }

    @Override
    public String[] secondSolution(int leftTopX, int leftTopY,
                                   int rightBottomX, int rightBottomY) {

        ArrayList<ObjectPoint> arrX = getTree().getAvlX().range(leftTopX,rightBottomX); //create array that contains the output of range function.
        ArrayList<ObjectPoint> arrY = getTree().getAvlY().range(leftTopY,rightBottomY);// - " " -               - " " -

        int i = 0;
        int j = 0;

        int temp = Math.min(arrX.size(),arrY.size()); // temporary


        List<ObjectPoint> arrMin = temp == arrX.size() ? arrX : arrY;
        String[] arrFinal = new String[arrMin.size()];

        String leadingMaxVar = arrMin == arrX ? "y" : "x";

        while (i < arrMin.size()){
            List<ObjectPoint> arrMax = temp != arrX.size() ? arrX : arrY;
            while (arrMax.size() > 1){
                // 3 conditions : if point.x < pointBigArray.x - take the left size, if point.x > pointBigArray.x - take the right side, if == - add to list.
                int holder = (arrMax.size()/2);

                String tmp1 = (arrMin.get(i).getName());
                String tmp2 = (arrMax.get(holder).getName());

                if (getLeader(arrMin.get(i),leadingMaxVar) < getLeader(arrMax.get(holder),leadingMaxVar)) {
                    arrMax = arrMax.subList(0,holder);
                    continue;
                }
                else if (getLeader(arrMin.get(i),leadingMaxVar) > getLeader(arrMax.get(holder),leadingMaxVar)) {
                    arrMax = arrMax.subList(holder+1,arrMax.size());
                    continue;
                }
                else if (getLeader(arrMin.get(i),leadingMaxVar) == getLeader(arrMax.get(holder),leadingMaxVar)) {
                    arrFinal[j] = (arrMin.get(i).toString());
                    j++;
                    break;
                }
            }
            if (arrMax.size() == 1 && getLeader(arrMin.get(i),leadingMaxVar) == getLeader(arrMax.get(0),leadingMaxVar)){
                arrFinal[j] = (arrMin.get(i).toString());
                j++;
                i++;
            }else {
                i++;
            }
        }
        return arrFinal;
    }
}
