package entity;

import java.util.List;
import java.util.Objects;

//        b. ClassB – Store с полями:
//        o String name
//        o List<Item> items
//        o List<String> feedbackList
public class Store {
    private String name;
    private List<Item> items;
    private List<String> feedbackList;

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<String> getFeedbackList() {
        return feedbackList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setFeedbackList(List<String> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public Store() {
    }

    public Store(String name) {
        this.name = name;
    }

    public Store(String name, List<Item> items, List<String> feedbackList) {
        this.name = name;
        this.items = items;
        this.feedbackList = feedbackList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Store={name='");
        sb.append(name);
        sb.append("', feedbackList=");
        sb.append(feedbackList);
        sb.append(", items=['");
        items.forEach(it -> sb.append(it.getName() + "', "));
        sb.append("]}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(name, store.name) &&
                Objects.equals(items, store.items) &&
                Objects.equals(feedbackList, store.feedbackList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, items, feedbackList);
    }
}
