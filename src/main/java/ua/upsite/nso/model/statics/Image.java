package ua.upsite.nso.model.statics;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *  Created by gregory on 11/19/15.
 */

@Entity
public class Image {

    private String id;
    private String path;


    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
