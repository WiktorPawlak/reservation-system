# Reservation-System
Multiplex reservation system


## This project uses:

- JDK 17
- Maven 3.8.1
- Spring boot 2.6.6
- Persistence provider: Hibernate 5.6.7.Final
- Lombok 1.18.22
- H2 1.4.200
- Mockito 4.0.0


# Endpoints
Tomcat starts on port: 8080

GET:
- /screenings - lists available screenings
- /screenings/{from},{to} - lists screenings available within given time period
- /screenings/{id} - gives information about particular screening

POST:
- /reservations - books reservation with given informations and gives back reservation info


# Usage
You need bash shell e.g. Gitbash to run shell scripts.
To start application execute file "run.sh".
Next run exemplary usecase by executing file "demo.sh"
