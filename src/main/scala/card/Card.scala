import javax.smartcardio._

object Card extends App {

  // show the list of available terminals
  val factory = TerminalFactory.getDefault()
  val terminals = factory.terminals().list()
  println("Terminals: " + terminals)

  // get the first terminal
  //CardTerminal terminal = terminals.get(0);

  // establish a connection with the card
  //Card card = terminal.connect("T=0");
  //System.out.println("card: " + card);
  //CardChannel channel = card.getBasicChannel();
  //ResponseAPDU r = channel.transmit(new CommandAPDU(c1));
  //System.out.println("response: " + toString(r.getBytes()));

  // disconnect
  //card.disconnect(false);

}
