import java.util.Stack;

public class 표_편집_LinkedList {
    static class Node {
        Node next, prev;
        int data;

        public Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    public String solution(int n, int k, String[] cmd) {

        Stack<Node> delNodes = new Stack<>();
        Node root = new Node(0);
        Node cur = root;

        for(int i = 1; i < n; i ++) {
            Node node = new Node(i);
            cur.next = node;
            node.prev = cur;
            cur = node;
        }

        Node tail = cur;
        root.prev = tail;
        tail.next = root;
        cur = root;

        while(k-- > 0){
            cur = cur.next;
        }

        for(int i = 0; i < cmd.length; i ++) {
            String[] s = cmd[i].split(" ");
            if(s.length == 1) {
                if(s[0].equals("C")) {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                    delNodes.push(cur);
                    if(cur == root) {
                        root = cur.next;
                        cur = root;
                    } else if(cur == tail) {
                        tail = cur.prev;
                        cur = tail;
                    } else cur = cur.next;
                } else {
                    Node node = delNodes.pop();
//                    Node tmp = node.prev.next;
                    node.prev.next = node;
//                    tmp.prev = node;
                    node.next.prev = node;
                    if(node.data < root.data) root = node;
                    else if(node.data > tail.data) tail = node;
                }
            } else {
                int num = Integer.parseInt(s[1]);
                if(s[0].equals("U"))
                    while(num-- >0) cur = cur.prev;
                else while(num-- >0) cur = cur.next;
            }
        }

        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < n; i ++) {
            if(root.data == i) {
                ans.append("O");
                root = root.next;
            } else ans.append("X");
        }

        return ans.toString();
    }
}
