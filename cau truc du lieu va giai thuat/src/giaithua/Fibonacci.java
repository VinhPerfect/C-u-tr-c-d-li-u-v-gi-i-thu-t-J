package giaithua;

public class Fibonacci {
    public static int fibonacci(int n) {
        // Xử lý trường hợp đầu vào không hợp lệ
        if (n <= 0) {
            throw new IllegalArgumentException("n phải lớn hơn 0");
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        // Khởi tạo hai số đầu tiên trong dãy Fibonacci
        int a = 1; // F(1)
        int b = 1; // F(2)
        int result = 0;

        // Tính F(n) bằng cách sử dụng vòng lặp
        for (int i = 3; i <= n; i++) {
            result = a + b; // F(n) = F(n-1) + F(n-2)
            a = b; // Cập nhật F(n-2)
            b = result; // Cập nhật F(n-1)
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 10; // Ví dụ: Tính số Fibonacci thứ 10
        System.out.println("F(" + n + ") = " + fibonacci(n));
    }
}
