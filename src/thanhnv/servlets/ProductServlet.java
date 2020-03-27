package thanhnv.servlets;

import thanhnv.entities.AnalysisEntity;
import thanhnv.entities.MaterialEntity;
import thanhnv.entities.ProductEntity;
import thanhnv.jaxb.Analysis;
import thanhnv.repository.AnalysisRepository;
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
            String replace = productEntity.getProductInfo().replace(".", "<br/>").replace("!", "<br/>");

            productEntity.setProductInfo(replace);

            //System.out.println("material mau:" + productEntity.getMaterial());
            String matching = "(?:\\b|-)([1-9]{1,2}[0]?|100)\\b\\%";

            String mate = productEntity.getMaterial().replaceAll(matching, "");
//            System.out.println("material sau:" + mate);


            String[] sizeSplit = productEntity.getProductSize().split("/");
            List<String> sizeList = new ArrayList<>();
            for (int i = 1; i < sizeSplit.length; i++) {
                sizeList.add(sizeSplit[i]);
            }
            request.setAttribute("PRODUCTSIZE", sizeList);

            //get material
            AnalysisRepository analysisRepository = new AnalysisRepository();
            List<AnalysisEntity> analysisEntityList = analysisRepository.getAnalysisInMaterial(productEntity);
            List<Analysis> analysisList = new ArrayList<>();
            int percentage = 0;
            for (int i = 0; i < analysisEntityList.size(); i++) {
                if (percentage < 100) {
                    Analysis analysis = new Analysis(analysisEntityList.get(i).getFabridName(), analysisEntityList.get(i).getPercentage());
                    analysisList.add(analysis);
                    percentage = percentage + analysisEntityList.get(i).getPercentage();
                } else {
                    break;
                }
            }
            request.setAttribute("ANALYST", analysisList);


            MaterialRepository materialRepository = new MaterialRepository();
            List<MaterialEntity> fiberList = materialRepository.getFiberInMaterial();
            List<MaterialEntity> fiberResultList = new ArrayList<>();
            for (int i = 0; i < fiberList.size(); i++) {
                for (int j = 0; j < analysisList.size(); j++) {
                    if (analysisList.get(j).getFabridName().toLowerCase().equals(fiberList.get(i).getFiber().toLowerCase())) {
                        fiberResultList.add(fiberList.get(i));
                    }

                }
            }


            request.setAttribute("MATERIALLIST", fiberResultList);

            List<String> season = materialRepository.getMaterialAnalystForSeason(productEntity);
            request.setAttribute("SEASON", season);


            productEntity.setMaterial(mate);
            request.setAttribute("PRODUCT", productEntity);
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
