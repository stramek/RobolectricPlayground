package pl.marcin.robolectricresearch

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.junit.runner.RunWith
import pl.marcin.robolectricresearch.mvptest.FragmentMvp
import pl.marcin.robolectricresearch.mvptest.MvpContract
import pl.marcin.robolectricresearch.mvptest.MvpPresenter

@RunWith(AndroidJUnit4::class)
class FragmentMvpTest {

    private val mockPresenter: MvpContract.Presenter = mock<MvpPresenter>()
    private val view: MvpContract.View = FragmentMvp().apply { presenter = mockPresenter }

    @Test
    fun shouldRunFun1() {
        view.viewFun1()

        verify(mockPresenter).presenterFun1()
    }

    @Test
    fun shouldPassString() {
        val stringToPass = "XD"

        view.viewFun2(stringToPass)

        verify(mockPresenter).presenterFun2(stringToPass)
    }
}
