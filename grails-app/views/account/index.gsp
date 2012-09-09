<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja" lang="ja">
  <head>
    <meta name="layout" content="main"/>
    <title>アカウント</title>
  </head>
  <body>
    <div class="body">
        <h1>ログイン</h1>
    </div>
    <div class="dialog">
        <table>
          <tbody>
          <g:if test="${session.user}">
			<tr class="prop">
			    <td valign="top" class="name">
			        <label for="name">${session.user.name}でログインしています</label>
			    </td>
			</tr>
            <tr class="prop">
                <td valign="top" class="logout">
                    <g:link action="logout">ログアウト</g:link>
                </td>
            </tr> 
          </g:if>
          <g:else>
            <tr>
              <td valign="top" class="name">
                <g:link action="twitter">Twitterアカウントでログイン</g:link>
              </td>
            </tr>
          </g:else>
          </tbody>
        </table>
    </div>
  </body>
</html>
