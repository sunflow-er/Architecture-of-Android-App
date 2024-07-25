import java.lang.Exception

// Model
interface Model {
    fun fetchData() : List<String>
}

// View
interface View {
    fun showData(data : List<String>)
    fun showError(error : String)
}

// Presenter
class Presenter(private val model : Model, private val view : View) {
    fun fetchData() {
        try {
            val data = model.fetchData()
            view.showData(data)
        } catch (e : Exception) {
            view.showError(e.message ?: "Unknown error occured.")
        }
    }
}