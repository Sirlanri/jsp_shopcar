package cn.rico;

import java.io.Serializable;

public class Goods implements Serializable  {
    private Product product;
    private int number;
    public Goods(Product product){
        this.product=product;
        number=1;
    }
    public Goods(Product product, int number){
        this.product=product;
        this.number=number;
    }

    public Product getProduct() {
        return product;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
}
