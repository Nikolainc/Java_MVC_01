package core.view;

import java.util.List;

import core.model.Drink;

public interface IDataProvider<T extends Drink> {

    public List<T> loadFeed();

    public boolean saveFeed(List<T> data);
    
}
