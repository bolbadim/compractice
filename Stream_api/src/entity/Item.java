package entity;

import java.util.ArrayList;
import java.util.List;

//ClassA - Item с полями:
//        o String name
//        o Int price
//        o Int count
//        o List<Store> stores
public class Item {
    private String name;
    private int price;
    private int count;
    private List<Store> stores;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public List<Store> getStores() {
        return stores;
    }

    public Item() {
        this.stores = new ArrayList<>();
    }

    public Item(String name, int price, int count) {
        this.stores = new ArrayList<>();
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public Item(String name, int price, int count, List<Store> stores) {
        this(name, price, count);
        this.stores = stores;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Item={name='");
        sb.append(name);
        sb.append("', price=");
        sb.append(price);
        sb.append(", count=");
        sb.append(count);
        sb.append(", stores=[");
        stores.forEach(it-> sb.append(it.getName()+"', "));
        sb.append("]}");
        return sb.toString();
    }
}