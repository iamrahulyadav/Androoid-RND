package spinfotech.androidresearchdev.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import spinfotech.androidresearchdev.R
import kotlinx.android.synthetic.main.activity_calculator.*

/**
 * Created by sibaprasad on 17/08/17.
 */
public class CalculatorActivity : AppCompatActivity(),View.OnClickListener{

    var str:String = ""
    var result:String =""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)


        tv0.setOnClickListener(this)
        tv1.setOnClickListener(this)
        tv2.setOnClickListener(this)
        tv3.setOnClickListener(this)
        tv4.setOnClickListener(this)
        tv5.setOnClickListener(this)
        tv6.setOnClickListener(this)
        tv7.setOnClickListener(this)
        tv8.setOnClickListener(this)
        tv9.setOnClickListener(this)
        tv0.setOnClickListener(this)
        tvAdd.setOnClickListener(this)
        tvDel.setOnClickListener(this)
        tvDiv.setOnClickListener(this)
        tvSub.setOnClickListener(this)
        tvEqual.setOnClickListener(this)

    }
    override fun onClick(view: View) {
        when (view.getId()) {
            R.id.tv0 -> {
                edittextAmount.setText(edittextAmount.text.toString()+"0")
            }
            R.id.tv1 -> {
                edittextAmount.setText(edittextAmount.text.toString()+"1")
            }
            R.id.tv2 -> {
                edittextAmount.setText(edittextAmount.text.toString()+"2")
            }
            R.id.tv3 -> {
                edittextAmount.setText(edittextAmount.text.toString()+"3")
            }
            R.id.tv4 -> {
                edittextAmount.setText(edittextAmount.text.toString()+"4")
            }
            R.id.tv5 -> {
                edittextAmount.setText(edittextAmount.text.toString()+"5")
            }
            R.id.tv6 -> {
                edittextAmount.setText(edittextAmount.text.toString()+"6")
            }
            R.id.tv7 -> {
                edittextAmount.setText(edittextAmount.text.toString()+"7")
            }
            R.id.tv8 -> {
                edittextAmount.setText(edittextAmount.text.toString()+"8")
            }
            R.id.tv9 -> {
                edittextAmount.setText(edittextAmount.text.toString()+"9")
            }
            R.id.tvDel -> {
                str = edittextAmount.text.toString().trim()
                if(str.length > 0) {
                    str = str.substring(0,str.length-1)
                }
                edittextAmount.setText(str)
            }
            R.id.tvAdd -> {
                add()
            }
            R.id.tvSub -> {
                sub()
            }
            R.id.tvEqual -> {

            }
            R.id.tvMul -> {
                mul()
            }
            R.id.tvDiv ->{
                div()
            }
        }
    }

    fun add(){
        str = edittextAmount.text.toString().trim()

        if(!str[str.length-1].equals("+")){
        edittextAmount.setText(str+"+")
        }
    }
    fun sub(){
        str = edittextAmount.text.toString().trim()
        if(!str[str.length-1].equals("-")) {
            edittextAmount.setText(str + "-")
        }
    }

    fun mul( ){
        str = edittextAmount.text.toString().trim()
        if(!str[str.length-1].equals("x")) {
            edittextAmount.setText(str + "x")
        }
    }

    fun div(){
        str = edittextAmount.text.toString().trim()
        if(!str[str.length-1].equals("/")) {
            edittextAmount.setText(str + "/")
        }
    }

    fun del(){
        edittextAmount.setText("")
    }

    fun equal(a:Int,b:Int){
        val reg = Regex("(?<=[!?])|(?=[!?])")
        var list = str.split(reg)
        val separate2 = str.split(" = "," - ")
    }
}