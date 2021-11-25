package com.example.programovatelna_kalkulacka

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.sqrt


class MainViewModel : ViewModel()
{
     
     private var floatHolder : Float = 0f
     private var longHolder : Long = 0
     private var resultHolder : String = "0"
     private var processHolder : String = ""
     private var resultHolderLenght : Int = 0
     private var ansHolder : String = ""
     private var stringHolder : String = ""
     private var symbolClicked : String = ""
     
     private var quadraticEqualationIsClickedCount : Int = 0
     private var quadraticEqualationIsClicked : Boolean = false
     private var quadraticNum1Holder : String = ""
     private var quadraticNum2Holder : String = ""
     private var quadraticNum3Holder : String = ""
     private var firstOperation : String = ""
     private var secondOperation : String = ""
     private var x1RootHolder : Double = 0.0
     private var x2RootHolder : Double = 0.0
     private var a : Double = 0.0
     private var b : Double = 0.0
     private var c : Double = 0.0
     private var click : Int = 0
     
     private var mem1Holder : String = ""
     private var mem2Holder : String = ""
     private var mem3Holder : String = ""
     private var mem4Holder : String = ""
     private var mem5Holder : String = ""
     
     private var isClicked : Boolean = false
     private var memRecordIsClicked : Boolean = false
     private var memCLearIsClicked : Boolean = false
     
     private var isClickedCount : Int = 0
     private var memIsClickedCount : Int = 0
     private var symbolIsClickedCount : Int = 0
     
     private var macroResult : Int = 0
     
     private var quadraticNum1Result = MutableLiveData<String>()
     private var quadraticNum2Result = MutableLiveData<String>()
     private var quadraticNum3Result = MutableLiveData<String>()
     private var determinantResult = MutableLiveData<String>()
     private var firstOperationResult = MutableLiveData<String>()
     private var secondOperationResult = MutableLiveData<String>()
     private var x1RootResult = MutableLiveData<String>()
     private var x2RootResult = MutableLiveData<String>()
     
     private val lastResult = MutableLiveData<String>()
     private val proccessResult = MutableLiveData<String>()
     private val result = MutableLiveData<String>()
     
     private val mem1Value = MutableLiveData<String>()
     private val mem2Value = MutableLiveData<String>()
     private val mem3Value = MutableLiveData<String>()
     private val mem4Value = MutableLiveData<String>()
     private val mem5Value = MutableLiveData<String>()
     //---------------------------------------------------\\
     
     fun addNumber1()
     {
	if (quadraticEqualationIsClicked)
	{
	     if (firstOperation.isEmpty())
	     {
		quadraticNum1Holder = quadraticNum1Holder.plus("1")
		quadraticNum1Result.value = quadraticNum1Holder
	     }
	     else if (firstOperation.isNotEmpty() && secondOperation.isEmpty())
	     {
		quadraticNum2Holder = quadraticNum2Holder.plus("1")
		quadraticNum2Result.value = quadraticNum2Holder
	     }
	     else
	     {
		
		quadraticNum3Holder = quadraticNum3Holder.plus("1")
		quadraticNum3Result.value = quadraticNum3Holder
	     }
	}
	else
	{
	     
	     if (resultHolder == "0" || resultHolder == "Error")
	     {
		resultHolder = ""
		if (processHolder == "0" || processHolder.isEmpty())
		{
		     
		     processHolder = processHolder.drop(1)
		     processHolder = processHolder.plus("1")
		}
		else
		{
		     
		     processHolder = processHolder.plus("1")
		}
		resultHolder = resultHolder.plus("1")
	     }
	     else if (resultHolder == "-0")
	     {
		resultHolder = ""
		processHolder = processHolder.plus("-1")
		resultHolder = resultHolder.plus("-1")
	     }
	     else if (isClicked)
	     {
		processHolder = ""
		resultHolder = ""
		processHolder = processHolder.plus("1")
		resultHolder = resultHolder.plus("1")
		isClicked = false
		
	     }
	     else
	     {
		processHolder = processHolder.plus("1")
		resultHolder = resultHolder.plus("1")
	     }
	     result.value = resultHolder
	     proccessResult.value = processHolder
	}
     }
     
     fun addNumber2()
     {
	if (quadraticEqualationIsClicked)
	{
	     if (firstOperation.isEmpty())
	     {
		quadraticNum1Holder = quadraticNum1Holder.plus("2")
		quadraticNum1Result.value = quadraticNum1Holder
	     }
	     else if (firstOperation.isNotEmpty() && secondOperation.isEmpty())
	     {
		quadraticNum2Holder = quadraticNum2Holder.plus("2")
		quadraticNum2Result.value = quadraticNum2Holder
	     }
	     else
	     {
		
		quadraticNum3Holder = quadraticNum3Holder.plus("2")
		quadraticNum3Result.value = quadraticNum3Holder
	     }
	}
	else
	{
	     
	     if (resultHolder == "0" || resultHolder == "Error")
	     {
		resultHolder = ""
		if (processHolder == "0" || processHolder.isEmpty())
		{
		     
		     processHolder = processHolder.drop(1)
		     processHolder = processHolder.plus("2")
		}
		else
		{
		     
		     processHolder = processHolder.plus("2")
		}
		resultHolder = resultHolder.plus("2")
	     }
	     else if (resultHolder == "-0")
	     {
		resultHolder = ""
		processHolder = processHolder.plus("-2")
		resultHolder = resultHolder.plus("-2")
	     }
	     else if (isClicked)
	     {
		processHolder = ""
		resultHolder = ""
		processHolder = processHolder.plus("2")
		resultHolder = resultHolder.plus("2")
		isClicked = false
		
	     }
	     else
	     {
		
		processHolder = processHolder.plus("2")
		resultHolder = resultHolder.plus("2")
	     }
	     result.value = resultHolder
	     proccessResult.value = processHolder
	     
	}
	
     }
     
     fun addNumber3()
     {
	if (quadraticEqualationIsClicked)
	{
	     if (firstOperation.isEmpty())
	     {
		quadraticNum1Holder = quadraticNum1Holder.plus("3")
		quadraticNum1Result.value = quadraticNum1Holder
	     }
	     else if (firstOperation.isNotEmpty() && secondOperation.isEmpty())
	     {
		quadraticNum2Holder = quadraticNum2Holder.plus("3")
		quadraticNum2Result.value = quadraticNum2Holder
	     }
	     else
	     {
		
		quadraticNum3Holder = quadraticNum3Holder.plus("3")
		quadraticNum3Result.value = quadraticNum3Holder
	     }
	}
	else
	{
	     
	     if (resultHolder == "0" || resultHolder == "Error")
	     {
		resultHolder = ""
		if (processHolder == "0" || processHolder.isEmpty())
		{
		     
		     processHolder = processHolder.drop(1)
		     processHolder = processHolder.plus("3")
		}
		else
		{
		     
		     processHolder = processHolder.plus("3")
		}
		resultHolder = resultHolder.plus("3")
	     }
	     else if (resultHolder == "-0")
	     {
		resultHolder = ""
		processHolder = processHolder.plus("-3")
		resultHolder = resultHolder.plus("-3")
	     }
	     else if (isClicked)
	     {
		processHolder = ""
		resultHolder = ""
		processHolder = processHolder.plus("3")
		resultHolder = resultHolder.plus("3")
		isClicked = false
	     }
	     else
	     {
		
		processHolder = processHolder.plus("3")
		resultHolder = resultHolder.plus("3")
	     }
	     result.value = resultHolder
	     proccessResult.value = processHolder
	}
	
     }
     
     fun addNumber4()
     {
	if (quadraticEqualationIsClicked)
	{
	     if (firstOperation.isEmpty())
	     {
		quadraticNum1Holder = quadraticNum1Holder.plus("4")
		quadraticNum1Result.value = quadraticNum1Holder
	     }
	     else if (firstOperation.isNotEmpty() && secondOperation.isEmpty())
	     {
		quadraticNum2Holder = quadraticNum2Holder.plus("4")
		quadraticNum2Result.value = quadraticNum2Holder
	     }
	     else
	     {
		
		quadraticNum3Holder = quadraticNum3Holder.plus("4")
		quadraticNum3Result.value = quadraticNum3Holder
	     }
	}
	else
	{
	     if (resultHolder == "0" || resultHolder == "Error")
	     {
		resultHolder = ""
		if (processHolder == "0" || processHolder.isEmpty())
		{
		     
		     processHolder = processHolder.drop(1)
		     processHolder = processHolder.plus("4")
		}
		else
		{
		     
		     processHolder = processHolder.plus("4")
		}
		resultHolder = resultHolder.plus("4")
	     }
	     else if (resultHolder == "-0")
	     {
		resultHolder = ""
		processHolder = processHolder.plus("-4")
		resultHolder = resultHolder.plus("-4")
	     }
	     else if (isClicked)
	     {
		processHolder = ""
		resultHolder = ""
		processHolder = processHolder.plus("4")
		resultHolder = resultHolder.plus("4")
		isClicked = false
		
	     }
	     else
	     {
		
		processHolder = processHolder.plus("4")
		resultHolder = resultHolder.plus("4")
	     }
	     result.value = resultHolder
	     proccessResult.value = processHolder
	}
     }
     
     fun addNumber5()
     {
	if (quadraticEqualationIsClicked)
	{
	     if (firstOperation.isEmpty())
	     {
		quadraticNum1Holder = quadraticNum1Holder.plus("5")
		quadraticNum1Result.value = quadraticNum1Holder
	     }
	     else if (firstOperation.isNotEmpty() && secondOperation.isEmpty())
	     {
		quadraticNum2Holder = quadraticNum2Holder.plus("5")
		quadraticNum2Result.value = quadraticNum2Holder
	     }
	     else
	     {
		
		quadraticNum3Holder = quadraticNum3Holder.plus("5")
		quadraticNum3Result.value = quadraticNum3Holder
	     }
	}
	else
	{
	     if (resultHolder == "0" || resultHolder == "Error")
	     {
		resultHolder = ""
		if (processHolder == "0" || processHolder.isEmpty())
		{
		     
		     processHolder = processHolder.drop(1)
		     processHolder = processHolder.plus("5")
		}
		else
		{
		     
		     processHolder = processHolder.plus("5")
		}
		resultHolder = resultHolder.plus("5")
	     }
	     else if (resultHolder == "-0")
	     {
		resultHolder = ""
		processHolder = processHolder.plus("-5")
		resultHolder = resultHolder.plus("-5")
	     }
	     else if (isClicked)
	     {
		processHolder = ""
		resultHolder = ""
		processHolder = processHolder.plus("5")
		resultHolder = resultHolder.plus("5")
		isClicked = false
		
	     }
	     else
	     {
		
		processHolder = processHolder.plus("5")
		resultHolder = resultHolder.plus("5")
	     }
	     result.value = resultHolder
	     proccessResult.value = processHolder
	}
     }
     
     fun addNumber6()
     {
	if (quadraticEqualationIsClicked)
	{
	     if (firstOperation.isEmpty())
	     {
		quadraticNum1Holder = quadraticNum1Holder.plus("6")
		quadraticNum1Result.value = quadraticNum1Holder
	     }
	     else if (firstOperation.isNotEmpty() && secondOperation.isEmpty())
	     {
		quadraticNum2Holder = quadraticNum2Holder.plus("6")
		quadraticNum2Result.value = quadraticNum2Holder
	     }
	     else
	     {
		
		quadraticNum3Holder = quadraticNum3Holder.plus("6")
		quadraticNum3Result.value = quadraticNum3Holder
	     }
	}
	else
	{
	     if (resultHolder == "0" || resultHolder == "Error")
	     {
		resultHolder = ""
		if (processHolder == "0" || processHolder.isEmpty())
		{
		     
		     processHolder = processHolder.drop(1)
		     processHolder = processHolder.plus("6")
		}
		else
		{
		     
		     processHolder = processHolder.plus("6")
		}
		resultHolder = resultHolder.plus("6")
	     }
	     else if (resultHolder == "-0")
	     {
		resultHolder = ""
		processHolder = processHolder.plus("-6")
		resultHolder = resultHolder.plus("-6")
	     }
	     else if (isClicked)
	     {
		processHolder = ""
		resultHolder = ""
		processHolder = processHolder.plus("6")
		resultHolder = resultHolder.plus("6")
		isClicked = false
		
	     }
	     else
	     {
		
		processHolder = processHolder.plus("6")
		resultHolder = resultHolder.plus("6")
	     }
	     result.value = resultHolder
	     proccessResult.value = processHolder
	}
     }
     
     fun addNumber7()
     {
	if (quadraticEqualationIsClicked)
	{
	     if (firstOperation.isEmpty())
	     {
		quadraticNum1Holder = quadraticNum1Holder.plus("7")
		quadraticNum1Result.value = quadraticNum1Holder
	     }
	     else if (firstOperation.isNotEmpty() && secondOperation.isEmpty())
	     {
		quadraticNum2Holder = quadraticNum2Holder.plus("7")
		quadraticNum2Result.value = quadraticNum2Holder
	     }
	     else
	     {
		
		quadraticNum3Holder = quadraticNum3Holder.plus("7")
		quadraticNum3Result.value = quadraticNum3Holder
	     }
	}
	else
	{
	     if (resultHolder == "0" || resultHolder == "Error")
	     {
		resultHolder = ""
		if (processHolder == "0" || processHolder.isEmpty())
		{
		     
		     processHolder = processHolder.drop(1)
		     processHolder = processHolder.plus("7")
		}
		else
		{
		     
		     processHolder = processHolder.plus("7")
		}
		resultHolder = resultHolder.plus("7")
	     }
	     else if (resultHolder == "-0")
	     {
		
		resultHolder = ""
		processHolder = processHolder.plus("-7")
		resultHolder = resultHolder.plus("-7")
	     }
	     else if (isClicked)
	     {
		processHolder = ""
		resultHolder = ""
		processHolder = processHolder.plus("7")
		resultHolder = resultHolder.plus("7")
		isClicked = false
		
	     }
	     else
	     {
		
		processHolder = processHolder.plus("7")
		resultHolder = resultHolder.plus("7")
	     }
	     result.value = resultHolder
	     proccessResult.value = processHolder
	}
     }
     
     fun addNumber8()
     {
	if (quadraticEqualationIsClicked)
	{
	     if (firstOperation.isEmpty())
	     {
		quadraticNum1Holder = quadraticNum1Holder.plus("8")
		quadraticNum1Result.value = quadraticNum1Holder
	     }
	     else if (firstOperation.isNotEmpty() && secondOperation.isEmpty())
	     {
		quadraticNum2Holder = quadraticNum2Holder.plus("8")
		quadraticNum2Result.value = quadraticNum2Holder
	     }
	     else
	     {
		
		quadraticNum3Holder = quadraticNum3Holder.plus("8")
		quadraticNum3Result.value = quadraticNum3Holder
	     }
	}
	else
	{
	     if (resultHolder == "0" || resultHolder == "Error")
	     {
		resultHolder = ""
		if (processHolder == "0" || processHolder.isEmpty())
		{
		     
		     processHolder = processHolder.drop(1)
		     processHolder = processHolder.plus("8")
		}
		else
		{
		     
		     processHolder = processHolder.plus("8")
		}
		resultHolder = resultHolder.plus("8")
	     }
	     else if (resultHolder == "-0")
	     {
		
		resultHolder = ""
		processHolder = processHolder.plus("-8")
		resultHolder = resultHolder.plus("-8")
	     }
	     else if (isClicked)
	     {
		processHolder = ""
		resultHolder = ""
		processHolder = processHolder.plus("8")
		resultHolder = resultHolder.plus("8")
		isClicked = false
		
	     }
	     else
	     {
		
		processHolder = processHolder.plus("8")
		resultHolder = resultHolder.plus("8")
	     }
	     result.value = resultHolder
	     proccessResult.value = processHolder
	}
     }
     
     fun addNumber9()
     {
	if (quadraticEqualationIsClicked)
	{
	     if (firstOperation.isEmpty())
	     {
		quadraticNum1Holder = quadraticNum1Holder.plus("9")
		quadraticNum1Result.value = quadraticNum1Holder
	     }
	     else if (firstOperation.isNotEmpty() && secondOperation.isEmpty())
	     {
		quadraticNum2Holder = quadraticNum2Holder.plus("9")
		quadraticNum2Result.value = quadraticNum2Holder
	     }
	     else
	     {
		
		quadraticNum3Holder = quadraticNum3Holder.plus("9")
		quadraticNum3Result.value = quadraticNum3Holder
	     }
	}
	else
	{
	     if (resultHolder == "0" || resultHolder == "Error")
	     {
		resultHolder = ""
		if (processHolder == "0" || processHolder.isEmpty())
		{
		     
		     processHolder = processHolder.drop(1)
		     processHolder = processHolder.plus("9")
		}
		else
		{
		     
		     processHolder = processHolder.plus("9")
		}
		resultHolder = resultHolder.plus("9")
	     }
	     else if (resultHolder == "-0")
	     {
		resultHolder = ""
		processHolder = processHolder.plus("-9")
		resultHolder = resultHolder.plus("-9")
	     }
	     else if (isClicked)
	     {
		processHolder = ""
		resultHolder = ""
		processHolder = processHolder.plus("9")
		resultHolder = resultHolder.plus("9")
		isClicked = false
		
	     }
	     else
	     {
		
		processHolder = processHolder.plus("9")
		resultHolder = resultHolder.plus("9")
	     }
	     result.value = resultHolder
	     proccessResult.value = processHolder
	}
     }
     
     fun addNumber0()
     {
	if (quadraticEqualationIsClicked)
	{
	     if (firstOperation.isEmpty())
	     {
		quadraticNum1Holder = quadraticNum1Holder.plus("0")
		quadraticNum1Result.value = quadraticNum1Holder
	     }
	     else if (firstOperation.isNotEmpty() && secondOperation.isEmpty())
	     {
		quadraticNum2Holder = quadraticNum2Holder.plus("0")
		quadraticNum2Result.value = quadraticNum2Holder
	     }
	     else
	     {
		
		quadraticNum3Holder = quadraticNum3Holder.plus("0")
		quadraticNum3Result.value = quadraticNum3Holder
	     }
	}
	else
	{
	     if (resultHolder == "0" || resultHolder == "Error")
	     {
		resultHolder = ""
		if (processHolder == "0" || processHolder.isEmpty())
		{
		     
		     processHolder = processHolder.drop(1)
		     processHolder = processHolder.plus("0")
		}
		else
		{
		     
		     processHolder = processHolder.plus("0")
		}
		resultHolder = resultHolder.plus("0")
	     }
	     else if (isClicked)
	     {
		processHolder = ""
		resultHolder = ""
		processHolder = processHolder.plus("0")
		resultHolder = resultHolder.plus("0")
		isClicked = false
		
	     }
	     else
	     {
		
		processHolder = processHolder.plus("0")
		resultHolder = resultHolder.plus("0")
	     }
	     result.value = resultHolder
	     proccessResult.value = processHolder
	}
     }
     
     fun addNumber00()
     {
	
	if (resultHolder == "0" || resultHolder == "Error")
	{
	     resultHolder = "0"
	     if (processHolder == "0" || processHolder.isEmpty())
	     {
		
	     }
	     
	}
	else if (resultHolder == "-0")
	{
	     resultHolder = ""
	     processHolder = processHolder.plus("-00")
	     resultHolder = resultHolder.plus("-00")
	}
	else if (isClicked)
	{
	     processHolder = ""
	     resultHolder = ""
	     processHolder = processHolder.plus("00")
	     resultHolder = resultHolder.plus("00")
	     isClicked = false
	     
	}
	else
	{
	     processHolder = processHolder.plus("00")
	     resultHolder = resultHolder.plus("00")
	}
	result.value = resultHolder
	proccessResult.value = processHolder
	
     }
     
     fun addDot()
     {
	if (quadraticEqualationIsClicked)
	{
	     if (firstOperation.isEmpty())
	     {
		if (quadraticNum1Holder.contains("."))
		{
		     quadraticNum1Result.value = quadraticNum1Holder
		}
		else
		{
		     quadraticNum1Holder = quadraticNum1Holder.plus(".")
		     quadraticNum1Result.value = quadraticNum1Holder
		}
	     }
	     else if (firstOperation.isNotEmpty() && secondOperation.isEmpty())
	     {
		if (quadraticNum2Holder.contains("."))
		{
		     quadraticNum2Result.value = quadraticNum2Holder
		}
		else
		{
		     quadraticNum2Holder = quadraticNum2Holder.plus(".")
		     quadraticNum2Result.value = quadraticNum2Holder
		}
	     }
	     else
	     {
		if (quadraticNum3Holder.contains("."))
		{
		     quadraticNum3Result.value = quadraticNum3Holder
		}
		else
		{
		     quadraticNum3Holder = quadraticNum3Holder.plus(".")
		     quadraticNum3Result.value = quadraticNum3Holder
		}
	     }
	}
	else
	{
	     if (processHolder.isEmpty())
	     {
		
		processHolder = "0"
		proccessResult.value = processHolder
		
	     }
	     else if (resultHolder == "0" && processHolder.contains("+") || processHolder.contains("-")
		    ||
		    processHolder
		        .contains("*") || processHolder.contains("/")
	     )
	     {
		processHolder += "0"
		proccessResult.value = processHolder
		Log.e("mesage",
		      resultHolder.toString())
	     }
	     
	     when
	     {
		resultHolder.contains(".") ->
		{
		
		}
		resultHolder.isEmpty() ->
		{
		     resultHolder = resultHolder.plus("0.")
		     processHolder = processHolder.plus("0.")
		}
		resultHolder.isNotEmpty() && resultHolder != "." ->
		{
		     resultHolder = resultHolder.plus(".")
		     processHolder = processHolder.plus(".")
		}
	     }
	     result.value = resultHolder
	     proccessResult.value = processHolder
	}
     }
     
     fun deleteAll()
     {
	if (quadraticEqualationIsClicked)
	{
	     
	     quadraticEqualationIsClickedCount = 0
	     quadraticNum1Holder = ""
	     quadraticNum2Holder = ""
	     quadraticNum3Holder = ""
	     firstOperation = ""
	     secondOperation = ""
	     x1RootHolder = 0.0
	     x2RootHolder = 0.0
	     a = 0.0
	     b = 0.0
	     c = 0.0
	     
	     quadraticNum1Result.value = ""
	     quadraticNum2Result.value = ""
	     quadraticNum3Result.value = ""
	     determinantResult.value = ""
	     firstOperationResult.value = ""
	     secondOperationResult.value = ""
	     x1RootResult.value = ""
	     x2RootResult.value = ""
	}
	else
	{
	     floatHolder = 0f
	     longHolder = 0
	     resultHolder = "0"
	     processHolder = ""
	     resultHolderLenght = 0
	     symbolClicked = ""
	     
	     isClicked = false
	     memRecordIsClicked = false
	     memCLearIsClicked = false
	     
	     isClickedCount = 0
	     memIsClickedCount = 0
	     symbolIsClickedCount = 0
	     macroResult = 0
	     
	     proccessResult.value = ""
	     result.value = "0"
	}
     }
     
     fun deleteOneChar()
     {
	if (quadraticEqualationIsClicked)
	{
	     if (quadraticNum3Holder.isNotEmpty())
	     {
		
		quadraticNum3Holder = quadraticNum3Holder.dropLast(1)
		quadraticNum3Result.value = quadraticNum3Holder
	     }
	     else if (quadraticNum3Holder.isEmpty() && secondOperation.isNotEmpty())
	     {
		
		secondOperation = secondOperation.dropLast(1)
		secondOperationResult.value = secondOperation
	     }
	     else if (quadraticNum2Holder.isNotEmpty())
	     {
		
		quadraticNum2Holder = quadraticNum2Holder.dropLast(1)
		quadraticNum2Result.value = quadraticNum2Holder
	     }
	     else if (quadraticNum2Holder.isEmpty() && firstOperation.isNotEmpty())
	     {
		
		firstOperation = firstOperation.dropLast(1)
		firstOperationResult.value = firstOperation
	     }
	     else
	     {
		quadraticNum1Holder = quadraticNum1Holder.dropLast(1)
		quadraticNum1Result.value = quadraticNum1Holder
	     }
	}
	else
	{
	     if (resultHolder == " " || resultHolder == "Error")
	     {
		resultHolder = "0"
		processHolder = "0"
		result.value = resultHolder
		proccessResult.value = processHolder
	     }
	     else
	     {
		resultHolder = resultHolder.dropLast(1)
		processHolder = processHolder.dropLast(1)
		
		if (resultHolder.isEmpty() || resultHolder == "-")
		{
		     resultHolder = "0"
		}
		result.value = resultHolder
		proccessResult.value = processHolder
	     }
	     result.value = resultHolder
	     proccessResult.value = processHolder
	}
     }
     
     fun changeSymbol()
     {
	if (quadraticEqualationIsClicked)
	{
	     
	     if (secondOperation.isNotEmpty() && quadraticNum2Holder.isNotEmpty())
	     {
		if (secondOperation == "-")
		{
		     secondOperation = "+"
		}
		else
		{
		     secondOperation = "-"
		}
		secondOperationResult.value = secondOperation
	     }
	     else if (firstOperation.isNotEmpty() && quadraticNum1Holder.isNotEmpty())
	     {
		if (firstOperation == "-")
		{
		     firstOperation = "+"
		}
		else
		{
		     firstOperation = "-"
		}
		firstOperationResult.value = firstOperation
	     }
	     else
	     {
		
		if (quadraticNum1Holder.contains("-"))
		{
		     quadraticNum1Holder = quadraticNum1Holder.drop(1)
		}
		else
		{
		     quadraticNum1Holder = ("-$quadraticNum1Holder")
		}
		quadraticNum1Result.value = quadraticNum1Holder
	     }
	}
	else
	{
	     
	     try
	     {
		isClickedCount += 1
		resultHolderLenght = resultHolder.length
		
		if (isClickedCount == 1 && resultHolder.contains("-"))
		{
		     resultHolder = resultHolder.drop(1)
		     processHolder = processHolder.drop(1)
		     Log.e("tady",
			 "tady1")
		     isClickedCount = 0
		     
		}
		else if (isClickedCount == 1 && resultHolder.toInt()
		        .toString() == "0")
		{
		     
		     resultHolder = "0"
		     processHolder = ""
		     isClickedCount = 0
		     Log.e("tady",
			 "tady2")
		  
		}
		else if (isClickedCount == 1)
		{
		     
		     resultHolder = "-$resultHolder"
		     processHolder = "-$processHolder"
		     isClickedCount = 0
		     Log.e("tady",
			 "tady3")
		  
		}
		else
		{
		     
		     resultHolder = "-$resultHolder"
		     processHolder = processHolder.dropLast(resultHolderLenght)
		     processHolder += "($resultHolder)"
		     isClickedCount = 0
		}
		
		result.value = resultHolder
		proccessResult.value = processHolder
		
	     }
	     catch (e : Exception)
	     {
		
		Log.e("message",
		      e.message.toString())
	     }
	}
     }
     
     fun plus()
     {
	isClicked = false
	if (quadraticEqualationIsClicked)
	{
	     if (firstOperation.isEmpty())
	     {
		firstOperation = "+"
		firstOperationResult.value = firstOperation
	     }
	     else if (firstOperation.isNotEmpty() && secondOperation.isEmpty())
	     {
		secondOperation = "+"
		secondOperationResult.value = secondOperation
	     }
	}
	else
	{
	     isClickedCount += 1
	     symbolClicked = "+"
	     
	     try
	     {
		if (processHolder.isEmpty())
		{
		     
		     processHolder = ""
		     isClickedCount = 0
		     
		}
		else
		{
		     
		     if (isClickedCount == 2)
		     {
			
			val expression = ExpressionBuilder(processHolder).build()
			val processHolderResult = expression.evaluate()
			if (processHolderResult.toString()
			        .contains(".0"))
			{
			     
			     processHolder = processHolderResult.toInt()
			         .toString()
			     isClickedCount = 1
			}
			else
			{
			     processHolder = processHolderResult.toDouble()
			         .toString()
			     isClickedCount = 1
			}
		     }
		     
		     resultHolder = "0"
		     processHolder = processHolder.plus("+")
		}
		proccessResult.value = processHolder
		result.value = resultHolder
		
	     }
	     catch (e : Exception)
	     {
		
		processHolder = processHolder.dropLast(1)
		processHolder = processHolder.plus(symbolClicked)
		
		proccessResult.value = processHolder
		
	     }
	}
	
     }
     
     fun minus()
     {
	isClicked = false
	if (quadraticEqualationIsClicked)
	{
	     if (quadraticNum1Holder.isEmpty())
	     {
		quadraticNum1Holder = quadraticNum1Holder.plus("-")
		quadraticNum1Result.value = quadraticNum1Holder
	     }
	     else if (firstOperation.isEmpty())
	     {
		firstOperation = "-"
		firstOperationResult.value = firstOperation
	     }
	     else if (firstOperation.isNotEmpty() && secondOperation.isEmpty())
	     {
		secondOperation = "-"
		secondOperationResult.value = secondOperation
	     }
	}
	else
	{
	     isClickedCount += 1
	     symbolClicked = "-"
	     try
	     {
		if (processHolder.isEmpty())
		{
		     
		     processHolder = ""
		     isClickedCount = 0
		     
		}
		else
		{
		     
		     if (isClickedCount == 2)
		     {
			
			val expression = ExpressionBuilder(processHolder).build()
			val processHolderResult = expression.evaluate()
			if (processHolderResult.toString()
			        .contains(".0"))
			{
			     
			     processHolder = processHolderResult.toInt()
			         .toString()
			     isClickedCount = 1
			}
			else
			{
			     processHolder = processHolderResult.toDouble()
			         .toString()
			     isClickedCount = 1
			}
		     }
		     
		     resultHolder = "0"
		     processHolder = processHolder.plus("-")
		}
		proccessResult.value = processHolder
		result.value = resultHolder
	     }
	     catch (e : Exception)
	     {
		
		processHolder = processHolder.dropLast(1)
		processHolder = processHolder.plus(symbolClicked)
		
		proccessResult.value = processHolder
		
	     }
	}
	
     }
     
     fun multiply()
     {
	isClicked = false
	isClickedCount += 1
	symbolClicked = "*"
	
	try
	{
	     if (processHolder.isEmpty())
	     {
		
		processHolder = ""
		isClickedCount = 0
		
	     }
	     else
	     {
		
		if (isClickedCount == 2)
		{
		     
		     val expression = ExpressionBuilder(processHolder).build()
		     val processHolderResult = expression.evaluate()
		     if (processHolderResult.toString()
			   .contains(".0"))
		     {
			
			processHolder = processHolderResult.toInt()
			    .toString()
			isClickedCount = 1
		     }
		     else
		     {
			processHolder = processHolderResult.toDouble()
			    .toString()
			isClickedCount = 1
		     }
		}
		
		resultHolder = "0"
		processHolder = processHolder.plus("*")
	     }
	     proccessResult.value = processHolder
	     result.value = resultHolder
	}
	catch (e : Exception)
	{
	     
	     processHolder = processHolder.dropLast(1)
	     processHolder = processHolder.plus(symbolClicked)
	     
	     proccessResult.value = processHolder
	     
	}
     }
     
     fun divide()
     {
	isClicked = false
	isClickedCount += 1
	symbolClicked = "/"
	
	try
	{
	     if (processHolder.isEmpty())
	     {
		
		processHolder = ""
		isClickedCount = 0
		
	     }
	     else
	     {
		
		if (isClickedCount == 2)
		{
		     
		     val expression = ExpressionBuilder(processHolder).build()
		     val processHolderResult = expression.evaluate()
		     if (processHolderResult.toString()
			   .contains(".0"))
		     {
			
			processHolder = processHolderResult.toInt()
			    .toString()
			isClickedCount = 1
		     }
		     else
		     {
			processHolder = processHolderResult.toDouble()
			    .toString()
			isClickedCount = 1
		     }
		}
		
		resultHolder = "0"
		processHolder = processHolder.plus("/")
	     }
	     proccessResult.value = processHolder
	     result.value = resultHolder
	}
	catch (e : Exception)
	{
	     
	     processHolder = processHolder.dropLast(1)
	     processHolder = processHolder.plus(symbolClicked)
	     
	     proccessResult.value = processHolder
	     
	}
	
     }
     
     fun percent()
     {
	isClicked = true
	resultHolderLenght = resultHolder.length
	when
	{
	     resultHolder.isEmpty() || resultHolder == "Error" ->
	     {
		resultHolder = "Error"
	     }
	     resultHolder == "0" ->
	     {
		
	     }
	     else ->
	     {
		floatHolder = resultHolder.toFloat() / 100
		if (floatHolder.toString()
		        .contains(".00"))
		{
		     
		     longHolder = floatHolder.toLong()
		     resultHolder = longHolder.toString()
		     isClicked = false
		}
		else
		{
		     resultHolder = floatHolder.toString()
		     isClicked = false
		     // processHolder = processHolder.dropLast(1) + intHolder.toString()
		}
	     }
	}
	
	if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains("*") || processHolder.contains(
	         "/"
												         )
	)
	{
	     
	     processHolder = processHolder.dropLast(resultHolderLenght)
	     processHolder += resultHolder
	     proccessResult.value = processHolder
	     Log.e("lenght",
		 resultHolderLenght.toString())
	  
	}
	else
	{
	     processHolder = resultHolder
	     proccessResult.value = processHolder
	}
	result.value = resultHolder
	
     }
     
     fun power2()
     {
	
	isClicked = true
	resultHolderLenght = resultHolder.length
	
	if (resultHolder.isEmpty() || resultHolder == "Error")
	{
	     resultHolder = "Error"
	}
	else if (resultHolder == "0")
	{
	     result.value = resultHolder
	}
	else
	{
	     if (resultHolder.toString()
		   .contains("."))
	     {
		
		floatHolder = resultHolder.toFloat() * resultHolder.toFloat()
		resultHolder = floatHolder.toString()
		isClicked = false
	     }
	     else
	     {
		longHolder = resultHolder.toLong() * resultHolder.toLong()
		resultHolder = longHolder.toString()
		isClicked = false
		// processHolder = processHolder.dropLast(1) + intHolder.toString()
	     }
	}
	
	
	if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains("*") || processHolder.contains(
	         "/"
												         )
	)
	{
	     
	     processHolder = processHolder.dropLast(resultHolderLenght)
	     processHolder += resultHolder
	     proccessResult.value = processHolder
	     Log.e("lenght",
		 resultHolderLenght.toString())
	  
	}
	else
	{
	     processHolder = resultHolder
	     proccessResult.value = processHolder
	}
	
	result.value = resultHolder
	// proccessResult.value = processHolder
	
     }
     
     fun power3()
     {
	isClicked = true
	resultHolderLenght = resultHolder.length
	when
	{
	     resultHolder.isEmpty() || resultHolder == "Error" ->
	     {
		resultHolder = "Error"
	     }
	     resultHolder == "0" ->
	     {
	     }
	     else ->
	     {
		
		if (resultHolder.toString()
		        .contains("."))
		{
		     
		     floatHolder =
			resultHolder.toFloat() * resultHolder.toFloat() * resultHolder.toFloat()
		     resultHolder = floatHolder.toString()
		     isClicked = false
		}
		else
		{
		     longHolder =
			resultHolder.toLong() * resultHolder.toLong() * resultHolder.toLong()
		     resultHolder = longHolder.toString()
		     isClicked = false
		     // processHolder = processHolder.dropLast(1) + intHolder.toString()
		}
	     }
	}
	if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains("*") || processHolder.contains(
	         "/"
												         )
	)
	{
	     
	     processHolder = processHolder.dropLast(resultHolderLenght)
	     processHolder += resultHolder
	     proccessResult.value = processHolder
	     Log.e("lenght",
		 resultHolderLenght.toString())
	  
	}
	else
	{
	     processHolder = resultHolder
	     proccessResult.value = processHolder
	}
	
	result.value = resultHolder
	//proccessResult.value = processHolder
     }
     
     fun squareRoot()
     {
	isClicked = true
	resultHolderLenght = resultHolder.length
	when
	{
	     resultHolder.isEmpty() || resultHolder == "Error" ->
	     {
		resultHolder = "Error"
	     }
	     resultHolder == "0" ->
	     {
	     }
	     else ->
	     {
		isClicked = false
		floatHolder = kotlin.math.sqrt(resultHolder.toDouble())
		    .toFloat()
		
		if (floatHolder.toString()
		        .contains(".0"))
		{
		     
		     longHolder = floatHolder.toLong()
		     resultHolder = longHolder.toString()
		}
		else
		{
		     resultHolder = floatHolder.toString()
		     
		}
		
	     }
	}
	if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains("*") || processHolder.contains(
	         "/"
												         )
	)
	{
	     
	     processHolder = processHolder.dropLast(resultHolderLenght)
	     processHolder += resultHolder
	     proccessResult.value = processHolder
	     Log.e("lenght",
		 resultHolderLenght.toString())
	  
	}
	else
	{
	     processHolder = resultHolder
	     proccessResult.value = processHolder
	}
	
	result.value = resultHolder
	
     }
     
     fun memoryRecord()
     {
	memRecordIsClicked = true
	processHolder = ""
	proccessResult.value = processHolder
     }
     
     fun memoryClear()
     {
	memCLearIsClicked = true
     }
     
     fun mem1()
     {
	
	if (quadraticEqualationIsClicked)
	{
	     
	     if (quadraticNum1Holder.isEmpty())
	     {
		
		quadraticNum1Holder = mem1Holder.toString()
		quadraticNum1Result.value = quadraticNum1Holder
	     }
	     else if (firstOperation.isEmpty() && quadraticNum2Holder.isEmpty())
	     {
		if (mem1Holder.toString()
		        .contains("-"))
		{
		     
		     firstOperation = "-"
		     stringHolder = mem1Holder
		     stringHolder = stringHolder.drop(1)
		     quadraticNum2Holder = stringHolder.toString()
		     quadraticNum2Result.value = quadraticNum2Holder
		     firstOperationResult.value = firstOperation
		     
		}
		else
		{
		     firstOperation = "+"
		     quadraticNum2Holder = stringHolder.toString()
		     quadraticNum2Result.value = quadraticNum2Holder
		     firstOperationResult.value = firstOperation
		}
		
	     }
	     else
	     {
		
		if (mem1Holder.toString()
		        .contains("-"))
		{
		     secondOperation = "-"
		     stringHolder = mem1Holder
		     stringHolder = stringHolder.drop(1)
		     quadraticNum3Holder = stringHolder.toString()
		     quadraticNum3Result.value = quadraticNum3Holder
		     secondOperationResult.value = secondOperation
		     
		}
		else
		{
		     secondOperation = "+"
		     stringHolder = mem1Holder
		     quadraticNum3Holder = stringHolder.toString()
		     quadraticNum3Result.value = quadraticNum3Holder
		     secondOperationResult.value = secondOperation
		}
	     }
	     
	}
	else
	{
	     
	     memIsClickedCount += 1
	     
	     if (mem1Holder == "")
	     {
		
		resultHolder = "0"
	     }
	     
	     if (memCLearIsClicked)
	     {
		mem1Holder = ""
		memCLearIsClicked = false
	     }
	     
	     if (memRecordIsClicked)
	     {
		mem1Holder = ansHolder
		memRecordIsClicked = false
	     }
	     
	     if (memIsClickedCount == 2)
	     {
		
		if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
		         "*") || processHolder.contains(
		         "/")
		)
		{
		     processHolder += mem1Holder
		     proccessResult.value = processHolder
		     
		}
		else if (processHolder == "")
		{
		     
		     processHolder = mem1Holder
		}
		
		if (resultHolder == "0")
		{
		     
		     resultHolder = "0"
		     
		}
		result.value = resultHolder
		proccessResult.value = processHolder
		memIsClickedCount = 1
	     }
	     mem1Value.value = mem1Holder
	}
     }
     
     fun mem2()
     {
	
	if (quadraticEqualationIsClicked)
	{
	     
	     if (quadraticNum1Holder.isEmpty())
	     {
		
		quadraticNum1Holder = mem2Holder.toString()
		quadraticNum1Result.value = quadraticNum1Holder
	     }
	     else if (firstOperation.isEmpty() && quadraticNum2Holder.isEmpty())
	     {
		if (mem2Holder.toString()
		        .contains("-"))
		{
		     
		     firstOperation = "-"
		     stringHolder = mem2Holder
		     stringHolder = stringHolder.drop(1)
		     quadraticNum2Holder = stringHolder.toString()
		     quadraticNum2Result.value = quadraticNum2Holder
		     firstOperationResult.value = firstOperation
		     
		}
		else
		{
		     firstOperation = "+"
		     quadraticNum2Holder = stringHolder.toString()
		     quadraticNum2Result.value = quadraticNum2Holder
		     firstOperationResult.value = firstOperation
		}
		
	     }
	     else
	     {
		
		if (mem2Holder.toString()
		        .contains("-"))
		{
		     secondOperation = "-"
		     stringHolder = mem2Holder
		     stringHolder = stringHolder.drop(1)
		     quadraticNum3Holder = stringHolder.toString()
		     quadraticNum3Result.value = quadraticNum3Holder
		     secondOperationResult.value = secondOperation
		     
		}
		else
		{
		     secondOperation = "+"
		     stringHolder = mem2Holder
		     quadraticNum3Holder = stringHolder.toString()
		     quadraticNum3Result.value = quadraticNum3Holder
		     secondOperationResult.value = secondOperation
		}
	     }
	     
	}
	else
	{
	     
	     memIsClickedCount += 1
	     
	     if (mem2Holder == "")
	     {
		
		resultHolder = "0"
	     }
	     
	     if (memCLearIsClicked)
	     {
		mem2Holder = ""
		memCLearIsClicked = false
	     }
	     
	     if (memRecordIsClicked)
	     {
		mem2Holder = ansHolder
		Log.e("message",
		      mem2Holder.toString())
		Log.e("message",
		      memRecordIsClicked.toString())
		memRecordIsClicked = false
	     }
	     
	     if (memIsClickedCount == 2)
	     {
		
		if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
		         "*") || processHolder.contains(
		         "/")
		)
		{
		     processHolder += mem2Holder
		     proccessResult.value = processHolder
		     
		}
		else if (processHolder == "")
		{
		     
		     processHolder = mem2Holder
		}
		
		if (resultHolder == "0")
		{
		     
		     resultHolder = "0"
		     
		}
		result.value = resultHolder
		proccessResult.value = processHolder
		memIsClickedCount = 1
	     }
	     mem2Value.value = mem2Holder
	}
     }
     
     fun mem3()
     {
	
	if (quadraticEqualationIsClicked)
	{
	     
	     if (quadraticNum1Holder.isEmpty())
	     {
		
		quadraticNum1Holder = mem3Holder.toString()
		quadraticNum1Result.value = quadraticNum1Holder
	     }
	     else if (firstOperation.isEmpty() && quadraticNum2Holder.isEmpty())
	     {
		if (mem3Holder.toString()
		        .contains("-"))
		{
		     
		     firstOperation = "-"
		     stringHolder = mem3Holder
		     stringHolder = stringHolder.drop(1)
		     quadraticNum2Holder = stringHolder.toString()
		     quadraticNum2Result.value = quadraticNum2Holder
		     firstOperationResult.value = firstOperation
		     
		}
		else
		{
		     firstOperation = "+"
		     quadraticNum2Holder = stringHolder.toString()
		     quadraticNum2Result.value = quadraticNum2Holder
		     firstOperationResult.value = firstOperation
		}
		
	     }
	     else
	     {
		
		if (mem3Holder.toString()
		        .contains("-"))
		{
		     secondOperation = "-"
		     stringHolder = mem3Holder
		     stringHolder = stringHolder.drop(1)
		     quadraticNum3Holder = stringHolder.toString()
		     quadraticNum3Result.value = quadraticNum3Holder
		     secondOperationResult.value = secondOperation
		     
		}
		else
		{
		     secondOperation = "+"
		     stringHolder = mem3Holder
		     quadraticNum3Holder = stringHolder.toString()
		     quadraticNum3Result.value = quadraticNum3Holder
		     secondOperationResult.value = secondOperation
		}
	     }
	     
	}
	else
	{
	     
	     memIsClickedCount += 1
	     
	     if (mem3Holder == "")
	     {
		
		resultHolder = "0"
	     }
	     
	     if (memCLearIsClicked)
	     {
		mem3Holder = ""
		memCLearIsClicked = false
	     }
	     
	     if (memRecordIsClicked)
	     {
		mem3Holder = ansHolder
		Log.e("message",
		      mem3Holder.toString())
		Log.e("message",
		      memRecordIsClicked.toString())
		memRecordIsClicked = false
	     }
	     
	     if (memIsClickedCount == 2)
	     {
		
		if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
		         "*") || processHolder.contains(
		         "/")
		)
		{
		     processHolder += mem3Holder
		     proccessResult.value = processHolder
		     
		}
		else if (processHolder == "")
		{
		     
		     processHolder = mem3Holder
		}
		
		if (resultHolder == "0")
		{
		     
		     resultHolder = "0"
		     
		}
		result.value = resultHolder
		proccessResult.value = processHolder
		memIsClickedCount = 1
	     }
	     mem3Value.value = mem3Holder
	}
     }
     
     fun mem4()
     {
	
	if (quadraticEqualationIsClicked)
	{
	     
	     if (quadraticNum1Holder.isEmpty())
	     {
		
		quadraticNum1Holder = mem4Holder.toString()
		quadraticNum1Result.value = quadraticNum1Holder
	     }
	     else if (firstOperation.isEmpty() && quadraticNum2Holder.isEmpty())
	     {
		if (mem4Holder.toString()
		        .contains("-"))
		{
		     
		     firstOperation = "-"
		     stringHolder = mem4Holder
		     stringHolder = stringHolder.drop(1)
		     quadraticNum2Holder = stringHolder.toString()
		     quadraticNum2Result.value = quadraticNum2Holder
		     firstOperationResult.value = firstOperation
		     
		}
		else
		{
		     firstOperation = "+"
		     quadraticNum2Holder = stringHolder.toString()
		     quadraticNum2Result.value = quadraticNum2Holder
		     firstOperationResult.value = firstOperation
		}
		
	     }
	     else
	     {
		
		if (mem4Holder.toString()
		        .contains("-"))
		{
		     secondOperation = "-"
		     stringHolder = mem4Holder
		     stringHolder = stringHolder.drop(1)
		     quadraticNum3Holder = stringHolder.toString()
		     quadraticNum3Result.value = quadraticNum3Holder
		     secondOperationResult.value = secondOperation
		     
		}
		else
		{
		     secondOperation = "+"
		     stringHolder = mem4Holder
		     quadraticNum3Holder = stringHolder.toString()
		     quadraticNum3Result.value = quadraticNum3Holder
		     secondOperationResult.value = secondOperation
		}
	     }
	     
	}
	else
	{
	     
	     memIsClickedCount += 1
	     
	     if (mem4Holder == "")
	     {
		
		resultHolder = "0"
	     }
	     
	     if (memCLearIsClicked)
	     {
		mem4Holder = ""
		memCLearIsClicked = false
	     }
	     
	     if (memRecordIsClicked)
	     {
		mem4Holder = ansHolder
		Log.e("message",
		      mem4Holder.toString())
		Log.e("message",
		      memRecordIsClicked.toString())
		memRecordIsClicked = false
	     }
	     
	     if (memIsClickedCount == 2)
	     {
		
		if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
		         "*") || processHolder.contains(
		         "/")
		)
		{
		     processHolder += mem4Holder
		     proccessResult.value = processHolder
		     
		}
		else if (processHolder == "")
		{
		     
		     processHolder = mem4Holder
		}
		
		if (resultHolder == "0")
		{
		     
		     resultHolder = "0"
		     
		}
		result.value = resultHolder
		proccessResult.value = processHolder
		memIsClickedCount = 1
	     }
	     mem4Value.value = mem4Holder
	}
     }
     
     fun mem5()
     {
	
	if (quadraticEqualationIsClicked)
	{
	     
	     if (quadraticNum1Holder.isEmpty())
	     {
		
		quadraticNum1Holder = mem5Holder.toString()
		quadraticNum1Result.value = quadraticNum1Holder
	     }
	     else if (firstOperation.isEmpty() && quadraticNum2Holder.isEmpty())
	     {
		if (mem5Holder.toString()
		        .contains("-"))
		{
		     
		     firstOperation = "-"
		     stringHolder = mem5Holder
		     stringHolder = stringHolder.drop(1)
		     quadraticNum2Holder = stringHolder.toString()
		     quadraticNum2Result.value = quadraticNum2Holder
		     firstOperationResult.value = firstOperation
		     
		}
		else
		{
		     firstOperation = "+"
		     quadraticNum2Holder = stringHolder.toString()
		     quadraticNum2Result.value = quadraticNum2Holder
		     firstOperationResult.value = firstOperation
		}
		
	     }
	     else
	     {
		
		if (mem5Holder.toString()
		        .contains("-"))
		{
		     secondOperation = "-"
		     stringHolder = mem5Holder
		     stringHolder = stringHolder.drop(1)
		     quadraticNum3Holder = stringHolder.toString()
		     quadraticNum3Result.value = quadraticNum3Holder
		     secondOperationResult.value = secondOperation
		     
		}
		else
		{
		     secondOperation = "+"
		     stringHolder = mem5Holder
		     quadraticNum3Holder = stringHolder.toString()
		     quadraticNum3Result.value = quadraticNum3Holder
		     secondOperationResult.value = secondOperation
		}
	     }
	     
	}
	else
	{
	     
	     memIsClickedCount += 1
	     
	     if (mem5Holder == "")
	     {
		
		resultHolder = "0"
	     }
	     
	     if (memCLearIsClicked)
	     {
		mem5Holder = ""
		memCLearIsClicked = false
	     }
	     
	     if (memRecordIsClicked)
	     {
		mem5Holder = ansHolder
		Log.e("message",
		      mem5Holder.toString())
		Log.e("message",
		      memRecordIsClicked.toString())
		memRecordIsClicked = false
	     }
	     
	     if (memIsClickedCount == 2)
	     {
		
		if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
		         "*") || processHolder.contains(
		         "/")
		)
		{
		     processHolder += mem5Holder
		     proccessResult.value = processHolder
		     
		}
		else if (processHolder == "")
		{
		     
		     processHolder = mem5Holder
		}
		
		if (resultHolder == "0")
		{
		     
		     resultHolder = "0"
		     
		}
		result.value = resultHolder
		proccessResult.value = processHolder
		memIsClickedCount = 1
	     }
	     mem5Value.value = mem5Holder
	}
     }
     
     fun equal()
     {
	
	if (quadraticEqualationIsClicked)
	{
	     
	     a = quadraticNum1Holder.toDouble()
	     
	     if (firstOperation == "-")
	     {
		
		b = ("-$quadraticNum2Holder").toDouble()
	     }
	     else if (firstOperation == "+")
	     {
		
		b = ("$quadraticNum2Holder").toDouble()
	     }
	     
	     if (secondOperation == "-")
	     {
		
		c = ("-$quadraticNum3Holder").toDouble()
	     }
	     else if (secondOperation == "+")
	     {
		
		c = ("$quadraticNum3Holder").toDouble()
	     }
	     
	     val determinantHolder : Double = b * b - 4.0 * a * c
	     
	     if (determinantHolder > 0.0)
	     {
		x1RootHolder = (- b + sqrt(determinantHolder)) / (2 * a)
		x2RootHolder = (- b - sqrt(determinantHolder)) / (2 * a)
		
		if (x2RootHolder.toString()
		        .contains(".0"))
		{
		     
		     x2RootResult.value = x2RootHolder.toInt()
		         .toString()
		     
		}
		else
		{
		     x2RootResult.value = x2RootHolder.toString()
		     x1RootResult.value = x1RootHolder.toString()
		}
		
		if (x1RootHolder.toString()
		        .contains(".0"))
		{
		     
		     x1RootResult.value = x1RootHolder.toInt()
		         .toString()
		     
		}
		else
		{
		     x1RootResult.value = x1RootHolder.toString()
		     x2RootResult.value = x2RootHolder.toString()
		}
		
		if (determinantHolder.toString()
		        .contains(".0"))
		{
		     
		     determinantResult.value = determinantHolder
		         .toInt()
		         .toString()
		}
		else
		{
		     
		     determinantResult.value = determinantHolder.toString()
		}
		
	     }
	     // Condition for real and equal roots
	     else if (determinantHolder == 0.0)
	     {
		
		x2RootHolder = ((- b / (2 * a)).toDouble())
		x1RootHolder = x2RootHolder
		
		if (x2RootHolder.toString()
		        .contains(".0"))
		{
		     
		     x2RootResult.value = x2RootHolder.toInt()
		         .toString()
		     
		}
		else
		{
		     x2RootResult.value = x2RootHolder.toString()
		     x1RootResult.value = x1RootHolder.toString()
		}
		
		if (x1RootHolder.toString()
		        .contains(".0"))
		{
		     
		     x1RootResult.value = x1RootHolder.toInt()
		         .toString()
		     
		}
		else
		{
		     x1RootResult.value = x1RootHolder.toString()
		     x2RootResult.value = x2RootHolder.toString()
		}
		
		if (determinantHolder.toString()
		        .contains(".0"))
		{
		     
		     determinantResult.value = determinantHolder
		         .toInt()
		         .toString()
		}
		else
		{
		     
		     determinantResult.value = determinantHolder.toString()
		}
		
	     }
	     else
	     {
		
		x1RootHolder = (- b + sqrt(determinantHolder)) / (2 * a)
		x2RootHolder = (- b - sqrt(determinantHolder)) / (2 * a)
		
		if (x1RootHolder.toString() == "NaN")
		{
		     
		     x1RootResult.value = "No real solutions"
		     
		}
		else
		{
		     
		     x2RootResult.value = x2RootHolder.toString()
		     
		}
		
		if (x2RootHolder.toString() == "NaN")
		{
		     x2RootResult.value = "No real solutions"
		}
		else
		{
		     x1RootResult.value = x1RootHolder.toString()
		     
		}
		
		if (determinantHolder.toString()
		        .contains(".0"))
		{
		     
		     determinantResult.value = determinantHolder
		         .toInt()
		         .toString()
		}
		else
		{
		     
		     determinantResult.value = determinantHolder.toString()
		}
	     }
	     
	}
	else
	{
	     try
	     {
		if (processHolder.isEmpty())
		{
		     
		     processHolder = "0"
		     resultHolder = processHolder
		     
		     lastResult.value = resultHolder
		     result.value = "0"
		     proccessResult.value = resultHolder
		     ansHolder = resultHolder
		}
		
		val expression = ExpressionBuilder(processHolder).build()
		val processHolderResult : Double = expression.evaluate()
		
		if (processHolderResult.toString()
		        .contains(".0"))
		{
		     
		     processHolder = processHolderResult.toInt()
		         .toString()
		     resultHolder = processHolderResult.toInt()
		         .toString()
		     
		     lastResult.value = resultHolder
		     result.value = "0"
		     proccessResult.value = resultHolder
		     ansHolder = resultHolder
		     
		}
		else
		{
		     
		     processHolder = processHolderResult.toDouble()
		         .toString()
		     resultHolder = processHolderResult.toDouble()
		         .toString()
		     
		     lastResult.value = resultHolder
		     result.value = "0"
		     proccessResult.value = resultHolder
		     ansHolder = resultHolder
		}
	     }
	     catch (e : Exception)
	     {
		
		processHolder = processHolder.dropLast(1)
		resultHolder = processHolder
		
		lastResult.value = processHolder
		result.value = "0"
		proccessResult.value = processHolder
		ansHolder = processHolder
		
	     }
	}
     }
     
     fun quadraticEqualation()
     {
	click += 1
	
	if (click == 1)
	{
	     quadraticEqualationIsClicked = true
	}
	else if (click == 2)
	{
	     quadraticEqualationIsClicked = false
	     click = 0
	}
	
     }
     
     fun ansShow()
     {
	if (quadraticEqualationIsClicked)
	{
	     
	     if (quadraticNum1Holder.isEmpty())
	     {
		
		quadraticNum1Holder = ansHolder.toString()
		quadraticNum1Result.value = quadraticNum1Holder
	     }
	     else if (firstOperation.isEmpty() && quadraticNum2Holder.isEmpty())
	     {
		if (ansHolder.toString()
		        .contains("-"))
		{
		     
		     firstOperation = "-"
		     stringHolder = ansHolder
		     stringHolder = stringHolder.drop(1)
		     quadraticNum2Holder = stringHolder.toString()
		     quadraticNum2Result.value = quadraticNum2Holder
		     firstOperationResult.value = firstOperation
		     
		}
		else
		{
		     firstOperation = "+"
		     stringHolder = ansHolder
		     quadraticNum2Holder = stringHolder.toString()
		     quadraticNum2Result.value = quadraticNum2Holder
		     firstOperationResult.value = firstOperation
		}
		
	     }
	     else
	     {
		
		if (ansHolder.toString()
		        .contains("-"))
		{
		     secondOperation = "-"
		     stringHolder = ansHolder
		     stringHolder = stringHolder.drop(1)
		     quadraticNum3Holder = stringHolder.toString()
		     quadraticNum3Result.value = quadraticNum3Holder
		     secondOperationResult.value = secondOperation
		     
		}
		else
		{
		     secondOperation = "+"
		     stringHolder = ansHolder
		     quadraticNum3Holder = stringHolder.toString()
		     quadraticNum3Result.value = quadraticNum3Holder
		     secondOperationResult.value = secondOperation
		}
	     }
	     
	}
	else
	{
	     if (ansHolder == "")
	     {
		
	     }
	     
	     if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
		    "*") || processHolder.contains(
		    "/")
	     )
	     {
		processHolder += ansHolder
		proccessResult.value = processHolder
		
	     }
	     else if (processHolder == "")
	     {
		
		processHolder = ansHolder
	     }
	     
	     if (resultHolder == "0")
	     {
		
		resultHolder = ansHolder
		
	     }
	     result.value = resultHolder
	     proccessResult.value = processHolder
	}
     }
     
     fun equalSend() : LiveData<String>
     {
	
	lastResult.value = resultHolder
	return lastResult
     }
     
     fun getResult() : LiveData<String>
     {
	return result
     }
     
     fun getM1() : LiveData<String>
     {
	return mem1Value
     }
     
     fun getM2() : LiveData<String>
     {
	return mem2Value
     }
     
     fun getM3() : LiveData<String>
     {
	return mem3Value
     }
     
     fun getM4() : LiveData<String>
     {
	return mem4Value
     }
     
     fun getM5() : LiveData<String>
     {
	return mem5Value
     }
     
     fun getProcessResult() : LiveData<String>
     {
	return proccessResult
     }
     
     fun quadraticResult1() : LiveData<String>
     {
	return quadraticNum1Result
     }
     
     fun quadraticResult2() : LiveData<String>
     {
	return quadraticNum2Result
     }
     
     fun quadraticResult3() : LiveData<String>
     {
	return quadraticNum3Result
     }
     
     fun firstOperation() : LiveData<String>
     {
	return firstOperationResult
     }
     
     fun secondOperation() : LiveData<String>
     {
	return secondOperationResult
     }
     
     fun getX1Root() : LiveData<String>
     {
	return x1RootResult
     }
     
     fun getX2Root() : LiveData<String>
     {
	return x2RootResult
     }
     
     fun getDeterminant() : LiveData<String>
     {
	return determinantResult
     }
}