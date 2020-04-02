package run;

import entity.Item;
import entity.Store;
import stream.StreamController;

import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class.getName());
    public static void main(String[] args) {
        log.info("Hello user");
        Store st = new Store("StoreName");
        Store st2 = new Store("StoreName2");
        Item it = new Item("Красавец",600,3,Arrays.asList(st));
        Item it2 = new Item("JS",600,5,Arrays.asList(st,st2));
        Item it3 = new Item("Java lang ed.1",400,1,Arrays.asList(st2));
        Item it4 = new Item("Tolkien",100,15);
        st.setItems(Arrays.asList(it,it2));
        st2.setItems(Arrays.asList(it2,it3));
        List<Item> itemList = Arrays.asList(it,it2,it3,it4);
        StreamController stream = new StreamController();
        long time = System.nanoTime();
        Boolean flag = stream.isMoreThen500Exist(itemList);
        time = System.nanoTime() - time;
        System.out.println("More then 500: " + flag);
        log.info("time without p: " + time);
        time = System.nanoTime();
        flag = stream.isMoreThen500Exist(itemList);
        time = System.nanoTime() - time;
        System.out.println("More then 500: " + flag);
        log.info("time with p: " + time);
        System.out.println("\nMax by count: " + stream.max(itemList));
        try {
            System.out.println("\nMin by count: " + stream.min(itemList));
        } catch (Exception ex){
            System.out.println("\nNo values represented");
        }
        System.out.println("\nExist in one store: " + stream.existInOneStore(itemList));
        time = System.nanoTime();
        List<Item> result = stream.sortByPriceAndCount(itemList);
        time = System.nanoTime() - time;
        System.out.println("\nSorted by price and count: " + result);
        log.info("time without p: " + time);
        time = System.nanoTime();
        result = stream.sortByPriceAndCountPar(itemList);
        time = System.nanoTime() - time;
        System.out.println("\nSorted by price and count: " + result);
        log.info("time with p: " + time);
        System.out.println("Unique stores: " + stream.getStores(itemList));
    }
}