package com.kue.ebean

import com.avaje.ebean.EbeanServer
import com.avaje.ebean.EbeanServerFactory
import com.avaje.ebean.config.ServerConfig
import com.avaje.ebean.config.ServerConfig.DbUuid.VARCHAR
import javax.inject.Inject
import javax.inject.Provider
import javax.sql.DataSource

/**
 * @author Michael Vaughan
 */
class EbeanServerProvider @Inject constructor(val providerDataSource: DataSource) : Provider<EbeanServer> {


    override fun get(): EbeanServer? {
        val serverConfig = ServerConfig().apply {
            dataSource = providerDataSource
            name = "default"
            isDefaultServer = true
            dbUuid = VARCHAR
        }
        return EbeanServerFactory.create(serverConfig)
    }

}