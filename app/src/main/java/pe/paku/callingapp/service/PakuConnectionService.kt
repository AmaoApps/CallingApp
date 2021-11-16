package pe.paku.callingapp.service

import android.R.attr
import android.content.Context
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi

import android.telecom.TelecomManager.PRESENTATION_ALLOWED
import android.R.attr.phoneNumber

import android.os.Bundle
import android.telecom.*


@RequiresApi(Build.VERSION_CODES.M)
class PakuConnectionService : ConnectionService() {

    override fun onCreateIncomingConnection(
        connectionManagerPhoneAccount: PhoneAccountHandle?,
        request: ConnectionRequest?
    ): Connection {
        return super.onCreateIncomingConnection(connectionManagerPhoneAccount, request)
    }

    override fun onCreateOutgoingConnection(
        connectionManagerPhoneAccount: PhoneAccountHandle?,
        request: ConnectionRequest?
    ): Connection {
        return super.onCreateOutgoingConnection(connectionManagerPhoneAccount, request)
    }

    private fun createCall(phoneNumber : Uri) : CallConnection {
        val conn = CallConnection()

        val extras = Bundle()

        conn.setAddress(phoneNumber, PRESENTATION_ALLOWED)
        conn.videoState = VideoProfile.STATE_AUDIO_ONLY
        conn.setExtras(extras)
        conn.connectionCapabilities = Connection.CAPABILITY_SUPPORT_DEFLECT
        conn.isRingbackRequested = true

        conn.setActive()

        return conn
    }



}