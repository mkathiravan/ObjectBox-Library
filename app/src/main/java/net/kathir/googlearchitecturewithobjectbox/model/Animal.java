package net.kathir.googlearchitecturewithobjectbox.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

@Entity
public class Animal {

    @Id
    private long id;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    private String name;
    private String image;
    private String group;

    public ToOne<Zoo> zoo;

    public Animal()
    {

    }
    public Animal(String name,String image,String group)
    {
        this.name = name;
        this.image = image;
        this.group = group;
    }
}
