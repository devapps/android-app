package app.simplypay.demoapp.api;

import java.util.HashMap;

/**
 * Created by jagadeeshakn on 3/17/2016.
 */
public class GenericResponse {
    HashMap<String,Object> responseFields = new HashMap<String, Object>();

    public HashMap<String, Object> getResponseFields() {
        return responseFields;
    }

    public void setResponseFields(HashMap<String, Object> responseFields) {
        this.responseFields = responseFields;
    }

    @Override
    public String toString() {
        return "GenericResponse{" +
                "responseFields=" + responseFields +
                '}';
    }
}
