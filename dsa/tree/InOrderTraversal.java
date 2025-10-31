import java.util.Queue;

class Node {
    int val;
    Node left, right;

    public Node(int item) {
        val = item;
        left = right = null;
    }
}

public class InOrderTraversal {

    Queue<Integer> result = new java.util.LinkedList<>();

    public int[] solution(Node node) {

        if (node.left != null) {
            solution(node.left);
        }

        this.result.add(node.val);
        if (node.right != null) {
            solution(node.right);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        InOrderTraversal obj = new InOrderTraversal();
        Node root = new Node(1);
        root.left = new Node(6);
        root.right = new Node(2);
        root.right.left = new Node(3);
        int[] res = obj.solution(root);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}