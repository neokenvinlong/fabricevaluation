package thanhnv.crawlers;

import thanhnv.constants.StaticURL;
import thanhnv.entities.MaterialEntity;
import thanhnv.jaxb.Materials;
import thanhnv.repository.MaterialRepository;
import thanhnv.utils.JAXBUtil;

public class MaterialCrawler extends PageCrawler{
    public MaterialCrawler(String url, String realPath) {
        super(url, realPath);
        this.setXslPath(realPath + StaticURL.XSL_MATERIAL);
    }

    @Override
    public void run() {
        try {
            Materials materials = (Materials) JAXBUtil.unmarshall(Materials.class,this.crawl(),this.getRealPath()+StaticURL.SCHEMA_MATERIAL);
            for (int i = 0; i < materials.getMaterial().size();i++){
//                System.out.println("Fiber :"+materials.getMaterial().get(i).getFiber());
//                System.out.println("Use :"+materials.getMaterial().get(i).getUses());
//                System.out.println("Appearance :"+materials.getMaterial().get(i).getAppearance());
//                System.out.println("Pros :"+materials.getMaterial().get(i).getPros());
//                System.out.println("Cons :"+materials.getMaterial().get(i).getCons());
//                System.out.println("Carewash :"+materials.getMaterial().get(i).getCarewash());
//                System.out.println("Wrinkle :"+materials.getMaterial().get(i).getWrinkle());
//                System.out.println("Shrink :"+materials.getMaterial().get(i).getShrink());
                MaterialEntity materialEntity = new MaterialEntity();
                materialEntity.setFiber(materials.getMaterial().get(i).getFiber());
                materialEntity.setUses(materials.getMaterial().get(i).getUses());
                materialEntity.setAppearance(materials.getMaterial().get(i).getAppearance());
                materialEntity.setPros(materials.getMaterial().get(i).getPros());
                materialEntity.setCons(materials.getMaterial().get(i).getCons());
                materialEntity.setCarewash(materials.getMaterial().get(i).getCarewash());
                materialEntity.setWrinkle(materials.getMaterial().get(i).getWrinkle());
                materialEntity.setShrink(materials.getMaterial().get(i).getShrink());

                MaterialRepository materialRepository = new MaterialRepository();
                materialRepository.addMaterial(materialEntity);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
//        try {
//            System.out.println(this.crawl());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
