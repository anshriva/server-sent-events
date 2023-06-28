const eventSource = new EventSource("http://localhost:8080/simple/users");

eventSource.onopen = function() {
  console.log("SSE connection opened");
};

eventSource.onerror = function(error) {
  console.error("SSE error:", error);
};

eventSource.onmessage = console.log;

eventSource.onclose = function() {
  console.log("SSE connection closed");
};