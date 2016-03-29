package refpay

import unfiltered.filter.Plan
import unfiltered.request._
import unfiltered.response._

/**
  *
  */
class RefPayPlan extends Plan{

  override def intent = {
    case r@_ => {
      Ok ~> Html5(<p>Her kommer en ny tjeneste for dommere</p>)
    }
  }
}
