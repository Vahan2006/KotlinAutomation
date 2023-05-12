package UserData

class Credentials {
    private val standardUserName = "standard_user"
    private val userLastName = "testLastName"
    private val postalCode = "0000"
    private val password = "secret_sauce"
    private val fakePassword = "Test123*"

    fun getStandardUserName(): String {
        return this.standardUserName
    }
    fun getPassword(): String {
        return this.password
    }
    fun getFakePassword(): String {
        return this.fakePassword
    }
    fun getUserLastName(): String {
        return this.userLastName
    }
    fun getPostalCode(): String {
        return this.postalCode
    }

}