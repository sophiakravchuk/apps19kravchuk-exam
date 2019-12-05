package domain;

import json.*;

/**
 * Created by Andrii_Rodionov on 1/5/2017.
 */
public class BasicStudent implements Jsonable {

    protected String name;
    protected String surname;
    protected Integer year;

    public BasicStudent() {
    }

    public BasicStudent(String name, String surname, Integer year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    @Override
    public JsonObject toJsonObject() {
        // ToDo
        //{'name': 'Andrii', 'surname': 'Rodionov',
        //'year': 2}
        JsonPair[] jPairs = new JsonPair[3];
        jPairs[0] = new JsonPair("name", new JsonString(name));
        jPairs[1] = new JsonPair("surname", new JsonString(surname));
        jPairs[2] = new JsonPair("year", new JsonNumber(year));
//        JsonObject jObj = new JsonObject(jPairs);
        return new JsonObject(jPairs);
    }
}
