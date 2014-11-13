import org.scalatest.WordSpec
import org.scalatest.Matchers

class TypeParameterInference extends WordSpec with Matchers {
  
  trait Source[+T]
  object Source {
    def apply[T] = new Source[T] {}
  }
  
  trait Sink[-T]
  object Sink {
    def apply[T] = new Sink[T] {}
  }
  
  trait Vertex[-A, +B]
  object Vertex {
    def apply[A] = new Vertex[A, A] {}
  }
  
  def connect[A, B](from: Sink[A], to: Source[B])(via: Vertex[A, B]) = ???
  
  "should infer types correctly" in {
    "connect(Sink[String], Source[Double])(Vertex[Any])" shouldNot compile
    "connect(Sink[Int], Source[Int])(Vertex[Double])" shouldNot compile
  }
  
}