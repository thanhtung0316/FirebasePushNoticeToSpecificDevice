package com.thanhtung.myapplication;

class Data {
    private String message;
    private String url;
    private String uid;
    private String kind;

    public Data(String message, String url, String uid, String kind) {
        this.message = message;
        this.url = url;
        this.uid = uid;
        this.kind = kind;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
