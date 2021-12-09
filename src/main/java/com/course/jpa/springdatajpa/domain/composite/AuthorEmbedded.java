package com.course.jpa.springdatajpa.domain.composite;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="author_composite")
public class AuthorEmbedded {

    @EmbeddedId
    private NameId nameId;

    public AuthorEmbedded() {
    }

    public AuthorEmbedded(NameId nameId) {
        this.nameId = nameId;
    }

    public NameId getNameId() {
        return nameId;
    }

    public void setNameId(NameId nameId) {
        this.nameId = nameId;
    }
}
