package superheroku.id.co.androidkotlin5seekbar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.SeekBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {


    private var progressView: TextView? = null
    private var seekbarStatusView: TextView? = null
    private var seekbarView: SeekBar? = null

    // SeekBar Range
    var MIN = 10
    var MAX = 160
    var STEP = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressView = this.progress
        seekbarStatusView = this.seekbarStatus

        seekbarView = this.seekbar
        // set max to seekbar
        seekbarView!!.max = (MAX - MIN) / STEP

        seekbarView!!.setOnSeekBarChangeListener(this)

    }

    override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                   fromUser: Boolean) {
        val progress_custom = MIN + ( progress * STEP )
        progressView!!.text = progress_custom.toString()
        seekbarStatusView!!.text = "Tracking Touch"
    }

    override fun onStartTrackingTouch(seekBar: SeekBar) {
        seekbarStatusView!!.text = "Started Tracking Touch"
    }

    override fun onStopTrackingTouch(seekBar: SeekBar) {
        seekbarStatusView!!.text = "Stopped Tracking Touch"
    }
}
