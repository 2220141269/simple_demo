package com.example.utils;

import com.example.entity.FsgXLS;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ReadFile {

    public static List<String> readerCSV(String filePath) {
        List<String> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));//换成你的文件名
            reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉
            String line = null;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                i++;

                list.add(line.replaceAll("\"","")+",#");

//                String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
//
//                String last = item[item.length-1];//这就是你要的数据了
//                //int value = Integer.parseInt(last);//如果是数值，可以转化为数值
//                System.out.println(last);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(String.format("从%s读取%s条记录",filePath,list.size()));
        return list;
    }

    public static List<FsgXLS> readerXLS(String filePath, int rowIndex) {
        List<FsgXLS> list = new ArrayList<>();
        int errorRow = 0;
        try {
            jxl.Workbook wb = null;
            InputStream is = new FileInputStream(filePath);
            wb = Workbook.getWorkbook(is);

            int sheetSize = wb.getNumberOfSheets();
            Sheet sheet = wb.getSheet(1);
            int row_total = sheet.getRows();
            for (int j = rowIndex; j < 6848; j++) {
                errorRow = j;

                Cell[] cells = sheet.getRow(j);
                FsgXLS xls = new FsgXLS();
                xls.setDataA(cells[0].getContents().replaceAll("\"",""));
                xls.setDataB(cells[1] .getContents().replaceAll("\"",""));
                xls.setDataC(cells[2] .getContents().replaceAll("\"",""));
                xls.setDataD(cells[3] .getContents().replaceAll("\"",""));
                xls.setDataE(cells[4] .getContents().replaceAll("\"",""));
                xls.setDataF(cells[5] .getContents().replaceAll("\"",""));
                xls.setDataG(cells[6] .getContents().replaceAll("\"",""));
                xls.setDataH(cells[7] .getContents().replaceAll("\"",""));
                xls.setDataI(cells[8] .getContents().replaceAll("\"",""));
                xls.setDataJ(cells[9] .getContents().replaceAll("\"",""));
                xls.setDataK(cells[10] .getContents().replaceAll("\"",""));
                xls.setDataL(cells[11] .getContents().replaceAll("\"",""));
                xls.setDataM(cells[12] .getContents().replaceAll("\"",""));
                xls.setDataN(cells[13] .getContents().replaceAll("\"",""));
                xls.setDataO(cells[14] .getContents().replaceAll("\"",""));
                xls.setDataP(cells[15] .getContents().replaceAll("\"",""));
                xls.setDataQ(cells[16] .getContents().replaceAll("\"",""));
                xls.setDataR(cells[17] .getContents().replaceAll("\"",""));
                xls.setDataS(cells[18] .getContents().replaceAll("\"",""));
                xls.setDataT(cells[19] .getContents().replaceAll("\"",""));
                list.add(xls);
            }
        } catch (IOException e) {
            System.out.println("errorRow="+errorRow);
            e.printStackTrace();
        } catch (BiffException e) {
            System.out.println("errorRow="+errorRow);
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("errorRow="+errorRow);
            e.printStackTrace();
        }
        System.out.println(String.format("从%s读取%s条记录",filePath,list.size()));
        return list;
    }


    public static List<String> readCSV2(String srcPath) {
        String charset = "utf-8";
        List<String> list = new ArrayList<>();
        try (CSVReader csvReader = new CSVReaderBuilder(new BufferedReader(new InputStreamReader(new FileInputStream(new File(srcPath)), charset))).build()) {
            Iterator<String[]> iterator = csvReader.iterator();
            int i = 0;
            String[] arr;
            while (iterator.hasNext()) {
                i++;
                if (i == 1){
                    iterator.next();
                    continue;
                }

                arr = iterator.next();
                StringBuilder sb = new StringBuilder();
                for (int j = 0;j<arr.length;j++){
                    sb.append(arr[j]+"#");
                }
                list.add(sb.toString()+"@");
                //System.out.println(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
