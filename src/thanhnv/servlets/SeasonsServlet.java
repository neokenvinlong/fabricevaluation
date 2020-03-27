package thanhnv.servlets;

import thanhnv.entities.CategoryEntity;
import thanhnv.entities.ProductEntity;
import thanhnv.repository.CategoryRepository;
import thanhnv.repository.MaterialRepository;
import thanhnv.repository.ProductRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SeasonsServlet", urlPatterns = "/SeasonsServlet")
public class SeasonsServlet extends HttpServlet {
    private final String categoryPage = "category.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try{
            CategoryRepository categoryRepository = new CategoryRepository();
            List<CategoryEntity> result = categoryRepository.readCategoryList();
            request.setAttribute("CATEGORYLIST",result);


            ProductRepository productRepository = new ProductRepository();
            List<ProductEntity> productEntityList = productRepository.getProductList();
            MaterialRepository materialRepository = new MaterialRepository();
            List<ProductEntity> entities = new ArrayList<>();
            for(int i=0; i<productEntityList.size(); i++){
                entities.addAll(materialRepository.getMaterialAnalystForColdSeason(productEntityList.get(i)));
            }
            request.setAttribute("PRODUCTLIST",entities);
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
