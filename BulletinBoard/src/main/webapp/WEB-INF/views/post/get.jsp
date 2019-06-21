<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="../includes/header.jsp" %>
<title>Get</title>
<script>
  $(document).ready(function(){
	$('#modify').on('click', function(){
	  $('form').attr('action', '/post/modify');
	  $('#pono').val('${post.pono}');
	  
	  $('form').submit();
	});
	$('#list').on('click', function(){
	  $('form').attr('action', '/post/list');
	  $('form').empty();
	  
	  $('form').submit();
	});
  });
</script>
</head>
<body>
<table border="1">
<tr>
  <th>Title</th>
  <td><c:out value="${post.title}" /></td>
</tr>
<tr>
  <th>Writer</th>
  <td><c:out value="${post.writer}" /></td>
</tr>
<tr>
  <td colspan="3"><c:out value="${post.text}" /></td>
</tr>
</table>
<form action="/" method="get">
  <input type="hidden" id="pono" name="pono" />
  <button id="modify">Modify</button>
  <button id="list">List</button>
</form>
</body>
</html>