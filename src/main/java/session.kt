class Session(){
    private var id : Int = 0
    private var name: String = ""

    fun setID(id: Int){
        this.id = id
    }

    fun setName(name: String){
        this.name = name
    }

    fun getName() : String {
        return this.name
    }
}