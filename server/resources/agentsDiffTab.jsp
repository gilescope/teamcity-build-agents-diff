<%@ include file="/include-internal.jsp"%>

<jsp:useBean id="agents" type="java.util.List" scope="request"/>

<c:choose>
  <c:when test="${empty agents}">
    <span>Nothing to compare.</span>
  </c:when>
  <c:otherwise>
    <div class="actionBar">
      <label>Compare build agent</label>
      <forms:select name="agentAId" id="agentAId" style="width: 20em" enableFilter="true">
        <c:forEach items="${agents}" var="agentA">
          <c:set var="agentAId" value="${agentA.id}"/>
          <forms:option value="${agentAId}"><c:out value="${agentA.name}"/> <bs:agentShortStatus agent="${agentA}" showUnavailable="${true}"/></forms:option>
        </c:forEach>
      </forms:select>
      &nbsp;<label>with</label>
      <forms:select name="agentBId" id="agentBId" style="width: 20em" enableFilter="true">
        <c:forEach items="${agents}" var="agentB">
          <c:set var="agentBId" value="${agentB.id}"/>
          <forms:option value="${agentBId}"><c:out value="${agentB.name}"/> <bs:agentShortStatus agent="${agentB}" showUnavailable="${true}"/></forms:option>
        </c:forEach>
      </forms:select>
    </div>

    <c:import url="/agents/agentsDiffView.html"/>

  </c:otherwise>
</c:choose>