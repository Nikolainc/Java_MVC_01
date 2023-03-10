package core.Service;

import java.util.List;

import core.model.Drink;

public interface IRequest<T extends Drink> {
    
    public List<T> filter(List<T> request);

    public void setRequest(String value);

}
