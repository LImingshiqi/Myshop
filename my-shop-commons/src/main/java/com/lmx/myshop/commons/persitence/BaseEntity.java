package com.lmx.myshop.commons.persitence;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * 实体类的基类
 */
public abstract class BaseEntity implements Serializable {
    private Long id;
    private Date created;
    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Date getUpdate() {
        return updated;
    }

    public void setUpdate(Date update) {
        this.updated = update;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }


}
