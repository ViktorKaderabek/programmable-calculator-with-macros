package com.example.programovatelna_kalkulacka


import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.programovatelna_kalkulacka.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity()
{
     
     private lateinit var mainViewModel : MainViewModel //Promenna ktera odkazuje na tridu, ktera ma obsahuje vsechny funcke a ma za ucel ridit MainActivitu
     private lateinit var activityMainBinding : ActivityMainBinding//Promenna ktera odkazuje na komponenty(buttony,labely atd..) a umoznuje pristup k nim
     
     override fun onCreate(savedInstanceState : Bundle?)
     { //vytvari Activitu
	super.onCreate(savedInstanceState)
	
	activityMainBinding =
	     DataBindingUtil.setContentView(
		this,
		R.layout.activity_main) //tato promenna nastavuje co bude ridit MainActivita
	
	mainViewModel =
	     ViewModelProvider(
		this,
		defaultViewModelProviderFactory
			  ).get(MainViewModel::class.java)//Umoznuje pristup do ViewModelu
	
	mainViewModel.getProcessResult()
	    .observe(
	         this,
	         {
		    activityMainBinding.txtProcess.text = it
	         })//Pokazde kdyz se vysledek getResult(), ktery je v MainViewModel zmeni, tak se zmeni i tady.
	
	mainViewModel.getM1()
	    .observe(
	         this,
	         {
		    activityMainBinding.txtMem1Value.text = it
	         })
	
	mainViewModel.getM2()
	    .observe(
	         this,
	         {
		    activityMainBinding.txtMem2Value.text = it
	         })
	
	mainViewModel.getM3()
	    .observe(
	         this,
	         {
		    activityMainBinding.txtMem3Value.text = it
	         })
	
	mainViewModel.getM4()
	    .observe(
	         this,
	         {
		    activityMainBinding.txtMem4Value.text = it
	         })
	
	mainViewModel.getM5()
	    .observe(
	         this,
	         {
		    activityMainBinding.txtMem5Value.text = it
	         })
	
	mainViewModel.getResult()
	    .observe(
	         this,
	         {
		    activityMainBinding.txtResult.text = it
	         })
	
	mainViewModel.quadraticResult1()
	    .observe(
	         this,
	         {
		    activityMainBinding.txtFirstNumber.text = it
	         })
	
	mainViewModel.quadraticResult2()
	    .observe(
	         this,
	         {
		    activityMainBinding.txtSecondNumber.text = it
	         })
	
	mainViewModel.quadraticResult3()
	    .observe(
	         this,
	         {
		    activityMainBinding.txtThirdNumber.text = it
	         })
	
	mainViewModel.firstOperation()
	    .observe(
	         this,
	         {
		    activityMainBinding.txtFirstOperator.text = it
	         })
	
	mainViewModel.secondOperation()
	    .observe(
	         this,
	         {
		    activityMainBinding.txtSecondOperator.text = it
	         })
	
	mainViewModel.getX1Root()
	    .observe(
	         this,
	         {
		    activityMainBinding.txtX1RootNumber.text = it
	         })
	
	mainViewModel.getX2Root()
	    .observe(
	         this,
	         {
		    activityMainBinding.txtX2RootNumber.text = it
	         })
	
	mainViewModel.getDeterminant()
	    .observe(
	         this,
	         {
		    activityMainBinding.txtDeterminantNumber.text = it
	         })
	
	
	activityMainBinding.determinantLayout.visibility = View.INVISIBLE
	activityMainBinding.x1RootLayout.visibility = View.INVISIBLE
	activityMainBinding.x2RootLayout.visibility = View.INVISIBLE
	activityMainBinding.quadraticEqualation.visibility = View.INVISIBLE
	
	
	if (activityMainBinding.txtResult.text.isEmpty())
	{ //pokud se result label == " " tak nezustane prazdny ale, pokazde kdyz je prazndy, tak tam bude zapsana "0"
	     activityMainBinding.txtResult.text = "0"
	}
	activityMainBinding.btnLastResult.setOnClickListener {
	     
	     activityMainBinding.btnLastResult.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnLastResult.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.ansShow()
	}
	
	activityMainBinding.btnNumber00.setOnClickListener {
	     
	     activityMainBinding.btnNumber00.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnNumber00.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.addNumber00()
	     
	}
	
	activityMainBinding.btnInfo.setOnClickListener {
	     
	     val alertadd = AlertDialog.Builder(this)
	     val factory = LayoutInflater.from(applicationContext)
	     val view : View = factory.inflate(R.layout.activity_dialog,
				         null)
	     alertadd.setView(view)
	     alertadd.setNeutralButton("Ok!",
				 DialogInterface.OnClickListener { dlg, sumthin -> })
	     
	     alertadd.show()
	     
	     /* if(activityMainBinding.btnMem1.visibility == View.INVISIBLE){
	     
		 activityMainBinding.btnMem1.visibility == View.VISIBLE
	      }else {
		 activityMainBinding.btnMem1.visibility == View.INVISIBLE
	      }*/
	      
	}
	
	activityMainBinding.btnQuadraticEqFun.setOnClickListener {
	     
	     if (activityMainBinding.determinantLayout.visibility == View.INVISIBLE)
	     {
		
		activityMainBinding.determinantLayout.visibility = View.VISIBLE
		activityMainBinding.x1RootLayout.visibility = View.VISIBLE
		activityMainBinding.x2RootLayout.visibility = View.VISIBLE
		activityMainBinding.quadraticEqualation.visibility = View.VISIBLE
		
		activityMainBinding.txtLastResult.visibility = View.INVISIBLE
		activityMainBinding.txtResult.visibility = View.INVISIBLE
		activityMainBinding.txtProcess.visibility = View.INVISIBLE
	     }
	     else
	     {
		
		activityMainBinding.determinantLayout.visibility = View.INVISIBLE
		activityMainBinding.x1RootLayout.visibility = View.INVISIBLE
		activityMainBinding.x2RootLayout.visibility = View.INVISIBLE
		activityMainBinding.quadraticEqualation.visibility = View.INVISIBLE
		
		activityMainBinding.txtLastResult.visibility = View.VISIBLE
		activityMainBinding.txtResult.visibility = View.VISIBLE
		activityMainBinding.txtProcess.visibility = View.VISIBLE
	     }
	     
	     if (activityMainBinding.determinantLayout.visibility == View.VISIBLE)
	     {
		activityMainBinding.btnQuadraticEqFun.setBackgroundColor(Color.parseColor("#616596"))
	     }
	     else
	     {
		activityMainBinding.btnQuadraticEqFun.setBackgroundColor(Color.TRANSPARENT)
	     }
	     
	     mainViewModel.quadraticEqualation()
	}
	
	activityMainBinding.btnNumber1.setOnClickListener { //Odkazuje na tlacitko btnNumber1 a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
	     
	     activityMainBinding.btnNumber1.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnNumber1.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.addNumber1() //prida do labelu "1"
	}
	
	activityMainBinding.btnNumber2.setOnClickListener {//Odkazuje na tlacitko btnNumber2 a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
	     
	     activityMainBinding.btnNumber2.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnNumber2.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.addNumber2()//prida do labelu "2"
	}
	
	activityMainBinding.btnNumber3.setOnClickListener {//Odkazuje na tlacitko btnNumber3 a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
	     
	     activityMainBinding.btnNumber3.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnNumber3.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.addNumber3()//prida do labelu "3"
	}
	
	activityMainBinding.btnNumber4.setOnClickListener {//Odkazuje na tlacitko btnNumber4 a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
	     
	     activityMainBinding.btnNumber4.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnNumber4.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.addNumber4()//prida do labelu "4"
	}
	
	activityMainBinding.btnNumber5.setOnClickListener {//Odkazuje na tlacitko btnNumber5 a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
	     
	     activityMainBinding.btnNumber5.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnNumber5.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.addNumber5()//prida do labelu "5"
	}
	
	activityMainBinding.btnNumber6.setOnClickListener {//Odkazuje na tlacitko btnNumber6 a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
	     
	     activityMainBinding.btnNumber6.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnNumber6.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.addNumber6()//prida do labelu "6"
	}
	
	activityMainBinding.btnNumber7.setOnClickListener {//Odkazuje na tlacitko btnNumber7 a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
	     
	     activityMainBinding.btnNumber7.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnNumber7.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.addNumber7()//prida do labelu "7"
	}
	
	activityMainBinding.btnNumber8.setOnClickListener {//Odkazuje na tlacitko btnNumber8 a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
	     
	     activityMainBinding.btnNumber8.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnNumber8.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.addNumber8()//prida do labelu "8"
	}
	
	activityMainBinding.btnNumber9.setOnClickListener {//Odkazuje na tlacitko btnNumber9 a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
	     
	     activityMainBinding.btnNumber9.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnNumber9.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.addNumber9()//prida do labelu "9"
	}
	
	activityMainBinding.btnNumber0.setOnClickListener {//Odkazuje na tlacitko btnNumber0 a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
	     
	     activityMainBinding.btnNumber0.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnNumber0.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.addNumber0()//prida do labelu "0"
	}
	
	activityMainBinding.btnDot.setOnClickListener { //Odkazuje na tlacitko btnDot a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
	     
	     activityMainBinding.btnDot.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnDot.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.addDot()//prida do labelu "."
	}
	
	activityMainBinding.btnDeleteAll.setOnClickListener {//Odkazuje na tlacitko btnDot a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
	     
	     activityMainBinding.btnDeleteAll.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnDeleteAll.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.deleteAll() //vymaze vse co zatim bylo v labelu result zapsano a nastavi hodnotu na "0" takze pokud tam bylo napsano treba cislo "22",tak po stisku tohot tlacitka bude hodnota "0"
	}
	
	activityMainBinding.btnDeleteOneObject.setOnClickListener {//Odkazuje na tlacitko btnDeleteOneObject a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
	     
	     activityMainBinding.btnDeleteOneObject.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnDeleteOneObject.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.deleteOneChar() //maze z labelu po jednoum cisle
	}
	
	activityMainBinding.btnChangeTheSymbol.setOnClickListener {//Odkazuje na tlacitko btnChangeTheSymbol a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
	     
	     activityMainBinding.btnChangeTheSymbol.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnChangeTheSymbol.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.changeSymbol()//meni hodnotu z "+" na "-" a opačně
	}
	
	activityMainBinding.btnPlus.setOnClickListener { //Odkazuje na tlacitko btnPlus a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
	     
	     activityMainBinding.btnPlus.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnPlus.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     
	     mainViewModel.plus() //tato funkce momentalne jeste neni dodelana ale mela by scitat cisla v labelu
	}
	
	activityMainBinding.btnMinus.setOnClickListener { //Odkazuje na
	     
	     activityMainBinding.btnMinus.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnMinus.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.minus()
	}
	
	activityMainBinding.btnMultiply.setOnClickListener {
	     
	     activityMainBinding.btnMultiply.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnMultiply.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.multiply()
	}
	
	activityMainBinding.btnDevided.setOnClickListener {
	     
	     activityMainBinding.btnDevided.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnDevided.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.divide()
	}
	
	activityMainBinding.btnEqual.setOnClickListener {
	     
	     activityMainBinding.btnEqual.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnEqual.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     //Odkazuje na tlacitko btnEqual a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
	     mainViewModel.equal() // provede funkci equal, ktera je ve MainViewModelu
	     mainViewModel.equalSend()//provede funkci equalSend, ktera je ve MainViewModelu
	     mainViewModel.getResult()
	         .observe(
		    this,
		    {
		         activityMainBinding.txtResult.text = it
		    }) // zmeni text v labelu kde je hlavni text
	     mainViewModel.equalSend()
	         .observe(
		    this,
		    {
		         activityMainBinding.txtLastResult.text = it
		    }) // zmeni text v labelu kde se zobrazuje lastResult na text, ktery je v hlavnim labelu
	}
	
	activityMainBinding.btnPercent.setOnClickListener { //Odkazuje na tlacitko btnPercent a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
	     
	     activityMainBinding.btnPercent.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnPercent.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.percent()//Konvertuje cislo na procento
	}
	
	activityMainBinding.btnPower2.setOnClickListener {//Odkazuje na tlacitko btnPower2 a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
	     
	     activityMainBinding.btnPower2.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnPower2.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.power2()//Umocni cislo
	}
	
	activityMainBinding.btnPower3.setOnClickListener {//Odkazuje na tlacitko btnPower3 a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
	     
	     activityMainBinding.btnPower3.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnPower3.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.power3()//Umocni cislo na treti
	}
	
	activityMainBinding.btnMem1.setOnClickListener {
	     
	     activityMainBinding.btnMem1.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnMem1.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.mem1()
	}
	
	activityMainBinding.btnMem2.setOnClickListener {
	     
	     activityMainBinding.btnMem2.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnMem2.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.mem2()
	}
	
	activityMainBinding.btnMem3.setOnClickListener {
	     
	     activityMainBinding.btnMem3.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnMem3.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.mem3()
	}
	
	activityMainBinding.btnMem4.setOnClickListener {
	     
	     activityMainBinding.btnMem4.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnMem4.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.mem4()
	}
	
	activityMainBinding.btnMem5.setOnClickListener {
	     
	     activityMainBinding.btnMem5.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnMem5.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.mem5()
	}
	
	activityMainBinding.btnMemoryRecord.setOnClickListener {
	     var isClickedCount = 0
	     isClickedCount += 1
	     
	     if (isClickedCount == 1)
	     {
		
		val anim : Animation = AlphaAnimation(0.0f,
					        1.0f)
		anim.duration = 500 //You can manage the blinking time with this parameter
		
		anim.startOffset = 50
		anim.repeatMode = Animation.ABSOLUTE
		anim.repeatCount = 5
		activityMainBinding.btnMem1.startAnimation(anim)
		activityMainBinding.btnMem2.startAnimation(anim)
		activityMainBinding.btnMem3.startAnimation(anim)
		activityMainBinding.btnMem4.startAnimation(anim)
		activityMainBinding.btnMem5.startAnimation(anim)
		
		Toast.makeText(applicationContext,
			     "Please chose one of those memories to store " +
			     "yout result",
			     Toast.LENGTH_LONG)
		    .show()
		
	     }
	     mainViewModel.memoryRecord()
	}
	
	activityMainBinding.btnStarRecord.setOnClickListener {
	     var isClickedCount = 0
	     isClickedCount += 1
	     
	     if (isClickedCount == 1)
	     {
		
		val anim : Animation = AlphaAnimation(0.0f,
					        1.0f)
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
		
		Toast.makeText(applicationContext,
			     "Please set one of those numbers to store the record that you " +
			     "made",
			     Toast.LENGTH_LONG)
		    .show()
		
	     }
	}
	
	activityMainBinding.btnRecallRecord.setOnClickListener {
	     var isClickedCount = 0
	     isClickedCount += 1
	     
	     if (isClickedCount == 1)
	     {
		
		val anim : Animation = AlphaAnimation(0.0f,
					        1.0f)
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
		
		Toast.makeText(applicationContext,
			     "Please select of one of those numbers where you stored the " +
			     "record",
			     Toast.LENGTH_LONG)
		    .show()
		
	     }
	}
	
	activityMainBinding.btnMemoryClear.setOnClickListener {
	     
	     var isClickedCount = 0
	     isClickedCount += 1
	     
	     if (isClickedCount == 1)
	     {
		
		val anim : Animation = AlphaAnimation(0.0f,
					        1.0f)
		anim.duration = 500 //You can manage the blinking time with this parameter
		
		anim.startOffset = 50
		anim.repeatMode = Animation.ABSOLUTE
		anim.repeatCount = 5
		activityMainBinding.btnMem1.startAnimation(anim)
		activityMainBinding.btnMem2.startAnimation(anim)
		activityMainBinding.btnMem3.startAnimation(anim)
		activityMainBinding.btnMem4.startAnimation(anim)
		activityMainBinding.btnMem5.startAnimation(anim)
		
		Toast.makeText(applicationContext,
			     "Chose one of those memories to be delted",
			     Toast.LENGTH_LONG)
		    .show()
		
	     }
	     mainViewModel.memoryClear()
	}
	
	activityMainBinding.btnSquareRoot.setOnClickListener {//Odkazuje na tlacitko btnSquareRoot a rika mu ze kdyz se zmackne tak se provede tato funkce, ktera je ulozena ve MainViewModel
	     
	     activityMainBinding.btnSquareRoot.setBackgroundColor(Color.parseColor("#616596"))
	     object : CountDownTimer(55,
			         110)
	     {
		override fun onTick(arg0 : Long)
		{
		     // TODO Auto-generated method stub
		}
		
		override fun onFinish()
		{
		     activityMainBinding.btnSquareRoot.setBackgroundColor(Color.TRANSPARENT)
		}
	     }.start()
	     
	     mainViewModel.squareRoot()//odmocni cislo
	}
	
     }
}