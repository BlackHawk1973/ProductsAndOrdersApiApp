package org.top.productsandordersapiapp.mock;

import org.springframework.stereotype.Service;
import org.top.productsandordersapiapp.entity.Product;
import org.top.productsandordersapiapp.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Имплементация интерфейса ProductService без базыданных (работа с коллекцией объектов)
@Service
public class MockProductService implements ProductService {

    //Объявление коллекции объектов сущности Product
    private static final List<Product> products = new ArrayList<>();
    private static Integer nextId = 1; //Объявление счетчика для реализации поля id из класса Product

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(products);
    } //Реализация метода выборки всех объектов

    @Override
    public Optional<Product> getById(Integer id) { //Реализация метода поиска объекта по id в коллекции
        // return products.stream().filter(p -> Objects.equals(p.getId(), id)).findFirst();
        for (Product product : products) { //Цикл перебора объектов в коллекции
            if (product.getId().equals(id)) {
                return Optional.of(product); //Возвращение найденного объекта
            }
        }
        return Optional.empty(); //Возвращение null, т.к. объект не был найден
    }

    @Override
    public Product add(Product product) { //Реализация метода добавление нового объекта в коллекцию
        product.setId(nextId++);    //Увеличение счетчика
        products.add(product);      //Добавление объекта
        return product;             //Возвращение добавленного объекта
    }

    @Override
    public Boolean deleteById(Integer id) { //Реализация метода удаления объекта из коллекции
        Optional<Product> deleted = getById(id); //Вызов метода поиска по id, присваивание объекту deleted найденного объекта
        deleted.ifPresent(products::remove);    //Удаление найденного объекта из коллекции
        return deleted.isPresent(); //Возвращение удаленного объекта или null, если объект не был найден
    }

    @Override
    public Optional<Product> update(Product product) {
        Optional<Product> updated = getById(product.getId()); //Вызов метода поиска по id, присваивание объекту updated найденного объекта
        if (updated.isEmpty()) {
            return Optional.empty(); //Возврат null, если объек не был найден в коллекции
        }
        //Обновление полей объекта в коллекции
        updated.get().setTitle(product.getTitle());
        updated.get().setPrice(product.getPrice());
        updated.get().setQuantity(product.getQuantity());
        updated.get().setDescription(product.getDescription());
        //
        return updated; //Возврат обновленного объекта
    }
}
