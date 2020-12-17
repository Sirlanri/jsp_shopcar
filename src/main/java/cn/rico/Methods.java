package cn.rico;

import javax.servlet.ServletContext;
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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("utf-8");
        String uri=request.getRequestURI();
        if (uri.endsWith("addToCar")){
            String name="";
            try {
                name=(String)request.getParameter("itemName");
            }catch (Exception e){
                System.out.println("后端提取item名字出错");
            }
            //加入一件物品到购物车
            Product product = getProduct(name);
            if (product!=null){
                Goods goods=new Goods(product);
                HttpSession session=request.getSession();
                Car car = (Car)session.getAttribute("car");
                if (car==null){
                    car = new Car();
                    session.setAttribute("car",car);
                }
                car.add(goods);

            }

        }else if (uri.endsWith("delItem")){
            delItem(request,response);
        }
        response.sendRedirect("car.jsp");
    }



    private void delItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session=request.getSession();
        //购物车：session-car
        Car car = (Car)session.getAttribute("car");
        try {
            String name=(String)request.getParameter("itemName");
            Goods item=null;
            for (Goods shopItem:car.getItems()){
                if (shopItem.getProduct().name.equals(name)){
                    item=shopItem;
                    break;
                }
            }
            car.remove(item.getProduct().name);
        }catch (Exception e){
            System.out.println("删除物品出错"+e.getMessage());
        }
        session.setAttribute("car",car);
    }


    //通过商品名返回商品信息
    private Product getProduct(String s) {
        context=getServletContext();
        ArrayList<Product> products=(ArrayList<Product>)context.getAttribute("list");
        for (Product product:products){
            if (product.name.equals(s)){
                return product;
            }
        }
        return null;
    }
}
