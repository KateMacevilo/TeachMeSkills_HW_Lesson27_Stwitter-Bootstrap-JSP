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

<div class="row">
    <div class="col mt-3">
        <form action="/post" method="get">
            <%
                ArrayList allPosts = (ArrayList) request.getAttribute("allPosts");
                if (allPosts != null) {
                    for (Object post : allPosts) {
                        out.println(post);
                    }
                }
            %>

            <button type="submit" class="btn btn-primary">Get Info</button>
        </form>
    </div>

    <div class="col mt-3">
        <div class="row">
            <div class="col-6">
                <form action="/post" method="post">
                    <div class="form-floating">
                        <textarea class="form-control" name="text" placeholder="Leave a text here"
                                  id="floatingTextarea2" style="height: 100px"></textarea>
                    </div>

                    <button type="submit" class="btn btn-primary">Add new post</button>
                </form>
            </div>
        </div>

    </div>
</div>


</body>
</html>
