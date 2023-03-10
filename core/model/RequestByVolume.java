package core.model;

import java.util.List;
import java.util.stream.Collectors;

import core.Service.IRequest;

public class RequestByVolume<T extends Drink> implements IRequest<T> {

    private int volume;

    public RequestByVolume() {
        this.volume = -1;
    }

    @Override
    public List<T> filter(List<T> request) {

        if (this.volume == -1) {

            return request;

        } else {

            return request.stream().filter(element -> element.gVolume() == this.volume).collect(Collectors.toList());

        }

    }

    @Override
    public void setRequest(String value) {

        this.volume = Integer.parseInt(value);

    }

    @Override
    public String toString() {

        return String.format("Запрос по объему: ");

    }
    
}
