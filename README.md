# basicKeycloakDemo - A demo App for Securing my SpringBoot REST APIs with Keycloak (inmemory H2 DB is used for storing demo data).

- First, download your suitable Keycloak server zip file from : https://www.keycloak.org/downloads
and Run your keycloak server at bin folder after unzipping it with CMD#> standalone.bat -Djboss.http.port=8180

OR

spin it with Docker => docker run -p 8180:8180 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin jboss/keycloak -Dkeycloak.profile.feature.docker=enabled -b 0.0.0.0

# Make sure keycloak server is running with given user settings before you run your code.
 
- Create a 'realm' inside Keycloak :- testing

- Create your own clientId with openid-connect protocol & root url as http://localhost:9091/*. In our example, "springboot-keycloak"
![](https://github.com/AadityaUoHyd/basicKeycloakDemo/blob/master/clientId.JPG)


- Add roles in your realm.
![](https://github.com/AadityaUoHyd/basicKeycloakDemo/blob/master/roles.JPG)

- Add users.
![](https://github.com/AadityaUoHyd/basicKeycloakDemo/blob/master/adduser.JPG)

- Create user with username and passwords credentials and map their corresponding roles. 

#create an user with only user role:- aadiuser/aadiuser123
![](https://github.com/AadityaUoHyd/basicKeycloakDemo/blob/master/aadiuser.JPG)

#create an user with both user & admin role:- manager/manager123
![](https://github.com/AadityaUoHyd/basicKeycloakDemo/blob/master/manager.JPG)

#create an user with only admin role:- myadmin/myadmin123
![](https://github.com/AadityaUoHyd/basicKeycloakDemo/blob/master/myadmin.JPG)

# Find your token-endpoints properties & pom.xml from : 
- http://localhost:8180/auth/realms/testing/.well-known/openid-configuration
- https://www.keycloak.org/docs/latest/securing_apps/#_spring_boot_adapter

# Results :
- You'll find, aadiuser can able to consume only individual urls & not all employees details at once. say specific employee details: http://localhost:9091/emp/1
- myadmin user can able to consume only that url, which has all employees : http://localhost:9091/emp/
- manager user can access both those urls, as manager has given both user & admin roles.

# Test them in Postman with such settings :
![](https://github.com/AadityaUoHyd/basicKeycloakDemo/blob/master/postman1.JPG)
![](https://github.com/AadityaUoHyd/basicKeycloakDemo/blob/master/postman2.JPG)


# Source to learn & explore : 
- https://www.baeldung.com/spring-boot-keycloak 
- https://www.keycloak.org/
