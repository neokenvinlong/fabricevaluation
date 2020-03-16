package thanhnv.utils;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.xml.bind.*;

public class JAXBUtil {

    public static Object unmarshall(Class type, ByteArrayOutputStream byteArrayOutputStream, String schemaFilePath)
        throws JAXBException, SAXException {
        System.out.println(byteArrayOutputStream.toString());
        JAXBContext jaxbContext = JAXBContext.newInstance(type);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File(schemaFilePath));
        jaxbUnmarshaller.setSchema(schema);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        return jaxbUnmarshaller.unmarshal(byteArrayInputStream);
    }
}
