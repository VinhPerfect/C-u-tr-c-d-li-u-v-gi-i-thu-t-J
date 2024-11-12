package Final_Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseConnection {
    // Thông tin kết nối đến cơ sở dữ liệu
    private static final String URL = "jdbc:mysql://localhost:3306/cau truc du lieu va giai thuat";
    private static final String USER = "root";
    private static final String PASSWORD = "new_password";

    private Connection conn;

    // Phương thức mở kết nối
    public void connect() {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Kết nối thành công đến MySQL.");
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối: " + e.getMessage());
        }
    }


    public void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Đã đóng kết nối MySQL.");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi đóng kết nối: " + e.getMessage());
        }
    }


    public void getElementsFromDatabaseBinaryTree(BinaryTree tree) {
        connect();
        try {
            String query = "SELECT * FROM binarytree";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);


            while (rs.next()) {
                int phantu1 = rs.getInt("phan tu 1");
                int phantu2 = rs.getInt("phan tu 2");
                int phantu3 = rs.getInt("phan tu 3");
                int phantu4 = rs.getInt("phan tu 4");
                tree.insert(phantu1);
                tree.insert(phantu2);
                tree.insert(phantu3);
                tree.insert(phantu4);
            }

            rs.close();
            stmt.close();
            System.out.println("Lấy dữ liệu thành công từ MySQL.");
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn dữ liệu: " + e.getMessage());
        } finally {
            close();
        }
    }
    public void getElementsFromDatabaseLinkedList(LinkedList list){
        connect();
        try {
            String query = "SELECT * FROM linkedlist";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int phantu1 = rs.getInt("phan tu 1");
                int phantu2 = rs.getInt("phan tu 2");
                int phantu3 = rs.getInt("phan tu 3");
                int phantu4 = rs.getInt("phan tu 4");
                list.chenVaoCuoiDanhSachLienKetDon(phantu1);
                list.chenVaoCuoiDanhSachLienKetDon(phantu2);
                list.chenVaoCuoiDanhSachLienKetDon(phantu3);
                list.chenVaoCuoiDanhSachLienKetDon(phantu4);
                list.chenVaoCuoiDanhSachLienKetDoi(phantu1);
                list.chenVaoCuoiDanhSachLienKetDoi(phantu2);
                list.chenVaoCuoiDanhSachLienKetDoi(phantu3);
                list.chenVaoCuoiDanhSachLienKetDoi(phantu4);
            }

            rs.close();
            stmt.close();
            System.out.println("Lấy dữ liệu thành công từ MySQL.");
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn dữ liệu: " + e.getMessage());
        } finally {
            close();
        }
    }
}
