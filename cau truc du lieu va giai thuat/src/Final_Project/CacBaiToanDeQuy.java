package Final_Project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CacBaiToanDeQuy {
    private Scanner sc;

    public CacBaiToanDeQuy(Scanner sc) {
        this.sc = sc;
    }

    public void Menuhienthi() {
        int choice;
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Các bài toán đệ quy quay lui");
            System.out.println("2. Các thuật toán sắp xếp");
            System.out.println("3. Các bài toán đệ quy và khu đệ quy");
            System.out.println("0. Thoat");
            System.out.print("Mời bạn chọn: ");

            try {
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        DeQuyQuayLui();
                        break;
                    case 2:
                        System.out.println("2. Thuật toán sắp xếp");
                        thuatToanSapXep();
                        break;
                    case 3:
                        System.out.println("3. Bài toán đệ quy và khu đệ quy");
                        baiToanDeQuyVaKhuDeQuy();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Nhập vào là một số nguyên");
                sc.nextLine();
            }
        }
    }

    ////////////////////////////////////////////////
    private void DeQuyQuayLui() {
        int choice2;
        System.out.println("1. Đặt quân Hậu vào bàn cờ");
        System.out.println("2. Bài toán Tổ hợp");
        System.out.print("Mời bạn chọn: ");
        choice2 = sc.nextInt();
        switch (choice2) {
            case 1:
                System.out.print("Nhập kích thước bàn cờ (N): ");
                int N = sc.nextInt();
                int[][] banCo = new int[N][N];

                if (giaiQuanHau(banCo, 0, N)) {
                    System.out.println("Giải pháp cho bài toán N-Hậu:");
                    inKetQua(banCo, N);
                } else {
                    System.out.println("Không có giải pháp.");
                }
                break;
            case 2:
                System.out.print("Nhập số lượng phần tử (n): ");
                int n = sc.nextInt();
                System.out.print("Nhập kích thước tổ hợp (r): ");
                int r = sc.nextInt();
                System.out.println("Tất cả các tổ hợp của " + n + " chọn " + r + ":");
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = i + 1;
                }
                sinhToHop(arr, r, 0, new int[r], 0);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    private static boolean kiemTraAnToan(int[][] banCo, int hang, int cot, int N) {
        for (int i = 0; i < hang; i++)
            if (banCo[i][cot] == 1) return false;

        for (int i = hang, j = cot; i >= 0 && j >= 0; i--, j--)
            if (banCo[i][j] == 1) return false;

        for (int i = hang, j = cot; i >= 0 && j < N; i--, j++)
            if (banCo[i][j] == 1) return false;

        return true;
    }

    private static boolean giaiQuanHau(int[][] banCo, int hang, int N) {
        if (hang >= N) return true;

        for (int cot = 0; cot < N; cot++) {
            if (kiemTraAnToan(banCo, hang, cot, N)) {
                banCo[hang][cot] = 1;

                if (giaiQuanHau(banCo, hang + 1, N))
                    return true;

                banCo[hang][cot] = 0;
            }
        }
        return false;
    }

    public static void inKetQua(int[][] banCo, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(banCo[i][j] + " ");
            System.out.println();
        }
    }

    ////////////////////////////////////////////////
    private void sinhToHop(int[] arr, int r, int index, int[] data, int i) {
        if (index == r) {
            for (int j = 0; j < r; j++) {
                System.out.print(data[j] + " ");
            }
            System.out.println();
            return;
        }
        while (i < arr.length) {
            data[index] = arr[i];
            sinhToHop(arr, r, index + 1, data, i + 1);
            i++;
        }
    }

    // 4 thuật toán sắp xếp
    private void thuatToanSapXep() {
        int choice;
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = sc.nextInt();
        int[] mang = new int[n];

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            mang[i] = sc.nextInt();
        }

        try {
            System.out.println("Chọn thuật toán sắp xếp:");
            System.out.println("1. Sắp xếp Bubble Sort ");
            System.out.println("2. Sắp xếp Merge Sort ");
            System.out.println("3. Sắp xếp Insertion Sort ");
            System.out.println("4. Sắp xếp Quick Sort ");
            System.out.println("0. Thoat");
            System.out.print("Mời bạn chọn: ");
            choice = sc.nextInt();


            switch (choice) {

                case 1:
                    sapXepNoiBot(mang);
                    System.out.println("Mảng sau khi sắp xếp Bubble Sort: " + arrayToString(mang));
                    break;
                case 2:
                    sapXepChon(mang);
                    System.out.println("Mảng sau khi sắp xếp Merge Sort: " + arrayToString(mang));
                    break;
                case 3:
                    sapXepChen(mang);
                    System.out.println("Mảng sau khi sắp xếp Insertion Sort: " + arrayToString(mang));
                    break;
                case 4:

                    sapXepNhanh(mang, 0, n - 1);
                    System.out.println("Mảng sau khi sắp xếp Quick Sort: " + arrayToString(mang));
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Nhập vào là một số nguyên.");
            sc.nextLine();
        }
    }

    private String arrayToString(int[] mang) {
        StringBuilder sb = new StringBuilder();
        for (int num : mang) {
            sb.append(num).append(" ");
        }
        return sb.toString().trim();
    }

    private void sapXepNoiBot(int[] mang) {
        int n = mang.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (mang[j] > mang[j + 1]) {
                    int tam = mang[j];
                    mang[j] = mang[j + 1];
                    mang[j + 1] = tam;
                }
            }
        }
    }

    private void sapXepChon(int[] mang) {
        int n = mang.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (mang[j] < mang[minIndex]) {
                    minIndex = j;
                }
            }
            int tam = mang[minIndex];
            mang[minIndex] = mang[i];
            mang[i] = tam;
        }
    }

    private void sapXepChen(int[] mang) {
        int n = mang.length;
        for (int i = 1; i < n; i++) {
            int key = mang[i];
            int j = i - 1;
            while (j >= 0 && mang[j] > key) {
                mang[j + 1] = mang[j];
                j = j - 1;
            }
            mang[j + 1] = key;
        }
    }

    private void sapXepNhanh(int[] mang, int trai, int phai) {
        if (trai < phai) {
            int chiSoPhanHoach = phanHoach(mang, trai, phai);
            sapXepNhanh(mang, trai, chiSoPhanHoach - 1);
            sapXepNhanh(mang, chiSoPhanHoach + 1, phai);
        }
    }

    private int phanHoach(int[] mang, int trai, int phai) {
        int chot = mang[phai];
        int i = (trai - 1);
        for (int j = trai; j < phai; j++) {
            if (mang[j] <= chot) {
                i++;
                int tam = mang[i];
                mang[i] = mang[j];
                mang[j] = tam;
            }
        }
        int tam = mang[i + 1];
        mang[i + 1] = mang[phai];
        mang[phai] = tam;
        return i + 1;
    }

    ////////////////////////////////////////////////////////////////////////////
    private void baiToanDeQuyVaKhuDeQuy() {
        int choice;
        try {
            System.out.println("Chọn bài toán đệ quy và khử đệ quy:");
            System.out.println("1. Tính giai thừa (Factorial)");
            System.out.println("2. Tính số Fibonacci");
            System.out.println("3. Tìm ước chung lớn nhất (GCD)");
            System.out.println("4. Tính lũy thừa (Power)");
            System.out.print("Mời bạn chọn: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    tinhGiaiThua();
                    break;
                case 2:
                    tinhFibonacci();
                    break;
                case 3:
                    tinhGCD();
                    break;
                case 4:
                    tinhLuyThua();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Nhập vào là một số nguyên.");
            sc.nextLine();
        }
    }

    private void tinhGiaiThua() {
        System.out.print("Nhập số nguyên dương n: ");
        int n = sc.nextInt();
        System.out.println("Giai thừa đệ quy của " + n + " là: " + giaiThuaDeQuy(n));
        System.out.println("Giai thừa khử đệ quy của " + n + " là: " + giaiThuaKhongDeQuy(n));
    }

    private int giaiThuaDeQuy(int n) {
        if (n == 0) return 1;
        return n * giaiThuaDeQuy(n - 1);
    }

    private int giaiThuaKhongDeQuy(int n) {
        int ketQua = 1;
        for (int i = 1; i <= n; i++) {
            ketQua *= i;
        }
        return ketQua;
    }

    private void tinhFibonacci() {
        System.out.print("Nhập vị trí của số Fibonacci (n): ");
        int n = sc.nextInt();
        System.out.println("Fibonacci đệ quy của " + n + " là: " + fibonacciDeQuy(n));
        System.out.println("Fibonacci khử đệ quy của " + n + " là: " + fibonacciKhongDeQuy(n));
    }

    private int fibonacciDeQuy(int n) {
        if (n <= 1) return n;
        return fibonacciDeQuy(n - 1) + fibonacciDeQuy(n - 2);
    }

    private int fibonacciKhongDeQuy(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    private void tinhGCD() {
        System.out.print("Nhập số nguyên dương a: ");
        int a = sc.nextInt();
        System.out.print("Nhập số nguyên dương b: ");
        int b = sc.nextInt();
        System.out.println("GCD đệ quy của " + a + " và " + b + " là: " + gcdDeQuy(a, b));
        System.out.println("GCD khử đệ quy của " + a + " và " + b + " là: " + gcdKhongDeQuy(a, b));
    }

    private int gcdDeQuy(int a, int b) {
        if (b == 0) return a;
        return gcdDeQuy(b, a % b);
    }

    private int gcdKhongDeQuy(int a, int b) {
        while (b != 0) {
            int tam = a % b;
            a = b;
            b = tam;
        }
        return a;
    }

    private void tinhLuyThua() {
        System.out.print("Nhập cơ số (x): ");
        int x = sc.nextInt();
        System.out.print("Nhập số mũ (n): ");
        int n = sc.nextInt();
        System.out.println("Lũy thừa đệ quy của " + x + "^" + n + " là: " + luyThuaDeQuy(x, n));
        System.out.println("Lũy thừa khử đệ quy của " + x + "^" + n + " là: " + luyThuaKhongDeQuy(x, n));
    }

    private int luyThuaDeQuy(int x, int n) {
        if (n == 0) return 1;
        return x * luyThuaDeQuy(x, n - 1);
    }

    private int luyThuaKhongDeQuy(int x, int n) {
        int ketQua = 1;
        for (int i = 0; i < n; i++) {
            ketQua *= x;
        }
        return ketQua;
    }


}
