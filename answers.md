Have you applied the SOLID principles?
Yes

How long have you been thinking and writing the code tests? If you had had much more time ... what would you have added?
I would have added the support to have multiple filters which we can still have by extending the current logic

Why did you choose the language you used for this test?
I have pretty good experience with Java and Spring framework. It has all the support for the requirements which were supposed to be implemented. I could have used other languages but it would have taken a little more time.

How would you improve the API you used?
I would have probably gone with camel case as it provides better compatibility with most languages when the APIs are getting consumed.
If sessions doesn't have multiple values, it should be provided as a single object rathen than an array.
Also it's confusing to find how an entity can be uniquely identified in the json.
And the API takes around 5 seconds to provide the response so something could have been done to look into it.

What framework and language do you think has been used to expose this REST API? Tip: A lot of information travels in the HTTP protocol
Express JS 

Do you think this API supports CORS requests? How did you come to that conclusion?
Access-Control-Allow-Origin: * 

What infrastructure do you think the API is hosted on? Why do you think we have made that decision?
AWS - url and http response headers

How would you track a production performance problem? Have you ever had to do it?
I have not tracked a production performance problem before but I think I would check crash reports, error logging, application availability, checking specific requests and transactions, some real time monitoring tools, thread and heap dumps. 

Describe yourself using JSON.
{	
	"firstName": "Ankush",
	"lastName": "Singhal",
	"socialID" : "https://www.linkedin.com/in/ankush-singhal-9714463b/",
	"education" : "B.Tech",
	"work" : [
		"Programmer",
		"DevOps"
	],
	"hobbies" : [
		"LAN-Gaming",
		"binge watching"
	],
	"technicalSkills" : [
		"Java", 
		"Spring", 
		"Docker", 
		"Microservices", 
		"Jenkins", 
		"Angular", 
		"JQuery",
		"AWS"
	],
	"domainExpertise" : [
		"Aviation",
		"Banking",
		"Logistics"
	]
}