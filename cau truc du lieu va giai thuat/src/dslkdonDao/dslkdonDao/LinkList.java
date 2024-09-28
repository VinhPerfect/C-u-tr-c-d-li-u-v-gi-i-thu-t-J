package dslkdonDao.dslkdonDao;

import java.util.Scanner;


public class LinkList {
	public Link first;
	LinkDao obj=new LinkDao();
    //LinkList constructor
    public LinkList() {
        first = null;
       
    }
        public void insert(String maSV, String hoten, double diem) {
       //TẠO NÚT VÀ ĐIỀN GIÁ TRỊ CHO NÚT ĐÓ
    	Link nut = new Link(maSV, hoten, diem);
    	// ĐƯA NÚT ĐÓ VÀO DANH SÁCH
        nut.nextLink = first;
        first = nut;    }
        
        public void ghifile()
        {
        obj.ghiFile(first);
        }
        public void docfile()
    	{
    				first= obj.docFile("D:\\xuatfile\\file1");
    	}
        public void printList() {
            Link p = first;
            while(p != null) {
                System.out.println(p.getMaSV()+"  "+p.getHoten()+ "   "+ p.getDiem());
                p = p.nextLink;
            }
            System.out.println("");
        }
}
