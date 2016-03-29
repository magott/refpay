import java.io.File
import java.util
import java.util.Locale
import javax.servlet.DispatcherType

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.FilterHolder
import org.eclipse.jetty.util.resource.{Resource, ResourceCollection}
import org.eclipse.jetty.webapp.WebAppContext
import refpay.RefPayPlan
import unfiltered.filter.Plan

import scala.util.Properties
/**
  *
  */
object Web extends App{


  Locale.setDefault(new Locale("no_NO"))

  val port = Properties.envOrElse("PORT", "9998").toInt

  val resources = new ResourceCollection(
    Resource.newResource(new File("src/main/webapp"))
  )
  val server = new Server(port)
  val context = new WebAppContext()
//  context.setContextPath("/api")
  context.setBaseResource(resources)
  registerPlan(new RefPayPlan, "Dommerbetaling", context)

  server.setHandler(context)
  server.setSendDateHeader(true)
  server.setStopAtShutdown(true)
  server.start()


  def registerPlan(plan: Plan, name: String, context: WebAppContext) {
    val holder = new FilterHolder(plan)
    holder.setName(name)
    context.addFilter(holder, "/*",  util.EnumSet.of(DispatcherType.REQUEST,DispatcherType.ASYNC,DispatcherType.ERROR,DispatcherType.FORWARD,DispatcherType.INCLUDE))
  }
}
