package thanhnv.servlets;

import thanhnv.entities.CategoryEntity;
import thanhnv.entities.MaterialEntity;
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

@WebServlet(name = "ProductServlet", urlPatterns = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private final String detailPage = "detail.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try {
            String id = request.getParameter("proId");
            ProductRepository productRepository = new ProductRepository();
            ProductEntity productEntity = productRepository.getProductByProductId(id);
            String replace = productEntity.getProductInfo().replace(".","<br/>").replace("!","<br/>");

            productEntity.setProductInfo(replace);
            request.setAttribute("PRODUCT", productEntity);

            String[] sizeSplit = productEntity.getProductSize().split("/");
            List<String> sizeList = new ArrayList<>();
            for (int i = 1; i < sizeSplit.length; i++) {
                sizeList.add(sizeSplit[i]);
            }
            request.setAttribute("PRODUCTSIZE",sizeList);

            String fiber = productEntity.getMaterial();
            MaterialRepository materialRepository = new MaterialRepository();
            List<MaterialEntity> fiberList = materialRepository.getFiberInMaterial();
            List<MaterialEntity> fiberResultList = new ArrayList<>();
            for(int i=0; i < fiberList.size();i++){
                if(fiber.contains(fiberList.get(i).getFiber())){
                    fiberResultList.add(fiberList.get(i));
                }
            }
            System.out.println(fiberResultList);

            request.setAttribute("MATERIALLIST",fiberResultList);
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(detailPage);
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
