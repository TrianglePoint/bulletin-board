<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../includes/header.jsp" %>
<title>List</title>
<script>
  $(document).ready(function(){
	$('#register').on('click', function(){
	  location.href = '/post/register';
	});
  });
</script>
</head>
<body>
<table border="1">
  <tr>
    <td>Number</td>
    <td>title</td>
    <td>text</td>
    <td>writer</td>
    <td>regDate</td>
    <td>updateDate</td>
  </tr>
<c:forEach items="${list}" var="post">
  <tr>
    <td><c:out value="${post.pono}" /></td>
    <td><a href="/post/get?pono=<c:out value='${post.pono}'></c:out>"><c:out value="${post.title}" /></a></td>
    <td><c:out value="${post.text}" /></td>
    <td><c:out value="${post.writer}" /></td>
    <td><fmt:formatDate value="${post.regDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
    <td><fmt:formatDate value="${post.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
  </tr>
</c:forEach>
</table>
<button id="register">Register</button>
</body>
</html>