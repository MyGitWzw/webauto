package com.webauto.util;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * 实现从excel中读取数据的功能
 *
 * @Author: Wzw
 * @Date: 2021/7/27 21:36
 */
public class ExcelUtil {

    public static <T> List<T> load(String filePath, String sheetName, Class<T> clazz) {
//        Class clazz = Case.class;//反射得到 class 对象
        List<T> lists = new ArrayList<T>();
        try {
            Workbook wb = WorkbookFactory.create(new File(filePath));
            Sheet sheet = wb.getSheet(sheetName);

            //使用反射读取列名
            Row headerRow = sheet.getRow(0);
            short lastCellNum = headerRow.getLastCellNum();//lastCellNum - 1 = index

            // 循环处理第一行的各列，取出每一列的字段名保存到数组
            String[] headers = new String[lastCellNum];
            for (int i = 0; i < lastCellNum; i++) {
                Cell cell = headerRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                cell.setCellType(CellType.STRING);
                String oneOfHeaderCell = cell.getStringCellValue();
//                System.out.println(oneOfHeaderCell);
                String headerCol = oneOfHeaderCell.substring(0, oneOfHeaderCell.indexOf("("));
//                System.out.println(headers);
                headers[i] = headerCol;
            }

            int lastRowIndex = sheet.getLastRowNum();//返回行索引 index
            //循环处理每一个数据行
            for (int i = 1; i <= lastRowIndex; i++) {

//                Case cs = (Case) clazz.newInstance();
                T object = clazz.newInstance();

                //拿到一个数据行
                Row dataRow = sheet.getRow(i);
                //拿到此数据行上的每一列,反射获取方法名
                for (int j = 0; j < lastCellNum; j++) {
                    Cell cell = dataRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    cell.setCellType(CellType.STRING);
                    String value = cell.getStringCellValue();
                    //获取要反射的方法名
                    String methodName = "set" + headers[j];
                    Method method = clazz.getMethod(methodName, String.class);
                    method.invoke(object, value);
                }

                lists.add(object);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return lists;
    }

}
