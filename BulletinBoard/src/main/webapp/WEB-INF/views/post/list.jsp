<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../includes/header.jsp" %>
<title>List</title>
<style>
  .selected{
    font-weight: bold;
  }
</style>

<script src="/resources/js/common.js"></script>
<script>
  $(document).ready(function(){
	  
	$('#register').on('click', function(){
		location.href = '/post/register';
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
    <td><a href="<c:out value='${post.pono}'></c:out>"><c:out value="${post.title}" /></a></td>
    <td><c:out value="${post.text}" /></td>
    <td><c:out value="${post.writer}" /></td>
    <td><fmt:formatDate value="${post.regDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
    <td><fmt:formatDate value="${post.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
  </tr>
</c:forEach>
</table>
<button id="register">Register</button>

<!-- Page list -->
<div id="pageList">
  <c:if test="${pageListInfo.previous}">
  <a href="<c:out value='${pageListInfo.startPage - 1}'></c:out>">Previous</a>
  </c:if>
<c:forEach var="page" begin="${pageListInfo.startPage}" end="${pageListInfo.endPage}">
  <a class="${pageInfo.pageNum == page ? 'selected' : ''}"
  href="<c:out value='${page}'></c:out>">${page}</a> 
</c:forEach>
  <c:if test="${pageListInfo.next}">
  <a href="<c:out value='${pageListInfo.endPage + 1}'></c:out>">Next</a>
  </c:if>
</div>

<div>
  <form id="searchForm" action="/post/list">
    <select name="type">
      <option value="T" <c:out value="${pageInfo.type == 'T' ? 'selected' : ''}" />>
        Title
      </option>
      <option value="X" <c:out value="${pageInfo.type == 'X' ? 'selected' : ''}" />>
        Text
      </option>
      <option value="W" <c:out value="${pageInfo.type == 'W' ? 'selected' : ''}" />>
        Writer
      </option>
      <option value="TX" <c:out value="${pageInfo.type == 'TX' ? 'selected' : ''}" />>
        Title + Text
      </option>
      <option value="TXW" <c:out value="${pageInfo.type == 'TXW' ? 'selected' : ''}" />>
        Title + Text + Writer
      </option>
    </select>
    <input type="text" name="keyword" value="<c:out value='${pageInfo.keyword}' />"/>
    <input type="submit" value="Search" />
  </form>
</div>

<form id="hiddenForm">
  <input type="hidden" name="pageNum" value="<c:out value='${pageInfo.pageNum}' />"/>
  <input type="hidden" name="type" value="<c:out value='${pageInfo.type}' />"/>
  <input type="hidden" name="keyword" value="<c:out value='${pageInfo.keyword}' />"/>
</form>

</body>
</html>