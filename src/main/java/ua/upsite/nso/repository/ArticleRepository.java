package ua.upsite.nso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.upsite.nso.model.statics.Article;

import java.util.Set;

/**
 *  Created by gregory on 11/22/15.
 */

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{

    @Query("select a from Article a join fetch a.content c join fetch c.language where c.language.id = 1")
    Set<Article> find();
}
