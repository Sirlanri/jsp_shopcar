import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;

@WebListener
public class ProductsListener implements ServletContextListener {
    private ServletContext context=null;
    //暂无数据库，把商品信息放到List中
    public void contextInit(ServletContextEvent sce){
        ArrayList<Product>products=new ArrayList<Product>();
        products.add(new Product("OPPO reno3",2899));
    }
}
