package com.vrushabh.newsapp_jetpack_compose.domain.usecases.app_entry

import com.vrushabh.newsapp_jetpack_compose.domain.manger.LocalUserManger

class SaveAppEntry(
    private val localUserManger: LocalUserManger
) {

    suspend operator fun invoke() {
        localUserManger.saveAppEntry()
    }

}