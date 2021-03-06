package com.example.programovatelna_kalkulacka.presentation.mainScreen_viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.objecthunter.exp4j.ExpressionBuilder

class MainViewModel : ViewModel() {
     
     private var arraySize : Int = 0
     private var count : Int = -1
     
     private var floatHolder : Float = 0f
     private var longHolder : Long = 0
     private var resultHolder : String = "0"
     private var processHolder : String = ""
     private var resultHolderLenght : Int = 0
     private var ansHolder : String = ""
     private var stringHolder : String = ""
     private var symbolClicked : String = ""
     
     private var falsiMethodIsClickedCount : Int = 0
     private var falsiMethodIsClicked : Boolean = false
     private var falsiNum1Holder : String? = "0"
     private var falsiNum2Holder : String? = "0"
     private var falsiNum3Holder : String? = "0"
     private var falsiNum4Holder : String? = "0"
     private var firstOperation : String? = null
     private var secondOperation : String? = null
     private var thirdOperation : String? = null
     private var x1RootHolder : Double = 0.0
     private var x2RootHolder : Double = 0.0
     private var lowVal : String = ""
     private var highVal : String = ""
     private var precision : String = ""
     
     private var click : Int = 0
     private var x1 : String? = null
     private var x2 : String? = null
     private var x3 : String? = null
     
     private var mem1Holder : String = ""
     private var mem2Holder : String = ""
     private var mem3Holder : String = ""
     private var mem4Holder : String = ""
     private var mem5Holder : String = ""
     private var mem6Holder : String = ""
     private var mem7Holder : String = ""
     private var mem8Holder : String = ""
     private var mem9Holder : String = ""
     private var mem10Holder : String = ""
     private var mem11Holder : String = ""
     private var mem12Holder : String = ""
     private var mem13Holder : String = ""
     private var mem14Holder : String = ""
     private var mem15Holder : String = ""
     
     private var mem1FalsiHolder : MutableList<String> = ArrayList()
     private var mem2FalsiHolder : MutableList<String> = ArrayList()
     private var mem3FalsiHolder : MutableList<String> = ArrayList()
     private var mem4FalsiHolder : MutableList<String> = ArrayList()
     private var mem5FalsiHolder : MutableList<String> = ArrayList()
     private var mem6FalsiHolder : MutableList<String> = ArrayList()
     private var mem7FalsiHolder : MutableList<String> = ArrayList()
     private var mem8FalsiHolder : MutableList<String> = ArrayList()
     private var mem9FalsiHolder : MutableList<String> = ArrayList()
     private var mem10FalsiHolder : MutableList<String> = ArrayList()
     private var mem11FalsiHolder : MutableList<String> = ArrayList()
     private var mem12FalsiHolder : MutableList<String> = ArrayList()
     private var mem13FalsiHolder : MutableList<String> = ArrayList()
     private var mem14FalsiHolder : MutableList<String> = ArrayList()
     private var mem15FalsiHolder : MutableList<String> = ArrayList()
     
     private var macroRecordIsClicked : Boolean = false
     private var macroClearIsClicked : Boolean = false
     private var macroRecallIsClicked : Boolean = false
     private var macroClearSet : String = " "
     private var macroContains : String = ""
     private var macroSet : String = "0"
     private var macroChoosed : String = "0"
     private var array1Holder : MutableList<String> = ArrayList()
     private var array2Holder : MutableList<String> = ArrayList()
     private var array3Holder : MutableList<String> = ArrayList()
     private var array4Holder : MutableList<String> = ArrayList()
     private var array5Holder : MutableList<String> = ArrayList()
     private var array6Holder : MutableList<String> = ArrayList()
     private var array7Holder : MutableList<String> = ArrayList()
     private var array8Holder : MutableList<String> = ArrayList()
     private var array9Holder : MutableList<String> = ArrayList()
     private var numberArrayHolder : MutableList<String> = ArrayList()
     
     private var isClicked : Boolean = false
     private var memRecordIsClicked : Boolean = false
     private var memCLearIsClicked : Boolean = false
     
     private var isClickedCount : Int = 0
     private var memIsClickedCount : Int = 0
     private var symbolIsClickedCount : Int = 0
     
     private var macroResult : Int = 0
     
     private var highValResult = MutableLiveData<String>()
     private var lowValResult = MutableLiveData<String>()
     private var precissionResult = MutableLiveData<String>()
     private var quadraticNum1Result = MutableLiveData<String>()
     private var quadraticNum2Result = MutableLiveData<String>()
     private var quadraticNum3Result = MutableLiveData<String>()
     private var quadraticNum4Result = MutableLiveData<String>()
     private var determinantResult = MutableLiveData<String>()
     private var firstOperationResult = MutableLiveData<String>()
     private var secondOperationResult = MutableLiveData<String>()
     private var thirdOperationResult = MutableLiveData<String>()
     private var x1RootResult = MutableLiveData<String>()
     private var x2RootResult = MutableLiveData<String>()
     private var x1Result = MutableLiveData<String>()
     private var x2Result = MutableLiveData<String>()
     private var x3Result = MutableLiveData<String>()
     
     private val lastResult = MutableLiveData<String>()
     private val proccessResult = MutableLiveData<String>()
     private val result = MutableLiveData<String>()
     private val message = MutableLiveData<String>()
     
     
     private val macroContainsResult = MutableLiveData<String>()
     private val mem1Value = MutableLiveData<String>()
     private val mem2Value = MutableLiveData<String>()
     private val mem3Value = MutableLiveData<String>()
     private val mem4Value = MutableLiveData<String>()
     private val mem5Value = MutableLiveData<String>()
     private val mem6Value = MutableLiveData<String>()
     private val mem7Value = MutableLiveData<String>()
     private val mem8Value = MutableLiveData<String>()
     private val mem9Value = MutableLiveData<String>()
     private val mem10Value = MutableLiveData<String>()
     private val mem11Value = MutableLiveData<String>()
     private val mem12Value = MutableLiveData<String>()
     private val mem13Value = MutableLiveData<String>()
     private val mem14Value = MutableLiveData<String>()
     private val mem15Value = MutableLiveData<String>()
     
     //---------------------------------------------------\\
     
     init {
          lastResult.value = "0"
     }
     
     fun addNumber1() {
          try {
               if (macroRecallIsClicked) {
                    arraySize = array1Holder.size
                    resultHolder.plus(1)
                    macroChoosed = "1"
                    macroRecallIsClicked = false
                    
                    var result = array1Holder.toString()
                    result = result.toString()
                    result = result.drop(1)
                    result = result.dropLast(1)
                    result = result.replace(
                         ",", ""
                    )
                    if (mem1Holder.isNotEmpty()) {
                         result = result.replace(
                              "M1", mem1Holder.toString()
                         )
                    }
                    if (mem2Holder.isNotEmpty()) {
                         result = result.replace(
                              "M2", mem2Holder.toString()
                         )
                    }
                    if (mem3Holder.isNotEmpty()) {
                         result = result.replace(
                              "M3", mem3Holder.toString()
                         )
                    }
                    if (mem4Holder.isNotEmpty()) {
                         result = result.replace(
                              "M4", mem4Holder.toString()
                         )
                    }
                    if (mem5Holder.isNotEmpty()) {
                         result = result.replace(
                              "M5", mem5Holder.toString()
                         )
                    }
                    if (mem6Holder.isNotEmpty()) {
                         result = result.replace(
                              "M6", mem6Holder.toString()
                         )
                    }
                    if (mem7Holder.isNotEmpty()) {
                         result = result.replace(
                              "M7", mem7Holder.toString()
                         )
                    }
                    if (mem8Holder.isNotEmpty()) {
                         result = result.replace(
                              "M8", mem8Holder.toString()
                         )
                    }
                    if (mem9Holder.isNotEmpty()) {
                         result = result.replace(
                              "M9", mem9Holder.toString()
                         )
                    }
                    if (mem10Holder.isNotEmpty()) {
                         result = result.replace(
                              "M10", mem10Holder.toString()
                         )
                    }
                    if (mem11Holder.isNotEmpty()) {
                         result = result.replace(
                              "M11", mem11Holder.toString()
                         )
                    }
                    if (mem12Holder.isNotEmpty()) {
                         result = result.replace(
                              "M12", mem12Holder.toString()
                         )
                    }
                    if (mem13Holder.isNotEmpty()) {
                         result = result.replace(
                              "M13", mem13Holder.toString()
                         )
                    }
                    if (mem14Holder.isNotEmpty()) {
                         result = result.replace(
                              "M14", mem14Holder.toString()
                         )
                    }
                    if (mem15Holder.isNotEmpty()) {
                         result = result.replace(
                              "M15", mem15Holder.toString()
                         )
                    }
                    
                    macroContains = result
                    macroContainsResult.value = macroContains
                    
               }
               else if (macroRecordIsClicked) {
                    
                    macroSet = "1"
                    Log.e("mes", macroSet.toString())
                    
               }
               else if (macroClearIsClicked) {
                    
                    array1Holder.clear()
                    Log.e("something", array1Holder.toString())
                    macroClearIsClicked = false
                    
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "1") {
                    lowVal = lowVal.plus("1")
                    lowValResult.value = lowVal
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "2") {
                    highVal = highVal.plus("1")
                    highValResult.value = highVal
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "3") {
                    precision = precision.plus("1")
                    precissionResult.value = precision
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "0") {
                    if (firstOperation!!.isEmpty()) {
                         falsiNum1Holder = falsiNum1Holder.plus("1")
                         quadraticNum1Result.value = falsiNum1Holder
                         
                    }
                    else if (firstOperation!!.isNotEmpty() && secondOperation!!.isEmpty()) {
                         falsiNum2Holder = falsiNum2Holder.plus("1")
                         quadraticNum2Result.value = falsiNum2Holder
                         
                    }
                    else if (secondOperation!!.isNotEmpty() && thirdOperation!!.isEmpty()) {
                         
                         falsiNum3Holder = falsiNum3Holder.plus("1")
                         quadraticNum3Result.value = falsiNum3Holder
                         
                    }
                    else {
                         falsiNum4Holder = falsiNum4Holder.plus("1")
                         quadraticNum4Result.value = falsiNum4Holder
                    }
               }
               else {
                    
                    if (resultHolder == "0" || resultHolder == "Error") {
                         resultHolder = ""
                         if (processHolder == "0" || processHolder.isEmpty()) {
                              
                              processHolder = processHolder.drop(1)
                              processHolder = processHolder.plus("1")
                         }
                         else {
                              
                              processHolder = processHolder.plus("1")
                         }
                         resultHolder = resultHolder.plus("1")
                    }
                    else if (resultHolder == "-0") {
                         resultHolder = ""
                         processHolder = processHolder.plus("-1")
                         resultHolder = resultHolder.plus("-1")
                    }
                    else if (isClicked) {
                         processHolder = ""
                         resultHolder = ""
                         processHolder = processHolder.plus("1")
                         resultHolder = resultHolder.plus("1")
                         isClicked = false
                         
                    }
                    else {
                         processHolder = processHolder.plus("1")
                         resultHolder = resultHolder.plus("1")
                    }
                    result.value = resultHolder
                    proccessResult.value = processHolder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
               Log.e("erro is ", e.message.toString())
          }
     }
     
     fun addNumber2() {
          try {
               if (macroRecallIsClicked) {
                    arraySize = array2Holder.size
                    resultHolder.plus(1)
                    macroChoosed = "2"
                    macroRecallIsClicked = false
                    
                    var result = array2Holder.toString()
                    result = result.toString()
                    result = result.drop(1)
                    result = result.dropLast(1)
                    result = result.replace(
                         ",", ""
                    )
                    if (mem1Holder.isNotEmpty()) {
                         result = result.replace(
                              "M1", mem1Holder.toString()
                         )
                    }
                    if (mem2Holder.isNotEmpty()) {
                         result = result.replace(
                              "M2", mem2Holder.toString()
                         )
                    }
                    if (mem3Holder.isNotEmpty()) {
                         result = result.replace(
                              "M3", mem3Holder.toString()
                         )
                    }
                    if (mem4Holder.isNotEmpty()) {
                         result = result.replace(
                              "M4", mem4Holder.toString()
                         )
                    }
                    if (mem5Holder.isNotEmpty()) {
                         result = result.replace(
                              "M5", mem5Holder.toString()
                         )
                    }
                    if (mem6Holder.isNotEmpty()) {
                         result = result.replace(
                              "M6", mem6Holder.toString()
                         )
                    }
                    if (mem7Holder.isNotEmpty()) {
                         result = result.replace(
                              "M7", mem7Holder.toString()
                         )
                    }
                    if (mem8Holder.isNotEmpty()) {
                         result = result.replace(
                              "M8", mem8Holder.toString()
                         )
                    }
                    if (mem9Holder.isNotEmpty()) {
                         result = result.replace(
                              "M9", mem9Holder.toString()
                         )
                    }
                    if (mem10Holder.isNotEmpty()) {
                         result = result.replace(
                              "M10", mem10Holder.toString()
                         )
                    }
                    if (mem11Holder.isNotEmpty()) {
                         result = result.replace(
                              "M11", mem11Holder.toString()
                         )
                    }
                    if (mem12Holder.isNotEmpty()) {
                         result = result.replace(
                              "M12", mem12Holder.toString()
                         )
                    }
                    if (mem13Holder.isNotEmpty()) {
                         result = result.replace(
                              "M13", mem13Holder.toString()
                         )
                    }
                    if (mem14Holder.isNotEmpty()) {
                         result = result.replace(
                              "M14", mem14Holder.toString()
                         )
                    }
                    if (mem15Holder.isNotEmpty()) {
                         result = result.replace(
                              "M15", mem15Holder.toString()
                         )
                    }
                    
                    macroContains = result
                    macroContainsResult.value = macroContains
                    
               }
               else if (macroRecordIsClicked) {
                    
                    macroSet = "2"
                    
               }
               else if (macroClearIsClicked) {
                    
                    array2Holder.clear()
                    macroClearIsClicked = false
                    
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "1") {
                    lowVal = lowVal.plus("2")
                    lowValResult.value = lowVal
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "2") {
                    highVal = highVal.plus("2")
                    highValResult.value = highVal
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "3") {
                    precision = precision.plus("2")
                    precissionResult.value = precision
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "0") {
                    if (firstOperation!!.isEmpty()) {
                         falsiNum1Holder = falsiNum1Holder.plus("2")
                         quadraticNum1Result.value = falsiNum1Holder
                         
                    }
                    else if (firstOperation!!.isNotEmpty() && secondOperation!!.isEmpty()) {
                         falsiNum2Holder = falsiNum2Holder.plus("2")
                         quadraticNum2Result.value = falsiNum2Holder
                         
                    }
                    else if (secondOperation!!.isNotEmpty() && thirdOperation!!.isEmpty()) {
                         
                         falsiNum3Holder = falsiNum3Holder.plus("2")
                         quadraticNum3Result.value = falsiNum3Holder
                         
                    }
                    else {
                         falsiNum4Holder = falsiNum4Holder.plus("2")
                         quadraticNum4Result.value = falsiNum4Holder
                    }
               }
               else {
                    
                    if (resultHolder == "0" || resultHolder == "Error") {
                         resultHolder = ""
                         if (processHolder == "0" || processHolder.isEmpty()) {
                              
                              processHolder = processHolder.drop(1)
                              processHolder = processHolder.plus("2")
                         }
                         else {
                              
                              processHolder = processHolder.plus("2")
                         }
                         resultHolder = resultHolder.plus("2")
                    }
                    else if (resultHolder == "-0") {
                         resultHolder = ""
                         processHolder = processHolder.plus("-2")
                         resultHolder = resultHolder.plus("-2")
                    }
                    else if (isClicked) {
                         processHolder = ""
                         resultHolder = ""
                         processHolder = processHolder.plus("2")
                         resultHolder = resultHolder.plus("2")
                         isClicked = false
                         
                    }
                    else {
                         
                         processHolder = processHolder.plus("2")
                         resultHolder = resultHolder.plus("2")
                    }
                    result.value = resultHolder
                    proccessResult.value = processHolder
                    
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun addNumber3() {
          try {
               if (macroRecallIsClicked) {
                    arraySize = array3Holder.size
                    resultHolder.plus(1)
                    macroChoosed = "3"
                    macroRecallIsClicked = false
                    
                    var result = array3Holder.toString()
                    result = result.toString()
                    result = result.drop(1)
                    result = result.dropLast(1)
                    result = result.replace(
                         ",", ""
                    )
                    if (mem1Holder.isNotEmpty()) {
                         result = result.replace(
                              "M1", mem1Holder.toString()
                         )
                    }
                    if (mem2Holder.isNotEmpty()) {
                         result = result.replace(
                              "M2", mem2Holder.toString()
                         )
                    }
                    if (mem3Holder.isNotEmpty()) {
                         result = result.replace(
                              "M3", mem3Holder.toString()
                         )
                    }
                    if (mem4Holder.isNotEmpty()) {
                         result = result.replace(
                              "M4", mem4Holder.toString()
                         )
                    }
                    if (mem5Holder.isNotEmpty()) {
                         result = result.replace(
                              "M5", mem5Holder.toString()
                         )
                    }
                    if (mem6Holder.isNotEmpty()) {
                         result = result.replace(
                              "M6", mem6Holder.toString()
                         )
                    }
                    if (mem7Holder.isNotEmpty()) {
                         result = result.replace(
                              "M7", mem7Holder.toString()
                         )
                    }
                    if (mem8Holder.isNotEmpty()) {
                         result = result.replace(
                              "M8", mem8Holder.toString()
                         )
                    }
                    if (mem9Holder.isNotEmpty()) {
                         result = result.replace(
                              "M9", mem9Holder.toString()
                         )
                    }
                    if (mem10Holder.isNotEmpty()) {
                         result = result.replace(
                              "M10", mem10Holder.toString()
                         )
                    }
                    if (mem11Holder.isNotEmpty()) {
                         result = result.replace(
                              "M11", mem11Holder.toString()
                         )
                    }
                    if (mem12Holder.isNotEmpty()) {
                         result = result.replace(
                              "M12", mem12Holder.toString()
                         )
                    }
                    if (mem13Holder.isNotEmpty()) {
                         result = result.replace(
                              "M13", mem13Holder.toString()
                         )
                    }
                    if (mem14Holder.isNotEmpty()) {
                         result = result.replace(
                              "M14", mem14Holder.toString()
                         )
                    }
                    if (mem15Holder.isNotEmpty()) {
                         result = result.replace(
                              "M15", mem15Holder.toString()
                         )
                    }
                    
                    macroContains = result
                    macroContainsResult.value = macroContains
                    
               }
               else if (macroRecordIsClicked) {
                    
                    macroSet = "3"
                    
               }
               else if (macroClearIsClicked) {
                    
                    array3Holder.clear()
                    macroClearIsClicked = false
                    
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "1") {
                    lowVal = lowVal.plus("3")
                    lowValResult.value = lowVal
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "2") {
                    highVal = highVal.plus("3")
                    highValResult.value = highVal
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "3") {
                    precision = precision.plus("3")
                    precissionResult.value = precision
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "0") {
                    if (firstOperation!!.isEmpty()) {
                         falsiNum1Holder = falsiNum1Holder.plus("3")
                         quadraticNum1Result.value = falsiNum1Holder
                         
                    }
                    else if (firstOperation!!.isNotEmpty() && secondOperation!!.isEmpty()) {
                         falsiNum2Holder = falsiNum2Holder.plus("3")
                         quadraticNum2Result.value = falsiNum2Holder
                         
                    }
                    else if (secondOperation!!.isNotEmpty() && thirdOperation!!.isEmpty()) {
                         
                         falsiNum3Holder = falsiNum3Holder.plus("3")
                         quadraticNum3Result.value = falsiNum3Holder
                         
                    }
                    else {
                         falsiNum4Holder = falsiNum4Holder.plus("3")
                         quadraticNum4Result.value = falsiNum4Holder
                    }
               }
               else {
                    
                    if (resultHolder == "0" || resultHolder == "Error") {
                         resultHolder = ""
                         if (processHolder == "0" || processHolder.isEmpty()) {
                              
                              processHolder = processHolder.drop(1)
                              processHolder = processHolder.plus("3")
                         }
                         else {
                              
                              processHolder = processHolder.plus("3")
                         }
                         resultHolder = resultHolder.plus("3")
                    }
                    else if (resultHolder == "-0") {
                         resultHolder = ""
                         processHolder = processHolder.plus("-3")
                         resultHolder = resultHolder.plus("-3")
                    }
                    else if (isClicked) {
                         processHolder = ""
                         resultHolder = ""
                         processHolder = processHolder.plus("3")
                         resultHolder = resultHolder.plus("3")
                         isClicked = false
                    }
                    else {
                         
                         processHolder = processHolder.plus("3")
                         resultHolder = resultHolder.plus("3")
                    }
                    result.value = resultHolder
                    proccessResult.value = processHolder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun addNumber4() {
          try {
               if (macroRecallIsClicked) {
                    arraySize = array4Holder.size
                    resultHolder.plus(1)
                    macroChoosed = "4"
                    macroRecallIsClicked = false
                    
                    var result = array4Holder.toString()
                    result = result.toString()
                    result = result.drop(1)
                    result = result.dropLast(1)
                    result = result.replace(
                         ",", ""
                    )
                    if (mem1Holder.isNotEmpty()) {
                         result = result.replace(
                              "M1", mem1Holder.toString()
                         )
                    }
                    if (mem2Holder.isNotEmpty()) {
                         result = result.replace(
                              "M2", mem2Holder.toString()
                         )
                    }
                    if (mem3Holder.isNotEmpty()) {
                         result = result.replace(
                              "M3", mem3Holder.toString()
                         )
                    }
                    if (mem4Holder.isNotEmpty()) {
                         result = result.replace(
                              "M4", mem4Holder.toString()
                         )
                    }
                    if (mem5Holder.isNotEmpty()) {
                         result = result.replace(
                              "M5", mem5Holder.toString()
                         )
                    }
                    if (mem6Holder.isNotEmpty()) {
                         result = result.replace(
                              "M6", mem6Holder.toString()
                         )
                    }
                    if (mem7Holder.isNotEmpty()) {
                         result = result.replace(
                              "M7", mem7Holder.toString()
                         )
                    }
                    if (mem8Holder.isNotEmpty()) {
                         result = result.replace(
                              "M8", mem8Holder.toString()
                         )
                    }
                    if (mem9Holder.isNotEmpty()) {
                         result = result.replace(
                              "M9", mem9Holder.toString()
                         )
                    }
                    if (mem10Holder.isNotEmpty()) {
                         result = result.replace(
                              "M10", mem10Holder.toString()
                         )
                    }
                    if (mem11Holder.isNotEmpty()) {
                         result = result.replace(
                              "M11", mem11Holder.toString()
                         )
                    }
                    if (mem12Holder.isNotEmpty()) {
                         result = result.replace(
                              "M12", mem12Holder.toString()
                         )
                    }
                    if (mem13Holder.isNotEmpty()) {
                         result = result.replace(
                              "M13", mem13Holder.toString()
                         )
                    }
                    if (mem14Holder.isNotEmpty()) {
                         result = result.replace(
                              "M14", mem14Holder.toString()
                         )
                    }
                    if (mem15Holder.isNotEmpty()) {
                         result = result.replace(
                              "M15", mem15Holder.toString()
                         )
                    }
                    
                    macroContains = result
                    macroContainsResult.value = macroContains
               }
               else if (macroRecordIsClicked) {
                    
                    macroSet = "4"
                    
               }
               else if (macroClearIsClicked) {
                    
                    array4Holder.clear()
                    macroClearIsClicked = false
                    
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "1") {
                    lowVal = lowVal.plus("4")
                    lowValResult.value = lowVal
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "2") {
                    highVal = highVal.plus("4")
                    highValResult.value = highVal
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "3") {
                    precision = precision.plus("4")
                    precissionResult.value = precision
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "0") {
                    if (firstOperation!!.isEmpty()) {
                         falsiNum1Holder = falsiNum1Holder.plus("4")
                         quadraticNum1Result.value = falsiNum1Holder
                         
                    }
                    else if (firstOperation!!.isNotEmpty() && secondOperation!!.isEmpty()) {
                         falsiNum2Holder = falsiNum2Holder.plus("4")
                         quadraticNum2Result.value = falsiNum2Holder
                         
                    }
                    else if (secondOperation!!.isNotEmpty() && thirdOperation!!.isEmpty()) {
                         
                         falsiNum3Holder = falsiNum3Holder.plus("4")
                         quadraticNum3Result.value = falsiNum3Holder
                         
                    }
                    else {
                         falsiNum4Holder = falsiNum4Holder.plus("4")
                         quadraticNum4Result.value = falsiNum4Holder
                    }
               }
               else {
                    if (resultHolder == "0" || resultHolder == "Error") {
                         resultHolder = ""
                         if (processHolder == "0" || processHolder.isEmpty()) {
                              
                              processHolder = processHolder.drop(1)
                              processHolder = processHolder.plus("4")
                         }
                         else {
                              
                              processHolder = processHolder.plus("4")
                         }
                         resultHolder = resultHolder.plus("4")
                    }
                    else if (resultHolder == "-0") {
                         resultHolder = ""
                         processHolder = processHolder.plus("-4")
                         resultHolder = resultHolder.plus("-4")
                    }
                    else if (isClicked) {
                         processHolder = ""
                         resultHolder = ""
                         processHolder = processHolder.plus("4")
                         resultHolder = resultHolder.plus("4")
                         isClicked = false
                         
                    }
                    else {
                         
                         processHolder = processHolder.plus("4")
                         resultHolder = resultHolder.plus("4")
                    }
                    result.value = resultHolder
                    proccessResult.value = processHolder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun addNumber5() {
          try {
               if (macroRecallIsClicked) {
                    arraySize = array5Holder.size
                    resultHolder.plus(1)
                    macroChoosed = "5"
                    macroRecallIsClicked = false
                    
                    var result = array5Holder.toString()
                    result = result.toString()
                    result = result.drop(1)
                    result = result.dropLast(1)
                    result = result.replace(
                         ",", ""
                    )
                    if (mem1Holder.isNotEmpty()) {
                         result = result.replace(
                              "M1", mem1Holder.toString()
                         )
                    }
                    if (mem2Holder.isNotEmpty()) {
                         result = result.replace(
                              "M2", mem2Holder.toString()
                         )
                    }
                    if (mem3Holder.isNotEmpty()) {
                         result = result.replace(
                              "M3", mem3Holder.toString()
                         )
                    }
                    if (mem4Holder.isNotEmpty()) {
                         result = result.replace(
                              "M4", mem4Holder.toString()
                         )
                    }
                    if (mem5Holder.isNotEmpty()) {
                         result = result.replace(
                              "M5", mem5Holder.toString()
                         )
                    }
                    if (mem6Holder.isNotEmpty()) {
                         result = result.replace(
                              "M6", mem6Holder.toString()
                         )
                    }
                    if (mem7Holder.isNotEmpty()) {
                         result = result.replace(
                              "M7", mem7Holder.toString()
                         )
                    }
                    if (mem8Holder.isNotEmpty()) {
                         result = result.replace(
                              "M8", mem8Holder.toString()
                         )
                    }
                    if (mem9Holder.isNotEmpty()) {
                         result = result.replace(
                              "M9", mem9Holder.toString()
                         )
                    }
                    if (mem10Holder.isNotEmpty()) {
                         result = result.replace(
                              "M10", mem10Holder.toString()
                         )
                    }
                    if (mem11Holder.isNotEmpty()) {
                         result = result.replace(
                              "M11", mem11Holder.toString()
                         )
                    }
                    if (mem12Holder.isNotEmpty()) {
                         result = result.replace(
                              "M12", mem12Holder.toString()
                         )
                    }
                    if (mem13Holder.isNotEmpty()) {
                         result = result.replace(
                              "M13", mem13Holder.toString()
                         )
                    }
                    if (mem14Holder.isNotEmpty()) {
                         result = result.replace(
                              "M14", mem14Holder.toString()
                         )
                    }
                    if (mem15Holder.isNotEmpty()) {
                         result = result.replace(
                              "M15", mem15Holder.toString()
                         )
                    }
                    
                    macroContains = result
                    macroContainsResult.value = macroContains
                    
               }
               else if (macroRecordIsClicked) {
                    
                    macroSet = "5"
                    
               }
               else if (macroClearIsClicked) {
                    
                    array5Holder.clear()
                    macroClearIsClicked = false
                    
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "1") {
                    lowVal = lowVal.plus("5")
                    lowValResult.value = lowVal
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "2") {
                    highVal = highVal.plus("5")
                    highValResult.value = highVal
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "3") {
                    precision = precision.plus("5")
                    precissionResult.value = precision
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "0") {
                    if (firstOperation!!.isEmpty()) {
                         falsiNum1Holder = falsiNum1Holder.plus("5")
                         quadraticNum1Result.value = falsiNum1Holder
                         
                    }
                    else if (firstOperation!!.isNotEmpty() && secondOperation!!.isEmpty()) {
                         falsiNum2Holder = falsiNum2Holder.plus("5")
                         quadraticNum2Result.value = falsiNum2Holder
                         
                    }
                    else if (secondOperation!!.isNotEmpty() && thirdOperation!!.isEmpty()) {
                         
                         falsiNum3Holder = falsiNum3Holder.plus("5")
                         quadraticNum3Result.value = falsiNum3Holder
                         
                    }
                    else {
                         falsiNum4Holder = falsiNum4Holder.plus("5")
                         quadraticNum4Result.value = falsiNum4Holder
                    }
               }
               else {
                    if (resultHolder == "0" || resultHolder == "Error") {
                         resultHolder = ""
                         if (processHolder == "0" || processHolder.isEmpty()) {
                              
                              processHolder = processHolder.drop(1)
                              processHolder = processHolder.plus("5")
                         }
                         else {
                              
                              processHolder = processHolder.plus("5")
                         }
                         resultHolder = resultHolder.plus("5")
                    }
                    else if (resultHolder == "-0") {
                         resultHolder = ""
                         processHolder = processHolder.plus("-5")
                         resultHolder = resultHolder.plus("-5")
                    }
                    else if (isClicked) {
                         processHolder = ""
                         resultHolder = ""
                         processHolder = processHolder.plus("5")
                         resultHolder = resultHolder.plus("5")
                         isClicked = false
                         
                    }
                    else {
                         
                         processHolder = processHolder.plus("5")
                         resultHolder = resultHolder.plus("5")
                    }
                    result.value = resultHolder
                    proccessResult.value = processHolder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun addNumber6() {
          try {
               
               if (macroRecallIsClicked) {
                    arraySize = array6Holder.size
                    resultHolder.plus(1)
                    macroChoosed = "6"
                    macroRecallIsClicked = false
                    
                    var result = array6Holder.toString()
                    result = result.toString()
                    result = result.drop(1)
                    result = result.dropLast(1)
                    result = result.replace(
                         ",", ""
                    )
                    if (mem1Holder.isNotEmpty()) {
                         result = result.replace(
                              "M1", mem1Holder.toString()
                         )
                    }
                    if (mem2Holder.isNotEmpty()) {
                         result = result.replace(
                              "M2", mem2Holder.toString()
                         )
                    }
                    if (mem3Holder.isNotEmpty()) {
                         result = result.replace(
                              "M3", mem3Holder.toString()
                         )
                    }
                    if (mem4Holder.isNotEmpty()) {
                         result = result.replace(
                              "M4", mem4Holder.toString()
                         )
                    }
                    if (mem5Holder.isNotEmpty()) {
                         result = result.replace(
                              "M5", mem5Holder.toString()
                         )
                    }
                    if (mem6Holder.isNotEmpty()) {
                         result = result.replace(
                              "M6", mem6Holder.toString()
                         )
                    }
                    if (mem7Holder.isNotEmpty()) {
                         result = result.replace(
                              "M7", mem7Holder.toString()
                         )
                    }
                    if (mem8Holder.isNotEmpty()) {
                         result = result.replace(
                              "M8", mem8Holder.toString()
                         )
                    }
                    if (mem9Holder.isNotEmpty()) {
                         result = result.replace(
                              "M9", mem9Holder.toString()
                         )
                    }
                    if (mem10Holder.isNotEmpty()) {
                         result = result.replace(
                              "M10", mem10Holder.toString()
                         )
                    }
                    if (mem11Holder.isNotEmpty()) {
                         result = result.replace(
                              "M11", mem11Holder.toString()
                         )
                    }
                    if (mem12Holder.isNotEmpty()) {
                         result = result.replace(
                              "M12", mem12Holder.toString()
                         )
                    }
                    if (mem13Holder.isNotEmpty()) {
                         result = result.replace(
                              "M13", mem13Holder.toString()
                         )
                    }
                    if (mem14Holder.isNotEmpty()) {
                         result = result.replace(
                              "M14", mem14Holder.toString()
                         )
                    }
                    if (mem15Holder.isNotEmpty()) {
                         result = result.replace(
                              "M15", mem15Holder.toString()
                         )
                    }
                    
                    macroContains = result
                    macroContainsResult.value = macroContains
                    
               }
               else if (macroRecordIsClicked) {
                    
                    macroSet = "6"
                    
               }
               else if (macroClearIsClicked) {
                    
                    array6Holder.clear()
                    macroClearIsClicked = false
                    
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "1") {
                    lowVal = lowVal.plus("6")
                    lowValResult.value = lowVal
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "2") {
                    highVal = highVal.plus("6")
                    highValResult.value = highVal
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "3") {
                    precision = precision.plus("6")
                    precissionResult.value = precision
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "0") {
                    if (firstOperation!!.isEmpty()) {
                         falsiNum1Holder = falsiNum1Holder.plus("6")
                         quadraticNum1Result.value = falsiNum1Holder
                         
                    }
                    else if (firstOperation!!.isNotEmpty() && secondOperation!!.isEmpty()) {
                         falsiNum2Holder = falsiNum2Holder.plus("6")
                         quadraticNum2Result.value = falsiNum2Holder
                    }
                    else if (secondOperation!!.isNotEmpty() && thirdOperation!!.isEmpty()) {
                         
                         falsiNum3Holder = falsiNum3Holder.plus("6")
                         quadraticNum3Result.value = falsiNum3Holder
                         
                    }
                    else {
                         falsiNum4Holder = falsiNum4Holder.plus("6")
                         quadraticNum4Result.value = falsiNum4Holder
                    }
               }
               else {
                    if (resultHolder == "0" || resultHolder == "Error") {
                         resultHolder = ""
                         if (processHolder == "0" || processHolder.isEmpty()) {
                              
                              processHolder = processHolder.drop(1)
                              processHolder = processHolder.plus("6")
                         }
                         else {
                              
                              processHolder = processHolder.plus("6")
                         }
                         resultHolder = resultHolder.plus("6")
                    }
                    else if (resultHolder == "-0") {
                         resultHolder = ""
                         processHolder = processHolder.plus("-6")
                         resultHolder = resultHolder.plus("-6")
                    }
                    else if (isClicked) {
                         processHolder = ""
                         resultHolder = ""
                         processHolder = processHolder.plus("6")
                         resultHolder = resultHolder.plus("6")
                         isClicked = false
                         
                    }
                    else {
                         
                         processHolder = processHolder.plus("6")
                         resultHolder = resultHolder.plus("6")
                    }
                    result.value = resultHolder
                    proccessResult.value = processHolder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun addNumber7() {
          try {
               if (macroRecallIsClicked) {
                    arraySize = array7Holder.size
                    resultHolder.plus(1)
                    macroChoosed = "7"
                    macroRecallIsClicked = false
                    
                    var result = array7Holder.toString()
                    result = result.toString()
                    result = result.drop(1)
                    result = result.dropLast(1)
                    result = result.replace(
                         ",", ""
                    )
                    if (mem1Holder.isNotEmpty()) {
                         result = result.replace(
                              "M1", mem1Holder.toString()
                         )
                    }
                    if (mem2Holder.isNotEmpty()) {
                         result = result.replace(
                              "M2", mem2Holder.toString()
                         )
                    }
                    if (mem3Holder.isNotEmpty()) {
                         result = result.replace(
                              "M3", mem3Holder.toString()
                         )
                    }
                    if (mem4Holder.isNotEmpty()) {
                         result = result.replace(
                              "M4", mem4Holder.toString()
                         )
                    }
                    if (mem5Holder.isNotEmpty()) {
                         result = result.replace(
                              "M5", mem5Holder.toString()
                         )
                    }
                    if (mem6Holder.isNotEmpty()) {
                         result = result.replace(
                              "M6", mem6Holder.toString()
                         )
                    }
                    if (mem7Holder.isNotEmpty()) {
                         result = result.replace(
                              "M7", mem7Holder.toString()
                         )
                    }
                    if (mem8Holder.isNotEmpty()) {
                         result = result.replace(
                              "M8", mem8Holder.toString()
                         )
                    }
                    if (mem9Holder.isNotEmpty()) {
                         result = result.replace(
                              "M9", mem9Holder.toString()
                         )
                    }
                    if (mem10Holder.isNotEmpty()) {
                         result = result.replace(
                              "M10", mem10Holder.toString()
                         )
                    }
                    if (mem11Holder.isNotEmpty()) {
                         result = result.replace(
                              "M11", mem11Holder.toString()
                         )
                    }
                    if (mem12Holder.isNotEmpty()) {
                         result = result.replace(
                              "M12", mem12Holder.toString()
                         )
                    }
                    if (mem13Holder.isNotEmpty()) {
                         result = result.replace(
                              "M13", mem13Holder.toString()
                         )
                    }
                    if (mem14Holder.isNotEmpty()) {
                         result = result.replace(
                              "M14", mem14Holder.toString()
                         )
                    }
                    if (mem15Holder.isNotEmpty()) {
                         result = result.replace(
                              "M15", mem15Holder.toString()
                         )
                    }
                    macroContains = result
                    macroContainsResult.value = macroContains
               }
               else if (macroRecordIsClicked) {
                    
                    macroSet = "7"
                    
               }
               else if (macroClearIsClicked) {
                    
                    array7Holder.clear()
                    macroClearIsClicked = false
                    
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "1") {
                    lowVal = lowVal.plus("7")
                    lowValResult.value = lowVal
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "2") {
                    highVal = highVal.plus("7")
                    highValResult.value = highVal
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "3") {
                    precision = precision.plus("7")
                    precissionResult.value = precision
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "0") {
                    if (firstOperation!!.isEmpty()) {
                         falsiNum1Holder = falsiNum1Holder.plus("7")
                         quadraticNum1Result.value = falsiNum1Holder
                    }
                    else if (firstOperation!!.isNotEmpty() && secondOperation!!.isEmpty()) {
                         falsiNum2Holder = falsiNum2Holder.plus("7")
                         quadraticNum2Result.value = falsiNum2Holder
                    }
                    else if (secondOperation!!.isNotEmpty() && thirdOperation!!.isEmpty()) {
                         
                         falsiNum3Holder = falsiNum3Holder.plus("7")
                         quadraticNum3Result.value = falsiNum3Holder
                         
                    }
                    else {
                         falsiNum4Holder = falsiNum4Holder.plus("7")
                         quadraticNum4Result.value = falsiNum4Holder
                    }
               }
               else {
                    if (resultHolder == "0" || resultHolder == "Error") {
                         resultHolder = ""
                         if (processHolder == "0" || processHolder.isEmpty()) {
                              
                              processHolder = processHolder.drop(1)
                              processHolder = processHolder.plus("7")
                         }
                         else {
                              
                              processHolder = processHolder.plus("7")
                         }
                         resultHolder = resultHolder.plus("7")
                    }
                    else if (resultHolder == "-0") {
                         
                         resultHolder = ""
                         processHolder = processHolder.plus("-7")
                         resultHolder = resultHolder.plus("-7")
                    }
                    else if (isClicked) {
                         processHolder = ""
                         resultHolder = ""
                         processHolder = processHolder.plus("7")
                         resultHolder = resultHolder.plus("7")
                         isClicked = false
                         
                    }
                    else {
                         
                         processHolder = processHolder.plus("7")
                         resultHolder = resultHolder.plus("7")
                    }
                    result.value = resultHolder
                    proccessResult.value = processHolder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun addNumber8() {
          try {
               if (macroRecallIsClicked) {
                    arraySize = array8Holder.size
                    resultHolder.plus(1)
                    macroChoosed = "8"
                    macroRecallIsClicked = false
                    
                    var result = array8Holder.toString()
                    result = result.toString()
                    result = result.drop(1)
                    result = result.dropLast(1)
                    result = result.replace(
                         ",", ""
                    )
                    if (mem1Holder.isNotEmpty()) {
                         result = result.replace(
                              "M1", mem1Holder.toString()
                         )
                    }
                    if (mem2Holder.isNotEmpty()) {
                         result = result.replace(
                              "M2", mem2Holder.toString()
                         )
                    }
                    if (mem3Holder.isNotEmpty()) {
                         result = result.replace(
                              "M3", mem3Holder.toString()
                         )
                    }
                    if (mem4Holder.isNotEmpty()) {
                         result = result.replace(
                              "M4", mem4Holder.toString()
                         )
                    }
                    if (mem5Holder.isNotEmpty()) {
                         result = result.replace(
                              "M5", mem5Holder.toString()
                         )
                    }
                    if (mem6Holder.isNotEmpty()) {
                         result = result.replace(
                              "M6", mem6Holder.toString()
                         )
                    }
                    if (mem7Holder.isNotEmpty()) {
                         result = result.replace(
                              "M7", mem7Holder.toString()
                         )
                    }
                    if (mem8Holder.isNotEmpty()) {
                         result = result.replace(
                              "M8", mem8Holder.toString()
                         )
                    }
                    if (mem9Holder.isNotEmpty()) {
                         result = result.replace(
                              "M9", mem9Holder.toString()
                         )
                    }
                    if (mem10Holder.isNotEmpty()) {
                         result = result.replace(
                              "M10", mem10Holder.toString()
                         )
                    }
                    if (mem11Holder.isNotEmpty()) {
                         result = result.replace(
                              "M11", mem11Holder.toString()
                         )
                    }
                    if (mem12Holder.isNotEmpty()) {
                         result = result.replace(
                              "M12", mem12Holder.toString()
                         )
                    }
                    if (mem13Holder.isNotEmpty()) {
                         result = result.replace(
                              "M13", mem13Holder.toString()
                         )
                    }
                    if (mem14Holder.isNotEmpty()) {
                         result = result.replace(
                              "M14", mem14Holder.toString()
                         )
                    }
                    if (mem15Holder.isNotEmpty()) {
                         result = result.replace(
                              "M15", mem15Holder.toString()
                         )
                    }
                    
                    macroContains = result
                    macroContainsResult.value = macroContains
               }
               else if (macroRecordIsClicked) {
                    
                    macroSet = "8"
                    
               }
               else if (macroClearIsClicked) {
                    
                    array8Holder.clear()
                    macroClearIsClicked = false
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "1") {
                    lowVal = lowVal.plus("8")
                    lowValResult.value = lowVal
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "2") {
                    highVal = highVal.plus("8")
                    highValResult.value = highVal
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "3") {
                    precision = precision.plus("8")
                    precissionResult.value = precision
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "0") {
                    if (firstOperation!!.isEmpty()) {
                         falsiNum1Holder = falsiNum1Holder.plus("8")
                         quadraticNum1Result.value = falsiNum1Holder
                    }
                    else if (firstOperation!!.isNotEmpty() && secondOperation!!.isEmpty()) {
                         falsiNum2Holder = falsiNum2Holder.plus("8")
                         quadraticNum2Result.value = falsiNum2Holder
                    }
                    else if (secondOperation!!.isNotEmpty() && thirdOperation!!.isEmpty()) {
                         
                         falsiNum3Holder = falsiNum3Holder.plus("8")
                         quadraticNum3Result.value = falsiNum3Holder
                         
                    }
                    else {
                         falsiNum4Holder = falsiNum4Holder.plus("8")
                         quadraticNum4Result.value = falsiNum4Holder
                    }
               }
               else {
                    if (resultHolder == "0" || resultHolder == "Error") {
                         resultHolder = ""
                         if (processHolder == "0" || processHolder.isEmpty()) {
                              
                              processHolder = processHolder.drop(1)
                              processHolder = processHolder.plus("8")
                         }
                         else {
                              
                              processHolder = processHolder.plus("8")
                         }
                         resultHolder = resultHolder.plus("8")
                    }
                    else if (resultHolder == "-0") {
                         
                         resultHolder = ""
                         processHolder = processHolder.plus("-8")
                         resultHolder = resultHolder.plus("-8")
                    }
                    else if (isClicked) {
                         processHolder = ""
                         resultHolder = ""
                         processHolder = processHolder.plus("8")
                         resultHolder = resultHolder.plus("8")
                         isClicked = false
                         
                    }
                    else {
                         
                         processHolder = processHolder.plus("8")
                         resultHolder = resultHolder.plus("8")
                    }
                    result.value = resultHolder
                    proccessResult.value = processHolder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun addNumber9() {
          try {
               if (macroRecallIsClicked) {
                    arraySize = array9Holder.size
                    resultHolder.plus(1)
                    macroChoosed = "9"
                    macroRecallIsClicked = false
                    
                    var result = array9Holder.toString()
                    result = result.toString()
                    result = result.drop(1)
                    result = result.dropLast(1)
                    result = result.replace(
                         ",", ""
                    )
                    if (mem1Holder.isNotEmpty()) {
                         result = result.replace(
                              "M1", mem1Holder.toString()
                         )
                    }
                    if (mem2Holder.isNotEmpty()) {
                         result = result.replace(
                              "M2", mem2Holder.toString()
                         )
                    }
                    if (mem3Holder.isNotEmpty()) {
                         result = result.replace(
                              "M3", mem3Holder.toString()
                         )
                    }
                    if (mem4Holder.isNotEmpty()) {
                         result = result.replace(
                              "M4", mem4Holder.toString()
                         )
                    }
                    if (mem5Holder.isNotEmpty()) {
                         result = result.replace(
                              "M5", mem5Holder.toString()
                         )
                    }
                    if (mem6Holder.isNotEmpty()) {
                         result = result.replace(
                              "M6", mem6Holder.toString()
                         )
                    }
                    if (mem7Holder.isNotEmpty()) {
                         result = result.replace(
                              "M7", mem7Holder.toString()
                         )
                    }
                    if (mem8Holder.isNotEmpty()) {
                         result = result.replace(
                              "M8", mem8Holder.toString()
                         )
                    }
                    if (mem9Holder.isNotEmpty()) {
                         result = result.replace(
                              "M9", mem9Holder.toString()
                         )
                    }
                    if (mem10Holder.isNotEmpty()) {
                         result = result.replace(
                              "M10", mem10Holder.toString()
                         )
                    }
                    if (mem11Holder.isNotEmpty()) {
                         result = result.replace(
                              "M11", mem11Holder.toString()
                         )
                    }
                    if (mem12Holder.isNotEmpty()) {
                         result = result.replace(
                              "M12", mem12Holder.toString()
                         )
                    }
                    if (mem13Holder.isNotEmpty()) {
                         result = result.replace(
                              "M13", mem13Holder.toString()
                         )
                    }
                    if (mem14Holder.isNotEmpty()) {
                         result = result.replace(
                              "M14", mem14Holder.toString()
                         )
                    }
                    if (mem15Holder.isNotEmpty()) {
                         result = result.replace(
                              "M15", mem15Holder.toString()
                         )
                    }
                    
                    macroContains = result
                    macroContainsResult.value = macroContains
               }
               else if (macroRecordIsClicked) {
                    
                    macroSet = "9"
                    
               }
               else if (macroClearIsClicked) {
                    
                    array9Holder.clear()
                    macroClearIsClicked = false
                    
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "1") {
                    lowVal = lowVal.plus("9")
                    lowValResult.value = lowVal
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "2") {
                    highVal = highVal.plus("9")
                    highValResult.value = highVal
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "3") {
                    precision = precision.plus("9")
                    precissionResult.value = precision
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "0") {
                    if (firstOperation!!.isEmpty()) {
                         falsiNum1Holder = falsiNum1Holder.plus("9")
                         quadraticNum1Result.value = falsiNum1Holder
                         
                    }
                    else if (firstOperation!!.isNotEmpty() && secondOperation!!.isEmpty()) {
                         
                         falsiNum2Holder = falsiNum2Holder.plus("9")
                         quadraticNum2Result.value = falsiNum2Holder
                         
                    }
                    else if (secondOperation!!.isNotEmpty() && thirdOperation!!.isEmpty()) {
                         
                         falsiNum3Holder = falsiNum3Holder.plus("9")
                         quadraticNum3Result.value = falsiNum3Holder
                         
                    }
                    else {
                         falsiNum4Holder = falsiNum4Holder.plus("9")
                         quadraticNum4Result.value = falsiNum4Holder
                    }
               }
               else {
                    if (resultHolder == "0" || resultHolder == "Error") {
                         resultHolder = ""
                         if (processHolder == "0" || processHolder.isEmpty()) {
                              
                              processHolder = processHolder.drop(1)
                              processHolder = processHolder.plus("9")
                         }
                         else {
                              
                              processHolder = processHolder.plus("9")
                         }
                         resultHolder = resultHolder.plus("9")
                    }
                    else if (resultHolder == "-0") {
                         resultHolder = ""
                         processHolder = processHolder.plus("-9")
                         resultHolder = resultHolder.plus("-9")
                    }
                    else if (isClicked) {
                         processHolder = ""
                         resultHolder = ""
                         processHolder = processHolder.plus("9")
                         resultHolder = resultHolder.plus("9")
                         isClicked = false
                         
                    }
                    else {
                         
                         processHolder = processHolder.plus("9")
                         resultHolder = resultHolder.plus("9")
                    }
                    result.value = resultHolder
                    proccessResult.value = processHolder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun addNumber0() {
          try {
               if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "1") {
                    lowVal = lowVal.plus("0")
                    lowValResult.value = lowVal
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "2") {
                    highVal = highVal.plus("0")
                    highValResult.value = highVal
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "3") {
                    precision = precision.plus("0")
                    precissionResult.value = precision
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "0") {
                    if (firstOperation!!.isEmpty()) {
                         falsiNum1Holder = falsiNum1Holder.plus("0")
                         quadraticNum1Result.value = falsiNum1Holder
                    }
                    else if (firstOperation!!.isNotEmpty() && secondOperation!!.isEmpty()) {
                         falsiNum2Holder = falsiNum2Holder.plus("0")
                         quadraticNum2Result.value = falsiNum2Holder
                    }
                    else if (secondOperation!!.isNotEmpty() && thirdOperation!!.isEmpty()) {
                         
                         falsiNum3Holder = falsiNum3Holder.plus("0")
                         quadraticNum3Result.value = falsiNum3Holder
                         
                    }
                    else {
                         falsiNum4Holder = falsiNum4Holder.plus("0")
                         quadraticNum4Result.value = falsiNum4Holder
                    }
               }
               else {
                    if (resultHolder == "0" || resultHolder == "Error") {
                         resultHolder = ""
                         if (processHolder == "0" || processHolder.isEmpty()) {
                              
                              processHolder = processHolder.drop(1)
                              processHolder = processHolder.plus("0")
                         }
                         else {
                              
                              processHolder = processHolder.plus("0")
                         }
                         resultHolder = resultHolder.plus("0")
                    }
                    else if (isClicked) {
                         processHolder = ""
                         resultHolder = ""
                         processHolder = processHolder.plus("0")
                         resultHolder = resultHolder.plus("0")
                         isClicked = false
                         
                    }
                    else {
                         
                         processHolder = processHolder.plus("0")
                         resultHolder = resultHolder.plus("0")
                    }
                    result.value = resultHolder
                    proccessResult.value = processHolder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun addNumber00() {
          try {
               if (resultHolder == "0" || resultHolder == "Error") {
                    resultHolder = "0"
                    if (processHolder == "0" || processHolder.isEmpty()) {
                    
                    }
                    
               }
               else if (resultHolder == "-0") {
                    resultHolder = ""
                    processHolder = processHolder.plus("-00")
                    resultHolder = resultHolder.plus("-00")
               }
               else if (isClicked) {
                    processHolder = ""
                    resultHolder = ""
                    processHolder = processHolder.plus("00")
                    resultHolder = resultHolder.plus("00")
                    isClicked = false
                    
               }
               else {
                    processHolder = processHolder.plus("00")
                    resultHolder = resultHolder.plus("00")
               }
               result.value = resultHolder
               proccessResult.value = processHolder
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun addDot() {
          try {
               if (falsiMethodIsClicked) {
                    if (falsiMethodIsClickedCount == 1) {
                         if (lowVal.contains('.')) {
                         }
                         else {
                              lowVal += "."
                              lowValResult.value = lowVal
                         }
                    }
                    if (falsiMethodIsClickedCount == 2) {
                         if (highVal.contains('.')) {
                         }
                         else {
                              highVal += "."
                              highValResult.value = highVal
                         }
                    }
                    if (falsiMethodIsClickedCount == 3) {
                         if (precision.contains('.')) {
                         }
                         else {
                              precision += "."
                              precissionResult.value = precision
                         }
                         
                    }
                    else if (falsiMethodIsClickedCount == 0) {
                         if (firstOperation!!.isEmpty()) {
                              if (falsiNum1Holder!!.contains(".")) {
                                   quadraticNum1Result.value = falsiNum1Holder
                              }
                              else {
                                   falsiNum1Holder = falsiNum1Holder.plus(".")
                                   quadraticNum1Result.value = falsiNum1Holder
                              }
                         }
                         else if (firstOperation!!.isNotEmpty() && secondOperation!!.isEmpty()) {
                              if (falsiNum2Holder!!.contains(".")) {
                                   quadraticNum2Result.value = falsiNum2Holder
                              }
                              else {
                                   falsiNum2Holder = falsiNum2Holder.plus(".")
                                   quadraticNum2Result.value = falsiNum2Holder
                              }
                         }
                         else if (secondOperation!!.isNotEmpty() && thirdOperation!!.isEmpty()) {
                              if (falsiNum3Holder!!.contains(".")) {
                                   quadraticNum3Result.value = falsiNum3Holder
                              }
                              else {
                                   falsiNum3Holder = falsiNum3Holder.plus(".")
                                   quadraticNum3Result.value = falsiNum3Holder
                              }
                         }
                         else {
                              if (falsiNum4Holder!!.contains(".")) {
                                   quadraticNum4Result.value = falsiNum4Holder
                              }
                              else {
                                   falsiNum4Holder = falsiNum4Holder.plus(".")
                                   quadraticNum4Result.value = falsiNum4Holder
                              }
                         }
                    }
                    
               }
               else {
                    if (processHolder.isEmpty()) {
                         
                         processHolder = ""
                         proccessResult.value = processHolder
                         
                    }
                    else if (resultHolder == "0" && processHolder.contains("+") || processHolder.contains(
                              "-"
                         ) || processHolder.contains("*") || processHolder.contains("/")) {
                         processHolder += "0"
                         proccessResult.value = processHolder
                         Log.e(
                              "mesage", resultHolder.toString()
                         )
                    }
                    
                    when {
                         resultHolder.contains(".") -> {
                         
                         }
                         resultHolder.isEmpty() -> {
                              resultHolder = resultHolder.plus("0.")
                              processHolder = processHolder.plus("0.")
                         }
                         resultHolder.isNotEmpty() && resultHolder != "." -> {
                              resultHolder = resultHolder.plus(".")
                              processHolder = processHolder.plus(".")
                         }
                    }
                    result.value = resultHolder
                    proccessResult.value = processHolder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun deleteAll() {
          if (falsiMethodIsClicked) {
               
               falsiMethodIsClickedCount = 0
               lowVal = ""
               highVal = ""
               precision = ""
               falsiNum1Holder = ""
               falsiNum2Holder = ""
               falsiNum3Holder = ""
               falsiNum4Holder = ""
               firstOperation = ""
               secondOperation = ""
               thirdOperation = ""
               x1RootHolder = 0.0
               x2RootHolder = 0.0
               x1 = ""
               x2 = ""
               x3 = ""
               
               lowValResult.value = lowVal
               highValResult.value = highVal
               precissionResult.value = precision
               x1Result.value = ""
               x2Result.value = ""
               x3Result.value = ""
               quadraticNum1Result.value = ""
               quadraticNum2Result.value = ""
               quadraticNum3Result.value = ""
               quadraticNum4Result.value = ""
               firstOperationResult.value = ""
               secondOperationResult.value = ""
               thirdOperationResult.value = ""
               x1RootResult.value = ""
               x2RootResult.value = ""
          }
          else {
               macroContains = ""
               macroContainsResult.value = macroContains
               numberArrayHolder.removeAll(numberArrayHolder)
               count = -1
               macroChoosed = "0"
               arraySize = 0
               macroClearIsClicked = false
               macroClearSet = ""
               macroRecordIsClicked = false
               macroRecallIsClicked = false
               macroSet = "0"
               macroChoosed = "0"
               
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
               symbolIsClickedCount = 0
               macroResult = 0
               
               proccessResult.value = ""
               result.value = "0"
          }
     }
     
     fun deleteOneChar() {
          try {
               if (falsiMethodIsClicked) {
                    
                    if (falsiMethodIsClickedCount == 1) {
                         lowVal = lowVal.dropLast(1)
                         lowValResult.value = lowVal
                         if (lowVal.isEmpty()) {
                              falsiMethodIsClickedCount = 0
                         }
                         
                    }
                    if (falsiMethodIsClickedCount == 2) {
                         highVal = highVal.dropLast(1)
                         highValResult.value = highVal
                         if (highVal.isEmpty()) {
                              falsiMethodIsClickedCount = 1
                         }
                    }
                    if (falsiMethodIsClickedCount == 3) {
                         precision = precision.dropLast(1)
                         precissionResult.value = precision
                         if (precision.isEmpty()) {
                              falsiMethodIsClickedCount = 2
                         }
                    }
                    
                    if (falsiNum4Holder!!.isNotEmpty() && falsiMethodIsClickedCount == 0) {
                         falsiNum4Holder = falsiNum4Holder!!.dropLast(1)
                         quadraticNum4Result.value = falsiNum4Holder
                    }
                    else if (falsiNum4Holder!!.isEmpty() && thirdOperation!!.isNotEmpty() && falsiMethodIsClickedCount == 0) {
                         thirdOperation = thirdOperation!!.dropLast(1)
                         thirdOperationResult.value = thirdOperation
                    }
                    else if (thirdOperation!!.isEmpty() && x3!!.isNotEmpty() && falsiMethodIsClickedCount == 0) {
                         x3 = ""
                         x3Result.value = x3
                    }
                    else if (x3!!.isEmpty() && falsiNum3Holder!!.isNotEmpty() && falsiMethodIsClickedCount == 0) {
                         falsiNum3Holder = falsiNum3Holder!!.dropLast(1)
                         quadraticNum3Result.value = falsiNum3Holder
                    }
                    else if (falsiNum3Holder!!.isEmpty() && secondOperation!!.isNotEmpty() && falsiMethodIsClickedCount == 0) {
                         secondOperation = secondOperation!!.dropLast(1)
                         secondOperationResult.value = secondOperation
                    }
                    else if (secondOperation!!.isEmpty() && x2!!.isNotEmpty() && falsiMethodIsClickedCount == 0) {
                         x2 = ""
                         x2Result.value = x2
                    }
                    else if (x2!!.isEmpty() && falsiNum2Holder!!.isNotEmpty() && falsiMethodIsClickedCount == 0) {
                         falsiNum2Holder = falsiNum2Holder!!.dropLast(1)
                         quadraticNum2Result.value = falsiNum2Holder
                         
                    }
                    else if (falsiNum2Holder!!.isEmpty() && firstOperation!!.isNotEmpty() && falsiMethodIsClickedCount == 0) {
                         firstOperation = firstOperation!!.dropLast(1)
                         firstOperationResult.value = firstOperation
                    }
                    else if (firstOperation!!.isEmpty() && x1!!.isNotEmpty() && falsiMethodIsClickedCount == 0) {
                         x1 = ""
                         x1Result.value = x1
                    }
                    else if (falsiNum1Holder!!.isNotEmpty() && falsiMethodIsClickedCount == 0) {
                         falsiNum1Holder = falsiNum1Holder!!.dropLast(1)
                         quadraticNum1Result.value = falsiNum1Holder
                    }
                    
               }
               else {
                    if (resultHolder == " " || resultHolder == "Error") {
                         resultHolder = "0"
                         processHolder = ""
                         result.value = resultHolder
                         proccessResult.value = processHolder
                    }
                    else {
                         resultHolder = resultHolder.dropLast(1)
                         processHolder = processHolder.dropLast(1)
                         
                         if (resultHolder.isEmpty() || resultHolder == "-") {
                              resultHolder = "0"
                         }
                         result.value = resultHolder
                         proccessResult.value = processHolder
                    }
                    result.value = resultHolder
                    proccessResult.value = processHolder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun changeSymbol() {
          try {
               if (falsiMethodIsClicked) {
                    
                    if (secondOperation!!.isNotEmpty() && falsiNum2Holder!!.isNotEmpty()) {
                         if (secondOperation == "-") {
                              secondOperation = "+"
                         }
                         else {
                              secondOperation = "-"
                         }
                         secondOperationResult.value = secondOperation
                    }
                    else if (firstOperation!!.isNotEmpty() && falsiNum1Holder!!.isNotEmpty()) {
                         if (firstOperation == "-") {
                              firstOperation = "+"
                         }
                         else {
                              firstOperation = "-"
                         }
                         firstOperationResult.value = firstOperation
                    }
                    else {
                         
                         if (falsiNum1Holder!!.contains("-")) {
                              falsiNum1Holder = falsiNum1Holder!!.drop(1)
                         }
                         else {
                              falsiNum1Holder = ("-$falsiNum1Holder")
                         }
                         quadraticNum1Result.value = falsiNum1Holder
                    }
               }
               else {
                    
                    try {
                         isClickedCount += 1
                         resultHolderLenght = resultHolder.length
                         
                         if (isClickedCount == 1 && resultHolder.contains("-")) {
                              resultHolder = resultHolder.drop(1)
                              processHolder = processHolder.drop(1)
                              Log.e(
                                   "tady", "tady1"
                              )
                              isClickedCount = 0
                              
                         }
                         else if (isClickedCount == 1 && resultHolder.toInt()
                                  .toString() == "0") {
                              
                              resultHolder = "0"
                              processHolder = ""
                              isClickedCount = 0
                              Log.e(
                                   "tady", "tady2"
                              )
                              
                         }
                         else if (isClickedCount == 1) {
                              
                              resultHolder = "-$resultHolder"
                              processHolder = "-$processHolder"
                              isClickedCount = 0
                              Log.e(
                                   "tady", "tady3"
                              )
                              
                         }
                         else {
                              
                              resultHolder = "-$resultHolder"
                              processHolder = processHolder.dropLast(resultHolderLenght)
                              processHolder += "($resultHolder)"
                              isClickedCount = 0
                         }
                         
                         result.value = resultHolder
                         proccessResult.value = processHolder
                         
                    }
                    catch (e : Exception) {
                         
                         Log.e(
                              "message", e.message.toString()
                         )
                    }
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun plus() {
          try {
               isClicked = false
               resultHolderLenght = resultHolder.length
               
               if (macroChoosed == "1") {
                    
                    count += 1
                    if (count == arraySize) {
                         
                         numberArrayHolder.add(resultHolder)
                         
                    }
                    else if (array1Holder[count].toString() == "x2" && array1Holder[count + 1].toString() == "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder + "*")
                         
                         count += 1
                    }
                    else if (array1Holder[count].toString() == "x2" && array1Holder[count + 1].toString() != "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder + array1Holder[count + 1])
                         
                         count += 1
                    }
                    else if (array1Holder[count].toString() == "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder)
                         
                    }
                    else if (array1Holder[count].toString() == "M1") {
                         
                         numberArrayHolder.add(mem1Holder.toString())
                         
                    }
                    else if (array1Holder[count].toString() == "M2") {
                         
                         numberArrayHolder.add(mem2Holder.toString())
                         
                    }
                    else if (array1Holder[count].toString() == "M3") {
                         
                         numberArrayHolder.add(mem3Holder.toString())
                         
                    }
                    else if (array1Holder[count].toString() == "M4") {
                         
                         numberArrayHolder.add(mem4Holder.toString())
                         
                    }
                    else if (array1Holder[count].toString() == "M5") {
                         
                         numberArrayHolder.add(mem5Holder.toString())
                         
                    }
                    else if (array1Holder[count].toString() == "M6") {
                         
                         numberArrayHolder.add(mem6Holder.toString())
                         
                    }
                    else if (array1Holder[count].toString() == "M7") {
                         
                         numberArrayHolder.add(mem7Holder.toString())
                         
                    }
                    else if (array1Holder[count].toString() == "M8") {
                         
                         numberArrayHolder.add(mem8Holder.toString())
                         
                    }
                    else if (array1Holder[count].toString() == "M9") {
                         
                         numberArrayHolder.add(mem9Holder.toString())
                         
                    }
                    else if (array1Holder[count].toString() == "M10") {
                         
                         numberArrayHolder.add(mem10Holder.toString())
                         
                    }
                    else if (array1Holder[count].toString() == "M11") {
                         
                         numberArrayHolder.add(mem11Holder.toString())
                         
                    }
                    else if (array1Holder[count].toString() == "M12") {
                         
                         numberArrayHolder.add(mem12Holder.toString())
                         
                    }
                    else if (array1Holder[count].toString() == "M13") {
                         
                         numberArrayHolder.add(mem13Holder.toString())
                         
                    }
                    else if (array1Holder[count].toString() == "M14") {
                         
                         numberArrayHolder.add(mem14Holder.toString())
                         
                    }
                    else if (array1Holder[count].toString() == "M15") {
                         
                         numberArrayHolder.add(mem15Holder.toString())
                         
                    }
                    else {
                         numberArrayHolder.add(resultHolder + array1Holder[count])
                    }
                    
                    resultHolder = ""
                    processHolder = ""
                    
                    result.value = "0"
                    
                    if (arraySize + 1 == numberArrayHolder.size) {
                         
                         resultHolder = numberArrayHolder.toString()
                         resultHolder = resultHolder.drop(1)
                         resultHolder = resultHolder.dropLast(1)
                         resultHolder = resultHolder.replace(
                              ",", ""
                         )
                         
                         val expression = ExpressionBuilder(resultHolder).build()
                         val processHolderResult : Double = expression.evaluate()
                         
                         if (processHolderResult.toString()
                                  .contains(".0")) {
                              
                              ansHolder =
                                  processHolderResult.toInt()
                                      .toString()
                              lastResult.value = ansHolder
                         }
                         else {
                              ansHolder = processHolderResult.toString()
                              lastResult.value = ansHolder
                         }
                         
                         numberArrayHolder.removeAll(numberArrayHolder)
                         count = -1
                         macroChoosed = "0"
                         arraySize = 0
                         macroRecordIsClicked = false
                         macroRecallIsClicked = false
                         macroSet = "0"
                         macroChoosed = "0"
                         resultHolder = "0"
                         macroContains = ""
                         macroContainsResult.value = macroContains
                         
                    }
                    Log.e(
                         "message", numberArrayHolder.toString()
                    )
                    processHolder = numberArrayHolder.toString()
                    processHolder = processHolder.drop(1)
                    processHolder = processHolder.dropLast(1)
                    processHolder = processHolder.replace(
                         ",", ""
                    )
                    proccessResult.value = processHolder
                    
               }
               else if (macroChoosed == "2") {
                    
                    count += 1
                    if (count == arraySize) {
                         
                         numberArrayHolder.add(resultHolder)
                         
                    }
                    else if (array2Holder[count].toString() == "x2" && array2Holder[count + 1].toString() == "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder + "*")
                         
                         count += 1
                    }
                    else if (array2Holder[count].toString() == "x2" && array2Holder[count + 1].toString() != "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder + array2Holder[count + 1])
                         
                         count += 1
                    }
                    else if (array2Holder[count].toString() == "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder)
                         
                    }
                    else if (array2Holder[count].toString() == "M1") {
                         
                         numberArrayHolder.add(mem1Holder.toString())
                         
                    }
                    else if (array2Holder[count].toString() == "M2") {
                         
                         numberArrayHolder.add(mem2Holder.toString())
                         
                    }
                    else if (array2Holder[count].toString() == "M3") {
                         
                         numberArrayHolder.add(mem3Holder.toString())
                         
                    }
                    else if (array2Holder[count].toString() == "M4") {
                         
                         numberArrayHolder.add(mem4Holder.toString())
                         
                    }
                    else if (array2Holder[count].toString() == "M5") {
                         
                         numberArrayHolder.add(mem5Holder.toString())
                         
                    }
                    else if (array2Holder[count].toString() == "M6") {
                         
                         numberArrayHolder.add(mem6Holder.toString())
                         
                    }
                    else if (array2Holder[count].toString() == "M7") {
                         
                         numberArrayHolder.add(mem7Holder.toString())
                         
                    }
                    else if (array2Holder[count].toString() == "M8") {
                         
                         numberArrayHolder.add(mem8Holder.toString())
                         
                    }
                    else if (array2Holder[count].toString() == "M9") {
                         
                         numberArrayHolder.add(mem9Holder.toString())
                         
                    }
                    else if (array2Holder[count].toString() == "M10") {
                         
                         numberArrayHolder.add(mem10Holder.toString())
                         
                    }
                    else if (array2Holder[count].toString() == "M11") {
                         
                         numberArrayHolder.add(mem11Holder.toString())
                         
                    }
                    else if (array2Holder[count].toString() == "M12") {
                         
                         numberArrayHolder.add(mem12Holder.toString())
                         
                    }
                    else if (array2Holder[count].toString() == "M13") {
                         
                         numberArrayHolder.add(mem13Holder.toString())
                         
                    }
                    else if (array2Holder[count].toString() == "M14") {
                         
                         numberArrayHolder.add(mem14Holder.toString())
                         
                    }
                    else if (array2Holder[count].toString() == "M15") {
                         
                         numberArrayHolder.add(mem15Holder.toString())
                         
                    }
                    else {
                         
                         numberArrayHolder.add(resultHolder + array2Holder[count])
                    }
                    
                    resultHolder = ""
                    processHolder = ""
                    
                    result.value = "0"
                    
                    if (arraySize + 1 == numberArrayHolder.size) {
                         
                         resultHolder = numberArrayHolder.toString()
                         resultHolder = resultHolder.drop(1)
                         resultHolder = resultHolder.dropLast(1)
                         resultHolder = resultHolder.replace(
                              ",", ""
                         )
                         
                         val expression = ExpressionBuilder(resultHolder).build()
                         val processHolderResult : Double = expression.evaluate()
                         
                         if (processHolderResult.toString()
                                  .contains(".0")) {
                              
                              ansHolder =
                                  processHolderResult.toInt()
                                      .toString()
                              lastResult.value = ansHolder
                         }
                         else {
                              ansHolder = processHolderResult.toString()
                              lastResult.value = ansHolder
                         }
                         
                         numberArrayHolder.removeAll(numberArrayHolder)
                         count = -1
                         macroChoosed = "0"
                         arraySize = 0
                         macroRecordIsClicked = false
                         macroRecallIsClicked = false
                         macroSet = "0"
                         macroChoosed = "0"
                         resultHolder = "0"
                         macroContains = ""
                         macroContainsResult.value = macroContains
                         
                    }
                    Log.e(
                         "message", numberArrayHolder.toString()
                    )
                    processHolder = numberArrayHolder.toString()
                    processHolder = processHolder.drop(1)
                    processHolder = processHolder.dropLast(1)
                    processHolder = processHolder.replace(
                         ",", ""
                    )
                    proccessResult.value = processHolder
                    
               }
               else if (macroChoosed == "3") {
                    
                    count += 1
                    if (count == arraySize) {
                         
                         numberArrayHolder.add(resultHolder)
                         
                    }
                    else if (array3Holder[count].toString() == "x2" && array3Holder[count + 1].toString() == "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder + "*")
                         
                         count += 1
                    }
                    else if (array3Holder[count].toString() == "x2" && array3Holder[count + 1].toString() != "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder + array3Holder[count + 1])
                         
                         count += 1
                    }
                    else if (array3Holder[count].toString() == "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder)
                         
                    }
                    else if (array3Holder[count].toString() == "M1") {
                         
                         numberArrayHolder.add(mem1Holder.toString())
                         
                    }
                    else if (array3Holder[count].toString() == "M2") {
                         
                         numberArrayHolder.add(mem2Holder.toString())
                         
                    }
                    else if (array3Holder[count].toString() == "M3") {
                         
                         numberArrayHolder.add(mem3Holder.toString())
                         
                    }
                    else if (array3Holder[count].toString() == "M4") {
                         
                         numberArrayHolder.add(mem4Holder.toString())
                         
                    }
                    else if (array3Holder[count].toString() == "M5") {
                         
                         numberArrayHolder.add(mem5Holder.toString())
                         
                    }
                    else if (array3Holder[count].toString() == "M6") {
                         
                         numberArrayHolder.add(mem6Holder.toString())
                         
                    }
                    else if (array3Holder[count].toString() == "M7") {
                         
                         numberArrayHolder.add(mem7Holder.toString())
                         
                    }
                    else if (array3Holder[count].toString() == "M8") {
                         
                         numberArrayHolder.add(mem8Holder.toString())
                         
                    }
                    else if (array3Holder[count].toString() == "M9") {
                         
                         numberArrayHolder.add(mem9Holder.toString())
                         
                    }
                    else if (array3Holder[count].toString() == "M10") {
                         
                         numberArrayHolder.add(mem10Holder.toString())
                         
                    }
                    else if (array3Holder[count].toString() == "M11") {
                         
                         numberArrayHolder.add(mem11Holder.toString())
                         
                    }
                    else if (array3Holder[count].toString() == "M12") {
                         
                         numberArrayHolder.add(mem12Holder.toString())
                         
                    }
                    else if (array3Holder[count].toString() == "M13") {
                         
                         numberArrayHolder.add(mem13Holder.toString())
                         
                    }
                    else if (array3Holder[count].toString() == "M14") {
                         
                         numberArrayHolder.add(mem14Holder.toString())
                         
                    }
                    else if (array3Holder[count].toString() == "M15") {
                         
                         numberArrayHolder.add(mem15Holder.toString())
                         
                    }
                    else {
                         
                         numberArrayHolder.add(resultHolder + array3Holder[count])
                    }
                    resultHolder = ""
                    processHolder = ""
                    result.value = "0"
                    
                    if (arraySize + 1 == numberArrayHolder.size) {
                         
                         resultHolder = numberArrayHolder.toString()
                         resultHolder = resultHolder.drop(1)
                         resultHolder = resultHolder.dropLast(1)
                         resultHolder = resultHolder.replace(
                              ",", ""
                         )
                         
                         val expression = ExpressionBuilder(resultHolder).build()
                         val processHolderResult : Double = expression.evaluate()
                         
                         if (processHolderResult.toString()
                                  .contains(".0")) {
                              
                              ansHolder =
                                  processHolderResult.toInt()
                                      .toString()
                              lastResult.value = ansHolder
                         }
                         else {
                              ansHolder = processHolderResult.toString()
                              lastResult.value = ansHolder
                         }
                         
                         numberArrayHolder.removeAll(numberArrayHolder)
                         count = -1
                         macroChoosed = "0"
                         arraySize = 0
                         macroRecordIsClicked = false
                         macroRecallIsClicked = false
                         macroSet = "0"
                         macroChoosed = "0"
                         resultHolder = "0"
                         macroContains = ""
                         macroContainsResult.value = macroContains
                         
                    }
                    Log.e(
                         "message", numberArrayHolder.toString()
                    )
                    processHolder = numberArrayHolder.toString()
                    processHolder = processHolder.drop(1)
                    processHolder = processHolder.dropLast(1)
                    processHolder = processHolder.replace(
                         ",", ""
                    )
                    proccessResult.value = processHolder
                    
               }
               else if (macroChoosed == "4") {
                    
                    count += 1
                    if (count == arraySize) {
                         
                         numberArrayHolder.add(resultHolder)
                         
                    }
                    else if (array4Holder[count].toString() == "x2" && array4Holder[count + 1].toString() == "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder + "*")
                         
                         count += 1
                    }
                    else if (array4Holder[count].toString() == "x2" && array4Holder[count + 1].toString() != "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder + array4Holder[count + 1])
                         
                         count += 1
                    }
                    else if (array4Holder[count].toString() == "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder)
                         
                    }
                    else if (array4Holder[count].toString() == "M1") {
                         
                         numberArrayHolder.add(mem1Holder.toString())
                         
                    }
                    else if (array4Holder[count].toString() == "M2") {
                         
                         numberArrayHolder.add(mem2Holder.toString())
                         
                    }
                    else if (array4Holder[count].toString() == "M3") {
                         
                         numberArrayHolder.add(mem3Holder.toString())
                         
                    }
                    else if (array4Holder[count].toString() == "M4") {
                         
                         numberArrayHolder.add(mem4Holder.toString())
                         
                    }
                    else if (array4Holder[count].toString() == "M5") {
                         
                         numberArrayHolder.add(mem5Holder.toString())
                         
                    }
                    else if (array4Holder[count].toString() == "M6") {
                         
                         numberArrayHolder.add(mem6Holder.toString())
                         
                    }
                    else if (array4Holder[count].toString() == "M7") {
                         
                         numberArrayHolder.add(mem7Holder.toString())
                         
                    }
                    else if (array4Holder[count].toString() == "M8") {
                         
                         numberArrayHolder.add(mem8Holder.toString())
                         
                    }
                    else if (array4Holder[count].toString() == "M9") {
                         
                         numberArrayHolder.add(mem9Holder.toString())
                         
                    }
                    else if (array4Holder[count].toString() == "M10") {
                         
                         numberArrayHolder.add(mem10Holder.toString())
                         
                    }
                    else if (array4Holder[count].toString() == "M11") {
                         
                         numberArrayHolder.add(mem11Holder.toString())
                         
                    }
                    else if (array4Holder[count].toString() == "M12") {
                         
                         numberArrayHolder.add(mem12Holder.toString())
                         
                    }
                    else if (array4Holder[count].toString() == "M13") {
                         
                         numberArrayHolder.add(mem13Holder.toString())
                         
                    }
                    else if (array4Holder[count].toString() == "M14") {
                         
                         numberArrayHolder.add(mem14Holder.toString())
                         
                    }
                    else if (array4Holder[count].toString() == "M15") {
                         
                         numberArrayHolder.add(mem15Holder.toString())
                         
                    }
                    else {
                         
                         numberArrayHolder.add(resultHolder + array4Holder[count])
                    }
                    resultHolder = ""
                    processHolder = ""
                    
                    result.value = "0"
                    
                    if (arraySize + 1 == numberArrayHolder.size) {
                         
                         resultHolder = numberArrayHolder.toString()
                         resultHolder = resultHolder.drop(1)
                         resultHolder = resultHolder.dropLast(1)
                         resultHolder = resultHolder.replace(
                              ",", ""
                         )
                         
                         val expression = ExpressionBuilder(resultHolder).build()
                         val processHolderResult : Double = expression.evaluate()
                         
                         if (processHolderResult.toString()
                                  .contains(".0")) {
                              
                              ansHolder =
                                  processHolderResult.toInt()
                                      .toString()
                              lastResult.value = ansHolder
                         }
                         else {
                              ansHolder = processHolderResult.toString()
                              lastResult.value = ansHolder
                         }
                         
                         numberArrayHolder.removeAll(numberArrayHolder)
                         count = -1
                         macroChoosed = "0"
                         arraySize = 0
                         macroRecordIsClicked = false
                         macroRecallIsClicked = false
                         macroSet = "0"
                         macroChoosed = "0"
                         resultHolder = "0"
                         macroContains = ""
                         macroContainsResult.value = macroContains
                         
                    }
                    Log.e(
                         "message", numberArrayHolder.toString()
                    )
                    processHolder = numberArrayHolder.toString()
                    processHolder = processHolder.drop(1)
                    processHolder = processHolder.dropLast(1)
                    processHolder = processHolder.replace(
                         ",", ""
                    )
                    proccessResult.value = processHolder
                    
               }
               else if (macroChoosed == "5") {
                    
                    count += 1
                    if (count == arraySize) {
                         
                         numberArrayHolder.add(resultHolder)
                         
                    }
                    else if (array5Holder[count].toString() == "x2" && array5Holder[count + 1].toString() == "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder + "*")
                         
                         count += 1
                    }
                    else if (array5Holder[count].toString() == "x2" && array5Holder[count + 1].toString() != "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder + array5Holder[count + 1])
                         
                         count += 1
                    }
                    else if (array5Holder[count].toString() == "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder)
                         
                    }
                    else if (array5Holder[count].toString() == "M1") {
                         
                         numberArrayHolder.add(mem1Holder.toString())
                         
                    }
                    else if (array5Holder[count].toString() == "M2") {
                         
                         numberArrayHolder.add(mem2Holder.toString())
                         
                    }
                    else if (array5Holder[count].toString() == "M3") {
                         
                         numberArrayHolder.add(mem3Holder.toString())
                         
                    }
                    else if (array5Holder[count].toString() == "M4") {
                         
                         numberArrayHolder.add(mem4Holder.toString())
                         
                    }
                    else if (array5Holder[count].toString() == "M5") {
                         
                         numberArrayHolder.add(mem5Holder.toString())
                         
                    }
                    else if (array5Holder[count].toString() == "M6") {
                         
                         numberArrayHolder.add(mem6Holder.toString())
                         
                    }
                    else if (array5Holder[count].toString() == "M7") {
                         
                         numberArrayHolder.add(mem7Holder.toString())
                         
                    }
                    else if (array5Holder[count].toString() == "M8") {
                         
                         numberArrayHolder.add(mem8Holder.toString())
                         
                    }
                    else if (array5Holder[count].toString() == "M9") {
                         
                         numberArrayHolder.add(mem9Holder.toString())
                         
                    }
                    else if (array5Holder[count].toString() == "M10") {
                         
                         numberArrayHolder.add(mem10Holder.toString())
                         
                    }
                    else if (array5Holder[count].toString() == "M11") {
                         
                         numberArrayHolder.add(mem11Holder.toString())
                         
                    }
                    else if (array5Holder[count].toString() == "M12") {
                         
                         numberArrayHolder.add(mem12Holder.toString())
                         
                    }
                    else if (array5Holder[count].toString() == "M13") {
                         
                         numberArrayHolder.add(mem13Holder.toString())
                         
                    }
                    else if (array5Holder[count].toString() == "M14") {
                         
                         numberArrayHolder.add(mem14Holder.toString())
                         
                    }
                    else if (array5Holder[count].toString() == "M15") {
                         
                         numberArrayHolder.add(mem15Holder.toString())
                         
                    }
                    else {
                         
                         numberArrayHolder.add(resultHolder + array5Holder[count])
                    }
                    resultHolder = ""
                    processHolder = ""
                    
                    result.value = "0"
                    
                    if (arraySize + 1 == numberArrayHolder.size) {
                         
                         resultHolder = numberArrayHolder.toString()
                         resultHolder = resultHolder.drop(1)
                         resultHolder = resultHolder.dropLast(1)
                         resultHolder = resultHolder.replace(
                              ",", ""
                         )
                         
                         val expression = ExpressionBuilder(resultHolder).build()
                         val processHolderResult : Double = expression.evaluate()
                         
                         if (processHolderResult.toString()
                                  .contains(".0")) {
                              
                              ansHolder =
                                  processHolderResult.toInt()
                                      .toString()
                              lastResult.value = ansHolder
                         }
                         else {
                              ansHolder = processHolderResult.toString()
                              lastResult.value = ansHolder
                         }
                         
                         numberArrayHolder.removeAll(numberArrayHolder)
                         count = -1
                         macroChoosed = "0"
                         arraySize = 0
                         macroRecordIsClicked = false
                         macroRecallIsClicked = false
                         macroSet = "0"
                         macroChoosed = "0"
                         resultHolder = "0"
                         macroContains = ""
                         macroContainsResult.value = macroContains
                         
                    }
                    Log.e(
                         "message", numberArrayHolder.toString()
                    )
                    processHolder = numberArrayHolder.toString()
                    processHolder = processHolder.drop(1)
                    processHolder = processHolder.dropLast(1)
                    processHolder = processHolder.replace(
                         ",", ""
                    )
                    proccessResult.value = processHolder
                    
               }
               else if (macroChoosed == "6") {
                    
                    count += 1
                    if (count == arraySize) {
                         
                         numberArrayHolder.add(resultHolder)
                         
                    }
                    else if (array6Holder[count].toString() == "x2" && array6Holder[count + 1].toString() == "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder + "*")
                         
                         count += 1
                    }
                    else if (array6Holder[count].toString() == "x2" && array6Holder[count + 1].toString() != "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder + array6Holder[count + 1])
                         
                         count += 1
                    }
                    else if (array6Holder[count].toString() == "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder)
                         
                    }
                    else if (array6Holder[count].toString() == "M1") {
                         
                         numberArrayHolder.add(mem1Holder.toString())
                         
                    }
                    else if (array6Holder[count].toString() == "M2") {
                         
                         numberArrayHolder.add(mem2Holder.toString())
                         
                    }
                    else if (array6Holder[count].toString() == "M3") {
                         
                         numberArrayHolder.add(mem3Holder.toString())
                         
                    }
                    else if (array6Holder[count].toString() == "M4") {
                         
                         numberArrayHolder.add(mem4Holder.toString())
                         
                    }
                    else if (array6Holder[count].toString() == "M5") {
                         
                         numberArrayHolder.add(mem5Holder.toString())
                         
                    }
                    else if (array6Holder[count].toString() == "M6") {
                         
                         numberArrayHolder.add(mem6Holder.toString())
                         
                    }
                    else if (array6Holder[count].toString() == "M7") {
                         
                         numberArrayHolder.add(mem7Holder.toString())
                         
                    }
                    else if (array6Holder[count].toString() == "M8") {
                         
                         numberArrayHolder.add(mem8Holder.toString())
                         
                    }
                    else if (array6Holder[count].toString() == "M9") {
                         
                         numberArrayHolder.add(mem9Holder.toString())
                         
                    }
                    else if (array6Holder[count].toString() == "M10") {
                         
                         numberArrayHolder.add(mem10Holder.toString())
                         
                    }
                    else if (array6Holder[count].toString() == "M11") {
                         
                         numberArrayHolder.add(mem11Holder.toString())
                         
                    }
                    else if (array6Holder[count].toString() == "M12") {
                         
                         numberArrayHolder.add(mem12Holder.toString())
                         
                    }
                    else if (array6Holder[count].toString() == "M13") {
                         
                         numberArrayHolder.add(mem13Holder.toString())
                         
                    }
                    else if (array6Holder[count].toString() == "M14") {
                         
                         numberArrayHolder.add(mem14Holder.toString())
                         
                    }
                    else if (array6Holder[count].toString() == "M15") {
                         
                         numberArrayHolder.add(mem15Holder.toString())
                         
                    }
                    else {
                         
                         numberArrayHolder.add(resultHolder + array6Holder[count])
                    }
                    resultHolder = ""
                    processHolder = ""
                    
                    result.value = "0"
                    
                    if (arraySize + 1 == numberArrayHolder.size) {
                         
                         resultHolder = numberArrayHolder.toString()
                         resultHolder = resultHolder.drop(1)
                         resultHolder = resultHolder.dropLast(1)
                         resultHolder = resultHolder.replace(
                              ",", ""
                         )
                         
                         val expression = ExpressionBuilder(resultHolder).build()
                         val processHolderResult : Double = expression.evaluate()
                         
                         if (processHolderResult.toString()
                                  .contains(".0")) {
                              
                              ansHolder =
                                  processHolderResult.toInt()
                                      .toString()
                              lastResult.value = ansHolder
                         }
                         else {
                              ansHolder = processHolderResult.toString()
                              lastResult.value = ansHolder
                         }
                         
                         numberArrayHolder.removeAll(numberArrayHolder)
                         count = -1
                         macroChoosed = "0"
                         arraySize = 0
                         macroRecordIsClicked = false
                         macroRecallIsClicked = false
                         macroSet = "0"
                         macroChoosed = "0"
                         resultHolder = "0"
                         macroContains = ""
                         macroContainsResult.value = macroContains
                         
                    }
                    Log.e(
                         "message", numberArrayHolder.toString()
                    )
                    processHolder = numberArrayHolder.toString()
                    processHolder = processHolder.drop(1)
                    processHolder = processHolder.dropLast(1)
                    processHolder = processHolder.replace(
                         ",", ""
                    )
                    proccessResult.value = processHolder
                    
               }
               else if (macroChoosed == "7") {
                    
                    count += 1
                    if (count == arraySize) {
                         
                         numberArrayHolder.add(resultHolder)
                         
                    }
                    else if (array7Holder[count].toString() == "x2" && array7Holder[count + 1].toString() == "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder + "*")
                         
                         count += 1
                    }
                    else if (array7Holder[count].toString() == "x2" && array7Holder[count + 1].toString() != "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder + array7Holder[count + 1])
                         
                         count += 1
                    }
                    else if (array7Holder[count].toString() == "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder)
                         
                    }
                    else if (array7Holder[count].toString() == "M1") {
                         
                         numberArrayHolder.add(mem1Holder.toString())
                         
                    }
                    else if (array7Holder[count].toString() == "M2") {
                         
                         numberArrayHolder.add(mem2Holder.toString())
                         
                    }
                    else if (array7Holder[count].toString() == "M3") {
                         
                         numberArrayHolder.add(mem3Holder.toString())
                         
                    }
                    else if (array7Holder[count].toString() == "M4") {
                         
                         numberArrayHolder.add(mem4Holder.toString())
                         
                    }
                    else if (array7Holder[count].toString() == "M5") {
                         
                         numberArrayHolder.add(mem5Holder.toString())
                         
                    }
                    else if (array7Holder[count].toString() == "M6") {
                         
                         numberArrayHolder.add(mem6Holder.toString())
                         
                    }
                    else if (array7Holder[count].toString() == "M7") {
                         
                         numberArrayHolder.add(mem7Holder.toString())
                         
                    }
                    else if (array7Holder[count].toString() == "M8") {
                         
                         numberArrayHolder.add(mem8Holder.toString())
                         
                    }
                    else if (array7Holder[count].toString() == "M9") {
                         
                         numberArrayHolder.add(mem9Holder.toString())
                         
                    }
                    else if (array7Holder[count].toString() == "M10") {
                         
                         numberArrayHolder.add(mem10Holder.toString())
                         
                    }
                    else if (array7Holder[count].toString() == "M11") {
                         
                         numberArrayHolder.add(mem11Holder.toString())
                         
                    }
                    else if (array7Holder[count].toString() == "M12") {
                         
                         numberArrayHolder.add(mem12Holder.toString())
                         
                    }
                    else if (array7Holder[count].toString() == "M13") {
                         
                         numberArrayHolder.add(mem13Holder.toString())
                         
                    }
                    else if (array7Holder[count].toString() == "M14") {
                         
                         numberArrayHolder.add(mem14Holder.toString())
                         
                    }
                    else if (array7Holder[count].toString() == "M15") {
                         
                         numberArrayHolder.add(mem15Holder.toString())
                         
                    }
                    else {
                         
                         numberArrayHolder.add(resultHolder + array7Holder[count])
                    }
                    resultHolder = ""
                    processHolder = ""
                    
                    result.value = "0"
                    
                    if (arraySize + 1 == numberArrayHolder.size) {
                         
                         resultHolder = numberArrayHolder.toString()
                         resultHolder = resultHolder.drop(1)
                         resultHolder = resultHolder.dropLast(1)
                         resultHolder = resultHolder.replace(
                              ",", ""
                         )
                         
                         val expression = ExpressionBuilder(resultHolder).build()
                         val processHolderResult : Double = expression.evaluate()
                         
                         if (processHolderResult.toString()
                                  .contains(".0")) {
                              
                              ansHolder =
                                  processHolderResult.toInt()
                                      .toString()
                              lastResult.value = ansHolder
                         }
                         else {
                              ansHolder = processHolderResult.toString()
                              lastResult.value = ansHolder
                         }
                         
                         numberArrayHolder.removeAll(numberArrayHolder)
                         count = -1
                         macroChoosed = "0"
                         arraySize = 0
                         macroRecordIsClicked = false
                         macroRecallIsClicked = false
                         macroSet = "0"
                         macroChoosed = "0"
                         resultHolder = "0"
                         macroContains = ""
                         macroContainsResult.value = macroContains
                         
                    }
                    Log.e(
                         "message", numberArrayHolder.toString()
                    )
                    processHolder = numberArrayHolder.toString()
                    processHolder = processHolder.drop(1)
                    processHolder = processHolder.dropLast(1)
                    processHolder = processHolder.replace(
                         ",", ""
                    )
                    proccessResult.value = processHolder
                    
               }
               else if (macroChoosed == "8") {
                    
                    count += 1
                    if (count == arraySize) {
                         
                         numberArrayHolder.add(resultHolder)
                         
                    }
                    else if (array8Holder[count].toString() == "x2" && array8Holder[count + 1].toString() == "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder + "*")
                         
                         count += 1
                    }
                    else if (array8Holder[count].toString() == "x2" && array8Holder[count + 1].toString() != "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder + array8Holder[count + 1])
                         
                         count += 1
                    }
                    else if (array8Holder[count].toString() == "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder)
                         
                    }
                    else if (array8Holder[count].toString() == "M1") {
                         
                         numberArrayHolder.add(mem1Holder.toString())
                         
                    }
                    else if (array8Holder[count].toString() == "M2") {
                         
                         numberArrayHolder.add(mem2Holder.toString())
                         
                    }
                    else if (array8Holder[count].toString() == "M3") {
                         
                         numberArrayHolder.add(mem3Holder.toString())
                         
                    }
                    else if (array8Holder[count].toString() == "M4") {
                         
                         numberArrayHolder.add(mem4Holder.toString())
                         
                    }
                    else if (array8Holder[count].toString() == "M5") {
                         
                         numberArrayHolder.add(mem5Holder.toString())
                         
                    }
                    else if (array8Holder[count].toString() == "M6") {
                         
                         numberArrayHolder.add(mem6Holder.toString())
                         
                    }
                    else if (array8Holder[count].toString() == "M7") {
                         
                         numberArrayHolder.add(mem7Holder.toString())
                         
                    }
                    else if (array8Holder[count].toString() == "M8") {
                         
                         numberArrayHolder.add(mem8Holder.toString())
                         
                    }
                    else if (array8Holder[count].toString() == "M9") {
                         
                         numberArrayHolder.add(mem9Holder.toString())
                         
                    }
                    else if (array8Holder[count].toString() == "M10") {
                         
                         numberArrayHolder.add(mem10Holder.toString())
                         
                    }
                    else if (array8Holder[count].toString() == "M11") {
                         
                         numberArrayHolder.add(mem11Holder.toString())
                         
                    }
                    else if (array8Holder[count].toString() == "M12") {
                         
                         numberArrayHolder.add(mem12Holder.toString())
                         
                    }
                    else if (array8Holder[count].toString() == "M13") {
                         
                         numberArrayHolder.add(mem13Holder.toString())
                         
                    }
                    else if (array8Holder[count].toString() == "M14") {
                         
                         numberArrayHolder.add(mem14Holder.toString())
                         
                    }
                    else if (array8Holder[count].toString() == "M15") {
                         
                         numberArrayHolder.add(mem15Holder.toString())
                         
                    }
                    else {
                         
                         numberArrayHolder.add(resultHolder + array8Holder[count])
                    }
                    resultHolder = ""
                    processHolder = ""
                    
                    result.value = "0"
                    
                    if (arraySize + 1 == numberArrayHolder.size) {
                         
                         resultHolder = numberArrayHolder.toString()
                         resultHolder = resultHolder.drop(1)
                         resultHolder = resultHolder.dropLast(1)
                         resultHolder = resultHolder.replace(
                              ",", ""
                         )
                         
                         val expression = ExpressionBuilder(resultHolder).build()
                         val processHolderResult : Double = expression.evaluate()
                         
                         if (processHolderResult.toString()
                                  .contains(".0")) {
                              
                              ansHolder =
                                  processHolderResult.toInt()
                                      .toString()
                              lastResult.value = ansHolder
                         }
                         else {
                              ansHolder = processHolderResult.toString()
                              lastResult.value = ansHolder
                         }
                         
                         numberArrayHolder.removeAll(numberArrayHolder)
                         count = -1
                         macroChoosed = "0"
                         arraySize = 0
                         macroRecordIsClicked = false
                         macroRecallIsClicked = false
                         macroSet = "0"
                         macroChoosed = "0"
                         resultHolder = "0"
                         macroContains = ""
                         macroContainsResult.value = macroContains
                         
                    }
                    Log.e(
                         "message", numberArrayHolder.toString()
                    )
                    processHolder = numberArrayHolder.toString()
                    processHolder = processHolder.drop(1)
                    processHolder = processHolder.dropLast(1)
                    processHolder = processHolder.replace(
                         ",", ""
                    )
                    proccessResult.value = processHolder
                    
               }
               else if (macroChoosed == "9") {
                    
                    count += 1
                    if (count == arraySize) {
                         
                         numberArrayHolder.add(resultHolder)
                         
                    }
                    else if (array9Holder[count].toString() == "x2" && array9Holder[count + 1].toString() == "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder + "*")
                         
                         count += 1
                    }
                    else if (array9Holder[count].toString() == "x2" && array9Holder[count + 1].toString() != "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder + array9Holder[count + 1])
                         
                         count += 1
                    }
                    else if (array9Holder[count].toString() == "x2") {
                         
                         numberArrayHolder.add(resultHolder + "*")
                         numberArrayHolder.add(resultHolder)
                         
                    }
                    else if (array9Holder[count].toString() == "M1") {
                         
                         numberArrayHolder.add(mem1Holder.toString())
                         
                    }
                    else if (array9Holder[count].toString() == "M2") {
                         
                         numberArrayHolder.add(mem2Holder.toString())
                         
                    }
                    else if (array9Holder[count].toString() == "M3") {
                         
                         numberArrayHolder.add(mem3Holder.toString())
                         
                    }
                    else if (array9Holder[count].toString() == "M4") {
                         
                         numberArrayHolder.add(mem4Holder.toString())
                         
                    }
                    else if (array9Holder[count].toString() == "M5") {
                         
                         numberArrayHolder.add(mem5Holder.toString())
                         
                    }
                    else if (array9Holder[count].toString() == "M6") {
                         
                         numberArrayHolder.add(mem6Holder.toString())
                         
                    }
                    else if (array9Holder[count].toString() == "M7") {
                         
                         numberArrayHolder.add(mem7Holder.toString())
                         
                    }
                    else if (array9Holder[count].toString() == "M8") {
                         
                         numberArrayHolder.add(mem8Holder.toString())
                         
                    }
                    else if (array9Holder[count].toString() == "M9") {
                         
                         numberArrayHolder.add(mem9Holder.toString())
                         
                    }
                    else if (array9Holder[count].toString() == "M10") {
                         
                         numberArrayHolder.add(mem10Holder.toString())
                         
                    }
                    else if (array9Holder[count].toString() == "M11") {
                         
                         numberArrayHolder.add(mem11Holder.toString())
                         
                    }
                    else if (array9Holder[count].toString() == "M12") {
                         
                         numberArrayHolder.add(mem12Holder.toString())
                         
                    }
                    else if (array9Holder[count].toString() == "M13") {
                         
                         numberArrayHolder.add(mem13Holder.toString())
                         
                    }
                    else if (array9Holder[count].toString() == "M14") {
                         
                         numberArrayHolder.add(mem14Holder.toString())
                         
                    }
                    else if (array9Holder[count].toString() == "M15") {
                         
                         numberArrayHolder.add(mem15Holder.toString())
                         
                    }
                    else {
                         
                         numberArrayHolder.add(resultHolder + array9Holder[count])
                    }
                    resultHolder = ""
                    processHolder = ""
                    
                    result.value = "0"
                    
                    if (arraySize + 1 == numberArrayHolder.size) {
                         
                         resultHolder = numberArrayHolder.toString()
                         resultHolder = resultHolder.drop(1)
                         resultHolder = resultHolder.dropLast(1)
                         resultHolder = resultHolder.replace(
                              ",", ""
                         )
                         
                         val expression = ExpressionBuilder(resultHolder).build()
                         val processHolderResult : Double = expression.evaluate()
                         
                         if (processHolderResult.toString()
                                  .contains(".0")) {
                              
                              ansHolder =
                                  processHolderResult.toInt()
                                      .toString()
                              lastResult.value = ansHolder
                         }
                         else {
                              ansHolder = processHolderResult.toString()
                              lastResult.value = ansHolder
                         }
                         
                         numberArrayHolder.removeAll(numberArrayHolder)
                         count = -1
                         macroChoosed = "0"
                         arraySize = 0
                         macroRecordIsClicked = false
                         macroRecallIsClicked = false
                         macroSet = "0"
                         macroChoosed = "0"
                         resultHolder = "0"
                         macroContains = ""
                         macroContainsResult.value = macroContains
                         
                    }
                    Log.e(
                         "message", numberArrayHolder.toString()
                    )
                    processHolder = numberArrayHolder.toString()
                    processHolder = processHolder.drop(1)
                    processHolder = processHolder.dropLast(1)
                    processHolder = processHolder.replace(
                         ",", ""
                    )
                    proccessResult.value = processHolder
                    
               }
               else if (macroRecordIsClicked) {
                    
                    if (macroSet == "1") {
                         
                         array1Holder.add("+")
                         Log.e(
                              "array", array1Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array1Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "2") {
                         
                         array2Holder.add("+")
                         Log.e(
                              "array", array2Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array2Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "3") {
                         
                         array3Holder.add("+")
                         Log.e(
                              "array", array3Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array3Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "4") {
                         
                         array4Holder.add("+")
                         Log.e(
                              "array", array4Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array4Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "5") {
                         
                         array5Holder.add("+")
                         Log.e(
                              "array", array5Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array5Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "6") {
                         
                         array6Holder.add("+")
                         Log.e(
                              "array", array6Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array6Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "7") {
                         
                         array7Holder.add("+")
                         Log.e(
                              "array", array7Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array7Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "8") {
                         
                         array8Holder.add("+")
                         Log.e(
                              "array", array8Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array8Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "9") {
                         
                         array9Holder.add("+")
                         Log.e(
                              "array", array9Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array9Holder.size.toString()
                         )
                    }
                    
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "1") {
                    falsiMethodIsClickedCount = 2
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "2") {
                    falsiMethodIsClickedCount = 3
               }
               else if (falsiMethodIsClicked && falsiMethodIsClickedCount.toString() == "3") {
                    falsiMethodIsClickedCount = 0
               }
               else if (falsiMethodIsClicked) {
                    if (firstOperation!!.isEmpty()) {
                         firstOperation = "+"
                         firstOperationResult.value = firstOperation
                    }
                    else if (firstOperation!!.isNotEmpty() && secondOperation!!.isEmpty()) {
                         secondOperation = "+"
                         secondOperationResult.value = secondOperation
                    }
                    else {
                         thirdOperation = "+"
                         thirdOperationResult.value = thirdOperation
                    }
               }
               else {
                    isClickedCount += 1
                    symbolClicked = "+"
                    
                    try {
                         if (processHolder.isEmpty()) {
                              
                              processHolder = ""
                              isClickedCount = 0
                              
                         }
                         else {
                              
                              if (isClickedCount == 2) {
                                   
                                   val expression = ExpressionBuilder(processHolder).build()
                                   val processHolderResult = expression.evaluate()
                                   if (processHolderResult.toString()
                                            .contains(".0")) {
                                        
                                        processHolder =
                                            processHolderResult.toInt()
                                                .toString()
                                        isClickedCount = 1
                                   }
                                   else {
                                        processHolder =
                                            processHolderResult.toDouble()
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
                    catch (e : Exception) {
                         
                         processHolder = processHolder.dropLast(1)
                         processHolder = processHolder.plus(symbolClicked)
                         
                         proccessResult.value = processHolder
                         
                    }
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
          
     }
     
     fun minus() {
          try {
               
               isClicked = false
               if (macroRecordIsClicked) {
                    
                    if (macroSet == "1") {
                         
                         array1Holder.add("-")
                         Log.e(
                              "array", array1Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array1Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "2") {
                         
                         array2Holder.add("-")
                         Log.e(
                              "array", array2Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array2Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "3") {
                         
                         array3Holder.add("-")
                         Log.e(
                              "array", array3Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array3Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "4") {
                         
                         array4Holder.add("-")
                         Log.e(
                              "array", array4Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array4Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "5") {
                         
                         array5Holder.add("-")
                         Log.e(
                              "array", array5Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array5Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "6") {
                         
                         array6Holder.add("-")
                         Log.e(
                              "array", array6Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array6Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "7") {
                         
                         array7Holder.add("-")
                         Log.e(
                              "array", array7Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array7Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "8") {
                         
                         array8Holder.add("-")
                         Log.e(
                              "array", array8Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array8Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "9") {
                         
                         array9Holder.add("-")
                         Log.e(
                              "array", array9Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array9Holder.size.toString()
                         )
                    }
                    
               }
               else if (falsiMethodIsClicked) {
                    if (falsiMethodIsClickedCount == 1) {
                         if (lowVal.contains('-')) {
                         }
                         else {
                              lowVal = "-" + lowVal
                              lowValResult.value = lowVal
                         }
                    }
                    if (falsiMethodIsClickedCount == 2) {
                         if (highVal.contains('-')) {
                         }
                         else {
                              highVal = "-" + highVal
                              highValResult.value = highVal
                         }
                    }
                    if (falsiMethodIsClickedCount == 3) {
                         if (precision.contains('-')) {
                         }
                         else {
                              precision = "-" + precision
                              precissionResult.value = precision
                         }
                    }
                    else if (falsiMethodIsClickedCount == 0) {
                         if (falsiNum1Holder!!.isEmpty()) {
                              falsiNum1Holder = falsiNum1Holder.plus("-")
                              quadraticNum1Result.value = falsiNum1Holder
                         }
                         else if (firstOperation!!.isEmpty()) {
                              firstOperation = "-"
                              firstOperationResult.value = firstOperation
                         }
                         else if (firstOperation!!.isNotEmpty() && secondOperation!!.isEmpty()) {
                              secondOperation = "-"
                              secondOperationResult.value = secondOperation
                         }
                         else {
                              thirdOperation = "-"
                              thirdOperationResult.value = thirdOperation
                         }
                    }
               }
               else {
                    isClickedCount += 1
                    symbolClicked = "-"
                    try {
                         if (processHolder.isEmpty()) {
                              
                              processHolder = ""
                              isClickedCount = 0
                              
                         }
                         else {
                              
                              if (isClickedCount == 2) {
                                   
                                   val expression = ExpressionBuilder(processHolder).build()
                                   val processHolderResult = expression.evaluate()
                                   if (processHolderResult.toString()
                                            .contains(".0")) {
                                        
                                        processHolder =
                                            processHolderResult.toInt()
                                                .toString()
                                        isClickedCount = 1
                                   }
                                   else {
                                        processHolder =
                                            processHolderResult.toDouble()
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
                    catch (e : Exception) {
                         
                         processHolder = processHolder.dropLast(1)
                         processHolder = processHolder.plus(symbolClicked)
                         
                         proccessResult.value = processHolder
                         
                    }
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun multiply() {
          try {
               
               isClicked = false
               if (macroRecordIsClicked) {
                    
                    if (macroSet == "1") {
                         
                         array1Holder.add("*")
                         Log.e(
                              "array", array1Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array1Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "2") {
                         
                         array2Holder.add("*")
                         Log.e(
                              "array", array2Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array2Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "3") {
                         
                         array3Holder.add("*")
                         Log.e(
                              "array", array3Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array3Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "4") {
                         
                         array4Holder.add("*")
                         Log.e(
                              "array", array4Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array4Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "5") {
                         
                         array5Holder.add("*")
                         Log.e(
                              "array", array5Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array5Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "6") {
                         
                         array6Holder.add("*")
                         Log.e(
                              "array", array6Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array6Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "7") {
                         
                         array7Holder.add("*")
                         Log.e(
                              "array", array7Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array7Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "8") {
                         
                         array8Holder.add("*")
                         Log.e(
                              "array", array8Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array8Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "9") {
                         
                         array9Holder.add("*")
                         Log.e(
                              "array", array9Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array9Holder.size.toString()
                         )
                    }
                    
               }
               else {
                    
                    isClickedCount += 1
                    symbolClicked = "*"
                    
                    try {
                         if (processHolder.isEmpty()) {
                              
                              processHolder = ""
                              isClickedCount = 0
                              
                         }
                         else {
                              
                              if (isClickedCount == 2) {
                                   
                                   val expression = ExpressionBuilder(processHolder).build()
                                   val processHolderResult = expression.evaluate()
                                   if (processHolderResult.toString()
                                            .contains(".0")) {
                                        
                                        processHolder =
                                            processHolderResult.toInt()
                                                .toString()
                                        isClickedCount = 1
                                   }
                                   else {
                                        processHolder =
                                            processHolderResult.toDouble()
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
                    catch (e : Exception) {
                         
                         processHolder = processHolder.dropLast(1)
                         processHolder = processHolder.plus(symbolClicked)
                         
                         proccessResult.value = processHolder
                         
                    }
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun divide() {
          try {
               if (falsiMethodIsClicked) {
                    if (firstOperation!!.isEmpty()) {
                         x1 = "x???"
                         x1Result.value = x1
                    }
                    else {
                         x2 = "x???"
                         x2Result.value = x2
                    }
               }
               else {
                    isClicked = false
                    if (macroRecordIsClicked) {
                         
                         if (macroSet == "1") {
                              
                              array1Holder.add("/")
                              Log.e(
                                   "array", array1Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array1Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "2") {
                              
                              array2Holder.add("/")
                              Log.e(
                                   "array", array2Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array2Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "3") {
                              
                              array3Holder.add("/")
                              Log.e(
                                   "array", array3Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array3Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "4") {
                              
                              array4Holder.add("/")
                              Log.e(
                                   "array", array4Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array4Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "5") {
                              
                              array5Holder.add("/")
                              Log.e(
                                   "array", array5Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array5Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "6") {
                              
                              array6Holder.add("/")
                              Log.e(
                                   "array", array6Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array6Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "7") {
                              
                              array7Holder.add("/")
                              Log.e(
                                   "array", array7Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array7Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "8") {
                              
                              array8Holder.add("/")
                              Log.e(
                                   "array", array8Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array8Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "9") {
                              
                              array9Holder.add("/")
                              Log.e(
                                   "array", array9Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array9Holder.size.toString()
                              )
                         }
                         
                    }
                    else {
                         isClickedCount += 1
                         symbolClicked = "/"
                         
                         try {
                              if (processHolder.isEmpty()) {
                                   
                                   processHolder = ""
                                   isClickedCount = 0
                                   
                              }
                              else {
                                   
                                   if (isClickedCount == 2) {
                                        
                                        val expression = ExpressionBuilder(processHolder).build()
                                        val processHolderResult = expression.evaluate()
                                        if (processHolderResult.toString()
                                                 .contains(".0")) {
                                             
                                             processHolder =
                                                 processHolderResult.toInt()
                                                     .toString()
                                             isClickedCount = 1
                                        }
                                        else {
                                             processHolder =
                                                 processHolderResult.toDouble()
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
                         catch (e : Exception) {
                              
                              processHolder = processHolder.dropLast(1)
                              processHolder = processHolder.plus(symbolClicked)
                              
                              proccessResult.value = processHolder
                              
                         }
                    }
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun percent() {
          try {
               isClicked = true
               
               if (falsiMethodIsClicked) {
                    if (firstOperation!!.isEmpty()) {
                         x1 = "x??"
                         x1Result.value = x1
                    }
                    else if (secondOperation!!.isEmpty()) {
                         x2 = "x??"
                         x2Result.value = x2
                    }
                    else {
                         x3 = "x??"
                         x3Result.value = x3
                    }
               }
               else {
                    
                    resultHolderLenght = resultHolder.length
                    when {
                         resultHolder.isEmpty() || resultHolder == "Error" -> {
                              resultHolder = "Error"
                         }
                         resultHolder == "0" -> {
                         
                         }
                         else -> {
                              floatHolder = resultHolder.toFloat() / 100
                              if (floatHolder.toString()
                                       .contains(".00")) {
                                   
                                   longHolder = floatHolder.toLong()
                                   resultHolder = longHolder.toString()
                                   isClicked = false
                              }
                              else {
                                   resultHolder = floatHolder.toString()
                                   isClicked =
                                       false // processHolder = processHolder.dropLast(1) + intHolder.toString()
                              }
                         }
                    }
                    
                    if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains("*") || processHolder.contains(
                              "/"
                         )) {
                         
                         processHolder = processHolder.dropLast(resultHolderLenght)
                         processHolder += resultHolder
                         proccessResult.value = processHolder
                         Log.e(
                              "lenght", resultHolderLenght.toString()
                         )
                         
                    }
                    else {
                         processHolder = resultHolder
                         proccessResult.value = processHolder
                    }
                    result.value = resultHolder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun power2() {
          try {
               if (falsiMethodIsClicked) {
                    if (firstOperation!!.isEmpty()) {
                         x1 = "x"
                         x1Result.value = x1
                    }
                    else if (secondOperation!!.isEmpty()) {
                         x2 = "x"
                         x2Result.value = x2
                    }
                    else {
                         x3 = "x"
                         x3Result.value = x3
                    }
               }
               else {
                    
                    isClicked = true
                    
                    isClicked = false
                    if (macroRecordIsClicked) {
                         
                         if (macroSet == "1") {
                              
                              array1Holder.add("x2")
                              Log.e(
                                   "array", array1Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array1Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "2") {
                              
                              array2Holder.add("x2")
                              Log.e(
                                   "array", array2Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array2Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "3") {
                              
                              array3Holder.add("x2")
                              Log.e(
                                   "array", array3Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array3Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "4") {
                              
                              array4Holder.add("x2")
                              Log.e(
                                   "array", array4Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array4Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "5") {
                              
                              array5Holder.add("x2")
                              Log.e(
                                   "array", array5Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array5Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "6") {
                              
                              array6Holder.add("x2")
                              Log.e(
                                   "array", array6Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array6Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "7") {
                              
                              array7Holder.add("x2")
                              Log.e(
                                   "array", array7Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array7Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "8") {
                              
                              array8Holder.add("x2")
                              Log.e(
                                   "array", array8Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array8Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "9") {
                              
                              array9Holder.add("x2")
                              Log.e(
                                   "array", array9Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array9Holder.size.toString()
                              )
                         }
                         
                    }
                    else {
                         resultHolderLenght = resultHolder.length
                         
                         if (resultHolder.isEmpty() || resultHolder == "Error") {
                              resultHolder = "Error"
                         }
                         else if (resultHolder == "0") {
                              result.value = resultHolder
                         }
                         else {
                              if (resultHolder.toString()
                                       .contains(".")) {
                                   
                                   floatHolder = resultHolder.toFloat() * resultHolder.toFloat()
                                   resultHolder = floatHolder.toString()
                                   isClicked = false
                              }
                              else {
                                   longHolder = resultHolder.toLong() * resultHolder.toLong()
                                   resultHolder = longHolder.toString()
                                   isClicked =
                                       false // processHolder = processHolder.dropLast(1) + intHolder.toString()
                              }
                         }
                         
                         
                         if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains("*") || processHolder.contains(
                                   "/"
                              )) {
                              
                              processHolder = processHolder.dropLast(resultHolderLenght)
                              processHolder += resultHolder
                              proccessResult.value = processHolder
                              Log.e(
                                   "lenght", resultHolderLenght.toString()
                              )
                              
                         }
                         else {
                              processHolder = resultHolder
                              proccessResult.value = processHolder
                         }
                         
                         result.value = resultHolder // proccessResult.value = processHolder
                    }
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun power3() {
          try {
               if (falsiMethodIsClicked) {
                    if (firstOperation!!.isEmpty()) {
                         x1 = "x??"
                         x1Result.value = x1
                    }
                    else if (secondOperation!!.isEmpty()) {
                         x2 = "x??"
                         x2Result.value = x2
                    }
                    else {
                         x3 = "x??"
                         x3Result.value = x3
                    }
               }
               else {
                    isClicked = true
                    
                    resultHolderLenght = resultHolder.length
                    
                    if (macroRecordIsClicked) {
                         
                         if (macroSet == "1") {
                              
                              array1Holder.add("x3")
                              Log.e(
                                   "array", array1Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array1Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "2") {
                              
                              array2Holder.add("x3")
                              Log.e(
                                   "array", array2Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array2Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "3") {
                              
                              array3Holder.add("x3")
                              Log.e(
                                   "array", array3Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array3Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "4") {
                              
                              array4Holder.add("x3")
                              Log.e(
                                   "array", array4Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array4Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "5") {
                              
                              array5Holder.add("x3")
                              Log.e(
                                   "array", array5Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array5Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "6") {
                              
                              array6Holder.add("x3")
                              Log.e(
                                   "array", array6Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array6Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "7") {
                              
                              array7Holder.add("x3")
                              Log.e(
                                   "array", array7Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array7Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "8") {
                              
                              array8Holder.add("x3")
                              Log.e(
                                   "array", array8Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array8Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "9") {
                              
                              array9Holder.add("x3")
                              Log.e(
                                   "array", array9Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array9Holder.size.toString()
                              )
                         }
                         
                    }
                    else {
                         
                         when {
                              resultHolder.isEmpty() || resultHolder == "Error" -> {
                                   resultHolder = "Error"
                              }
                              resultHolder == "0" -> {
                              }
                              else -> {
                                   
                                   if (resultHolder.toString()
                                            .contains(".")) {
                                        
                                        floatHolder =
                                            resultHolder.toFloat() * resultHolder.toFloat() * resultHolder.toFloat()
                                        resultHolder = floatHolder.toString()
                                        isClicked = false
                                   }
                                   else {
                                        longHolder =
                                            resultHolder.toLong() * resultHolder.toLong() * resultHolder.toLong()
                                        resultHolder = longHolder.toString()
                                        isClicked =
                                            false // processHolder = processHolder.dropLast(1) + intHolder.toString()
                                   }
                              }
                         }
                         if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains("*") || processHolder.contains(
                                   "/"
                              )) {
                              
                              processHolder = processHolder.dropLast(resultHolderLenght)
                              processHolder += resultHolder
                              proccessResult.value = processHolder
                              Log.e(
                                   "lenght", resultHolderLenght.toString()
                              )
                              
                         }
                         else {
                              processHolder = resultHolder
                              proccessResult.value = processHolder
                         }
                         
                         result.value = resultHolder //proccessResult.value = processHolder
                    }
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun squareRoot() {
          try {
               
               if (falsiMethodIsClicked) {
                    if (firstOperation!!.isEmpty()) {
                         x1 = "x???"
                         x1Result.value = x1
                    }
                    else {
                         x2 = "x???"
                         x2Result.value = x2
                    }
               }
               else {
                    
                    isClicked = true
                    resultHolderLenght = resultHolder.length
                    when {
                         resultHolder.isEmpty() || resultHolder == "Error" -> {
                              resultHolder = "Error"
                         }
                         resultHolder == "0" -> {
                         }
                         else -> {
                              isClicked = false
                              floatHolder =
                                  kotlin.math.sqrt(resultHolder.toDouble())
                                      .toFloat()
                              
                              if (floatHolder.toString()
                                       .contains(".0")) {
                                   
                                   longHolder = floatHolder.toLong()
                                   resultHolder = longHolder.toString()
                              }
                              else {
                                   resultHolder = floatHolder.toString()
                                   
                              }
                              
                         }
                    }
                    if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains("*") || processHolder.contains(
                              "/"
                         )) {
                         
                         processHolder = processHolder.dropLast(resultHolderLenght)
                         processHolder += resultHolder
                         proccessResult.value = processHolder
                         Log.e(
                              "lenght", resultHolderLenght.toString()
                         )
                         
                    }
                    else {
                         processHolder = resultHolder
                         proccessResult.value = processHolder
                    }
                    
                    result.value = resultHolder
                    
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun memoryRecord() {
          try {
               memRecordIsClicked = true
               processHolder = ""
               proccessResult.value = processHolder
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun memoryClear() {
          memCLearIsClicked = true
     }
     
     fun macroRecord() {
          
          macroRecordIsClicked = true
          processHolder = ""
          resultHolder = "0"
          result.value = resultHolder
          proccessResult.value = processHolder
     }
     
     fun macroClear() {
          macroClearIsClicked = true
     }
     
     fun macroStopRecord() {
          macroRecordIsClicked = false
          macroSet = ""
     }
     
     fun macroRecall() {
          macroRecallIsClicked = true
     }
     
     fun mem1() {
          try {
               if (macroRecordIsClicked) {
                    
                    if (macroRecordIsClicked) {
                         
                         if (macroSet == "1") {
                              
                              array1Holder.add("M1")
                              Log.e(
                                   "array", array1Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array1Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "2") {
                              
                              array2Holder.add("M1")
                              Log.e(
                                   "array", array2Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array2Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "3") {
                              
                              array3Holder.add("M1")
                              Log.e(
                                   "array", array3Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array3Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "4") {
                              
                              array4Holder.add("M1")
                              Log.e(
                                   "array", array4Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array4Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "5") {
                              
                              array5Holder.add("M1")
                              Log.e(
                                   "array", array5Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array5Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "6") {
                              
                              array6Holder.add("M1")
                              Log.e(
                                   "array", array6Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array6Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "7") {
                              
                              array7Holder.add("M1")
                              Log.e(
                                   "array", array7Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array7Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "8") {
                              
                              array8Holder.add("M1")
                              Log.e(
                                   "array", array8Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array8Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "9") {
                              
                              array9Holder.add("M1")
                              Log.e(
                                   "array", array9Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array9Holder.size.toString()
                              )
                         }
                    }
               }
               else if (falsiMethodIsClicked) {
                    
                    if (memRecordIsClicked) {
                         mem1FalsiHolder.clear()
                         
                         mem1FalsiHolder.add(falsiNum1Holder.toString())
                         mem1FalsiHolder.add(x1.toString())
                         mem1FalsiHolder.add(firstOperation.toString())
                         mem1FalsiHolder.add(falsiNum2Holder.toString())
                         mem1FalsiHolder.add(x2.toString())
                         mem1FalsiHolder.add(secondOperation.toString())
                         mem1FalsiHolder.add(falsiNum3Holder.toString())
                         mem1FalsiHolder.add(x3.toString())
                         mem1FalsiHolder.add(thirdOperation.toString())
                         mem1FalsiHolder.add(falsiNum4Holder.toString())
                         
                         
                         Log.e("message", mem1FalsiHolder.toString())
                         mem1Value.value =
                             mem1FalsiHolder.toString()
                                 .dropLast(1)
                                 .drop(1)
                                 .replace(",", "")
                                 .replace(" ", "")
                         mem1Holder = ""
                         mem1FalsiHolder.add(lowVal.toString())
                         mem1FalsiHolder.add(highVal.toString())
                         mem1FalsiHolder.add(precision.toString())
                         memRecordIsClicked = false
                    }
                    
                    if (mem1FalsiHolder.isNotEmpty() && !memRecordIsClicked) {
                         Log.e("message", mem1FalsiHolder.toString())
                         secondOperation = mem1FalsiHolder[5].toString()
                         falsiNum3Holder = mem1FalsiHolder[6].toString()
                         falsiNum1Holder = mem1FalsiHolder[0].toString()
                         x1 = mem1FalsiHolder[1].toString()
                         firstOperation = mem1FalsiHolder[2].toString()
                         falsiNum2Holder = mem1FalsiHolder[3].toString()
                         x2 = mem1FalsiHolder[4].toString()
                         x3 = mem1FalsiHolder[7].toString()
                         thirdOperation = mem1FalsiHolder[8].toString()
                         falsiNum4Holder = mem1FalsiHolder[9].toString()
                         lowVal = mem1FalsiHolder[10].toString()
                         highVal = mem1FalsiHolder[11].toString()
                         precision = mem1FalsiHolder[12].toString()
                         
                    }
                    else {
                         
                         if (falsiNum1Holder!!.isEmpty()) {
                              falsiNum1Holder = mem1Holder.toString()
                              quadraticNum1Result.value = falsiNum1Holder
                         }
                         else if (firstOperation!!.isEmpty()) {
                              if (mem1Holder.toString()
                                       .contains("-")) {
                                   
                                   firstOperation = "-"
                                   stringHolder = mem1Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                                   
                              }
                              else {
                                   firstOperation = "+"
                                   stringHolder = mem1Holder
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                              }
                         }
                         else if (secondOperation!!.isEmpty()) {
                              
                              if (mem1Holder.toString()
                                       .contains("-")) {
                                   secondOperation = "-"
                                   stringHolder = mem1Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                                   
                              }
                              else {
                                   secondOperation = "+"
                                   stringHolder = mem1Holder
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                              }
                         }
                         else {
                              if (mem1Holder.toString()
                                       .contains("-")) {
                                   
                                   thirdOperation = "-"
                                   stringHolder = mem1Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                                   
                              }
                              else {
                                   thirdOperation = "+"
                                   stringHolder = mem1Holder
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                              }
                              
                              if (falsiMethodIsClickedCount == 1) {
                                   lowVal = mem1Holder.toString()
                                   lowValResult.value = lowVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 2) {
                                   highVal = mem1Holder.toString()
                                   highValResult.value = highVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 3) {
                                   precision = mem1Holder.toString()
                                   precissionResult.value = precision
                              }
                         }
                    }
                    
                    
                    
                    
                    if (memCLearIsClicked) {
                         mem1FalsiHolder.clear()
                         mem1Value.value = ""
                         memCLearIsClicked = false
                    }
                    
                    quadraticNum1Result.value = falsiNum1Holder
                    secondOperationResult.value = secondOperation
                    quadraticNum2Result.value = falsiNum2Holder
                    firstOperationResult.value = firstOperation
                    x1Result.value = x1
                    x2Result.value = x2
                    quadraticNum3Result.value = falsiNum3Holder
                    x3Result.value = x3
                    thirdOperationResult.value = thirdOperation
                    quadraticNum4Result.value = falsiNum4Holder
                    lowValResult.value = lowVal
                    highValResult.value = highVal
                    precissionResult.value = precision
                    
               }
               else {
                    
                    memIsClickedCount += 1
                    
                    if (mem1Holder == "0") {
                         
                         resultHolder = "0"
                    }
                    
                    if (memCLearIsClicked) {
                         mem1Holder = ""
                         memCLearIsClicked = false
                    }
                    
                    if (memRecordIsClicked) {
                         mem1Holder = ansHolder
                         memRecordIsClicked = false
                         mem1FalsiHolder.clear()
                         Log.e("message", mem1FalsiHolder.toString())
                         Log.e("message", mem1Holder.toString())
                    }
                    
                    if (memIsClickedCount == 2) {
                         if (mem1FalsiHolder.isEmpty()) {
                              if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                        "*"
                                   ) || processHolder.contains(
                                        "/"
                                   )) {
                                   processHolder += mem1Holder
                                   proccessResult.value = processHolder
                                   
                              }
                              else if (processHolder == "") {
                                   
                                   processHolder = mem1Holder
                              }
                              
                              if (resultHolder == "0") {
                                   
                                   resultHolder = "0"
                                   
                              }
                              result.value = resultHolder
                              proccessResult.value = processHolder
                              memIsClickedCount = 1
                              
                              mem1Value.value = mem1Holder
                         }
                    }
               }
               if(!falsiMethodIsClicked){
               result.value = resultHolder
               proccessResult.value = processHolder
               memIsClickedCount = 1
     
               mem1Value.value = mem1Holder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun mem2() {
          try {
               Log.e("mess", "called M2 fun")
               if (macroRecordIsClicked) {
                    
                    if (macroSet == "1") {
                         
                         array1Holder.add("M2")
                         Log.e(
                              "array", array1Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array1Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "2") {
                         
                         array2Holder.add("M2")
                         Log.e(
                              "array", array2Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array2Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "3") {
                         
                         array3Holder.add("M2")
                         Log.e(
                              "array", array3Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array3Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "4") {
                         
                         array4Holder.add("M2")
                         Log.e(
                              "array", array4Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array4Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "5") {
                         
                         array5Holder.add("M2")
                         Log.e(
                              "array", array5Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array5Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "6") {
                         
                         array6Holder.add("M2")
                         Log.e(
                              "array", array6Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array6Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "7") {
                         
                         array7Holder.add("M2")
                         Log.e(
                              "array", array7Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array7Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "8") {
                         
                         array8Holder.add("M2")
                         Log.e(
                              "array", array8Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array8Holder.size.toString()
                         )
                         
                    }
                    else if (macroSet == "9") {
                         
                         array9Holder.add("M2")
                         Log.e(
                              "array", array9Holder.toString()
                         )
                         Log.e(
                              "set", macroSet.toString()
                         )
                         Log.e(
                              "length", array9Holder.size.toString()
                         )
                         
                    }
               }
               else if (falsiMethodIsClicked) {
                    
                    if (memRecordIsClicked) {
                         mem2FalsiHolder.clear()
                         
                         mem2FalsiHolder.add(falsiNum1Holder.toString())
                         mem2FalsiHolder.add(x1.toString())
                         mem2FalsiHolder.add(firstOperation.toString())
                         mem2FalsiHolder.add(falsiNum2Holder.toString())
                         mem2FalsiHolder.add(x2.toString())
                         mem2FalsiHolder.add(secondOperation.toString())
                         mem2FalsiHolder.add(falsiNum3Holder.toString())
                         mem2FalsiHolder.add(x3.toString())
                         mem2FalsiHolder.add(thirdOperation.toString())
                         mem2FalsiHolder.add(falsiNum4Holder.toString())
                         
                         
                         Log.e("message", mem2FalsiHolder.toString())
                         mem2Value.value =
                             mem2FalsiHolder.toString()
                                 .dropLast(1)
                                 .drop(1)
                                 .replace(",", "")
                                 .replace(" ", "")
                         mem2Holder = ""
                         mem2FalsiHolder.add(lowVal.toString())
                         mem2FalsiHolder.add(highVal.toString())
                         mem2FalsiHolder.add(precision.toString())
                         memRecordIsClicked = false
                    }
                    
                    if (mem2FalsiHolder.isNotEmpty() && !memRecordIsClicked) {
                         Log.e("message", mem2FalsiHolder.toString())
                         secondOperation = mem2FalsiHolder[5].toString()
                         falsiNum3Holder = mem2FalsiHolder[6].toString()
                         falsiNum1Holder = mem2FalsiHolder[0].toString()
                         x1 = mem2FalsiHolder[1].toString()
                         firstOperation = mem2FalsiHolder[2].toString()
                         falsiNum2Holder = mem2FalsiHolder[3].toString()
                         x2 = mem2FalsiHolder[4].toString()
                         x3 = mem2FalsiHolder[7].toString()
                         thirdOperation = mem2FalsiHolder[8].toString()
                         falsiNum4Holder = mem2FalsiHolder[9].toString()
                         lowVal = mem2FalsiHolder[10].toString()
                         highVal = mem2FalsiHolder[11].toString()
                         precision = mem2FalsiHolder[12].toString()
                         
                    }
                    else {
                         
                         if (falsiNum1Holder!!.isEmpty()) {
                              falsiNum1Holder = mem2Holder.toString()
                              quadraticNum1Result.value = falsiNum1Holder
                         }
                         else if (firstOperation!!.isEmpty()) {
                              if (mem2Holder.toString()
                                       .contains("-")) {
                                   
                                   firstOperation = "-"
                                   stringHolder = mem2Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                                   
                              }
                              else {
                                   firstOperation = "+"
                                   stringHolder = mem2Holder
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                              }
                         }
                         else if (secondOperation!!.isEmpty()) {
                              
                              if (mem2Holder.toString()
                                       .contains("-")) {
                                   secondOperation = "-"
                                   stringHolder = mem2Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                                   
                              }
                              else {
                                   secondOperation = "+"
                                   stringHolder = mem2Holder
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                              }
                         }
                         else {
                              if (mem2Holder.toString()
                                       .contains("-")) {
                                   
                                   thirdOperation = "-"
                                   stringHolder = mem2Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                                   
                              }
                              else {
                                   thirdOperation = "+"
                                   stringHolder = mem2Holder
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                              }
                              
                              if (falsiMethodIsClickedCount == 1) {
                                   lowVal = mem2Holder.toString()
                                   lowValResult.value = lowVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 2) {
                                   highVal = mem2Holder.toString()
                                   highValResult.value = highVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 3) {
                                   precision = mem2Holder.toString()
                                   precissionResult.value = precision
                              }
                         }
                    }
                    
                    
                    
                    
                    if (memCLearIsClicked) {
                         mem2FalsiHolder.clear()
                         mem2Value.value = ""
                         memCLearIsClicked = false
                    }
                    
                    quadraticNum1Result.value = falsiNum1Holder
                    secondOperationResult.value = secondOperation
                    quadraticNum2Result.value = falsiNum2Holder
                    firstOperationResult.value = firstOperation
                    x1Result.value = x1
                    x2Result.value = x2
                    quadraticNum3Result.value = falsiNum3Holder
                    x3Result.value = x3
                    thirdOperationResult.value = thirdOperation
                    quadraticNum4Result.value = falsiNum4Holder
                    lowValResult.value = lowVal
                    highValResult.value = highVal
                    precissionResult.value = precision
                    
               }
               else {
                    
                    memIsClickedCount += 1
                    
                    if (mem2Holder == "0") {
                         
                         resultHolder = "0"
                    }
                    
                    if (memCLearIsClicked) {
                         mem2Holder = ""
                         memCLearIsClicked = false
                    }
                    
                    if (memRecordIsClicked) {
                         mem2Holder = ansHolder
                         memRecordIsClicked = false
                         mem2FalsiHolder.clear()
                         Log.e("message", mem2FalsiHolder.toString())
                         Log.e("message", mem2Holder.toString())
                    }
                    
                    if (memIsClickedCount == 2) {
                         if (mem2FalsiHolder.isEmpty()) {
                              if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                        "*"
                                   ) || processHolder.contains(
                                        "/"
                                   )) {
                                   processHolder += mem2Holder
                                   proccessResult.value = processHolder
                                   
                              }
                              else if (processHolder == "") {
                                   
                                   processHolder = mem2Holder
                              }
                              
                              if (resultHolder == "0") {
                                   
                                   resultHolder = "0"
                                   
                              }
                              result.value = resultHolder
                              proccessResult.value = processHolder
                              memIsClickedCount = 1
                              
                              mem2Value.value = mem2Holder
                         }
                    }
               }
     
               if(!falsiMethodIsClicked) {
                    result.value = resultHolder
                    proccessResult.value = processHolder
                    memIsClickedCount = 1
     
                    mem2Value.value = mem2Holder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun mem3() {
          try {
               if (macroRecordIsClicked) {
                    isClicked = true
                    
                    isClicked = false
                    if (macroRecordIsClicked) {
                         
                         if (macroSet == "1") {
                              
                              array1Holder.add("M3")
                              Log.e(
                                   "array", array1Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array1Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "2") {
                              
                              array2Holder.add("M3")
                              Log.e(
                                   "array", array2Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array2Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "3") {
                              
                              array3Holder.add("M3")
                              Log.e(
                                   "array", array3Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array3Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "4") {
                              
                              array4Holder.add("M3")
                              Log.e(
                                   "array", array4Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array4Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "5") {
                              
                              array5Holder.add("M3")
                              Log.e(
                                   "array", array5Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array5Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "6") {
                              
                              array6Holder.add("M3")
                              Log.e(
                                   "array", array6Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array6Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "7") {
                              
                              array7Holder.add("M3")
                              Log.e(
                                   "array", array7Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array7Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "8") {
                              
                              array8Holder.add("M3")
                              Log.e(
                                   "array", array8Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array8Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "9") {
                              
                              array9Holder.add("M3")
                              Log.e(
                                   "array", array9Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array9Holder.size.toString()
                              )
                         }
                    }
               }
               else if (falsiMethodIsClicked) {
                    
                    if (memRecordIsClicked) {
                         mem3FalsiHolder.clear()
                         
                         mem3FalsiHolder.add(falsiNum1Holder.toString())
                         mem3FalsiHolder.add(x1.toString())
                         mem3FalsiHolder.add(firstOperation.toString())
                         mem3FalsiHolder.add(falsiNum2Holder.toString())
                         mem3FalsiHolder.add(x2.toString())
                         mem3FalsiHolder.add(secondOperation.toString())
                         mem3FalsiHolder.add(falsiNum3Holder.toString())
                         mem3FalsiHolder.add(x3.toString())
                         mem3FalsiHolder.add(thirdOperation.toString())
                         mem3FalsiHolder.add(falsiNum4Holder.toString())
                         
                         
                         Log.e("message", mem3FalsiHolder.toString())
                         mem3Value.value =
                             mem3FalsiHolder.toString()
                                 .dropLast(1)
                                 .drop(1)
                                 .replace(",", "")
                                 .replace(" ", "")
                         mem3Holder = ""
                         mem3FalsiHolder.add(lowVal.toString())
                         mem3FalsiHolder.add(highVal.toString())
                         mem3FalsiHolder.add(precision.toString())
                         memRecordIsClicked = false
                    }
                    
                    if (mem3FalsiHolder.isNotEmpty() && !memRecordIsClicked) {
                         Log.e("message", mem3FalsiHolder.toString())
                         secondOperation = mem3FalsiHolder[5].toString()
                         falsiNum3Holder = mem3FalsiHolder[6].toString()
                         falsiNum1Holder = mem3FalsiHolder[0].toString()
                         x1 = mem3FalsiHolder[1].toString()
                         firstOperation = mem3FalsiHolder[2].toString()
                         falsiNum2Holder = mem3FalsiHolder[3].toString()
                         x2 = mem3FalsiHolder[4].toString()
                         x3 = mem3FalsiHolder[7].toString()
                         thirdOperation = mem3FalsiHolder[8].toString()
                         falsiNum4Holder = mem3FalsiHolder[9].toString()
                         lowVal = mem3FalsiHolder[10].toString()
                         highVal = mem3FalsiHolder[11].toString()
                         precision = mem3FalsiHolder[12].toString()
                         
                    }
                    else {
                         
                         if (falsiNum1Holder!!.isEmpty()) {
                              falsiNum1Holder = mem3Holder.toString()
                              quadraticNum1Result.value = falsiNum1Holder
                         }
                         else if (firstOperation!!.isEmpty()) {
                              if (mem3Holder.toString()
                                       .contains("-")) {
                                   
                                   firstOperation = "-"
                                   stringHolder = mem3Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                                   
                              }
                              else {
                                   firstOperation = "+"
                                   stringHolder = mem3Holder
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                              }
                         }
                         else if (secondOperation!!.isEmpty()) {
                              
                              if (mem3Holder.toString()
                                       .contains("-")) {
                                   secondOperation = "-"
                                   stringHolder = mem3Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                                   
                              }
                              else {
                                   secondOperation = "+"
                                   stringHolder = mem3Holder
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                              }
                         }
                         else {
                              if (mem3Holder.toString()
                                       .contains("-")) {
                                   
                                   thirdOperation = "-"
                                   stringHolder = mem3Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                                   
                              }
                              else {
                                   thirdOperation = "+"
                                   stringHolder = mem3Holder
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                              }
                              
                              if (falsiMethodIsClickedCount == 1) {
                                   lowVal = mem3Holder.toString()
                                   lowValResult.value = lowVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 2) {
                                   highVal = mem3Holder.toString()
                                   highValResult.value = highVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 3) {
                                   precision = mem3Holder.toString()
                                   precissionResult.value = precision
                              }
                         }
                    }
                    
                    
                    
                    
                    if (memCLearIsClicked) {
                         mem3FalsiHolder.clear()
                         mem3Value.value = ""
                         memCLearIsClicked = false
                    }
                    
                    quadraticNum1Result.value = falsiNum1Holder
                    secondOperationResult.value = secondOperation
                    quadraticNum2Result.value = falsiNum2Holder
                    firstOperationResult.value = firstOperation
                    x1Result.value = x1
                    x2Result.value = x2
                    quadraticNum3Result.value = falsiNum3Holder
                    x3Result.value = x3
                    thirdOperationResult.value = thirdOperation
                    quadraticNum4Result.value = falsiNum4Holder
                    lowValResult.value = lowVal
                    highValResult.value = highVal
                    precissionResult.value = precision
                    
               }
               else {
                    
                    memIsClickedCount += 1
                    
                    if (mem3Holder == "0") {
                         
                         resultHolder = "0"
                    }
                    
                    if (memCLearIsClicked) {
                         mem3Holder = ""
                         memCLearIsClicked = false
                    }
                    
                    if (memRecordIsClicked) {
                         mem3Holder = ansHolder
                         memRecordIsClicked = false
                         mem3FalsiHolder.clear()
                         Log.e("message", mem3FalsiHolder.toString())
                         Log.e("message", mem3Holder.toString())
                    }
                    
                    if (memIsClickedCount == 2) {
                         if (mem3FalsiHolder.isEmpty()) {
                              if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                        "*"
                                   ) || processHolder.contains(
                                        "/"
                                   )) {
                                   processHolder += mem3Holder
                                   proccessResult.value = processHolder
                                   
                              }
                              else if (processHolder == "") {
                                   
                                   processHolder = mem3Holder
                              }
                              
                              if (resultHolder == "0") {
                                   
                                   resultHolder = "0"
                                   
                              }
                              result.value = resultHolder
                              proccessResult.value = processHolder
                              memIsClickedCount = 1
                              
                              mem3Value.value = mem3Holder
                         }
                    }
               }
               if(!falsiMethodIsClicked) {
                    result.value = resultHolder
                    proccessResult.value = processHolder
                    memIsClickedCount = 1
     
                    mem3Value.value = mem3Holder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun mem4() {
          try {
               if (macroRecordIsClicked) {
                    isClicked = true
                    
                    isClicked = false
                    if (macroRecordIsClicked) {
                         
                         if (macroSet == "1") {
                              
                              array1Holder.add("M4")
                              Log.e(
                                   "array", array1Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array1Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "2") {
                              
                              array2Holder.add("M4")
                              Log.e(
                                   "array", array2Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array2Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "3") {
                              
                              array3Holder.add("M4")
                              Log.e(
                                   "array", array3Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array3Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "4") {
                              
                              array4Holder.add("M4")
                              Log.e(
                                   "array", array4Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array4Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "5") {
                              
                              array5Holder.add("M4")
                              Log.e(
                                   "array", array5Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array5Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "6") {
                              
                              array6Holder.add("M4")
                              Log.e(
                                   "array", array6Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array6Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "7") {
                              
                              array7Holder.add("M4")
                              Log.e(
                                   "array", array7Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array7Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "8") {
                              
                              array8Holder.add("M4")
                              Log.e(
                                   "array", array8Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array8Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "9") {
                              
                              array9Holder.add("M4")
                              Log.e(
                                   "array", array9Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array9Holder.size.toString()
                              )
                         }
                    }
               }
               else if (falsiMethodIsClicked) {
                    
                    if (memRecordIsClicked) {
                         mem4FalsiHolder.clear()
                         
                         mem4FalsiHolder.add(falsiNum1Holder.toString())
                         mem4FalsiHolder.add(x1.toString())
                         mem4FalsiHolder.add(firstOperation.toString())
                         mem4FalsiHolder.add(falsiNum2Holder.toString())
                         mem4FalsiHolder.add(x2.toString())
                         mem4FalsiHolder.add(secondOperation.toString())
                         mem4FalsiHolder.add(falsiNum3Holder.toString())
                         mem4FalsiHolder.add(x3.toString())
                         mem4FalsiHolder.add(thirdOperation.toString())
                         mem4FalsiHolder.add(falsiNum4Holder.toString())
                         
                         
                         Log.e("message", mem4FalsiHolder.toString())
                         mem4Value.value =
                             mem4FalsiHolder.toString()
                                 .dropLast(1)
                                 .drop(1)
                                 .replace(",", "")
                                 .replace(" ", "")
                         mem4Holder = ""
                         mem4FalsiHolder.add(lowVal.toString())
                         mem4FalsiHolder.add(highVal.toString())
                         mem4FalsiHolder.add(precision.toString())
                         memRecordIsClicked = false
                    }
                    
                    if (mem4FalsiHolder.isNotEmpty() && !memRecordIsClicked) {
                         Log.e("message", mem4FalsiHolder.toString())
                         secondOperation = mem4FalsiHolder[5].toString()
                         falsiNum3Holder = mem4FalsiHolder[6].toString()
                         falsiNum1Holder = mem4FalsiHolder[0].toString()
                         x1 = mem4FalsiHolder[1].toString()
                         firstOperation = mem4FalsiHolder[2].toString()
                         falsiNum2Holder = mem4FalsiHolder[3].toString()
                         x2 = mem4FalsiHolder[4].toString()
                         x3 = mem4FalsiHolder[7].toString()
                         thirdOperation = mem4FalsiHolder[8].toString()
                         falsiNum4Holder = mem4FalsiHolder[9].toString()
                         lowVal = mem4FalsiHolder[10].toString()
                         highVal = mem4FalsiHolder[11].toString()
                         precision = mem4FalsiHolder[12].toString()
                         
                    }
                    else {
                         
                         if (falsiNum1Holder!!.isEmpty()) {
                              falsiNum1Holder = mem4Holder.toString()
                              quadraticNum1Result.value = falsiNum1Holder
                         }
                         else if (firstOperation!!.isEmpty()) {
                              if (mem4Holder.toString()
                                       .contains("-")) {
                                   
                                   firstOperation = "-"
                                   stringHolder = mem4Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                                   
                              }
                              else {
                                   firstOperation = "+"
                                   stringHolder = mem4Holder
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                              }
                         }
                         else if (secondOperation!!.isEmpty()) {
                              
                              if (mem4Holder.toString()
                                       .contains("-")) {
                                   secondOperation = "-"
                                   stringHolder = mem4Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                                   
                              }
                              else {
                                   secondOperation = "+"
                                   stringHolder = mem4Holder
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                              }
                         }
                         else {
                              if (mem4Holder.toString()
                                       .contains("-")) {
                                   
                                   thirdOperation = "-"
                                   stringHolder = mem4Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                                   
                              }
                              else {
                                   thirdOperation = "+"
                                   stringHolder = mem4Holder
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                              }
                              
                              if (falsiMethodIsClickedCount == 1) {
                                   lowVal = mem4Holder.toString()
                                   lowValResult.value = lowVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 2) {
                                   highVal = mem4Holder.toString()
                                   highValResult.value = highVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 3) {
                                   precision = mem4Holder.toString()
                                   precissionResult.value = precision
                              }
                         }
                    }
                    
                    
                    
                    
                    if (memCLearIsClicked) {
                         mem4FalsiHolder.clear()
                         mem4Value.value = ""
                         memCLearIsClicked = false
                    }
                    
                    quadraticNum1Result.value = falsiNum1Holder
                    secondOperationResult.value = secondOperation
                    quadraticNum2Result.value = falsiNum2Holder
                    firstOperationResult.value = firstOperation
                    x1Result.value = x1
                    x2Result.value = x2
                    quadraticNum3Result.value = falsiNum3Holder
                    x3Result.value = x3
                    thirdOperationResult.value = thirdOperation
                    quadraticNum4Result.value = falsiNum4Holder
                    lowValResult.value = lowVal
                    highValResult.value = highVal
                    precissionResult.value = precision
                    
               }
               else {
                    
                    memIsClickedCount += 1
                    
                    if (mem4Holder == "0") {
                         
                         resultHolder = "0"
                    }
                    
                    if (memCLearIsClicked) {
                         mem4Holder = ""
                         memCLearIsClicked = false
                    }
                    
                    if (memRecordIsClicked) {
                         mem4Holder = ansHolder
                         memRecordIsClicked = false
                         mem4FalsiHolder.clear()
                         Log.e("message", mem4FalsiHolder.toString())
                         Log.e("message", mem4Holder.toString())
                    }
                    
                    if (memIsClickedCount == 2) {
                         if (mem4FalsiHolder.isEmpty()) {
                              if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                        "*"
                                   ) || processHolder.contains(
                                        "/"
                                   )) {
                                   processHolder += mem4Holder
                                   proccessResult.value = processHolder
                                   
                              }
                              else if (processHolder == "") {
                                   
                                   processHolder = mem4Holder
                              }
                              
                              if (resultHolder == "0") {
                                   
                                   resultHolder = "0"
                                   
                              }
                              result.value = resultHolder
                              proccessResult.value = processHolder
                              memIsClickedCount = 1
                              
                              mem4Value.value = mem4Holder
                         }
                    }
               }
               if(!falsiMethodIsClicked) {
                    result.value = resultHolder
                    proccessResult.value = processHolder
                    memIsClickedCount = 1
     
                    mem4Value.value = mem4Holder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun mem5() {
          try {
               
               if (macroRecordIsClicked) {
                    isClicked = true
                    
                    isClicked = false
                    if (macroRecordIsClicked) {
                         
                         if (macroSet == "1") {
                              
                              array1Holder.add("M5")
                              Log.e(
                                   "array", array1Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array1Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "2") {
                              
                              array2Holder.add("M5")
                              Log.e(
                                   "array", array2Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array2Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "3") {
                              
                              array3Holder.add("M5")
                              Log.e(
                                   "array", array3Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array3Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "4") {
                              
                              array4Holder.add("M5")
                              Log.e(
                                   "array", array4Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array4Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "5") {
                              
                              array5Holder.add("M5")
                              Log.e(
                                   "array", array5Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array5Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "6") {
                              
                              array6Holder.add("M5")
                              Log.e(
                                   "array", array6Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array6Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "7") {
                              
                              array7Holder.add("M5")
                              Log.e(
                                   "array", array7Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array7Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "8") {
                              
                              array8Holder.add("M5")
                              Log.e(
                                   "array", array8Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array8Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "9") {
                              
                              array9Holder.add("M5")
                              Log.e(
                                   "array", array9Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array9Holder.size.toString()
                              )
                         }
                    }
               }
               else if (falsiMethodIsClicked) {
                    
                    if (memRecordIsClicked) {
                         mem5FalsiHolder.clear()
                         
                         mem5FalsiHolder.add(falsiNum1Holder.toString())
                         mem5FalsiHolder.add(x1.toString())
                         mem5FalsiHolder.add(firstOperation.toString())
                         mem5FalsiHolder.add(falsiNum2Holder.toString())
                         mem5FalsiHolder.add(x2.toString())
                         mem5FalsiHolder.add(secondOperation.toString())
                         mem5FalsiHolder.add(falsiNum3Holder.toString())
                         mem5FalsiHolder.add(x3.toString())
                         mem5FalsiHolder.add(thirdOperation.toString())
                         mem5FalsiHolder.add(falsiNum4Holder.toString())
                         
                         
                         Log.e("message", mem5FalsiHolder.toString())
                         mem5Value.value =
                             mem5FalsiHolder.toString()
                                 .dropLast(1)
                                 .drop(1)
                                 .replace(",", "")
                                 .replace(" ", "")
                         mem5Holder = ""
                         mem5FalsiHolder.add(lowVal.toString())
                         mem5FalsiHolder.add(highVal.toString())
                         mem5FalsiHolder.add(precision.toString())
                         memRecordIsClicked = false
                    }
                    
                    if (mem5FalsiHolder.isNotEmpty() && !memRecordIsClicked) {
                         Log.e("message", mem5FalsiHolder.toString())
                         secondOperation = mem5FalsiHolder[5].toString()
                         falsiNum3Holder = mem5FalsiHolder[6].toString()
                         falsiNum1Holder = mem5FalsiHolder[0].toString()
                         x1 = mem5FalsiHolder[1].toString()
                         firstOperation = mem5FalsiHolder[2].toString()
                         falsiNum2Holder = mem5FalsiHolder[3].toString()
                         x2 = mem5FalsiHolder[4].toString()
                         x3 = mem5FalsiHolder[7].toString()
                         thirdOperation = mem5FalsiHolder[8].toString()
                         falsiNum4Holder = mem5FalsiHolder[9].toString()
                         lowVal = mem5FalsiHolder[10].toString()
                         highVal = mem5FalsiHolder[11].toString()
                         precision = mem5FalsiHolder[12].toString()
                         
                    }
                    else {
                         
                         if (falsiNum1Holder!!.isEmpty()) {
                              falsiNum1Holder = mem5Holder.toString()
                              quadraticNum1Result.value = falsiNum1Holder
                         }
                         else if (firstOperation!!.isEmpty()) {
                              if (mem5Holder.toString()
                                       .contains("-")) {
                                   
                                   firstOperation = "-"
                                   stringHolder = mem5Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                                   
                              }
                              else {
                                   firstOperation = "+"
                                   stringHolder = mem5Holder
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                              }
                         }
                         else if (secondOperation!!.isEmpty()) {
                              
                              if (mem5Holder.toString()
                                       .contains("-")) {
                                   secondOperation = "-"
                                   stringHolder = mem5Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                                   
                              }
                              else {
                                   secondOperation = "+"
                                   stringHolder = mem5Holder
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                              }
                         }
                         else {
                              if (mem5Holder.toString()
                                       .contains("-")) {
                                   
                                   thirdOperation = "-"
                                   stringHolder = mem5Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                                   
                              }
                              else {
                                   thirdOperation = "+"
                                   stringHolder = mem5Holder
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                              }
                              
                              if (falsiMethodIsClickedCount == 1) {
                                   lowVal = mem5Holder.toString()
                                   lowValResult.value = lowVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 2) {
                                   highVal = mem5Holder.toString()
                                   highValResult.value = highVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 3) {
                                   precision = mem5Holder.toString()
                                   precissionResult.value = precision
                              }
                         }
                    }
                    
                    
                    
                    
                    if (memCLearIsClicked) {
                         mem5FalsiHolder.clear()
                         mem5Value.value = ""
                         memCLearIsClicked = false
                    }
                    
                    quadraticNum1Result.value = falsiNum1Holder
                    secondOperationResult.value = secondOperation
                    quadraticNum2Result.value = falsiNum2Holder
                    firstOperationResult.value = firstOperation
                    x1Result.value = x1
                    x2Result.value = x2
                    quadraticNum3Result.value = falsiNum3Holder
                    x3Result.value = x3
                    thirdOperationResult.value = thirdOperation
                    quadraticNum4Result.value = falsiNum4Holder
                    lowValResult.value = lowVal
                    highValResult.value = highVal
                    precissionResult.value = precision
                    
               }
               else {
                    
                    memIsClickedCount += 1
                    
                    if (mem5Holder == "0") {
                         
                         resultHolder = "0"
                    }
                    
                    if (memCLearIsClicked) {
                         mem5Holder = ""
                         memCLearIsClicked = false
                    }
                    
                    if (memRecordIsClicked) {
                         mem5Holder = ansHolder
                         memRecordIsClicked = false
                         mem5FalsiHolder.clear()
                         Log.e("message", mem5FalsiHolder.toString())
                         Log.e("message", mem5Holder.toString())
                    }
                    
                    if (memIsClickedCount == 2) {
                         if (mem5FalsiHolder.isEmpty()) {
                              if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                        "*"
                                   ) || processHolder.contains(
                                        "/"
                                   )) {
                                   processHolder += mem5Holder
                                   proccessResult.value = processHolder
                                   
                              }
                              else if (processHolder == "") {
                                   
                                   processHolder = mem5Holder
                              }
                              
                              if (resultHolder == "0") {
                                   
                                   resultHolder = "0"
                                   
                              }
                              result.value = resultHolder
                              proccessResult.value = processHolder
                              memIsClickedCount = 1
                              
                              mem5Value.value = mem5Holder
                         }
                    }
               }
               if(!falsiMethodIsClicked) {
                    result.value = resultHolder
                    proccessResult.value = processHolder
                    memIsClickedCount = 1
     
                    mem5Value.value = mem5Holder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun mem6() {
          try {
               if (macroRecordIsClicked) {
                    isClicked = true
                    
                    isClicked = false
                    if (macroRecordIsClicked) {
                         
                         if (macroSet == "1") {
                              
                              array1Holder.add("M6")
                              Log.e(
                                   "array", array1Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array1Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "2") {
                              
                              array2Holder.add("M6")
                              Log.e(
                                   "array", array2Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array2Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "3") {
                              
                              array3Holder.add("M6")
                              Log.e(
                                   "array", array3Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array3Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "4") {
                              
                              array4Holder.add("M6")
                              Log.e(
                                   "array", array4Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array4Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "5") {
                              
                              array5Holder.add("M6")
                              Log.e(
                                   "array", array5Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array5Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "6") {
                              
                              array6Holder.add("M6")
                              Log.e(
                                   "array", array6Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array6Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "7") {
                              
                              array7Holder.add("M6")
                              Log.e(
                                   "array", array7Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array7Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "8") {
                              
                              array8Holder.add("M6")
                              Log.e(
                                   "array", array8Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array8Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "9") {
                              
                              array9Holder.add("M6")
                              Log.e(
                                   "array", array9Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array9Holder.size.toString()
                              )
                         }
                    }
               }
               else if (falsiMethodIsClicked) {
                    
                    if (memRecordIsClicked) {
                         mem6FalsiHolder.clear()
                         
                         mem6FalsiHolder.add(falsiNum1Holder.toString())
                         mem6FalsiHolder.add(x1.toString())
                         mem6FalsiHolder.add(firstOperation.toString())
                         mem6FalsiHolder.add(falsiNum2Holder.toString())
                         mem6FalsiHolder.add(x2.toString())
                         mem6FalsiHolder.add(secondOperation.toString())
                         mem6FalsiHolder.add(falsiNum3Holder.toString())
                         mem6FalsiHolder.add(x3.toString())
                         mem6FalsiHolder.add(thirdOperation.toString())
                         mem6FalsiHolder.add(falsiNum4Holder.toString())
                         
                         
                         Log.e("message", mem6FalsiHolder.toString())
                         mem6Value.value =
                             mem6FalsiHolder.toString()
                                 .dropLast(1)
                                 .drop(1)
                                 .replace(",", "")
                                 .replace(" ", "")
                         mem6Holder = ""
                         mem6FalsiHolder.add(lowVal.toString())
                         mem6FalsiHolder.add(highVal.toString())
                         mem6FalsiHolder.add(precision.toString())
                         memRecordIsClicked = false
                    }
                    
                    if (mem6FalsiHolder.isNotEmpty() && !memRecordIsClicked) {
                         Log.e("message", mem6FalsiHolder.toString())
                         secondOperation = mem6FalsiHolder[5].toString()
                         falsiNum3Holder = mem6FalsiHolder[6].toString()
                         falsiNum1Holder = mem6FalsiHolder[0].toString()
                         x1 = mem6FalsiHolder[1].toString()
                         firstOperation = mem6FalsiHolder[2].toString()
                         falsiNum2Holder = mem6FalsiHolder[3].toString()
                         x2 = mem6FalsiHolder[4].toString()
                         x3 = mem6FalsiHolder[7].toString()
                         thirdOperation = mem6FalsiHolder[8].toString()
                         falsiNum4Holder = mem6FalsiHolder[9].toString()
                         lowVal = mem6FalsiHolder[10].toString()
                         highVal = mem1FalsiHolder[11].toString()
                         precision = mem1FalsiHolder[12].toString()
                         
                    }
                    else {
                         
                         if (falsiNum1Holder!!.isEmpty()) {
                              falsiNum1Holder = mem6Holder.toString()
                              quadraticNum1Result.value = falsiNum1Holder
                         }
                         else if (firstOperation!!.isEmpty()) {
                              if (mem6Holder.toString()
                                       .contains("-")) {
                                   
                                   firstOperation = "-"
                                   stringHolder = mem6Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                                   
                              }
                              else {
                                   firstOperation = "+"
                                   stringHolder = mem6Holder
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                              }
                         }
                         else if (secondOperation!!.isEmpty()) {
                              
                              if (mem6Holder.toString()
                                       .contains("-")) {
                                   secondOperation = "-"
                                   stringHolder = mem6Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                                   
                              }
                              else {
                                   secondOperation = "+"
                                   stringHolder = mem6Holder
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                              }
                         }
                         else {
                              if (mem6Holder.toString()
                                       .contains("-")) {
                                   
                                   thirdOperation = "-"
                                   stringHolder = mem6Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                                   
                              }
                              else {
                                   thirdOperation = "+"
                                   stringHolder = mem6Holder
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                              }
                              
                              if (falsiMethodIsClickedCount == 1) {
                                   lowVal = mem6Holder.toString()
                                   lowValResult.value = lowVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 2) {
                                   highVal = mem6Holder.toString()
                                   highValResult.value = highVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 3) {
                                   precision = mem6Holder.toString()
                                   precissionResult.value = precision
                              }
                         }
                    }
                    
                    
                    
                    
                    if (memCLearIsClicked) {
                         mem6FalsiHolder.clear()
                         mem6Value.value = ""
                         memCLearIsClicked = false
                    }
                    
                    quadraticNum1Result.value = falsiNum1Holder
                    secondOperationResult.value = secondOperation
                    quadraticNum2Result.value = falsiNum2Holder
                    firstOperationResult.value = firstOperation
                    x1Result.value = x1
                    x2Result.value = x2
                    quadraticNum3Result.value = falsiNum3Holder
                    x3Result.value = x3
                    thirdOperationResult.value = thirdOperation
                    quadraticNum4Result.value = falsiNum4Holder
                    lowValResult.value = lowVal
                    highValResult.value = highVal
                    precissionResult.value = precision
                    
               }
               else {
                    
                    memIsClickedCount += 1
                    
                    if (mem6Holder == "0") {
                         
                         resultHolder = "0"
                    }
                    
                    if (memCLearIsClicked) {
                         mem6Holder = ""
                         memCLearIsClicked = false
                    }
                    
                    if (memRecordIsClicked) {
                         mem6Holder = ansHolder
                         memRecordIsClicked = false
                         mem6FalsiHolder.clear()
                         Log.e("message", mem6FalsiHolder.toString())
                         Log.e("message", mem6Holder.toString())
                    }
                    
                    if (memIsClickedCount == 2) {
                         if (mem6FalsiHolder.isEmpty()) {
                              if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                        "*"
                                   ) || processHolder.contains(
                                        "/"
                                   )) {
                                   processHolder += mem6Holder
                                   proccessResult.value = processHolder
                                   
                              }
                              else if (processHolder == "") {
                                   
                                   processHolder = mem6Holder
                              }
                              
                              if (resultHolder == "0") {
                                   
                                   resultHolder = "0"
                                   
                              }
                              result.value = resultHolder
                              proccessResult.value = processHolder
                              memIsClickedCount = 1
                              
                              mem6Value.value = mem6Holder
                         }
                    }
               }
               if(!falsiMethodIsClicked) {
                    result.value = resultHolder
                    proccessResult.value = processHolder
                    memIsClickedCount = 1
     
                    mem6Value.value = mem6Holder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun mem7() {
          try {
               if (macroRecordIsClicked) {
                    isClicked = true
                    
                    isClicked = false
                    if (macroRecordIsClicked) {
                         
                         if (macroSet == "1") {
                              
                              array1Holder.add("M7")
                              Log.e(
                                   "array", array1Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array1Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "2") {
                              
                              array2Holder.add("M7")
                              Log.e(
                                   "array", array2Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array2Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "3") {
                              
                              array3Holder.add("M7")
                              Log.e(
                                   "array", array3Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array3Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "4") {
                              
                              array4Holder.add("M7")
                              Log.e(
                                   "array", array4Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array4Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "5") {
                              
                              array5Holder.add("M7")
                              Log.e(
                                   "array", array5Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array5Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "6") {
                              
                              array6Holder.add("M7")
                              Log.e(
                                   "array", array6Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array6Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "7") {
                              
                              array7Holder.add("M1")
                              Log.e(
                                   "array", array7Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array7Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "8") {
                              
                              array8Holder.add("M7")
                              Log.e(
                                   "array", array8Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array8Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "9") {
                              
                              array9Holder.add("M7")
                              Log.e(
                                   "array", array9Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array9Holder.size.toString()
                              )
                         }
                    }
               }
               else if (falsiMethodIsClicked) {
                    
                    if (memRecordIsClicked) {
                         mem7FalsiHolder.clear()
                         
                         mem7FalsiHolder.add(falsiNum1Holder.toString())
                         mem7FalsiHolder.add(x1.toString())
                         mem7FalsiHolder.add(firstOperation.toString())
                         mem7FalsiHolder.add(falsiNum2Holder.toString())
                         mem7FalsiHolder.add(x2.toString())
                         mem7FalsiHolder.add(secondOperation.toString())
                         mem7FalsiHolder.add(falsiNum3Holder.toString())
                         mem7FalsiHolder.add(x3.toString())
                         mem7FalsiHolder.add(thirdOperation.toString())
                         mem7FalsiHolder.add(falsiNum4Holder.toString())
                         
                         
                         Log.e("message", mem7FalsiHolder.toString())
                         mem7Value.value =
                             mem7FalsiHolder.toString()
                                 .dropLast(1)
                                 .drop(1)
                                 .replace(",", "")
                                 .replace(" ", "")
                         mem7Holder = ""
                         mem7FalsiHolder.add(lowVal.toString())
                         mem7FalsiHolder.add(highVal.toString())
                         mem7FalsiHolder.add(precision.toString())
                         memRecordIsClicked = false
                    }
                    
                    if (mem7FalsiHolder.isNotEmpty() && !memRecordIsClicked) {
                         Log.e("message", mem7FalsiHolder.toString())
                         secondOperation = mem7FalsiHolder[5].toString()
                         falsiNum3Holder = mem1FalsiHolder[6].toString()
                         falsiNum1Holder = mem7FalsiHolder[0].toString()
                         x1 = mem7FalsiHolder[1].toString()
                         firstOperation = mem7FalsiHolder[2].toString()
                         falsiNum2Holder = mem7FalsiHolder[3].toString()
                         x2 = mem7FalsiHolder[4].toString()
                         x3 = mem7FalsiHolder[7].toString()
                         thirdOperation = mem7FalsiHolder[8].toString()
                         falsiNum4Holder = mem7FalsiHolder[9].toString()
                         lowVal = mem7FalsiHolder[10].toString()
                         highVal = mem7FalsiHolder[11].toString()
                         precision = mem7FalsiHolder[12].toString()
                         
                    }
                    else {
                         
                         if (falsiNum1Holder!!.isEmpty()) {
                              falsiNum1Holder = mem7Holder.toString()
                              quadraticNum1Result.value = falsiNum1Holder
                         }
                         else if (firstOperation!!.isEmpty()) {
                              if (mem7Holder.toString()
                                       .contains("-")) {
                                   
                                   firstOperation = "-"
                                   stringHolder = mem7Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                                   
                              }
                              else {
                                   firstOperation = "+"
                                   stringHolder = mem7Holder
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                              }
                         }
                         else if (secondOperation!!.isEmpty()) {
                              
                              if (mem7Holder.toString()
                                       .contains("-")) {
                                   secondOperation = "-"
                                   stringHolder = mem7Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                                   
                              }
                              else {
                                   secondOperation = "+"
                                   stringHolder = mem7Holder
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                              }
                         }
                         else {
                              if (mem7Holder.toString()
                                       .contains("-")) {
                                   
                                   thirdOperation = "-"
                                   stringHolder = mem7Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                                   
                              }
                              else {
                                   thirdOperation = "+"
                                   stringHolder = mem7Holder
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                              }
                              
                              if (falsiMethodIsClickedCount == 1) {
                                   lowVal = mem7Holder.toString()
                                   lowValResult.value = lowVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 2) {
                                   highVal = mem7Holder.toString()
                                   highValResult.value = highVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 3) {
                                   precision = mem7Holder.toString()
                                   precissionResult.value = precision
                              }
                         }
                    }
                    
                    
                    
                    
                    if (memCLearIsClicked) {
                         mem7FalsiHolder.clear()
                         mem7Value.value = ""
                         memCLearIsClicked = false
                    }
                    
                    quadraticNum1Result.value = falsiNum1Holder
                    secondOperationResult.value = secondOperation
                    quadraticNum2Result.value = falsiNum2Holder
                    firstOperationResult.value = firstOperation
                    x1Result.value = x1
                    x2Result.value = x2
                    quadraticNum3Result.value = falsiNum3Holder
                    x3Result.value = x3
                    thirdOperationResult.value = thirdOperation
                    quadraticNum4Result.value = falsiNum4Holder
                    lowValResult.value = lowVal
                    highValResult.value = highVal
                    precissionResult.value = precision
                    
               }
               else {
                    
                    memIsClickedCount += 1
                    
                    if (mem7Holder == "0") {
                         
                         resultHolder = "0"
                    }
                    
                    if (memCLearIsClicked) {
                         mem7Holder = ""
                         memCLearIsClicked = false
                    }
                    
                    if (memRecordIsClicked) {
                         mem7Holder = ansHolder
                         memRecordIsClicked = false
                         mem7FalsiHolder.clear()
                         Log.e("message", mem7FalsiHolder.toString())
                         Log.e("message", mem7Holder.toString())
                    }
                    
                    if (memIsClickedCount == 2) {
                         if (mem7FalsiHolder.isEmpty()) {
                              if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                        "*"
                                   ) || processHolder.contains(
                                        "/"
                                   )) {
                                   processHolder += mem7Holder
                                   proccessResult.value = processHolder
                                   
                              }
                              else if (processHolder == "") {
                                   
                                   processHolder = mem7Holder
                              }
                              
                              if (resultHolder == "0") {
                                   
                                   resultHolder = "0"
                                   
                              }
                              result.value = resultHolder
                              proccessResult.value = processHolder
                              memIsClickedCount = 1
                              
                              mem7Value.value = mem7Holder
                         }
                    }
               }
               if(!falsiMethodIsClicked) {
                    result.value = resultHolder
                    proccessResult.value = processHolder
                    memIsClickedCount = 1
     
                    mem7Value.value = mem7Holder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun mem8() {
          try {
               if (macroRecordIsClicked) {
                    isClicked = true
                    
                    isClicked = false
                    if (macroRecordIsClicked) {
                         
                         if (macroSet == "1") {
                              
                              array1Holder.add("M8")
                              Log.e(
                                   "array", array1Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array1Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "2") {
                              
                              array2Holder.add("M8")
                              Log.e(
                                   "array", array2Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array2Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "3") {
                              
                              array3Holder.add("M8")
                              Log.e(
                                   "array", array3Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array3Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "4") {
                              
                              array4Holder.add("M8")
                              Log.e(
                                   "array", array4Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array4Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "5") {
                              
                              array5Holder.add("M8")
                              Log.e(
                                   "array", array5Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array5Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "6") {
                              
                              array6Holder.add("M8")
                              Log.e(
                                   "array", array6Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array6Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "7") {
                              
                              array7Holder.add("M8")
                              Log.e(
                                   "array", array7Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array7Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "8") {
                              
                              array8Holder.add("M8")
                              Log.e(
                                   "array", array8Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array8Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "9") {
                              
                              array9Holder.add("M8")
                              Log.e(
                                   "array", array9Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array9Holder.size.toString()
                              )
                         }
                    }
               }
               else if (falsiMethodIsClicked) {
                    
                    if (memRecordIsClicked) {
                         mem8FalsiHolder.clear()
                         
                         mem8FalsiHolder.add(falsiNum1Holder.toString())
                         mem8FalsiHolder.add(x1.toString())
                         mem8FalsiHolder.add(firstOperation.toString())
                         mem8FalsiHolder.add(falsiNum2Holder.toString())
                         mem8FalsiHolder.add(x2.toString())
                         mem8FalsiHolder.add(secondOperation.toString())
                         mem8FalsiHolder.add(falsiNum3Holder.toString())
                         mem8FalsiHolder.add(x3.toString())
                         mem8FalsiHolder.add(thirdOperation.toString())
                         mem8FalsiHolder.add(falsiNum4Holder.toString())
                         
                         
                         Log.e("message", mem8FalsiHolder.toString())
                         mem8Value.value =
                             mem8FalsiHolder.toString()
                                 .dropLast(1)
                                 .drop(1)
                                 .replace(",", "")
                                 .replace(" ", "")
                         mem8Holder = ""
                         mem8FalsiHolder.add(lowVal.toString())
                         mem8FalsiHolder.add(highVal.toString())
                         mem8FalsiHolder.add(precision.toString())
                         memRecordIsClicked = false
                    }
                    
                    if (mem8FalsiHolder.isNotEmpty() && !memRecordIsClicked) {
                         Log.e("message", mem8FalsiHolder.toString())
                         secondOperation = mem8FalsiHolder[5].toString()
                         falsiNum3Holder = mem8FalsiHolder[6].toString()
                         falsiNum1Holder = mem8FalsiHolder[0].toString()
                         x1 = mem8FalsiHolder[1].toString()
                         firstOperation = mem8FalsiHolder[2].toString()
                         falsiNum2Holder = mem8FalsiHolder[3].toString()
                         x2 = mem8FalsiHolder[4].toString()
                         x3 = mem8FalsiHolder[7].toString()
                         thirdOperation = mem8FalsiHolder[8].toString()
                         falsiNum4Holder = mem8FalsiHolder[9].toString()
                         lowVal = mem8FalsiHolder[10].toString()
                         highVal = mem8FalsiHolder[11].toString()
                         precision = mem8FalsiHolder[12].toString()
                         
                    }
                    else {
                         
                         if (falsiNum1Holder!!.isEmpty()) {
                              falsiNum1Holder = mem8Holder.toString()
                              quadraticNum1Result.value = falsiNum1Holder
                         }
                         else if (firstOperation!!.isEmpty()) {
                              if (mem8Holder.toString()
                                       .contains("-")) {
                                   
                                   firstOperation = "-"
                                   stringHolder = mem8Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                                   
                              }
                              else {
                                   firstOperation = "+"
                                   stringHolder = mem8Holder
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                              }
                         }
                         else if (secondOperation!!.isEmpty()) {
                              
                              if (mem8Holder.toString()
                                       .contains("-")) {
                                   secondOperation = "-"
                                   stringHolder = mem8Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                                   
                              }
                              else {
                                   secondOperation = "+"
                                   stringHolder = mem8Holder
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                              }
                         }
                         else {
                              if (mem8Holder.toString()
                                       .contains("-")) {
                                   
                                   thirdOperation = "-"
                                   stringHolder = mem8Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                                   
                              }
                              else {
                                   thirdOperation = "+"
                                   stringHolder = mem8Holder
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                              }
                              
                              if (falsiMethodIsClickedCount == 1) {
                                   lowVal = mem8Holder.toString()
                                   lowValResult.value = lowVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 2) {
                                   highVal = mem8Holder.toString()
                                   highValResult.value = highVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 3) {
                                   precision = mem8Holder.toString()
                                   precissionResult.value = precision
                              }
                         }
                    }
                    
                    
                    
                    
                    if (memCLearIsClicked) {
                         mem8FalsiHolder.clear()
                         mem8Value.value = ""
                         memCLearIsClicked = false
                    }
                    
                    quadraticNum1Result.value = falsiNum1Holder
                    secondOperationResult.value = secondOperation
                    quadraticNum2Result.value = falsiNum2Holder
                    firstOperationResult.value = firstOperation
                    x1Result.value = x1
                    x2Result.value = x2
                    quadraticNum3Result.value = falsiNum3Holder
                    x3Result.value = x3
                    thirdOperationResult.value = thirdOperation
                    quadraticNum4Result.value = falsiNum4Holder
                    lowValResult.value = lowVal
                    highValResult.value = highVal
                    precissionResult.value = precision
                    
               }
               else {
                    
                    memIsClickedCount += 1
                    
                    if (mem8Holder == "0") {
                         
                         resultHolder = "0"
                    }
                    
                    if (memCLearIsClicked) {
                         mem8Holder = ""
                         memCLearIsClicked = false
                    }
                    
                    if (memRecordIsClicked) {
                         mem8Holder = ansHolder
                         memRecordIsClicked = false
                         mem8FalsiHolder.clear()
                         Log.e("message", mem8FalsiHolder.toString())
                         Log.e("message", mem8Holder.toString())
                    }
                    
                    if (memIsClickedCount == 2) {
                         if (mem8FalsiHolder.isEmpty()) {
                              if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                        "*"
                                   ) || processHolder.contains(
                                        "/"
                                   )) {
                                   processHolder += mem8Holder
                                   proccessResult.value = processHolder
                                   
                              }
                              else if (processHolder == "") {
                                   
                                   processHolder = mem8Holder
                              }
                              
                              if (resultHolder == "0") {
                                   
                                   resultHolder = "0"
                                   
                              }
                              result.value = resultHolder
                              proccessResult.value = processHolder
                              memIsClickedCount = 1
                              
                              mem8Value.value = mem8Holder
                         }
                    }
               }
               if(!falsiMethodIsClicked) {
                    result.value = resultHolder
                    proccessResult.value = processHolder
                    memIsClickedCount = 1
     
                    mem8Value.value = mem8Holder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun mem9() {
          try {
               if (macroRecordIsClicked) {
                    isClicked = true
                    
                    isClicked = false
                    if (macroRecordIsClicked) {
                         
                         if (macroSet == "1") {
                              
                              array1Holder.add("M9")
                              Log.e(
                                   "array", array1Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array1Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "2") {
                              
                              array2Holder.add("M9")
                              Log.e(
                                   "array", array2Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array2Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "3") {
                              
                              array3Holder.add("M9")
                              Log.e(
                                   "array", array3Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array3Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "4") {
                              
                              array4Holder.add("M9")
                              Log.e(
                                   "array", array4Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array4Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "5") {
                              
                              array5Holder.add("M9")
                              Log.e(
                                   "array", array5Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array5Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "6") {
                              
                              array6Holder.add("M9")
                              Log.e(
                                   "array", array6Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array6Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "7") {
                              
                              array7Holder.add("M9")
                              Log.e(
                                   "array", array7Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array7Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "8") {
                              
                              array8Holder.add("M9")
                              Log.e(
                                   "array", array8Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array8Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "9") {
                              
                              array9Holder.add("M9")
                              Log.e(
                                   "array", array9Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array9Holder.size.toString()
                              )
                         }
                    }
               }
               else if (falsiMethodIsClicked) {
                    
                    if (memRecordIsClicked) {
                         mem9FalsiHolder.clear()
                         
                         mem9FalsiHolder.add(falsiNum1Holder.toString())
                         mem9FalsiHolder.add(x1.toString())
                         mem9FalsiHolder.add(firstOperation.toString())
                         mem9FalsiHolder.add(falsiNum2Holder.toString())
                         mem9FalsiHolder.add(x2.toString())
                         mem9FalsiHolder.add(secondOperation.toString())
                         mem9FalsiHolder.add(falsiNum3Holder.toString())
                         mem9FalsiHolder.add(x3.toString())
                         mem9FalsiHolder.add(thirdOperation.toString())
                         mem9FalsiHolder.add(falsiNum4Holder.toString())
                         
                         
                         Log.e("message", mem9FalsiHolder.toString())
                         mem9Value.value =
                             mem9FalsiHolder.toString()
                                 .dropLast(1)
                                 .drop(1)
                                 .replace(",", "")
                                 .replace(" ", "")
                         mem9Holder = ""
                         mem9FalsiHolder.add(lowVal.toString())
                         mem9FalsiHolder.add(highVal.toString())
                         mem9FalsiHolder.add(precision.toString())
                         memRecordIsClicked = false
                    }
                    
                    if (mem9FalsiHolder.isNotEmpty() && !memRecordIsClicked) {
                         Log.e("message", mem9FalsiHolder.toString())
                         secondOperation = mem9FalsiHolder[5].toString()
                         falsiNum3Holder = mem9FalsiHolder[6].toString()
                         falsiNum1Holder = mem9FalsiHolder[0].toString()
                         x1 = mem9FalsiHolder[1].toString()
                         firstOperation = mem9FalsiHolder[2].toString()
                         falsiNum2Holder = mem9FalsiHolder[3].toString()
                         x2 = mem9FalsiHolder[4].toString()
                         x3 = mem9FalsiHolder[7].toString()
                         thirdOperation = mem9FalsiHolder[8].toString()
                         falsiNum4Holder = mem9FalsiHolder[9].toString()
                         lowVal = mem9FalsiHolder[10].toString()
                         highVal = mem9FalsiHolder[11].toString()
                         precision = mem9FalsiHolder[12].toString()
                         
                    }
                    else {
                         
                         if (falsiNum1Holder!!.isEmpty()) {
                              falsiNum1Holder = mem9Holder.toString()
                              quadraticNum1Result.value = falsiNum1Holder
                         }
                         else if (firstOperation!!.isEmpty()) {
                              if (mem9Holder.toString()
                                       .contains("-")) {
                                   
                                   firstOperation = "-"
                                   stringHolder = mem9Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                                   
                              }
                              else {
                                   firstOperation = "+"
                                   stringHolder = mem9Holder
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                              }
                         }
                         else if (secondOperation!!.isEmpty()) {
                              
                              if (mem9Holder.toString()
                                       .contains("-")) {
                                   secondOperation = "-"
                                   stringHolder = mem9Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                                   
                              }
                              else {
                                   secondOperation = "+"
                                   stringHolder = mem9Holder
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                              }
                         }
                         else {
                              if (mem9Holder.toString()
                                       .contains("-")) {
                                   
                                   thirdOperation = "-"
                                   stringHolder = mem9Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                                   
                              }
                              else {
                                   thirdOperation = "+"
                                   stringHolder = mem9Holder
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                              }
                              
                              if (falsiMethodIsClickedCount == 1) {
                                   lowVal = mem9Holder.toString()
                                   lowValResult.value = lowVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 2) {
                                   highVal = mem9Holder.toString()
                                   highValResult.value = highVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 3) {
                                   precision = mem9Holder.toString()
                                   precissionResult.value = precision
                              }
                         }
                    }
                    
                    
                    
                    
                    if (memCLearIsClicked) {
                         mem9FalsiHolder.clear()
                         mem9Value.value = ""
                         memCLearIsClicked = false
                    }
                    
                    quadraticNum1Result.value = falsiNum1Holder
                    secondOperationResult.value = secondOperation
                    quadraticNum2Result.value = falsiNum2Holder
                    firstOperationResult.value = firstOperation
                    x1Result.value = x1
                    x2Result.value = x2
                    quadraticNum3Result.value = falsiNum3Holder
                    x3Result.value = x3
                    thirdOperationResult.value = thirdOperation
                    quadraticNum4Result.value = falsiNum4Holder
                    lowValResult.value = lowVal
                    highValResult.value = highVal
                    precissionResult.value = precision
                    
               }
               else {
                    
                    memIsClickedCount += 1
                    
                    if (mem9Holder == "0") {
                         
                         resultHolder = "0"
                    }
                    
                    if (memCLearIsClicked) {
                         mem9Holder = ""
                         memCLearIsClicked = false
                    }
                    
                    if (memRecordIsClicked) {
                         mem9Holder = ansHolder
                         memRecordIsClicked = false
                         mem9FalsiHolder.clear()
                         Log.e("message", mem9FalsiHolder.toString())
                         Log.e("message", mem9Holder.toString())
                    }
                    
                    if (memIsClickedCount == 2) {
                         if (mem9FalsiHolder.isEmpty()) {
                              if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                        "*"
                                   ) || processHolder.contains(
                                        "/"
                                   )) {
                                   processHolder += mem9Holder
                                   proccessResult.value = processHolder
                                   
                              }
                              else if (processHolder == "") {
                                   
                                   processHolder = mem9Holder
                              }
                              
                              if (resultHolder == "0") {
                                   
                                   resultHolder = "0"
                                   
                              }
                              result.value = resultHolder
                              proccessResult.value = processHolder
                              memIsClickedCount = 1
                              
                              mem9Value.value = mem9Holder
                         }
                    }
               }
               if(!falsiMethodIsClicked) {
                    result.value = resultHolder
                    proccessResult.value = processHolder
                    memIsClickedCount = 1
     
                    mem9Value.value = mem9Holder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun mem10() {
          try {
               if (macroRecordIsClicked) {
                    isClicked = true
                    
                    isClicked = false
                    if (macroRecordIsClicked) {
                         
                         if (macroSet == "1") {
                              
                              array1Holder.add("M10")
                              Log.e(
                                   "array", array1Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array1Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "2") {
                              
                              array2Holder.add("M10")
                              Log.e(
                                   "array", array2Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array2Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "3") {
                              
                              array3Holder.add("M10")
                              Log.e(
                                   "array", array3Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array3Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "4") {
                              
                              array4Holder.add("M10")
                              Log.e(
                                   "array", array4Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array4Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "5") {
                              
                              array5Holder.add("M10")
                              Log.e(
                                   "array", array5Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array5Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "6") {
                              
                              array6Holder.add("M10")
                              Log.e(
                                   "array", array6Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array6Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "7") {
                              
                              array7Holder.add("M10")
                              Log.e(
                                   "array", array7Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array7Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "8") {
                              
                              array8Holder.add("M10")
                              Log.e(
                                   "array", array8Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array8Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "9") {
                              
                              array9Holder.add("M10")
                              Log.e(
                                   "array", array9Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array9Holder.size.toString()
                              )
                         }
                    }
               }
               else if (falsiMethodIsClicked) {
                    
                    if (memRecordIsClicked) {
                         mem10FalsiHolder.clear()
                         
                         mem10FalsiHolder.add(falsiNum1Holder.toString())
                         mem10FalsiHolder.add(x1.toString())
                         mem10FalsiHolder.add(firstOperation.toString())
                         mem10FalsiHolder.add(falsiNum2Holder.toString())
                         mem10FalsiHolder.add(x2.toString())
                         mem10FalsiHolder.add(secondOperation.toString())
                         mem10FalsiHolder.add(falsiNum3Holder.toString())
                         mem10FalsiHolder.add(x3.toString())
                         mem10FalsiHolder.add(thirdOperation.toString())
                         mem10FalsiHolder.add(falsiNum4Holder.toString())
                         
                         
                         Log.e("message", mem10FalsiHolder.toString())
                         mem10Value.value =
                             mem10FalsiHolder.toString()
                                 .dropLast(1)
                                 .drop(1)
                                 .replace(",", "")
                                 .replace(" ", "")
                         mem10Holder = ""
                         mem10FalsiHolder.add(lowVal.toString())
                         mem10FalsiHolder.add(highVal.toString())
                         mem10FalsiHolder.add(precision.toString())
                         memRecordIsClicked = false
                    }
                    
                    if (mem10FalsiHolder.isNotEmpty() && !memRecordIsClicked) {
                         Log.e("message", mem10FalsiHolder.toString())
                         secondOperation = mem10FalsiHolder[5].toString()
                         falsiNum3Holder = mem10FalsiHolder[6].toString()
                         falsiNum1Holder = mem10FalsiHolder[0].toString()
                         x1 = mem10FalsiHolder[1].toString()
                         firstOperation = mem10FalsiHolder[2].toString()
                         falsiNum2Holder = mem10FalsiHolder[3].toString()
                         x2 = mem10FalsiHolder[4].toString()
                         x3 = mem10FalsiHolder[7].toString()
                         thirdOperation = mem10FalsiHolder[8].toString()
                         falsiNum4Holder = mem10FalsiHolder[9].toString()
                         lowVal = mem10FalsiHolder[10].toString()
                         highVal = mem10FalsiHolder[11].toString()
                         precision = mem10FalsiHolder[12].toString()
                         
                    }
                    else {
                         
                         if (falsiNum1Holder!!.isEmpty()) {
                              falsiNum1Holder = mem10Holder.toString()
                              quadraticNum1Result.value = falsiNum1Holder
                         }
                         else if (firstOperation!!.isEmpty()) {
                              if (mem10Holder.toString()
                                       .contains("-")) {
                                   
                                   firstOperation = "-"
                                   stringHolder = mem10Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                                   
                              }
                              else {
                                   firstOperation = "+"
                                   stringHolder = mem10Holder
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                              }
                         }
                         else if (secondOperation!!.isEmpty()) {
                              
                              if (mem10Holder.toString()
                                       .contains("-")) {
                                   secondOperation = "-"
                                   stringHolder = mem10Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                                   
                              }
                              else {
                                   secondOperation = "+"
                                   stringHolder = mem10Holder
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                              }
                         }
                         else {
                              if (mem10Holder.toString()
                                       .contains("-")) {
                                   
                                   thirdOperation = "-"
                                   stringHolder = mem10Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                                   
                              }
                              else {
                                   thirdOperation = "+"
                                   stringHolder = mem10Holder
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                              }
                              
                              if (falsiMethodIsClickedCount == 1) {
                                   lowVal = mem10Holder.toString()
                                   lowValResult.value = lowVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 2) {
                                   highVal = mem10Holder.toString()
                                   highValResult.value = highVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 3) {
                                   precision = mem10Holder.toString()
                                   precissionResult.value = precision
                              }
                         }
                    }
                    
                    
                    
                    
                    if (memCLearIsClicked) {
                         mem10FalsiHolder.clear()
                         mem10Value.value = ""
                         memCLearIsClicked = false
                    }
                    
                    quadraticNum1Result.value = falsiNum1Holder
                    secondOperationResult.value = secondOperation
                    quadraticNum2Result.value = falsiNum2Holder
                    firstOperationResult.value = firstOperation
                    x1Result.value = x1
                    x2Result.value = x2
                    quadraticNum3Result.value = falsiNum3Holder
                    x3Result.value = x3
                    thirdOperationResult.value = thirdOperation
                    quadraticNum4Result.value = falsiNum4Holder
                    lowValResult.value = lowVal
                    highValResult.value = highVal
                    precissionResult.value = precision
                    
               }
               else {
                    
                    memIsClickedCount += 1
                    
                    if (mem10Holder == "0") {
                         
                         resultHolder = "0"
                    }
                    
                    if (memCLearIsClicked) {
                         mem10Holder = ""
                         memCLearIsClicked = false
                    }
                    
                    if (memRecordIsClicked) {
                         mem10Holder = ansHolder
                         memRecordIsClicked = false
                         mem10FalsiHolder.clear()
                         Log.e("message", mem10FalsiHolder.toString())
                         Log.e("message", mem10Holder.toString())
                    }
                    
                    if (memIsClickedCount == 2) {
                         if (mem10FalsiHolder.isEmpty()) {
                              if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                        "*"
                                   ) || processHolder.contains(
                                        "/"
                                   )) {
                                   processHolder += mem10Holder
                                   proccessResult.value = processHolder
                                   
                              }
                              else if (processHolder == "") {
                                   
                                   processHolder = mem10Holder
                              }
                              
                              if (resultHolder == "0") {
                                   
                                   resultHolder = "0"
                                   
                              }
                              result.value = resultHolder
                              proccessResult.value = processHolder
                              memIsClickedCount = 1
                              
                              mem10Value.value = mem10Holder
                         }
                    }
               }
               if(!falsiMethodIsClicked) {
                    result.value = resultHolder
                    proccessResult.value = processHolder
                    memIsClickedCount = 1
     
                    mem10Value.value = mem10Holder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun mem11() {
          try {
               if (macroRecordIsClicked) {
                    isClicked = true
                    
                    isClicked = false
                    if (macroRecordIsClicked) {
                         
                         if (macroSet == "1") {
                              
                              array1Holder.add("M11")
                              Log.e(
                                   "array", array1Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array1Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "2") {
                              
                              array2Holder.add("M11")
                              Log.e(
                                   "array", array2Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array2Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "3") {
                              
                              array3Holder.add("M11")
                              Log.e(
                                   "array", array3Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array3Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "4") {
                              
                              array4Holder.add("M11")
                              Log.e(
                                   "array", array4Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array4Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "5") {
                              
                              array5Holder.add("M11")
                              Log.e(
                                   "array", array5Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array5Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "6") {
                              
                              array6Holder.add("M11")
                              Log.e(
                                   "array", array6Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array6Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "7") {
                              
                              array7Holder.add("M11")
                              Log.e(
                                   "array", array7Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array7Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "8") {
                              
                              array8Holder.add("M11")
                              Log.e(
                                   "array", array8Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array8Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "9") {
                              
                              array9Holder.add("M11")
                              Log.e(
                                   "array", array9Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array9Holder.size.toString()
                              )
                         }
                    }
               }
               else if (falsiMethodIsClicked) {
                    
                    if (memRecordIsClicked) {
                         mem11FalsiHolder.clear()
                         
                         mem11FalsiHolder.add(falsiNum1Holder.toString())
                         mem11FalsiHolder.add(x1.toString())
                         mem11FalsiHolder.add(firstOperation.toString())
                         mem11FalsiHolder.add(falsiNum2Holder.toString())
                         mem11FalsiHolder.add(x2.toString())
                         mem11FalsiHolder.add(secondOperation.toString())
                         mem11FalsiHolder.add(falsiNum3Holder.toString())
                         mem11FalsiHolder.add(x3.toString())
                         mem11FalsiHolder.add(thirdOperation.toString())
                         mem11FalsiHolder.add(falsiNum4Holder.toString())
                         
                         
                         Log.e("message", mem11FalsiHolder.toString())
                         mem11Value.value =
                             mem11FalsiHolder.toString()
                                 .dropLast(1)
                                 .drop(1)
                                 .replace(",", "")
                                 .replace(" ", "")
                         mem11Holder = ""
                         mem11FalsiHolder.add(lowVal.toString())
                         mem11FalsiHolder.add(highVal.toString())
                         mem11FalsiHolder.add(precision.toString())
                         memRecordIsClicked = false
                    }
                    
                    if (mem11FalsiHolder.isNotEmpty() && !memRecordIsClicked) {
                         Log.e("message", mem11FalsiHolder.toString())
                         secondOperation = mem11FalsiHolder[5].toString()
                         falsiNum3Holder = mem11FalsiHolder[6].toString()
                         falsiNum1Holder = mem11FalsiHolder[0].toString()
                         x1 = mem11FalsiHolder[1].toString()
                         firstOperation = mem11FalsiHolder[2].toString()
                         falsiNum2Holder = mem11FalsiHolder[3].toString()
                         x2 = mem11FalsiHolder[4].toString()
                         x3 = mem11FalsiHolder[7].toString()
                         thirdOperation = mem11FalsiHolder[8].toString()
                         falsiNum4Holder = mem11FalsiHolder[9].toString()
                         lowVal = mem11FalsiHolder[10].toString()
                         highVal = mem11FalsiHolder[11].toString()
                         precision = mem11FalsiHolder[12].toString()
                         
                    }
                    else {
                         
                         if (falsiNum1Holder!!.isEmpty()) {
                              falsiNum1Holder = mem11Holder.toString()
                              quadraticNum1Result.value = falsiNum1Holder
                         }
                         else if (firstOperation!!.isEmpty()) {
                              if (mem11Holder.toString()
                                       .contains("-")) {
                                   
                                   firstOperation = "-"
                                   stringHolder = mem11Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                                   
                              }
                              else {
                                   firstOperation = "+"
                                   stringHolder = mem11Holder
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                              }
                         }
                         else if (secondOperation!!.isEmpty()) {
                              
                              if (mem11Holder.toString()
                                       .contains("-")) {
                                   secondOperation = "-"
                                   stringHolder = mem11Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                                   
                              }
                              else {
                                   secondOperation = "+"
                                   stringHolder = mem11Holder
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                              }
                         }
                         else {
                              if (mem11Holder.toString()
                                       .contains("-")) {
                                   
                                   thirdOperation = "-"
                                   stringHolder = mem11Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                                   
                              }
                              else {
                                   thirdOperation = "+"
                                   stringHolder = mem11Holder
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                              }
                              
                              if (falsiMethodIsClickedCount == 1) {
                                   lowVal = mem11Holder.toString()
                                   lowValResult.value = lowVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 2) {
                                   highVal = mem11Holder.toString()
                                   highValResult.value = highVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 3) {
                                   precision = mem11Holder.toString()
                                   precissionResult.value = precision
                              }
                         }
                    }
                    
                    
                    
                    
                    if (memCLearIsClicked) {
                         mem11FalsiHolder.clear()
                         mem11Value.value = ""
                         memCLearIsClicked = false
                    }
                    
                    quadraticNum1Result.value = falsiNum1Holder
                    secondOperationResult.value = secondOperation
                    quadraticNum2Result.value = falsiNum2Holder
                    firstOperationResult.value = firstOperation
                    x1Result.value = x1
                    x2Result.value = x2
                    quadraticNum3Result.value = falsiNum3Holder
                    x3Result.value = x3
                    thirdOperationResult.value = thirdOperation
                    quadraticNum4Result.value = falsiNum4Holder
                    lowValResult.value = lowVal
                    highValResult.value = highVal
                    precissionResult.value = precision
                    
               }
               else {
                    
                    memIsClickedCount += 1
                    
                    if (mem11Holder == "0") {
                         
                         resultHolder = "0"
                    }
                    
                    if (memCLearIsClicked) {
                         mem11Holder = ""
                         memCLearIsClicked = false
                    }
                    
                    if (memRecordIsClicked) {
                         mem11Holder = ansHolder
                         memRecordIsClicked = false
                         mem11FalsiHolder.clear()
                         Log.e("message", mem11FalsiHolder.toString())
                         Log.e("message", mem11Holder.toString())
                    }
                    
                    if (memIsClickedCount == 2) {
                         if (mem11FalsiHolder.isEmpty()) {
                              if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                        "*"
                                   ) || processHolder.contains(
                                        "/"
                                   )) {
                                   processHolder += mem11Holder
                                   proccessResult.value = processHolder
                                   
                              }
                              else if (processHolder == "") {
                                   
                                   processHolder = mem11Holder
                              }
                              
                              if (resultHolder == "0") {
                                   
                                   resultHolder = "0"
                                   
                              }
                              result.value = resultHolder
                              proccessResult.value = processHolder
                              memIsClickedCount = 1
                              
                              mem11Value.value = mem11Holder
                         }
                    }
               }
               if(!falsiMethodIsClicked) {
                    result.value = resultHolder
                    proccessResult.value = processHolder
                    memIsClickedCount = 1
     
                    mem11Value.value = mem11Holder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun mem12() {
          try {
               if (macroRecordIsClicked) {
                    isClicked = true
                    
                    isClicked = false
                    if (macroRecordIsClicked) {
                         
                         if (macroSet == "1") {
                              
                              array1Holder.add("M12")
                              Log.e(
                                   "array", array1Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array1Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "2") {
                              
                              array2Holder.add("M12")
                              Log.e(
                                   "array", array2Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array2Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "3") {
                              
                              array3Holder.add("M12")
                              Log.e(
                                   "array", array3Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array3Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "4") {
                              
                              array4Holder.add("M12")
                              Log.e(
                                   "array", array4Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array4Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "5") {
                              
                              array5Holder.add("M12")
                              Log.e(
                                   "array", array5Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array5Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "6") {
                              
                              array6Holder.add("M12")
                              Log.e(
                                   "array", array6Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array6Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "7") {
                              
                              array7Holder.add("M12")
                              Log.e(
                                   "array", array7Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array7Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "8") {
                              
                              array8Holder.add("M12")
                              Log.e(
                                   "array", array8Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array8Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "9") {
                              
                              array9Holder.add("M12")
                              Log.e(
                                   "array", array9Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array9Holder.size.toString()
                              )
                         }
                    }
               }
               else if (falsiMethodIsClicked) {
                    
                    if (memRecordIsClicked) {
                         mem12FalsiHolder.clear()
                         
                         mem12FalsiHolder.add(falsiNum1Holder.toString())
                         mem12FalsiHolder.add(x1.toString())
                         mem12FalsiHolder.add(firstOperation.toString())
                         mem12FalsiHolder.add(falsiNum2Holder.toString())
                         mem12FalsiHolder.add(x2.toString())
                         mem12FalsiHolder.add(secondOperation.toString())
                         mem12FalsiHolder.add(falsiNum3Holder.toString())
                         mem12FalsiHolder.add(x3.toString())
                         mem12FalsiHolder.add(thirdOperation.toString())
                         mem12FalsiHolder.add(falsiNum4Holder.toString())
                         
                         
                         Log.e("message", mem12FalsiHolder.toString())
                         mem12Value.value =
                             mem12FalsiHolder.toString()
                                 .dropLast(1)
                                 .drop(1)
                                 .replace(",", "")
                                 .replace(" ", "")
                         mem12Holder = ""
                         mem12FalsiHolder.add(lowVal.toString())
                         mem12FalsiHolder.add(highVal.toString())
                         mem12FalsiHolder.add(precision.toString())
                         memRecordIsClicked = false
                    }
                    
                    if (mem12FalsiHolder.isNotEmpty() && !memRecordIsClicked) {
                         Log.e("message", mem12FalsiHolder.toString())
                         secondOperation = mem12FalsiHolder[5].toString()
                         falsiNum3Holder = mem12FalsiHolder[6].toString()
                         falsiNum1Holder = mem12FalsiHolder[0].toString()
                         x1 = mem12FalsiHolder[1].toString()
                         firstOperation = mem12FalsiHolder[2].toString()
                         falsiNum2Holder = mem12FalsiHolder[3].toString()
                         x2 = mem12FalsiHolder[4].toString()
                         x3 = mem12FalsiHolder[7].toString()
                         thirdOperation = mem12FalsiHolder[8].toString()
                         falsiNum4Holder = mem12FalsiHolder[9].toString()
                         lowVal = mem12FalsiHolder[10].toString()
                         highVal = mem12FalsiHolder[11].toString()
                         precision = mem12FalsiHolder[12].toString()
                         
                    }
                    else {
                         
                         if (falsiNum1Holder!!.isEmpty()) {
                              falsiNum1Holder = mem12Holder.toString()
                              quadraticNum1Result.value = falsiNum1Holder
                         }
                         else if (firstOperation!!.isEmpty()) {
                              if (mem12Holder.toString()
                                       .contains("-")) {
                                   
                                   firstOperation = "-"
                                   stringHolder = mem12Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                                   
                              }
                              else {
                                   firstOperation = "+"
                                   stringHolder = mem12Holder
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                              }
                         }
                         else if (secondOperation!!.isEmpty()) {
                              
                              if (mem12Holder.toString()
                                       .contains("-")) {
                                   secondOperation = "-"
                                   stringHolder = mem12Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                                   
                              }
                              else {
                                   secondOperation = "+"
                                   stringHolder = mem12Holder
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                              }
                         }
                         else {
                              if (mem12Holder.toString()
                                       .contains("-")) {
                                   
                                   thirdOperation = "-"
                                   stringHolder = mem12Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                                   
                              }
                              else {
                                   thirdOperation = "+"
                                   stringHolder = mem12Holder
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                              }
                              
                              if (falsiMethodIsClickedCount == 1) {
                                   lowVal = mem12Holder.toString()
                                   lowValResult.value = lowVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 2) {
                                   highVal = mem12Holder.toString()
                                   highValResult.value = highVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 3) {
                                   precision = mem12Holder.toString()
                                   precissionResult.value = precision
                              }
                         }
                    }
                    
                    
                    
                    
                    if (memCLearIsClicked) {
                         mem12FalsiHolder.clear()
                         mem12Value.value = ""
                         memCLearIsClicked = false
                    }
                    
                    quadraticNum1Result.value = falsiNum1Holder
                    secondOperationResult.value = secondOperation
                    quadraticNum2Result.value = falsiNum2Holder
                    firstOperationResult.value = firstOperation
                    x1Result.value = x1
                    x2Result.value = x2
                    quadraticNum3Result.value = falsiNum3Holder
                    x3Result.value = x3
                    thirdOperationResult.value = thirdOperation
                    quadraticNum4Result.value = falsiNum4Holder
                    lowValResult.value = lowVal
                    highValResult.value = highVal
                    precissionResult.value = precision
                    
               }
               else {
                    
                    memIsClickedCount += 1
                    
                    if (mem12Holder == "0") {
                         
                         resultHolder = "0"
                    }
                    
                    if (memCLearIsClicked) {
                         mem12Holder = ""
                         memCLearIsClicked = false
                    }
                    
                    if (memRecordIsClicked) {
                         mem12Holder = ansHolder
                         memRecordIsClicked = false
                         mem12FalsiHolder.clear()
                         Log.e("message", mem12FalsiHolder.toString())
                         Log.e("message", mem12Holder.toString())
                    }
                    
                    if (memIsClickedCount == 2) {
                         if (mem12FalsiHolder.isEmpty()) {
                              if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                        "*"
                                   ) || processHolder.contains(
                                        "/"
                                   )) {
                                   processHolder += mem12Holder
                                   proccessResult.value = processHolder
                                   
                              }
                              else if (processHolder == "") {
                                   
                                   processHolder = mem12Holder
                              }
                              
                              if (resultHolder == "0") {
                                   
                                   resultHolder = "0"
                                   
                              }
                              result.value = resultHolder
                              proccessResult.value = processHolder
                              memIsClickedCount = 1
                              
                              mem2Value.value = mem12Holder
                         }
                    }
               }
               if(!falsiMethodIsClicked) {
                    result.value = resultHolder
                    proccessResult.value = processHolder
                    memIsClickedCount = 1
     
                    mem12Value.value = mem12Holder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun mem13() {
          try {
               if (macroRecordIsClicked) {
                    isClicked = true
                    
                    isClicked = false
                    if (macroRecordIsClicked) {
                         
                         if (macroSet == "1") {
                              
                              array1Holder.add("M13")
                              Log.e(
                                   "array", array1Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array1Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "2") {
                              
                              array2Holder.add("M13")
                              Log.e(
                                   "array", array2Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array2Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "3") {
                              
                              array3Holder.add("M13")
                              Log.e(
                                   "array", array3Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array3Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "4") {
                              
                              array4Holder.add("M13")
                              Log.e(
                                   "array", array4Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array4Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "5") {
                              
                              array5Holder.add("M13")
                              Log.e(
                                   "array", array5Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array5Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "6") {
                              
                              array6Holder.add("M13")
                              Log.e(
                                   "array", array6Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array6Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "7") {
                              
                              array7Holder.add("M13")
                              Log.e(
                                   "array", array7Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array7Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "8") {
                              
                              array8Holder.add("M13")
                              Log.e(
                                   "array", array8Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array8Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "9") {
                              
                              array9Holder.add("M13")
                              Log.e(
                                   "array", array9Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array9Holder.size.toString()
                              )
                         }
                    }
               }
               else if (falsiMethodIsClicked) {
                    
                    if (memRecordIsClicked) {
                         mem13FalsiHolder.clear()
                         
                         mem13FalsiHolder.add(falsiNum1Holder.toString())
                         mem13FalsiHolder.add(x1.toString())
                         mem13FalsiHolder.add(firstOperation.toString())
                         mem13FalsiHolder.add(falsiNum2Holder.toString())
                         mem13FalsiHolder.add(x2.toString())
                         mem13FalsiHolder.add(secondOperation.toString())
                         mem13FalsiHolder.add(falsiNum3Holder.toString())
                         mem13FalsiHolder.add(x3.toString())
                         mem13FalsiHolder.add(thirdOperation.toString())
                         mem13FalsiHolder.add(falsiNum4Holder.toString())
                         
                         
                         Log.e("message", mem13FalsiHolder.toString())
                         mem13Value.value =
                             mem13FalsiHolder.toString()
                                 .dropLast(1)
                                 .drop(1)
                                 .replace(",", "")
                                 .replace(" ", "")
                         mem13Holder = ""
                         mem13FalsiHolder.add(lowVal.toString())
                         mem13FalsiHolder.add(highVal.toString())
                         mem13FalsiHolder.add(precision.toString())
                         memRecordIsClicked = false
                    }
                    
                    if (mem13FalsiHolder.isNotEmpty() && !memRecordIsClicked) {
                         Log.e("message", mem13FalsiHolder.toString())
                         secondOperation = mem13FalsiHolder[5].toString()
                         falsiNum3Holder = mem13FalsiHolder[6].toString()
                         falsiNum1Holder = mem13FalsiHolder[0].toString()
                         x1 = mem13FalsiHolder[1].toString()
                         firstOperation = mem13FalsiHolder[2].toString()
                         falsiNum2Holder = mem13FalsiHolder[3].toString()
                         x2 = mem13FalsiHolder[4].toString()
                         x3 = mem13FalsiHolder[7].toString()
                         thirdOperation = mem13FalsiHolder[8].toString()
                         falsiNum4Holder = mem13FalsiHolder[9].toString()
                         lowVal = mem13FalsiHolder[10].toString()
                         highVal = mem13FalsiHolder[11].toString()
                         precision = mem13FalsiHolder[12].toString()
                         
                    }
                    else {
                         
                         if (falsiNum1Holder!!.isEmpty()) {
                              falsiNum1Holder = mem13Holder.toString()
                              quadraticNum1Result.value = falsiNum1Holder
                         }
                         else if (firstOperation!!.isEmpty()) {
                              if (mem13Holder.toString()
                                       .contains("-")) {
                                   
                                   firstOperation = "-"
                                   stringHolder = mem13Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                                   
                              }
                              else {
                                   firstOperation = "+"
                                   stringHolder = mem13Holder
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                              }
                         }
                         else if (secondOperation!!.isEmpty()) {
                              
                              if (mem13Holder.toString()
                                       .contains("-")) {
                                   secondOperation = "-"
                                   stringHolder = mem13Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                                   
                              }
                              else {
                                   secondOperation = "+"
                                   stringHolder = mem13Holder
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                              }
                         }
                         else {
                              if (mem13Holder.toString()
                                       .contains("-")) {
                                   
                                   thirdOperation = "-"
                                   stringHolder = mem13Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                                   
                              }
                              else {
                                   thirdOperation = "+"
                                   stringHolder = mem13Holder
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                              }
                              
                              if (falsiMethodIsClickedCount == 1) {
                                   lowVal = mem13Holder.toString()
                                   lowValResult.value = lowVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 2) {
                                   highVal = mem13Holder.toString()
                                   highValResult.value = highVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 3) {
                                   precision = mem13Holder.toString()
                                   precissionResult.value = precision
                              }
                         }
                    }
                    
                    
                    
                    
                    if (memCLearIsClicked) {
                         mem13FalsiHolder.clear()
                         mem13Value.value = ""
                         memCLearIsClicked = false
                    }
                    
                    quadraticNum1Result.value = falsiNum1Holder
                    secondOperationResult.value = secondOperation
                    quadraticNum2Result.value = falsiNum2Holder
                    firstOperationResult.value = firstOperation
                    x1Result.value = x1
                    x2Result.value = x2
                    quadraticNum3Result.value = falsiNum3Holder
                    x3Result.value = x3
                    thirdOperationResult.value = thirdOperation
                    quadraticNum4Result.value = falsiNum4Holder
                    lowValResult.value = lowVal
                    highValResult.value = highVal
                    precissionResult.value = precision
                    
               }
               else {
                    
                    memIsClickedCount += 1
                    
                    if (mem13Holder == "0") {
                         
                         resultHolder = "0"
                    }
                    
                    if (memCLearIsClicked) {
                         mem13Holder = ""
                         memCLearIsClicked = false
                    }
                    
                    if (memRecordIsClicked) {
                         mem13Holder = ansHolder
                         memRecordIsClicked = false
                         mem13FalsiHolder.clear()
                         Log.e("message", mem13FalsiHolder.toString())
                         Log.e("message", mem13Holder.toString())
                    }
                    
                    if (memIsClickedCount == 2) {
                         if (mem13FalsiHolder.isEmpty()) {
                              if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                        "*"
                                   ) || processHolder.contains(
                                        "/"
                                   )) {
                                   processHolder += mem13Holder
                                   proccessResult.value = processHolder
                                   
                              }
                              else if (processHolder == "") {
                                   
                                   processHolder = mem13Holder
                              }
                              
                              if (resultHolder == "0") {
                                   
                                   resultHolder = "0"
                                   
                              }
                              result.value = resultHolder
                              proccessResult.value = processHolder
                              memIsClickedCount = 1
     
                              mem2Value.value = mem12Holder
                         }
                    }
               }
               if(!falsiMethodIsClicked) {
                    result.value = resultHolder
                    proccessResult.value = processHolder
                    memIsClickedCount = 1
     
                    mem13Value.value = mem13Holder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun mem14() {
          try {
               if (macroRecordIsClicked) {
                    isClicked = true
                    
                    isClicked = false
                    if (macroRecordIsClicked) {
                         
                         if (macroSet == "1") {
                              
                              array1Holder.add("M14")
                              Log.e(
                                   "array", array1Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array1Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "2") {
                              
                              array2Holder.add("M14")
                              Log.e(
                                   "array", array2Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array2Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "3") {
                              
                              array3Holder.add("M14")
                              Log.e(
                                   "array", array3Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array3Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "4") {
                              
                              array4Holder.add("M14")
                              Log.e(
                                   "array", array4Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array4Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "5") {
                              
                              array5Holder.add("M14")
                              Log.e(
                                   "array", array5Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array5Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "6") {
                              
                              array6Holder.add("M14")
                              Log.e(
                                   "array", array6Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array6Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "7") {
                              
                              array7Holder.add("M14")
                              Log.e(
                                   "array", array7Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array7Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "8") {
                              
                              array8Holder.add("M14")
                              Log.e(
                                   "array", array8Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array8Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "9") {
                              
                              array9Holder.add("M14")
                              Log.e(
                                   "array", array9Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array9Holder.size.toString()
                              )
                         }
                    }
               }
               else if (falsiMethodIsClicked) {
                    
                    if (memRecordIsClicked) {
                         mem14FalsiHolder.clear()
                         
                         mem14FalsiHolder.add(falsiNum1Holder.toString())
                         mem14FalsiHolder.add(x1.toString())
                         mem14FalsiHolder.add(firstOperation.toString())
                         mem14FalsiHolder.add(falsiNum2Holder.toString())
                         mem14FalsiHolder.add(x2.toString())
                         mem14FalsiHolder.add(secondOperation.toString())
                         mem14FalsiHolder.add(falsiNum3Holder.toString())
                         mem14FalsiHolder.add(x3.toString())
                         mem14FalsiHolder.add(thirdOperation.toString())
                         mem14FalsiHolder.add(falsiNum4Holder.toString())
                         
                         
                         Log.e("message", mem14FalsiHolder.toString())
                         mem14Value.value =
                             mem14FalsiHolder.toString()
                                 .dropLast(1)
                                 .drop(1)
                                 .replace(",", "")
                                 .replace(" ", "")
                         mem14Holder = ""
                         mem14FalsiHolder.add(lowVal.toString())
                         mem14FalsiHolder.add(highVal.toString())
                         mem14FalsiHolder.add(precision.toString())
                         memRecordIsClicked = false
                    }
                    
                    if (mem14FalsiHolder.isNotEmpty() && !memRecordIsClicked) {
                         Log.e("message", mem14FalsiHolder.toString())
                         secondOperation = mem14FalsiHolder[5].toString()
                         falsiNum3Holder = mem14FalsiHolder[6].toString()
                         falsiNum1Holder = mem14FalsiHolder[0].toString()
                         x1 = mem14FalsiHolder[1].toString()
                         firstOperation = mem14FalsiHolder[2].toString()
                         falsiNum2Holder = mem14FalsiHolder[3].toString()
                         x2 = mem14FalsiHolder[4].toString()
                         x3 = mem14FalsiHolder[7].toString()
                         thirdOperation = mem14FalsiHolder[8].toString()
                         falsiNum4Holder = mem14FalsiHolder[9].toString()
                         lowVal = mem14FalsiHolder[10].toString()
                         highVal = mem14FalsiHolder[11].toString()
                         precision = mem14FalsiHolder[12].toString()
                         
                    }
                    else {
                         
                         if (falsiNum1Holder!!.isEmpty()) {
                              falsiNum1Holder = mem14Holder.toString()
                              quadraticNum1Result.value = falsiNum1Holder
                         }
                         else if (firstOperation!!.isEmpty()) {
                              if (mem14Holder.toString()
                                       .contains("-")) {
                                   
                                   firstOperation = "-"
                                   stringHolder = mem14Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                                   
                              }
                              else {
                                   firstOperation = "+"
                                   stringHolder = mem14Holder
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                              }
                         }
                         else if (secondOperation!!.isEmpty()) {
                              
                              if (mem14Holder.toString()
                                       .contains("-")) {
                                   secondOperation = "-"
                                   stringHolder = mem14Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                                   
                              }
                              else {
                                   secondOperation = "+"
                                   stringHolder = mem14Holder
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                              }
                         }
                         else {
                              if (mem14Holder.toString()
                                       .contains("-")) {
                                   
                                   thirdOperation = "-"
                                   stringHolder = mem14Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                                   
                              }
                              else {
                                   thirdOperation = "+"
                                   stringHolder = mem14Holder
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                              }
                              
                              if (falsiMethodIsClickedCount == 1) {
                                   lowVal = mem14Holder.toString()
                                   lowValResult.value = lowVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 2) {
                                   highVal = mem14Holder.toString()
                                   highValResult.value = highVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 3) {
                                   precision = mem14Holder.toString()
                                   precissionResult.value = precision
                              }
                         }
                    }
                    
                    
                    
                    
                    if (memCLearIsClicked) {
                         mem14FalsiHolder.clear()
                         mem14Value.value = ""
                         memCLearIsClicked = false
                    }
                    
                    quadraticNum1Result.value = falsiNum1Holder
                    secondOperationResult.value = secondOperation
                    quadraticNum2Result.value = falsiNum2Holder
                    firstOperationResult.value = firstOperation
                    x1Result.value = x1
                    x2Result.value = x2
                    quadraticNum3Result.value = falsiNum3Holder
                    x3Result.value = x3
                    thirdOperationResult.value = thirdOperation
                    quadraticNum4Result.value = falsiNum4Holder
                    lowValResult.value = lowVal
                    highValResult.value = highVal
                    precissionResult.value = precision
                    
               }
               else {
                    
                    memIsClickedCount += 1
                    
                    if (mem14Holder == "0") {
                         
                         resultHolder = "0"
                    }
                    
                    if (memCLearIsClicked) {
                         mem14Holder = ""
                         memCLearIsClicked = false
                    }
                    
                    if (memRecordIsClicked) {
                         mem14Holder = ansHolder
                         memRecordIsClicked = false
                         mem14FalsiHolder.clear()
                         Log.e("message", mem14FalsiHolder.toString())
                         Log.e("message", mem14Holder.toString())
                    }
                    
                    if (memIsClickedCount == 2) {
                         if (mem14FalsiHolder.isEmpty()) {
                              if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                        "*"
                                   ) || processHolder.contains(
                                        "/"
                                   )) {
                                   processHolder += mem14Holder
                                   proccessResult.value = processHolder
                                   
                              }
                              else if (processHolder == "") {
                                   
                                   processHolder = mem14Holder
                              }
                              
                              if (resultHolder == "0") {
                                   
                                   resultHolder = "0"
                                   
                              }
                              result.value = resultHolder
                              proccessResult.value = processHolder
                              memIsClickedCount = 1
                              
                              mem14Value.value = mem14Holder
                         }
                    }
               }
               if(!falsiMethodIsClicked) {
                    result.value = resultHolder
                    proccessResult.value = processHolder
                    memIsClickedCount = 1
     
                    mem14Value.value = mem14Holder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun mem15() {
          try {
               if (macroRecordIsClicked) {
                    isClicked = true
                    
                    isClicked = false
                    if (macroRecordIsClicked) {
                         
                         if (macroSet == "1") {
                              
                              array1Holder.add("M15")
                              Log.e(
                                   "array", array1Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array1Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "2") {
                              
                              array2Holder.add("M15")
                              Log.e(
                                   "array", array2Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array2Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "3") {
                              
                              array3Holder.add("M15")
                              Log.e(
                                   "array", array3Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array3Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "4") {
                              
                              array4Holder.add("M15")
                              Log.e(
                                   "array", array4Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array4Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "5") {
                              
                              array5Holder.add("M15")
                              Log.e(
                                   "array", array5Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array5Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "6") {
                              
                              array6Holder.add("M15")
                              Log.e(
                                   "array", array6Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array6Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "7") {
                              
                              array7Holder.add("M15")
                              Log.e(
                                   "array", array7Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array7Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "8") {
                              
                              array8Holder.add("M15")
                              Log.e(
                                   "array", array8Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array8Holder.size.toString()
                              )
                              
                         }
                         else if (macroSet == "9") {
                              
                              array9Holder.add("M15")
                              Log.e(
                                   "array", array9Holder.toString()
                              )
                              Log.e(
                                   "set", macroSet.toString()
                              )
                              Log.e(
                                   "length", array9Holder.size.toString()
                              )
                         }
                    }
               }
               else if (falsiMethodIsClicked) {
                    
                    if (memRecordIsClicked) {
                         mem15FalsiHolder.clear()
                         
                         mem15FalsiHolder.add(falsiNum1Holder.toString())
                         mem15FalsiHolder.add(x1.toString())
                         mem15FalsiHolder.add(firstOperation.toString())
                         mem15FalsiHolder.add(falsiNum2Holder.toString())
                         mem15FalsiHolder.add(x2.toString())
                         mem15FalsiHolder.add(secondOperation.toString())
                         mem15FalsiHolder.add(falsiNum3Holder.toString())
                         mem15FalsiHolder.add(x3.toString())
                         mem15FalsiHolder.add(thirdOperation.toString())
                         mem15FalsiHolder.add(falsiNum4Holder.toString())
                         
                         
                         Log.e("message", mem15FalsiHolder.toString())
                         mem15Value.value =
                             mem15FalsiHolder.toString()
                                 .dropLast(1)
                                 .drop(1)
                                 .replace(",", "")
                                 .replace(" ", "")
                         mem15Holder = ""
                         mem15FalsiHolder.add(lowVal.toString())
                         mem15FalsiHolder.add(highVal.toString())
                         mem15FalsiHolder.add(precision.toString())
                         memRecordIsClicked = false
                    }
                    
                    if (mem15FalsiHolder.isNotEmpty() && !memRecordIsClicked) {
                         Log.e("message", mem15FalsiHolder.toString())
                         secondOperation = mem15FalsiHolder[5].toString()
                         falsiNum3Holder = mem15FalsiHolder[6].toString()
                         falsiNum1Holder = mem15FalsiHolder[0].toString()
                         x1 = mem15FalsiHolder[1].toString()
                         firstOperation = mem15FalsiHolder[2].toString()
                         falsiNum2Holder = mem15FalsiHolder[3].toString()
                         x2 = mem15FalsiHolder[4].toString()
                         x3 = mem15FalsiHolder[7].toString()
                         thirdOperation = mem15FalsiHolder[8].toString()
                         falsiNum4Holder = mem15FalsiHolder[9].toString()
                         lowVal = mem15FalsiHolder[10].toString()
                         highVal = mem15FalsiHolder[11].toString()
                         precision = mem15FalsiHolder[12].toString()
                         
                    }
                    else {
                         
                         if (falsiNum1Holder!!.isEmpty()) {
                              falsiNum1Holder = mem15Holder.toString()
                              quadraticNum1Result.value = falsiNum1Holder
                         }
                         else if (firstOperation!!.isEmpty()) {
                              if (mem15Holder.toString()
                                       .contains("-")) {
                                   
                                   firstOperation = "-"
                                   stringHolder = mem15Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                                   
                              }
                              else {
                                   firstOperation = "+"
                                   stringHolder = mem15Holder
                                   falsiNum2Holder = stringHolder.toString()
                                   quadraticNum2Result.value = falsiNum2Holder
                                   firstOperationResult.value = firstOperation
                              }
                         }
                         else if (secondOperation!!.isEmpty()) {
                              
                              if (mem15Holder.toString()
                                       .contains("-")) {
                                   secondOperation = "-"
                                   stringHolder = mem15Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                                   
                              }
                              else {
                                   secondOperation = "+"
                                   stringHolder = mem15Holder
                                   falsiNum3Holder = stringHolder.toString()
                                   quadraticNum3Result.value = falsiNum3Holder
                                   secondOperationResult.value = secondOperation
                              }
                         }
                         else {
                              if (mem15Holder.toString()
                                       .contains("-")) {
                                   
                                   thirdOperation = "-"
                                   stringHolder = mem15Holder
                                   stringHolder = stringHolder.drop(1)
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                                   
                              }
                              else {
                                   thirdOperation = "+"
                                   stringHolder = mem15Holder
                                   falsiNum4Holder = stringHolder.toString()
                                   quadraticNum4Result.value = falsiNum4Holder
                                   thirdOperationResult.value = thirdOperation
                              }
                              
                              if (falsiMethodIsClickedCount == 1) {
                                   lowVal = mem15Holder.toString()
                                   lowValResult.value = lowVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 2) {
                                   highVal = mem15Holder.toString()
                                   highValResult.value = highVal
                                   falsiMethodIsClickedCount += 1
                              }
                              else if (falsiMethodIsClickedCount == 3) {
                                   precision = mem15Holder.toString()
                                   precissionResult.value = precision
                              }
                         }
                    }
                    
                    
                    
                    
                    if (memCLearIsClicked) {
                         mem15FalsiHolder.clear()
                         mem15Value.value = ""
                         memCLearIsClicked = false
                    }
                    
                    quadraticNum1Result.value = falsiNum1Holder
                    secondOperationResult.value = secondOperation
                    quadraticNum2Result.value = falsiNum2Holder
                    firstOperationResult.value = firstOperation
                    x1Result.value = x1
                    x2Result.value = x2
                    quadraticNum3Result.value = falsiNum3Holder
                    x3Result.value = x3
                    thirdOperationResult.value = thirdOperation
                    quadraticNum4Result.value = falsiNum4Holder
                    lowValResult.value = lowVal
                    highValResult.value = highVal
                    precissionResult.value = precision
                    
               }
               else {
                    
                    memIsClickedCount += 1
                    
                    if (mem15Holder == "0") {
                         
                         resultHolder = "0"
                    }
                    
                    if (memCLearIsClicked) {
                         mem15Holder = ""
                         memCLearIsClicked = false
                    }
                    
                    if (memRecordIsClicked) {
                         mem15Holder = ansHolder
                         memRecordIsClicked = false
                         mem15FalsiHolder.clear()
                         Log.e("message", mem15FalsiHolder.toString())
                         Log.e("message", mem15Holder.toString())
                    }
                    
                    if (memIsClickedCount == 2) {
                         if (mem15FalsiHolder.isEmpty()) {
                              if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                        "*"
                                   ) || processHolder.contains(
                                        "/"
                                   )) {
                                   processHolder += mem15Holder
                                   proccessResult.value = processHolder
                                   
                              }
                              else if (processHolder == "") {
                                   
                                   processHolder = mem15Holder
                              }
                              
                              if (resultHolder == "0") {
                                   
                                   resultHolder = "0"
                                   
                              }
                              result.value = resultHolder
                              proccessResult.value = processHolder
                              memIsClickedCount = 1
                              
                              mem15Value.value = mem15Holder
                         }
                    }
               }
               if(!falsiMethodIsClicked) {
                    result.value = resultHolder
                    proccessResult.value = processHolder
                    memIsClickedCount = 1
     
                    mem15Value.value = mem15Holder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     suspend fun falsiMethod(
         a : Double,
         b : Double
     ) : Double {
          var iter : Int = 0
          var c : Double = 0.0
          var a = a
          var b = b
          val precision : Double = precision.toDouble()
          
          if (func(a) * func(b) > 0.0f) {
               x1RootResult.postValue("Function has same signs at ends of interval")
          }
          else {
               do {
                    c = a - func(a) * (b - a) / (func(b) - func(a))
                    iter++
                    if (func(a) * func(c) < 0) {
                         b = c
                    }
                    else {
                         a = c
                    }
                    Log.e("mess", c.toString())
               }
               while (kotlin.math.abs(func(c)) >= precision) //Terminating case
               
          }
          return c
     }
     
     fun equal() {
          try {
               if (falsiMethodIsClicked) {
                    if (precision.isNotEmpty()) {
                         val a : Double = lowVal.toDouble()
                         val b : Double = highVal.toDouble()
                         
                         CoroutineScope(Dispatchers.Default).launch {
                              x1RootResult.postValue(falsiMethod(a, b).toString())
                         }
                    }
                    else {
                         if (falsiMethodIsClickedCount == 0) {
                              falsiMethodIsClickedCount = 1
                         }
                         else if (falsiMethodIsClickedCount == 3) {
                              
                              val a : Double = lowVal.toDouble()
                              val b : Double = highVal.toDouble()
                              
                              CoroutineScope(Dispatchers.Default).launch {
                                   x1RootResult.postValue(falsiMethod(a, b).toString())
                              }
                         }
                    }
                    
               }
               else {
                    try {
                         if (processHolder.isEmpty()) {
                              
                              processHolder = ""
                              resultHolder = processHolder
                              
                              lastResult.value = resultHolder
                              result.value = "0"
                              proccessResult.value = resultHolder
                              ansHolder = resultHolder
                         }
                         
                         val expression = ExpressionBuilder(processHolder).build()
                         val processHolderResult : Double = expression.evaluate()
                         
                         if (processHolderResult.toString()
                                  .contains(".0")) {
                              
                              processHolder =
                                  processHolderResult.toInt()
                                      .toString()
                              resultHolder =
                                  processHolderResult.toInt()
                                      .toString()
                              
                              lastResult.value = resultHolder
                              result.value = "0"
                              proccessResult.value = resultHolder
                              ansHolder = resultHolder
                              
                         }
                         else {
                              
                              processHolder =
                                  processHolderResult.toDouble()
                                      .toString()
                              resultHolder =
                                  processHolderResult.toDouble()
                                      .toString()
                              
                              lastResult.value = resultHolder
                              result.value = "0"
                              proccessResult.value = resultHolder
                              ansHolder = resultHolder
                         }
                    }
                    catch (e : Exception) {
                         
                         processHolder = processHolder.dropLast(1)
                         resultHolder = processHolder
                         
                         lastResult.value = processHolder
                         result.value = "0"
                         proccessResult.value = processHolder
                         ansHolder = processHolder
                         
                    }
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun failsMethod() {
          try {
               click += 1
               
               if (click == 1) {
                    falsiMethodIsClicked = true
               }
               else if (click == 2) {
                    falsiMethodIsClicked = false
                    click = 0
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     private fun func(x : Double) : Double {
          
          var x1x : Double = x
          var x2x : Double = x
          var x3x : Double = x
          var func : Double = 0.0
          val a : Double?
          val b : Double?
          val c : Double?
          val d : Double?
          
          if (x1 == "x") {
               x1x = x
          }
          if (x1 == "x??") {
               x1x = x * x
          }
          if (x1 == "x??") {
               x1x = x * x * x
          }
          
          if (x2 == "x") {
               x2x = x
          }
          if (x2 == "x??") {
               x2x = x * x
          }
          if (x2 == "x??") {
               x2x = x * x * x
          }
          
          if (x3 == "x") {
               x3x = x
          }
          if (x3 == "x??") {
               x3x = x * x
          }
          if (x3 == "x??") {
               x3x = x * x * x
          }
          
          if (x1.isNullOrBlank()) {
               x1x = 1.0
          }
          if (x2.isNullOrBlank()) {
               x2x = 1.0
          }
          if (x3.isNullOrBlank()) {
               x3x = 1.0
          }
          
          if (firstOperation.isNullOrBlank()) {
               firstOperation = "+"
          }
          if (secondOperation.isNullOrBlank()) {
               secondOperation = "+"
          }
          if (thirdOperation.isNullOrBlank()) {
               thirdOperation = "+"
          }
          
          if (falsiNum1Holder.isNullOrBlank()) {
               a = 0.0
          }
          else {
               a = falsiNum1Holder!!.toDouble()
          }
          if (falsiNum2Holder.isNullOrBlank()) {
               b = 0.0
          }
          else {
               b = falsiNum2Holder!!.toDouble()
          }
          if (falsiNum3Holder.isNullOrBlank()) {
               c = 0.0
          }
          else {
               c = falsiNum3Holder!!.toDouble()
          }
          if (falsiNum4Holder.isNullOrBlank()) {
               d = 0.0
               Log.e("message", d.toString())
          }
          else {
               d = falsiNum4Holder!!.toDouble()
          }
          
          
          if (falsiNum4Holder != null) {
               
               if (firstOperation == "+" && secondOperation == "+" && thirdOperation == "+") {
                    func = a * (x1x) + b * (x2x) + c * (x3x) + d
               }
               if (firstOperation == "-" && secondOperation == "+" && thirdOperation == "+") {
                    func = a * (x1x) - b * (x2x) + c * (x3x) + d
               }
               if (firstOperation == "+" && secondOperation == "-" && thirdOperation == "-") {
                    func = a * (x1x) + b * (x2x) - c * (x3x) - d
               }
               if (firstOperation == "-" && secondOperation == "+" && thirdOperation == "-") {
                    func = a * (x1x) - b * (x2x) + c * (x3x) - d
               }
               if (firstOperation == "+" && secondOperation == "-" && thirdOperation == "+") {
                    func = a * (x1x) + b * (x2x) - c * (x3x) + d
               }
               if (firstOperation == "-" && secondOperation == "-" && thirdOperation == "-") {
                    func = a * (x1x) - b * (x2x) - c * (x3x) - d
               }
               if (firstOperation == "+" && secondOperation == "+" && thirdOperation == "-") {
                    func = a * (x1x) + b * (x2x) + c * (x3x) - d
               }
          }
          else if (falsiNum4Holder == null) {
               
               if (firstOperation == "+" && secondOperation == "+") {
                    func = a * (x1x) + b * (x2x) + c * (x3x)
               }
               if (firstOperation == "-" && secondOperation == "+") {
                    func = a * (x1x) - b * (x2x) + c * (x3x)
               }
               if (firstOperation == "+" && secondOperation == "-") {
                    func = a * (x1x) + b * (x2x) - c * (x3x)
               }
               if (firstOperation == "-" && secondOperation == "-") {
                    func = a * (x1x) - b * (x2x) - c * (x3x)
               }
          }
          else if (falsiNum3Holder == null && falsiNum2Holder != null) {
               
               if (firstOperation == "+") {
                    func = a * (x1x) + b * (x2x)
               }
               if (firstOperation == "-") {
                    func = a * (x1x) - b * (x2x)
               }
          }
          else {
               func = a * (x1x)
          }
          
          return func
     }
     
     fun ansShow() {
          try {
               if (falsiMethodIsClicked) {
                    
                    if (falsiNum1Holder!!.isEmpty()) {
                         
                         falsiNum1Holder = ansHolder.toString()
                         quadraticNum1Result.value = falsiNum1Holder
                    }
                    else if (firstOperation!!.isEmpty() && falsiNum2Holder!!.isEmpty()) {
                         if (ansHolder.toString()
                                  .contains("-")) {
                              
                              firstOperation = "-"
                              stringHolder = ansHolder
                              stringHolder = stringHolder.drop(1)
                              falsiNum2Holder = stringHolder.toString()
                              quadraticNum2Result.value = falsiNum2Holder
                              firstOperationResult.value = firstOperation
                              
                         }
                         else {
                              firstOperation = "+"
                              stringHolder = ansHolder
                              falsiNum2Holder = stringHolder.toString()
                              quadraticNum2Result.value = falsiNum2Holder
                              firstOperationResult.value = firstOperation
                         }
                         
                    }
                    else {
                         
                         if (ansHolder.toString()
                                  .contains("-")) {
                              secondOperation = "-"
                              stringHolder = ansHolder
                              stringHolder = stringHolder.drop(1)
                              falsiNum3Holder = stringHolder.toString()
                              quadraticNum3Result.value = falsiNum3Holder
                              secondOperationResult.value = secondOperation
                              
                         }
                         else {
                              secondOperation = "+"
                              stringHolder = ansHolder
                              falsiNum3Holder = stringHolder.toString()
                              quadraticNum3Result.value = falsiNum3Holder
                              secondOperationResult.value = secondOperation
                         }
                    }
                    
               }
               else {
                    if (ansHolder == "") {
                    
                    }
                    
                    if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                              "*"
                         ) || processHolder.contains(
                              "/"
                         )) {
                         processHolder += ansHolder
                         proccessResult.value = processHolder
                         
                    }
                    else if (processHolder == "") {
                         
                         processHolder = ansHolder
                    }
                    
                    if (resultHolder == "0") {
                         
                         resultHolder = ansHolder
                         
                    }
                    result.value = resultHolder
                    proccessResult.value = processHolder
               }
          }
          catch (e : Exception) {
               deleteAll()
               result.value = "Error"
          }
     }
     
     fun equalSend() : LiveData<String> {
          
          lastResult.value = resultHolder
          return lastResult
     }
     
     fun getResult() : LiveData<String> {
          return result
     }
     
     fun getM1() : LiveData<String> {
          val value : String?
          if (mem1Holder.isEmpty()) {
               value =
                   mem1FalsiHolder.toString()
                       .dropLast(1)
                       .drop(1)
                       .replace(",", "")
                       .replace(" ", "")
          }
          else {
               value = mem1Holder
          }
          
          mem1Value.value = value
          return mem1Value
     }
     
     fun getM2() : LiveData<String> {
          val value : String?
          if (mem2Holder.isEmpty()) {
               value =
                   mem2FalsiHolder.toString()
                       .dropLast(1)
                       .drop(1)
                       .replace(",", "")
                       .replace(" ", "")
          }
          else {
               value = mem2Holder
          }
          
          mem2Value.value = value
          return mem2Value
     }
     
     fun getM3() : LiveData<String> {
          val value : String?
          if (mem3Holder.isEmpty()) {
               value =
                   mem3FalsiHolder.toString()
                       .dropLast(1)
                       .drop(1)
                       .replace(",", "")
                       .replace(" ", "")
          }
          else {
               value = mem3Holder
          }
          
          mem3Value.value = value
          return mem3Value
     }
     
     fun getM4() : LiveData<String> {
          val value : String?
          if (mem4Holder.isEmpty()) {
               value =
                   mem4FalsiHolder.toString()
                       .dropLast(1)
                       .drop(1)
                       .replace(",", "")
                       .replace(" ", "")
          }
          else {
               value = mem4Holder
          }
          
          mem4Value.value = value
          return mem4Value
     }
     
     fun getM5() : LiveData<String> {
          val value : String?
          if (mem5Holder.isEmpty()) {
               value =
                   mem5FalsiHolder.toString()
                       .dropLast(1)
                       .drop(1)
                       .replace(",", "")
                       .replace(" ", "")
          }
          else {
               value = mem5Holder
          }
          
          mem5Value.value = value
          return mem5Value
     }
     
     fun getM6() : LiveData<String> {
          val value : String?
          if (mem6Holder.isEmpty()) {
               value =
                   mem6FalsiHolder.toString()
                       .dropLast(1)
                       .drop(1)
                       .replace(",", "")
                       .replace(" ", "")
          }
          else {
               value = mem6Holder
          }
          
          mem6Value.value = value
          return mem6Value
     }
     
     fun getM7() : LiveData<String> {
          val value : String?
          if (mem7Holder.isEmpty()) {
               value =
                   mem7FalsiHolder.toString()
                       .dropLast(1)
                       .drop(1)
                       .replace(",", "")
                       .replace(" ", "")
          }
          else {
               value = mem7Holder
          }
          
          mem7Value.value = value
          return mem7Value
     }
     
     fun getM8() : LiveData<String> {
          val value : String?
          if (mem8Holder.isEmpty()) {
               value =
                   mem8FalsiHolder.toString()
                       .dropLast(1)
                       .drop(1)
                       .replace(",", "")
                       .replace(" ", "")
          }
          else {
               value = mem8Holder
          }
          
          mem8Value.value = value
          return mem8Value
     }
     
     fun getM9() : LiveData<String> {
          val value : String?
          if (mem9Holder.isEmpty()) {
               value =
                   mem9FalsiHolder.toString()
                       .dropLast(1)
                       .drop(1)
                       .replace(",", "")
                       .replace(" ", "")
          }
          else {
               value = mem9Holder
          }
          
          mem9Value.value = value
          return mem9Value
     }
     
     fun getM10() : LiveData<String> {
          val value : String?
          if (mem10Holder.isEmpty()) {
               value =
                   mem10FalsiHolder.toString()
                       .dropLast(1)
                       .drop(1)
                       .replace(",", "")
                       .replace(" ", "")
          }
          else {
               value = mem10Holder
          }
          
          mem10Value.value = value
          return mem10Value
     }
     
     fun getM11() : LiveData<String> {
          val value : String?
          if (mem11Holder.isEmpty()) {
               value =
                   mem11FalsiHolder.toString()
                       .dropLast(1)
                       .drop(1)
                       .replace(",", "")
                       .replace(" ", "")
          }
          else {
               value = mem11Holder
          }
          
          mem11Value.value = value
          return mem11Value
     }
     
     fun getM12() : LiveData<String> {
          val value : String?
          if (mem12Holder.isEmpty()) {
               value =
                   mem12FalsiHolder.toString()
                       .dropLast(1)
                       .drop(1)
                       .replace(",", "")
                       .replace(" ", "")
          }
          else {
               value = mem12Holder
          }
          
          mem12Value.value = value
          return mem12Value
     }
     
     fun getM13() : LiveData<String> {
          val value : String?
          if (mem13Holder.isEmpty()) {
               value =
                   mem13FalsiHolder.toString()
                       .dropLast(1)
                       .drop(1)
                       .replace(",", "")
                       .replace(" ", "")
          }
          else {
               value = mem13Holder
          }
          
          mem13Value.value = value
          return mem13Value
     }
     
     fun getM14() : LiveData<String> {
          val value : String?
          if (mem14Holder.isEmpty()) {
               value =
                   mem14FalsiHolder.toString()
                       .dropLast(1)
                       .drop(1)
                       .replace(",", "")
                       .replace(" ", "")
          }
          else {
               value = mem14Holder
          }
          
          mem14Value.value = value
          return mem14Value
     }
     
     fun getM15() : LiveData<String> {
          val value : String?
          if (mem15Holder.isEmpty()) {
               value =
                   mem15FalsiHolder.toString()
                       .dropLast(1)
                       .drop(1)
                       .replace(",", "")
                       .replace(" ", "")
          }
          else {
               value = mem15Holder
          }
          
          mem15Value.value = value
          return mem15Value
     }
     
     fun getProcessResult() : LiveData<String> {
          return proccessResult
     }
     
     fun quadraticResult1() : LiveData<String> {
          return quadraticNum1Result
     }
     
     fun quadraticResult2() : LiveData<String> {
          return quadraticNum2Result
     }
     
     fun quadraticResult3() : LiveData<String> {
          return quadraticNum3Result
     }
     
     fun quadraticResult4() : LiveData<String> {
          return quadraticNum4Result
     }
     
     fun firstOperation() : LiveData<String> {
          return firstOperationResult
     }
     
     fun secondOperation() : LiveData<String> {
          return secondOperationResult
     }
     
     fun thirdOperation() : LiveData<String> {
          return thirdOperationResult
     }
     
     fun getX1Root() : LiveData<String> {
          return x1RootResult
     }
     
     fun x1Result() : LiveData<String> {
          return x1Result
     }
     
     fun x2Result() : LiveData<String> {
          return x2Result
     }
     
     fun x3Result() : LiveData<String> {
          return x3Result
     }
     
     fun getMessage() : LiveData<String> {
          return message
     }
     
     fun getMacroContains() : LiveData<String> {
          return macroContainsResult
     }
     
     fun getHighVal() : LiveData<String> {
          return highValResult
     }
     
     fun getLowVal() : LiveData<String> {
          return lowValResult
     }
     
     fun getPrecission() : LiveData<String> {
          return precissionResult
     }
     
}