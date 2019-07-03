<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%@ include file="../includes/header.jsp" %>
<title>Register</title>

<script src="/resources/js/common.js"></script>
<script>
  $(document).ready(function(){
	  
	$('#list').on('click', function(e){
	  e.preventDefault();
	  
	  removeEmptyOnForm('#hiddenForm');	
	  
	  $('#hiddenForm').attr('action', '/post/list');
	  $('#hiddenForm').submit();
	});
	
  });
</script>
</head>
<body>
<form action="/post/register" method="post">
  <div>Title <input type="text" name="title" /></div>
  <div>Writer <input type="text" name="writer" /></div>
  <div><textarea rows="3" name="text"></textarea></div>
  <div>
    <input type="submit" value="Submit" />
    <button id="list">List</button>
  </div>
</form>

<form id="hiddenForm">
  <input type="hidden" name="pageNum" value="<c:out value='${pageInfo.pageNum}' />"/>
  <input type="hidden" name="type" value="<c:out value='${pageInfo.type}' />"/>
  <input type="hidden" name="keyword" value="<c:out value='${pageInfo.keyword}' />"/>
</form>
</body>
</html>