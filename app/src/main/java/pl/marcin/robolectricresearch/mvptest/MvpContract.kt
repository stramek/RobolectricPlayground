package pl.marcin.robolectricresearch.mvptest

interface MvpContract {

    interface Presenter {
        fun presenterFun1()
        fun presenterFun2(someString: String)
    }

    interface View {
        fun viewFun1()
        fun viewFun2(someString: String)
    }
}
