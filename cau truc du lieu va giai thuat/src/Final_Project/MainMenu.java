package Final_Project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    private Scanner sc;
    private LinkedList list;
    private BinaryTree binaryTree;
    private DatabaseConnection dbConnection;

    public MainMenu() {
        sc = new Scanner(System.in);
        list = new LinkedList();
        binaryTree = new BinaryTree();
        dbConnection = new DatabaseConnection();
    }

    public void displayMenu() {
        int choice;
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Các bài toán đệ quy");
            System.out.println("2. Danh sách liên kết đơn");
            System.out.println("3. Danh sách liên kết đôi");
            System.out.println("4. Cấu trúc cây nhị phân");
            System.out.println("5. Đọc dữ liệu từ Database cho BinaryTree");
            System.out.println("6. Đọc dữ liệu từ Database cho LinkedList");
            System.out.println("7. Xuất ra file Excel");
            System.out.println("0. Thoát");
            System.out.print("Mời bạn chọn: ");
            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        CacBaiToanDeQuy deQuyMenu = new CacBaiToanDeQuy(sc);
                        deQuyMenu.Menuhienthi();
                        break;
                    case 2:
                        menuDanhSachLienKetDon();
                        break;
                    case 3:
                        menuDanhSachLienKetDoi();
                        break;
                    case 4:
                        menuBinaryTree();
                        break;
                    case 5:
                        docDuLieuDatabaseCayNhiPhan();
                        break;
                    case 6:
                        docDuLieuDatabaseLinkedLst();
                        break;
                    case 7:
                        ExportToText();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Vui lòng nhập một số nguyên.");
                sc.nextLine();
            }
        }
    }

    // Menu cho danh sách liên kết đơn
    public void menuDanhSachLienKetDon() {
        int choice;
        while (true) {
            System.out.println("\nDanh sách liên kết đơn:");
            System.out.println("1. Nhập danh sách các phần tử");
            System.out.println("2. Chèn vào đầu");
            System.out.println("3. Chèn vào cuối");
            System.out.println("4. Xóa phần tử");
            System.out.println("5. Tìm kiếm phần tử");
            System.out.println("6. Hiển thị danh sách");
            System.out.println("0. Quay lại menu chính");
            System.out.print("Mời bạn chọn: ");
            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        list.nhapDanhSachLienKetDon();
                        break;
                    case 2:
                        System.out.print("Nhập giá trị để chèn vào đầu: ");
                        list.chenVaoDauLienKetDon(sc.nextInt());
                        break;
                    case 3:
                        System.out.print("Nhập giá trị để chèn vào cuối: ");
                        list.chenVaoCuoiDanhSachLienKetDon(sc.nextInt());
                        break;
                    case 4:
                        System.out.print("Nhập giá trị để xóa: ");
                        list.xoaDauLienKetDon(sc.nextInt());
                        break;
                    case 5:
                        System.out.print("Nhập giá trị để tìm kiếm: ");
                        boolean found = list.timKiemDanhSachLienKetDon(sc.nextInt());
                        System.out.println(found ? "Phần tử được tìm thấy." : "Phần tử không được tìm thấy.");
                        break;
                    case 6:
                        System.out.println("Các phần tử trong danh sách:");
                        list.hienThiDanhSachLienKetDon();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Vui lòng nhập một số nguyên.");
                sc.nextLine(); // Dọn bộ đệm
            }
        }
    }

    // Menu cho danh sách liên kết đôi
    public void menuDanhSachLienKetDoi() {
        int choice;
        while (true) {
            System.out.println("\nDanh sách liên kết đôi:");
            System.out.println("1. Nhập danh sách các phần tử");
            System.out.println("2. Chèn vào đầu");
            System.out.println("3. Chèn vào cuối");
            System.out.println("4. Xóa phần tử");
            System.out.println("5. Tìm kiếm phần tử");
            System.out.println("6. Hiển thị danh sách");
            System.out.println("0. Quay lại menu chính");
            System.out.print("Mời bạn chọn: ");
            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        list.nhapDanhSachLienKetDoi();
                        break;
                    case 2:
                        System.out.print("Nhập giá trị để chèn vào đầu: ");
                        list.chenVaoDauDanhSachLienKetDoi(sc.nextInt());
                        break;
                    case 3:
                        System.out.print("Nhập giá trị để chèn vào cuối: ");
                        list.chenVaoCuoiDanhSachLienKetDoi(sc.nextInt());
                        break;
                    case 4:
                        System.out.print("Nhập giá trị để xóa: ");
                        list.xoaDanhSachLienKetDoi(sc.nextInt());
                        break;
                    case 5:
                        System.out.print("Nhập giá trị để tìm kiếm: ");
                        boolean found = list.timKiemDanhSachLienKetDoi(sc.nextInt());
                        System.out.println(found ? "Phần tử được tìm thấy." : "Phần tử không được tìm thấy.");
                        break;
                    case 6:
                        System.out.println("Các phần tử trong danh sách:");
                        list.hienThiDanhSachLienKetDoi();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Vui lòng nhập một số nguyên.");
                sc.nextLine(); // Dọn bộ đệm
            }
        }
    }

    // Menu cho cây nhị phân
    private void menuBinaryTree() {
        int choice;
        while (true) {
            System.out.println("\nQuản lý cây nhị phân:");
            System.out.println("1. Nhập phần tử");
            System.out.println("2. Tìm kiếm phần tử");
            System.out.println("3. Xóa phần tử");
            System.out.println("4. Duyệt cây (In-Order)");
            System.out.println("5. Duyệt cây (Pre-Order)");
            System.out.println("6. Duyệt cây (Post-Order)");
            System.out.println("0. Quay lại menu chính");
            System.out.print("Mời bạn chọn: ");
            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        binaryTree.nhapPhanTuCayNhiPhan();
                        break;
                    case 2:
                        System.out.print("Nhập giá trị để tìm kiếm: ");
                        boolean found = binaryTree.search(sc.nextInt());
                        System.out.println(found ? "Phần tử được tìm thấy." : "Phần tử không được tìm thấy.");
                        break;
                    case 3:
                        System.out.print("Nhập giá trị để xóa: ");
                        binaryTree.delete(sc.nextInt());
                        break;
                    case 4:
                        System.out.println("Duyệt cây theo thứ tự giữa (In-Order):");
                        binaryTree.inOrder();
                        break;
                    case 5:
                        System.out.println("Duyệt cây theo thứ tự trước (Pre-Order):");
                        binaryTree.preOrder();
                        break;
                    case 6:
                        System.out.println("Duyệt cây theo thứ tự sau (Post-Order):");
                        binaryTree.postOrder();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Vui lòng nhập một số nguyên.");
                sc.nextLine(); // Dọn bộ đệm
            }
        }
    }

    // Đọc dữ liệu từ database cho cây nhị phân
    private void docDuLieuDatabaseCayNhiPhan() {
        dbConnection.getElementsFromDatabaseBinaryTree(binaryTree);
        System.out.println("Dữ liệu đã được tải vào cây nhị phân.");
    }

    // Đọc dữ liệu từ database cho danh sách liên kết
    private void docDuLieuDatabaseLinkedLst() {
        dbConnection.getElementsFromDatabaseLinkedList(list);
        System.out.println("Dữ liệu đã được tải vào danh sách liên kết.");
    }
    //////////////////////////
    public void ExportToText() {
        ExportToText xuatfile = new ExportToText();

        System.out.println("Chọn dữ liệu xuất ra Excel:");
        System.out.println("1. Xuất LinkedList");
        System.out.println("2. Xuất BinaryTree");
        System.out.print("Mời bạn chọn: ");

        int choice = sc.nextInt();
        sc.nextLine(); // Dọn bộ đệm

        System.out.print("Nhập tên file (ví dụ: data.xlsx): ");
        String fileName = sc.nextLine();

        switch (choice) {
            case 1:
                xuatfile.exportLinkedListToText(list, fileName);
                break;
            case 2:
                xuatfile.exportBinaryTreeToText(binaryTree, fileName);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }

}
