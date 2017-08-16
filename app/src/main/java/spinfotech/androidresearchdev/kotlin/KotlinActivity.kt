package spinfotech.androidresearchdev.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import spinfotech.androidresearchdev.R
import kotlinx.android.synthetic.main.activity_kotlin.*

/**
 * Created by sibaprasad on 15/08/17.
 */
public class KotlinActivity : AppCompatActivity(){

    var str:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)


        for (i in 1..10 step 2){
            str = str+"${i}"
        }

        tvDummy.text = str

    }

}