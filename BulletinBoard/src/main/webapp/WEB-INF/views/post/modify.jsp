<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%@ include file="../includes/header.jsp" %>
<title>Modify</title>
<script>
  $(document).ready(function(){
	$('#remove').on('click', function(){
	  $('form').attr('action', '/post/remove');
	  
	  $('form').submit();
	});
	$('#list').on('click', function(){
	  $('form').attr('action', '/post/list');
	  $('form').attr('method', 'get');
	  $('form').empty();
	  
	  $('form').submit();
	});
  });
</script>
</head>
<body>
<form action="/post/modify" method="post">
  <input type="hidden" name="pono" value="<c:out value="${post.pono}"></c:out>" />
  <div>
    <span>Title</span> 
    <input type="text" name="title" value="<c:out value="${post.title}"></c:out>" />
  </div>
  <div>
    <span>Writer</span>
    <input type="text" name="writer" value="<c:out value="${post.writer}"></c:out>" />
  </div>
  <div>
    <textarea rows="3" name="text"><c:out value="${post.text}" /></textarea>
  </div>
  <div>
    <input type="submit" value="Submit" />
    <button id="list">List</button>
    <br /><br />
    <button id="remove">Remove</button>
  </div>
</form>
</body>
</html>