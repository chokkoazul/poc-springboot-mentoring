package com.chokkoazul.pocspringbootmentoring.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Cristian Osorio (cristian.osorio@globant.com).
 */
@Document(collection = "products")
public class Product {
    @Id
    public ObjectId _id;
    public String id;
    public String title;
    public String description;

    public Product() {
    }

    public String getId() {
        return this._id.toString();
    }

    public Product(ObjectId _id, String title, String description) {
        this._id = _id;
        this.title = title;
        this.description = description;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}