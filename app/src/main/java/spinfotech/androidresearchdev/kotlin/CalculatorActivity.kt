package spinfotech.androidresearchdev.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import spinfotech.androidresearchdev.R
import kotlinx.android.synthetic.main.activity_calculator.*
import java.util.*

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
                var res = evaluate(edittextAmount.text.toString().trim());
                edittextAmount.setText(""+res)
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
        if(!str[str.length-1].equals("*")) {
            edittextAmount.setText(str + "*")
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


    fun evaluate(expression: String): Int {
        val tokens = expression.toCharArray()

        // Stack for numbers: 'values'
        val values = Stack<Int>()

        // Stack for Operators: 'ops'
        val ops = Stack<Char>()

        var i = 0
        while (i < tokens.size) {
            // Current token is a whitespace, skip it
            if (tokens[i] == ' ') {
                i++
                continue
            }

            // Current token is a number, push it to stack for numbers
            if (tokens[i] >= '0' && tokens[i] <= '9') {
                val sbuf = StringBuffer()
                // There may be more than one digits in number
                while (i < tokens.size && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++])
                values.push(Integer.parseInt(sbuf.toString()))
            } else if (tokens[i] == '(')
                ops.push(tokens[i])
            else if (tokens[i] == ')') {
                while (ops.peek() !== '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()))
                ops.pop()
            } else if (tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/') {
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()))

                // Push current token to 'ops'.
                ops.push(tokens[i])
            }// Current token is an operator.
            // Closing brace encountered, solve entire brace
            // Current token is an opening brace, push it to 'ops'
            i++
        }

        // Entire expression has been parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()))

        // Top of 'values' contains result, return it
        return values.pop()
    }

    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    fun hasPrecedence(op1: Char, op2: Char): Boolean {
        if (op2 == '(' || op2 == ')')
            return false
        return if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            false
        else
            true
    }

    // A utility method to apply an operator 'op' on operands 'a'
    // and 'b'. Return the result.
    fun applyOp(op: Char, b: Int, a: Int): Int {
        when (op) {
            '+' -> return a + b
            '-' -> return a - b
            '*' -> return a * b
            '/' -> {
                if (b == 0)
                    throw UnsupportedOperationException("Cannot divide by zero")
                return a / b
            }
        }
        return 0
    }

}