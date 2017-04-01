"use strict";

var app = b4w.require("app");
var data = b4w.require("data");

app.init({
  canvas_container_id: "model_canvas_container",
  phyics_enabled: false,
  autoresize: true,
  callback: load_cb
});

function load_cb() {
  data.load("car2.json", loaded_cb);
}

function loaded_cb() {
  alert("loaded_cb");
}
