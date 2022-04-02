<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.teschMeSkills.lesson27.twitterServlet.entity.Post" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Катя
  Date: 28.03.2022
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Posts</title>
    <jsp:include page="_header.jsp"/>
</head>
<body>

<div class="container-fluid d-flex justify-content-md-center">

    <div class="row col-6">
        <div class="col mt-3">
            <form action="/post" method="post" class="border border-light">
                <div class="form-floating my-3 px-3">
                        <textarea class="form-control" name="text" placeholder="Leave a text here"
                                  id="floatingTextarea2" style="height: 100px">
                        </textarea>
                    <button type="submit" class="btn btn-primary mt-2 pr-3">Add new post</button>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="container-fluid d-flex justify-content-md-center">
    <div class="row col-6">
        <div class="col mt-3">

            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Dropdown button
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="/post">Get only my posts</a>
                    <a class="dropdown-item" href="/postHistory">Get all posts</a>
                </div>
            </div>


            <form action="/post" method="get" class="border border-light">
                <div class="form-floating my-3 px-3">

                    <c:forEach var="post" items="${allPosts}">
                        <p class="text-left"> ID: ${post.idPost}</p>
                        <p class="text-left"> User: ${post.user.login}</p>
                        <p class="text-left"> text: ${post.text}</p>
                        <div class="d-inline">
                            <p> likes: ${post.likeList}</p>
                            <p>comments: ${post.commentList}</p>
                        </div>

                        <div>
                            <button type="submit" name="buttonEdit" class="btn btn-outline-success mt-2 pr-3">Edit post
                            </button>
                            <button type="submit" name="buttonDelete" class="btn btn-outline-danger mt-2 pr-3">Delete post
                            </button>
                        </div>

                    </c:forEach>
                </div>
            </form>
        </div>
    </div>
</div>


<%--<ul class="list-group list-group-flush">--%>
<%--    <li class="list-group-item">Cras justo odio</li>--%>
<%--    <li class="list-group-item">Dapibus ac facilisis in</li>--%>
<%--    <li class="list-group-item">Morbi leo risus</li>--%>
<%--    <li class="list-group-item">Porta ac consectetur ac</li>--%>
<%--    <li class="list-group-item">Vestibulum at eros</li>--%>
<%--</ul>--%>

</body>
</html>
