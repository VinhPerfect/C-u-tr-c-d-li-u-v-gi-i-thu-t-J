package danhsachlienketdoi;

import danhsachlienketdon.Node;

import java.util.Scanner;

public class TimKiemDanhSachLienKetDoi {

    DoubleLink head;
    DoubleLink current = head;

    public void search(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap ma sinh vien can tim: ");

        String key = sc.nextLine();

        while (current != null){
            if (current.getMaSV().equals(key)){
                System.out.println("Da tim thay sinh vien co ma: "+key);
                return;
            }
            current=current.next;
        }
        System.out.println("Ma sinh vien "+key+" khong ton tai");
    }

}
