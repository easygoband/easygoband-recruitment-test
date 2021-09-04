import controller.APIManager

/**
 * Main function of the application.
 *
 * @param args Array of execution arguments.
 */
fun main(args: Array<String>) {
    // Creates an instance of the class in charge of managing the API
    val apiManager = APIManager(args)

    // Runs the API manager
    apiManager.runAPIManager()
}

