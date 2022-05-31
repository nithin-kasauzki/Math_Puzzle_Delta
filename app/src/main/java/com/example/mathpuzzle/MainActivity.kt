package com.example.mathpuzzle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submit:Button= findViewById(R.id.submit)
        //message
       // val msg:TextView=findViewById(R.id.textView6)
        /** Operand Buttons */
        val a1:Button= findViewById(R.id.a1)
        val a2:Button= findViewById(R.id.a2)
        val b1:Button= findViewById(R.id.b1)
        val b2:Button= findViewById(R.id.b2)
        val c1:Button= findViewById(R.id.c1)
        val c2:Button= findViewById(R.id.c2)
        val d1:Button= findViewById(R.id.d1)
        val d2:Button= findViewById(R.id.d2)
        val e1:Button= findViewById(R.id.e1)
        val e2:Button= findViewById(R.id.e2)

        /** Operation */
        val o1:TextView=findViewById(R.id.o1)
        val o2:TextView=findViewById(R.id.o2)
        val o3:TextView=findViewById(R.id.o3)
        val o4:TextView=findViewById(R.id.o4)
        val o5:TextView=findViewById(R.id.o5)

        /** Result of Equation */
        val r1:TextView=findViewById(R.id.r1)
        val r2:TextView=findViewById(R.id.r2)
        val r3:TextView=findViewById(R.id.r3)
        val r4:TextView=findViewById(R.id.r4)
        val r5:TextView=findViewById(R.id.r5)

        /** Option Buttons */
        val z1:Button=findViewById(R.id.z1)
        val z2:Button=findViewById(R.id.z2)
        val z3:Button=findViewById(R.id.z3)
        val z4:Button=findViewById(R.id.z4)
        val z5:Button=findViewById(R.id.z5)
        val z6:Button=findViewById(R.id.z6)
        val z7:Button=findViewById(R.id.z7)
        val z8:Button=findViewById(R.id.z8)
        val z9:Button=findViewById(R.id.z9)
        val z10:Button=findViewById(R.id.z10)

        /**setting default text for operands*/
        val l1= arrayOf(a1,a2,b1,b2,c1,c2,d1,d2,e1,e2)
        for(i in l1){ i.text=" " }
        /** setting operations */
        val ops= arrayOf("+","-","X","/")
        val operation_list= arrayOf(o1,o2,o3,o4,o5)
        val choices= arrayListOf<Int>()
        for (i in 0..4){ operation_list[i].text= ops.random() }

        /** setting choice box */
        val result_list=arrayOf(r1,r2,r3,r4,r5)
        for (x in 0..4){
            var res:Int
            var n1=0
            var n2=1
            //addition
            if(operation_list[x].text=="+"){
                res= (2..99).random()
                result_list[x].text= res.toString()
                n1=(1 until res).random()
                n2=res-n1

                choices.add(n1)
                choices.add(n2)
            }
            //subtraction
            else if(operation_list[x].text=="-"){
                res= (2..99).random()
                result_list[x].text= res.toString()

                n1=(1 until res).random()
                n2=res+n1

                choices.add(n1)
                choices.add(n2)
            }

            //multiplication
            else if(operation_list[x].text=="X"){
                res= (2..99).random()
                result_list[x].text= res.toString()

                var factors= arrayListOf<Int>()
                for(i in 1..res){
                    if(res%i==0){ factors.add(i) }
                }

                n1=factors.random()
                n2=res/n1
                choices.add(n1)
                choices.add(n2)
            }

            //division
            else{
                res= (2..20).random()
                result_list[x].text= res.toString()

                n1=(1..res).random()
                n2=res*n1

                choices.add(n1)
                choices.add(n2)
            }
        }


        /**
        r1.text="10"
        z1.text="7"
        z2.text="3"
        o1.text="+" */
        //random choice allotting
        val z_choiceList=arrayOf(z1,z2,z3,z4,z5,z6,z7,z8,z9,z10)
        for(i in z_choiceList){
            val len= choices.size
            val j= (0 until len).random()
            i.text= choices[j].toString()
            choices.removeAt(j)
        }

        //clikings!!!
        fun click(n:Button){

            n.setOnClickListener {
                var temp:CharSequence=" "
                if(n.text==" "){ /** dont do anything */ }
                else {
                    a1.setOnClickListener { temp=a1.text; a1.text = n.text; n.text = temp}
                    a2.setOnClickListener { temp=a2.text; a2.text = n.text; n.text = temp }
                    b1.setOnClickListener { temp=b1.text; b1.text = n.text; n.text = temp}
                    b2.setOnClickListener { temp=b2.text; b2.text = n.text; n.text = temp}
                    c1.setOnClickListener { temp=c1.text; c1.text = n.text; n.text = temp}
                    c2.setOnClickListener { temp=c2.text; c2.text = n.text; n.text = temp}
                    d1.setOnClickListener { temp=d1.text; d1.text = n.text; n.text = temp}
                    d2.setOnClickListener { temp=d2.text; d2.text = n.text; n.text = temp}
                    e1.setOnClickListener { temp=e1.text; e1.text = n.text; n.text = temp}
                    e2.setOnClickListener { temp=e2.text; e2.text = n.text; n.text = temp}
                }
            }
        }

        click(z1)
        click(z2)
        click(z3)
        click(z4)
        click(z5)
        click(z6)
        click(z7)
        click(z8)
        click(z9)
        click(z10)

        fun check(a:Button,b:Button,o:TextView,r:TextView) :Int{
            val x: Int = (((a.text).toString()).toInt())
            val y: Int = (((b.text).toString()).toInt())
            var z: Int = 1
            when (o.text) {
                "+" -> z = x + y
                "-" -> z = x - y
                "X" -> z = x * y
                "/" -> z = x / y

            }
            if (z == ((r.text).toString()).toInt()) { return 1}
            else { return 0}
        }
        submit.setOnClickListener {
            if(a1.text==" " || a2.text==" " || b1.text==" " || b2.text==" " || c1.text==" " ||
                c2.text==" " || d1.text==" " || d2.text==" " || e1.text==" " || e2.text==" ")
            { Toast.makeText(this, "Fill values", Toast.LENGTH_SHORT).show() }
            else {
                val eq1 = check(a1, a2, o1, r1)
                val eq2 = check(b1, b2, o2, r2)
                val eq3 = check(c1, c2, o3, r3)
                val eq4 = check(d1, d2, o4, r4)
                val eq5 = check(e1, e2, o5, r5)
                if (eq1 + eq2 + eq3 + eq4 + eq5 == 5) {
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
                }
            }
            }

        }

}


