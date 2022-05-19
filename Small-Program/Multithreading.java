package com.company;
import java.util.Random;
import java.util.Scanner;

class MyThread implements Runnable {
    private int [] ticket1 = new int[4];
    private int [] ticket2 =new int[4];
    private int [][] count=new int[4][4];
    int sum1;
    int sum2;
    public int[][] Count(){
        return count;
    }
    public void setTicket2(int [] ticket2){
        for (int i=0;i<ticket2.length;i++){
            this.ticket2[i]=ticket2[i];
            sum2+=ticket2[i];
        }
    }
    @Override
    public void run() {
        for (int x = 0; x <= sum2/4; x++) {
            this.sale();
        }
    }
    public synchronized void sale() {
        Random ran =new Random();
        int r;
        while(true){
            r =ran.nextInt(4);
            if(ticket1[r]!=ticket2[r])
                break;
            if(ticket1[0]==ticket2[0]&&ticket1[1]==ticket2[1]&&ticket1[2]==ticket2[2]&&ticket1[3]==ticket2[3])
                break;
        }
        if (sum1 < sum2) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 卖票，第"+(char)(r+97)+"类卖出第" + ((this.ticket1[r]++)+1) + "张票");
            if (Thread.currentThread().getName() == "窗口A")
                count[0][r]++;
            else if (Thread.currentThread().getName() == "窗口B")
                count[1][r]++;
            else if (Thread.currentThread().getName() == "窗口C")
                count[2][r]++;
            else if (Thread.currentThread().getName() == "窗口D")
                count[3][r]++;
            sum1++;
        }
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input=new Scanner(System.in);
        MyThread mt = new MyThread();
        int [] num =new int[4];
        System.out.print("输入资源总量(a类,b类,c类,d类):");
        for(int i=0;i<num.length;i++)
            num[i]=input.nextInt();
        mt.setTicket2(num);
        Thread t1=new Thread(mt,"窗口A");
        Thread t2=new Thread(mt,"窗口B");
        Thread t3=new Thread(mt,"窗口C");
        Thread t4=new Thread(mt,"窗口D");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        int[][] count = mt.Count();
        for (int i=0;i< count.length;i++)
            for(int j=0;j<count[0].length;j++)
                System.out.println("窗口"+(char)(i+65)+"卖了"+(char)(j+97)+"类"+count[i][j]+"张票");
    }
}
