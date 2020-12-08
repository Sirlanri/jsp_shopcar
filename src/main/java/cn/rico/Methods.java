package cn.rico;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "methods",urlPatterns = {"/addToCar","/delItem"})
public class Methods extends HttpServlet {
    ServletContext context;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String uri=request.getRequestURI();
        if (uri.endsWith("/addToCar")){
            String name="";
            try {
                name=(String)request.getParameter("itemName");
            }catch (Exception e){
                System.out.println("后端提取item名字出错");
            }
            Product product=getProduct("");
        }else if (uri.endsWith("/delItem")){
            delItem(request,response);
        }
    }

    private void delItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session=request.getSession();
        //购物车：session-car
        Car car = (Car)session.getAttribute("car");
    }


    //通过商品名返回商品信息
    private Product getProduct(String s) {
        context=getServletContext();
        ArrayList<Product> products=(ArrayList<Product>)context.getAttribute("list");
        for (Product product:products){
            if (product.name==s){
                return product;
            }
        }
        return null;
    }
}
