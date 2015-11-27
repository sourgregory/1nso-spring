package ua.upsite.nso.model.statics;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *  Created by gregory on 11/19/15.
 */

@Entity
@DiscriminatorValue("category")
public class Category extends StaticItem{
}
