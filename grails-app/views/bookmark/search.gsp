<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja" lang="ja">
  <head>
    <meta name="layout" content="bookmarkMain"/>
    <title>イベント検索</title>
  </head>
  <body>
    <div class="body">
      <h1>イベント検索</h1>
      <g:form action="search">
        <div class="dialog">
          <table>
            <tbody>
              <tr>
                <td valign="top" class="name">
                  <label for="title">キーワード:</label>
                </td>
                <td valign="top" class="value ${hasErrors(bean:event,field:'keyword','errors')}">
                  <g:textField name="keyword" value="${searchResult.keyword}"/>
                </td>
              </tr>
              <tr>
                <td valign="top" class="name">
                  <label for="title">今月～再来月開催のみ:</label>
                </td>
                <td valign="top">
                  <g:checkBox name="onlyFewDays" value="${searchResult.onlyFewDays}" />
                </td>
              </tr>
            </tbody>
          </table>
        </div>
        <div class="buttons">
          <g:submitButton name="doSearch" value="検索"/>
        </div>
      </g:form>

      <g:if test="${searchResult != null && searchResult.events != null && !searchResult.events.isEmpty()}">
        　　     <h1>「${searchResult.keyword}」の検索結果(${searchResult.available}件中${searchResult.start}-${searchResult.end}件目)
          <g:if test="${searchResult.prevable}">
            <g:link action="prev" params="${searchResult.searchParams}">前</g:link>
          </g:if>
          <g:else>前</g:else>
          <g:if test="${searchResult.nextable}">
            <g:link action="next" params="${searchResult.searchParams}">次</g:link>
          </g:if>
          <g:else>次</g:else>
          <div class="list">
            <table>
              <thead>
                <tr>
                  <th>日時</th>
                  <th>イベント名</th>
                  <th>開催場所</th>
                  <th>参加者</th>
                </tr>
              <thead>
              <tbody>
                <g:each in="${searchResult.events}" var="event">
                  <tr>
                    <td><g:formatDate date="${event.startedAt}" format="yyyy/MM/dd HH:mm" /> - <g:formatDate date="${event.endedAt}" format="HH:mm" /></td>
                    <td><g:link url="${event.url}" target="_blank">${event.name?.encodeAsHTML()}</g:link></td>
                    <td>${event.place?.encodeAsHTML()}(${event.address?.encodeAsHTML()})</td>
                    <td>${event.accepted}/${event.capacity}</td>
                  </tr>
                </g:each>
              </tbody>
            </table>
          </div>
      </g:if>
    </div>
  </body>
</html>
