package app.simplypay.demoapp.api;

import java.util.HashMap;

/**
 * Created by jagadeeshakn on 3/17/2016.
 */
public class GenericRequest {

    HashMap<String,Object> requestFields = new HashMap<String, Object>();

    public HashMap<String, Object> getRequestFields() {
        return requestFields;
    }

    public void setRequestFields(HashMap<String, Object> requestFields) {
        this.requestFields = requestFields;
    }
}
