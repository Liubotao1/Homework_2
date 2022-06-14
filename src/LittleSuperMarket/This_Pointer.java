package LittleSuperMarket;

public class This_Pointer {
    public int count;
    public int duplicatename(int count){
        this.count=10;
        count =5;
        return count;
    }
    public int duplicatename1(int count){
        int a=this.duplicatename(count);
        this.count=10;
        count =5;
        return count;
    }

    public static void main(String[] args){
          int a;
          int b=5;
        This_Pointer  this_pointer =new This_Pointer();
        a=this_pointer.duplicatename1(b);
        System.out.println(a);
        System.out.println(this_pointer.count);
    }

}
