package constractor.supermarket;

public class MerchandiseV2 {

    public String name;
    public String id;
    //  构造方法执行前，会执行给局部变量赋初始值的操作
    //  我们说过，所有的代码都必须在方法里，那么这种给成员变赋初始值的代码在哪个方法里？怎么看不到呢？
    //  原来构造方法在内部变成了<init>方法。学习就是要脑洞大，敢想敢试，刨根问底。
    public int count = 999;// 999/0;
    public double soldPrice;
    public double purchasePrice;
    public static double DISCOUNT_FOR_VIP = 0.95;
    //  构造方法（constructor）的重载和普通方法一样
    public MerchandiseV2(String name, String id, int count, double soldPrice, double purchasePrice) {
        this.name = name;
        this.id = id;
        this.count = count;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;
//        soldPrice = 9/0;
    }

    //  在构造方法里才能调用重载的构造方法。语法为this(实参列表)
    //  构造方法不能自己调用自己，这会是一个死循环
    //  在调用重载的构造方法时，不可以使用成员变量。因为用语意上讲，这个对象还没有被初始化完成，处于中间状态。
    //  在构造方法里才能调用重载的构造方法时，必须是方法的第一行。后面可以继续有代码
    public MerchandiseV2(String name, String id, int count, double soldPrice) {
         // double purPrice = soldPrice * 0.8;
        // this(name, id, count, soldPrice, purchasePrice);
        this(name, id, count, soldPrice, soldPrice * 0.8);
        // double purPrice = soldPrice * 0.8;
    }

    //   因为我们添加了构造方法之后，Java就不会再添加无参数的构造方法。如果需要的话，我们可以自己添加这样的构造方法
    public MerchandiseV2() {
        this("无名", "000", 0, 1, 1.1);

    }

    // 除了没有this，静态方法的定义和成员方法一样，也有方法名，返回值和参数
    //  静态方法没有this自引用，它不属于某个实例，调用的时候也无需引用，直接用类名调用，所以它也不能直接访问成员变量
    // 当然在静态方法里面，也可以自己创建对象，或者通过参数，获得对象的引用，进而调用方法和访问成员变量
    // 静态方法只是没有this自引用的方法而已。
    public static double getVIPDiscount() {
        // 静态方法可以访问静态变量，包括自己类的静态变量和在访问控制符允许的别的类的静态变量
        return DISCOUNT_FOR_VIP;
    }




    public void describe() {
        System.out.println("商品名字叫做" + name + "，id是" + id + "。 商品售价是" + soldPrice
            + "。商品进价是" + purchasePrice + "。商品库存量是" + count +
            "。销售一个的毛利润是" + (soldPrice - purchasePrice));
    }

    public double calculateProfit() {
        double profit = soldPrice - purchasePrice;
//        if(profit <= 0){
//            return 0;
//        }
        return profit;
    }

    public double buy(int count) {
        if (this.count < count) {
            return -1;
        }
        return this.count -= count;
    }
}
