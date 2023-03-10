package core.model;

import java.util.List;
import java.util.stream.Collectors;

import core.Service.IRequest;

public class RequestByName<T extends Drink> implements IRequest<T> {

    private String name;

    public RequestByName() {
        this.name = "";
    }

    @Override
    public List<T> filter(List<T> request) {
        
        if(this.name.equals("")) {

            return request;
            
        } else {

            return request.stream().filter(element -> element.gName().equals(
                    this.name)).collect(Collectors.toList());

        }
        
    }

    @Override
    public void setRequest(String value) {
        
        this.name = value;

    }

    @Override
    public String toString() {

        return String.format("Запрос по имени: ");

    }
    
}
