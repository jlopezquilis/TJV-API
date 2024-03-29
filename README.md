# TJV Project

## Checkpoint 1
### Description of the complex query:
Two options for the complex query:
1) Get the total number of enrolled credits for a student
2) Given a Teacher, get all the students that are being taught by her/him (a Teacher can teach in more than one course).

### Descrpition of the complex business logic operation
The client (a student) will be able to enroll in a course. When the student will press the button "enroll", the system will check if there exists the course and if there is free capacity. If all the statements are acomplished, the client will get a message confirming the enrollment, otherwise will get a message saying that the student can not enroll in that course and the reason.


## Final Submission

### How to run and build it.
My application is composed by two projects:
1) TJVapi --> Which contains the code for the REST API. Must be the first project to run using the main method in the TjVapiApplication class.
2) TJVclient --> Which contains the shell client developed using SpringShell. This project must be run after TJVapi using the main method in the TjVapiApplication class.

### How to use the client
When the TJVclient project runs using your prefered IDE, we can see a shell prompt of this way:

``` shell:> ```

Here we can write the command ``` help ``` and we will obtain a list of methods we can use for this client followed my an explanation of what they do.

If we are interested in some method but do not know how to use it or which arguments do we need for executing it, we can use the command ``` help ``` followed by the name of the method. For example:

```help read-current-course```

And we will get information about the method and how to use it.

I hope you find it usefull. Wish you a great day.