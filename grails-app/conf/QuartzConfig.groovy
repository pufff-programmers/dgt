
quartz {
    autoStartup = true
    jdbcStore = true
    waitForJobsToCompleteOnShutdown = true
}

environments {
    development {
        quartz {
            autoStartup = false
            jdbcStore = true
        }
    }
    test {
        quartz {
            autoStartup = false
            jdbcStore = false
        }
    }
}
