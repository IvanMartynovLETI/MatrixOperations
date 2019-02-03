package com.test.MatrixPackage;

public class GenerateRandomMatrix implements GenerateMatrix{
    public int[][] GenMatrixMethod(String dim)
    {
        int dimension;
        boolean flag=true;
        int[][] randMatrix;
        try
        {
            dimension=Integer.parseInt(dim);
        }
        catch(NumberFormatException ex) {

            System.out.println("Input parameter is not an integer. Random matrix has not been created.");
            System.out.println("Abnormal program termination");
            flag=false;
            dimension = 2;
        }

        if(dimension<0)
        {
            System.out.println("Input parameter is integer, but not positive. Random matrix has not been created.");
            System.out.println("Abnormal program termination");
            flag=false;
            dimension=2;
        }

        else if(dimension==1)
        {
            System.out.println("Input parameter must be more than 1. Random matrix has not been created.");
            System.out.println("Abnormal program termination");
            flag=false;
            dimension=2;
        }

        randMatrix=new int[dimension][dimension];

        for(int i=0; i<dimension; i++)
            for (int j=0; j<dimension; j++)
            {
                if(flag)
                    randMatrix[i][j]=(int)(Math.random()*100);
                else
                    randMatrix[i][j]=0;
            }
        return randMatrix;
    }
}
