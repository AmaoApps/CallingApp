package pe.paku.callingapp.service

import android.os.Build
import android.telecom.Connection
import android.telecom.DisconnectCause
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.M)
class CallConnection : Connection() {

    fun CallConnection() {
        audioModeIsVoip = true
    }

    override fun onAbort() {
        super.onAbort()
        dropCall()
    }

    override fun onReject() {
        super.onReject()
        dropCall()
    }

    override fun onDisconnect() {
        super.onDisconnect()
        dropCall()
    }

    private fun dropCall() {
        setDisconnected(DisconnectCause(DisconnectCause.LOCAL))
        destroy()
    }

}