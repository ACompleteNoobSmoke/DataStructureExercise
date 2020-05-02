public class Node {
    Node rightChild;
    Node leftChild;
    Students newStudent;

    public Node(Students newStudent) {
        this.newStudent = newStudent;
    }

    public Students getStudent() {
        return newStudent;
    }

    public String toString() {
        return "Name: " + newStudent.getName() + "\n" + "ID#: " + newStudent.getID() + "\n" + "Major: "
                + newStudent.getMajor() + "\n" + "Grade(%): " + newStudent.getGradePercentage() + "\n"
                + "Grade(A - F): " + newStudent.getGradeLetter() + "\n" + "Status: " + newStudent.getGradeStatus()
                + "\n\n";
    }

    public int getSize() {
        int left = 0;
        int right = 0;

        if (leftChild != null) {
            left = leftChild.getSize();
        }

        if (rightChild != null) {
            right = rightChild.getSize();
        }

        return 1 + left + right;
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

    public int getDepth() {
        int leftDepth = 0;
        int rightDepth = 0;

        if (leftChild != null) {
            leftDepth = leftChild.getDepth();
        }

        if (rightChild != null) {
            rightDepth = rightChild.getDepth();
        }

        return 1 + Math.max(leftDepth, rightDepth);
    }
}