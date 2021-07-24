import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class XmlToJsonParser {
    public static List<Employee> parseXml(String fileName) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(fileName);

        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("employee");

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            Element element = (Element) node;
            Node node0 = element.getElementsByTagName("id").item(0);
            Node node1 = element.getElementsByTagName("firstName").item(0);
            Node node2 = element.getElementsByTagName("secondName").item(0);
            Node node3 = element.getElementsByTagName("country").item(0);
            Node node4 = element.getElementsByTagName("age").item(0);

            employees.add(new Employee(Integer.parseInt(node0.getTextContent()), node1.getTextContent(),
                    node2.getTextContent(), node3.getTextContent(),
                    Integer.parseInt(node4.getTextContent())));
        }
        return employees;
    }

    public static String listToJson(List<Employee> list) {
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        Type listType = new TypeToken<List<Employee>>() {
        }.getType();

        return gson.toJson(list, listType);
    }

    public static void writeString(String json) {
        File file = new File("C://Users//MI//Desktop//Runtime-projects//jsonParser", "fromXml.json");

        try {
            FileWriter fw = new FileWriter(file);
            fw.write(json);
            fw.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}