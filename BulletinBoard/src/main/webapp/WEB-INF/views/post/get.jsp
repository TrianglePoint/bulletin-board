<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="../includes/header.jsp" %>
<title><spring:message code="post.get.title" arguments="${post.title}" /></title>

<script src="/resources/js/common.js"></script>
<script>
$(document).ready(function(){
	
	$('#modify').on('click', function(){
		$('form').attr('action', '/post/modify');
		$('#pono').val('${post.pono}');
		
		removeEmptyOnForm('form');
		
		$('form').submit();
	});
	
	$('#list').on('click', function(){
		$('form').attr('action', '/post/list');
		
		removeEmptyOnForm('form');
		
		$('form').submit();
	});
	
});
</script>
</head>
<body>
<table border="1">
	<tr>
		<th><spring:message code="post.common.title" /></th>
		<td><c:out value="${post.title}" /></td>
	</tr>
	<tr>
		<th><spring:message code="post.common.writer" /></th>
		<td><c:out value="${post.writer}" /></td>
	</tr>
	<tr>
		<td colspan="3"><c:out value="${post.text}" /></td>
	</tr>
</table>

<button id="modify"><spring:message code="post.common.modify" /></button>
<button id="list"><spring:message code="post.common.list" /></button>

<form action="/" method="get">
	<input type="hidden" id="pono" name="pono" />
	
	<input type="hidden" name="pageNum" value="<c:out value='${pageInfo.pageNum}' />"/>
	<input type="hidden" name="type" value="<c:out value='${pageInfo.type}' />"/>
	<input type="hidden" name="keyword" value="<c:out value='${pageInfo.keyword}' />"/>
</form>
</body>
</html>