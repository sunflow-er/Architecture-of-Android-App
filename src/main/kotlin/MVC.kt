// Model
class UserModel(val name : String, val email : String)

// View
class UserView {
    fun displayUserInfo(name : String, email : String) {
        println("User Information: \nName : $name \nEmail : $email")
    }
}

// Controller
class UserController {
    private val userModel = UserModel("John Doe", "johndoe@gmail.com") // Model
    private val userView = UserView() // View

    fun displayUserInfo() {
        // View가 직접 Model을 참조
        val name = userModel.name
        val email = userModel.email
        userView.displayUserInfo(name, email)
    }
}