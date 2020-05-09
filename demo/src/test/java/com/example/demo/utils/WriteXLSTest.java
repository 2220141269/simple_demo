package com.example.demo.utils;

import com.example.entity.*;
import com.example.utils.DateUtils;
import com.example.utils.ReadFile;
import com.example.utils.WriteXLS;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WriteXLSTest {

    @Test
    public void testWrite() {
        String filePathSrc = "E:\\work\\华润\\文档处理\\20200409\\新建文件夹\\2019年商户数据统计12.17.xls";
        List<FsgXLS> list = ReadFile.readerXLS(filePathSrc, 2);
        String filePathDist = "E:\\work\\华润\\文档处理\\20200409\\新建文件夹\\2019年商户数据统计12.17_dist.xls";
        WriteXLS.write(filePathDist, list);

    }


    @Test
    public void testFileHandle() {
        /*String filePathSrc = "E:\\work\\华润\\文档处理\\20200409\\新建文件夹\\2019年商户数据统计12.17.xls";
        List<FsgXLS> list = ReadFile.readerXLS(filePathSrc, 2);*/

        List<FsgXLS> list = new ArrayList<>();

        String filePathSrc1 = "E:\\work\\华润\\文档处理\\20200409\\新建文件夹\\fsg20200409-01.csv";
        List<String> list1 = ReadFile.readCSV2(filePathSrc1);
        handleCSV01(list, list1);

        String filePathSrc2 = "E:\\work\\华润\\文档处理\\20200409\\新建文件夹\\fsg20200409-02.csv";
        List<String> list2 = ReadFile.readCSV2(filePathSrc2);
        handleCSV02(list, list2);

        String filePathSrc3 = "E:\\work\\华润\\文档处理\\20200409\\新建文件夹\\fsg20200409-03.csv";
        List<String> list3 = ReadFile.readCSV2(filePathSrc3);
        handleCSV03(list, list3);

        String filePathSrc4 = "E:\\work\\华润\\文档处理\\20200409\\新建文件夹\\fsg20200409-04.csv";
        List<String> list4 = ReadFile.readCSV2(filePathSrc4);
        handleCSV04(list, list4);

        String filePathSrc5 = "E:\\work\\华润\\文档处理\\20200409\\新建文件夹\\fsg20200409-05.csv";
        List<String> list5 = ReadFile.readCSV2(filePathSrc5);
        handleCSV05(list, list5);

        String filePathSrc6 = "E:\\work\\华润\\文档处理\\20200409\\新建文件夹\\fsg20200409-06.csv";
        List<String> list6 = ReadFile.readCSV2(filePathSrc6);
        handleCSV06(list, list6);

        String filePathSrc7 = "E:\\work\\华润\\文档处理\\20200409\\新建文件夹\\fsg20200409-07.csv";
        List<String> list7 = ReadFile.readCSV2(filePathSrc7);
        handleCSV07(list, list7);

        String filePathSrc8 = "E:\\work\\华润\\文档处理\\20200409\\新建文件夹\\fsg20200409-08.csv";
        List<String> list8 = ReadFile.readCSV2(filePathSrc8);
        handleCSV08(list, list8);


        String filePathDist = "E:\\work\\华润\\文档处理\\20200409\\新建文件夹\\2019年商户数据统计12.17_dist.xls";
        WriteXLS.write(filePathDist, list);
    }


    public static void handleCSV01(List<FsgXLS> fsgXLSlist, List<String> CSVlist1) {
        //获取csv数据
        int i = 0;
        for (String str : CSVlist1) {
            String[] arr = str.split("#");
            i++;
            System.out.println("index=" + i);
            FsgXLS xls = new FsgXLS();
            xls.setDataA(arr[0]);//行社ID
            xls.setDataB(arr[1]);//所属馆
            xls.setDataC(arr[2]);//店铺ID
            xls.setDataD(arr[3]);//店铺名称
            xls.setDataE(arr[4]);//注册时间
            xls.setDataN(arr[5]);//最后登录时间
            xls.setDataG(arr[7]);//在售商品总数
            xls.setDataT("0");//当月平均发货时间
            fsgXLSlist.add(xls);
        }

    }

    public static void handleCSV02(List<FsgXLS> fsgXLSlist, List<String> CSVlist1) {
        int i = 0;
        Map<String, FsgCVS2> map = new HashMap<>();
        for (String s : CSVlist1) {
            i++;
            System.out.println("index=" + i);
            String[] arr = s.split("#");
            if (map.containsKey(arr[1])) {
                FsgCVS2 cvs = map.get(arr[1]);
                cvs.setCatname(cvs.getCatname() + "," + arr[2]);
            } else {
                FsgCVS2 cvs = new FsgCVS2();
                cvs.setShopid(arr[1]);
                cvs.setCatname(arr[2]);
                map.put(cvs.getShopid(), cvs);
            }
        }

        for (FsgXLS xls : fsgXLSlist) {
            if (map.containsKey(xls.getDataC())) {
                xls.setDataF(map.get(xls.getDataC()).getCatname());//主营类目
            }
        }

    }

    public static void handleCSV03(List<FsgXLS> fsgXLSlist, List<String> CSVlist1) {
        int i = 0;
        Map<String, FsgCVS3> map = new HashMap<>();
        for (String s : CSVlist1) {
            i++;
            System.out.println("index=" + i);
            String[] arr = s.split("#");
            FsgCVS3 cvs = new FsgCVS3();
            cvs.setShopid(arr[0]);
            cvs.setCountOrderid(arr[3]);
            cvs.setSumPayprice(arr[4]);
            cvs.setCountDistinctBuyerid(arr[5]);
            map.put(cvs.getShopid(), cvs);
        }

        for (FsgXLS xls : fsgXLSlist) {
            if (map.containsKey(xls.getDataC())) {
                xls.setDataH(map.get(xls.getDataC()).getCountOrderid());//成功交易订单总笔数
                xls.setDataI(map.get(xls.getDataC()).getSumPayprice());//成功交易订单总金额
                xls.setDataJ(map.get(xls.getDataC()).getCountDistinctBuyerid());//成功交易总客户数（去重）
            }
        }
    }


    public static void handleCSV04(List<FsgXLS> fsgXLSlist, List<String> CSVlist1) {
        int i = 0;
        Map<String, FsgCVS4> map = new HashMap<>();
        for (String s : CSVlist1) {
            i++;
            System.out.println("index=" + i);
            String[] arr = s.split("#");
            FsgCVS4 cvs = new FsgCVS4();
            cvs.setShopid(arr[0]);
            cvs.setSumGoodsnum(arr[2]);
            map.put(cvs.getShopid(), cvs);
        }

        for (FsgXLS xls : fsgXLSlist) {
            if (map.containsKey(xls.getDataC())) {
                xls.setDataK(map.get(xls.getDataC()).getSumGoodsnum());//成功交易商品总件数
            }
        }
    }

    public static void handleCSV05(List<FsgXLS> fsgXLSlist, List<String> CSVlist1) {
        int i = 0;
        Map<String, FsgCVS5> map = new HashMap<>();
        for (String s : CSVlist1) {
            i++;
            System.out.println("index=" + i);
            String[] arr = s.split("#");
            FsgCVS5 cvs = new FsgCVS5();
            cvs.setShopid(arr[0]);
            cvs.setCountOrderid(arr[3]);
            cvs.setSumPayprice(arr[4]);
            map.put(cvs.getShopid(), cvs);
        }

        for (FsgXLS xls : fsgXLSlist) {
            if (map.containsKey(xls.getDataC())) {
                xls.setDataL(map.get(xls.getDataC()).getCountOrderid());//全部退款订单笔数
                xls.setDataM(map.get(xls.getDataC()).getSumPayprice());//全部退款订单金额
            }
        }
    }

    public static void handleCSV06(List<FsgXLS> fsgXLSlist, List<String> CSVlist1) {
        int i = 0;
        Map<String, FsgCVS6> map = new HashMap<>();
        for (String s : CSVlist1) {
            i++;
            System.out.println("index=" + i);
            String[] arr = s.split("#");
            if (map.containsKey(arr[1])) {
                FsgCVS6 entity = map.get(arr[1]);
                if (StringUtils.isNotBlank(arr[2])) {
                    if (StringUtils.isBlank(entity.getModifydatetime()) || DateUtils.strToDate(entity.getModifydatetime()).getTime() < DateUtils.strToDate(arr[2]).getTime()) {
                        entity.setModifydatetime(arr[2]);//修改时间
                    }
                }

                if (StringUtils.isNotBlank(arr[3])) {
                    if (StringUtils.isBlank(entity.getUptime()) || DateUtils.strToDate(entity.getUptime()).getTime() < DateUtils.strToDate(arr[3]).getTime()) {
                        entity.setUptime(arr[3]);//上架时间
                    }
                }

                if (StringUtils.isNotBlank(arr[5])) {
                    if (StringUtils.isBlank(entity.getLastsaledatetime()) || DateUtils.strToDate(entity.getLastsaledatetime()).getTime() < DateUtils.strToDate(arr[5]).getTime()) {
                        entity.setLastsaledatetime(arr[5]);//最后一次销售时间
                    }
                }
            } else {
                FsgCVS6 entity = new FsgCVS6();
                entity.setShopid(arr[1]);
                entity.setModifydatetime(arr[2]);//修改时间
                entity.setUptime(arr[3]);//上架时间
                entity.setLastsaledatetime(arr[5]);//最后一次销售时间
                map.put(entity.getShopid(), entity);
            }
        }

        for (FsgXLS xls : fsgXLSlist) {
            if (map.containsKey(xls.getDataC())) {
                xls.setDataO(map.get(xls.getDataC()).getModifydatetime());//修改时间
                xls.setDataP(map.get(xls.getDataC()).getUptime());//最后一次上架商品时间
                xls.setDataQ(map.get(xls.getDataC()).getLastsaledatetime());//最后一次交易订单时间
            }
        }
    }


    public static void handleCSV07(List<FsgXLS> fsgXLSlist, List<String> CSVlist1) {
        int i = 0;
        Map<String, String> map = new HashMap<>();
        for (String s : CSVlist1) {
            i++;
            System.out.println("index=" + i);
            String[] arr = s.split("#");
            if (map.containsKey(arr[1])) {
                map.put(arr[1], String.valueOf(Integer.valueOf(map.get(arr[1])) + 1));
            } else {
                map.put(arr[1], "1");
            }
        }

        for (FsgXLS xls : fsgXLSlist) {
            if (map.containsKey(xls.getDataC())) {
                xls.setDataR(map.get(xls.getDataC()));//营销工具使用次数（满减、券、专题
            }
        }
    }


    public static void handleCSV08(List<FsgXLS> fsgXLSlist, List<String> CSVlist1) {
        int i = 0;
        Map<String, String> map = new HashMap<>();
        for (String s : CSVlist1) {
            i++;
            System.out.println("index=" + i);
            String[] arr = s.split("#");
            String countt = StringUtils.isNotBlank(arr[3]) && Double.valueOf(arr[3]) >= 15 ? "14" : arr[3];
            map.put(arr[0], countt);

        }

        for (FsgXLS xls : fsgXLSlist) {
            if (map.containsKey(xls.getDataC())) {
                xls.setDataS(map.get(xls.getDataC()));//当月平均发货时间

            }
        }
    }
}
