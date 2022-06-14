package constractor;

import constractor.supermarket.MerchandiseV2WithStaticVariable;

public class Static_main {
    public static void main(String[] args) {
        //静态变量不需要NEW一个对象使用它，可以直接用类名使用。
       System.out.println(MerchandiseV2WithStaticVariable.DISCOUNT_FOR_VIP);


    }
}
