<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../includes/header.jsp" %>
<title>Register</title>
<script>
  $(document).ready(function(){
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
<form action="/post/register" method="post">
  <div>Title <input type="text" name="title" /></div>
  <div>Writer <input type="text" name="writer" /></div>
  <div><textarea rows="3" name="text"></textarea></div>
  <div>
    <input type="submit" value="Submit" />
    <button id="list">List</button>
  </div>
</form>
</body>
</html>