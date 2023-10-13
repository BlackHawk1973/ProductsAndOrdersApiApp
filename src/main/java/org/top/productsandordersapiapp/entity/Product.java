package org.top.productsandordersapiapp.entity;

import jakarta.persistence.*;

// Класс Product - описывает объект товара
// соответсвует таблицы product_t из БД
// хранить информацию об объекте "Товар", не реализует бизнес-логику
// является dataclass-ом
@Entity
@Table(name = "product_t")
public class Product {
    // поля - соответствуют столбцам (атрибутам) таблице в БД
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Определение типа генератора значений поля id
    private Integer id; //Объявление переменной id класса Product

    //Установка соостветствия между полем title_f и переменной title, а также установка ограничения not null
    @Column(name="title_f", nullable = false)
    private String title; //Объявление переменной title класса Product

    //Установка соостветствия между полем price_f и переменной price, а также установка ограничения not null
    @Column(name="price_f", nullable = false)
    private Double price; //Объявление переменной price класса Product

    //Установка соостветствия между полем quantity_f и переменной quantity, а также установка ограничения not null
    @Column(name="quantity_f", nullable = false)
    private Integer quantity; //Объявление переменной quantity класса Product

    //Установка соостветствия между полем description_f и переменной description
    @Column(name="description_f") //Объявление переменной description класса Product
    private String description;

    // constructors

    // 1. конструктор по умолчанию
    public Product() {
        //Установка дефолтных значений переменных класса Product
        id = 0;
        title = "";
        price = 0.0;
        quantity = 0;
        description = null;
    }

    // getters & setters

    public Integer getId() {
        return id;
    } //Геттер переменной id

    public void setId(Integer id) {
        this.id = id;
    } //Сеттер переменной id

    public String getTitle() {
        return title;
    } //Геттер переменной title

    public void setTitle(String title) {
        this.title = title;
    } //Сеттер переменной title

    public Double getPrice() {
        return price;
    } //Геттер переменной price

    public void setPrice(Double price) {
        this.price = price;
    } //Сеттер переменной price

    public Integer getQuantity() {
        return quantity;
    } //Геттер переменной quantity

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    } //Сеттер переменной quantity

    public String getDescription() {
        return description;
    } //Геттер переменной description

    public void setDescription(String description) {
        this.description = description;
    } //Сеттер переменной description

    // представление объекта в виде строки
    @Override
    public String toString() {
        // Product(id=1,title="test",price=1000,quantity=100,description=null)
        // toString() -> "1 - test - 1000 - 100 - null"
        return id + " - " + title + " - " + price + " - " + quantity + " - " + description;
    }
}

