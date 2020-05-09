package com.example.utils;

import com.example.entity.FsgXLS;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WriteXLS {

    public static void write(String filePath, List<FsgXLS> list) {
        FileInputStream fs;
        try {
            fs = new FileInputStream(filePath);
            POIFSFileSystem ps = new POIFSFileSystem(fs); //使用POI提供的方法得到excel的信息
            HSSFWorkbook wb = new HSSFWorkbook(ps);
            HSSFSheet sheet = wb.getSheetAt(1); //获取到工作表，因为一个excel可能有多个工作表
            HSSFRow row = sheet.getRow(0);

            //分别得到最后一行的行号，和一条记录的最后一个单元格
            FileOutputStream out = new FileOutputStream(filePath); //向d://test.xls中写数据
            for (int i = 0 ;i < list.size();i++){
                FsgXLS fsgXLS = list.get(i);

                row = sheet.createRow(i+2); //在现有行号后追加数据
                row.createCell(0).setCellValue( fsgXLS.getDataA()); //设置第一个（从0开始）单元格的数据
                row.createCell(1).setCellValue(fsgXLS.getDataB() ); //设置第二个（从0开始）单元格的数据
                row.createCell(2).setCellValue(fsgXLS.getDataC() ); //设置第二个（从0开始）单元格的数据
                row.createCell(3).setCellValue( fsgXLS.getDataD()); //设置第二个（从0开始）单元格的数据
                row.createCell(4).setCellValue( fsgXLS.getDataE()); //设置第二个（从0开始）单元格的数据
                row.createCell(5).setCellValue( fsgXLS.getDataF()); //设置第二个（从0开始）单元格的数据
                row.createCell(6).setCellValue( fsgXLS.getDataG()); //设置第二个（从0开始）单元格的数据
                row.createCell(7).setCellValue( fsgXLS.getDataH()); //设置第二个（从0开始）单元格的数据
                row.createCell(8).setCellValue( fsgXLS.getDataI());
                row.createCell(9).setCellValue( fsgXLS.getDataJ()); //设置第二个（从0开始）单元格的数据
                row.createCell(10).setCellValue(fsgXLS.getDataK() ); //设置第二个（从0开始）单元格的数据
                row.createCell(11).setCellValue(fsgXLS.getDataL() ); //设置第二个（从0开始）单元格的数据
                row.createCell(12).setCellValue(fsgXLS.getDataM() ); //设置第二个（从0开始）单元格的数据
                row.createCell(13).setCellValue( fsgXLS.getDataN()); //设置第二个（从0开始）单元格的数据
                row.createCell(14).setCellValue(fsgXLS.getDataO() ); //设置第二个（从0开始）单元格的数据
                row.createCell(15).setCellValue(fsgXLS.getDataP() ); //设置第二个（从0开始）单元格的数据
                row.createCell(16).setCellValue( fsgXLS.getDataQ()); //设置第二个（从0开始）单元格的数据
                row.createCell(17).setCellValue( fsgXLS.getDataR()); //设置第二个（从0开始）单元格的数据
                row.createCell(18).setCellValue(fsgXLS.getDataS() );
                row.createCell(19).setCellValue(fsgXLS.getDataT() );

            }

            out.flush();
            wb.write(out);
            out.close();
            System.out.println(row.getPhysicalNumberOfCells() + " " + row.getLastCellNum());
            System.out.println(String.format("将%s条记录写入%s",list.size(),filePath));
        } catch (
                IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } //获取d://test.xls
    }

}
