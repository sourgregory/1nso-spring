<nav id="w0" class="navbar-inverse nlkvdavbar-fixed-top navbar" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle" data-target="#w0-collapse" data-toggle="collapse" type="button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">
                <img alt="Первый Никовый Социум" src="/images/icons/logo_nso.png">
                <?= Html::encode($brandLabel) ?>
            </a>
        </div>
        <div id="w0-collapse" class="collapse navbar-collapse">
            <ul id="w1" class="navbar-nav navbar-right nav">
                <?php foreach ($pages->models as $page): ?>
                <li>
                    <?= Html::a($page->getTitle(), Url::to(['cat-articles/view', 'name' => $page->getSlug()])) ?>
                </li>
                <?php endforeach; ?>
                <?php foreach ($auth as $authItem): ?>
                <li>
                    <?= Html::a($authItem['label'], $authItem['url']) ?>
                </li>
                <?php endforeach; ?>
            </ul>
        </div>
    </div>
</nav>