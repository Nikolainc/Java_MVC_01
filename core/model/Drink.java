package core.model;

import java.util.Objects;

public abstract class Drink {

    private String name;
    private int volume;

    protected Drink(String name, int volume) {

        this.name = name;
        this.volume = volume;

    }

    public int gVolume() {

        return this.volume;

    }

    public String gName() {

        return this.name;

    }

    @Override
    public String toString() {
        
        return String.format("Name: %s, Volume: %s ml", this.name, this.volume);

    }

    @Override
    public int hashCode() {

        return 13 * Objects.hash(this.name, this.volume);

    }

    @Override
    public boolean equals(Object obj) {

        if (obj != null && obj.getClass() == this.getClass()) {

            return this.name.equals(((Drink)obj).name) && this.volume == ((Drink)obj).volume;

        }

        return false;

    }
    
}
