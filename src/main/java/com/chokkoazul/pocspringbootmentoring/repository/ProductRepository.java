package com.chokkoazul.pocspringbootmentoring.repository;

import com.chokkoazul.pocspringbootmentoring.model.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Cristian Osorio (cristian.osorio@globant.com).
 */
public interface ProductRepository extends MongoRepository<Product, String> {
    Product findBy_id(ObjectId _id);

}