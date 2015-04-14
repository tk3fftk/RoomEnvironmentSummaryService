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

- Managerまわりが入っていなかった場合
    - yum install tomcat7-admin-webapps

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

### pom.xmlにこういう書き方もできるとか

    <!-- Tomcat plugin -->  
    <plugin>  
        <groupId>org.apache.tomcat.maven</groupId>  
        <artifactId>tomcat7-maven-plugin</artifactId>  
        <version>2.2</version>  
        <configuration>  
            <path>/${project.build.finalName}</path>  
            <update>true</update>  
            <url>http:// localhost:8080/manager/text</url>  
            <username>tomcat</username>  
            <password>tomcatuser</password>  
        </configuration>  
    </plugin>

## 実行
- goals
 `package tomcat7:deploy`
- deployではすでに存在している場合上書きしてくれない模様なので
 `tomcat7:redeploy`

### Eclipse上でのエラー
- Dmaven.multiModuleProjectDirectory system propery is not set
 - `-Dmaven.multiModuleProjectDirectory=$M2_HOME` を`Window-> Preference -> Java -> Installed JREs -> Edit`の`Default VM arguments `に入力
 - 参考: http://stackoverflow.com/questions/29330577/maven-3-3-1-eclipse-dmaven-multimoduleprojectdirectory-system-propery-is-not-s
- 他にもJavaがない，みたいなことを言われるときは，`JREシステムライブラリー右クリック → プロパティ → 環境 → 互換性のあるJREにチェック`

