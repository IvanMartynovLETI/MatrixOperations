package com.test.matrix.classes.checkarg;

public class ArgCheck {

    public String checkForEmpty (String[] strArr)
    {
        String outStr;

        if (strArr.length == 0)
        {
            System.out.println ("Command line parameter is empty.");
            outStr = "suxx";
        }
        else
            outStr = strArr[0];
        return outStr;
    }
}
