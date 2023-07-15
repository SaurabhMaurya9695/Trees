
import java.util.*;
public class GenericTreeday3 {
    
    static int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
        -1 };
    
    public static void main(String[] args) {
        Construction.Node node = Construction.createTree(arr);
        MirrorOfGenerictree(node);
        LinerizeGenericTree(node);
    }

    
    private static void LinerizeGenericTree(Construction.Node node) {
        List<Construction.Node> ls = new ArrayList<>() ;
        if(node == null) {
            Construction.Node x = new Construction.Node();
            ls.add(x);
            return ;
        }
        
        ls.add(node);
        
        for(Construction.Node child : node.childrens){
            LinerizeGenericTree(child);

        }

    }

    private static void MirrorOfGenerictree(Construction.Node node) {
        // faith : apne children ki list ko reverse krna hai ..
        // expectation : children reverse hokar aayengy 

    }
    
}


