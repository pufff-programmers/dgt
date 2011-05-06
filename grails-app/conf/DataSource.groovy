dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop','update'
            url = "jdbc:mysql://localhost:3306/dgt?jdbcCompliantTruncation=false&zeroDateTimeBehavior=convertToNull&useUnicode=yes&characterEncoding=UTF-8"
            username="root"
            password="root"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:hsqldb:mem:testDb"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://localhost:3306/dgt?jdbcCompliantTruncation=false&zeroDateTimeBehavior=convertToNull&useUnicode=yes&characterEncoding=UTF-8"
            username="dgt"
            password="dgt"
        }
    }
}
