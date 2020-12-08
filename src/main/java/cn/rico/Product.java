package cn.rico;

import java.io.Serializable;

public class Product implements Serializable {
    //全公有，可以直接访问，不需要乱七八糟的访问方法了（懒
    public String name;
    public double price;
    public String detail;
    public String img;

    //构造方法
    public Product(){}
    public Product(String name,double price,String detail,String img){
        this.name=name;
        this.price=price;
        this.detail=detail;
        this.img=img;
    }
}
