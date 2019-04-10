package pl.marcin.robolectricresearch.mvptest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.content_main.*
import pl.marcin.robolectricresearch.R

class FragmentMvp : Fragment(), MvpContract.View {

    lateinit var presenter: MvpContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = MvpPresenter(this)
        return inflater.inflate(R.layout.content_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillBt.setOnClickListener { presenter.presenterFun1() }
        clearBt.setOnClickListener { presenter.presenterFun2("lol") }
    }

    override fun viewFun1() {
        Log.i("TAG", "viewFun1")
        presenter.presenterFun1()
    }

    override fun viewFun2(someString: String) {
        Log.i("TAG", "viewFun2")
        presenter.presenterFun2(someString)
    }
}