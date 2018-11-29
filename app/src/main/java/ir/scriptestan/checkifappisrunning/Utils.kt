package ir.scriptestan.checkifappisrunning

import android.app.ActivityManager
import android.content.Context

/**
 * Created by Neo on 2018-11-29.
 * http://m3n.ir/
 */
class Utils {
    fun isActivityRunning(ctx: Context): Boolean {
        val activityManager = ctx.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        var tasks: List<ActivityManager.RunningAppProcessInfo>? = null
        tasks = activityManager.runningAppProcesses

        for (task in tasks!!) {

            if (task.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                for (activeProcess in task.pkgList) {
                    if (activeProcess == ctx.packageName) {
                        return true
                    }
                }
            }
        }
        return false
    }
}