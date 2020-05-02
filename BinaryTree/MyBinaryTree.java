public class MyBinaryTree {
    Node root;

    public void addNode(Students newStudent) {
        Node newNode = new Node(newStudent);

        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent = root;

            while (true) {
                parent = focusNode;

                if (newStudent.getID() < focusNode.getStudent().getID()) {
                    focusNode = focusNode.leftChild;

                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else if (newStudent.getID() == focusNode.getStudent().getID()) {
                    return;
                } else {
                    focusNode = focusNode.rightChild;

                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node findNode(int StudentID) {
        Node searchNode = root;

        while (StudentID != searchNode.getStudent().getID()) {

            if (StudentID < searchNode.getStudent().getID()) {
                searchNode = searchNode.leftChild;
            } else {
                searchNode = searchNode.rightChild;
            }

            if (searchNode == null) {
                return null;
            }
        }

        return searchNode;
    }

    public Node getReplacementNode(Node replacedNode) {
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;
        Node focusNode = replacedNode.rightChild;

        while (focusNode != null) {
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild;
        }

        while (replacement != replacedNode.rightChild) {
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }

        return replacement;
    }

    public boolean removeNode(int StudentID) {
        Node focusNode = root;
        Node parent = root;
        boolean isItALeftChild = true;

        while (StudentID != focusNode.getStudent().getID()) {
            parent = focusNode;

            if (StudentID < focusNode.getStudent().getID()) {
                focusNode = focusNode.leftChild;
            } else {
                isItALeftChild = false;
                focusNode = focusNode.rightChild;
            }

            if (focusNode == null) {
                return false;
            }
        }

        if (focusNode.leftChild == null && focusNode.rightChild == null) {
            if (focusNode == root) {
                root = null;
            } else if (isItALeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }

        else if (focusNode.leftChild == null) {
            if (focusNode == root) {
                root = focusNode.rightChild;
            } else if (isItALeftChild) {
                parent.leftChild = focusNode.rightChild;
            } else {
                parent.rightChild = focusNode.rightChild;
            }
        }

        else if (focusNode.rightChild == null) {
            if (focusNode == root) {
                root = focusNode.leftChild;
            } else if (isItALeftChild) {
                parent.leftChild = focusNode.leftChild;
            } else {
                parent.rightChild = focusNode.leftChild;
            }
        }

        else {
            Node replacement = getReplacementNode(focusNode);

            if (focusNode == root) {
                root = replacement;
            } else if (isItALeftChild) {
                parent.leftChild = replacement;
            } else {
                parent.rightChild = replacement;
            }

            replacement.leftChild = focusNode.leftChild;
        }

        return true;
    }

    public void inOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void preOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            preOrderTraverseTree(focusNode.leftChild);
            preOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void postOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }

    public int getSize() {
        if (root != null) {
            return root.getSize();
        }

        return 0;
    }

    public int getHeight() {
        if (root != null) {
            return root.getHeight() - 1;
        }

        return 0;
    }

    public int getDepth() {
        if (root != null) {
            return root.getDepth();
        }

        return 0;
    }
}