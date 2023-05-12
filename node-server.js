const EventEmitter = require("events");

const emitter = new EventEmitter();

emitter.on("e1", (p1, p2) => {
  console.log("e1", p1, p2);
});

emitter.emit("e1", "param1", "param2");
