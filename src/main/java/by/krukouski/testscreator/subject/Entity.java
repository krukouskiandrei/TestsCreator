package by.krukouski.testscreator.subject;

import java.io.Serializable;

/**
 * Created by Krukouski Andrei on 26.12.2015.
 */
public abstract class Entity implements Serializable, Cloneable {//abstract class that implements the general nature of the database

    private Integer id;
    public Entity(){}
    public Entity(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }

}
