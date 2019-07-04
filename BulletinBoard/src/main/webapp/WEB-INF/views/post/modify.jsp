<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%@ include file="../includes/header.jsp" %>
<title>Modify</title>

<script src="/resources/js/common.js"></script>
<script>
$(document).ready(function(){
	
	$('#remove').on('click', function(e){
		e.preventDefault();
		    
		$('#submitForm').attr('action', '/post/remove');
		 
		$('#submitForm').submit();
	});
	
	$('#list').on('click', function(e){
		var hiddenForm = $('#hiddenForm');	
		
		e.preventDefault();	
		
		hiddenForm.attr('action', '/post/list');
		hiddenForm.attr('method', 'get');
		
		removeEmptyOnForm('#hiddenForm');
		
		hiddenForm.submit();
	});
	
});
</script>
</head>
<body>
<form id="submitForm" action="/post/modify" method="post">
	<input type="hidden" name="pono" value="<c:out value='${post.pono}' />" />
	<div>
		<span>Title</span>
		<input type="text" name="title" value="<c:out value='${post.title}' />" />
	</div>
	<div>
		<span>Writer</span>
		<input type="text" name="writer" value="<c:out value='${post.writer}' />" />
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

<form id="hiddenForm">
	<input type="hidden" name="pageNum" value="<c:out value='${pageInfo.pageNum}' />"/>
	<input type="hidden" name="type" value="<c:out value='${pageInfo.type}' />"/>
	<input type="hidden" name="keyword" value="<c:out value='${pageInfo.keyword}' />"/>
</form>
</body>
</html>