package com.equivi.mailsy.application.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "app_registry")
public class AppRegistryEntity extends BaseModel {

    private static final long serialVersionUID = -1195521598381696374L;
    @Column(name = "registry_key")
    private String registryKey;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "expiry_date")
    private Date expiryDate;

    public String getRegistryKey() {
        return registryKey;
    }

    public void setRegistryKey(String registryKey) {
        this.registryKey = registryKey;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
