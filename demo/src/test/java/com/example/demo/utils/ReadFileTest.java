package com.example.demo.utils;

import com.example.entity.FsgXLS;
import com.example.utils.ReadFile;
import org.junit.Test;

import java.util.List;

public class ReadFileTest {

    @Test
    public void testReaderCSV() {
        String filePath = "E:\\work\\华润\\文档处理\\20200409\\新建文件夹\\fsg20200409-01.csv";
        List<String> list = ReadFile.readerCSV(filePath);
        for (String s : list) {
            System.out.println(s);

        }
    }

    @Test
    public void testeadCSV2() {
        String filePath = "E:\\work\\华润\\文档处理\\20200409\\新建文件夹\\fsg20200409-01.csv";
        ReadFile.readCSV2(filePath);
    }

    @Test
    public void testReadXLS() {
        String filePath = "E:\\work\\华润\\文档处理\\20200409\\新建文件夹\\2019年商户数据统计12.17.xls";
        List<FsgXLS> list = ReadFile.readerXLS(filePath, 2);
        int i = 0;
        for (FsgXLS s : list) {
            System.out.println(s);


        }
    }
}
