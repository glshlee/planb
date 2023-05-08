package com.glshlee.planb.config

import org.slf4j.LoggerFactory

abstract class HLogger {
    val logger = LoggerFactory.getLogger(this.javaClass)
}
