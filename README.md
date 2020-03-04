# springbootassignment

Assignment Implementation Steps
1)	There are two micro services app’s created using spring boot a)orderrestcontroller b)orderjmsprocessor
2)	Use Mongo Db for storing the records (Mongo DB compass installed in laptop)
3)	Use Active Mq as queue server(for sending the messages to the queue)
4)	Orderrestcontroller exposes a POST service with the URL -http://localhost:8090/transaction/send

5)Once the request is sent to the api URL, orderrestcontroller stores the request to JMS queue named “OrderTransactionQueue”, this queue gets registered in the Active MQ server running locally

6)Orderjmsprocessor app gets the orders from the queue “OrderTransactionQueue” and stores the data to the MongoDb test database.
 
Steps to Run the application
1)	Install maven , Java, Active Mq and Mongo DB in your computer(Else please change the active mq and mongo db configuration in the application.properties to point to where queue and mongo db is running)
2)	Setup environment variable for Maven and Java, also setup path variable which point to maven/bin and Java/bin directory
3)	Go to the source code folder of the app and, run mvn install
4)	Once the maven build successful, run java -jar <name of the jar file> 



