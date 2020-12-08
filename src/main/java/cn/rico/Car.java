package cn.rico;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Car {
    //用商品名作为id，省了个参数
    HashMap<String, Goods>items=null;
    public Car(){
        items=new HashMap<String, Goods>();
    }
    //向购物车添加商品
    public void add(Goods good){
        String name= good.getProduct().name;
        //如果商品已经存在
        if (items.containsKey(name)){
            Goods newitem=(Goods)items.get(name);
            newitem.setNumber(newitem.getNumber()+good.getNumber());
        }else {
            //不存在，就添加进
            items.put(name,good);
        }
    }
    //删除商品
    public void remove(String name){
        if (items.containsKey(name)){
            Goods item = (Goods)items.get(name);
            item.setNumber(item.getNumber()-1);
            if (item.getNumber()<=0){
                items.remove(name);
            }
        }
    }
    //返回购物车的Items集合
    public Collection<Goods> getItems(){
        return items.values();
    }

    //计算价格总和
    public double getTotal(){
        double count=0;
        for (Iterator<Goods> i = getItems().iterator(); i.hasNext();){
            Goods item =(Goods)i.next();
            Product product=(Product)item.getProduct();
            count+=product.price;
        }
        return round(count);
    }
    //保留两位小数
    private double round(double count) {
        long val=Math.round(count*100);
        return val/100.0;
    }

    //不买立减100%
    public void clear(){
        items.clear();
    }

}
