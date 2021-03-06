package shaolizhi.hackerscareer.ui.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import shaolizhi.hackerscareer.R
import shaolizhi.hackerscareer.utils.showToast


/**
 * 由邵励治于2017/10/23创造.
 */

abstract class BaseFragment : Fragment() {

    private lateinit var mActivity: Context

    @LayoutRes
    protected abstract fun layoutId(): Int

    protected abstract fun created(bundle: Bundle?)

    protected abstract fun resumed()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        created(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        resumed()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mActivity = context
    }

    protected fun toast401() {
        showToast(getString(R.string.base_string1))
        Log.i(this.javaClass.simpleName, getString(R.string.base_string3))
    }

    protected fun toast402() {
        showToast(getString(R.string.base_string1))
        Log.i(this.javaClass.simpleName, getString(R.string.base_string4))
    }

    protected fun toast203() {
        showToast(getString(R.string.base_string1))
        Log.i(this.javaClass.simpleName, getString(R.string.base_string5))
    }

    protected fun toast403() {
        showToast(getString(R.string.base_string7))
        Log.i(this.javaClass.simpleName, getString(R.string.base_string6))
    }

    fun showToastForRequestResult(flag: String) {
        when (flag) {
            "203" -> toast203()
            "401" -> toast401()
            "402" -> toast402()
            "403" -> toast403()
            else -> {
            }
        }
    }
}
