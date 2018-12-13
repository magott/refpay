package regning

import java.sql.Timestamp
import java.time.{LocalDateTime, ZonedDateTime}

import com.zaxxer.hikari.HikariDataSource
import db.{Hikari, LiquibaseRunner}
import org.scalatest.{FlatSpec, Matchers}

/**
  *
  */
class RegningRepositoryTest extends FlatSpec with Matchers{


  "Do it" should "foo" in {
    val ds = Hikari.ds
    new LiquibaseRunner(ds).runScript("db/scripts/main.xml")
    insertRegning(ds)
    val repository = new RegningRepository(ds)
    val readRegning = repository.readRegning(0, "foo@bar.com")
    readRegning.hjemmelag shouldBe "ØHIL"
    readRegning.utlegg.length shouldBe 1
  }

  "Repository " should "save" in {
    val ds = Hikari.ds
    new LiquibaseRunner(ds).runScript("db/scripts/main.xml")

    val regning = new Regning(None, "morten", "ref", "hjemmelag", "bortelag", LocalDateTime.now(), 1000, None, None, None, List.empty)

    val repository = new RegningRepository(ds)
    val key = repository.saveRegning(regning)
    println(key)
  }


  def insertRegning(ds: HikariDataSource) = {
    val connection = ds.getConnection()

    val stmt = connection.prepareStatement(
      """INSERT INTO regning(referanse, brukernavn, hjemmelag, bortelag, kamptidspunkt, honorar, kgKm, kgSats, passKm, passSats, andreUtl1, andreUtl1Beskrivelse)
 VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)""".stripMargin
    )
    stmt.setString(1, "entotre")
    stmt.setString(2, "foo@bar.com")
    stmt.setString(3, "ØHIL")
    stmt.setString(4, "Lyn")
    stmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()))
    stmt.setString(6, "800")
    stmt.setString(7, null)
    stmt.setString(8, null)
    stmt.setString(9, null)
    stmt.setString(10, null)
    stmt.setDouble(11, 200d)
    stmt.setString(12, "Bompenger")

    val updateCount = stmt.executeUpdate()
    connection.close()
    updateCount

  }

}
