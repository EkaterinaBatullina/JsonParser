/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package a.jsonparse;

import org.json.JSONException;

/**
 *
 * @author ekaterina
 */
public class JsonParse {

    public static void main(String[] args) throws JSONException {
        
        String jsonString = "{\"name\":\"John\",\"age\":30,\"address\":\"Main Street\",\"phone\":\"69232223\"}";
        Person person = new Person();
        Json json = new Json(jsonString);
        json.parseJson(jsonString, person);

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Address: " + person.getAddress());
        System.out.println("Phone: " + person.getPhone());
    }
}
