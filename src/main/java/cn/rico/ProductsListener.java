package cn.rico;

import cn.rico.Product;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebListener
public class ProductsListener implements ServletContextListener {
    private ServletContext context=null;
    //暂无数据库，把商品信息放到List中
    public void contextInitialized(ServletContextEvent sce){
        Connection dbconn=null;
        DataSource dataSource;
        try {
            Context context=new InitialContext();
            dataSource=(DataSource)context.lookup("java:comp/env/jdbc/jsp1");
            dbconn=dataSource.getConnection();
        } catch (NamingException | SQLException e) {
            System.out.println("Server数据库初始化失败！"+e.getMessage());
        }
        //获取全部商品列表
        ArrayList<Product>products=null;
        products=new ArrayList<Product>();
        context=sce.getServletContext();
        try {
            String sql="select name,price,detail,pic from item";
            PreparedStatement pstmp=dbconn.prepareStatement(sql);
            ResultSet result=pstmp.executeQuery();
            while (result.next()){
                Product product= new Product();
                product.name=result.getString("name");
                product.img=result.getString("pic");
                product.detail=result.getString("detail");
                product.price=result.getDouble("price");
                products.add(product);
            }
            if (!products.isEmpty()){
                context.setAttribute("list",products);
            }
        } catch (SQLException throwables) {
            System.out.println("查询商品信息出错"+throwables.getMessage());
        }

    }
    public void contextDestryed(ServletContextEvent sce){
        context=sce.getServletContext();
        context.removeAttribute("list");
    }
}
