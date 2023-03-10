package core.presenter;

import java.util.ArrayList;
import java.util.List;

import core.Service.IAutomat;
import core.Service.IRequest;
import core.model.Drink;
import core.view.IDataProvider;
import core.view.IView;

public class Presenter<T extends Drink> {

    private IAutomat<T> automat;
    private IView view;
    private List<IRequest<T>> request;
    private IDataProvider<T> provider;

    public Presenter(IView view, IAutomat<T> automat, IDataProvider<T> provider, List<IRequest<T>> requests) {

        this.view = view;
        this.automat = automat;
        this.provider = provider;
        this.request = requests;

    }

    public void loadFeed() {

        this.automat.addProducts(this.provider.loadFeed());

    }

    public void saveData() {

        this.provider.saveFeed(this.automat.gProducts());

    }

    public void getProduct() {

        for (IRequest<T> req : request) {

            System.out.println(req);
            req.setRequest(this.view.get());
            
        }

        var products = this.automat.gProducts(request);

        for (T item : products) {
            
            this.view.set(item.toString());

        }

    }

    public void getAllProduct() {

        var products = this.automat.gProducts();

        for (T item : products) {

            this.view.set(item.toString());

        }

    }
    
}
