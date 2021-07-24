import com.google.gson.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JsonToJavaParser {
    public static String readString(String fileName) {
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String tmp;
            while ((tmp = bufferedReader.readLine()) != null) {
                String[] s = tmp.split("\\s");
                for (String res : s) {
                    stringBuilder.append(res);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void JsonToList(String json) {
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();

        JsonArray array = new JsonParser().parse(json).getAsJsonArray();

        for (int i = 0; i < array.size(); i++) {
            System.out.println(gson.fromJson(array.get(i), Employee.class));
        }
    }
}