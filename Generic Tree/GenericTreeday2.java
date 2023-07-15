import java.util.*;
import java.io.*;
public class GenericTreeday2 {
    
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

    public static void main(String[] args) {
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
            -1 };

        Node root = creatTree(arr);
        //traversal in GenericTree
        //LevelOrder of GenericTree
        //LevelOrder LineWise of GenericTree
        //LevelOrder LineWise ZigZag
        PreOrder(root);
        BFS(root);
        PrintAllLevelNodeUsingBFS(root);
        FindHeightUsingBFS(root);
        PrintInZigZagOrder(root);
    }

    //not sure whether this code is currect or not ..
    private static void PrintInZigZagOrder(Node root) {
        Queue<Node> q = new ArrayDeque<>() ;
        q.add(root);
        List<Node> lst = new ArrayList<>();
        while(q.size() > 0){
            
            for(int i = 0 ; i < q.size() ; i ++){
                Node curr = q.remove() ;
                lst.add(curr);
                for(Node child : root.childrens){
                    q.add(child);
                }
            }
            Collections.reverse(lst);
            for(Node node : lst){
                System.out.println(node);
            }
        }
    }

    private static void FindHeightUsingBFS(Node root) {
        Queue<Node> q = new ArrayDeque();
        q.add(root);
        int height = 0 ;
        while(q.size() > 0){
            //pop the front Node and push its children 
            for(int i = 0; i < q.size() ; i ++){
                Node curr = q.remove();
                System.out.println(curr.data);
                //push childrens ;
                for(Node child : curr.childrens){
                    q.add(child);
                }
            }
            height ++ ;
        }

        System.out.println(height - 1); // in terms of edge's
    }

    private static void PrintAllLevelNodeUsingBFS(Node root) {
        Queue<Node> q = new ArrayDeque();
        q.add(root);
        //do the work till then Queue become empty 
        while(q.size() > 0){
            //pop the front Node and push its children 
            for(int i = 0; i < q.size() ; i ++){
                Node curr = q.remove();
                System.out.println(curr.data);
                //push childrens ;
                for(Node child : curr.childrens){
                    q.add(child);
                }
            }
        }
    }

    private static void BFS(Node root) {
        Queue<Node> q = new ArrayDeque();

        q.add(root);
        
        //do the work till then Queue become empty 
        while(q.size() > 0){
            //pop the front Node and push its children 
            Node curr = q.remove();
            System.out.println(curr.data);

            //push childrens ;
            for(Node child : curr.childrens){
                q.add(child);
            }
        }

    }

    // for PreOrder the Time complexity is O(NumberOfNodes + NumberOfEdge's);
    // in other terms NumberOfEdges = NumberOfNodes - 1;
    //  O(NumberOfNodes + NumberOfNodes - 1) => O(2 * NumberOfNodes) ;
    // same as O(N) ;
    private static void PreOrder(Node root) {
        if(root == null) return ;
        System.out.println(root.data);
        for(Node child : root.childrens){
            PreOrder(child);
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
