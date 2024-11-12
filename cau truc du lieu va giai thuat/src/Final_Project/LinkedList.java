package Final_Project;

import java.util.Scanner;

public class LinkedList {
    private Node head;
    private Node tail;

    Scanner sc = new Scanner(System.in);

    public void chenVaoDauLienKetDon(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void chenVaoCuoiDanhSachLienKetDon(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void xoaDauLienKetDon(int value) {
        if (head == null) return;

        if (head.value == value) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.value != value) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public boolean timKiemDanhSachLienKetDon(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.value == value) return true;
            temp = temp.next;
        }
        return false;
    }

    public void hienThiDanhSachLienKetDon() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void chenVaoDauDanhSachLienKetDoi(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void chenVaoCuoiDanhSachLienKetDoi(int value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void xoaDanhSachLienKetDoi(int value) {
        if (head == null) return;

        if (head.value == value) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
            return;
        }

        Node temp = head;
        while (temp != null && temp.value != value) {
            temp = temp.next;
        }

        if (temp != null) {
            if (temp.next != null) temp.next.prev = temp.prev;
            else tail = temp.prev;

            if (temp.prev != null) temp.prev.next = temp.next;
        }
    }

    public boolean timKiemDanhSachLienKetDoi(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.value == value) return true;
            temp = temp.next;
        }
        return false;
    }

    public void hienThiDanhSachLienKetDoi() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    //////////////////////////////
    public void nhapDanhSachLienKetDon() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử trong danh sách liên kết đơn: ");
        int n = sc.nextInt();

        System.out.println("Nhập các phần tử:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử " + (i + 1) + ": ");
            int value = sc.nextInt();

        }
        System.out.println("Danh sách liên kết đơn đã được tạo.");
    }
    //////////////////////////////////
    public void nhapDanhSachLienKetDoi() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử trong danh sách liên kết đôi: ");
        int n = sc.nextInt();

        System.out.println("Nhập các phần tử:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử " + (i + 1) + ": ");
            int value = sc.nextInt();
            chenVaoCuoiDanhSachLienKetDoi(value);
        }
        System.out.println("Danh sách liên kết đôi đã được tạo.");
    }
    ///////////////
    public Node getHead() {
        return head;
    }
}
