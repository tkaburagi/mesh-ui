service {
  name = "ui"
  id = "ui-1"
  port = 8181

  connect {
    sidecar_service {}
  }

  check {
    id       = "counting-check"
    http     = "http://localhost:8181/japan"
    method   = "GET"
    interval = "10s"
    timeout  = "1s"
  }
}