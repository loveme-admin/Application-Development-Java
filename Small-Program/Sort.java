package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] num = new int[10];
        for (int i = 0; i < num.length; i++)
            num[i] = input.nextInt();
        sort3(num,0,num.length-1);
        for (int i = 0; i < num.length; i++)
            System.out.print(num[i] + " ");
    }
    private static void sort1(int[] num) {
        int temp;
        for (int i = 0; i < num.length - 1; i++)
            for (int j = 0; j < num.length - i - 1; j++)
                if (num[j] > num[j + 1]) {
                    temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
    }
    private static void sort2(int[] num) {
        int sub,min,temp;
        int i,j;
        for(i=0;i<num.length-1;i++){
            sub=i;
            min=num[i];
            for(j=i+1;j<num.length;j++)
                if(min>num[j]){
                    min=num[j];
                    sub=j;
                }
            temp=num[i];
            num[i]=min;
            num[sub]=temp;
        }
    }
    private static void sort3(int[] num,int begin,int end) {
       if(begin<end){
           int key=num[begin];
           int i=begin;
           int j=end;
           while(i!=j){
               while(i!=j && num[j]>key)
                   j--;
               if(i!=j){
                   num[i]=num[j];
                   i++;
               }
               while(i!=j && num[i]<key)
                   i++;
               if(i!=j){
                   num[j]=num[i];
                   j--;
               }
           }
           num[i]=key;
           sort3(num,begin,i-1);
           sort3(num,i+1,end);
       }
    }
}
