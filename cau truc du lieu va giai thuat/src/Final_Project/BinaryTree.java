package Final_Project;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryTree {
    private TreeNode root;


    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
    ///////
    public void insert(int value) {
        root = insertRec(root, value);
    }
    ///////
    private TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }
    ///////
    public boolean search(int value) {
        return searchRec(root, value);
    }
    ///////
    private boolean searchRec(TreeNode root, int value) {
        if (root == null) {
            return false;
        }
        if (root.value == value) {
            return true;
        }
        return value < root.value ? searchRec(root.left, value) : searchRec(root.right, value);
    }
    ///////
    public void delete(int value) {
        root = deleteRec(root, value);
    }
    ///////
    private TreeNode deleteRec(TreeNode root, int value) {
        if (root == null) {
            return null;
        }
        if (value < root.value) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.value) {
            root.right = deleteRec(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.value = minValue(root.right);
            root.right = deleteRec(root.right, root.value);
        }
        return root;
    }
    ///////
    private int minValue(TreeNode root) {
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }
    ///////
    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }
    ///////
    private void inOrderRec(TreeNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.value + " ");
            inOrderRec(root.right);
        }
    }
    ///////
    public List<Integer> preOrder() {
        List<Integer> result = new ArrayList<>();
        preOrderHelper(root, result);
        return result;
    }
    private void preOrderHelper(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.value);
            preOrderHelper(node.left, result);   // Sửa lỗi: Dùng node.left thay vì TreeNode.left
            preOrderHelper(node.right, result);  // Sửa lỗi: Dùng node.right thay vì node.t
        }
    }
    ///////
    private void preOrderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }
    ///////
    public void postOrder() {
        postOrderRec(root);
        System.out.println();
    }
    ///////
    private void postOrderRec(TreeNode root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.value + " ");
        }
    }
    /////
    public void nhapPhanTuCayNhiPhan() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử bạn muốn chèn vào cây: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập giá trị phần tử thứ " + (i + 1) + ": ");
            int value = sc.nextInt();
            insert(value);
        }
        System.out.println("Đã chèn " + n + " phần tử vào cây.");
    }

}
