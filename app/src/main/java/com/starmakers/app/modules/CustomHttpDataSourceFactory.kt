package com.starmakers.app.modules

import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.HttpDataSource
import com.google.android.exoplayer2.upstream.TransferListener
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties


class CustomHttpDataSourceFactory(
    userAgent: String?,
    listener: TransferListener?,
    private val allowCrossProtocolRedirects: Boolean = false,
    private val requestProperties: RequestProperties? = null
) : DataSource.Factory {
    private val defaultDataSourceFactory: DataSource.Factory = DefaultHttpDataSource.Factory()
        .setUserAgent(userAgent)
        .setTransferListener(listener)
        .setAllowCrossProtocolRedirects(allowCrossProtocolRedirects)

    override fun createDataSource(): DataSource {
        val dataSource = defaultDataSourceFactory.createDataSource() as HttpDataSource
        requestProperties?.let { dataSource.setRequestProperty(it.getSnapshot().toString(),"") }
        return dataSource
    }
}


