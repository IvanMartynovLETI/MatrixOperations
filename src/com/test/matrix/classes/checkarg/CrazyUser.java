package com.test.matrix.classes.checkarg;

import com.test.matrix.interfaces.MadUser;

public class CrazyUser implements MadUser {
    public int CheckUserInput(String InpStr)
    {
        int dimension;
        String StrToCmp="suxx";
        if(InpStr.equals(StrToCmp))//здесь я не ругаюсь по поводу пустого аргумента командной строки,
            dimension=0;           //я делал это раньше в методе CheckArgForEmpty
        else
        {
            try
            {
                dimension=Integer.parseInt(InpStr);
            }
            catch(NumberFormatException ex)
            {
                System.out.println("Input parameter for int CheckUserInput(String InpStr) is not an integer");
                System.out.println("0 as output parameter for this method generated");
                dimension=0;
            }
            //ок, пустой параметр, не целое число и не число мы отловили, что осталось?
            //мы предполагаем, что пользователь неадекватен и может передать ахинею
            //частные случаи ахинеи, а именно 0, 1 и отрицательные целые мы будем
            //отлавливать в методе GenerateRandomMatrix()
        }
        return dimension;
    }
}
