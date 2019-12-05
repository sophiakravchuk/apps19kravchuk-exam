package json;

import java.util.Arrays;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private JsonPair[] jsonPairs;
    public JsonObject(JsonPair... jsonPairs) {
        this.jsonPairs = jsonPairs;
    }

    @Override
    public String toJson() {
        StringBuilder s = new StringBuilder();
        s.append('{');
        for (int i = 0; i < jsonPairs.length; i++) {
            s.append('\'');
            s.append(jsonPairs[i].key);
            s.append('\'');
            s.append(": ");

            s.append(jsonPairs[i].value.toJson());

            s.append(", ");
            if (i == jsonPairs.length-1) {
                int n = s.length();
                s.delete(n-2, n-1);
            }
        }

        s.append('}');
        return s.toString();
    }

    public boolean contains(String name) {
        for (int i = 0; i < jsonPairs.length; i++) {
            if (jsonPairs[i].value.toJson().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void add(JsonPair jsonPair) {
        JsonPair[] newJsonPairs = new JsonPair[jsonPairs.length+1];
        for (int i = 0; i < jsonPairs.length; i++) {
            newJsonPairs[i] = jsonPairs[i];
        }
        newJsonPairs[jsonPairs.length] = jsonPair;
        this.jsonPairs = newJsonPairs;
    }

    public Json find(String name) {
        for (int i = 0; i < jsonPairs.length; i++) {
            if (jsonPairs[i].value.toJson().equals(name)) {
                return jsonPairs[i].value;
            }
        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject jObj = new JsonObject();
        for (int i = 0; i < jsonPairs.length; i++) {
            for (int j = 0; j < names.length; j++) {
                if (jsonPairs[i].value.toJson().equals(names[j])) {
                    jObj.add(jsonPairs[i]);
                }
            }
        }
        return jObj;
    }
}
