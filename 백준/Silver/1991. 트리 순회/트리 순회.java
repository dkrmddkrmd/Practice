import java.util.*;
import java.io.*;

class Tree{
     String name;
     Tree left;
     Tree right;

    public Tree(String name) {
        this.name = name;
    }
}

public class Main{
    static StringBuilder stringBuilder;

    static void preOrder(Tree tree){
        if(tree == null)
            return;
        stringBuilder.append(tree.name);
        preOrder(tree.left);
        preOrder(tree.right);
    }
    static void inOrder(Tree tree){
        if(tree == null)
            return;
        inOrder(tree.left);
        stringBuilder.append(tree.name);
        inOrder(tree.right);
    }
    static void postOrder(Tree tree){
        if(tree == null)
            return;
        postOrder(tree.left);
        postOrder(tree.right);
        stringBuilder.append(tree.name);
    }

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Map<String, Tree> trees = new HashMap<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            String now = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            //trees.computeIfAbsent(now, new Tree());
            trees.computeIfAbsent(now, Tree::new);
            Tree nowTree = trees.get(now);
            if(!Objects.equals(left, ".")){
                trees.computeIfAbsent(left, Tree::new);
                nowTree.left = trees.get(left);
            }
            if(!Objects.equals(right, ".")){
                trees.computeIfAbsent(right, Tree::new);
                nowTree.right = trees.get(right);
            }
        }

        stringBuilder = new StringBuilder();

        Tree root = trees.get("A");

        preOrder(root);
        stringBuilder.append("\n");
        inOrder(root);
        stringBuilder.append("\n");
        postOrder(root);
        System.out.println(stringBuilder);
    }
}