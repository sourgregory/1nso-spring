package ua.upsite.nso.model.statics;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 *  Created by gregory on 11/19/15.
 */

@MappedSuperclass
@DiscriminatorColumn(name = "type")
public abstract class StaticItem {

    private Long id;
    private boolean showInMenu;
    private boolean isPublished;
    private String type;
    private int sortWeight;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
    private Content content;
    private Set<Content> translations;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isShowInMenu() {
        return showInMenu;
    }

    public void setShowInMenu(boolean showInMenu) {
        this.showInMenu = showInMenu;
    }

    @OneToOne(targetEntity = Content.class)
    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @OneToMany(targetEntity = Content.class)
    @JoinTable(name = "static", joinColumns = {@JoinColumn(name = "id")}, inverseJoinColumns = {})
    public Set<Content> getTranslations() {
        return translations;
    }

    public void setTranslations(Set<Content> translations) {
        this.translations = translations;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSortWeight() {
        return sortWeight;
    }

    public void setSortWeight(int sortWeight) {
        this.sortWeight = sortWeight;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}
