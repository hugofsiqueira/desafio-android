package com.pitang.hlfs.movielist.model;

import java.io.Serializable;

/**
 * Created by hlfs on 30/01/18.
 */

public class Movie implements Serializable {

    private String _id;
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
