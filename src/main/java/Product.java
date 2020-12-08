import java.io.Serializable;

public class Product implements Serializable {
    //全公有，可以直接访问，不需要乱七八糟的访问方法了（懒
    public String name;
    public double price;

    //构造方法
    public Product(){}
    public Product(String name,double price){
        this.name=name;
        this.price=price;
    }
}
