package com.kue.ebean

import com.avaje.ebean.EbeanServer
import com.avaje.ebean.EbeanServerFactory
import com.avaje.ebean.config.ServerConfig
import com.kue.core.NamedDataSourceCollection

import javax.inject.Inject
import javax.inject.Provider

/**
 * @author Michael Vaughan
 */
class EbeanServerProvider @Inject constructor(val dataSources: NamedDataSourceCollection) : Provider<EbeanServerCollection> {

    override fun get(): EbeanServerCollection {
        val ebeanServers = dataSources.dataSources.map { namedDataSource ->
            val serverConfig = ServerConfig().apply {
                this.dataSource = namedDataSource.dataSource
                this.name = namedDataSource.name
                this.packages
                if ("default".equals(namedDataSource.name)) {
                    this.isDefaultServer = true
                }
            }
            EbeanServerFactory.create(serverConfig)
        }
        return EbeanServerCollection(ebeanServers)
    }

}

data class EbeanServerCollection(val ebeanServers: List<EbeanServer>)