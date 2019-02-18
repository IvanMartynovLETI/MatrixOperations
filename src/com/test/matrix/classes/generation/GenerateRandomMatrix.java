package com.test.matrix.classes.generation;

import com.test.matrix.interfaces.GenerateMatrix;

public class GenerateRandomMatrix implements GenerateMatrix {
    private int dim = 0;
    private boolean generationOK = false;


    public GenerateRandomMatrix(int i) {
        if(i == 0) {
            generationOK = false;
            throw new IllegalArgumentException("Empty array, constructor of GenerateRandomMatrix class failed");
        }
        else if (i < 0) {
            generationOK = false;
            throw new IllegalArgumentException("Dimension must be positive, " +
                    " constructor of GenerateRandomMatrix class failed");
        }
        else if (i < 2 || i > 100) {
            generationOK = false;
            throw new IllegalArgumentException("Dimension must be in range from 2 to 100, " +
                    "constructor of GenerateRandomMatrix class failed");
        }
        else{
            dim = i;
            generationOK = true;
        }
    }

    public int[][] generateMatrix(){
        try {
            if( (dim == 0) && (generationOK==false)) throw new IllegalArgumentException("Incorrect dimension value " +
                    " in generateMatrix() method received");
            int[][] randMatrix;
            randMatrix=new int[dim][dim];

            for(int i=0; i<dim; i++)
                for(int j=0; j<dim; j++){
                    if(generationOK)
                        randMatrix[i][j]=(int)(Math.random()*100);
                    else
                        randMatrix[i][j]=0;
                }


            return randMatrix;
        } catch (IllegalArgumentException e) {
            System.out.println(" Incorrect dimension value");
            throw new IllegalArgumentException("Incorrect dimension value in generateMatrix() method received");
        }
    }

    public String getDescription(){
        return "int[][] generateMatrix(int dim) method of GenerateRandomMatrix class\n" +
                "creates square random matrix dimension of dim,\n" +
                "dim parameter must be positive integer greater than 1.";
    }


}