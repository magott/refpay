//package regning
//
//import org.apache.poi.xssf.usermodel.{XSSFCell, XSSFSheet, XSSFWorkbook}
//
///**
//  *
//  */
//object NFFBreddeEksporter {
//
//  def generateNffBreddeInvoice(invoice: Regning, userOpt: Option[Bruker]) =
//    withTemplate("/Dommerregning-reise_bredde-2015.xlsx"){ template =>
////      applyCommonNffHeaders(template, invoice, userOpt)
////      applyToNffSpreadsheet(template, invoice, userOpt)(0)
//      template
//    }
//
//
//  def withTemplate(filename:String)(f: XSSFWorkbook => XSSFWorkbook) = {
//    val stream = getClass.getResourceAsStream(filename)
//    val template = new XSSFWorkbook(stream)
//    f(template)
//    template.getCreationHelper().createFormulaEvaluator().evaluateAll()
//    stream.close()
//    template
//  }
//
//
//  private def applyCommonNffHeaders(template: XSSFWorkbook, invoice: Regning, userOpt:Option[Bruker]) = {
//    import XlsxImplicits._
//    val sheet = template.getSheetAt(0)
////    userOpt.foreach { user =>
////      sheet(5)('B').setCellValue(user.fnrForInvoice)
////      sheet(5)('D').setCellValue(user.nameForInvoice)
////      sheet(5)('F').setCellValue(user.addressForInvoice)
////      sheet(5)('H').setCellValue(user.zipForInvoice + " " + user.cityForInvoice)
////      sheet(7)('B').setCellValue(user.muncipalForInvoice)
////      sheet(7)('H').setCellValue(user.accountForInvoice)
////      sheet(9)('D').setCellValue(user.email)
////      sheet(10)('D').setCellValue(invoice.matchData.matchId + " " + invoice.matchData.teams)
////      if (invoice.millageAllowance.isDefined) {
////        sheet(14)('B').setString(userOpt.map(_.addressForInvoice))
////        sheet(14)('D').setCellValue(invoice.matchData.venue)
////        sheet(15)('B').setCellValue(invoice.matchData.venue)
////        sheet(15)('D').setString(userOpt.map(_.addressForInvoice))
////      }
//      sheet(14)('F').setDouble(invoice.kjoregodtgjorelse.map(_.kilometer))
//      sheet(15)('F').setDouble(invoice.km.map(_ / 2))
//    }
//  }
//
//  object XlsxImplicits {
//
//    implicit class RichSheet(underlying: XSSFSheet) {
//
//      def apply(rowNum: Int)(cell: Char) = {
//        val cellInt = cell.toLower.toInt - 'a'
//        underlying.getRow(rowNum - 1).getCell(cellInt)
//      }
//
////      def apply(cell: Char)(rowNum: Int) = {
////        val cellInt = cell.toLower.toInt - 'a'
////        underlying.getRow(rowNum - 1).getCell(cellInt)
////      }
//    }
//
//    implicit class RichCell(underlying: XSSFCell) {
//
//      def setDouble(doubleOpt: Option[Double]) = {
//        doubleOpt.foreach(underlying.setCellValue(_))
//      }
//
//      def setInt(intOpt: Option[Int]) = {
//        intOpt.foreach(underlying.setCellValue(_))
//      }
//
//      def setString(stringOpt: Option[String]) = {
//        stringOpt.foreach(underlying.setCellValue(_))
//      }
//    }
//
//}
