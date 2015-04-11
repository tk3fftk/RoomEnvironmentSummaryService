# MavenToTomcatWithJersey
Mavenを使って既存のリモート(ローカルも化)のtomcatにJerseyで作成したWebサービスをデプロイする

## 環境 
- tomcat7
- Maven 3.3.1
- Java 1.8系

## tomcat側

### tomcat-users.xml

    <tomcat-users>
      <user username="user" password="pass" roles="manager-gui,manager-script" />
    </tomcat-users>


## maven側
### setting.xml修正

    <servers>
      <server>
        <id>tomcat-test</id>
        <username>tktk</username>
        <password>tktk</password>
      </server>
    </servers>

- idはpom.xmlに書いたものと合わせること

## 実行
- goals
 `package tomcat7:deploy`
- deployではすでに存在している場合上書きしてくれない模様なので
 `tomcat:redeploy`

### Eclipse上でのエラー
- Dmaven.multiModuleProjectDirectory system propery is not set
 - `-Dmaven.multiModuleProjectDirectory=$M2_HOME` を`Window-> Preference -> Java -> Installed JREs -> Edit`の`Default VM arguments `に入力
 - 参考: http://stackoverflow.com/questions/29330577/maven-3-3-1-eclipse-dmaven-multimoduleprojectdirectory-system-propery-is-not-s
- 他にもJavaがない，みたいなことを言われるときは，`JREシステムライブラリー右クリック → プロパティ → 環境 → 互換性のあるJREにチェック`

