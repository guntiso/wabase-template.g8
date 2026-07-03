package $package_name$

import org.wabase.client.WabaseHttpClient
import org.wabase.{AppQuerease, DefaultAppQuerease, WabaseServer}

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.language.reflectiveCalls

class RunningServer extends WabaseHttpClient {

  override protected def initQuerease: AppQuerease = DefaultAppQuerease

  override def login(username: String = null, password: String = null) = {
    ""
  }

  ServerState.synchronized {
    if (!ServerState.is_running) {
      WabaseServer.main(Array.empty)
      ServerState.is_running = true
    }
  }

  def unbind(): Unit = {
    implicit val ec: scala.concurrent.ExecutionContext = WabaseServer.app.executor
    Await.result(WabaseServer.unbindFuture, 30.seconds)
  }
}

private object ServerState {
  var is_running = false
}
