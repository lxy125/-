package test;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] tempArr={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0};
        Random random = new Random();
        for(int i= 0;i<tempArr.length;i++){
            int index = random.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }

        for(int i=0;i<tempArr.length;i++){
            System.out.println(tempArr[i]);
        }


        int[][] data = new int[4][4];
        int index = 0;
//遍历一维数组，将数据存入二维数组
//        for(int i =0 ;i<tempArr.length;i++){
//            data[i/4][i%4] = tempArr[i];
//        }
//遍历二维数组
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = tempArr[index];
                index++;
            }
            System.out.println();
        }

        for(int i =0;i< data.length;i++){
            for(int j = 0;j<data[i].length;j++){
                System.out.print(data[i][j]+" ");
            }
            System.out.println();
        }
    }
}
