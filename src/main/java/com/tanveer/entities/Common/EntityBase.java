package com.tanveer.entities.Common;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public class EntityBase {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    @Column(name="created_at")
    private Date createdAt;
    @Column(name="is_deleted")
    private boolean isDeleted;
    @Column(name="created_by")
    private String createdBy;

    public EntityBase() {
        this.id=UUID.randomUUID().toString();
        this.createdAt = new Date();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public void setCreatedBy(String created_by) {
        this.createdBy = created_by;
    }

    public String getId() {
        return id;
    }

    public Date getCreated_at() {
        return createdAt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public String getCreated_by() {
        return createdBy;
    }
}
