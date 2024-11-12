package Final_Project;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelExporter {


    public void exportLinkedListToExcel(LinkedList list, String fileName) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Dữ Liệu LinkedList");

        // Tạo dòng tiêu đề
        Row headerRow = sheet.createRow(0);
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Giá trị");

        // Duyệt qua LinkedList và thêm mỗi node vào Excel
        Node currentNode = list.getHead();
        int rowNum = 1; // Bắt đầu từ dòng 2

        while (currentNode != null) {
            Row row = sheet.createRow(rowNum++);
            Cell cell = row.createCell(0);
            cell.setCellValue(currentNode.value);  // Thêm giá trị node vào file Excel
            currentNode = currentNode.next; // Chuyển đến node tiếp theo
        }

        // Ghi dữ liệu vào file
        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
            workbook.write(fileOut);
            System.out.println("Tạo file Excel thành công tại " + fileName);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file Excel: " + e.getMessage());
        }
    }


    public void exportBinaryTreeToExcel(BinaryTree tree, String fileName) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Dữ Liệu BinaryTree");

        // Tạo dòng tiêu đề
        Row headerRow = sheet.createRow(0);
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Giá trị");

        // Giả sử bạn có phương thức in-order traversal để lấy dữ liệu cây
        int rowNum = 1;
        for (int value : tree.preOrder()) {
            Row row = sheet.createRow(rowNum++);
            Cell cell = row.createCell(0);
            cell.setCellValue(value);
        }

        // Ghi dữ liệu vào file
        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
            workbook.write(fileOut);
            System.out.println("Tạo file Excel thành công tại " + fileName);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file Excel: " + e.getMessage());
        }
    }
}
