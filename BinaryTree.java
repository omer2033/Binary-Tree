package Tree;
public class BinaryTree {
    Node root = null;
    BinaryTree(){

    }
    class Node{
        Node left;
        Node right;
        Integer data;

        Node(Integer value){
            this.left = null;
            this.right = null;
            this.data = value;
        }
    }
    public void insert(Integer value){
            Node newNode = new Node(value);
            //If tree is empty
            if(root == null){
                root = newNode;
            }
            else {
                Node currentNode = root;
                while (true){
                    if(value< currentNode.data){
                        //Left
                        if(currentNode.left == null){
                            currentNode.left = newNode;
                            return;
                        }
                        currentNode = currentNode.left;
                    }
                    else {
                        //Right
                        if(currentNode.right == null){
                            currentNode.right = newNode;
                            return;
                        }
                        currentNode = currentNode.right;}}}}

        public void lookUp(Integer target){
        if(root == null){
            System.out.println("Tree is empty");
            return;
        }
        Node currentNode = root;
        while (currentNode !=null){
            if(target < currentNode.data){
                currentNode = currentNode.left;
            }
            else if(target> currentNode.data){
                currentNode = currentNode.right;
            }
            else if(target == currentNode.data){
                System.out.println(target+" is found out in Binary Tree.");
                return;
            }
        }
            System.out.println(target+ " is not found out in Binary Tree.");
        }

        public void remove(Integer target){
        if(root == null){
            System.out.println("Tree is empty!");
            return;
        }
        Node currentNode = root;
        Node parentNode = null;
        while (currentNode!= null){
            if (target < currentNode.data){
                parentNode = currentNode;
                currentNode = currentNode.left;
            }
            else if (target > currentNode.data){
                parentNode = currentNode;
                currentNode = currentNode.right;
            }
            else if(currentNode.data == target){
                //We have match
                //Option 1 No right child:
                if(currentNode.right == null){
                    if(parentNode == null){
                        root = currentNode.left;
                    }else {
                        //if parent > current value, make current left child a child of parent
                        if(currentNode.data < parentNode.data){
                            parentNode.left = currentNode.left;
                        }
                        else if(currentNode.data > parentNode.data){
                            parentNode.right = currentNode.left;
                        }
                    }
                }
                else if(currentNode.right.left == null){
                    if(parentNode == null){
                        root = currentNode.left;
                    }
                    else {
                        currentNode.right.left = currentNode.left;
                        // if parent > current, make right child of the left THE parent
                        if(currentNode.data < parentNode.data){
                            parentNode.left = currentNode.right;

                            //if parent < current, make right child a right child of the parent
                        }
                        else if(currentNode.data > parentNode.data){
                            parentNode.right = currentNode.right;
                        }
                    }
                }
                //OPTION 3 RIGHT CHILD THAT HAS A LEFT CHILD
                else {
                //find the right child's left most child
                    Node leftmost = currentNode.right.left;
                    Node leftmostParent = currentNode.right;
                    while (leftmost.left != null){
                        leftmostParent = leftmost;
                        leftmost = leftmost.left;
                    }
                    //Parents left subtree is not leftmost's right subtree
                    leftmostParent.left = leftmost.right;
                    leftmost.left = currentNode.left;
                    leftmost.right = currentNode.right;
                    if (parentNode ==null){
                        root = leftmost;
                    }
                    else {
                        if(currentNode.data < parentNode.data){
                            parentNode.left = leftmost;
                        }
                        else if(currentNode.data>parentNode.data){
                            parentNode.right = leftmost;
                        }
                    }
                }
                return;
            }

        }

        }

    public static void main(String[] args) {
        BinaryTree bnt = new BinaryTree();
        bnt.insert(45);
        bnt.insert(10);
        bnt.insert(7);
        bnt.insert(12);
        bnt.insert(90);
        bnt.insert(50);
        bnt.lookUp(7);
        bnt.lookUp(0);
        bnt.remove(5);
        bnt.lookUp(5);
    }
    }



