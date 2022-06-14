package LittleSuperMarket.supermarket;

public class Merchandise {
    public String name;
    public String id;
    public int count;
    public double soldPrice;    //售价
    public double purchasePrice;   // 进价
    String madeIn="China";

    //不带返回值
    public void describe(){
        double netIncome = soldPrice - purchasePrice;
        System.out.println("商品名称叫做"+name+",id是"+id+".商品售价是"+soldPrice+"。商品进价是"+purchasePrice+
                "。商品库存为"+count +"。销售一个的毛利润是"+netIncome+"。制造地为"+madeIn);
    }
    //带返回值
    public double calculateProfit(){
        double profit =soldPrice-purchasePrice;
        if (profit<=0){
            return 0;
        }
        return profit;
    }
    public double buy(int countToBuy) {
        if (count < countToBuy) {
            System.out.println("商品库存不够");
            return -1;
        }
        System.out.println("商品单价为" + soldPrice);

        int fullPriceCount = countToBuy / 2 + countToBuy % 2;
        int halfPriceCount = countToBuy - fullPriceCount;
        double totalCost = soldPrice * fullPriceCount + halfPriceCount * soldPrice / 2;

        count -= countToBuy;

        return totalCost;
    }
}
