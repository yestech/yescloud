dataSource {
	pooled = true
//	driverClassName = "org.hsqldb.jdbcDriver"
//  username = "sa"
//  password = ""
	driverClassName = "org.postgresql.Driver"
	username = "yescloud"
	password = "yescloud"
  dialect= "org.hibernate.dialect.PostgreSQLDialect"
}
hibernate {
    cache.use_second_level_cache=true
    cache.use_query_cache=true
    cache.provider_class='com.opensymphony.oscache.hibernate.OSCacheProvider'
    hibernate.dialect='org.hibernate.dialect.PostgreSQLDialect'
    hibernate.show_sql=true
    hibernate.format_sql=true

}
// environment specific settings
environments {
	development {
		dataSource {
			dbCreate = "create-drop" // one of 'create', 'create-drop','update'
//			url = "jdbc:hsqldb:mem:devDB"
			url = "jdbc:postgresql://localhost/yescloud"
		}
	}
	test {
		dataSource {
			dbCreate = "update"
//			url = "jdbc:hsqldb:mem:devDB"
          url = "jdbc:postgresql://localhost/yescloud"
		}
	}
	production {
		dataSource {
			dbCreate = "update"
//			url = "jdbc:hsqldb:mem:devDB"
          url = "jdbc:postgresql://localhost/yescloud"
		}
	}
}