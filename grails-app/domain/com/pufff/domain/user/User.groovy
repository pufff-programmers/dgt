package com.pufff.domain.user

class User {

    static hasMany = [alertas:Alerta]

	String username
	String password
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

    String token = System.currentTimeMillis()



	static constraints = {
		username email:true, blank: false, unique: true
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}
}
