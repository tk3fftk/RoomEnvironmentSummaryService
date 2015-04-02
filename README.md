# MavenToTomcatWithJersey

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
