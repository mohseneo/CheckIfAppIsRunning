package ir.scriptestan.checkifappisrunning

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log
import java.util.*
import kotlin.concurrent.schedule

class MyService : Service() {

    var context : Context? = null
    private val timer: Timer = Timer()

    override fun onCreate() {
        super.onCreate()
        context = this
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        timer.schedule(1000, 1000) {
            if(Utils().isActivityRunning(context!!)){
                log("app is running..")
            }else{
                log("app is not running..")
            }
        }

        return Service.START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    fun log(s : String){
        Log.wtf("MyService", s)
    }
}
