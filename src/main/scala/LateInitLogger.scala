import akka.actor.Actor
import akka.pattern.pipe
import com.github.mauricio.async.db.mysql.MySQLConnection
import com.github.mauricio.async.db.Connection

class Logger extends Actor {
  
  import context.dispatcher
  
  val connectionFuture = new MySQLConnection(???).connect
  
  val waitingForConnection: Receive = {
    case c: Connection => context.become(connectionEstablished(c))
  }
  
  val connectionEstablished: Connection => Receive = connection => { 
    case _ => println(connection)
  }
  
  override def preStart() = {
    // when future completes, send its contents to self
    connectionFuture pipeTo self
  }
  
  def receive = waitingForConnection
  
  override def postStop() = {
    // free resources
    connectionFuture.foreach(_.disconnect)
  }
}