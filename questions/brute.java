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
public class brute {
    
    int MAX_M = 6;
    int MAX_N = 6;
    
    int subdivisionCost = 50;
    int count = 0;
    ArrayList<Integer> prices;
    
    int[][] priceArray = new int[MAX_M + 1][MAX_N + 1];

    public brute() {
        this.prices = new ArrayList<>();
    }
    
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
    
    public int brute(int x, int y){
        int max = 0;
        if (x > 0 && y > 0){
            bruteHelper(x, y, 0, 0);
        }
        //System.out.println(prices.size());
        for (int i = 0; i < prices.size(); i++) {
            System.out.println(prices.get(i));
            if( prices.get(i) > max){
                max = prices.get(i);
            }
        }
        System.out.println(max);
        return max;
    }
    
    public void bruteHelper(int x, int y, int current, int prior){
        int temp =  priceArray[x][y];
        prices.add(current + temp + prior);
        for(int i = 1; i <=  (y - 1); i++){
            bruteHelper(x, (y - i), ((priceArray[x][i])) - (subdivisionCost * x), current);
        }
        
        for(int j = 1; j <=  (x - 1); j++){
            bruteHelper((x - j), y, ((priceArray[j][y])) - (subdivisionCost * y), current);
        }
    }
    
    public static void main(String[] args) {
        brute test = new brute();
        test.intializeArray();
        test.brute(6, 6);
    }
}
