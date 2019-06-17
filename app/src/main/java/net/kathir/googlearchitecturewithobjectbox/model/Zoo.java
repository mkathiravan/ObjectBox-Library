package net.kathir.googlearchitecturewithobjectbox.model;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

@Entity
public class Zoo {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    private long id;
    private String name;

    @Backlink
    public ToMany<Animal> animals;

    public Zoo()
    {

    }
    public Zoo(String name)
    {
        this.name = name;
    }



}
