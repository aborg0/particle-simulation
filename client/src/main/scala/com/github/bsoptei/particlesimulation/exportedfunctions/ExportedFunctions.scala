package com.github.bsoptei.particlesimulation.exportedfunctions

import com.github.bsoptei.particlesimulation.components._
import com.github.bsoptei.particlesimulation.ui.{DomAction, DomActionUnit}
import com.github.bsoptei.particlesimulation.wiring.TopLevelModule

import scala.concurrent.ExecutionContext.Implicits.global
import scala.scalajs.js.annotation.JSExportTopLevel
import scala.util.{Failure, Success}

object ExportedFunctions extends TopLevelModule {

  def modTemperature(i : Int): DomAction = (e) => ui.manageControl(Temp)(i)

  def modGravity(i : Int):     DomAction = (e) => ui.manageControl(Grav)(i)

  def modInp(i : Int):         DomAction = (e) => ui.manageControl(Inps)(i)

  def modSteps(i : Int):       DomAction = (e) => ui.manageControl(Step)(i)

  def reqSimulationResults():  DomActionUnit = (e) => {
    ui.sendSimulationRequest().onComplete {
      case Success(xhr) => ui.update(xhr.responseText)
      case Failure(err) => println(err.toString)
    }
  }

}
