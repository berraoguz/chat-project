package com.berraoguz.chatproject.data.model

data class LatestUserMessage(
    var message: Message = Message("", "", "", ""),
    var user: User = User("", "", "", null, null)
)