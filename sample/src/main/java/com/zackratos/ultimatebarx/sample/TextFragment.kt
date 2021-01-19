package com.zackratos.ultimatebarx.sample

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import com.zackratos.ultimatebarx.sample.R
import kotlinx.android.synthetic.main.fragment_text.*

/**
 * @Author   : zhangwenchao
 * @Date     : 2020/7/1  4:50 PM
 * @email    : 869649338@qq.com
 * @Describe :
 */
open class TextFragment : Fragment(R.layout.fragment_text) {

    companion object {

        private const val COLOR = "color"
        private const val TITLE = "title"
        private const val TITLE_COLOR = "title_color"
        private const val HIDE_TOOLBAR = "hide_toolbar"
        private const val CONTENT = "content"

        fun newInstance(content: String) = newInstance(Color.TRANSPARENT, "", Color.TRANSPARENT)
            .apply {
                arguments?.putBoolean(HIDE_TOOLBAR, true)
                arguments?.putString(CONTENT, content)
            }

        fun newInstance(@ColorInt color: Int, title: String, @ColorInt titleColor: Int) = TextFragment()
            .apply { initArguments(color, title, titleColor) }
    }

    private val title: String by lazy { arguments?.getString(TITLE) ?: "" }
    private val color: Int by lazy { arguments?.getInt(COLOR) ?: Color.TRANSPARENT }
    private val titleColor: Int by lazy { arguments?.getInt(TITLE_COLOR) ?: Color.TRANSPARENT }
    private val hideToolbar: Boolean by lazy { arguments?.getBoolean(HIDE_TOOLBAR) ?: false }
    private val content: String? by lazy { arguments?.getString(CONTENT) ?: getString(R.string.jiuyin) }

    protected fun initArguments(@ColorInt color: Int, title: String, @ColorInt titleColor: Int) {
        arguments = Bundle().apply {
            putString(TITLE, title)
            putInt(COLOR, color)
            putInt(TITLE_COLOR, titleColor)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    protected fun initView() {
        toolbar.setBackgroundColor(color)
        toolbar.title = title
        toolbar.setTitleTextColor(titleColor)
        if (hideToolbar) toolbar.visibility = View.GONE
        tvContent.text = content
    }

}