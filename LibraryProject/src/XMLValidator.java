import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class XMLValidator {
    public static void main(String[] args) throws Exception {
        File xml = new File("library.xml");
        File xsd = new File("library.xsd");

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        factory.newSchema(xsd).newValidator().validate(new StreamSource(xml));

        System.out.println("XML валиден.");
    }
}
