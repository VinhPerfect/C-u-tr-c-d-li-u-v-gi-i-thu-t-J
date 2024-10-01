package BinaryTree;

public class TreeNode {
    private String HoTenSv;
    private String MaSv;
    private double diem;
    private String kq, xl;
    TreeNode left;
    TreeNode right;

    public TreeNode(String hoTenSv, String maSv, double diem, String kq, String xl) {
        HoTenSv = hoTenSv;
        this.xl = xl;
        this.kq = kq;
        this.diem = diem;
        MaSv = maSv;
        this.right = null;
        this.left = null;
    }

    public String getHoTenSv() {
        return HoTenSv;
    }

    public void setHoTenSv(String hoTenSv) {
        HoTenSv = hoTenSv;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public String getMaSv() {
        return MaSv;
    }

    public void setMaSv(String maSv) {
        MaSv = maSv;
    }

    public String getKq() {
        return kq;
    }

    public void setKq(String kq) {
        this.kq = kq;
    }

    public String getXl() {
        return xl;
    }

    public void setXl(String xl) {
        this.xl = xl;
    }
}
