### Server sent events
1. These are the based on http protocol so, they are firewall friendly.
2. They are easy to scale because they are just like http.
3. They are ideal for uni-directional communication.  

#### Websockets vs server sent events
1. Web socket is for bidirectional communication. 
2. Server sent event is for uni directional communication. 

#### Setup
1. Launch the main method
2. access the url http://localhost:8080/healthCheck 
3. in the same page, copy the content from browser.js and paste in the browser console. 
4. Observe the console logs and also the network tabs.

There are two controllers added in server sent events
1. http://localhost:8080/simple/users
<br> This is using simple HttpServletResponse. We need to take care of following: 
   1. response header: Content-Type = text/event-stream
   2. response data should be of following format: data: event data \n\n
<br> Here is the sample code:  [SimpleController.cs](src/main/java/com/anubhav/controller/SimpleController.java)

2. http://localhost:8080/flux/users
<br> This is a ready-made library in java which is used for server sent events.
<br> [FluxController.cs](src/main/java/com/anubhav/controller/FluxController.java)

