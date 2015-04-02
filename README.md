# MavenToTomcatWithJersey

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
