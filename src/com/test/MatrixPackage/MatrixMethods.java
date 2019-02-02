package com.test.MatrixPackage;

public interface MatrixMethods {
    default public int[][] generateRandomMatrix(String dim)
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

    default public int[][] flipRelToMainDiag(int[][] m) {
        //flips matrix previously generated relative to main diagonal
        int[][] resultMatrix = new int[m.length][m[0].length];
        for (int i=0; i<m.length; i++)
        {
            for (int j=0; j<m[0].length; j++)
                resultMatrix[i][j] = m[j][i];
        }
        return resultMatrix;
    }

    default public int[][] flipRelToSecDiag(int[][] m)
    {
        //flip matrix previously generated relative to secondary diagonal
        int[][] resultMatrix=new int[m.length][m[0].length];
        for(int i=0; i<m.length; i++)
        {
            for(int j=0; j<m[0].length; j++)
                resultMatrix[i][j]=m[m[0].length-1-j][m.length-1-i];
        }
        return resultMatrix;
    }

    default public int[][] flipVertically(int[][] m)
    {
        //flips matrix previously generated vertically
        int[][] resultMatrix=new int[m.length][m[0].length];
        for(int i=0; i<m.length; i++)
        {
            for(int j=0; j<m[0].length; j++)
                resultMatrix[i][j]=m[i][m[0].length-1-j];
        }
        return resultMatrix;
    }

    default public int[][] flipHorizontally(int[][] m)
    {
        //flips matrix previously generated horizontally
        int[][] resultMatrix=new int[m.length][m[0].length];
        for(int i=0; i<m.length;i++)
        {
            for(int j=0; j<m[0].length; j++)
                resultMatrix[i][j]=m[m.length-1-i][j];
        }
        return resultMatrix;
    }

    default public void displayMatrix(int m[][])
    {
        for(int i=0; i<m.length; i++)
        {
            for(int j=0; j<m[0].length; j++)
                System.out.print(m[i][j]+"\t");
            System.out.println("");
        }
        System.out.println("");
    }

    default public int[][] userFlipMethod(int[][] m)
    {
        int[][] mr=new int[m.length][m[0].length];
        for(int i=0; i<m.length; i++)
            for(int j=0; j<m[0].length; j++)
                mr[i][j]=m[i][j];
        return mr;
    }
}
