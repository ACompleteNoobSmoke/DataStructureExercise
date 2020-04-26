public class MyBinaryTree {

    Node root;

    public void addNode(Students newStudent) {
        Node newNode = new Node(newStudent);

        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;

            while (true) {
                parent = focusNode;

                if (newStudent.getGradePercentage() < focusNode.getStudent().getGradePercentage()) {
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

    public Node findNode(int id) {
        Node searchNode = root;

        while (id != searchNode.getStudent().getID()) {
            if (id < searchNode.getStudent().getID()) {
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

        if (replacement != replacedNode.rightChild) {
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }

        return replacement;

    }

    public boolean removeNode(int id) {
        Node focusNode = root;
        Node parent = root;
        boolean isItALeftChild = true;

        while (id != focusNode.getStudent().getID()) {
            parent = focusNode;

            if (id < focusNode.getStudent().getID()) {
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
                parent.rightChild = focusNode.rightChild;
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

    public void inOrderTreeTraversal(Node focusNode) {
        if (focusNode != null) {
            inOrderTreeTraversal(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTreeTraversal(focusNode.rightChild);
        }
    }

    public void preOrderTreeTraversal(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            preOrderTreeTraversal(focusNode.leftChild);
            preOrderTreeTraversal(focusNode.righChild);
        }
    }

    public void postOrderTreeTraversal(Node focusNode) {
        if (focusNode != null) {
            postOrderTreeTraversal(focusNode.leftChild);
            postOrderTreeTraversal(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }

    public void reverseOrderTreeTraversal(Node focusNode) {
        if (focusNode != null) {
            reverseOrderTreeTraversal(focusNode.rightChild);
            System.out.println(focusNode);
            reverseOrderTreeTraversal(focusNode.leftChild);
        }
    }

    public int getTreeSize() {
        if (root == null) {
            return 0;
        }

        return root.getSize();
    }

    public int getTreeHeight() {
        if (root == null) {
            return 0;
        }

        return root.getHeight() - 1;
    }

    public int getTreeDepth() {
        if (root == null) {
            return 0;
        }

        return root.getDepth();
    }
}
