package ua.upsite.nso.model.statics;

import javax.persistence.*;
import java.sql.Date;

/**
 *  Created by gregory on 11/19/15.
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("article")
public class Article extends StaticItem{

}
