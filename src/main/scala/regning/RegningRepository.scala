//package regning
//
//import java.sql.Timestamp
//import java.time.{Instant, LocalDateTime, ZoneId}
//
//import com.zaxxer.hikari.HikariDataSource
//import doobie.hikari.hikaritransactor.HikariTransactor
//import doobie.imports._
//import Regning.kjoregodtgjorelseComposite
//import Regning.andreUtgifterComposite
//import doobie.hikari.HikariTransactor
///**
//  *
//  */
//class RegningRepository(hikariDataSource: HikariDataSource) {
//
//  val tx = HikariTransactor[Task](hikariDataSource)
//
//  def readRegning(id:Long, brukernavn:String) : Regning = {
////    sql"select 1".query[Int]
//    val result = regningQuery(brukernavn, id)
//      .transact(tx)
//      .unsafePerformSync
//    Regning(result._1, result._2, result._3, result._4, result._5, result._6, result._7, result._8, result._9, result._10, result._11)
//  }
//
//  def saveRegning(regning: Regning): Long = {
//    import regning._
//    import Regning._
//    //andreUtl1, andreUtl1Beskrivelse, andreUtl2, andreUtl2Beskrivelse,
//    //andreUtl3, andreUtl3Beskrivelse
//    /*$brukernavn, $referanse, $hjemmelag, $bortelag, $kamptidspunkt, $honorar,
//          ${kjoregodtgjorelse.map(_.kilometer)}, ${kjoregodtgjorelse.map(_.sats)},
//          ${passasjergodtgjorelse.map(_.kilometer)}, ${passasjergodtgjorelse.map(_.sats)},
//          $passasjerNavn, $utlegg)*/
//    val transact: Task[Int] = {
//      val sql =
//        """INSERT INTO regning(id, brukernavn, referanse, hjemmelag, bortelag, kamptidspunkt, honorar, kgKm,
//            kgSats, passKm, passSats, passNavn, andreUtl1, andreUtl1Beskrivelse, andreUtl2, andreUtl2Beskrivelse,
//            andreUtl3, andreUtl3Beskrivelse)
//          VALUES (?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"""
//
//      val update = Update[Regning](sql).withUniqueGeneratedKeys[Int]("id")(regning)
//      update.transact(tx)
////      update.
////      sql.update
//        //        .run
////        .run(update)
//    }
//
//    transact.unsafePerformSync
//  }
//
//
//  def regningQuery(brukernavn:String, id:Long) = {
//    val andId: Fragment = idFragment(id)
//    val regningByBrukernavn: Fragment = regningByUserFragment(brukernavn)
//    val regningByBrukernavnOgId: Fragment = regningByBrukernavn ++ andId
//      regningByBrukernavnOgId.query[(Long, String, String, String, String, Timestamp, Double, Option[Kjoregodtgjorelse], Option[Kjoregodtgjorelse], Option[String], List[Utlegg])]
//      .unique
//  }
//
//  private def idFragment(id: Long) : Fragment = {
//    fr"AND id=$id"
//  }
//
//  def regningByUserFragment(brukernavn: String): Fragment = {
//    fr"select id, referanse, brukernavn, hjemmelag, bortelag, kamptidspunkt, honorar, kgKm, kgSats, passKm, passSats, passNavn, andreUtl1, andreUtl1Beskrivelse, andreUtl2, andreUtl2Beskrivelse, andreUtl3, andreUtl3Beskrivelse from regning where brukernavn=$brukernavn"
//  }
//
//  implicit val LocalDateTimeMeta: Meta[LocalDateTime] = Meta[java.sql.Timestamp].nxmap(
//    ts => ts.toLocalDateTime,
//    ldt =>Timestamp.valueOf(ldt)
//  )
//
//  /**
//    *   id IDENTITY PRIMARY KEY
//  referanse VARCHAR(255) NOT NULL,
//  hjemmelag VARCHAR(255) NOT NULL,
//  bortelag VARCHAR(255) NOT NULL,
//  kamptidspunkt TIMESTAMP NOT NULL,
//  honorar DECIMAL NOT NULL,
//  kgKm DECIMAL,
//  kgSats DECIMAL,
//  passKm DECIMAL,
//  passSats DECIMAL
//    */
//}