package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str1=input.nextLine(); //输入
        String[] str2 = str1.split(" ");//分割
        String[] str3=new String[str2.length+1];//去重
        int[] count=new int[str2.length+1];//计数
        int i=0,j=0;
        for(i=0;i< str2.length;i++)
        {
            for(j=0;str3[j]!=null;j++)
                if(str2[i].equals(str3[j])==true)
                {
                    count[j]++;
                    break;
                }
            if(str3[j]==null)
            {
                str3[j]=str2[i];
                count[j]++;
            }
        }
        for(i=0;str3[i]!=null;i++)
            System.out.println(str3[i]+" "+count[i]);
    }
}
