package com.nax.entity;

import org.springframework.data.domain.Persistable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.beans.Transient;
import java.io.Serializable;

/**
 * Created by Maxim on 9/23/2017.
 */
@MappedSuperclass
public class AbstractEntity<PK extends Serializable> implements Persistable<PK> {
    private static long serialVersionUID = 999999999999999L;

    public AbstractEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private PK id;

    @Override
    public PK getId() {
        return id;
    }

    @Transient
    @Override
    public boolean isNew() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractEntity<?> that = (AbstractEntity<?>) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "id=" + id +
                '}';
    }
}
