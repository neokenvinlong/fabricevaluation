package thanhnv.servlets;

import thanhnv.entities.CategoryEntity;
import thanhnv.entities.ProductEntity;
import thanhnv.repository.CategoryRepository;
import thanhnv.repository.ProductRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", urlPatterns = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    private final String categoryPage = "category.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try{
            String productName = request.getParameter("txtProductName");
            ProductRepository productRepository = new ProductRepository();
            List<ProductEntity> productEntityList = productRepository.getProductByProductName(productName);

            request.setAttribute("PRODUCTLIST",productEntityList);

            CategoryRepository categoryRepository = new CategoryRepository();
            List<CategoryEntity> result = categoryRepository.readCategoryList();
            request.setAttribute("CATEGORYLIST",result);

        }finally{
            RequestDispatcher rd = request.getRequestDispatcher(categoryPage);
            rd.forward(request,response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
