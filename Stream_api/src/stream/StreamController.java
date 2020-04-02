package stream;

import entity.Item;
import entity.Store;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamController {
    private static final Logger log = LogManager.getLogger(StreamController.class.getName());

    public StreamController() {
    }

    public boolean isMoreThen500Exist(List<Item> itemList) {
        return itemList.stream().filter((it) -> it.getPrice() > 500).peek(it -> log.debug(it)).count() > 0 ? true : false;
    }

    public boolean isMoreThen500ExistPar(List<Item> itemList) {
        return itemList.parallelStream().filter((it) -> it.getPrice() > 500).peek(it -> log.debug(it)).count() > 0 ? true : false;
    }

    public Item max(List<Item> itemList) {
        Optional<Item> max_optional = itemList.stream().max(Comparator.comparingInt(Item::getCount));
        if (!max_optional.isPresent())
            System.out.println("List is probably empty");
        return max_optional.orElse(new Item());
    }

    public Item maxPar(List<Item> itemList) {
        Optional<Item> max_optional = itemList.parallelStream().max(Comparator.comparingInt(Item::getCount));
        if (!max_optional.isPresent())
            System.out.println("List is probably empty");
        return max_optional.orElse(new Item());
    }

    public Item min(List<Item> itemList) throws Exception {
        return itemList.stream().min(Comparator.comparingInt(Item::getCount)).orElseThrow(Exception::new);
    }

    public Item minPar(List<Item> itemList) throws Exception {
        return itemList.parallelStream().min(Comparator.comparingInt(Item::getCount)).orElseThrow(Exception::new);
    }

    public List<Item> existInOneStore(List<Item> itemList) {
        return itemList.stream().filter((it) -> it.getStores().size() == 1).peek(it -> log.debug(it)).collect((Collectors.toCollection(ArrayList::new)));
    }

    public List<Item> existInOneStorePar(List<Item> itemList) {
        return itemList.parallelStream().filter((it) -> it.getStores().size() == 1).peek(it -> log.debug(it)).collect((Collectors.toCollection(ArrayList::new)));
    }

    public List<Item> sortByPriceAndCount(List<Item> itemList) {
        return itemList.parallelStream().sorted(Comparator.comparing(Item::getPrice).thenComparing(Item::getCount)).collect((Collectors.toCollection(ArrayList::new)));
    }


    public List<Item> sortByPriceAndCountPar(List<Item> itemList) {
        return itemList.parallelStream().sorted(Comparator.comparing(Item::getPrice).thenComparing(Item::getCount)).collect((Collectors.toCollection(ArrayList::new)));
    }

    public List<Store> getStores(List<Item> itemList) {
        List<Store> stores = new ArrayList();
        itemList.stream().forEach(item -> {
            stores.addAll(item.getStores());
            log.debug(item.getStores());
        });
        return stores.stream().distinct().collect(Collectors.toList());
    }
}