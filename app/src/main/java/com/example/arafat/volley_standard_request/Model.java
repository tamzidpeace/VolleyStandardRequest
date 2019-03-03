package com.example.arafat.volley_standard_request;

import org.json.JSONException;
import org.json.JSONObject;

public class Model {

    private String name, email, mobile;

    public static Model fromJson(JSONObject jsonObject)  {
        Model model = new Model();

        try {
            model.name = jsonObject.getJSONArray("response2").getJSONObject(0).getString("Name");
            model.email = jsonObject.getJSONArray("response2").getJSONObject(0).getString("Email");
            model.mobile = jsonObject.getJSONArray("response2").getJSONObject(0).getString("Mobile");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  model;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }
}
