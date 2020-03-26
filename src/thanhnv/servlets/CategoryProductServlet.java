package thanhnv.servlets;

import thanhnv.entities.CategoryEntity;
import thanhnv.entities.ProductEntity;
import thanhnv.repository.CategoryRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryProductServlet", urlPatterns ="/CategoryProductServlet")
public class CategoryProductServlet extends HttpServlet {
    private final String categoryPage = "category.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try{
            String idString = request.getParameter("id");
            int id = Integer.parseInt(idString);
            CategoryRepository categoryRepository = new CategoryRepository();
            List<ProductEntity> result = categoryRepository.getProductListByCategoryId(categoryRepository.searchCategoryByCategoryId(id));

            request.setAttribute("PRODUCTLIST",result);

            List<CategoryEntity> result1 = categoryRepository.readCategoryList();
            request.setAttribute("CATEGORYLIST",result1);


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
