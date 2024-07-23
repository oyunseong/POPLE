package com.verywords.app.core.data.mapper

import com.verywords.app.core.data.model.TestResponse
import com.verywords.app.core.model.Test

internal fun TestResponse.toData(): Test = Test(
    id = id,
    status = status,
    title = title,
    writer = writer,
    reporter = reporter,
    registrationDate = registrationDate,
    completeDate = completeDate,
    preferredStation = preferredStation
)