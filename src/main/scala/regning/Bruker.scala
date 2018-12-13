package regning

import java.net.URI

/**
  *
  */
case class Bruker(brukernavn:String, fornavn:String, etternavn:String, kontonummer:String, dommernummer:String, url:Option[URI]) {

}
