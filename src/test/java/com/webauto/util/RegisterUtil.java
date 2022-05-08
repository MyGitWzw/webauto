package com.webauto.util;

import com.webauto.cases.RegisterCase;
import com.webauto.pojo.RegisterData;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2021/12/27 15:11
 */
public class RegisterUtil {
    public static List<RegisterData> registerDatas = new ArrayList<RegisterData>();

    static{
        List<RegisterData> list = ExcelUtil.load(PropertiesUtil.getFilePath("register.excel.path"), "Sheet1", RegisterData.class);
        registerDatas.addAll(list);
//        for (RegisterData regsiterData:registerDatas) {
//            System.out.println(regsiterData);
//        }
    }


    /**
     * 获取用例的数据
     * @param flag : 0 represents negative case,1 represents positive case
     * @param cellNames :
     * */
    public static Object[][] getDatas(String flag, String [] cellNames) {
        List<RegisterData> satisfied = new ArrayList<RegisterData>();
        // 先找出满足 Negative/Positive case 并 保存自 satisfied list 中
        for (RegisterData register: registerDatas){
            if(flag.equals(register.getIsNegative())){
                satisfied.add(register);
            }
        }

        // 将 satisfied List中的元素取出，放在 datas 二位数组中
        Class<RegisterData> clazz = RegisterData.class;
        Object[][] datas = new Object[satisfied.size()][cellNames.length];
        try {
            for (int i = 0;i<satisfied.size();i++) {
                RegisterData registerData = satisfied.get(i);

                for (int j = 0; j < cellNames.length ; j++) {
                    String colName = cellNames[j];
                    String methodName = "get"+colName;
                    Method method = clazz.getMethod(methodName);
                    String value = (String)method.invoke(registerData);
                    datas[i][j] = value;
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return datas;
    }


}
