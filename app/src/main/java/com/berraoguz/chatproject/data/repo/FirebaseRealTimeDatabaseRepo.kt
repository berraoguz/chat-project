package com.berraoguz.chatproject.data.repo

import androidx.lifecycle.LiveData
import com.berraoguz.chatproject.data.model.LatestUserMessage
import com.berraoguz.chatproject.data.model.Message
import com.berraoguz.chatproject.data.model.User

interface FirebaseRealTimeDatabaseRepo {

    suspend fun sendMessage(message: String, senderRoom: String, receiverRoom: String, userReceiver: User, userSender: User)

    suspend fun getMessages(senderRoom: String)

    val messagesLiveData: LiveData<ArrayList<Message?>?>

    suspend fun getLatestUserAndMessages(senderId: String)

    val latestUserAndMessageLiveData: LiveData<ArrayList<LatestUserMessage?>?>

    suspend fun searchOnLatestUserAndMessages(senderId: String, name: String)

    val searchOnUsersLiveData: LiveData<ArrayList<LatestUserMessage?>?>

}