package com.webauto.cases;

import com.webauto.util.LoginUtil;
import org.testng.annotations.Test;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2021/12/28 16:42
 */
public class LoginCase extends Base {

    @Test(dataProvider = "negativeDatas")
    public void testNegativeCases(String mobilePhone,String password, String expected){


    }

    public Object[][] negativeDatas(){
        String [] cellNames = {"MobilePhone","Password","ErrorMsg"};
        Object[][] datas = LoginUtil.getDatas("0", cellNames);
        return datas;
    }
}
