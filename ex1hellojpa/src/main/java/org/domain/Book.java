package org.domain;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class Book extends Item {

    private String book;
    private String isbn;
}
