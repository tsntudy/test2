package simpleCalc;

import java.util.Scanner;

public class simpleCalc {

    public static void main(String args[]){

        double number1 = 0;      /* １つ目の数字 */
        double number2 = 0;      /* ２つ目の数字 */
        String str1;           /* キーボードから入力される1つ目の数字 */
        String str2;           /* キーボードから入力される2つ目の数字 */
        String calc;           /* 演算子を格納 */
    	double result = 0;     /* 結果を格納   */
        long number_max = 999999999;
        long number_min = -999999999;

        Scanner scan = new Scanner(System.in);
        
        System.out.print("計算式を入力して下さい:");

        /* Comment １つ目の入力された数字 */
        str1 = scan.next();
        /* Comment 入力された演算子 */
        calc = scan.next();
        /* Comment ２つ目の入力された数字 */
        str2 = scan.next();

        /* Comment 数字1, 数字2の例外チェックを実施 */
        try{
            number1 = Double.parseDouble(str1);
            number2 = Double.parseDouble(str2);
        }catch(NumberFormatException e){
            errDisp("引数エラー：[数字1]または[数字2]に数値でない値が入力されています");
        }

        /* Comment 最大値、最小値のチェック */
        if((number1 > number_max) || (number2 > number_max)){
            errDisp("引数エラー：[数字1]または[数字2]が最大値よりも大きい値です");
        }
        if((number1 < number_min) || (number2 < number_min)){
            errDisp("引数エラー：[数字1]または[数字2]が最小値よりも小さい値です");
        }

        /* Comment 演算子の種類を定義 */
        String calcStr[] = {"*", "/", "+", "-", "%"};

    	/* Comment エラーフラグの初期状態を"true"(エラーあり)としておく */
        boolean errFlag = true;

        /* Comment 演算子の例外チェックを実施 */
        for (int i = 0 ; i < 5 ; i++){
            /* Comment 演算子文字列の比較を実施 */
            if (calc.equals(calcStr[i])){
            	/* Comment 演算子文字列が一致した場合はエラーフラグを"false"(エラーなし)とする */
                errFlag = false;
            }
        }

        /* Comment 演算子の例外チェックでエラーが発生しているかチェック */
        if (errFlag == true){
            errDisp("引数エラー：[演算子]は * / + - % の5つです");
        }

        /* Comment 演算子をチェックして演算を実施 */
        if (calc.equals("*")){
            result = number1 * number2;
        }else if (calc.equals("+")){
            result = number1 + number2;
        }else if (calc.equals("-")){
            result = number1 - number2;
        }else{
            /* Comment ０除算はエラーとする */
            if (number2 == 0){
                errDisp("引数エラー：[数字2]が0の為、0 で割ろうとしました");
            }
            /* Comment 除余算の追加 */
            if(calc.equals("/")){
                result = number1 / number2;
            }else{
                result = number1 % number2;
            }
        }

        System.out.println("入力された式は " + number1 + " " + calc + " " + number2 + " です");
        System.out.println("計算結果は " + result + " です");

        scan.close();
    }

    private static void errDisp(String errStr){
            System.out.println("Usage : java dentaku 数値 演算子 数値");
            System.out.println(errStr);
            System.exit(0);  /* プログラムを終了する */
    }
}
