import org.scalatest.FunSuite
import date_pack.DatePack

class Test extends FunSuite {
  test("myDate.setDate"){
    var currentDate = new DatePack.myDate
    currentDate.setDate(2020, 12, 30, 23, 59, 56)
    Thread.sleep(10000);
    currentDate.stopTime()
    assert(currentDate.getTime() == "0:0:6 1.1.2021")
    currentDate.setDate(1999, 11, 29, 12, 59, 56)
    Thread.sleep(10000);
    currentDate.stopTime()
    assert(currentDate.getTime() == "13:0:6 29.11.1999")
  }
}