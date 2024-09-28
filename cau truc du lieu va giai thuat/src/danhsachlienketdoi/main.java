package danhsachlienketdoi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        DoubleLinkList list = new DoubleLinkList();
        Scanner sc = new Scanner(System.in);
        list.add("Vinh", "SV01", 9);
        list.add("A", "SV02", 7);
        list.add("B", "SV03", 6);
        list.add("C", "SV04", 3);
        //
        Map<Integer, Runnable> Menu = new HashMap<>();
        Menu.put(1, () -> System.out.println("Nhap danh sach sinh vien"));
        System.out.println("");
        //
        System.out.println("Du lieu sinh vien: ");
        list.indulieu();
        //
        System.out.println("------------");
        System.out.println("Xep loai sinh vien: ");
        list.ketqua();
        //
        System.out.println("------------");
        System.out.println("Xep loai hoc luc: ");
        list.hocluc();
        //
        System.out.println("------------");
        System.out.println("Tim kiem sinh vien");
        list.search();
        //
        System.out.println("------------");
        System.out.println("Xoa sinh vien dau tien: ");
        list.xoasinhviendautien();
        //
        System.out.println("------------");
        list.sinhviencodiemtrungbinhlonnhat();
        //
        System.out.println("---------------");
        System.out.println("Danh sach sinh vien sau khi chen");
        list.themsinhvien("D", "SV05", 5);
        list.indulieu();
        //
        System.out.println("----------------");

    }
}
