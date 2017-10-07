# intellforce
test task
This is spring boot application
You can run application in IntellforceApplication class
web client work on http://localhost:8080/

In project use:
Spring boot 
Spring security
AngularJS
Bootstrap

Server side work as RestFull service
with endpoint :

http://localhost:8080/ -GET return page index

http://localhost:8080/register/addUser -POST consume json and add user in users list in format{
	"last_name":"admin",
	"password":"123",
	"email":"mail@mail.com",
	"phone":"+55345",
	"username":"name"
}

endpoint secured by base authentication
http://localhost:8080/api/question/{id} -GET return question 1-5
http://localhost:8080/api/answer -POST consume json of answer in format {"questionId":1,"answerId":1}
http://localhost:8080/api/getUserInfo/{username} -GET return information about answers


