package com.company;

import java.util.Random;

public class GeneratorSimpleNumber {
    private static int number;
    private static String Strnumber;
    private static boolean[] arraySimple;
    private static int num;
    private static Eratosfen eratosfen=new Eratosfen(2000);
    private static Random random = new Random();

    private static void GenerateNumber(){
        number=random.nextInt((2001 - 1) + 1) + 1;
    }

    private static String toBinary(){
        GenerateNumber();
        String str = "";
        StringBuffer sb = new StringBuffer(str);
        while (number>0){
            int num = number%2;
            sb.append(num);
            number = number/2;
        }
        sb.reverse();
        return String.valueOf(sb);
    }

    private static int PreobrazToSimple(){
        int num;
        int u;
        int j = 0;
        Strnumber = toBinary();
        int[] numb = new int [Strnumber.length()];
        for(int i = 0; i < Strnumber.length(); i++){
            numb[i] = Strnumber.charAt(i) - '0';
        }
        for(int i = 0; i < Strnumber.length(); i++){
            if(i==0 || i ==numb.length-1){
                numb[i] = 1;
            }
        }
        for (int a=0;a<numb.length;a++){
            u = ( (int) (Math.pow(2,a)*numb[a]));
            j=j+u;
        }
        num = j;
        return num;
    }

    public static int Proverka(){
        num = PreobrazToSimple();
        System.out.println(num);
        arraySimple=eratosfen.reshetoEratosfera();
        int j=0;
        while (j<arraySimple.length){
            if(arraySimple[j]) {
                if (num % j == 0 && num != j) {
                    num = PreobrazToSimple();
                    j = 0;
                }
                else {
                    j++;
                }
            }
            else {
                j++;
            }
        }
        System.out.println("---------------------------------");
        System.out.println("Сгенерированное простое число: "+num);
        return num;
    }

   /* private static boolean TestMiller(BigInteger number){
        if(number == 2 || number == 3){
            return true;
        }
        if(number<2 || number % 2==0){
            return false;
        }
        BigInteger t = number-1;
        int s = 0;
        while(t % 2 == 0){
            t /= 2;
            s += 1;
        }
        for(int i=0;i<5;i++){
            int a = random.nextInt((number-1)+2)+2;
            BigInteger x = BigInteger.ZERO.modPow();
            if(x==1 || x == number-1){
                continue;
            }
            for (int r=1;r<s;r++){
                x=(int)Math.pow((x*x),number);
                if(x==1){
                    return false;
                }
                if(x==number-1){
                    break;
                }
            }
            if(x!=number-1) {
                return false;
            }
        }
        return true;
    }

    public static int GeneratS(){
        while (true){
            if(TestMiller(num)==false){
                num=Proverka();
                System.out.println("()()()()()()()())(()))()(()()()()(");
                System.out.println(num);
            }else {
                break;
            }
        }
        System.out.println("Сгенерированное простое число: "+num);
        return num;

    }*/
}
