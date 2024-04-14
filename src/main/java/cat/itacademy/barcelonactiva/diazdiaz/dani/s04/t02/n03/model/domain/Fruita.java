package cat.itacademy.barcelonactiva.diazdiaz.dani.s04.t02.n03.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fruita")
public class Fruita {

    @Id
    private String id;
    private String name;
    private int quantitatKg;


    public Fruita(){

    }

    public Fruita(String name, int quantitatKg) {
        this.name = name;
        this.quantitatKg = quantitatKg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantitatKg() {
        return quantitatKg;
    }

    public void setQuantitatKg(int quantitatKg) {
        this.quantitatKg = quantitatKg;
    }

    @Override
    public String toString() {
        return "Fruita " + getName() + "con ID: " + getId() + " y " + getQuantitatKg() + "kg";
    }
}
