class MyViewModel(private val myRepository : MyRepository) : ViewModel() {
    private val _myData = MutableLiveData<List<MyData>>()
    val myData : LiveData<List<MyData>> = _myData

    fun fetchData() {
        viewModelScope.launch {
            val data = myRepository.getData()
            _myData.postValue(data)
        }
    }
}

class MyActivity : AppCompatActivity() {
    private val viewModel : MyViewModel by viewModels()

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        
        // ...
        
        // LiveData를 관찰하여 데이터가 업데이트될 때마다 UI를 갱신
        viewModel.myData.observe(this, Observer {data ->
            // UI를 갱신하는 코드
        })

        // 데이터를 가져오는 함수를 호출
        viewModel.fetchData()
    }
}