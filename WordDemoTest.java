package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;

public class WordDemoTest {

    public static void main(String[] args) throws Exception {
        XWPFDocument xdoc = new XWPFDocument();
      //创建表格对象(一个8行5列的表格)
        XWPFTable xTable = xdoc.createTable(8, 5);
      //得到Table的CTTblPr,不存在则新建
        CTTbl ttbl = xTable.getCTTbl();
        //表格属性 
        CTTblPr tblPr = ttbl.getTblPr() == null ? ttbl.addNewTblPr() : ttbl.getTblPr();
        //设置表格宽度
        CTTblWidth tblWidth = tblPr.isSetTblW() ? tblPr.getTblW() : tblPr.addNewTblW();
        tblWidth.setW(new BigInteger("9600"));
        //获取表格第一行（从0开始）
        XWPFTableRow row = null;
        row = xTable.getRow(0);
        //设置行高
        row.setHeight(100);
        //获取表格的单元格（第一行的第一个，从0开始）
        XWPFTableCell cell = null;
        cell = row.getCell(0);
        //设置内容（也可以使用cell.setParagraph(XWPFParagraph p),单元格里添加一个段落，更易于设置样式）
        cell.setText("内容");

        OutputStream out = null;
        try {
            File word = new File("D:\\33.docx");
           out = new FileOutputStream(word);
           xdoc.write(out);
           out.flush();
           out.close();
        } catch (IOException e) {
           e.printStackTrace();
        }
        xdoc.close();
    }
}
