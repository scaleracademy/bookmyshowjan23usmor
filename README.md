// package by feature by package by layer
// users
//     UserController.java
//     UserRepository.java
//     UserService.java
// ticket
//     TicketController.java
//     TicketRepository.java

// For models, dtos, have @Getter @Setter

// ORM -> Object Relational Mapping
// reduce the need for you to write queries yourself

```sql
namanbhalla@Namans-Scaler-MacbookM1Pro-16 ~ % psql;
psql (14.1)
Type "help" for help.

namanbhalla=# create database jan23bms;
CREATE DATABASE
namanbhalla=# create user jan23bms;
CREATE ROLE
namanbhalla=# grant all privileg on data jan23bms to jan23bms;
ERROR:  syntax error at or near "privileg"
LINE 1: grant all privileg on data jan23bms to jan23bms;
                  ^
namanbhalla=# grant all privilges on data jan23bms to jan23bms;
ERROR:  syntax error at or near "privilges"
LINE 1: grant all privilges on data jan23bms to jan23bms;
                  ^
namanbhalla=# grant all privilges on database jan23bms to jan23bms;
ERROR:  syntax error at or near "privilges"
LINE 1: grant all privilges on database jan23bms to jan23bms;
                  ^
namanbhalla=# grant all privileges on database jan23bms to jan23bms;
GRANT
namanbhalla=#
```

// Database Migrations -> Flyway 

// 1. Rep everything as Entity
// 2. Mapped Superclass
// 3. Represent cardinality of associations -> BREAK till 9:03 AM