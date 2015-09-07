package com.gmaslowski.controller

import com.gmaslowski.actor.WebSocketHandler
import play.api.Play.current
import play.api.mvc.{Action, Controller, WebSocket}

// https://www.playframework.com/documentation/2.4.x/ScalaWebSockets
object MainController extends Controller {

  def websocket = WebSocket.acceptWithActor[String, String] { request => out =>
    WebSocketHandler.props(out)
  }

  def index = Action { request =>
    Ok(views.html.index())
  }


}
