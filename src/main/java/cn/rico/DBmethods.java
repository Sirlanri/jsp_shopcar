package cn.rico;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/getItems")
public class DBmethods extends HttpServlet {
    private static final long serialVersionUID=1L;
    Connection dbconn=null;
    DataSource dataSource;

    public void init(){
        try {
            Context context=new InitialContext();
            dataSource=(DataSource)context.lookup("java:comp/env/jdbc/jsp1");
            dbconn=dataSource.getConnection();
        } catch (NamingException | SQLException e) {
            System.out.println("数据库初始化失败！"+e.getMessage());
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        String uri=request.getRequestURI();

        if (uri.endsWith("getItems")){
            //获取全部商品列表
            ArrayList<Product>products=null;
            products=new ArrayList<Product>();
            try {
                String sql="select name,price,detail,pic from item";
                PreparedStatement pstmp=dbconn.prepareStatement(sql);
                ResultSet result=pstmp.executeQuery();
                while (result.next()){
                    Product product= new Product();
                    product.name=result.getString("name");
                    product.img=result.getString("img");
                    product.detail=result.getString("detail");
                    product.price=result.getDouble("price");
                    products.add(product);
                }
                if (!products.isEmpty()){
                    request.getSession().setAttribute("list",products);
                }
            } catch (SQLException throwables) {
                System.out.println("查询商品信息出错"+throwables.getMessage());
            }
        }
    }
}
