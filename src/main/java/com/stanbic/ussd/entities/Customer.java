package com.stanbic.ussd.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author bkariuki
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "CONTACT")
    private String contact;
    @Column(name = "STORE_NUMBER")
    private String storeNumber;
    @Column(name = "HEAD_OFFICE_NUMBER")
    private String headOfOfficeNumber;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "CREATION_DATE")
    private Date creationDate;

    public Customer() {
        this.creationDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
    }

    public String getHeadOfOfficeNumber() {
        return headOfOfficeNumber;
    }

    public void setHeadOfOfficeNumber(String headOfOfficeNumber) {
        this.headOfOfficeNumber = headOfOfficeNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Customer[" +
                "id=" + id +
                ", contact='" + contact + '\'' +
                ", storeNumber='" + storeNumber + '\'' +
                ", headOfOfficeNumber='" + headOfOfficeNumber + '\'' +
                ", phone='" + phone + '\'' +
                ", creationDate=" + creationDate +
                ']';
    }
}
