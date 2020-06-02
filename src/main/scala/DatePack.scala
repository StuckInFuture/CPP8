package date_pack


object DatePack{
  class myDate() {
    private var year:Long = 0
    private var month:Long = 0
    private var day:Long = 0
    private var hours:Long = 0
    private var minutes:Long = 0
    private var seconds:Long = 0
    private var timer:Long = 0

    def setDate(newYear:Int, newMonth:Int, newDay:Int, newHours:Int, newMinutes:Int, newSeconds: Int)={
      year = newYear
      month = newMonth
      day = newDay
      hours = newHours
      minutes = newMinutes
      seconds = newSeconds
      timer = System.nanoTime() / 1000000000
    }

    def stopTime()={
      var elapsedTime: Long =  (System.nanoTime() / 1000000000) - timer
      year += (elapsedTime / 31104000)
      elapsedTime = (elapsedTime % 31104000)
      month += elapsedTime / 2592000
      elapsedTime = elapsedTime % 2592000
      day += elapsedTime / 86400
      elapsedTime = elapsedTime % 86400
      hours += elapsedTime / 3600
      elapsedTime = elapsedTime % 3600
      minutes += elapsedTime / 60
      elapsedTime = elapsedTime % 60
      seconds += elapsedTime
      if (seconds > 59){
        minutes += seconds / 60
        seconds %= 60
      }
      if (minutes > 59){
        hours += minutes / 60
        minutes %= 60
      }
      if (hours >23){
        day += hours / 24
        hours %= 24
      }
      if ( day > 30){
        month += day / 30
        day %= 30
      }
      if (month >12){
        year += month / 12
        month %= 12
      }
      //DD.MM.YYYY HH:MM:SS
    }

    def getTime():String={
      String.valueOf(hours) + ':' + String.valueOf(minutes) + ':' + String.valueOf(seconds) + ' ' +
        String.valueOf(day) + '.' + String.valueOf(month) + '.' + String.valueOf(year)
      //HH:MM:SS DD.MM.YYYY
    }


  }
}


