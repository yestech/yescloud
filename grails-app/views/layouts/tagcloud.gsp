<!-- tagcloud.jsp -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://randomcoder.com/tags-escape" prefix="rcesc" %>
<div class="sectionHeading">Tags</div>
<div class="sectionContent" align="right">
  <div class="tagCloud">
    <c:forEach
        var="tagCloudEntry"
        items="${tagCloud}"
        varStatus="status">
      <c:url var="tagLink"
        value="/tags/${rcesc:urlencode(tagCloudEntry.tag.name)}" />
      <c:url var="tagClass" value="cloud${tagCloudEntry.scale}" />
      <c:if test="${status.index > 0}">::</c:if>
      <a rel="tag" class="tag ${tagClass}" href="${tagLink}">
        <c:out value="${tagCloudEntry.tag.displayName}" />
      </a>
    </c:forEach>
  </div>
</div>