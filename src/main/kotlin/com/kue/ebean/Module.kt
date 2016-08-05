package com.kue.ebean

import com.avaje.ebean.EbeanServer
import com.google.inject.AbstractModule

/**
 * @author Michael Vaughan
 */
class Module : AbstractModule() {

    override fun configure() {
        bind(EbeanServer::class.java).toProvider(EbeanServerProvider::class.java).asEagerSingleton()
    }

}