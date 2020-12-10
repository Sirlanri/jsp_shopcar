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
        products.add(new Product("阿米洛机械键盘",938,
                "【个性定制】快速私人定制机械键盘 办公键盘 VA108键有线",
                "https://img13.360buyimg.com//n0/jfs/t1/100616/13/2599/110353/5dd25383E3ab5cab7/d8383b1d1d5df8c2.jpg"));
        products.add(new Product("赛博朋克2077",348,
                "STEAM正版PC中文 steam赛博朋克2077 Cyberpunk2077 電馭叛客 国区礼物",
                "https://img13.360buyimg.com/n1/jfs/t1/71211/35/5863/744245/5d41570eEfb3edb39/4045c4db82276820.png"));
        products.add(new Product("PS5游戏主机",8899,
                "索尼（SONY）PS5游戏主机PlayStaion 5家用高清蓝光8K电视游戏机 外版现货 PS5 光驱版 双原装手柄大作套装",
                "https://img13.360buyimg.com/n1/jfs/t1/153820/16/5301/26454/5faa0a84E0c26293b/2990bd3275b60a53.jpg"));
        products.add(new Product("百搭针织衫",1039,
                "卡迪黛尔2020年冬季新款网纱拼接小立领花边袖个性时尚百搭针织衫 白色 S",
                "https://img12.360buyimg.com/n1/s350x449_jfs/t1/149880/5/16771/185850/5fc8a42fE49a3b4b5/d742870e506d96d8.jpg!cc_350x449.jpg"));
        products.add(new Product("翻领单排扣大衣外套",799,
                "尚都比拉100%棉羊毛中长款双面呢2020秋季新款女装翻领单排扣大衣外套 浅黄色 L",
                "https://img11.360buyimg.com/n1/s350x449_jfs/t1/137683/3/17761/199726/5fd21821E3eb2dec7/fcb9798a35c7284c.jpg!cc_350x449.jpg"));
        products.add(new Product("儿童玩具智能机器狗",128,
                "趣致（Quzhi）儿童玩具智能机器狗 宝宝婴儿玩具早教学习编程机器人1-3-6岁以上男女孩生日礼物 智能机器狗（精装）",
                "https://img12.360buyimg.com/n1/jfs/t1/122902/38/13156/419443/5f67f7d1E71264cbb/00675dc54a7f34d0.png"));
        context=sce.getServletContext();
        context.setAttribute("list",products);


    }
    public void contextDestryed(ServletContextEvent sce){
        context=sce.getServletContext();
        context.removeAttribute("list");
    }
}
