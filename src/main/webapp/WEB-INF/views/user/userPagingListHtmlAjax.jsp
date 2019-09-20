<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<c:forEach items="${userList }" var="user">
	<tr class="userTr" data-userId="${user.userId}">
		<input type="hidden" value="${user.userId}"/>
		<td>${user.userId }</td>
		<td>${user.userNm }</td>
		<td>${user.alias }</td>
<%-- 										<td>${user.reg_dt }</td> --%>
		<td><fmt:formatDate value="${user.reg_dt }" pattern="yyyy/MM/dd"/></td>
	</tr>
</c:forEach>


######################!!!!!!!!!!!!!!!!!!!!!!!
<%-- 이전 페이지 가기 : 지금 있는 페이지에서 한 페이지 전으로 
					  단 1페이지인 경우는 li 태그에 class="disabled"를 추가하고
					  이동 경로는 차단
				--%>
			<c:choose>
				<c:when test="${param.page == 1}">
					<li class="disabled"> <!-- pagination << 화살표 -->
		        		<span aria-hidden="true">&laquo;</span>
		    		</li>
		    	</c:when>
		    	<c:otherwise>
					<li class=""> <!-- pagination << 화살표 -->
						<a href="javascript:getUserHtmlList(${pageVo.page-1}), (${pageVo.pagesize});">
						<span aria-hidden="true">&laquo;</span>
						</a>
		    		</li>
				</c:otherwise>
		    </c:choose>
		    
		<c:forEach begin="1" end="${paginationSize}" var="page">
			<c:choose>
				<c:when test="${page == pageVo.page}">
					<li class="active"><span>${page }</span></li>
				</c:when>
				<c:otherwise>
					<li><a href="javascript:getUserHtmlList(${page}, ${pageVo.pagesize});">${page }</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
			
			<li> <!-- pagination >> 화살표 -->
			<%-- 오른쪽으로 이동 --%>
		    <c:choose>
		    	<c:when test="${pageVo.page == paginationSize }">
		    		<li class="disabled">
		    			<span aria-hidden="true">&raquo;</span>
		    		</li>
		    	</c:when>
	    		<c:otherwise>
				<li class=""> <!-- pagination << 화살표 -->
					<a aria-label="Next" href="javascript:getUserHtmlList(${pageVo.page+1}, ${pageVo.pagesize});">
					<span aria-hidden="true">&raquo;</span>
					</a>
	    		</li>
				</c:otherwise>
		    </c:choose>
		    
<!-- 							      <a href="#" aria-label="Next"> -->
<!-- 							        <span aria-hidden="true">&raquo;</span> -->
<!-- 							      </a> -->
		    </li>
