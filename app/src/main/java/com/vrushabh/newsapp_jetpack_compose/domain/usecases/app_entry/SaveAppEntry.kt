package com.vrushabh.newsapp_jetpack_compose.domain.usecases.app_entry

import com.vrushabh.newsapp_jetpack_compose.domain.manger.LocalUserManger
import javax.inject.Inject

class SaveAppEntry @Inject constructor(
    private val localUserManger: LocalUserManger
) {

    suspend operator fun invoke() {
        localUserManger.saveAppEntry()
    }

}