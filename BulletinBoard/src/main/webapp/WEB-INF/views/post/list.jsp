<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../includes/header.jsp" %>
<title><spring:message code="post.list.title" /></title>
<style>
	.selected{
		font-weight: bold;
	}
</style>

<script src="/resources/js/common.js"></script>
<script>
$(document).ready(function(){
	
	$('#register').on('click', function(e){
		var hiddenForm = $('#hiddenForm');
	
		e.preventDefault();

		removeEmptyOnForm('#hiddenForm');
		
		hiddenForm.attr('action', '/post/register');
		hiddenForm.submit();
	});
	
	$('#postList a').on('click', function(e){
		var hiddenForm = $('#hiddenForm');
		var input = $('<input />');
		
		e.preventDefault();

		input.attr('type', 'hidden')
		     .attr('name', 'pono')
		     .attr('value', $(this).attr('href'));
		hiddenForm.append(input);

		removeEmptyOnForm('#hiddenForm');
		
		hiddenForm.attr('action', '/post/get');
		hiddenForm.submit();
	});
	
	$('#pageList a').on('click', function(e){
		var hiddenForm = $('#hiddenForm');
		var input = hiddenForm.find('input[name="pageNum"]');
		
		e.preventDefault();
		
		input.attr('value', $(this).attr('href'));
		
		removeEmptyOnForm('#hiddenForm');
		
		hiddenForm.attr('action', '/post/list');
		hiddenForm.submit();
	});
	
	$('#searchForm input[type="submit"]').on('click', function(e){
		e.preventDefault();
		
		if($('#searchForm input[name="keyword"]').val() == ''){
			alert('No keyword');
			return false;
		}
		
		$('#searchForm').submit();
	});
	
});
</script>
</head>
<body>
<table border="1" id="postList">
	<tr>
		<td><spring:message code="post.common.number" /></td>
		<td><spring:message code="post.common.title" /></td>
		<td><spring:message code="post.common.text" /></td>
		<td><spring:message code="post.common.writer" /></td>
		<td><spring:message code="post.common.regDate" /></td>
		<td><spring:message code="post.common.updateDate" /></td>
	</tr>
<c:forEach items="${list}" var="post">
	<tr>
		<td><c:out value="${post.pono}" /></td>
		<td><a href="<c:out value='${post.pono}' />"><c:out value="${post.title}" /></a></td>
		<td><c:out value="${post.text}" /></td>
		<td><c:out value="${post.writer}" /></td>
		<td><fmt:formatDate value="${post.regDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		<td><fmt:formatDate value="${post.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	</tr>
</c:forEach>
</table>
<button id="register"><spring:message code="post.common.register" /></button>

<!-- Page list -->
<div id="pageList">
	<c:if test="${pageListInfo.previous}">
		<a href="<c:out value='${pageListInfo.startPage - 1}' />">
			<spring:message code="post.common.previous" />
		</a>
	</c:if>
	<c:forEach var="page" begin="${pageListInfo.startPage}" end="${pageListInfo.endPage}">
		<a class="${pageInfo.pageNum == page ? 'selected' : ''}"
			href="<c:out value='${page}' />">${page}</a> 
	</c:forEach>
	<c:if test="${pageListInfo.next}">
		<a href="<c:out value='${pageListInfo.endPage + 1}' />">
			<spring:message code="post.common.next" />
		</a>
	</c:if>
</div>

<div>
	<form id="searchForm" action="/post/list">
		<select name="type">
			<option value="T" <c:out value="${pageInfo.type == 'T' ? 'selected' : ''}" />>
				<spring:message code="post.common.title" />
			</option>
			<option value="X" <c:out value="${pageInfo.type == 'X' ? 'selected' : ''}" />>
				<spring:message code="post.common.text" />
			</option>
			<option value="W" <c:out value="${pageInfo.type == 'W' ? 'selected' : ''}" />>
				<spring:message code="post.common.writer" />
			</option>
			<option value="TX" <c:out value="${pageInfo.type == 'TX' ? 'selected' : ''}" />>
				<spring:message code="post.common.title" /> + 
				<spring:message code="post.common.text" />
			</option>
			<option value="TXW" <c:out value="${pageInfo.type == 'TXW' ? 'selected' : ''}" />>
				<spring:message code="post.common.title" /> + 
				<spring:message code="post.common.text" /> + 
				<spring:message code="post.common.writer" />
			</option>
		</select>
		<input type="text" name="keyword" value="<c:out value='${pageInfo.keyword}' />"/>
		<input type="submit" value="<spring:message code='post.common.search' />" />
	</form>
</div>

<form id="hiddenForm">
	<input type="hidden" name="pageNum" value="<c:out value='${pageInfo.pageNum}' />"/>
	<input type="hidden" name="type" value="<c:out value='${pageInfo.type}' />"/>
	<input type="hidden" name="keyword" value="<c:out value='${pageInfo.keyword}' />"/>
</form>

</body>
</html>