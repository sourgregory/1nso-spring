package ua.upsite.nso.model.statics;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 *  Created by gregory on 11/19/15.
 */
@Entity
@Table(name = "static")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class StaticItem {

    private Long id;
    private boolean showInMenu;
    private boolean published;
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

    @Column(name = "show_in_menu")
    public boolean isShowInMenu() {
        return showInMenu;
    }

    public void setShowInMenu(boolean showInMenu) {
        this.showInMenu = showInMenu;
    }

    @OneToOne(targetEntity = Content.class)
    @JoinColumn(name = "id", referencedColumnName = "static_id")
//    @Where(clause = "static_content.language_id = 1")
    @Fetch(FetchMode.JOIN)
    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @OneToMany(targetEntity = Content.class)
    @JoinColumn(name = "static_id", referencedColumnName = "id")
    public Set<Content> getTranslations() {
        return translations;
    }

    public void setTranslations(Set<Content> translations) {
        this.translations = translations;
    }

    @Column(name = "is_published")
    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    @Column(name = "sort_weight")
    public int getSortWeight() {
        return sortWeight;
    }

    public void setSortWeight(int sortWeight) {
        this.sortWeight = sortWeight;
    }

    @Column(name = "created_at")
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "updated_at")
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Column(name = "deleted_at")
    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}
