package com.kue.ebean

import com.google.inject.AbstractModule

/**
 * @author Michael Vaughan
 */
class Module : AbstractModule() {

    override fun configure() {
        bind(EbeanServerCollection::class.java)
                .toProvider(EbeanServerProvider::class.java)
                .asEagerSingleton()
    }

}
