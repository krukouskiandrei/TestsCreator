package by.bsu.krukouski.testscreator.subject;

import java.io.Serializable;

/**
 * Created by Krukouski Andrei on 26.12.2015.
 */
public abstract class Entity implements Serializable, Cloneable {//абстарктный класс который реализует общую сущность данных из БД

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
