package pe.paku.callingapp.service

import android.telecom.Call
import android.telecom.InCallService
import pe.paku.callingapp.CallActivity

class CallService : InCallService() {

    override fun onCallAdded(call: Call) {
        OngoingCall.call = call
        CallActivity.start(this, call)
    }

    override fun onCallRemoved(call: Call) {
        OngoingCall.call = null
    }

}