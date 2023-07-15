import java.util.*;
import java.io.*;

public class GenericTree {

    // construction of Generic Tree class ;
    private static class Node {
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

    public static void main() {
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };

        Node tree = creatTree(arr);
        display(tree);
        size(tree);
        maxOfWholeTree(tree);
        int depth = MaxDepth(tree);
        System.out.println(depth);
        traversal(tree);
    }

    private static void traversal(Node root) {
        // node pre
        // edge pre
        // node post
        // edge post
        if(root == null) return ;

        System.out.println("node pre" + root.data );
        for(Node child : root.childrens){
            
            System.out.println("edge pre" + root.data + "child val" + child.data );
            traversal(child);
            System.out.println("edge post" + root.data  + "child val" + child.data);
        }
        System.out.println("node post" + root.data );
    }

    private static int MaxDepth(Node root) {
        if (root == null)
            return 1;
        int depth = 0;
        for (Node child : root.childrens) {
            depth = Math.max(depth, MaxDepth(child));
        }

        return depth + 1;
    }

    private static int maxOfWholeTree(Node root) {
        if (root == null)
            return root.data;

        // now except from childrens ..apne neeche wale subtree se max lekar aao or usme
        // se
        // jo max hoga ussey hum compare kr lengy aapne aap ko .. or jo max hoga wahi
        // ans hoga
        int ans = root.data;
        for (Node child : root.childrens) {
            ans = Math.max(ans, child.data);
            maxOfWholeTree(child);
        }

        return ans;
    }

    private static int size(Node root) {
        if (root == null)
            return 0;
        int cnt = 1; // add 1 for self node
        for (Node child : root.childrens) {
            cnt += size(child); // make faith on childrens
        }

        return cnt;

    }

    private static void display(Node node) {
        if (node == null)
            return;
        System.out.println(node.data);
        for (Node child : node.childrens) {
            display(child);
        }

    }

    private static Node creatTree(int[] arr) {
        Node root = null;
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