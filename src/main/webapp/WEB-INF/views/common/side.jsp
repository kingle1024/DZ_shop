<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
 <style>
   .no-underline{
      text-decoration:none;
   }
 </style>
  <meta charset="UTF-8">
  <title>사이드 메뉴</title>
</head>
<body>
	<h1>사이드 메뉴</h1>
	<h1>
		<a href="${contextPath}/pro27/member/listMembers.do"  class="no-underline">회원관리</a><br>		
		<a href="${contextPath}/pro27/board/listArticles.do"  class="no-underline">게시판관리</a><br>
		<a href="${contextPath}/pro27/fileUploadForm.do"  class="no-underline">파일업로드</a><br>
		<a href="#"  class="no-underline">상품관리</a><br>
	</h1>
</body>
</html>