package com.berraoguz.chatproject.ui.presenter

interface FirebaseRealTimeChatPresenter {

    fun ifSaveMessageToDatabaseSuccess(ifSuccess: Boolean, state: String)

}