package com.gmaslowski.actor

import java.util.concurrent.TimeUnit._

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import com.gmaslowski.actor.WebSocketHandler.{CalculationEnded, CalculationInProgress, CalculationStarted}

import scala.concurrent.duration.FiniteDuration

object WebSocketHandler {
  def props(out: ActorRef) = Props(classOf[WebSocketHandler], out)

  case object CalculationStarted
  case object CalculationInProgress
  case object CalculationEnded

}

class WebSocketHandler(val out: ActorRef) extends Actor with ActorLogging {

  override def receive: Receive = {
    case msg: String =>
      implicit val ex = context.dispatcher

      context.system.scheduler.scheduleOnce(FiniteDuration.apply(1, SECONDS), sender(), CalculationStarted.toString)
      context.system.scheduler.scheduleOnce(FiniteDuration.apply(3, SECONDS), out, CalculationInProgress.toString)
      context.system.scheduler.scheduleOnce(FiniteDuration.apply(6, SECONDS), out, CalculationInProgress.toString)
      context.system.scheduler.scheduleOnce(FiniteDuration.apply(9, SECONDS), out, CalculationInProgress.toString)
      context.system.scheduler.scheduleOnce(FiniteDuration.apply(20, SECONDS), out, CalculationInProgress.toString)
      context.system.scheduler.scheduleOnce(FiniteDuration.apply(30, SECONDS), out, CalculationEnded.toString)
  }
}
