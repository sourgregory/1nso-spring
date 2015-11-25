package ua.upsite.nso.model.statics;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *  Created by gregory on 11/19/15.
 */

@Entity
@Table(name = "static")
@DiscriminatorValue("article")
public class Article extends StaticItem{

}
