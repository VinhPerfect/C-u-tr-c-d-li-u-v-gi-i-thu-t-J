package danhsachlienketdon;

import java.util.Scanner;

class LienKetDon {
    class Node {
        String ten;
        double diemTrungBinh;
        String ketQua;
        String xepLoai;
        Node next;

        public Node(String ten, double diemTrungBinh) {
            this.ten = ten;
            this.diemTrungBinh = diemTrungBinh;
            this.ketQua = "";
            this.xepLoai = "";
            this.next = null;
        }
    }

    private Node head;

    public void themSinhVien(String ten, double diemTrungBinh) {
        Node newNode = new Node(ten, diemTrungBinh);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void hienThiDanhSach() {
        Node current = head;
        while (current != null) {
            System.out.println("Tên: " + current.ten + ", Điểm TB: " + current.diemTrungBinh);
            current = current.next;
        }
    }

    public void hienThiDiemLonHonBang5() {
        Node current = head;
        while (current != null) {
            if (current.diemTrungBinh >= 5) {
                System.out.println("Tên: " + current.ten + ", Điểm TB: " + current.diemTrungBinh);
            }
            current = current.next;
        }
    }

    public void hienThiDiemLonNhat() {
        if (head == null) {
            System.out.println("Danh sách trống.");
            return;
        }
        Node current = head;
        Node maxNode = head;
        while (current != null) {
            if (current.diemTrungBinh > maxNode.diemTrungBinh) {
                maxNode = current;
            }
            current = current.next;
        }
        System.out.println("Sinh viên có điểm TB cao nhất: Tên: " + maxNode.ten + ", Điểm TB: " + maxNode.diemTrungBinh);
    }

    public void dienKetQua() {
        Node current = head;
        while (current != null) {
            current.ketQua = current.diemTrungBinh >= 5 ? "Đậu" : "Rớt";
            current = current.next;
        }
    }

    public void dienXepLoai() {
        Node current = head;
        while (current != null) {
            if (current.diemTrungBinh >= 8) {
                current.xepLoai = "Giỏi";
            } else if (current.diemTrungBinh >= 6.5) {
                current.xepLoai = "Khá";
            } else if (current.diemTrungBinh >= 5) {
                current.xepLoai = "Trung bình";
            } else {
                current.xepLoai = "Yếu";
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LienKetDon danhSach = new LienKetDon();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập số lượng sinh viên:");
        int soLuong = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập tên sinh viên:");
            String ten = scanner.nextLine();
            System.out.println("Nhập điểm trung bình:");
            double diemTrungBinh = scanner.nextDouble();
            scanner.nextLine();
            danhSach.themSinhVien(ten, diemTrungBinh);
        }

        System.out.println("\nDanh sách sinh viên:");
        danhSach.hienThiDanhSach();

        System.out.println("\nSinh viên có điểm TB >= 5:");
        danhSach.hienThiDiemLonHonBang5();

        System.out.println("\nSinh viên có điểm TB cao nhất:");
        danhSach.hienThiDiemLonNhat();

        danhSach.dienKetQua();
        danhSach.dienXepLoai();

        System.out.println("\nDanh sách sinh viên sau khi điền kết quả và xếp loại:");
        Node current = danhSach.head;
        while (current != null) {
            System.out.println("Tên: " + current.ten + ", Điểm TB: " + current.diemTrungBinh +
                    ", Kết quả: " + current.ketQua + ", Xếp loại: " + current.xepLoai);
            current = current.next;
        }
    }
}

