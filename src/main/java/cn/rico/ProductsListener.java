package cn.rico;

import cn.rico.Product;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;

@WebListener
public class ProductsListener implements ServletContextListener {
    private ServletContext context=null;
    //暂无数据库，把商品信息放到List中
    public void contextInitialized(ServletContextEvent sce){
        ArrayList<Product>products=new ArrayList<Product>();
        products.add(new Product("OPPO reno3",2899,"OPPO Reno3 Pro 双模5G 视频双防抖 90HZ高感曲面屏 7.7mm轻薄机身 12GB+256GB 雾月白全网通游戏视频手机","https://img10.360buyimg.com/n1/s450x450_jfs/t1/96127/30/8596/71921/5e05d2d3Eea057f1e/e596ae07921c890d.jpg"));
        products.add(new Product("阿米洛机械键盘",938,"【个性定制】快速私人定制机械键盘 办公键盘 VA108键有线","https://img13.360buyimg.com//n0/jfs/t1/100616/13/2599/110353/5dd25383E3ab5cab7/d8383b1d1d5df8c2.jpg"));
        context=sce.getServletContext();
        context.setAttribute("list",products);
    }
    public void contextDestryed(ServletContextEvent sce){
        context=sce.getServletContext();
        context.removeAttribute("list");
    }
}
