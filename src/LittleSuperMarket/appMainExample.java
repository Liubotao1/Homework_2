package LittleSuperMarket;

import LittleSuperMarket.supermarket.LittleSuperMarket;
import LittleSuperMarket.supermarket.Merchandise;

import java.util.Scanner;

public class appMainExample {
    public static void main(String[] args){
        LittleSuperMarket littleSuperMarket = new LittleSuperMarket();
        //littleSuperMarket.merchandises = new Merchandise[200];
        //littleSuperMarket.merchandiseSold = new int[littleSuperMarket.merchandises.length];

        littleSuperMarket.init("有家超市","世纪大道666号", 200, 200, 200);
        //littleSuperMarket.address = "世纪大道666号";
        //littleSuperMarket.superMarketName = "有家超市";
       // littleSuperMarket.parkingCount = 200;
        System.out.println("本店叫做" + littleSuperMarket.superMarketName);
        System.out.println("本店地址" + littleSuperMarket.address);
        System.out.println("共有停车位" + littleSuperMarket.parkingCount + "个");
        System.out.println("今天的营业额为" + littleSuperMarket.incomingSum);
        System.out.println("共有商品" + littleSuperMarket.merchandises.length + "种");


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
            int numToBuy = scanner.nextInt();

            if (numToBuy > m.count) {
                System.out.println("库存不足");
                continue;
            }

            int fullPriceCount = numToBuy / 2 + numToBuy % 2;  //全价商品个数
            int halfPriceCount = numToBuy - fullPriceCount;      //半价商品个数

            double totalCost = fullPriceCount * m.soldPrice + (halfPriceCount * m.soldPrice / 2);

            m.count -= numToBuy;

            System.out.println("选购的商品总价为" + totalCost);
        }

    }

}
