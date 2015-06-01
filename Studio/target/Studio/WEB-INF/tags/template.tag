<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="rus">

<head>
    <title>Home - Home Page | Cinema - Free Website Template from Templates.com</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="${pageContext.request.contextPath}/res/css/style.css" rel="stylesheet" type="text/css" />
    <script src="${pageContext.request.contextPath}/res/js/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/res/js/Gill_Sans_400.font.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/res/js/cufon-replace.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/res/js/cufon-yui.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/res/js/script.js" type="text/javascript"></script>

</head>

<body id="page1" content="text/html; charset=utf-8">
<div class="tail-top">
    <div class="tail-bottom">
        <div id="main">
            <!--==============================
                          header
            =================================-->
            <header>
                <div id="header">
                    <div class="row-1">
                        <div class="fleft"><a href="index.html">Cinema <span>World</span></a></div>
                        <ul>
                            <li><a href="index.html"><img src="${pageContext.request.contextPath}/res/images/icon1-act.gif" alt="" /></a></li>
                            <li><a href="${pageContext.request.contextPath}/res/contact-us.html"><img src="${pageContext.request.contextPath}/res/images/icon2.gif" alt="" /></a></li>
                            <li><a href="${pageContext.request.contextPath}/WEB-INF/pages/sitemap.html"><img src="${pageContext.request.contextPath}/res/images/icon3.gif" alt="" /></a></li>
                        </ul>
                    </div>
                    <div class="row-2">
                        <ul>
                            <li><a href="index.html" class="active">Главная</a></li>
                            <li><a href="allProject">Проекты</a></li>
                            <li><a href="allActor">Актеры</a></li>
                            <li><a href="${pageContext.request.contextPath}/WEB-INF/pages/contact-us.html">Сотрудники</a></li>
                            <li class="last"><a href="${pageContext.request.contextPath}/WEB-INF/pages/sitemap.html">Карта сайта</a></li>
                        </ul>
                    </div>
                </div>
            </header>
            <!--=====================
                  Content
        ======================-->
            <section class="content">
                <div id="slogan">
                    <div class="image png"></div>
                    <div class="inside">
                        <h2>Вас приветствует студия озвучивания<span>Cinema World</span></h2>
                    </div>
                </div>
                <div class="box">
                    <div class="border-right">
                        <div class="border-left">
                            <div class="inner">
                                <jsp:doBody/>
                            </div>
                        </div>
                    </div>
                </div>

            </section>
            <!--==============================
                          footer
            =================================-->
            <div id="footer">
                <div class="left">
                    <div class="right">
                        <div class="inside">Copyright - Type in your name here<br />
                            <a rel="nofollow" href="http://www.templatemonster.com/" class="new_window">Website template</a> designed by TemplateMonster.com<br />
                            <a href="http://www.templates.com/product/3d-models/" class="new_window">3D Models</a> provided by Templates.com
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript"> Cufon.now(); </script>
</body>
</html>