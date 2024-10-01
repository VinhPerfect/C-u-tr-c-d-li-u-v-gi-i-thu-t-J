package BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.Nhapdanhsachsinhvien();
        tree.duyettruoc(tree.root);
        //
        System.out.println("danh sach sinh vien sau khi xoa");
        tree.root = tree.xoa(tree.root, "SV002");
        //
        tree.duyettruoc(tree.root);
    }
}
