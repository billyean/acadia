package com.haiboyan.scala.algorithm

import scala.concurrent.{Await, Future, Promise}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import language.postfixOps

object TestFuture extends App {
  val p = Promise[Int]()
  val f = p.future

  def test1()= {
    val f1 = Future.successful{
      try {
        Thread.sleep(5000)
      } catch {
        case e: InterruptedException => println("Interrupted")
      }
      val t = 10
      p success(t)
    }

  }

  def test2(): Future[Int] = {
    Future {
      val v = Await.result(f, 1 second)
      v + 1
    }
  }

  test1()
  test2()
}
