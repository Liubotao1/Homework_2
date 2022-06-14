package LittleSuperMarket.supermarket;


public class LittleSuperMarket {
    public String superMarketName;
    public String address;
    public int parkingCount;         //停车位
    public double incomingSum;
    public Merchandise[] merchandises;
    public int[] merchandiseSold;

public void init(String superMarketName, String address, int parkingCount,
                     int merchandises ,  int merchandiseSold){

    this.superMarketName=superMarketName;
    this.address=address;
    this.parkingCount=parkingCount;
    this.merchandises=new Merchandise[merchandises];
    this.merchandiseSold= new int[merchandiseSold];

    }
    // >> 返回值类型可以是类名，这时候实际返回的值就是这个类的引用
    public Merchandise getBiggestProfitMerchandise() {
        Merchandise curr = null;
        for (int i = 0; i < merchandises.length; i++) {
            Merchandise m = merchandises[i];
            if (curr == null) {
                curr = m;
                continue;
            }
            // >> 调用商品中定义的方法，不同的实例调用相同的方法，虽然代码相同，但是每个实例内部的数据不同，所以返回值也不同
            double currProfit = curr.calculateProfit();
            double newProfit = m.calculateProfit();
            if (currProfit < newProfit) {
                curr = m;
            }
        }
        return curr;
    }
}
