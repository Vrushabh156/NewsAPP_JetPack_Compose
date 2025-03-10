package com.vrushabh.newsapp_jetpack_compose.domain.usecases.app_entry

import com.vrushabh.newsapp_jetpack_compose.domain.manger.LocalUserManger
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadAppEntry @Inject constructor(
    private val localUserManger: LocalUserManger
) {

    operator fun invoke(): Flow<Boolean> {
        return localUserManger.readAppEntry()
    }

}