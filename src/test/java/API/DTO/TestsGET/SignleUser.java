package API.DTO.TestsGET;

import com.fasterxml.jackson.databind.JsonNode;

public class SignleUser {
    public int id;
    public String email;
    public String first_name;
    public String last_name;
    public String avatar;
    public String url;
    public String text;

    JsonNode data;
    JsonNode support;

    public JsonNode getSupport() {
        return support;
    }

    public JsonNode getData() {
        return data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSupport(JsonNode support) {
        this.support = support;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setData(JsonNode data) {
        this.data = data;
    }
}
