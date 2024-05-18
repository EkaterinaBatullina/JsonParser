/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a.jsonparse;

import java.lang.reflect.Field;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author ekaterina
 */
public class Json {
    private JSONObject json;
    
    public Json(String json) throws JSONException {
        
        this.json = new JSONObject(json);
        
    }
    
    public void parseJson(String jsonString, Object obj) {

        Field[] fields = obj.getClass().getDeclaredFields();
        //получаем поля Person
        
        for (Field field : fields) {
            String fieldValue = json.optString(field.getName());
            //получаю значение ключа поля

            //проверка на тип поля
            //getSimpleName() - для получения класса искдючая пакет
            if (field.getType().getSimpleName().equals("String")) {
                try {
                    obj.getClass().getMethod("set" + field.getName().toUpperCase().charAt(0) +
            field.getName().substring(1), String.class).invoke(obj, fieldValue);
                } 
                catch (Exception e) {
                    e.printStackTrace();
                }
            } 
            //иначе исходное строковое значение обращаем в инт
            else if (field.getType().getSimpleName().equals("int")) {
                try {
                    obj.getClass().getMethod("set" + field.getName().toUpperCase().charAt(0) +
            field.getName().substring(1), int.class).invoke(obj, Integer.parseInt(fieldValue));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } 
            else {
                throw new IllegalArgumentException("Unsupported field type: " + field.getType().getSimpleName());
            }
        }
    }  
    
}
