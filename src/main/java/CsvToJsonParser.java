import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class CsvToJsonParser {
    public static List<Employee> parseCSV(String fileName, String[] columnMapping) {

        try {
            CSVReader csvReader = new CSVReader(new FileReader(fileName));
            ColumnPositionMappingStrategy<Employee> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Employee.class);
            strategy.setColumnMapping(columnMapping);

            CsvToBean<Employee> csv = new CsvToBean<>();
            csv.setCsvReader(csvReader);
            csv.setMappingStrategy(strategy);

            return csv.parse();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String listToJson(List<Employee> list) {
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        Type listType = new TypeToken<List<Employee>>() {
        }.getType();

        return gson.toJson(list, listType);
    }

    public static void writeString(String json) {
        File file = new File("C://Users//MI//Desktop//Runtime-projects//jsonParser", "fromCsv.json");

        try {
            FileWriter fw = new FileWriter(file);
            fw.write(json);
            fw.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}