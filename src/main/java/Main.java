import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] columnMapping = {"id", "firstName", "secondName", "country", "age"};
        String fileName = "jsonParser//data.csv";
        String fileName2 = "jsonParser//data2.xml";
        String jsonFile = "jsonParser//fromXml.json";

        //parsing cvs to json
        List<Employee> list = CsvToJsonParser.parseCSV(fileName, columnMapping);
        CsvToJsonParser.writeString(CsvToJsonParser.listToJson(list));

        //parsing xml to json
        try {
            XmlToJsonParser.writeString(XmlToJsonParser.listToJson(XmlToJsonParser.parseXml(fileName2)));
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        //parsing json to java class
        JsonToJavaParser.JsonToList(JsonToJavaParser.readString(jsonFile));
    }
}