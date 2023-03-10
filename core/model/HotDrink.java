package core.model;

import java.util.Objects;

public class HotDrink extends Drink {

    private int temp;

    public HotDrink(String name, int volume, int temp) {

        super(name, volume);
        this.temp = temp;

    }

    public int gTemp() {

        return this.temp;

    }

    @Override
    public String toString() {
        
        return String.format("%s, Temperture: %s C", super.toString(), this.temp);

    }

    @Override
    public boolean equals(Object obj) {

        if (obj != null && obj.getClass() == this.getClass()) {

            return super.equals(obj) && this.temp == ((HotDrink) obj).temp;

        }

        return false;

    }

    @Override
    public int hashCode() {

        return Objects.hash(this.temp, super.hashCode());

    }
    
}
