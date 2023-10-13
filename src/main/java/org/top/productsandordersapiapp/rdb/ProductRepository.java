package org.top.productsandordersapiapp.rdb;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.top.productsandordersapiapp.entity.Product;

//Объявление Интерфейса класса ProductRepository, который является наследником класса CrudRepository,
// для выполнения CRUD - операций с сущностью Product
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
