import javax.smartcardio._

object PcSc extends App {

  println(s"Smarcardio library path: ${sys.props.get("sun.security.smartcardio.library")}")
  println(s"Default terminal factory ${TerminalFactory.getDefaultType}")

  // show the list of available terminals
  val factory = TerminalFactory.getInstance("PC/SC", null)
  val terminals = factory.terminals.list
  println("Terminals: " + terminals)

  // get the first terminal
  val terminal = terminals.get(0)

  // establish a connection with the card
  val card = terminal.connect("T=1")
  println("card: " + card)

  val channel = card.getBasicChannel();
  //val r = channel.transmit(new CommandAPDU(c1))
  //System.out.println("response: " + toString(r.getBytes()));

  // disconnect
  card.disconnect(false);

}

object Pkcs11 extends App {

  import java.io.ByteArrayInputStream
  import java.nio.charset.StandardCharsets.UTF_8
  import java.security.{ KeyStore, Security }

  val config = """
    |name=SmartCard
    |library=/usr/lib/opensc-pkcs11.so
    """.stripMargin('|')

  val is = new ByteArrayInputStream(config.getBytes(UTF_8))
  val provider = new sun.security.pkcs11.SunPKCS11(is)

  //Security.addProvider(provider)
  val pin = System.console.readPassword("PIN: ")
  val cac = KeyStore.getInstance("PKCS11", provider)
  cac.load(null, pin)
}
