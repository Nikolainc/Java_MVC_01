package core.Service;

import java.util.List;

import core.model.Drink;

public interface IAutomat<T extends Drink> {

    public List<T> gProducts();

    public List<T> gProducts(IRequest<T> request);

    public List<T> gProducts(List<IRequest<T>> request);

    public boolean addProducts(List<T> productFeed);

    public boolean addProduct(T product);
    
}
