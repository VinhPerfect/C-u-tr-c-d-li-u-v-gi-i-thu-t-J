package cautrucdulieuvagiaithuat;

public class hangdoi {
    private int[] mang;
    private int dau;
    private int cuoi;
    private int kichThuoc; 


    public hangdoi(int sucChua) {
        mang = new int[sucChua];
        dau = 0;
        cuoi = -1;
        kichThuoc = 0;
    }


    public void them(int giaTri) {
        if (kichThuoc == mang.length) {
            System.out.println("Hàng đợi đầy.");
            return;
        }
        cuoi = (cuoi + 1) % mang.length;
        mang[cuoi] = giaTri;
        kichThuoc++;
    }


    public int loaiBo() {
        if (kichThuoc == 0) {
            System.out.println("Hàng đợi rỗng.");
            return -1;
        }
        int giaTri = mang[dau];
        dau = (dau + 1) % mang.length;
        kichThuoc--;
        return giaTri;
    }


    public int xem() {
        if (kichThuoc == 0) {
            System.out.println("Hàng đợi rỗng.");
            return -1;
        }
        return mang[dau];
    }

    public static void main(String[] args) {
        hangdoi hangDoi = new hangdoi(3);

        hangDoi.them(1);
        hangDoi.them(2);
        hangDoi.them(3);
        hangDoi.them(4);

        System.out.println("Xem phần tử đầu: " + hangDoi.xem());

        System.out.println("Loại bỏ: " + hangDoi.loaiBo());
        System.out.println("Loại bỏ: " + hangDoi.loaiBo());

        hangDoi.them(5);

        while (hangDoi.kichThuoc > 0) {
            System.out.println("Loại bỏ: " + hangDoi.loaiBo());
        }
    }
}

