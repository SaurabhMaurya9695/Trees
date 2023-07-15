import java.util.ArrayList;
import java.util.Stack;

public class Construction {
    public static class Node {
        int data;
        ArrayList<Node> childrens;

        Node(int val) {
            this.data = val;
            this.childrens = new ArrayList<>();
        }

        Node() {
            this.data = 0;
            this.childrens = null;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
            -1 };

        createTree(arr);
        
    }

    public static Node createTree(int[] arr) {
        Node root = null ;
        Stack<Node> stk = new Stack<>();

        // traverse on array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                // then we have to create a node then add in parent
                Node childrenNode = new Node(arr[i]);
                if (stk.size() == 0) {
                    root = childrenNode;
                } else {
                    // then add in its parent ;
                    Node parent = stk.peek();
                    parent.childrens.add(childrenNode);
                }

                stk.push(childrenNode);
            } else {
                // this is the end of euler ;
                stk.pop();
            }
        }

        return root;

    }
}
