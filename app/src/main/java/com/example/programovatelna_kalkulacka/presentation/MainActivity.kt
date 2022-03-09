package com.example.programovatelna_kalkulacka.presentation

import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.programovatelna_kalkulacka.R
import com.example.programovatelna_kalkulacka.databinding.ActivityMainBinding
import com.example.programovatelna_kalkulacka.presentation.mainScreen_viewModel.MainViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
     
     private var btnFalsi : Boolean = false
     private val mainViewModel : MainViewModel by inject() //Promenna ktera odkazuje na tridu, ktera ma obsahuje vsechny funcke a ma za ucel ridit MainActivitu
     private lateinit var activityMainBinding : ActivityMainBinding //Promenna ktera odkazuje na komponenty(buttony,labely atd..) a umoznuje pristup k nim
     private var count = 0
     override fun onCreate(savedInstanceState : Bundle?) { //vytvari Activitu
          super.onCreate(savedInstanceState)
          
          
          activityMainBinding = DataBindingUtil.setContentView(
               this, R.layout.activity_main
          ) //tato promenna nastavuje co bude ridit MainActivita d
          
          mainViewModel.getMacroContains()
              .observe(this, {
                   activityMainBinding.txtMacroContains?.text = it
              })
          
          mainViewModel.getProcessResult()
              .observe(this, {
                   activityMainBinding.txtProcess.text = it
              }) //Pokazde kdyz se vysledek getResult(), ktery je v MainViewModel zmeni, tak se zmeni i tady.
          
          mainViewModel.getM6()
              .observe(this, {
                   activityMainBinding.txtMem1Value.text = it
              })
          
          mainViewModel.getM7()
              .observe(this, {
                   activityMainBinding.txtMem2Value.text = it
              })
          
          mainViewModel.getM8()
              .observe(this, {
                   activityMainBinding.txtMem3Value.text = it
              })
          
          mainViewModel.getM9()
              .observe(this, {
                   activityMainBinding.txtMem4Value.text = it
              })
          
          mainViewModel.getM10()
              .observe(this, {
                   activityMainBinding.txtMem5Value.text = it
              })
          
          mainViewModel.getM11()
              .observe(this, {
                   activityMainBinding.txtMem1Value.text = it
              })
          
          mainViewModel.getM12()
              .observe(this, {
                   activityMainBinding.txtMem2Value.text = it
              })
          
          mainViewModel.getM13()
              .observe(this, {
                   activityMainBinding.txtMem3Value.text = it
              })
          
          mainViewModel.getM14()
              .observe(this, {
                   activityMainBinding.txtMem4Value.text = it
              })
          
          mainViewModel.getM15()
              .observe(this, {
                   activityMainBinding.txtMem5Value.text = it
              })
          
          mainViewModel.getM1()
              .observe(this, {
                   activityMainBinding.txtMem1Value.text = it
              })
          
          mainViewModel.getM2()
              .observe(this, {
                   activityMainBinding.txtMem2Value.text = it
              })
          
          mainViewModel.getM3()
              .observe(this, {
                   activityMainBinding.txtMem3Value.text = it
              })
          
          mainViewModel.getM4()
              .observe(this, {
                   activityMainBinding.txtMem4Value.text = it
              })
          
          mainViewModel.getM5()
              .observe(this, {
                   activityMainBinding.txtMem5Value.text = it
              })
          
          
          mainViewModel.getResult()
              .observe(this, {
                   activityMainBinding.txtResult.text = it
              })
          
          mainViewModel.quadraticResult1()
              .observe(this, {
                   activityMainBinding.txtFirstNumber.text = it
              })
          
          mainViewModel.quadraticResult2()
              .observe(this, {
                   activityMainBinding.txtSecondNumber.text = it
              })
          
          mainViewModel.quadraticResult3()
              .observe(this, {
                   activityMainBinding.txtThirdNumber.text = it
              })
          
          mainViewModel.quadraticResult4()
              .observe(this, {
                   activityMainBinding.txtFourthNumber?.text = it
              })
          
          mainViewModel.firstOperation()
              .observe(this, {
                   activityMainBinding.txtFirstOperator.text = it
              })
          
          mainViewModel.secondOperation()
              .observe(this, {
                   activityMainBinding.txtSecondOperator.text = it
              })
          
          mainViewModel.thirdOperation()
              .observe(this, {
                   activityMainBinding.txtThirdOperator?.text = it
              })
          
          mainViewModel.getX1Root()
              .observe(this, {
                   activityMainBinding.txtFuncNumber?.text = it
              })
          mainViewModel.x1Result()
              .observe(this, {
                   activityMainBinding.x1!!.text = it
              })
          mainViewModel.x2Result()
              .observe(this, {
                   activityMainBinding.x2!!.text = it
              })
          
          mainViewModel.x3Result()
              .observe(this, {
                   activityMainBinding.txtX3!!.text = it
              })
          
          mainViewModel.getLowVal()
              .observe(this, {
                   activityMainBinding.txtANumber!!.text = it
              })
          
          mainViewModel.getHighVal()
              .observe(this, {
                   activityMainBinding.txtBNumber!!.text = it
              })
          
          mainViewModel.getPrecission()
              .observe(this, {
                   activityMainBinding.txtCNumber!!.text = it
              })
          
          
          
          
          
          activityMainBinding.x1RootLayout.visibility = View.INVISIBLE
          activityMainBinding.x2RootLayout?.visibility = View.INVISIBLE
          activityMainBinding.quadraticEqualation.visibility = View.INVISIBLE
          
          
          if (activityMainBinding.txtResult.text.isEmpty()) { //pokud se result label == " " tak nezustane prazdny ale, pokazde kdyz je prazndy, tak tam bude zapsana "0"
               activityMainBinding.txtResult.text = "0"
          }
          
          activityMainBinding.btnLastResult.setOnClickListener {
               
               activityMainBinding.btnLastResult.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnLastResult.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               mainViewModel.ansShow()
          }
          
          activityMainBinding.btnNumber00.setOnClickListener {
               
               activityMainBinding.btnNumber00.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnNumber00.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               mainViewModel.addNumber00()
               
          }
          
          activityMainBinding.btnStartRecord?.setOnClickListener {
               
               count += 1
               
               if (count == 1) {
                    mainViewModel.macroRecord()
                    activityMainBinding.btnStartRecord?.setText("Stop Record")
                    activityMainBinding.btnStartRecord?.setBackgroundColor(
                         Color.parseColor("#616596")
                    )
                    
                    val anim : Animation = AlphaAnimation(
                         0.0f, 1.0f
                    )
                    anim.duration = 500 //You can manage the blinking time with this parameter
                    
                    anim.startOffset = 50
                    anim.repeatMode = Animation.ABSOLUTE
                    anim.repeatCount = 5
                    activityMainBinding.btnNumber1.startAnimation(anim)
                    activityMainBinding.btnNumber2.startAnimation(anim)
                    activityMainBinding.btnNumber3.startAnimation(anim)
                    activityMainBinding.btnNumber4.startAnimation(anim)
                    activityMainBinding.btnNumber5.startAnimation(anim)
                    activityMainBinding.btnNumber6.startAnimation(anim)
                    activityMainBinding.btnNumber7.startAnimation(anim)
                    activityMainBinding.btnNumber8.startAnimation(anim)
                    activityMainBinding.btnNumber9.startAnimation(anim)
                    
               }
               else {
                    activityMainBinding.btnStartRecord?.setText("Start Record")
                    activityMainBinding.btnStartRecord?.setBackgroundColor(Color.TRANSPARENT)
                    mainViewModel.macroStopRecord()
                    count = 0
               }
               
          }
          
          activityMainBinding.btnInfo.setOnClickListener {
               
               val alertadd = AlertDialog.Builder(this)
               val factory = LayoutInflater.from(applicationContext)
               val view : View = factory.inflate(
                    R.layout.activity_dialog, null
               )
               alertadd.setView(view)
               alertadd.setNeutralButton("Ok!", DialogInterface.OnClickListener { dlg, sumthin -> })
               
               alertadd.show()
               
               /* if(activityMainBinding.btnMem1.visibility == View.INVISIBLE){
   
               activityMainBinding.btnMem1.visibility == View.VISIBLE
                }else {
               activityMainBinding.btnMem1.visibility == View.INVISIBLE
                }*/
               
          }
          
          activityMainBinding.btnFalsiMethod.setOnClickListener {
               
               if (activityMainBinding.x1RootLayout.visibility == View.INVISIBLE) {
                    btnFalsi = true
                    
                    activityMainBinding.x1RootLayout.visibility = View.VISIBLE
                    activityMainBinding.x2RootLayout?.visibility = View.VISIBLE
                    activityMainBinding.quadraticEqualation.visibility = View.VISIBLE
                    activityMainBinding.txtLastResult.visibility = View.INVISIBLE
                    activityMainBinding.txtResult.visibility = View.INVISIBLE
                    activityMainBinding.txtProcess.visibility = View.INVISIBLE
                    activityMainBinding.btnPower2.text = "x".lowercase()
                    activityMainBinding.btnPower3.text = "x²".lowercase()
                    activityMainBinding.btnPercent.text = "x³".lowercase()
               }
               else {
                    btnFalsi = false
                    activityMainBinding.x1RootLayout.visibility = View.INVISIBLE
                    activityMainBinding.x2RootLayout?.visibility = View.INVISIBLE
                    activityMainBinding.quadraticEqualation.visibility = View.INVISIBLE
                    
                    activityMainBinding.txtLastResult.visibility = View.VISIBLE
                    activityMainBinding.txtResult.visibility = View.VISIBLE
                    activityMainBinding.txtProcess.visibility = View.VISIBLE
                    activityMainBinding.btnPercent.text = "%"
                    activityMainBinding.btnSquareRoot.text = "√"
                    activityMainBinding.btnDevided.text = "÷"
                    
               }
               
               if (activityMainBinding.x1RootLayout.visibility == View.VISIBLE) {
                    activityMainBinding.btnFalsiMethod.setBackgroundColor(Color.parseColor("#616596"))
               }
               else {
                    activityMainBinding.btnFalsiMethod.setBackgroundColor(Color.TRANSPARENT)
               }
               
               mainViewModel.failsMethod()
          }
          
          activityMainBinding.btnNumber1.setOnClickListener { //Odkazuje na tlacitko btnNumber1 a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
               
               activityMainBinding.btnNumber1.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnNumber1.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               mainViewModel.addNumber1() //prida do labelu "1"
               
          }
          
          
          
          activityMainBinding.btnClearMacro!!.setOnClickListener {
               mainViewModel.macroClear()
               
               val anim : Animation = AlphaAnimation(
                    0.0f, 1.0f
               )
               anim.duration = 500 //You can manage the blinking time with this parameter
               
               anim.startOffset = 50
               anim.repeatMode = Animation.ABSOLUTE
               anim.repeatCount = 5
               
               activityMainBinding.btnNumber1.startAnimation(anim)
               activityMainBinding.btnNumber2.startAnimation(anim)
               activityMainBinding.btnNumber3.startAnimation(anim)
               activityMainBinding.btnNumber4.startAnimation(anim)
               activityMainBinding.btnNumber5.startAnimation(anim)
               activityMainBinding.btnNumber6.startAnimation(anim)
               activityMainBinding.btnNumber7.startAnimation(anim)
               activityMainBinding.btnNumber8.startAnimation(anim)
               activityMainBinding.btnNumber9.startAnimation(anim)
               
          }
          
          activityMainBinding.btnNumber2.setOnClickListener { //Odkazuje na tlacitko btnNumber2 a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
               
               activityMainBinding.btnNumber2.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnNumber2.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               mainViewModel.addNumber2() //prida do labelu "2"
          }
          
          activityMainBinding.btnNumber3.setOnClickListener { //Odkazuje na tlacitko btnNumber3 a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
               
               activityMainBinding.btnNumber3.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnNumber3.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               mainViewModel.addNumber3() //prida do labelu "3"
          }
          
          activityMainBinding.btnNumber4.setOnClickListener { //Odkazuje na tlacitko btnNumber4 a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
               
               activityMainBinding.btnNumber4.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnNumber4.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               mainViewModel.addNumber4() //prida do labelu "4"
          }
          
          activityMainBinding.btnNumber5.setOnClickListener { //Odkazuje na tlacitko btnNumber5 a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
               
               activityMainBinding.btnNumber5.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnNumber5.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               mainViewModel.addNumber5() //prida do labelu "5"
          }
          
          activityMainBinding.btnNumber6.setOnClickListener { //Odkazuje na tlacitko btnNumber6 a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
               
               activityMainBinding.btnNumber6.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnNumber6.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               mainViewModel.addNumber6() //prida do labelu "6"
          }
          
          activityMainBinding.btnNumber7.setOnClickListener { //Odkazuje na tlacitko btnNumber7 a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
               
               activityMainBinding.btnNumber7.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnNumber7.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               mainViewModel.addNumber7() //prida do labelu "7"
          }
          
          activityMainBinding.btnNumber8.setOnClickListener { //Odkazuje na tlacitko btnNumber8 a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
               
               activityMainBinding.btnNumber8.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnNumber8.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               mainViewModel.addNumber8() //prida do labelu "8"
          }
          
          activityMainBinding.btnNumber9.setOnClickListener { //Odkazuje na tlacitko btnNumber9 a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
               
               activityMainBinding.btnNumber9.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnNumber9.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               mainViewModel.addNumber9() //prida do labelu "9"
          }
          
          activityMainBinding.btnNumber0.setOnClickListener { //Odkazuje na tlacitko btnNumber0 a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
               
               activityMainBinding.btnNumber0.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnNumber0.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               mainViewModel.addNumber0() //prida do labelu "0"
          }
          
          activityMainBinding.btnDot.setOnClickListener { //Odkazuje na tlacitko btnDot a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
               
               activityMainBinding.btnDot.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnDot.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               mainViewModel.addDot() //prida do labelu "."
          }
          
          activityMainBinding.btnDeleteAll.setOnClickListener { //Odkazuje na tlacitko btnDot a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
               
               activityMainBinding.btnDeleteAll.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnDeleteAll.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               mainViewModel.deleteAll() //vymaze vse co zatim bylo v labelu result zapsano a nastavi hodnotu na "0" takze pokud tam bylo napsano treba cislo "22",tak po stisku tohot tlacitka bude hodnota "0"
          }
          
          activityMainBinding.btnArrowFor!!.setOnClickListener {
               
               if (activityMainBinding.btnMem1.text == "M1") {
                    
                    activityMainBinding.btnMem1.text = "M6"
                    activityMainBinding.btnMem2.text = "M7"
                    activityMainBinding.btnMem3.text = "M8"
                    activityMainBinding.btnMem4.text = "M9"
                    activityMainBinding.btnMem5.text = "M10"
                    
                    mainViewModel.getM6()
                        .observe(this, {
                             activityMainBinding.txtMem1Value.text = it
                        })
                    
                    mainViewModel.getM7()
                        .observe(this, {
                             activityMainBinding.txtMem2Value.text = it
                        })
                    
                    mainViewModel.getM8()
                        .observe(this, {
                             activityMainBinding.txtMem3Value.text = it
                        })
                    
                    mainViewModel.getM9()
                        .observe(this, {
                             activityMainBinding.txtMem4Value.text = it
                        })
                    
                    mainViewModel.getM10()
                        .observe(this, {
                             activityMainBinding.txtMem5Value.text = it
                        })
                    
               }
               else if (activityMainBinding.btnMem1.text == "M6") {
                    
                    activityMainBinding.btnMem1.text = "M11"
                    activityMainBinding.btnMem2.text = "M12"
                    activityMainBinding.btnMem3.text = "M13"
                    activityMainBinding.btnMem4.text = "M14"
                    activityMainBinding.btnMem5.text = "M15"
                    
                    
                    mainViewModel.getM11()
                        .observe(this, {
                             activityMainBinding.txtMem1Value.text = it
                        })
                    
                    mainViewModel.getM12()
                        .observe(this, {
                             activityMainBinding.txtMem2Value.text = it
                        })
                    
                    mainViewModel.getM13()
                        .observe(this, {
                             activityMainBinding.txtMem3Value.text = it
                        })
                    
                    mainViewModel.getM14()
                        .observe(this, {
                             activityMainBinding.txtMem4Value.text = it
                        })
                    
                    mainViewModel.getM15()
                        .observe(this, {
                             activityMainBinding.txtMem5Value.text = it
                        })
                    
               }
               else {
                    activityMainBinding.btnMem1.text = "M1"
                    activityMainBinding.btnMem2.text = "M2"
                    activityMainBinding.btnMem3.text = "M3"
                    activityMainBinding.btnMem4.text = "M4"
                    activityMainBinding.btnMem5.text = "M5"
                    
                    mainViewModel.getM1()
                        .observe(this, {
                             activityMainBinding.txtMem1Value.text = it
                        })
                    
                    mainViewModel.getM2()
                        .observe(this, {
                             activityMainBinding.txtMem2Value.text = it
                        })
                    
                    mainViewModel.getM3()
                        .observe(this, {
                             activityMainBinding.txtMem3Value.text = it
                        })
                    
                    mainViewModel.getM4()
                        .observe(this, {
                             activityMainBinding.txtMem4Value.text = it
                        })
                    
                    mainViewModel.getM5()
                        .observe(this, {
                             activityMainBinding.txtMem5Value.text = it
                        })
               }
               
          }
          
          activityMainBinding.btnArrowBack!!.setOnClickListener {
               
               if (activityMainBinding.btnMem1.text == "M1") {
                    
                    activityMainBinding.btnMem1.text = "M11"
                    activityMainBinding.btnMem2.text = "M12"
                    activityMainBinding.btnMem3.text = "M13"
                    activityMainBinding.btnMem4.text = "M14"
                    activityMainBinding.btnMem5.text = "M15"
                    
                    mainViewModel.getM11()
                        .observe(this, {
                             activityMainBinding.txtMem1Value.text = it
                        })
                    
                    mainViewModel.getM12()
                        .observe(this, {
                             activityMainBinding.txtMem2Value.text = it
                        })
                    
                    mainViewModel.getM13()
                        .observe(this, {
                             activityMainBinding.txtMem3Value.text = it
                        })
                    
                    mainViewModel.getM14()
                        .observe(this, {
                             activityMainBinding.txtMem4Value.text = it
                        })
                    
                    mainViewModel.getM15()
                        .observe(this, {
                             activityMainBinding.txtMem5Value.text = it
                        })
               }
               else if (activityMainBinding.btnMem1.text == "M11") {
                    activityMainBinding.btnMem1.text = "M6"
                    activityMainBinding.btnMem2.text = "M7"
                    activityMainBinding.btnMem3.text = "M8"
                    activityMainBinding.btnMem4.text = "M9"
                    activityMainBinding.btnMem5.text = "M10"
                    
                    mainViewModel.getM6()
                        .observe(this, {
                             activityMainBinding.txtMem1Value.text = it
                        })
                    
                    mainViewModel.getM7()
                        .observe(this, {
                             activityMainBinding.txtMem2Value.text = it
                        })
                    
                    mainViewModel.getM8()
                        .observe(this, {
                             activityMainBinding.txtMem3Value.text = it
                        })
                    
                    mainViewModel.getM9()
                        .observe(this, {
                             activityMainBinding.txtMem4Value.text = it
                        })
                    
                    mainViewModel.getM10()
                        .observe(this, {
                             activityMainBinding.txtMem5Value.text = it
                        })
                    
               }
               else {
                    activityMainBinding.btnMem1.text = "M1"
                    activityMainBinding.btnMem2.text = "M2"
                    activityMainBinding.btnMem3.text = "M3"
                    activityMainBinding.btnMem4.text = "M4"
                    activityMainBinding.btnMem5.text = "M5"
                    
                    mainViewModel.getM1()
                        .observe(this, {
                             activityMainBinding.txtMem1Value.text = it
                        })
                    
                    mainViewModel.getM2()
                        .observe(this, {
                             activityMainBinding.txtMem2Value.text = it
                        })
                    
                    mainViewModel.getM3()
                        .observe(this, {
                             activityMainBinding.txtMem3Value.text = it
                        })
                    
                    mainViewModel.getM4()
                        .observe(this, {
                             activityMainBinding.txtMem4Value.text = it
                        })
                    
                    mainViewModel.getM5()
                        .observe(this, {
                             activityMainBinding.txtMem5Value.text = it
                        })
               }
               
          }
          
          activityMainBinding.btnDeleteOneObject.setOnClickListener { //Odkazuje na tlacitko btnDeleteOneObject a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
               
               activityMainBinding.btnDeleteOneObject.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnDeleteOneObject.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               mainViewModel.deleteOneChar() //maze z labelu po jednoum cisle
          }
          
          activityMainBinding.btnChangeTheSymbol.setOnClickListener { //Odkazuje na tlacitko btnChangeTheSymbol a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
               
               activityMainBinding.btnChangeTheSymbol.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnChangeTheSymbol.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               mainViewModel.changeSymbol() //meni hodnotu z "+" na "-" a opačně
          }
          
          activityMainBinding.btnPlus.setOnClickListener { //Odkazuje na tlacitko btnPlus a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
               
               activityMainBinding.btnPlus.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnPlus.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               
               mainViewModel.plus() //tato funkce momentalne jeste neni dodelana ale mela by scitat cisla v labelu
          }
          
          activityMainBinding.btnMinus.setOnClickListener { //Odkazuje na
               
               activityMainBinding.btnMinus.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnMinus.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               mainViewModel.minus()
          }
          
          activityMainBinding.btnMultiply.setOnClickListener {
               
               activityMainBinding.btnMultiply.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnMultiply.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               mainViewModel.multiply()
          }
          
          activityMainBinding.btnDevided.setOnClickListener {
               
               activityMainBinding.btnDevided.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnDevided.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               mainViewModel.divide()
          }
          
          activityMainBinding.btnEqual.setOnClickListener {
               
               activityMainBinding.btnEqual.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnEqual.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               //Odkazuje na tlacitko btnEqual a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
               mainViewModel.equal() // provede funkci equal, ktera je ve MainViewModelu
               mainViewModel.equalSend() //provede funkci equalSend, ktera je ve MainViewModelu
               mainViewModel.getResult()
                   .observe(this, {
                        activityMainBinding.txtResult.text = it
                   }) // zmeni text v labelu kde je hlavni text
               mainViewModel.equalSend()
                   .observe(this, {
                        activityMainBinding.txtLastResult.text = it
                   }) // zmeni text v labelu kde se zobrazuje lastResult na text, ktery je v hlavnim labelu
               
               if (btnFalsi) {
                    mainViewModel.getMessage()
                        .observe(this, {
                             Toast.makeText(applicationContext, it, Toast.LENGTH_LONG)
                                 .show()
                        })
               }
          }
          
          activityMainBinding.btnPercent.setOnClickListener { //Odkazuje na tlacitko btnPercent a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
               
               activityMainBinding.btnPercent.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnPercent.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               mainViewModel.percent() //Konvertuje cislo na procento
          }
          
          activityMainBinding.btnPower2.setOnClickListener { //Odkazuje na tlacitko btnPower2 a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
               
               activityMainBinding.btnPower2.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnPower2.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               mainViewModel.power2() //Umocni cislo
          }
          
          activityMainBinding.btnPower3.setOnClickListener { //Odkazuje na tlacitko btnPower3 a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
               
               activityMainBinding.btnPower3.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnPower3.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               mainViewModel.power3() //Umocni cislo na treti
          }
          
          activityMainBinding.btnMem1.setOnClickListener {
               
               activityMainBinding.btnMem1.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnMem1.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               if (activityMainBinding.btnMem1.text == "M1") {
                    mainViewModel.mem1()
               }
               else if (activityMainBinding.btnMem1.text == "M6") {
                    mainViewModel.mem6()
               }
               else {
                    mainViewModel.mem11()
               }
               
          }
          
          activityMainBinding.btnMem2.setOnClickListener {
               
               Log.e("mes", "M2 is clicked")
               activityMainBinding.btnMem2.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnMem2.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               if (activityMainBinding.btnMem2.text == "M2") {
                    mainViewModel.mem2()
               }
               else if (activityMainBinding.btnMem2.text == "M7") {
                    mainViewModel.mem7()
               }
               else {
                    mainViewModel.mem12()
               }
          }
          
          activityMainBinding.btnMem3.setOnClickListener {
               
               activityMainBinding.btnMem3.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnMem3.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               if (activityMainBinding.btnMem3.text == "M3") {
                    mainViewModel.mem3()
               }
               else if (activityMainBinding.btnMem3.text == "M8") {
                    mainViewModel.mem8()
               }
               else {
                    mainViewModel.mem13()
               }
          }
          
          activityMainBinding.btnMem4.setOnClickListener {
               
               activityMainBinding.btnMem4.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnMem4.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               if (activityMainBinding.btnMem4.text == "M4") {
                    mainViewModel.mem4()
               }
               else if (activityMainBinding.btnMem4.text == "M9") {
                    mainViewModel.mem9()
               }
               else {
                    mainViewModel.mem14()
               }
          }
          
          activityMainBinding.btnMem5.setOnClickListener {
               
               activityMainBinding.btnMem5.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnMem5.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               if (activityMainBinding.btnMem5.text == "M5") {
                    mainViewModel.mem5()
               }
               else if (activityMainBinding.btnMem5.text == "M10") {
                    mainViewModel.mem10()
               }
               else {
                    mainViewModel.mem15()
               }
          }
          
          activityMainBinding.btnMemoryRecord.setOnClickListener {
               var isClickedCount = 0
               isClickedCount += 1
               
               if (isClickedCount == 1) {
                    
                    val anim : Animation = AlphaAnimation(
                         0.0f, 1.0f
                    )
                    anim.duration = 500 //You can manage the blinking time with this parameter
                    
                    anim.startOffset = 50
                    anim.repeatMode = Animation.ABSOLUTE
                    anim.repeatCount = 5
                    activityMainBinding.btnMem1.startAnimation(anim)
                    activityMainBinding.btnMem2.startAnimation(anim)
                    activityMainBinding.btnMem3.startAnimation(anim)
                    activityMainBinding.btnMem4.startAnimation(anim)
                    activityMainBinding.btnMem5.startAnimation(anim)
                    
                    Toast.makeText(
                         applicationContext, "Please chose one of those memories to store " + "yout result", Toast.LENGTH_LONG
                    )
                        .show()
                    
               }
               mainViewModel.memoryRecord()
          }
          
          
          
          activityMainBinding.btnRecallRecord.setOnClickListener {
               var isClickedCount = 0
               isClickedCount += 1
               
               if (isClickedCount == 1) {
                    
                    val anim : Animation = AlphaAnimation(
                         0.0f, 1.0f
                    )
                    anim.duration = 500 //You can manage the blinking time with this parameter
                    
                    anim.startOffset = 50
                    anim.repeatMode = Animation.ABSOLUTE
                    anim.repeatCount = 5
                    activityMainBinding.btnNumber1.startAnimation(anim)
                    activityMainBinding.btnNumber2.startAnimation(anim)
                    activityMainBinding.btnNumber3.startAnimation(anim)
                    activityMainBinding.btnNumber4.startAnimation(anim)
                    activityMainBinding.btnNumber5.startAnimation(anim)
                    activityMainBinding.btnNumber6.startAnimation(anim)
                    activityMainBinding.btnNumber7.startAnimation(anim)
                    activityMainBinding.btnNumber8.startAnimation(anim)
                    activityMainBinding.btnNumber9.startAnimation(anim)
                    
               }
               mainViewModel.macroRecall()
               
          }
          
          activityMainBinding.btnMemoryClear.setOnClickListener {
               
               var isClickedCount = 0
               isClickedCount += 1
               
               if (isClickedCount == 1) {
                    
                    val anim : Animation = AlphaAnimation(
                         0.0f, 1.0f
                    )
                    anim.duration = 500 //You can manage the blinking time with this parameter
                    
                    anim.startOffset = 50
                    anim.repeatMode = Animation.ABSOLUTE
                    anim.repeatCount = 5
                    activityMainBinding.btnMem1.startAnimation(anim)
                    activityMainBinding.btnMem2.startAnimation(anim)
                    activityMainBinding.btnMem3.startAnimation(anim)
                    activityMainBinding.btnMem4.startAnimation(anim)
                    activityMainBinding.btnMem5.startAnimation(anim)
                    
                    Toast.makeText(
                         applicationContext, "Chose one of those memories to be delted", Toast.LENGTH_LONG
                    )
                        .show()
                    
               }
               mainViewModel.memoryClear()
          }
          
          activityMainBinding.btnSquareRoot.setOnClickListener { //Odkazuje na tlacitko btnSquareRoot a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
               
               activityMainBinding.btnSquareRoot.setBackgroundColor(Color.parseColor("#616596"))
               object : CountDownTimer(
                    55, 110
               ) {
                    override fun onTick(arg0 : Long) { // TODO Auto-generated method stub
                    }
                    
                    override fun onFinish() {
                         activityMainBinding.btnSquareRoot.setBackgroundColor(Color.TRANSPARENT)
                    }
               }.start()
               
               mainViewModel.squareRoot() //odmocni cislo
          }
          
     }
}