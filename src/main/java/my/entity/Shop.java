package my.entity;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

//import lombok.Value;

//import javax.persistence.*;

//import org.hibernate.annotations.GenericGenerator;
//import org.springframework.stereotype.Repository;

//@Entity
//@Table(name = "Account", schema = "")
//@SuppressWarnings("serial")
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@Repository
//@Value
//@Document(collection = "shop")
//@PersistenceConstructor
public class Shop {
    public Shop() {
    }

    public Shop(String name){
        this();
        this.PLACE_NAME = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * id
     */
    @org.springframework.data.annotation.Id
    private String id;

    public String getPLACE_NAME() {
        return PLACE_NAME;
    }

    public void setPLACE_NAME(String PLACE_NAME) {
        this.PLACE_NAME = PLACE_NAME;
    }

    private String PLACE_NAME;

}
