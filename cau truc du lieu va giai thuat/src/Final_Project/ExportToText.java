package Final_Project;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ExportToText {

    // Phương thức xuất dữ liệu LinkedList ra file văn bản
    public void exportLinkedListToText(LinkedList list, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            Node currentNode = list.getHead();

            // Duyệt qua LinkedList và ghi mỗi node vào file
            while (currentNode != null) {
                writer.write(String.valueOf(currentNode.value));  // Ghi giá trị node vào file
                writer.newLine();  // Thêm dòng mới sau mỗi giá trị
                currentNode = currentNode.next; // Chuyển đến node tiếp theo
            }

            System.out.println("Tạo file văn bản thành công tại " + fileName);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file văn bản: " + e.getMessage());
        }
    }
    public void exportBinaryTreeToText(BinaryTree tree, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            List<Integer> values = tree.preOrder();

            // Duyệt qua danh sách và ghi vào file
            for (int value : values) {
                writer.write(String.valueOf(value));  // Ghi giá trị vào file
                writer.newLine();  // Thêm dòng mới sau mỗi giá trị
            }

            System.out.println("Tạo file văn bản thành công tại " + fileName);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file văn bản: " + e.getMessage());
        }
    }
}
