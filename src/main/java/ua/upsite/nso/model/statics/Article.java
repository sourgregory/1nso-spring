package ua.upsite.nso.model.statics;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *  Created by gregory on 11/19/15.
 */

@Entity
@DiscriminatorValue("article")
public class Article extends StaticItem{

}
