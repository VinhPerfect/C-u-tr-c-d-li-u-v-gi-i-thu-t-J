package dslkdonDao.dslkdonDao;

import java.util.Scanner;

public class MainDao {
    public static void main(String[] args) {
        LinkList list = new LinkList();

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Thêm sinh viên vào danh sách");
            System.out.println("2. Ghi danh sách vào file");
            System.out.println("3. Đọc danh sách từ file");
            System.out.println("4. In danh sách sinh viên");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("NHập số lượng sinh viên: ");
                    int soLuongsv = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 1; i<=soLuongsv; i++){
                        System.out.println("Sinh vien thu " +i+ " : ");
                        scanner.nextLine();

                        System.out.print("Nhập mã sinh viên thu " +i+ " : ");
                        String maSV = scanner.nextLine();

                        System.out.print("Nhập họ tên sinh viên thu " +i+ " : ");
                        String hoten = scanner.nextLine();

                        System.out.print("Nhập điểm sinh vien thu " +i+ " : ");
                        double diem = scanner.nextDouble();

                        list.insert(maSV, hoten, diem);
                    }

                    System.out.println("Đã thêm sinh viên vào danh sách.");
                    break;

                case 2:
                    list.ghifile();
                    System.out.println("Đã ghi danh sách vào file.");
                    break;

                case 3:
                    list.docfile();
                    System.out.println("Đã đọc danh sách từ file.");
                    break;

                case 4:
                    System.out.println("Danh sách sinh viên:");
                    list.printList();
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
