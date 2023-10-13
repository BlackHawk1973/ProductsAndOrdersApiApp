package org.top.productsandordersapiapp.rdb;

import org.springframework.stereotype.Service;
import org.top.productsandordersapiapp.entity.Product;
import org.top.productsandordersapiapp.service.ProductService;

import java.util.List;
import java.util.Optional;

//Объявление класса RdbProductService, который реализует логику контроллера ProductController и является
//имлементацией интерфейса ProductService при помощи инерфейса ProductRepository
@Service
public class RdbProductService implements ProductService {

    // внедрение репоизторий в имплементацию сервиса через DI
    private final ProductRepository productRepository;

    public RdbProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Метод getAll(), реализущий получение коллекции всех сущностей класса Product
    @Override
    public List<Product> getAll() {
        return (List<Product>)productRepository.findAll();
    }

    //Метод getById, реализующий поиск по id объекта из репозитория
    @Override
    public Optional<Product> getById(Integer id) {
        return productRepository.findById(id);
    }

    //Метод add, реализующий добавление нового объекта из коллекцию сущностей класса Product
    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }

    //Метод deleteById, реализующий поиск по id объекта из репозитория, и, если объект найден, удаляет его из репозитория
    @Override
    public Boolean deleteById(Integer id) {
        Optional<Product> deleted = productRepository.findById(id);
        if (deleted.isPresent()) {
            productRepository.deleteById(id); //Удаление найденного объекта из коллекции
        }
        return deleted.isPresent(); //Возвращает true, если объект был найден или false, если объект не был найден.
    }

    //Метод update, реализующий обновление данных объекта из репозитория
    @Override
    public Optional<Product> update(Product product) {
        Optional<Product> updated = productRepository.findById(product.getId()); //Присваивает объекту updated результат
        //поиска объекта в репозитории. Если обект не найден присваивает пустой объект
        if (updated.isPresent()) { //Проверка на то, что объект updated не пустой
            productRepository.save(product); //Обновление полей объекта в репозитории
            return Optional.of(product); //возвращение ответа в виде обновленного объекта
        }
        return Optional.empty(); //Возвращение null
    }
}
