package LittleSuperMarket;

import LittleSuperMarket.supermarket.LittleSuperMarket;
import LittleSuperMarket.supermarket.Merchandise;

import java.util.Scanner;

public class app_Method {
    public static void main(String[] args){
        Merchandise merchandise = new Merchandise();
        merchandise.name = "书桌";
        merchandise.soldPrice =999.9;
        merchandise.purchasePrice=500;
        merchandise.count=40;
        merchandise.id="DESK9527";

        LittleSuperMarket littleSuperMarket = new LittleSuperMarket();
        littleSuperMarket.address = "世纪大道666号";
        littleSuperMarket.superMarketName = "有家超市";
        littleSuperMarket.parkingCount = 200;
        littleSuperMarket.merchandises = new Merchandise[200];
        littleSuperMarket.merchandiseSold = new int[littleSuperMarket.merchandises.length];

        Merchandise[] all = littleSuperMarket.merchandises;

        for (int i = 0; i < all.length; i++) {
            Merchandise m = new Merchandise();
            m.count = 200;
            m.id = "ID" + i;
            m.name = "商品" + i;
            m.purchasePrice = Math.random() * 200;
            m.soldPrice = (1 + Math.random()) * 200;
            all[i] = m;
        }

        merchandise.describe();//调用方法

        System.out.println("下面请利润最高的商品自我介绍：");

        // >> TODO 返回值可以直接使用，不必赋值给一个变量再使用。
        littleSuperMarket.getBiggestProfitMerchandise().describe();        //采用返回值调用describe方法

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("今日超市大特惠，所有商品第二件半价！选择要购买的商品索引：");
            int index = scanner.nextInt();

            if (index < 0) {
                break;
            }

            if (index >= all.length) {
                System.out.println("商品索引超出界限");
                continue;
            }

            Merchandise m = all[index];
            System.out.println("商品" + m.name + "售价为" + m.soldPrice + "。请问购买几个？");
            int count = scanner.nextInt();


           System.out.println("商品总结为："+m.buy(count));


        }

    }
}
