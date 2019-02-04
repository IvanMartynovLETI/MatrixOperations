package com.test.matrix.classes.checkarg;

import com.test.matrix.interfaces.CheckArgForEmpty;

public class ArgCheck implements CheckArgForEmpty {
    public String isEmpty(String[] strArr)
    {
        String outStr;
        if(strArr.length==0)
        {
            System.out.println("Input parameter is empty.");
            outStr="suxx";
        }
        else
            outStr=strArr[0];
        return outStr;
    }
}
