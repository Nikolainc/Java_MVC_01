package core.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import core.model.Drink;

public class Automat<T extends Drink> implements IAutomat<T>, Iterable<T> {

    private List<T> products;

    public Automat() {

        this.products = new ArrayList<T>();

    }

    @Override
    public List<T> gProducts() {
        
        return this.products;

    }

    @Override
    public List<T> gProducts(IRequest<T> request) {

        return request.filter(this.products);

    }

    @Override
    public List<T> gProducts(List<IRequest<T>> request) {

        List<T> requestList = new ArrayList<>();
        requestList.addAll(this.products);
        
        for (IRequest<T> req : request) {

            requestList = req.filter(requestList);

        }

        return requestList;

    }

    @Override
    public boolean addProducts(List<T> productFeed) {
        
        if (this.products.isEmpty()) {

            this.products = productFeed;

            return true;

        }

        return false;

    }

    @Override
    public boolean addProduct(T product) {

        if (this.products.contains(product)) {

            return false;

        } else {

            return this.products.add(product);

        }

    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            private int index = 0;

            @Override
            public boolean hasNext() {

                return index < products.size();

            }

            @Override
            public T next() {

                if (index >= products.size()) {

                    throw new NoSuchElementException();

                }

                return products.get(index++);

            }

        };

    }

    
    
}
