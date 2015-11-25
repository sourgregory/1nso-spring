<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<layout:main>

    <div class="site-index">
        <article class="index_thumb">
            <h2><?= $index_page->getTitle() ?></h2>
            <p><?= $index_page->getText()?></p>
        </article>


        <div class="body-content">
            <?php foreach($categories->models as $category): ?>
                <div class="row">
                    <h2><?= Html::a($category->getTitle(), ['cat-articles/view', 'name' => $category->getSlug()], ['title' => $category->getTitle()]) ?></h2>
                    <div class="articles">
                        <?php foreach($category->getChildren()->models as $article): ?>
                            <div class="col-sm-4">
                                <article class="index_thumb">

                                    <h2><?= Html::a($article->getTitle(), ['articles/view', 'name' => $article->getSlug()]) ?></h2>
                                    <p><?= $article->getDescription() ?></p>

                                </article>
                            </div>
                        <?php endforeach; ?>
                    </div>
                </div>
            <?php endforeach; ?>
        </div>

    </div>
</layout:main>