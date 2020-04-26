public class Node {

    Students newStudent;
    Node leftChild;
    Node rightChild;

    public Node(Students newStudent) {
        this.newStudent = newStudent;
    }

    public Students getStudent() {
        return newStudent;
    }

    public int getSize() {
        int leftSize = 0;
        int rightSize = 0;

        if (leftChild != null) {
            leftSize = leftChild.getSize();
        }

        if (rightChild != null) {
            rightSize = rightChild.getSize();
        }

        return 1 + leftSize + rightSize;
    }

    public int getHeight() {
        int leftHeight = 0;
        int rightHeight = 0;

        if (leftChild != null) {
            leftHeight = leftChild.getHeight();
        }

        if (rightChild != null) {
            rightHeight = rightChild.getHeight();
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int getDepth(){
        int leftDepth = 0;
        int rightDepth = 0;

        if(leftChild != null){
            leftDepth = leftChild.getDepth();
        }

        if(rightChild != null){
            rightDepth = rightChild.getDepth():
        }

        return 1 + Math.max(leftDepth, rightDepth);
    }

    public String toString() {
        String studentinfo = newStudent.toString();

        return studentinfo;
    }
}