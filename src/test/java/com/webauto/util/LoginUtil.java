package com.webauto.util;

import com.webauto.pojo.LoginData;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2021/12/27 15:11
 */
public class LoginUtil {
    public static List<LoginData> loginDatas = new ArrayList<LoginData>();

    static {
        List<LoginData> list = ExcelUtil.load(PropertiesUtil.getFilePath("login.excel.path"), "Sheet1", LoginData.class);
        loginDatas.addAll(list);
    }


    /**
     * 获取用例的数据
     * @param flag : 0 represents negative case,1 represents positive case
     * @param cellNames :
     * */
    public static Object[][] getDatas(String flag, String [] cellNames) {
        List<LoginData> satisfied = new ArrayList<LoginData>();
        // 先找出满足 Negative/Positive case 并 保存自 satisfied list 中
        for (LoginData login: loginDatas){
            if(flag.equals(login.getIsNegative())){
                satisfied.add(login);
            }
        }

        // 将 satisfied List中的元素取出，放在 datas 二位数组中
        Object[][] datas = new Object[satisfied.size()][cellNames.length];
        Class<LoginData> clazz = LoginData.class;
        try {
            for (int i = 0;i<satisfied.size();i++) {
                LoginData loginData = satisfied.get(i);

                for (int j = 0; j < cellNames.length ; j++) {
                    String colName = cellNames[j];
                    String methodName = "get"+colName;
                    Method method = clazz.getMethod(methodName);
                    String value = (String)method.invoke(loginData);
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
