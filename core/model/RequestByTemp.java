package core.model;

import java.util.List;
import java.util.stream.Collectors;

import core.Service.IRequest;

public class RequestByTemp<T extends HotDrink> implements IRequest<T> {

    private int temp;

    public RequestByTemp() {
        this.temp = -1;
    }

    @Override
    public List<T> filter(List<T> request) {

        if (this.temp == -1) {

            return request;

        } else {

            return request.stream().filter(element -> element.gTemp() == this.temp).collect(Collectors.toList());

        }

    }

    @Override
    public void setRequest(String value) {

        this.temp = Integer.parseInt(value);

    }

    @Override
    public String toString() {

        return String.format("Запрос по температуре: ");

    }
    
}
