package danhsachlienketdoi;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DoubleLinkList {
    DoubleLink head;
    Scanner sc = new Scanner(System.in);
    public DoubleLinkList() {
        head = null;
    }

    public void add(String hoTen, String maSV, double diem){
        DoubleLink newDoubleLink = new DoubleLink(hoTen, maSV, diem);
        if(head == null){
            head = newDoubleLink;
        }else{
            DoubleLink current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newDoubleLink;
            newDoubleLink.prev = current;
        }
    }
    //
    public void indulieu(){
        DoubleLink current = head;
        while (current != null){
            System.out.println("Ho ten: " + current.getHoTen());
            System.out.println("Ma sinh vien: " + current.getMaSV());
            System.out.println("Diem: " + current.getDiem());
            current = current.next;
        }
        System.out.println("Danh sach trong");
    }
    //
    public void ketqua(){
        DoubleLink current = head;
        while (current != null){
            String ketquadiem = (current.getDiem()>=5) ? "Dau" : "Rot";
            System.out.println(ketquadiem);
            current = current.next;
        }
    }
    //
    public void hocluc (){
        DoubleLink current = head;
        while(current != null){
            if (current.getDiem()>=9){
                System.out.println("Xuat xac");
            } else if (current.getDiem()>=8){
                System.out.println("Gioi");
            } else if (current.getDiem()>=6.5) {
                System.out.println("Kha");
            } else {
                System.out.println("Trung Binh");
            }
            current = current.next;
        }
    }
    //
    public void search(){
        DoubleLink current = head;

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
    //
    public void xoasinhviendautien(){
        DoubleLink current = head;

        if (current == null){
            System.out.println("Danh sach rong khong the xoa");
            return;
        }
        current = current.next;
        if (current != null){
            current.prev = null;
        }
        System.out.println("Da xoa thanh cong");
        while (current != null){
            System.out.println("Ho ten: " + current.getHoTen());
            System.out.println("Ma sinh vien: " + current.getMaSV());
            System.out.println("Diem: " + current.getDiem());
            current = current.next;
        }
        System.out.println("end!!!");
    }
    //
    public void sinhviencodiemtrungbinhlonnhat(){
        DoubleLink temp = head;
        DoubleLink current = head.next;
        while (current != null){
            if (current.getDiem() > head.getDiem()){
                temp = current;
            }
            current = current.next;
        }
        System.out.println("Sinh vien co diem lon nhat");
        System.out.println("Ho va ten: " + temp.getHoTen());
        System.out.println("Ma sinh vien: " + temp.getMaSV());
        System.out.println("Diem: " + temp.getDiem());
        System.out.println("end!!!");
    }
    //
    public void themsinhvien(String hoTen, String maSV, double diem){
        DoubleLink current = head;
        DoubleLink themsinhvienmoi = new DoubleLink(hoTen, maSV, diem);
        if (current == null){
            current = themsinhvienmoi;
            return;
        }
        while (current.next != null){
            current = current.next;
        }
        current.next = themsinhvienmoi;
        themsinhvienmoi.prev = current;

    }
    //
    public static void ghifile(String filePath, String content){
        try (FileOutputStream out = new FileOutputStream(filePath)){
            out.write(content.getBytes());
            System.out.println("File da duoc tao");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String docfile(String filePath){
       StringBuilder content = new StringBuilder();
       try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
           byte[] data = new byte[fileInputStream.available()];
           fileInputStream.read(data);
           content.append(new String(data));
       } catch (IOException e){
           e.printStackTrace();
       }
       return content.toString();
       }
    }

