package tw.edu.pu.csim.tcyang.counter20210319

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),View.OnClickListener,View.OnLongClickListener,View.OnTouchListener {

    var counter:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txv.text = counter.toString()
        txv.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0:View?){
            counter = (1..100).random()
            txv.text=counter.toString()
        }
        })
        txv.setOnLongClickListener(this)
        txvvb.setOnTouchListener(this)
        img.setOnLongClickListener(this)
    }


    fun Add(v:View){
        //if (v.id == R.id.btn){
        if (v ==  btn){
            counter++
        }
        else{
            counter += 2
        }
        txv.text = counter.toString()
    }

    override fun onClick(v: View?) {
        if (v == txv) {
            counter += 1
            txv.text = counter.toString()
        }
        else if(v== btn3){
            counter = 0
            txv.text = counter.toString()
        }

    }

    override fun onLongClick(v: View?): Boolean {
        if (v == txv) {
            counter += 3
            txv.text = counter.toString()
        }
        else if (v== img){
            counter -=1
            txv.text= counter.toString()
        }
        return true
    }

    override fun onTouch(v: View?, event: MotionEvent): Boolean {
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (event.action == MotionEvent.ACTION_DOWN){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                //Build.VERSION.SDK_INT >= 26, New vibrate method for API Level 26 or higher
                vibrator.vibrate(VibrationEffect.createOneShot(5000, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                vibrator.vibrate(5000)
            }
        }
        else{
            vibrator.cancel()
        }
        return true
    }



}