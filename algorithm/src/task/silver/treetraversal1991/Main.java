package task.silver.treetraversal1991;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N;
    static Node rootNode;
    static Map<String, Node> nodeMap;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        setTree();
        // 전위 순회
        sb = new StringBuilder();
        preOrder(rootNode);
        bw.write(sb.toString() + "\n");

        // 중위 순회
        sb = new StringBuilder();
        inOrder(rootNode);
        bw.write(sb.toString() + "\n");

        // 후위 순회
        sb = new StringBuilder();
        postOrder(rootNode);
        bw.write(sb.toString() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }


    private static void preOrder(Node startNode) {
        sb.append(startNode.value);
        if (startNode.left != null) {
            preOrder(startNode.left);
        }
        if (startNode.right != null) {
            preOrder(startNode.right);
        }
    }

    private static void inOrder(Node startNode) {
        if (startNode.left != null) {
            inOrder(startNode.left);
        }

        sb.append(startNode.value);

        if (startNode.right != null) {
            inOrder(startNode.right);
        }
    }
    private static void postOrder(Node startNode) {
        if (startNode.left != null) {
            postOrder(startNode.left);
        }
        if (startNode.right != null) {
            postOrder(startNode.right);
        }
        sb.append(startNode.value);
    }

    private static void setTree() throws IOException {
        nodeMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            if (i==0) {
                rootNode = new Node(st.nextToken());
                nodeMap.put(rootNode.value, rootNode);
                String left = st.nextToken();
                String right = st.nextToken();
                if (!left.equals(".")) {
                    rootNode.left = new Node(left);
                    nodeMap.put(rootNode.left.value, rootNode.left);
                }
                if (!right.equals(".")) {
                    rootNode.right = new Node(right);
                    nodeMap.put(rootNode.right.value, rootNode.right);
                }
            }  else {
                String self = st.nextToken();
                String left = st.nextToken();
                String right = st.nextToken();
                if (!left.equals(".")) {
                    nodeMap.get(self).left = new Node(left);
                    nodeMap.put(left, nodeMap.get(self).left);
                }
                if (!right.equals(".")) {
                    nodeMap.get(self).right = new Node(right);
                    nodeMap.put(right, nodeMap.get(self).right);
                }
            }
        }
    }

    static class Node {
        String value;
        Node left;
        Node right;

        public Node(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
