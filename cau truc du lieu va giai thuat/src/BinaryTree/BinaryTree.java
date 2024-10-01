package BinaryTree;

import java.util.ArrayList;
import java.util.Scanner;

public class BinaryTree {
    TreeNode root;

    public BinaryTree(){
        root = null;
    }

    ArrayList<TreeNode> dssv = new ArrayList<>();
    //
    public void Nhapdanhsachsinhvien(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong sinh vien: ");
        int soluongsinhvien = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i<soluongsinhvien; i++){
            System.out.println("Nhap thong tin sinh vien thu  "+(i+1)+": ");
            System.out.println("Ho va ten: ");
            String hoTenSv = sc.nextLine();

            System.out.print("Mã sinh viên: ");
            String maSv = sc.nextLine();
            System.out.print("Điểm: ");
            double diem = sc.nextDouble();
            sc.nextLine();
            System.out.println("Ket qua: ");
            String kq = sc.nextLine();

            System.out.println("Xep loai: ");
            String xl = sc.nextLine();

            TreeNode NewSinhvien = new TreeNode(hoTenSv, maSv, diem, kq, xl);
            dssv.add(NewSinhvien);

            root = them(root, NewSinhvien);
        }
    }
    //
    private TreeNode them(TreeNode root, TreeNode NewSinhvien){
        if(root==null){
            return NewSinhvien;
        }
        if (NewSinhvien.getMaSv().compareTo(root.getMaSv()) < 0) {
            root.left = them(root.left, NewSinhvien);
        } else {
            root.right = them(root.right, NewSinhvien);
        }
        return root;
    }
    //
    public void duyettruoc(TreeNode root) {
        if (root != null) {
            System.out.println("Sinh viên: " + root.getHoTenSv() + " - Mã SV: " + root.getMaSv() + " - Điểm: " + root.getDiem() + " - Kết quả: " + root.getKq() + " - Xếp loại: " + root.getXl());
            duyettruoc(root.left);
            duyettruoc(root.right);
        }
    }
    //
    public TreeNode xoa(TreeNode root, String MaSv) {
        if (root == null) return null;

        if (MaSv.compareTo(root.getMaSv()) < 0) {
            root.left = xoa(root.left, MaSv);
        } else if (MaSv.compareTo(root.getMaSv()) > 0) {
            root.right = xoa(root.right, MaSv);
        } else {
            if (root.left == null) {
                return root.right;
            } else {
                return root.left;
            }
        }
        return root;
    }
}

