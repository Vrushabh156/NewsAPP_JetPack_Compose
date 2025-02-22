package com.vrushabh.newsapp_jetpack_compose.domain.usecases.app_entry

import com.vrushabh.newsapp_jetpack_compose.domain.manger.LocalUserManger
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManger: LocalUserManger
) {

    operator fun invoke(): Flow<Boolean> {
        return localUserManger.readAppEntry()
    }

}