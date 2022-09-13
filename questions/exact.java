/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questions;

import java.util.ArrayList;

/**
 *
 * @author kelly
 */
public class exact {
    
    ArrayList<Integer> prices;
    int[][] priceArray = new int[7][7];
    int[][] storageArray = new int[7][7];
    int subdivisionCost = 50;
    int temp;
    
    void intializeArray(){
        priceArray[0][0] = 0;
        priceArray[0][1] = 0;
        priceArray[0][2] = 0;
        priceArray[0][3] = 0;
        priceArray[0][4] = 0;
        priceArray[0][5] = 0;
        priceArray[0][6] = 0;
        priceArray[1][0] = 0;
        priceArray[1][1] = 20;
        priceArray[1][2] = 40;
        priceArray[1][3] = 100;
        priceArray[1][4] = 130;
        priceArray[1][5] = 150;
        priceArray[1][6] = 200;
        priceArray[2][0] = 0;
        priceArray[2][1] = 40;
        priceArray[2][2] = 140;
        priceArray[2][3] = 250;
        priceArray[2][4] = 320;
        priceArray[2][5] = 400;
        priceArray[2][6] = 450;
        priceArray[3][0] = 0;
        priceArray[3][1] = 100;
        priceArray[3][2] = 250;
        priceArray[3][3] = 350;
        priceArray[3][4] = 420;
        priceArray[3][5] = 450;
        priceArray[3][6] = 500;
        priceArray[4][0] = 0;
        priceArray[4][1] = 130;
        priceArray[4][2] = 320;
        priceArray[4][3] = 420;
        priceArray[4][4] = 500;
        priceArray[4][5] = 600;
        priceArray[4][6] = 700;
        priceArray[5][0] = 0;
        priceArray[5][1] = 150;
        priceArray[5][2] = 400;
        priceArray[5][3] = 450;
        priceArray[5][4] = 600;
        priceArray[5][5] = 700;
        priceArray[5][6] = 800;
        priceArray[6][0] = 0;
        priceArray[6][1] = 200;
        priceArray[6][2] = 450;
        priceArray[6][3] = 500;
        priceArray[6][4] = 700;
        priceArray[6][5] = 800;
        priceArray[6][6] = 900;
    }
    
    
    public void exact(int x, int y){
        if(x < y){
            int tempX;
            tempX = x;
            x = y;
            y = tempX;
        }
        
        for(int i = 1; i <=  y; i++){
            for(int j = 1; j <=  x; j++){
                if(j < i){
                    storageArray[j][i] = storageArray[i][j];
                    System.out.println(storageArray[j][i] + "(" + j + "," + i + ")");
                }else{
                    int tempPrice;
                    tempPrice = priceArray[j][i];
                    temp = j - 1;
                    
                    while(temp > (j/2 - 1 + j%2) && temp > 0){
                        if(tempPrice < (storageArray[temp][i] - subdivisionCost * i + storageArray[j - temp][i])){
                            tempPrice = storageArray[temp][i] - subdivisionCost * i + storageArray[j - temp][i];
                            
                        }else if(tempPrice == storageArray[temp][i] - subdivisionCost * i + storageArray[j - temp][i]){
                            System.out.println("HEREHEREHERE");
                        }
                        temp -= 1;
                    }
                    System.out.println(tempPrice + "(" + j + "," + i + ")");
                    storageArray[j][i] = tempPrice;
                }
            }
        }
        System.out.println(storageArray[x][y]);
    }
    
    public static void main(String[] args) {
        exact test = new exact();
        test.intializeArray();
        test.exact(6, 6);
    }
}
