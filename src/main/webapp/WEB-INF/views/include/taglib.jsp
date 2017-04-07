<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="fnc" uri="/WEB-INF/tlds/fnc.tld" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<%@ taglib prefix="act" tagdir="/WEB-INF/tags/act" %>
<%@ taglib prefix="cms" tagdir="/WEB-INF/tags/cms" %>
<c:set var="ctxApp" value="${pageContext.request.contextPath }"/>
<c:set var="ctx" value="${pageContext.request.contextPath }${fns:getAdminPath() }"/>
<c:set var="ctxAdmin" value="${ctxApp }${fns:getAdminPath() }"/>
<c:set var="ctxStatic" value="${ctxApp }/static"/>
<c:set var="assetsPath" value="${ctxStatic }/metronic/assets"/>
<c:set var="globalPluginsPath" value="${assetsPath }/global/plugins"/>
<c:set var="globalAssetsPath" value="${assetsPath }/global"/>
<c:set var="layoutAssetsPath" value="${assetsPath }/layouts/layout"/>
<c:set var="layoutGlobalAssetsPath" value="${assetsPath }/layouts/global"/>