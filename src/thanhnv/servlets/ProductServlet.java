package thanhnv.servlets;

import thanhnv.entities.MaterialEntity;
import thanhnv.entities.ProductEntity;
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

            //System.out.println("material mau:" + productEntity.getMaterial());
            String matching = "(?:\\b|-)([1-9]{1,2}[0]?|100)\\b\\%";

            String mate = productEntity.getMaterial().replaceAll(matching,"");
//            System.out.println("material sau:" + mate);

            //test
//            String mau = "100% Cotton/ Rib: 91% Cotton, 7% Polyester, 2% Spandex";
//            String matching1 = "(?:\\b|-)([1-9]{1,2}[0]?|100)\\b\\% ([A-Z])\\w+";
//            Pattern pattern = Pattern.compile(matching1);
//            Matcher matcher = pattern.matcher(mau);
//            List<Integer> percentList = new ArrayList<>();
//            List<String> mateList = new ArrayList<>();
//            while (matcher.find()){
//                String a = matcher.group();
//                System.out.println("aaa"+a);
//                String []b = a.split(" ");
//                System.out.println("bbb"+ b[0] +"xxxx" + b[1]);
//                int bInt = Integer.parseInt(b[0].replace("%",""));
//                percentList.add(bInt);
//                mateList.add(b[1]);
//            }
//            System.out.println("Percent list "+ percentList);
//            System.out.println("Mate List"+ mateList);
            //end of test
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
//            System.out.println(fiberResultList);

            request.setAttribute("MATERIALLIST",fiberResultList);

            String appear ="";
            for (int i=0 ; i< fiberResultList.size();i++){
                appear += fiberResultList.get(i).getAppearance();
            }
//            System.out.println("chuoi :"+ appear);
//            List<String> season = materialRepository.getMaterialInfoForSeason(productEntity, appear);
            List<String> season = materialRepository.getMaterialAnalystForSeason(productEntity);
            System.out.println("aaaa"+season);
            request.setAttribute("SEASON",season);

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
