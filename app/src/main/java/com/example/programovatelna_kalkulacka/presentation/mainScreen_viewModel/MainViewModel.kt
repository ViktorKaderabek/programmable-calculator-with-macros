package com.example.programovatelna_kalkulacka.presentation.mainScreen_viewModel

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import net.objecthunter.exp4j.ExpressionBuilder


class MainViewModel : ViewModel()
{

    var arraySize : Int = 0
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
    private var falsiNum1Holder : String = ""
    private var falsiNum2Holder : String = ""
    private var falsiNum3Holder : String = ""
    private var firstOperation : String = ""
    private var secondOperation : String = ""
    private var x1RootHolder : Double = 0.0
    private var x2RootHolder : Double = 0.0
    private var a : Double = 0.0
    private var b : Double = 0.0
    private var c : Double = 0.0
    private var click : Int = 0
    private var x1 : String = ""
    private var x2 : String = ""

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

    var macroRecordIsClicked : Boolean = false
    private var macroClearIsClicked : Boolean = false
    private var macroRecallIsClicked : Boolean = false
    private var macroClearSet : String = " "
    private var macroContains : String = ""
    var macroSet : String = "0"
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

    private var quadraticNum1Result = MutableLiveData<String>()
    private var quadraticNum2Result = MutableLiveData<String>()
    private var quadraticNum3Result = MutableLiveData<String>()
    private var determinantResult = MutableLiveData<String>()
    private var firstOperationResult = MutableLiveData<String>()
    private var secondOperationResult = MutableLiveData<String>()
    private var x1RootResult = MutableLiveData<String>()
    private var x2RootResult = MutableLiveData<String>()
    private var x1Result = MutableLiveData<String>()
    private var x2Result = MutableLiveData<String>()

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

    fun addNumber1()
    {
        try
        {
            if (macroRecallIsClicked)
            {
                arraySize = array1Holder.size
                resultHolder.plus(1)
                macroChoosed = "1"
                macroRecallIsClicked = false


                var result = array1Holder.toString()
                result = result.toString()
                result = result.drop(1)
                result = result.dropLast(1)
                result = result.replace(
                    ",",
                    ""
                )
                result = result.replace(
                    "M1",
                    mem1Holder.toString()
                )
                result = result.replace(
                    "M2",
                    mem2Holder.toString()
                )
                result = result.replace(
                    "M3",
                    mem3Holder.toString()
                )
                result = result.replace(
                    "M4",
                    mem4Holder.toString()
                )
                result = result.replace(
                    "M5",
                    mem5Holder.toString()
                )
                result = result.replace(
                    "M6",
                    mem6Holder.toString()
                )
                result = result.replace(
                    "M7",
                    mem7Holder.toString()
                )
                result = result.replace(
                    "M8",
                    mem8Holder.toString()
                )
                result = result.replace(
                    "M9",
                    mem9Holder.toString()
                )
                result = result.replace(
                    "M10",
                    mem10Holder.toString()
                )
                result = result.replace(
                    "M11",
                    mem11Holder.toString()
                )
                result = result.replace(
                    "M12",
                    mem12Holder.toString()
                )
                result = result.replace(
                    "M13",
                    mem13Holder.toString()
                )
                result = result.replace(
                        "M14",
                mem14Holder.toString()
                )
                result = result.replace(
                    "M15",
                    mem15Holder.toString()
                )

                macroContains = result
                macroContainsResult.value = macroContains

                /*
         _________________________________________________________
             if (array1Holder.contains("M1"))
               {
                   resultHolder = array1Holder.toString()
                   resultHolder = resultHolder.drop(1)
                   resultHolder = resultHolder.dropLast(1)
                   resultHolder = resultHolder.replace(
                       ",",
                       ""
                   )
                   resultHolder = resultHolder.replace(
                       "M1",
                       mem1Holder.toString()
                   )


                   val expression = ExpressionBuilder(resultHolder).build()
                   val processHolderResult : Double = expression.evaluate()

                   if (processHolderResult.toString()
                           .contains(".0"))
                   {

                       result.value =
                               processHolderResult.toInt()
                                   .toString()
                   }
                   else
                   {
                       result.value = processHolderResult.toString()
                   }

                   numberArrayHolder.removeAll(numberArrayHolder)
                   count = -1
                   macroChoosed = "0"
                   arraySize = 0
                   macroRecordIsClicked = false
                   macroRecallIsClicked = false
                   macroSet = "0"
                   macroChoosed = "0"
               }

             */

            }
            else if (macroRecordIsClicked)
            {

                macroSet = "1"
                Log.e("mes", macroSet.toString())

            }
            else if (macroClearIsClicked)
            {

                array1Holder.clear()
                Log.e("something", array1Holder.toString())
                macroClearIsClicked = false


            }
            else if (falsiMethodIsClicked)
            {
                if (firstOperation.isEmpty())
                {
                    falsiNum1Holder = falsiNum1Holder.plus("1")
                    quadraticNum1Result.value = falsiNum1Holder


                }
                else if (firstOperation.isNotEmpty() && secondOperation.isEmpty())
                {
                    falsiNum2Holder = falsiNum2Holder.plus("1")
                    quadraticNum2Result.value = falsiNum2Holder

                }
                else
                {

                    falsiNum3Holder = falsiNum3Holder.plus("1")
                    quadraticNum3Result.value = falsiNum3Holder

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
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun addNumber2()
    {
        try
        {
            if (macroRecallIsClicked)
            {
                arraySize = array2Holder.size
                resultHolder.plus(1)
                macroChoosed = "2"
                macroRecallIsClicked = false

                var result = array2Holder.toString()
                result = result.toString()
                result = result.drop(1)
                result = result.dropLast(1)
                result = result.replace(
                    ",",
                    ""
                )
                result = result.replace(
                    "M1",
                    mem1Holder.toString()
                )
                result = result.replace(
                    "M2",
                    mem2Holder.toString()
                )
                result = result.replace(
                    "M3",
                    mem3Holder.toString()
                )
                result = result.replace(
                    "M4",
                    mem4Holder.toString()
                )
                result = result.replace(
                    "M5",
                    mem5Holder.toString()
                )
                result = result.replace(
                    "M6",
                    mem6Holder.toString()
                )
                result = result.replace(
                    "M7",
                    mem7Holder.toString()
                )
                result = result.replace(
                    "M8",
                    mem8Holder.toString()
                )
                result = result.replace(
                    "M9",
                    mem9Holder.toString()
                )
                result = result.replace(
                    "M10",
                    mem10Holder.toString()
                )
                result = result.replace(
                    "M11",
                    mem11Holder.toString()
                )
                result = result.replace(
                    "M12",
                    mem12Holder.toString()
                )
                result = result.replace(
                    "M13",
                    mem13Holder.toString()
                )
                result = result.replace(
                    "M14",
                    mem14Holder.toString()
                )
                result = result.replace(
                    "M15",
                    mem15Holder.toString()
                )

                macroContains = result
                macroContainsResult.value = macroContains


            }
            else if (macroRecordIsClicked)
            {

                macroSet = "2"

            }
            else if (macroClearIsClicked)
            {

                array2Holder.clear()
                macroClearIsClicked = false

            }
            else if (falsiMethodIsClicked)
            {
                if (firstOperation.isEmpty())
                {
                    falsiNum1Holder = falsiNum1Holder.plus("2")
                    quadraticNum1Result.value = falsiNum1Holder

                }
                else if (firstOperation.isNotEmpty() && secondOperation.isEmpty())
                {
                    falsiNum2Holder = falsiNum2Holder.plus("2")
                    quadraticNum2Result.value = falsiNum2Holder

                }
                else
                {
                    falsiNum3Holder = falsiNum3Holder.plus("2")
                    quadraticNum3Result.value = falsiNum3Holder

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
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun addNumber3()
    {
        try
        {
            if (macroRecallIsClicked)
            {
                arraySize = array3Holder.size
                resultHolder.plus(1)
                macroChoosed = "3"
                macroRecallIsClicked = false

                var result = array3Holder.toString()
                result = result.toString()
                result = result.drop(1)
                result = result.dropLast(1)
                result = result.replace(
                    ",",
                    ""
                )
                result = result.replace(
                    "M1",
                    mem1Holder.toString()
                )
                result = result.replace(
                    "M2",
                    mem2Holder.toString()
                )
                result = result.replace(
                    "M3",
                    mem3Holder.toString()
                )
                result = result.replace(
                    "M4",
                    mem4Holder.toString()
                )
                result = result.replace(
                    "M5",
                    mem5Holder.toString()
                )
                result = result.replace(
                    "M6",
                    mem6Holder.toString()
                )
                result = result.replace(
                    "M7",
                    mem7Holder.toString()
                )
                result = result.replace(
                    "M8",
                    mem8Holder.toString()
                )
                result = result.replace(
                    "M9",
                    mem9Holder.toString()
                )
                result = result.replace(
                    "M10",
                    mem10Holder.toString()
                )
                result = result.replace(
                    "M11",
                    mem11Holder.toString()
                )
                result = result.replace(
                    "M12",
                    mem12Holder.toString()
                )
                result = result.replace(
                    "M13",
                    mem13Holder.toString()
                )
                result = result.replace(
                    "M14",
                    mem14Holder.toString()
                )
                result = result.replace(
                    "M15",
                    mem15Holder.toString()
                )

                macroContains = result
                macroContainsResult.value = macroContains

            }
            else if (macroRecordIsClicked)
            {

                macroSet = "3"

            }
            else if (macroClearIsClicked)
            {

                array3Holder.clear()
                macroClearIsClicked = false

            }
            else if (falsiMethodIsClicked)
            {
                if (firstOperation.isEmpty())
                {
                    falsiNum1Holder = falsiNum1Holder.plus("3")
                    quadraticNum1Result.value = falsiNum1Holder

                }
                else if (firstOperation.isNotEmpty() && secondOperation.isEmpty())
                {
                    falsiNum2Holder = falsiNum2Holder.plus("3")
                    quadraticNum2Result.value = falsiNum2Holder

                }
                else
                {

                    falsiNum3Holder = falsiNum3Holder.plus("3")
                    quadraticNum3Result.value = falsiNum3Holder

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
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun addNumber4()
    {
        try
        {
            if (macroRecallIsClicked)
            {
                arraySize = array4Holder.size
                resultHolder.plus(1)
                macroChoosed = "4"
                macroRecallIsClicked = false

                var result = array4Holder.toString()
                result = result.toString()
                result = result.drop(1)
                result = result.dropLast(1)
                result = result.replace(
                    ",",
                    ""
                )
                result = result.replace(
                    "M1",
                    mem1Holder.toString()
                )
                result = result.replace(
                    "M2",
                    mem2Holder.toString()
                )
                result = result.replace(
                    "M3",
                    mem3Holder.toString()
                )
                result = result.replace(
                    "M4",
                    mem4Holder.toString()
                )
                result = result.replace(
                    "M5",
                    mem5Holder.toString()
                )
                result = result.replace(
                    "M6",
                    mem6Holder.toString()
                )
                result = result.replace(
                    "M7",
                    mem7Holder.toString()
                )
                result = result.replace(
                    "M8",
                    mem8Holder.toString()
                )
                result = result.replace(
                    "M9",
                    mem9Holder.toString()
                )
                result = result.replace(
                    "M10",
                    mem10Holder.toString()
                )
                result = result.replace(
                    "M11",
                    mem11Holder.toString()
                )
                result = result.replace(
                    "M12",
                    mem12Holder.toString()
                )
                result = result.replace(
                    "M13",
                    mem13Holder.toString()
                )
                result = result.replace(
                    "M14",
                    mem14Holder.toString()
                )
                result = result.replace(
                    "M15",
                    mem15Holder.toString()
                )

                macroContains = result
                macroContainsResult.value = macroContains
            }
            else if (macroRecordIsClicked)
            {

                macroSet = "4"

            }
            else if (macroClearIsClicked)
            {

                array4Holder.clear()
                macroClearIsClicked = false

            }
            else if (falsiMethodIsClicked)
            {
                if (firstOperation.isEmpty())
                {
                    falsiNum1Holder = falsiNum1Holder.plus("4")
                    quadraticNum1Result.value = falsiNum1Holder


                }
                else if (firstOperation.isNotEmpty() && secondOperation.isEmpty())
                {
                    falsiNum2Holder = falsiNum2Holder.plus("4")
                    quadraticNum2Result.value = falsiNum2Holder

                }
                else
                {

                    falsiNum3Holder = falsiNum3Holder.plus("4")
                    quadraticNum3Result.value = falsiNum3Holder

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
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun addNumber5()
    {
        try
        {
            if (macroRecallIsClicked)
            {
                arraySize = array5Holder.size
                resultHolder.plus(1)
                macroChoosed = "5"
                macroRecallIsClicked = false

                var result = array5Holder.toString()
                result = result.toString()
                result = result.drop(1)
                result = result.dropLast(1)
                result = result.replace(
                    ",",
                    ""
                )
                result = result.replace(
                    "M1",
                    mem1Holder.toString()
                )
                result = result.replace(
                    "M2",
                    mem2Holder.toString()
                )
                result = result.replace(
                    "M3",
                    mem3Holder.toString()
                )
                result = result.replace(
                    "M4",
                    mem4Holder.toString()
                )
                result = result.replace(
                    "M5",
                    mem5Holder.toString()
                )
                result = result.replace(
                    "M6",
                    mem6Holder.toString()
                )
                result = result.replace(
                    "M7",
                    mem7Holder.toString()
                )
                result = result.replace(
                    "M8",
                    mem8Holder.toString()
                )
                result = result.replace(
                    "M9",
                    mem9Holder.toString()
                )
                result = result.replace(
                    "M10",
                    mem10Holder.toString()
                )
                result = result.replace(
                    "M11",
                    mem11Holder.toString()
                )
                result = result.replace(
                    "M12",
                    mem12Holder.toString()
                )
                result = result.replace(
                    "M13",
                    mem13Holder.toString()
                )
                result = result.replace(
                    "M14",
                    mem14Holder.toString()
                )
                result = result.replace(
                    "M15",
                    mem15Holder.toString()
                )

                macroContains = result
                macroContainsResult.value = macroContains

            }
            else if (macroRecordIsClicked)
            {

                macroSet = "5"

            }
            else if (macroClearIsClicked)
            {

                array5Holder.clear()
                macroClearIsClicked = false

            }
            else if (falsiMethodIsClicked)
            {
                if (firstOperation.isEmpty())
                {
                    falsiNum1Holder = falsiNum1Holder.plus("5")
                    quadraticNum1Result.value = falsiNum1Holder

                }
                else if (firstOperation.isNotEmpty() && secondOperation.isEmpty())
                {
                    falsiNum2Holder = falsiNum2Holder.plus("5")
                    quadraticNum2Result.value = falsiNum2Holder

                }
                else
                {
                    falsiNum3Holder = falsiNum3Holder.plus("5")
                    quadraticNum3Result.value = falsiNum3Holder

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
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun addNumber6()
    {
        try
        {

            if (macroRecallIsClicked)
            {
                arraySize = array6Holder.size
                resultHolder.plus(1)
                macroChoosed = "6"
                macroRecallIsClicked = false

                var result = array6Holder.toString()
                result = result.toString()
                result = result.drop(1)
                result = result.dropLast(1)
                result = result.replace(
                    ",",
                    ""
                )
                result = result.replace(
                    "M1",
                    mem1Holder.toString()
                )
                result = result.replace(
                    "M2",
                    mem2Holder.toString()
                )
                result = result.replace(
                    "M3",
                    mem3Holder.toString()
                )
                result = result.replace(
                    "M4",
                    mem4Holder.toString()
                )
                result = result.replace(
                    "M5",
                    mem5Holder.toString()
                )
                result = result.replace(
                    "M6",
                    mem6Holder.toString()
                )
                result = result.replace(
                    "M7",
                    mem7Holder.toString()
                )
                result = result.replace(
                    "M8",
                    mem8Holder.toString()
                )
                result = result.replace(
                    "M9",
                    mem9Holder.toString()
                )
                result = result.replace(
                    "M10",
                    mem10Holder.toString()
                )
                result = result.replace(
                    "M11",
                    mem11Holder.toString()
                )
                result = result.replace(
                    "M12",
                    mem12Holder.toString()
                )
                result = result.replace(
                    "M13",
                    mem13Holder.toString()
                )
                result = result.replace(
                    "M14",
                    mem14Holder.toString()
                )
                result = result.replace(
                    "M15",
                    mem15Holder.toString()
                )

                macroContains = result
                macroContainsResult.value = macroContains

            }
            else if (macroRecordIsClicked)
            {

                macroSet = "6"

            }
            else if (macroClearIsClicked)
            {

                array6Holder.clear()
                macroClearIsClicked = false

            }
            else if (falsiMethodIsClicked)
            {
                if (firstOperation.isEmpty())
                {
                    falsiNum1Holder = falsiNum1Holder.plus("6")
                    quadraticNum1Result.value = falsiNum1Holder

                }
                else if (firstOperation.isNotEmpty() && secondOperation.isEmpty())
                {
                    falsiNum2Holder = falsiNum2Holder.plus("6")
                    quadraticNum2Result.value = falsiNum2Holder
                }
                else
                {

                    falsiNum3Holder = falsiNum3Holder.plus("6")
                    quadraticNum3Result.value = falsiNum3Holder
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
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun addNumber7()
    {
        try
        {
            if (macroRecallIsClicked)
            {
                arraySize = array7Holder.size
                resultHolder.plus(1)
                macroChoosed = "7"
                macroRecallIsClicked = false

                var result = array7Holder.toString()
                result = result.toString()
                result = result.drop(1)
                result = result.dropLast(1)
                result = result.replace(
                    ",",
                    ""
                )
                result = result.replace(
                    "M1",
                    mem1Holder.toString()
                )
                result = result.replace(
                    "M2",
                    mem2Holder.toString()
                )
                result = result.replace(
                    "M3",
                    mem3Holder.toString()
                )
                result = result.replace(
                    "M4",
                    mem4Holder.toString()
                )
                result = result.replace(
                    "M5",
                    mem5Holder.toString()
                )
                result = result.replace(
                    "M6",
                    mem6Holder.toString()
                )
                result = result.replace(
                    "M7",
                    mem7Holder.toString()
                )
                result = result.replace(
                    "M8",
                    mem8Holder.toString()
                )
                result = result.replace(
                    "M9",
                    mem9Holder.toString()
                )
                result = result.replace(
                    "M10",
                    mem10Holder.toString()
                )
                result = result.replace(
                    "M11",
                    mem11Holder.toString()
                )
                result = result.replace(
                    "M12",
                    mem12Holder.toString()
                )
                result = result.replace(
                    "M13",
                    mem13Holder.toString()
                )
                result = result.replace(
                    "M14",
                    mem14Holder.toString()
                )
                result = result.replace(
                    "M15",
                    mem15Holder.toString()
                )

                macroContains = result
                macroContainsResult.value = macroContains
            }
            else if (macroRecordIsClicked)
            {

                macroSet = "7"

            }
            else if (macroClearIsClicked)
            {

                array7Holder.clear()
                macroClearIsClicked = false

            }
            else if (falsiMethodIsClicked)
            {
                if (firstOperation.isEmpty())
                {
                    falsiNum1Holder = falsiNum1Holder.plus("7")
                    quadraticNum1Result.value = falsiNum1Holder
                }
                else if (firstOperation.isNotEmpty() && secondOperation.isEmpty())
                {
                    falsiNum2Holder = falsiNum2Holder.plus("7")
                    quadraticNum2Result.value = falsiNum2Holder
                }
                else
                {

                    falsiNum3Holder = falsiNum3Holder.plus("7")
                    quadraticNum3Result.value = falsiNum3Holder
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
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun addNumber8()
    {
        try
        {
            if (macroRecallIsClicked)
            {
                arraySize = array8Holder.size
                resultHolder.plus(1)
                macroChoosed = "8"
                macroRecallIsClicked = false

                var result = array8Holder.toString()
                result = result.toString()
                result = result.drop(1)
                result = result.dropLast(1)
                result = result.replace(
                    ",",
                    ""
                )
                result = result.replace(
                    "M1",
                    mem1Holder.toString()
                )
                result = result.replace(
                    "M2",
                    mem2Holder.toString()
                )
                result = result.replace(
                    "M3",
                    mem3Holder.toString()
                )
                result = result.replace(
                    "M4",
                    mem4Holder.toString()
                )
                result = result.replace(
                    "M5",
                    mem5Holder.toString()
                )
                result = result.replace(
                    "M6",
                    mem6Holder.toString()
                )
                result = result.replace(
                    "M7",
                    mem7Holder.toString()
                )
                result = result.replace(
                    "M8",
                    mem8Holder.toString()
                )
                result = result.replace(
                    "M9",
                    mem9Holder.toString()
                )
                result = result.replace(
                    "M10",
                    mem10Holder.toString()
                )
                result = result.replace(
                    "M11",
                    mem11Holder.toString()
                )
                result = result.replace(
                    "M12",
                    mem12Holder.toString()
                )
                result = result.replace(
                    "M13",
                    mem13Holder.toString()
                )
                result = result.replace(
                    "M14",
                    mem14Holder.toString()
                )
                result = result.replace(
                    "M15",
                    mem15Holder.toString()
                )

                macroContains = result
                macroContainsResult.value = macroContains
            }
            else if (macroRecordIsClicked)
            {

                macroSet = "8"

            }
            else if (macroClearIsClicked)
            {

                array8Holder.clear()
                macroClearIsClicked = false
            }
            else if (falsiMethodIsClicked)
            {
                if (firstOperation.isEmpty())
                {
                    falsiNum1Holder = falsiNum1Holder.plus("8")
                    quadraticNum1Result.value = falsiNum1Holder
                }
                else if (firstOperation.isNotEmpty() && secondOperation.isEmpty())
                {
                    falsiNum2Holder = falsiNum2Holder.plus("8")
                    quadraticNum2Result.value = falsiNum2Holder
                }
                else
                {

                    falsiNum3Holder = falsiNum3Holder.plus("8")
                    quadraticNum3Result.value = falsiNum3Holder
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
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun addNumber9()
    {
        try
        {
            if (macroRecallIsClicked)
            {
                arraySize = array9Holder.size
                resultHolder.plus(1)
                macroChoosed = "9"
                macroRecallIsClicked = false

                var result = array9Holder.toString()
                result = result.toString()
                result = result.drop(1)
                result = result.dropLast(1)
                result = result.replace(
                    ",",
                    ""
                )
                result = result.replace(
                    "M1",
                    mem1Holder.toString()
                )
                result = result.replace(
                    "M2",
                    mem2Holder.toString()
                )
                result = result.replace(
                    "M3",
                    mem3Holder.toString()
                )
                result = result.replace(
                    "M4",
                    mem4Holder.toString()
                )
                result = result.replace(
                    "M5",
                    mem5Holder.toString()
                )
                result = result.replace(
                    "M6",
                    mem6Holder.toString()
                )
                result = result.replace(
                    "M7",
                    mem7Holder.toString()
                )
                result = result.replace(
                    "M8",
                    mem8Holder.toString()
                )
                result = result.replace(
                    "M9",
                    mem9Holder.toString()
                )
                result = result.replace(
                    "M10",
                    mem10Holder.toString()
                )
                result = result.replace(
                    "M11",
                    mem11Holder.toString()
                )
                result = result.replace(
                    "M12",
                    mem12Holder.toString()
                )
                result = result.replace(
                    "M13",
                    mem13Holder.toString()
                )
                result = result.replace(
                    "M14",
                    mem14Holder.toString()
                )
                result = result.replace(
                    "M15",
                    mem15Holder.toString()
                )

                macroContains = result
                macroContainsResult.value = macroContains
            }
            else if (macroRecordIsClicked)
            {

                macroSet = "9"

            }
            else if (macroClearIsClicked)
            {

                array9Holder.clear()
                macroClearIsClicked = false

            }
            else if (falsiMethodIsClicked)
            {
                if (firstOperation.isEmpty())
                {
                    falsiNum1Holder = falsiNum1Holder.plus("9")
                    quadraticNum1Result.value = falsiNum1Holder

                }
                else if (firstOperation.isNotEmpty() && secondOperation.isEmpty())
                {

                    falsiNum2Holder = falsiNum2Holder.plus("9")
                    quadraticNum2Result.value = falsiNum2Holder

                }
                else if (firstOperation.isNotEmpty() && secondOperation.isNotEmpty())
                {

                    falsiNum3Holder = falsiNum3Holder.plus("9")
                    quadraticNum3Result.value = falsiNum3Holder

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
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun addNumber0()
    {
        try
        {
            if (falsiMethodIsClicked)
            {
                if (firstOperation.isEmpty())
                {
                    falsiNum1Holder = falsiNum1Holder.plus("0")
                    quadraticNum1Result.value = falsiNum1Holder
                }
                else if (firstOperation.isNotEmpty() && secondOperation.isEmpty())
                {
                    falsiNum2Holder = falsiNum2Holder.plus("0")
                    quadraticNum2Result.value = falsiNum2Holder
                }
                else
                {

                    falsiNum3Holder = falsiNum3Holder.plus("0")
                    quadraticNum3Result.value = falsiNum3Holder
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
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun addNumber00()
    {
        try
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
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun addDot()
    {
        try
        {
            if (falsiMethodIsClicked)
            {
                if (firstOperation.isEmpty())
                {
                    if (falsiNum1Holder.contains("."))
                    {
                        quadraticNum1Result.value = falsiNum1Holder
                    }
                    else
                    {
                        falsiNum1Holder = falsiNum1Holder.plus(".")
                        quadraticNum1Result.value = falsiNum1Holder
                    }
                }
                else if (firstOperation.isNotEmpty() && secondOperation.isEmpty())
                {
                    if (falsiNum2Holder.contains("."))
                    {
                        quadraticNum2Result.value = falsiNum2Holder
                    }
                    else
                    {
                        falsiNum2Holder = falsiNum2Holder.plus(".")
                        quadraticNum2Result.value = falsiNum2Holder
                    }
                }
                else
                {
                    if (falsiNum3Holder.contains("."))
                    {
                        quadraticNum3Result.value = falsiNum3Holder
                    }
                    else
                    {
                        falsiNum3Holder = falsiNum3Holder.plus(".")
                        quadraticNum3Result.value = falsiNum3Holder
                    }
                }
            }
            else
            {
                if (processHolder.isEmpty())
                {

                    processHolder = ""
                    proccessResult.value = processHolder

                }
                else if (resultHolder == "0" && processHolder.contains("+") || processHolder.contains(
                        "-"
                    )
                    ||
                    processHolder
                        .contains("*") || processHolder.contains("/")
                )
                {
                    processHolder += "0"
                    proccessResult.value = processHolder
                    Log.e(
                        "mesage",
                        resultHolder.toString()
                    )
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
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun deleteAll()
    {
        if (falsiMethodIsClicked)
        {

            falsiMethodIsClickedCount = 0
            falsiNum1Holder = ""
            falsiNum2Holder = ""
            falsiNum3Holder = ""
            firstOperation = ""
            secondOperation = ""
            x1RootHolder = 0.0
            x2RootHolder = 0.0
            a = 0.0
            c = 0.0
            b = 0.0
            x1 = ""
            x2 = ""


            x1Result.value = ""
            x2Result.value = ""
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

    fun deleteOneChar()
    {
        try
        {
            if (falsiMethodIsClicked)
            {
                if (falsiNum3Holder.isNotEmpty())
                {

                    falsiNum3Holder = falsiNum3Holder.dropLast(1)
                    quadraticNum3Result.value = falsiNum3Holder
                }
                else if (falsiNum3Holder.isEmpty() && secondOperation.isNotEmpty())
                {
                    secondOperation = secondOperation.dropLast(1)
                    secondOperationResult.value = secondOperation
                }
                else if (falsiNum2Holder.isNotEmpty())
                {

                    x2 = ""
                    x2Result.value = " "
                    falsiNum2Holder = falsiNum2Holder.dropLast(1)
                    quadraticNum2Result.value = falsiNum2Holder
                }
                else if (falsiNum2Holder.isEmpty() && firstOperation.isNotEmpty())
                {

                    firstOperation = firstOperation.dropLast(1)
                    firstOperationResult.value = firstOperation
                }
                else
                {
                    x1 = ""
                    x1Result.value = " "
                    falsiNum1Holder = falsiNum1Holder.dropLast(1)
                    quadraticNum1Result.value = falsiNum1Holder
                }
            }
            else
            {
                if (resultHolder == " " || resultHolder == "Error")
                {
                    resultHolder = "0"
                    processHolder = ""
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
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun changeSymbol()
    {
        try
        {
            if (falsiMethodIsClicked)
            {

                if (secondOperation.isNotEmpty() && falsiNum2Holder.isNotEmpty())
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
                else if (firstOperation.isNotEmpty() && falsiNum1Holder.isNotEmpty())
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

                    if (falsiNum1Holder.contains("-"))
                    {
                        falsiNum1Holder = falsiNum1Holder.drop(1)
                    }
                    else
                    {
                        falsiNum1Holder = ("-$falsiNum1Holder")
                    }
                    quadraticNum1Result.value = falsiNum1Holder
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
                        Log.e(
                            "tady",
                            "tady1"
                        )
                        isClickedCount = 0

                    }
                    else if (isClickedCount == 1 && resultHolder.toInt()
                            .toString() == "0"
                    )
                    {

                        resultHolder = "0"
                        processHolder = ""
                        isClickedCount = 0
                        Log.e(
                            "tady",
                            "tady2"
                        )

                    }
                    else if (isClickedCount == 1)
                    {

                        resultHolder = "-$resultHolder"
                        processHolder = "-$processHolder"
                        isClickedCount = 0
                        Log.e(
                            "tady",
                            "tady3"
                        )

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

                    Log.e(
                        "message",
                        e.message.toString()
                    )
                }
            }
        }
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun plus()
    {
        try
        {
            isClicked = false
            resultHolderLenght = resultHolder.length

            if (macroChoosed == "1")
            {

                count += 1
                if (count == arraySize)
                {

                    numberArrayHolder.add(resultHolder)

                }
                else if (array1Holder[count].toString() == "x2" && array1Holder[count + 1].toString() == "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder + "*")

                    count += 1
                }
                else if (array1Holder[count].toString() == "x2" && array1Holder[count + 1].toString() != "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder + array1Holder[count + 1])

                    count += 1
                }
                else if (array1Holder[count].toString() == "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder)

                }
                else if (array1Holder[count].toString() == "M1")
                {

                    numberArrayHolder.add(mem1Holder.toString())

                }
                else if (array1Holder[count].toString() == "M2")
                {

                    numberArrayHolder.add(mem2Holder.toString())

                }
                else if (array1Holder[count].toString() == "M3")
                {

                    numberArrayHolder.add(mem3Holder.toString())

                }
                else if (array1Holder[count].toString() == "M4")
                {

                    numberArrayHolder.add(mem4Holder.toString())

                }
                else if (array1Holder[count].toString() == "M5")
                {

                    numberArrayHolder.add(mem5Holder.toString())

                }
                else if (array1Holder[count].toString() == "M6")
                {

                    numberArrayHolder.add(mem6Holder.toString())

                }
                else if (array1Holder[count].toString() == "M7")
                {

                    numberArrayHolder.add(mem7Holder.toString())

                }
                else if (array1Holder[count].toString() == "M8")
                {

                    numberArrayHolder.add(mem8Holder.toString())

                }
                else if (array1Holder[count].toString() == "M9")
                {

                    numberArrayHolder.add(mem9Holder.toString())

                }
                else if (array1Holder[count].toString() == "M10")
                {

                    numberArrayHolder.add(mem10Holder.toString())

                }
                else if (array1Holder[count].toString() == "M11")
                {

                    numberArrayHolder.add(mem11Holder.toString())

                }
                else if (array1Holder[count].toString() == "M12")
                {

                    numberArrayHolder.add(mem12Holder.toString())

                }
                else if (array1Holder[count].toString() == "M13")
                {

                    numberArrayHolder.add(mem13Holder.toString())

                }
                else if (array1Holder[count].toString() == "M14")
                {

                    numberArrayHolder.add(mem14Holder.toString())

                }
                else if (array1Holder[count].toString() == "M15")
                {

                    numberArrayHolder.add(mem15Holder.toString())

                }
                else
                {
                    numberArrayHolder.add(resultHolder + array1Holder[count])
                }

                resultHolder = ""
                processHolder = ""

                result.value = "0"

                if (arraySize + 1 == numberArrayHolder.size)
                {

                    resultHolder = numberArrayHolder.toString()
                    resultHolder = resultHolder.drop(1)
                    resultHolder = resultHolder.dropLast(1)
                    resultHolder = resultHolder.replace(
                        ",",
                        ""
                    )


                    val expression = ExpressionBuilder(resultHolder).build()
                    val processHolderResult : Double = expression.evaluate()

                    if (processHolderResult.toString()
                            .contains(".0"))
                    {

                        result.value =
                                processHolderResult.toInt()
                                    .toString()
                    }
                    else
                    {
                        result.value = processHolderResult.toString()
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
                    "message",
                    numberArrayHolder.toString()
                )
                processHolder = numberArrayHolder.toString()
                processHolder = processHolder.drop(1)
                processHolder = processHolder.dropLast(1)
                processHolder = processHolder.replace(
                    ",",
                    ""
                )
                proccessResult.value = processHolder

            }
            else if (macroChoosed == "2")
            {

                count += 1
                if (count == arraySize)
                {

                    numberArrayHolder.add(resultHolder)

                }
                else if (array2Holder[count].toString() == "x2" && array2Holder[count + 1].toString() == "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder + "*")

                    count += 1
                }
                else if (array2Holder[count].toString() == "x2" && array2Holder[count + 1].toString() != "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder + array2Holder[count + 1])

                    count += 1
                }
                else if (array2Holder[count].toString() == "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder)

                }else if (array2Holder[count].toString() == "M1")
                {

                    numberArrayHolder.add(mem1Holder.toString())

                }
                else if (array2Holder[count].toString() == "M2")
                {

                    numberArrayHolder.add(mem2Holder.toString())

                }
                else if (array2Holder[count].toString() == "M3")
                {

                    numberArrayHolder.add(mem3Holder.toString())

                }
                else if (array2Holder[count].toString() == "M4")
                {

                    numberArrayHolder.add(mem4Holder.toString())

                }
                else if (array2Holder[count].toString() == "M5")
                {

                    numberArrayHolder.add(mem5Holder.toString())

                }
                else if (array2Holder[count].toString() == "M6")
                {

                    numberArrayHolder.add(mem6Holder.toString())

                }
                else if (array2Holder[count].toString() == "M7")
                {

                    numberArrayHolder.add(mem7Holder.toString())

                }
                else if (array2Holder[count].toString() == "M8")
                {

                    numberArrayHolder.add(mem8Holder.toString())

                }
                else if (array2Holder[count].toString() == "M9")
                {

                    numberArrayHolder.add(mem9Holder.toString())

                }
                else if (array2Holder[count].toString() == "M10")
                {

                    numberArrayHolder.add(mem10Holder.toString())

                }
                else if (array2Holder[count].toString() == "M11")
                {

                    numberArrayHolder.add(mem11Holder.toString())

                }
                else if (array2Holder[count].toString() == "M12")
                {

                    numberArrayHolder.add(mem12Holder.toString())

                }
                else if (array2Holder[count].toString() == "M13")
                {

                    numberArrayHolder.add(mem13Holder.toString())

                }
                else if (array2Holder[count].toString() == "M14")
                {

                    numberArrayHolder.add(mem14Holder.toString())

                }
                else if (array2Holder[count].toString() == "M15")
                {

                    numberArrayHolder.add(mem15Holder.toString())

                }
                else
                {

                    numberArrayHolder.add(resultHolder + array2Holder[count])
                }

                resultHolder = ""
                processHolder = ""

                result.value = "0"

                if (arraySize + 1 == numberArrayHolder.size)
                {

                    resultHolder = numberArrayHolder.toString()
                    resultHolder = resultHolder.drop(1)
                    resultHolder = resultHolder.dropLast(1)
                    resultHolder = resultHolder.replace(
                        ",",
                        ""
                    )

                    val expression = ExpressionBuilder(resultHolder).build()
                    val processHolderResult : Double = expression.evaluate()

                    if (processHolderResult.toString()
                            .contains(".0"))
                    {

                        result.value =
                                processHolderResult.toInt()
                                    .toString()
                    }
                    else
                    {
                        result.value = processHolderResult.toString()
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
                    "message",
                    numberArrayHolder.toString()
                )
                processHolder = numberArrayHolder.toString()
                processHolder = processHolder.drop(1)
                processHolder = processHolder.dropLast(1)
                processHolder = processHolder.replace(
                    ",",
                    ""
                )
                proccessResult.value = processHolder


            }
            else if (macroChoosed == "3")
            {

                count += 1
                if (count == arraySize)
                {

                    numberArrayHolder.add(resultHolder)

                }
                else if (array3Holder[count].toString() == "x2" && array3Holder[count + 1].toString() == "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder + "*")

                    count += 1
                }
                else if (array3Holder[count].toString() == "x2" && array3Holder[count + 1].toString() != "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder + array3Holder[count + 1])

                    count += 1
                }
                else if (array3Holder[count].toString() == "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder)

                }else if (array3Holder[count].toString() == "M1")
                {

                    numberArrayHolder.add(mem1Holder.toString())

                }
                else if (array3Holder[count].toString() == "M2")
                {

                    numberArrayHolder.add(mem2Holder.toString())

                }
                else if (array3Holder[count].toString() == "M3")
                {

                    numberArrayHolder.add(mem3Holder.toString())

                }
                else if (array3Holder[count].toString() == "M4")
                {

                    numberArrayHolder.add(mem4Holder.toString())

                }
                else if (array3Holder[count].toString() == "M5")
                {

                    numberArrayHolder.add(mem5Holder.toString())

                }
                else if (array3Holder[count].toString() == "M6")
                {

                    numberArrayHolder.add(mem6Holder.toString())

                }
                else if (array3Holder[count].toString() == "M7")
                {

                    numberArrayHolder.add(mem7Holder.toString())

                }
                else if (array3Holder[count].toString() == "M8")
                {

                    numberArrayHolder.add(mem8Holder.toString())

                }
                else if (array3Holder[count].toString() == "M9")
                {

                    numberArrayHolder.add(mem9Holder.toString())

                }
                else if (array3Holder[count].toString() == "M10")
                {

                    numberArrayHolder.add(mem10Holder.toString())

                }
                else if (array3Holder[count].toString() == "M11")
                {

                    numberArrayHolder.add(mem11Holder.toString())

                }
                else if (array3Holder[count].toString() == "M12")
                {

                    numberArrayHolder.add(mem12Holder.toString())

                }
                else if (array3Holder[count].toString() == "M13")
                {

                    numberArrayHolder.add(mem13Holder.toString())

                }
                else if (array3Holder[count].toString() == "M14")
                {

                    numberArrayHolder.add(mem14Holder.toString())

                }
                else if (array3Holder[count].toString() == "M15")
                {

                    numberArrayHolder.add(mem15Holder.toString())

                }
                else
                {

                    numberArrayHolder.add(resultHolder + array3Holder[count])
                }
                resultHolder = ""
                processHolder = ""
                result.value = "0"

                if (arraySize + 1 == numberArrayHolder.size)
                {

                    resultHolder = numberArrayHolder.toString()
                    resultHolder = resultHolder.drop(1)
                    resultHolder = resultHolder.dropLast(1)
                    resultHolder = resultHolder.replace(
                        ",",
                        ""
                    )

                    val expression = ExpressionBuilder(resultHolder).build()
                    val processHolderResult : Double = expression.evaluate()

                    if (processHolderResult.toString()
                            .contains(".0"))
                    {

                        result.value =
                                processHolderResult.toInt()
                                    .toString()
                    }
                    else
                    {
                        result.value = processHolderResult.toString()
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
                    "message",
                    numberArrayHolder.toString()
                )
                processHolder = numberArrayHolder.toString()
                processHolder = processHolder.drop(1)
                processHolder = processHolder.dropLast(1)
                processHolder = processHolder.replace(
                    ",",
                    ""
                )
                proccessResult.value = processHolder


            }
            else if (macroChoosed == "4")
            {

                count += 1
                if (count == arraySize)
                {

                    numberArrayHolder.add(resultHolder)

                }
                else if (array4Holder[count].toString() == "x2" && array4Holder[count + 1].toString() == "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder + "*")

                    count += 1
                }
                else if (array4Holder[count].toString() == "x2" && array4Holder[count + 1].toString() != "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder + array4Holder[count + 1])

                    count += 1
                }
                else if (array4Holder[count].toString() == "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder)

                }else if (array4Holder[count].toString() == "M1")
                {

                    numberArrayHolder.add(mem1Holder.toString())

                }
                else if (array4Holder[count].toString() == "M2")
                {

                    numberArrayHolder.add(mem2Holder.toString())

                }
                else if (array4Holder[count].toString() == "M3")
                {

                    numberArrayHolder.add(mem3Holder.toString())

                }
                else if (array4Holder[count].toString() == "M4")
                {

                    numberArrayHolder.add(mem4Holder.toString())

                }
                else if (array4Holder[count].toString() == "M5")
                {

                    numberArrayHolder.add(mem5Holder.toString())

                }
                else if (array4Holder[count].toString() == "M6")
                {

                    numberArrayHolder.add(mem6Holder.toString())

                }
                else if (array4Holder[count].toString() == "M7")
                {

                    numberArrayHolder.add(mem7Holder.toString())

                }
                else if (array4Holder[count].toString() == "M8")
                {

                    numberArrayHolder.add(mem8Holder.toString())

                }
                else if (array4Holder[count].toString() == "M9")
                {

                    numberArrayHolder.add(mem9Holder.toString())

                }
                else if (array4Holder[count].toString() == "M10")
                {

                    numberArrayHolder.add(mem10Holder.toString())

                }
                else if (array4Holder[count].toString() == "M11")
                {

                    numberArrayHolder.add(mem11Holder.toString())

                }
                else if (array4Holder[count].toString() == "M12")
                {

                    numberArrayHolder.add(mem12Holder.toString())

                }
                else if (array4Holder[count].toString() == "M13")
                {

                    numberArrayHolder.add(mem13Holder.toString())

                }
                else if (array4Holder[count].toString() == "M14")
                {

                    numberArrayHolder.add(mem14Holder.toString())

                }
                else if (array4Holder[count].toString() == "M15")
                {

                    numberArrayHolder.add(mem15Holder.toString())

                }
                else
                {

                    numberArrayHolder.add(resultHolder + array4Holder[count])
                }
                resultHolder = ""
                processHolder = ""

                result.value = "0"

                if (arraySize + 1 == numberArrayHolder.size)
                {

                    resultHolder = numberArrayHolder.toString()
                    resultHolder = resultHolder.drop(1)
                    resultHolder = resultHolder.dropLast(1)
                    resultHolder = resultHolder.replace(
                        ",",
                        ""
                    )

                    val expression = ExpressionBuilder(resultHolder).build()
                    val processHolderResult : Double = expression.evaluate()

                    if (processHolderResult.toString()
                            .contains(".0"))
                    {

                        result.value =
                                processHolderResult.toInt()
                                    .toString()
                    }
                    else
                    {
                        result.value = processHolderResult.toString()
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
                    "message",
                    numberArrayHolder.toString()
                )
                processHolder = numberArrayHolder.toString()
                processHolder = processHolder.drop(1)
                processHolder = processHolder.dropLast(1)
                processHolder = processHolder.replace(
                    ",",
                    ""
                )
                proccessResult.value = processHolder


            }
            else if (macroChoosed == "5")
            {

                count += 1
                if (count == arraySize)
                {

                    numberArrayHolder.add(resultHolder)

                }
                else if (array5Holder[count].toString() == "x2" && array5Holder[count + 1].toString() == "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder + "*")

                    count += 1
                }
                else if (array5Holder[count].toString() == "x2" && array5Holder[count + 1].toString() != "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder + array5Holder[count + 1])

                    count += 1
                }
                else if (array5Holder[count].toString() == "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder)

                }else if (array5Holder[count].toString() == "M1")
                {

                    numberArrayHolder.add(mem1Holder.toString())

                }
                else if (array5Holder[count].toString() == "M2")
                {

                    numberArrayHolder.add(mem2Holder.toString())

                }
                else if (array5Holder[count].toString() == "M3")
                {

                    numberArrayHolder.add(mem3Holder.toString())

                }
                else if (array5Holder[count].toString() == "M4")
                {

                    numberArrayHolder.add(mem4Holder.toString())

                }
                else if (array5Holder[count].toString() == "M5")
                {

                    numberArrayHolder.add(mem5Holder.toString())

                }
                else if (array5Holder[count].toString() == "M6")
                {

                    numberArrayHolder.add(mem6Holder.toString())

                }
                else if (array5Holder[count].toString() == "M7")
                {

                    numberArrayHolder.add(mem7Holder.toString())

                }
                else if (array5Holder[count].toString() == "M8")
                {

                    numberArrayHolder.add(mem8Holder.toString())

                }
                else if (array5Holder[count].toString() == "M9")
                {

                    numberArrayHolder.add(mem9Holder.toString())

                }
                else if (array5Holder[count].toString() == "M10")
                {

                    numberArrayHolder.add(mem10Holder.toString())

                }
                else if (array5Holder[count].toString() == "M11")
                {

                    numberArrayHolder.add(mem11Holder.toString())

                }
                else if (array5Holder[count].toString() == "M12")
                {

                    numberArrayHolder.add(mem12Holder.toString())

                }
                else if (array5Holder[count].toString() == "M13")
                {

                    numberArrayHolder.add(mem13Holder.toString())

                }
                else if (array5Holder[count].toString() == "M14")
                {

                    numberArrayHolder.add(mem14Holder.toString())

                }
                else if (array5Holder[count].toString() == "M15")
                {

                    numberArrayHolder.add(mem15Holder.toString())

                }
                else
                {

                    numberArrayHolder.add(resultHolder + array5Holder[count])
                }
                resultHolder = ""
                processHolder = ""

                result.value = "0"

                if (arraySize + 1 == numberArrayHolder.size)
                {

                    resultHolder = numberArrayHolder.toString()
                    resultHolder = resultHolder.drop(1)
                    resultHolder = resultHolder.dropLast(1)
                    resultHolder = resultHolder.replace(
                        ",",
                        ""
                    )

                    val expression = ExpressionBuilder(resultHolder).build()
                    val processHolderResult : Double = expression.evaluate()

                    if (processHolderResult.toString()
                            .contains(".0"))
                    {

                        result.value =
                                processHolderResult.toInt()
                                    .toString()
                    }
                    else
                    {
                        result.value = processHolderResult.toString()
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
                    "message",
                    numberArrayHolder.toString()
                )
                processHolder = numberArrayHolder.toString()
                processHolder = processHolder.drop(1)
                processHolder = processHolder.dropLast(1)
                processHolder = processHolder.replace(
                    ",",
                    ""
                )
                proccessResult.value = processHolder


            }
            else if (macroChoosed == "6")
            {

                count += 1
                if (count == arraySize)
                {

                    numberArrayHolder.add(resultHolder)

                }
                else if (array6Holder[count].toString() == "x2" && array6Holder[count + 1].toString() == "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder + "*")

                    count += 1
                }
                else if (array6Holder[count].toString() == "x2" && array6Holder[count + 1].toString() != "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder + array6Holder[count + 1])

                    count += 1
                }
                else if (array6Holder[count].toString() == "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder)

                }else if (array6Holder[count].toString() == "M1")
                {

                    numberArrayHolder.add(mem1Holder.toString())

                }
                else if (array6Holder[count].toString() == "M2")
                {

                    numberArrayHolder.add(mem2Holder.toString())

                }
                else if (array6Holder[count].toString() == "M3")
                {

                    numberArrayHolder.add(mem3Holder.toString())

                }
                else if (array6Holder[count].toString() == "M4")
                {

                    numberArrayHolder.add(mem4Holder.toString())

                }
                else if (array6Holder[count].toString() == "M5")
                {

                    numberArrayHolder.add(mem5Holder.toString())

                }
                else if (array6Holder[count].toString() == "M6")
                {

                    numberArrayHolder.add(mem6Holder.toString())

                }
                else if (array6Holder[count].toString() == "M7")
                {

                    numberArrayHolder.add(mem7Holder.toString())

                }
                else if (array6Holder[count].toString() == "M8")
                {

                    numberArrayHolder.add(mem8Holder.toString())

                }
                else if (array6Holder[count].toString() == "M9")
                {

                    numberArrayHolder.add(mem9Holder.toString())

                }
                else if (array6Holder[count].toString() == "M10")
                {

                    numberArrayHolder.add(mem10Holder.toString())

                }
                else if (array6Holder[count].toString() == "M11")
                {

                    numberArrayHolder.add(mem11Holder.toString())

                }
                else if (array6Holder[count].toString() == "M12")
                {

                    numberArrayHolder.add(mem12Holder.toString())

                }
                else if (array6Holder[count].toString() == "M13")
                {

                    numberArrayHolder.add(mem13Holder.toString())

                }
                else if (array6Holder[count].toString() == "M14")
                {

                    numberArrayHolder.add(mem14Holder.toString())

                }
                else if (array6Holder[count].toString() == "M15")
                {

                    numberArrayHolder.add(mem15Holder.toString())

                }
                else
                {

                    numberArrayHolder.add(resultHolder + array6Holder[count])
                }
                resultHolder = ""
                processHolder = ""

                result.value = "0"

                if (arraySize + 1 == numberArrayHolder.size)
                {

                    resultHolder = numberArrayHolder.toString()
                    resultHolder = resultHolder.drop(1)
                    resultHolder = resultHolder.dropLast(1)
                    resultHolder = resultHolder.replace(
                        ",",
                        ""
                    )

                    val expression = ExpressionBuilder(resultHolder).build()
                    val processHolderResult : Double = expression.evaluate()

                    if (processHolderResult.toString()
                            .contains(".0"))
                    {

                        result.value =
                                processHolderResult.toInt()
                                    .toString()
                    }
                    else
                    {
                        result.value = processHolderResult.toString()
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
                    "message",
                    numberArrayHolder.toString()
                )
                processHolder = numberArrayHolder.toString()
                processHolder = processHolder.drop(1)
                processHolder = processHolder.dropLast(1)
                processHolder = processHolder.replace(
                    ",",
                    ""
                )
                proccessResult.value = processHolder


            }
            else if (macroChoosed == "7")
            {

                count += 1
                if (count == arraySize)
                {

                    numberArrayHolder.add(resultHolder)

                }
                else if (array7Holder[count].toString() == "x2" && array7Holder[count + 1].toString() == "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder + "*")

                    count += 1
                }
                else if (array7Holder[count].toString() == "x2" && array7Holder[count + 1].toString() != "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder + array7Holder[count + 1])

                    count += 1
                }
                else if (array7Holder[count].toString() == "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder)

                }else if (array7Holder[count].toString() == "M1")
                {

                    numberArrayHolder.add(mem1Holder.toString())

                }
                else if (array7Holder[count].toString() == "M2")
                {

                    numberArrayHolder.add(mem2Holder.toString())

                }
                else if (array7Holder[count].toString() == "M3")
                {

                    numberArrayHolder.add(mem3Holder.toString())

                }
                else if (array7Holder[count].toString() == "M4")
                {

                    numberArrayHolder.add(mem4Holder.toString())

                }
                else if (array7Holder[count].toString() == "M5")
                {

                    numberArrayHolder.add(mem5Holder.toString())

                }
                else if (array7Holder[count].toString() == "M6")
                {

                    numberArrayHolder.add(mem6Holder.toString())

                }
                else if (array7Holder[count].toString() == "M7")
                {

                    numberArrayHolder.add(mem7Holder.toString())

                }
                else if (array7Holder[count].toString() == "M8")
                {

                    numberArrayHolder.add(mem8Holder.toString())

                }
                else if (array7Holder[count].toString() == "M9")
                {

                    numberArrayHolder.add(mem9Holder.toString())

                }
                else if (array7Holder[count].toString() == "M10")
                {

                    numberArrayHolder.add(mem10Holder.toString())

                }
                else if (array7Holder[count].toString() == "M11")
                {

                    numberArrayHolder.add(mem11Holder.toString())

                }
                else if (array7Holder[count].toString() == "M12")
                {

                    numberArrayHolder.add(mem12Holder.toString())

                }
                else if (array7Holder[count].toString() == "M13")
                {

                    numberArrayHolder.add(mem13Holder.toString())

                }
                else if (array7Holder[count].toString() == "M14")
                {

                    numberArrayHolder.add(mem14Holder.toString())

                }
                else if (array7Holder[count].toString() == "M15")
                {

                    numberArrayHolder.add(mem15Holder.toString())

                }
                else
                {

                    numberArrayHolder.add(resultHolder + array7Holder[count])
                }
                resultHolder = ""
                processHolder = ""

                result.value = "0"

                if (arraySize + 1 == numberArrayHolder.size)
                {

                    resultHolder = numberArrayHolder.toString()
                    resultHolder = resultHolder.drop(1)
                    resultHolder = resultHolder.dropLast(1)
                    resultHolder = resultHolder.replace(
                        ",",
                        ""
                    )

                    val expression = ExpressionBuilder(resultHolder).build()
                    val processHolderResult : Double = expression.evaluate()

                    if (processHolderResult.toString()
                            .contains(".0"))
                    {

                        result.value =
                                processHolderResult.toInt()
                                    .toString()
                    }
                    else
                    {
                        result.value = processHolderResult.toString()
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
                    "message",
                    numberArrayHolder.toString()
                )
                processHolder = numberArrayHolder.toString()
                processHolder = processHolder.drop(1)
                processHolder = processHolder.dropLast(1)
                processHolder = processHolder.replace(
                    ",",
                    ""
                )
                proccessResult.value = processHolder


            }
            else if (macroChoosed == "8")
            {

                count += 1
                if (count == arraySize)
                {

                    numberArrayHolder.add(resultHolder)

                }
                else if (array8Holder[count].toString() == "x2" && array8Holder[count + 1].toString() == "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder + "*")

                    count += 1
                }
                else if (array8Holder[count].toString() == "x2" && array8Holder[count + 1].toString() != "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder + array8Holder[count + 1])

                    count += 1
                }
                else if (array8Holder[count].toString() == "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder)

                }else if (array8Holder[count].toString() == "M1")
                {

                    numberArrayHolder.add(mem1Holder.toString())

                }
                else if (array8Holder[count].toString() == "M2")
                {

                    numberArrayHolder.add(mem2Holder.toString())

                }
                else if (array8Holder[count].toString() == "M3")
                {

                    numberArrayHolder.add(mem3Holder.toString())

                }
                else if (array8Holder[count].toString() == "M4")
                {

                    numberArrayHolder.add(mem4Holder.toString())

                }
                else if (array8Holder[count].toString() == "M5")
                {

                    numberArrayHolder.add(mem5Holder.toString())

                }
                else if (array8Holder[count].toString() == "M6")
                {

                    numberArrayHolder.add(mem6Holder.toString())

                }
                else if (array8Holder[count].toString() == "M7")
                {

                    numberArrayHolder.add(mem7Holder.toString())

                }
                else if (array8Holder[count].toString() == "M8")
                {

                    numberArrayHolder.add(mem8Holder.toString())

                }
                else if (array8Holder[count].toString() == "M9")
                {

                    numberArrayHolder.add(mem9Holder.toString())

                }
                else if (array8Holder[count].toString() == "M10")
                {

                    numberArrayHolder.add(mem10Holder.toString())

                }
                else if (array8Holder[count].toString() == "M11")
                {

                    numberArrayHolder.add(mem11Holder.toString())

                }
                else if (array8Holder[count].toString() == "M12")
                {

                    numberArrayHolder.add(mem12Holder.toString())

                }
                else if (array8Holder[count].toString() == "M13")
                {

                    numberArrayHolder.add(mem13Holder.toString())

                }
                else if (array8Holder[count].toString() == "M14")
                {

                    numberArrayHolder.add(mem14Holder.toString())

                }
                else if (array8Holder[count].toString() == "M15")
                {

                    numberArrayHolder.add(mem15Holder.toString())

                }
                else
                {

                    numberArrayHolder.add(resultHolder + array8Holder[count])
                }
                resultHolder = ""
                processHolder = ""

                result.value = "0"

                if (arraySize + 1 == numberArrayHolder.size)
                {

                    resultHolder = numberArrayHolder.toString()
                    resultHolder = resultHolder.drop(1)
                    resultHolder = resultHolder.dropLast(1)
                    resultHolder = resultHolder.replace(
                        ",",
                        ""
                    )

                    val expression = ExpressionBuilder(resultHolder).build()
                    val processHolderResult : Double = expression.evaluate()

                    if (processHolderResult.toString()
                            .contains(".0"))
                    {

                        result.value =
                                processHolderResult.toInt()
                                    .toString()
                    }
                    else
                    {
                        result.value = processHolderResult.toString()
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
                    "message",
                    numberArrayHolder.toString()
                )
                processHolder = numberArrayHolder.toString()
                processHolder = processHolder.drop(1)
                processHolder = processHolder.dropLast(1)
                processHolder = processHolder.replace(
                    ",",
                    ""
                )
                proccessResult.value = processHolder


            }
            else if (macroChoosed == "9")
            {

                count += 1
                if (count == arraySize)
                {

                    numberArrayHolder.add(resultHolder)

                }
                else if (array9Holder[count].toString() == "x2" && array9Holder[count + 1].toString() == "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder + "*")

                    count += 1
                }
                else if (array9Holder[count].toString() == "x2" && array9Holder[count + 1].toString() != "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder + array9Holder[count + 1])

                    count += 1
                }
                else if (array9Holder[count].toString() == "x2")
                {

                    numberArrayHolder.add(resultHolder + "*")
                    numberArrayHolder.add(resultHolder)

                }else if (array9Holder[count].toString() == "M1")
                {

                    numberArrayHolder.add(mem1Holder.toString())

                }
                else if (array9Holder[count].toString() == "M2")
                {

                    numberArrayHolder.add(mem2Holder.toString())

                }
                else if (array9Holder[count].toString() == "M3")
                {

                    numberArrayHolder.add(mem3Holder.toString())

                }
                else if (array9Holder[count].toString() == "M4")
                {

                    numberArrayHolder.add(mem4Holder.toString())

                }
                else if (array9Holder[count].toString() == "M5")
                {

                    numberArrayHolder.add(mem5Holder.toString())

                }
                else if (array9Holder[count].toString() == "M6")
                {

                    numberArrayHolder.add(mem6Holder.toString())

                }
                else if (array9Holder[count].toString() == "M7")
                {

                    numberArrayHolder.add(mem7Holder.toString())

                }
                else if (array9Holder[count].toString() == "M8")
                {

                    numberArrayHolder.add(mem8Holder.toString())

                }
                else if (array9Holder[count].toString() == "M9")
                {

                    numberArrayHolder.add(mem9Holder.toString())

                }
                else if (array9Holder[count].toString() == "M10")
                {

                    numberArrayHolder.add(mem10Holder.toString())

                }
                else if (array9Holder[count].toString() == "M11")
                {

                    numberArrayHolder.add(mem11Holder.toString())

                }
                else if (array9Holder[count].toString() == "M12")
                {

                    numberArrayHolder.add(mem12Holder.toString())

                }
                else if (array9Holder[count].toString() == "M13")
                {

                    numberArrayHolder.add(mem13Holder.toString())

                }
                else if (array9Holder[count].toString() == "M14")
                {

                    numberArrayHolder.add(mem14Holder.toString())

                }
                else if (array9Holder[count].toString() == "M15")
                {

                    numberArrayHolder.add(mem15Holder.toString())

                }
                else
                {

                    numberArrayHolder.add(resultHolder + array9Holder[count])
                }
                resultHolder = ""
                processHolder = ""

                result.value = "0"

                if (arraySize + 1 == numberArrayHolder.size)
                {

                    resultHolder = numberArrayHolder.toString()
                    resultHolder = resultHolder.drop(1)
                    resultHolder = resultHolder.dropLast(1)
                    resultHolder = resultHolder.replace(
                        ",",
                        ""
                    )

                    val expression = ExpressionBuilder(resultHolder).build()
                    val processHolderResult : Double = expression.evaluate()

                    if (processHolderResult.toString()
                            .contains(".0"))
                    {

                        result.value =
                                processHolderResult.toInt()
                                    .toString()
                    }
                    else
                    {
                        result.value = processHolderResult.toString()
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
                    "message",
                    numberArrayHolder.toString()
                )
                processHolder = numberArrayHolder.toString()
                processHolder = processHolder.drop(1)
                processHolder = processHolder.dropLast(1)
                processHolder = processHolder.replace(
                    ",",
                    ""
                )
                proccessResult.value = processHolder

            }
            else if (macroRecordIsClicked)
            {

                if (macroSet == "1")
                {

                    array1Holder.add("+")
                    Log.e(
                        "array",
                        array1Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array1Holder.size.toString()
                    )

                }
                else if (macroSet == "2")
                {

                    array2Holder.add("+")
                    Log.e(
                        "array",
                        array2Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array2Holder.size.toString()
                    )

                }
                else if (macroSet == "3")
                {

                    array3Holder.add("+")
                    Log.e(
                        "array",
                        array3Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array3Holder.size.toString()
                    )

                }
                else if (macroSet == "4")
                {

                    array4Holder.add("+")
                    Log.e(
                        "array",
                        array4Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array4Holder.size.toString()
                    )

                }
                else if (macroSet == "5")
                {

                    array5Holder.add("+")
                    Log.e(
                        "array",
                        array5Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array5Holder.size.toString()
                    )

                }
                else if (macroSet == "6")
                {

                    array6Holder.add("+")
                    Log.e(
                        "array",
                        array6Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array6Holder.size.toString()
                    )

                }
                else if (macroSet == "7")
                {

                    array7Holder.add("+")
                    Log.e(
                        "array",
                        array7Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array7Holder.size.toString()
                    )

                }
                else if (macroSet == "8")
                {

                    array8Holder.add("+")
                    Log.e(
                        "array",
                        array8Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array8Holder.size.toString()
                    )

                }
                else if (macroSet == "9")
                {

                    array9Holder.add("+")
                    Log.e(
                        "array",
                        array9Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array9Holder.size.toString()
                    )
                }

            }
            else if (falsiMethodIsClicked)
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
                                    .contains(".0")
                            )
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
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }

    }

    fun minus()
    {
        try
        {

            isClicked = false
            if (macroRecordIsClicked)
            {

                if (macroSet == "1")
                {

                    array1Holder.add("-")
                    Log.e(
                        "array",
                        array1Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array1Holder.size.toString()
                    )

                }
                else if (macroSet == "2")
                {

                    array2Holder.add("-")
                    Log.e(
                        "array",
                        array2Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array2Holder.size.toString()
                    )

                }
                else if (macroSet == "3")
                {

                    array3Holder.add("-")
                    Log.e(
                        "array",
                        array3Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array3Holder.size.toString()
                    )

                }
                else if (macroSet == "4")
                {

                    array4Holder.add("-")
                    Log.e(
                        "array",
                        array4Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array4Holder.size.toString()
                    )

                }
                else if (macroSet == "5")
                {

                    array5Holder.add("-")
                    Log.e(
                        "array",
                        array5Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array5Holder.size.toString()
                    )

                }
                else if (macroSet == "6")
                {

                    array6Holder.add("-")
                    Log.e(
                        "array",
                        array6Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array6Holder.size.toString()
                    )

                }
                else if (macroSet == "7")
                {

                    array7Holder.add("-")
                    Log.e(
                        "array",
                        array7Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array7Holder.size.toString()
                    )

                }
                else if (macroSet == "8")
                {

                    array8Holder.add("-")
                    Log.e(
                        "array",
                        array8Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array8Holder.size.toString()
                    )

                }
                else if (macroSet == "9")
                {

                    array9Holder.add("-")
                    Log.e(
                        "array",
                        array9Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array9Holder.size.toString()
                    )
                }

            }
            else if (falsiMethodIsClicked)
            {
                if (falsiNum1Holder.isEmpty())
                {
                    falsiNum1Holder = falsiNum1Holder.plus("-")
                    quadraticNum1Result.value = falsiNum1Holder
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
                                    .contains(".0")
                            )
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
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun multiply()
    {
        try
        {

            isClicked = false
            if (macroRecordIsClicked)
            {

                if (macroSet == "1")
                {

                    array1Holder.add("*")
                    Log.e(
                        "array",
                        array1Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array1Holder.size.toString()
                    )

                }
                else if (macroSet == "2")
                {

                    array2Holder.add("*")
                    Log.e(
                        "array",
                        array2Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array2Holder.size.toString()
                    )

                }
                else if (macroSet == "3")
                {

                    array3Holder.add("*")
                    Log.e(
                        "array",
                        array3Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array3Holder.size.toString()
                    )

                }
                else if (macroSet == "4")
                {

                    array4Holder.add("*")
                    Log.e(
                        "array",
                        array4Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array4Holder.size.toString()
                    )

                }
                else if (macroSet == "5")
                {

                    array5Holder.add("*")
                    Log.e(
                        "array",
                        array5Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array5Holder.size.toString()
                    )

                }
                else if (macroSet == "6")
                {

                    array6Holder.add("*")
                    Log.e(
                        "array",
                        array6Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array6Holder.size.toString()
                    )

                }
                else if (macroSet == "7")
                {

                    array7Holder.add("*")
                    Log.e(
                        "array",
                        array7Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array7Holder.size.toString()
                    )

                }
                else if (macroSet == "8")
                {

                    array8Holder.add("*")
                    Log.e(
                        "array",
                        array8Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array8Holder.size.toString()
                    )

                }
                else if (macroSet == "9")
                {

                    array9Holder.add("*")
                    Log.e(
                        "array",
                        array9Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array9Holder.size.toString()
                    )
                }

            }
            else
            {

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
                                    .contains(".0")
                            )
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
        }
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun divide()
    {
        try
        {
            if (falsiMethodIsClicked)
            {
                if (firstOperation.isEmpty())
                {
                    x1 = "x⁵"
                    x1Result.value = x1
                }
                else
                {
                    x2 = "x⁵"
                    x2Result.value = x2
                }
            }
            else
            {
                isClicked = false
                if (macroRecordIsClicked)
                {

                    if (macroSet == "1")
                    {

                        array1Holder.add("/")
                        Log.e(
                            "array",
                            array1Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array1Holder.size.toString()
                        )

                    }
                    else if (macroSet == "2")
                    {

                        array2Holder.add("/")
                        Log.e(
                            "array",
                            array2Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array2Holder.size.toString()
                        )

                    }
                    else if (macroSet == "3")
                    {

                        array3Holder.add("/")
                        Log.e(
                            "array",
                            array3Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array3Holder.size.toString()
                        )

                    }
                    else if (macroSet == "4")
                    {

                        array4Holder.add("/")
                        Log.e(
                            "array",
                            array4Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array4Holder.size.toString()
                        )

                    }
                    else if (macroSet == "5")
                    {

                        array5Holder.add("/")
                        Log.e(
                            "array",
                            array5Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array5Holder.size.toString()
                        )

                    }
                    else if (macroSet == "6")
                    {

                        array6Holder.add("/")
                        Log.e(
                            "array",
                            array6Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array6Holder.size.toString()
                        )

                    }
                    else if (macroSet == "7")
                    {

                        array7Holder.add("/")
                        Log.e(
                            "array",
                            array7Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array7Holder.size.toString()
                        )

                    }
                    else if (macroSet == "8")
                    {

                        array8Holder.add("/")
                        Log.e(
                            "array",
                            array8Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array8Holder.size.toString()
                        )

                    }
                    else if (macroSet == "9")
                    {

                        array9Holder.add("/")
                        Log.e(
                            "array",
                            array9Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array9Holder.size.toString()
                        )
                    }

                }
                else
                {
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
                                        .contains(".0")
                                )
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
            }
        }
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun percent()
    {
        try
        {
            isClicked = true

            if (falsiMethodIsClicked)
            {
                if (firstOperation.isEmpty())
                {
                    x1 = "x³"
                    x1Result.value = x1
                }
                else
                {
                    x2 = "x³"
                    x2Result.value = x2
                }
            }
            else
            {


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
                                .contains(".00")
                        )
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
                    Log.e(
                        "lenght",
                        resultHolderLenght.toString()
                    )

                }
                else
                {
                    processHolder = resultHolder
                    proccessResult.value = processHolder
                }
                result.value = resultHolder
            }
        }
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun power2()
    {
        try
        {
            if (falsiMethodIsClicked)
            {
                if (firstOperation.isEmpty())
                {
                    x1 = "x"
                    x1Result.value = x1
                }
                else
                {
                    x2 = "x"
                    x2Result.value = x2
                }
            }
            else
            {

                isClicked = true

                isClicked = false
                if (macroRecordIsClicked)
                {

                    if (macroSet == "1")
                    {

                        array1Holder.add("x2")
                        Log.e(
                            "array",
                            array1Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array1Holder.size.toString()
                        )

                    }
                    else if (macroSet == "2")
                    {

                        array2Holder.add("x2")
                        Log.e(
                            "array",
                            array2Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array2Holder.size.toString()
                        )

                    }
                    else if (macroSet == "3")
                    {

                        array3Holder.add("x2")
                        Log.e(
                            "array",
                            array3Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array3Holder.size.toString()
                        )

                    }
                    else if (macroSet == "4")
                    {

                        array4Holder.add("x2")
                        Log.e(
                            "array",
                            array4Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array4Holder.size.toString()
                        )

                    }
                    else if (macroSet == "5")
                    {

                        array5Holder.add("x2")
                        Log.e(
                            "array",
                            array5Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array5Holder.size.toString()
                        )

                    }
                    else if (macroSet == "6")
                    {

                        array6Holder.add("x2")
                        Log.e(
                            "array",
                            array6Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array6Holder.size.toString()
                        )

                    }
                    else if (macroSet == "7")
                    {

                        array7Holder.add("x2")
                        Log.e(
                            "array",
                            array7Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array7Holder.size.toString()
                        )

                    }
                    else if (macroSet == "8")
                    {

                        array8Holder.add("x2")
                        Log.e(
                            "array",
                            array8Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array8Holder.size.toString()
                        )

                    }
                    else if (macroSet == "9")
                    {

                        array9Holder.add("x2")
                        Log.e(
                            "array",
                            array9Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array9Holder.size.toString()
                        )
                    }

                }
                else
                {
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
                                .contains(".")
                        )
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
                        Log.e(
                            "lenght",
                            resultHolderLenght.toString()
                        )

                    }
                    else
                    {
                        processHolder = resultHolder
                        proccessResult.value = processHolder
                    }

                    result.value = resultHolder
                    // proccessResult.value = processHolder
                }
            }
        }
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun power3()
    {
        try
        {
            if (falsiMethodIsClicked)
            {
                if (firstOperation.isEmpty())
                {
                    x1 = "x²"
                    x1Result.value = x1
                }
                else
                {
                    x2 = "x²"
                    x2Result.value = x2
                }
            }
            else
            {
                isClicked = true

                resultHolderLenght = resultHolder.length

                if (macroRecordIsClicked)
                {

                    if (macroSet == "1")
                    {

                        array1Holder.add("x3")
                        Log.e(
                            "array",
                            array1Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array1Holder.size.toString()
                        )

                    }
                    else if (macroSet == "2")
                    {

                        array2Holder.add("x3")
                        Log.e(
                            "array",
                            array2Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array2Holder.size.toString()
                        )

                    }
                    else if (macroSet == "3")
                    {

                        array3Holder.add("x3")
                        Log.e(
                            "array",
                            array3Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array3Holder.size.toString()
                        )

                    }
                    else if (macroSet == "4")
                    {

                        array4Holder.add("x3")
                        Log.e(
                            "array",
                            array4Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array4Holder.size.toString()
                        )

                    }
                    else if (macroSet == "5")
                    {

                        array5Holder.add("x3")
                        Log.e(
                            "array",
                            array5Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array5Holder.size.toString()
                        )

                    }
                    else if (macroSet == "6")
                    {

                        array6Holder.add("x3")
                        Log.e(
                            "array",
                            array6Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array6Holder.size.toString()
                        )

                    }
                    else if (macroSet == "7")
                    {

                        array7Holder.add("x3")
                        Log.e(
                            "array",
                            array7Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array7Holder.size.toString()
                        )

                    }
                    else if (macroSet == "8")
                    {

                        array8Holder.add("x3")
                        Log.e(
                            "array",
                            array8Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array8Holder.size.toString()
                        )

                    }
                    else if (macroSet == "9")
                    {

                        array9Holder.add("x3")
                        Log.e(
                            "array",
                            array9Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array9Holder.size.toString()
                        )
                    }

                }
                else
                {

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
                                    .contains(".")
                            )
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
                        Log.e(
                            "lenght",
                            resultHolderLenght.toString()
                        )

                    }
                    else
                    {
                        processHolder = resultHolder
                        proccessResult.value = processHolder
                    }

                    result.value = resultHolder
                    //proccessResult.value = processHolder
                }
            }
        }
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun squareRoot()
    {
        try
        {

            if (falsiMethodIsClicked)
            {
                if (firstOperation.isEmpty())
                {
                    x1 = "x⁴"
                    x1Result.value = x1
                }
                else
                {
                    x2 = "x⁴"
                    x2Result.value = x2
                }
            }
            else
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
                                .contains(".0")
                        )
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
                    Log.e(
                        "lenght",
                        resultHolderLenght.toString()
                    )

                }
                else
                {
                    processHolder = resultHolder
                    proccessResult.value = processHolder
                }

                result.value = resultHolder

            }
        }
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun memoryRecord()
    {
        try
        {
            memRecordIsClicked = true
            processHolder = ""
            proccessResult.value = processHolder
        }
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun memoryClear()
    {
        memCLearIsClicked = true
    }

    fun macroRecord()
    {

        macroRecordIsClicked = true
        processHolder = ""
        resultHolder = "0"
        result.value = resultHolder
        proccessResult.value = processHolder
    }

    fun macroClear()
    {
        macroClearIsClicked = true
    }

    fun macroStopRecord()
    {
        macroRecordIsClicked = false
        macroSet = ""
    }

    fun macroRecall()
    {
        macroRecallIsClicked = true
    }

    fun mem1()
    {
        try
        {
            if (macroRecordIsClicked)
            {

                if (macroRecordIsClicked)
                {

                    if (macroSet == "1")
                    {

                        array1Holder.add("M1")
                        Log.e(
                            "array",
                            array1Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array1Holder.size.toString()
                        )


                    }
                    else if (macroSet == "2")
                    {

                        array2Holder.add("M1")
                        Log.e(
                            "array",
                            array2Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array2Holder.size.toString()
                        )

                    }
                    else if (macroSet == "3")
                    {

                        array3Holder.add("M1")
                        Log.e(
                            "array",
                            array3Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array3Holder.size.toString()
                        )

                    }
                    else if (macroSet == "4")
                    {

                        array4Holder.add("M1")
                        Log.e(
                            "array",
                            array4Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array4Holder.size.toString()
                        )

                    }
                    else if (macroSet == "5")
                    {

                        array5Holder.add("M1")
                        Log.e(
                            "array",
                            array5Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array5Holder.size.toString()
                        )

                    }
                    else if (macroSet == "6")
                    {

                        array6Holder.add("M1")
                        Log.e(
                            "array",
                            array6Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array6Holder.size.toString()
                        )

                    }
                    else if (macroSet == "7")
                    {

                        array7Holder.add("M1")
                        Log.e(
                            "array",
                            array7Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array7Holder.size.toString()
                        )

                    }
                    else if (macroSet == "8")
                    {

                        array8Holder.add("M1")
                        Log.e(
                            "array",
                            array8Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array8Holder.size.toString()
                        )

                    }
                    else if (macroSet == "9")
                    {

                        array9Holder.add("M1")
                        Log.e(
                            "array",
                            array9Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array9Holder.size.toString()
                        )
                    }
                }
            }
            else if (falsiMethodIsClicked)
            {

                if (memRecordIsClicked)
                {
                    mem1FalsiHolder.clear()

                    mem1FalsiHolder.add(falsiNum1Holder)
                    mem1FalsiHolder.add(x1)
                    mem1FalsiHolder.add(firstOperation)
                    mem1FalsiHolder.add(falsiNum2Holder)
                    mem1FalsiHolder.add(x2)
                    mem1FalsiHolder.add(secondOperation)
                    mem1FalsiHolder.add(falsiNum3Holder)

                    Log.e("message", mem1FalsiHolder.toString())
                    mem1Value.value =
                            mem1FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                                .replace(",", "")
                                .replace(" ", "")
                    mem1Holder = ""
                    memRecordIsClicked = false
                }

                if (mem1FalsiHolder.isNotEmpty() && !memRecordIsClicked)
                {
                    Log.e("message", mem1FalsiHolder.toString())
                    secondOperation = mem1FalsiHolder[5].toString()
                    falsiNum3Holder = mem1FalsiHolder[6].toString()
                    falsiNum1Holder = mem1FalsiHolder[0].toString()
                    x1 = mem1FalsiHolder[1].toString()
                    firstOperation = mem1FalsiHolder[2].toString()
                    falsiNum2Holder = mem1FalsiHolder[3].toString()
                    x2 = mem1FalsiHolder[4].toString()
                }
                else
                {

                    if (falsiNum1Holder.isEmpty())
                    {
                        falsiNum1Holder = mem1Holder.toString()
                        quadraticNum1Result.value = falsiNum1Holder
                    }
                    else if (firstOperation.isEmpty())
                    {
                        if (mem1Holder.toString()
                                .contains("-")
                        )
                        {

                            firstOperation = "-"
                            stringHolder = mem1Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation

                        }
                        else
                        {
                            firstOperation = "+"
                            stringHolder = mem1Holder
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation
                        }
                    }
                    else
                    {

                        if (mem1Holder.toString()
                                .contains("-")
                        )
                        {
                            secondOperation = "-"
                            stringHolder = mem1Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation

                        }
                        else
                        {
                            secondOperation = "+"
                            stringHolder = mem1Holder
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation
                        }
                    }
                }




                if (memCLearIsClicked)
                {
                    mem1FalsiHolder.clear()
                    mem1Value.value =
                            mem1FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                    memCLearIsClicked = false
                }

                quadraticNum1Result.value = falsiNum1Holder
                secondOperationResult.value = secondOperation
                quadraticNum2Result.value = falsiNum2Holder
                firstOperationResult.value = firstOperation
                x1Result.value = x1
                x2Result.value = x2
                quadraticNum3Result.value = falsiNum3Holder

            }
            else
            {

                memIsClickedCount += 1

                if (mem1Holder == "0")
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
                    mem1FalsiHolder.clear()
                    Log.e("message", mem1FalsiHolder.toString())
                    Log.e("message", mem1Holder.toString())
                }

                if (memIsClickedCount == 2)
                {
                    if (mem1FalsiHolder.isEmpty())
                    {
                        if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                "*"
                            ) || processHolder.contains(
                                "/"
                            )
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

                        mem1Value.value = mem1Holder
                    }
                }
            }
        }
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }


    fun mem2()
    {
        try
        {
            Log.e("mess", "called M2 fun")
            if (macroRecordIsClicked)
            {

                if (macroSet == "1")
                {

                    array1Holder.add("M2")
                    Log.e(
                        "array",
                        array1Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array1Holder.size.toString()
                    )


                }
                else if (macroSet == "2")
                {

                    array2Holder.add("M2")
                    Log.e(
                        "array",
                        array2Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array2Holder.size.toString()
                    )

                }
                else if (macroSet == "3")
                {

                    array3Holder.add("M2")
                    Log.e(
                        "array",
                        array3Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array3Holder.size.toString()
                    )

                }
                else if (macroSet == "4")
                {

                    array4Holder.add("M2")
                    Log.e(
                        "array",
                        array4Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array4Holder.size.toString()
                    )

                }
                else if (macroSet == "5")
                {

                    array5Holder.add("M2")
                    Log.e(
                        "array",
                        array5Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array5Holder.size.toString()
                    )

                }
                else if (macroSet == "6")
                {

                    array6Holder.add("M2")
                    Log.e(
                        "array",
                        array6Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array6Holder.size.toString()
                    )

                }
                else if (macroSet == "7")
                {

                    array7Holder.add("M2")
                    Log.e(
                        "array",
                        array7Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array7Holder.size.toString()
                    )

                }
                else if (macroSet == "8")
                {

                    array8Holder.add("M2")
                    Log.e(
                        "array",
                        array8Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array8Holder.size.toString()
                    )

                }
                else if (macroSet == "9")
                {

                    array9Holder.add("M2")
                    Log.e(
                        "array",
                        array9Holder.toString()
                    )
                    Log.e(
                        "set",
                        macroSet.toString()
                    )
                    Log.e(
                        "length",
                        array9Holder.size.toString()
                    )

                }
            }
            else if (falsiMethodIsClicked)
            {
                if (memRecordIsClicked)
                {
                    mem2FalsiHolder.clear()

                    mem2FalsiHolder.add(falsiNum1Holder)
                    mem2FalsiHolder.add(x1)
                    mem2FalsiHolder.add(firstOperation)
                    mem2FalsiHolder.add(falsiNum2Holder)
                    mem2FalsiHolder.add(x2)
                    mem2FalsiHolder.add(secondOperation)
                    mem2FalsiHolder.add(falsiNum3Holder)

                    Log.e("message", mem2FalsiHolder.toString())
                    mem2Value.value =
                            mem2FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                                .replace(",", "")
                                .replace(" ", "")
                    mem2Holder = ""
                    memRecordIsClicked = false
                }

                if (mem2FalsiHolder.isNotEmpty() && !memRecordIsClicked)
                {
                    Log.e("message", mem2FalsiHolder.toString())
                    secondOperation = mem2FalsiHolder[5].toString()
                    falsiNum3Holder = mem2FalsiHolder[6].toString()
                    falsiNum1Holder = mem2FalsiHolder[0].toString()
                    x1 = mem2FalsiHolder[1].toString()
                    firstOperation = mem2FalsiHolder[2].toString()
                    falsiNum2Holder = mem2FalsiHolder[3].toString()
                    x2 = mem2FalsiHolder[4].toString()
                }
                else
                {

                    if (falsiNum1Holder.isEmpty())
                    {
                        falsiNum1Holder = mem2Holder.toString()
                        quadraticNum1Result.value = falsiNum1Holder
                    }
                    else if (firstOperation.isEmpty())
                    {
                        if (mem2Holder.toString()
                                .contains("-")
                        )
                        {

                            firstOperation = "-"
                            stringHolder = mem2Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation

                        }
                        else
                        {
                            firstOperation = "+"
                            stringHolder = mem2Holder
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation
                        }
                    }
                    else
                    {

                        if (mem2Holder.toString()
                                .contains("-")
                        )
                        {
                            secondOperation = "-"
                            stringHolder = mem2Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation

                        }
                        else
                        {
                            secondOperation = "+"
                            stringHolder = mem2Holder
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation
                        }
                    }
                }




                if (memCLearIsClicked)
                {
                    mem2FalsiHolder.clear()
                    mem2Value.value =
                            mem2FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                    memCLearIsClicked = false
                }

                quadraticNum1Result.value = falsiNum1Holder
                secondOperationResult.value = secondOperation
                quadraticNum2Result.value = falsiNum2Holder
                firstOperationResult.value = firstOperation
                x1Result.value = x1
                x2Result.value = x2
                quadraticNum3Result.value = falsiNum3Holder

            }
            else
            {

                memIsClickedCount += 1

                if (mem2Holder == "0")
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
                    memRecordIsClicked = false
                    mem2FalsiHolder.clear()
                    Log.e("message", mem2FalsiHolder.toString())
                    Log.e("message", mem2Holder.toString())
                }

                if (memIsClickedCount == 2)
                {
                    if (mem2FalsiHolder.isEmpty())
                    {
                        if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                "*"
                            ) || processHolder.contains(
                                "/"
                            )
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

                        mem2Value.value = mem2Holder
                    }
                }
            }
        }
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun mem3()
    {
        try
        {
            if (macroRecordIsClicked)
            {
                isClicked = true

                isClicked = false
                if (macroRecordIsClicked)
                {

                    if (macroSet == "1")
                    {

                        array1Holder.add("M3")
                        Log.e(
                            "array",
                            array1Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array1Holder.size.toString()
                        )


                    }
                    else if (macroSet == "2")
                    {

                        array2Holder.add("M3")
                        Log.e(
                            "array",
                            array2Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array2Holder.size.toString()
                        )

                    }
                    else if (macroSet == "3")
                    {

                        array3Holder.add("M3")
                        Log.e(
                            "array",
                            array3Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array3Holder.size.toString()
                        )

                    }
                    else if (macroSet == "4")
                    {

                        array4Holder.add("M3")
                        Log.e(
                            "array",
                            array4Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array4Holder.size.toString()
                        )

                    }
                    else if (macroSet == "5")
                    {

                        array5Holder.add("M3")
                        Log.e(
                            "array",
                            array5Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array5Holder.size.toString()
                        )

                    }
                    else if (macroSet == "6")
                    {

                        array6Holder.add("M3")
                        Log.e(
                            "array",
                            array6Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array6Holder.size.toString()
                        )

                    }
                    else if (macroSet == "7")
                    {

                        array7Holder.add("M3")
                        Log.e(
                            "array",
                            array7Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array7Holder.size.toString()
                        )

                    }
                    else if (macroSet == "8")
                    {

                        array8Holder.add("M3")
                        Log.e(
                            "array",
                            array8Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array8Holder.size.toString()
                        )

                    }
                    else if (macroSet == "9")
                    {

                        array9Holder.add("M3")
                        Log.e(
                            "array",
                            array9Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array9Holder.size.toString()
                        )
                    }
                }
            }
            else if (falsiMethodIsClicked)
            {
                if (memRecordIsClicked)
                {
                    mem3FalsiHolder.clear()

                    mem3FalsiHolder.add(falsiNum1Holder)
                    mem3FalsiHolder.add(x1)
                    mem3FalsiHolder.add(firstOperation)
                    mem3FalsiHolder.add(falsiNum2Holder)
                    mem3FalsiHolder.add(x2)
                    mem3FalsiHolder.add(secondOperation)
                    mem3FalsiHolder.add(falsiNum3Holder)

                    Log.e("message", mem3FalsiHolder.toString())
                    mem3Value.value =
                            mem3FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                                .replace(",", "")
                                .replace(" ", "")
                    mem3Holder = ""
                    memRecordIsClicked = false
                }

                if (mem3FalsiHolder.isNotEmpty() && !memRecordIsClicked)
                {
                    Log.e("message", mem3FalsiHolder.toString())
                    secondOperation = mem3FalsiHolder[5].toString()
                    falsiNum3Holder = mem3FalsiHolder[6].toString()
                    falsiNum1Holder = mem3FalsiHolder[0].toString()
                    x1 = mem3FalsiHolder[1].toString()
                    firstOperation = mem3FalsiHolder[2].toString()
                    falsiNum2Holder = mem3FalsiHolder[3].toString()
                    x2 = mem3FalsiHolder[4].toString()
                }
                else
                {

                    if (falsiNum1Holder.isEmpty())
                    {
                        falsiNum1Holder = mem3Holder.toString()
                        quadraticNum1Result.value = falsiNum1Holder
                    }
                    else if (firstOperation.isEmpty())
                    {
                        if (mem3Holder.toString()
                                .contains("-")
                        )
                        {

                            firstOperation = "-"
                            stringHolder = mem3Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation

                        }
                        else
                        {
                            firstOperation = "+"
                            stringHolder = mem3Holder
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation
                        }
                    }
                    else
                    {

                        if (mem3Holder.toString()
                                .contains("-")
                        )
                        {
                            secondOperation = "-"
                            stringHolder = mem3Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation

                        }
                        else
                        {
                            secondOperation = "+"
                            stringHolder = mem3Holder
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation
                        }
                    }
                }




                if (memCLearIsClicked)
                {
                    mem3FalsiHolder.clear()
                    mem3Value.value =
                            mem3FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                    memCLearIsClicked = false
                }

                quadraticNum1Result.value = falsiNum1Holder
                secondOperationResult.value = secondOperation
                quadraticNum2Result.value = falsiNum2Holder
                firstOperationResult.value = firstOperation
                x1Result.value = x1
                x2Result.value = x2
                quadraticNum3Result.value = falsiNum3Holder

            }
            else
            {

                memIsClickedCount += 1

                if (mem3Holder == "0")
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
                    memRecordIsClicked = false
                    mem3FalsiHolder.clear()
                    Log.e("message", mem3FalsiHolder.toString())
                    Log.e("message", mem3Holder.toString())
                }

                if (memIsClickedCount == 2)
                {
                    if (mem3FalsiHolder.isEmpty())
                    {
                        if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                "*"
                            ) || processHolder.contains(
                                "/"
                            )
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

                        mem3Value.value = mem3Holder
                    }
                }
            }
        }
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun mem4()
    {
        try
        {
            if (macroRecordIsClicked)
            {
                isClicked = true

                isClicked = false
                if (macroRecordIsClicked)
                {

                    if (macroSet == "1")
                    {

                        array1Holder.add("M4")
                        Log.e(
                            "array",
                            array1Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array1Holder.size.toString()
                        )


                    }
                    else if (macroSet == "2")
                    {

                        array2Holder.add("M4")
                        Log.e(
                            "array",
                            array2Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array2Holder.size.toString()
                        )

                    }
                    else if (macroSet == "3")
                    {

                        array3Holder.add("M4")
                        Log.e(
                            "array",
                            array3Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array3Holder.size.toString()
                        )

                    }
                    else if (macroSet == "4")
                    {

                        array4Holder.add("M4")
                        Log.e(
                            "array",
                            array4Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array4Holder.size.toString()
                        )

                    }
                    else if (macroSet == "5")
                    {

                        array5Holder.add("M4")
                        Log.e(
                            "array",
                            array5Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array5Holder.size.toString()
                        )

                    }
                    else if (macroSet == "6")
                    {

                        array6Holder.add("M4")
                        Log.e(
                            "array",
                            array6Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array6Holder.size.toString()
                        )

                    }
                    else if (macroSet == "7")
                    {

                        array7Holder.add("M4")
                        Log.e(
                            "array",
                            array7Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array7Holder.size.toString()
                        )

                    }
                    else if (macroSet == "8")
                    {

                        array8Holder.add("M4")
                        Log.e(
                            "array",
                            array8Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array8Holder.size.toString()
                        )

                    }
                    else if (macroSet == "9")
                    {

                        array9Holder.add("M4")
                        Log.e(
                            "array",
                            array9Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array9Holder.size.toString()
                        )
                    }
                }
            }
            else if (falsiMethodIsClicked)
            {
                if (memRecordIsClicked)
                {
                    mem4FalsiHolder.clear()

                    mem4FalsiHolder.add(falsiNum1Holder)
                    mem4FalsiHolder.add(x1)
                    mem4FalsiHolder.add(firstOperation)
                    mem4FalsiHolder.add(falsiNum2Holder)
                    mem4FalsiHolder.add(x2)
                    mem4FalsiHolder.add(secondOperation)
                    mem4FalsiHolder.add(falsiNum3Holder)

                    Log.e("message", mem4FalsiHolder.toString())
                    mem4Value.value =
                            mem4FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                                .replace(",", "")
                                .replace(" ", "")
                    mem4Holder = ""
                    memRecordIsClicked = false
                }

                if (mem4FalsiHolder.isNotEmpty() && !memRecordIsClicked)
                {
                    Log.e("message", mem4FalsiHolder.toString())
                    secondOperation = mem4FalsiHolder[5].toString()
                    falsiNum3Holder = mem4FalsiHolder[6].toString()
                    falsiNum1Holder = mem4FalsiHolder[0].toString()
                    x1 = mem4FalsiHolder[1].toString()
                    firstOperation = mem4FalsiHolder[2].toString()
                    falsiNum2Holder = mem4FalsiHolder[3].toString()
                    x2 = mem4FalsiHolder[4].toString()
                }
                else
                {

                    if (falsiNum1Holder.isEmpty())
                    {
                        falsiNum1Holder = mem4Holder.toString()
                        quadraticNum1Result.value = falsiNum1Holder
                    }
                    else if (firstOperation.isEmpty())
                    {
                        if (mem4Holder.toString()
                                .contains("-")
                        )
                        {

                            firstOperation = "-"
                            stringHolder = mem4Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation

                        }
                        else
                        {
                            firstOperation = "+"
                            stringHolder = mem4Holder
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation
                        }
                    }
                    else
                    {

                        if (mem4Holder.toString()
                                .contains("-")
                        )
                        {
                            secondOperation = "-"
                            stringHolder = mem4Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation

                        }
                        else
                        {
                            secondOperation = "+"
                            stringHolder = mem4Holder
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation
                        }
                    }
                }




                if (memCLearIsClicked)
                {
                    mem4FalsiHolder.clear()
                    mem4Value.value =
                            mem4FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                    memCLearIsClicked = false
                }

                quadraticNum1Result.value = falsiNum1Holder
                secondOperationResult.value = secondOperation
                quadraticNum2Result.value = falsiNum2Holder
                firstOperationResult.value = firstOperation
                x1Result.value = x1
                x2Result.value = x2
                quadraticNum3Result.value = falsiNum3Holder

            }
            else
            {

                memIsClickedCount += 1

                if (mem4Holder == "0")
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
                    memRecordIsClicked = false
                    mem4FalsiHolder.clear()
                    Log.e("message", mem4FalsiHolder.toString())
                    Log.e("message", mem4Holder.toString())
                }

                if (memIsClickedCount == 2)
                {
                    if (mem4FalsiHolder.isEmpty())
                    {
                        if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                "*"
                            ) || processHolder.contains(
                                "/"
                            )
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

                        mem4Value.value = mem4Holder
                    }
                }
            }
        }
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun mem5()
    {
        try
        {

            if (macroRecordIsClicked)
            {
                isClicked = true

                isClicked = false
                if (macroRecordIsClicked)
                {

                    if (macroSet == "1")
                    {

                        array1Holder.add("M5")
                        Log.e(
                            "array",
                            array1Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array1Holder.size.toString()
                        )


                    }
                    else if (macroSet == "2")
                    {

                        array2Holder.add("M5")
                        Log.e(
                            "array",
                            array2Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array2Holder.size.toString()
                        )

                    }
                    else if (macroSet == "3")
                    {

                        array3Holder.add("M5")
                        Log.e(
                            "array",
                            array3Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array3Holder.size.toString()
                        )

                    }
                    else if (macroSet == "4")
                    {

                        array4Holder.add("M5")
                        Log.e(
                            "array",
                            array4Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array4Holder.size.toString()
                        )

                    }
                    else if (macroSet == "5")
                    {

                        array5Holder.add("M5")
                        Log.e(
                            "array",
                            array5Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array5Holder.size.toString()
                        )

                    }
                    else if (macroSet == "6")
                    {

                        array6Holder.add("M5")
                        Log.e(
                            "array",
                            array6Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array6Holder.size.toString()
                        )

                    }
                    else if (macroSet == "7")
                    {

                        array7Holder.add("M5")
                        Log.e(
                            "array",
                            array7Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array7Holder.size.toString()
                        )

                    }
                    else if (macroSet == "8")
                    {

                        array8Holder.add("M5")
                        Log.e(
                            "array",
                            array8Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array8Holder.size.toString()
                        )

                    }
                    else if (macroSet == "9")
                    {

                        array9Holder.add("M5")
                        Log.e(
                            "array",
                            array9Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array9Holder.size.toString()
                        )
                    }
                }
            }
            else if (falsiMethodIsClicked)
            {
                if (memRecordIsClicked)
                {
                    mem5FalsiHolder.clear()

                    mem5FalsiHolder.add(falsiNum1Holder)
                    mem5FalsiHolder.add(x1)
                    mem5FalsiHolder.add(firstOperation)
                    mem5FalsiHolder.add(falsiNum2Holder)
                    mem5FalsiHolder.add(x2)
                    mem5FalsiHolder.add(secondOperation)
                    mem5FalsiHolder.add(falsiNum3Holder)

                    Log.e("message", mem5FalsiHolder.toString())
                    mem5Value.value =
                            mem5FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                                .replace(",", "")
                                .replace(" ", "")
                    mem5Holder = ""
                    memRecordIsClicked = false
                }

                if (mem5FalsiHolder.isNotEmpty() && !memRecordIsClicked)
                {
                    Log.e("message", mem5FalsiHolder.toString())
                    secondOperation = mem5FalsiHolder[5].toString()
                    falsiNum3Holder = mem5FalsiHolder[6].toString()
                    falsiNum1Holder = mem5FalsiHolder[0].toString()
                    x1 = mem5FalsiHolder[1].toString()
                    firstOperation = mem5FalsiHolder[2].toString()
                    falsiNum2Holder = mem5FalsiHolder[3].toString()
                    x2 = mem5FalsiHolder[4].toString()
                }
                else
                {

                    if (falsiNum1Holder.isEmpty())
                    {
                        falsiNum1Holder = mem5Holder.toString()
                        quadraticNum1Result.value = falsiNum1Holder
                    }
                    else if (firstOperation.isEmpty())
                    {
                        if (mem5Holder.toString()
                                .contains("-")
                        )
                        {

                            firstOperation = "-"
                            stringHolder = mem5Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation

                        }
                        else
                        {
                            firstOperation = "+"
                            stringHolder = mem5Holder
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation
                        }
                    }
                    else
                    {

                        if (mem5Holder.toString()
                                .contains("-")
                        )
                        {
                            secondOperation = "-"
                            stringHolder = mem5Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation

                        }
                        else
                        {
                            secondOperation = "+"
                            stringHolder = mem5Holder
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation
                        }
                    }
                }




                if (memCLearIsClicked)
                {
                    mem5FalsiHolder.clear()
                    mem5Value.value =
                            mem5FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                    memCLearIsClicked = false
                }

                quadraticNum1Result.value = falsiNum1Holder
                secondOperationResult.value = secondOperation
                quadraticNum2Result.value = falsiNum2Holder
                firstOperationResult.value = firstOperation
                x1Result.value = x1
                x2Result.value = x2
                quadraticNum3Result.value = falsiNum3Holder

            }
            else
            {

                memIsClickedCount += 1

                if (mem5Holder == "0")
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
                    memRecordIsClicked = false
                    mem5FalsiHolder.clear()
                    Log.e("message", mem5FalsiHolder.toString())
                    Log.e("message", mem5Holder.toString())
                }

                if (memIsClickedCount == 2)
                {
                    if (mem5FalsiHolder.isEmpty())
                    {
                        if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                "*"
                            ) || processHolder.contains(
                                "/"
                            )
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

                        mem5Value.value = mem5Holder
                    }
                }
            }
        }
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun mem6()
    {
        try
        {
            if (macroRecordIsClicked)
            {
                isClicked = true

                isClicked = false
                if (macroRecordIsClicked)
                {

                    if (macroSet == "1")
                    {

                        array1Holder.add("M6")
                        Log.e(
                            "array",
                            array1Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array1Holder.size.toString()
                        )


                    }
                    else if (macroSet == "2")
                    {

                        array2Holder.add("M6")
                        Log.e(
                            "array",
                            array2Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array2Holder.size.toString()
                        )

                    }
                    else if (macroSet == "3")
                    {

                        array3Holder.add("M6")
                        Log.e(
                            "array",
                            array3Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array3Holder.size.toString()
                        )

                    }
                    else if (macroSet == "4")
                    {

                        array4Holder.add("M6")
                        Log.e(
                            "array",
                            array4Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array4Holder.size.toString()
                        )

                    }
                    else if (macroSet == "5")
                    {

                        array5Holder.add("M6")
                        Log.e(
                            "array",
                            array5Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array5Holder.size.toString()
                        )

                    }
                    else if (macroSet == "6")
                    {

                        array6Holder.add("M6")
                        Log.e(
                            "array",
                            array6Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array6Holder.size.toString()
                        )

                    }
                    else if (macroSet == "7")
                    {

                        array7Holder.add("M6")
                        Log.e(
                            "array",
                            array7Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array7Holder.size.toString()
                        )

                    }
                    else if (macroSet == "8")
                    {

                        array8Holder.add("M6")
                        Log.e(
                            "array",
                            array8Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array8Holder.size.toString()
                        )

                    }
                    else if (macroSet == "9")
                    {

                        array9Holder.add("M6")
                        Log.e(
                            "array",
                            array9Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array9Holder.size.toString()
                        )
                    }
                }
            }
            else if (falsiMethodIsClicked)
            {
                if (memRecordIsClicked)
                {
                    mem6FalsiHolder.clear()

                    mem6FalsiHolder.add(falsiNum1Holder)
                    mem6FalsiHolder.add(x1)
                    mem6FalsiHolder.add(firstOperation)
                    mem6FalsiHolder.add(falsiNum2Holder)
                    mem6FalsiHolder.add(x2)
                    mem6FalsiHolder.add(secondOperation)
                    mem6FalsiHolder.add(falsiNum3Holder)

                    Log.e("message", mem6FalsiHolder.toString())
                    mem6Value.value =
                            mem6FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                                .replace(",", "")
                                .replace(" ", "")
                    mem6Holder = ""
                    memRecordIsClicked = false
                }

                if (mem6FalsiHolder.isNotEmpty() && !memRecordIsClicked)
                {
                    Log.e("message", mem6FalsiHolder.toString())
                    secondOperation = mem6FalsiHolder[5].toString()
                    falsiNum3Holder = mem6FalsiHolder[6].toString()
                    falsiNum1Holder = mem6FalsiHolder[0].toString()
                    x1 = mem6FalsiHolder[1].toString()
                    firstOperation = mem6FalsiHolder[2].toString()
                    falsiNum2Holder = mem6FalsiHolder[3].toString()
                    x2 = mem6FalsiHolder[4].toString()
                }
                else
                {

                    if (falsiNum1Holder.isEmpty())
                    {
                        falsiNum1Holder = mem6Holder.toString()
                        quadraticNum1Result.value = falsiNum1Holder
                    }
                    else if (firstOperation.isEmpty())
                    {
                        if (mem6Holder.toString()
                                .contains("-")
                        )
                        {

                            firstOperation = "-"
                            stringHolder = mem6Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation

                        }
                        else
                        {
                            firstOperation = "+"
                            stringHolder = mem6Holder
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation
                        }
                    }
                    else
                    {

                        if (mem6Holder.toString()
                                .contains("-")
                        )
                        {
                            secondOperation = "-"
                            stringHolder = mem6Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation

                        }
                        else
                        {
                            secondOperation = "+"
                            stringHolder = mem6Holder
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation
                        }
                    }
                }




                if (memCLearIsClicked)
                {
                    mem6FalsiHolder.clear()
                    mem6Value.value =
                            mem6FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                    memCLearIsClicked = false
                }

                quadraticNum1Result.value = falsiNum1Holder
                secondOperationResult.value = secondOperation
                quadraticNum2Result.value = falsiNum2Holder
                firstOperationResult.value = firstOperation
                x1Result.value = x1
                x2Result.value = x2
                quadraticNum3Result.value = falsiNum3Holder

            }
            else
            {

                memIsClickedCount += 1

                if (mem6Holder == "0")
                {

                    resultHolder = "0"
                }

                if (memCLearIsClicked)
                {
                    mem6Holder = ""
                    memCLearIsClicked = false
                }

                if (memRecordIsClicked)
                {
                    mem6Holder = ansHolder
                    memRecordIsClicked = false
                    mem6FalsiHolder.clear()
                    Log.e("message", mem6FalsiHolder.toString())
                    Log.e("message", mem6Holder.toString())
                }

                if (memIsClickedCount == 2)
                {
                    if (mem6FalsiHolder.isEmpty())
                    {
                        if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                "*"
                            ) || processHolder.contains(
                                "/"
                            )
                        )
                        {
                            processHolder += mem6Holder
                            proccessResult.value = processHolder

                        }
                        else if (processHolder == "")
                        {

                            processHolder = mem6Holder
                        }

                        if (resultHolder == "0")
                        {

                            resultHolder = "0"

                        }
                        result.value = resultHolder
                        proccessResult.value = processHolder
                        memIsClickedCount = 1

                        mem6Value.value = mem6Holder
                    }
                }
            }
        }
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun mem7()
    {
        try
        {
            if (macroRecordIsClicked)
            {
                isClicked = true

                isClicked = false
                if (macroRecordIsClicked)
                {

                    if (macroSet == "1")
                    {

                        array1Holder.add("M7")
                        Log.e(
                            "array",
                            array1Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array1Holder.size.toString()
                        )


                    }
                    else if (macroSet == "2")
                    {

                        array2Holder.add("M7")
                        Log.e(
                            "array",
                            array2Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array2Holder.size.toString()
                        )

                    }
                    else if (macroSet == "3")
                    {

                        array3Holder.add("M7")
                        Log.e(
                            "array",
                            array3Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array3Holder.size.toString()
                        )

                    }
                    else if (macroSet == "4")
                    {

                        array4Holder.add("M7")
                        Log.e(
                            "array",
                            array4Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array4Holder.size.toString()
                        )

                    }
                    else if (macroSet == "5")
                    {

                        array5Holder.add("M7")
                        Log.e(
                            "array",
                            array5Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array5Holder.size.toString()
                        )

                    }
                    else if (macroSet == "6")
                    {

                        array6Holder.add("M7")
                        Log.e(
                            "array",
                            array6Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array6Holder.size.toString()
                        )

                    }
                    else if (macroSet == "7")
                    {

                        array7Holder.add("M1")
                        Log.e(
                            "array",
                            array7Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array7Holder.size.toString()
                        )

                    }
                    else if (macroSet == "8")
                    {

                        array8Holder.add("M7")
                        Log.e(
                            "array",
                            array8Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array8Holder.size.toString()
                        )

                    }
                    else if (macroSet == "9")
                    {

                        array9Holder.add("M7")
                        Log.e(
                            "array",
                            array9Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array9Holder.size.toString()
                        )
                    }
                }
            }
            else if (falsiMethodIsClicked)
            {
                if (memRecordIsClicked)
                {
                    mem7FalsiHolder.clear()

                    mem7FalsiHolder.add(falsiNum1Holder)
                    mem7FalsiHolder.add(x1)
                    mem7FalsiHolder.add(firstOperation)
                    mem7FalsiHolder.add(falsiNum2Holder)
                    mem7FalsiHolder.add(x2)
                    mem7FalsiHolder.add(secondOperation)
                    mem7FalsiHolder.add(falsiNum3Holder)

                    Log.e("message", mem7FalsiHolder.toString())
                    mem7Value.value =
                            mem7FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                                .replace(",", "")
                                .replace(" ", "")
                    mem7Holder = ""
                    memRecordIsClicked = false
                }

                if (mem7FalsiHolder.isNotEmpty() && !memRecordIsClicked)
                {
                    Log.e("message", mem7FalsiHolder.toString())
                    secondOperation = mem7FalsiHolder[5].toString()
                    falsiNum3Holder = mem7FalsiHolder[6].toString()
                    falsiNum1Holder = mem7FalsiHolder[0].toString()
                    x1 = mem7FalsiHolder[1].toString()
                    firstOperation = mem7FalsiHolder[2].toString()
                    falsiNum2Holder = mem7FalsiHolder[3].toString()
                    x2 = mem7FalsiHolder[4].toString()
                }
                else
                {

                    if (falsiNum1Holder.isEmpty())
                    {
                        falsiNum1Holder = mem7Holder.toString()
                        quadraticNum1Result.value = falsiNum1Holder
                    }
                    else if (firstOperation.isEmpty())
                    {
                        if (mem7Holder.toString()
                                .contains("-")
                        )
                        {

                            firstOperation = "-"
                            stringHolder = mem7Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation

                        }
                        else
                        {
                            firstOperation = "+"
                            stringHolder = mem7Holder
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation
                        }
                    }
                    else
                    {

                        if (mem7Holder.toString()
                                .contains("-")
                        )
                        {
                            secondOperation = "-"
                            stringHolder = mem7Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation

                        }
                        else
                        {
                            secondOperation = "+"
                            stringHolder = mem7Holder
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation
                        }
                    }
                }




                if (memCLearIsClicked)
                {
                    mem7FalsiHolder.clear()
                    mem7Value.value =
                            mem7FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                    memCLearIsClicked = false
                }

                quadraticNum1Result.value = falsiNum1Holder
                secondOperationResult.value = secondOperation
                quadraticNum2Result.value = falsiNum2Holder
                firstOperationResult.value = firstOperation
                x1Result.value = x1
                x2Result.value = x2
                quadraticNum3Result.value = falsiNum3Holder

            }
            else
            {

                memIsClickedCount += 1

                if (mem7Holder == "0")
                {

                    resultHolder = "0"
                }

                if (memCLearIsClicked)
                {
                    mem7Holder = ""
                    memCLearIsClicked = false
                }

                if (memRecordIsClicked)
                {
                    mem7Holder = ansHolder
                    memRecordIsClicked = false
                    mem7FalsiHolder.clear()
                    Log.e("message", mem7FalsiHolder.toString())
                    Log.e("message", mem7Holder.toString())
                }

                if (memIsClickedCount == 2)
                {
                    if (mem7FalsiHolder.isEmpty())
                    {
                        if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                "*"
                            ) || processHolder.contains(
                                "/"
                            )
                        )
                        {
                            processHolder += mem7Holder
                            proccessResult.value = processHolder

                        }
                        else if (processHolder == "")
                        {

                            processHolder = mem7Holder
                        }

                        if (resultHolder == "0")
                        {

                            resultHolder = "0"

                        }
                        result.value = resultHolder
                        proccessResult.value = processHolder
                        memIsClickedCount = 1

                        mem7Value.value = mem7Holder
                    }
                }
            }
        }
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun mem8()
    {
        try
        {
            if (macroRecordIsClicked)
            {
                isClicked = true

                isClicked = false
                if (macroRecordIsClicked)
                {

                    if (macroSet == "1")
                    {

                        array1Holder.add("M8")
                        Log.e(
                            "array",
                            array1Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array1Holder.size.toString()
                        )


                    }
                    else if (macroSet == "2")
                    {

                        array2Holder.add("M8")
                        Log.e(
                            "array",
                            array2Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array2Holder.size.toString()
                        )

                    }
                    else if (macroSet == "3")
                    {

                        array3Holder.add("M8")
                        Log.e(
                            "array",
                            array3Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array3Holder.size.toString()
                        )

                    }
                    else if (macroSet == "4")
                    {

                        array4Holder.add("M8")
                        Log.e(
                            "array",
                            array4Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array4Holder.size.toString()
                        )

                    }
                    else if (macroSet == "5")
                    {

                        array5Holder.add("M8")
                        Log.e(
                            "array",
                            array5Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array5Holder.size.toString()
                        )

                    }
                    else if (macroSet == "6")
                    {

                        array6Holder.add("M8")
                        Log.e(
                            "array",
                            array6Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array6Holder.size.toString()
                        )

                    }
                    else if (macroSet == "7")
                    {

                        array7Holder.add("M8")
                        Log.e(
                            "array",
                            array7Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array7Holder.size.toString()
                        )

                    }
                    else if (macroSet == "8")
                    {

                        array8Holder.add("M8")
                        Log.e(
                            "array",
                            array8Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array8Holder.size.toString()
                        )

                    }
                    else if (macroSet == "9")
                    {

                        array9Holder.add("M8")
                        Log.e(
                            "array",
                            array9Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array9Holder.size.toString()
                        )
                    }
                }
            }
            else if (falsiMethodIsClicked)
            {
                if (memRecordIsClicked)
                {
                    mem8FalsiHolder.clear()

                    mem8FalsiHolder.add(falsiNum1Holder)
                    mem8FalsiHolder.add(x1)
                    mem8FalsiHolder.add(firstOperation)
                    mem8FalsiHolder.add(falsiNum2Holder)
                    mem8FalsiHolder.add(x2)
                    mem8FalsiHolder.add(secondOperation)
                    mem8FalsiHolder.add(falsiNum3Holder)

                    Log.e("message", mem8FalsiHolder.toString())
                    mem8Value.value =
                            mem8FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                                .replace(",", "")
                                .replace(" ", "")
                    mem8Holder = ""
                    memRecordIsClicked = false
                }

                if (mem8FalsiHolder.isNotEmpty() && !memRecordIsClicked)
                {
                    Log.e("message", mem8FalsiHolder.toString())
                    secondOperation = mem8FalsiHolder[5].toString()
                    falsiNum3Holder = mem8FalsiHolder[6].toString()
                    falsiNum1Holder = mem8FalsiHolder[0].toString()
                    x1 = mem8FalsiHolder[1].toString()
                    firstOperation = mem8FalsiHolder[2].toString()
                    falsiNum2Holder = mem8FalsiHolder[3].toString()
                    x2 = mem8FalsiHolder[4].toString()
                }
                else
                {

                    if (falsiNum1Holder.isEmpty())
                    {
                        falsiNum1Holder = mem8Holder.toString()
                        quadraticNum1Result.value = falsiNum1Holder
                    }
                    else if (firstOperation.isEmpty())
                    {
                        if (mem8Holder.toString()
                                .contains("-")
                        )
                        {

                            firstOperation = "-"
                            stringHolder = mem8Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation

                        }
                        else
                        {
                            firstOperation = "+"
                            stringHolder = mem8Holder
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation
                        }
                    }
                    else
                    {

                        if (mem8Holder.toString()
                                .contains("-")
                        )
                        {
                            secondOperation = "-"
                            stringHolder = mem8Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation

                        }
                        else
                        {
                            secondOperation = "+"
                            stringHolder = mem8Holder
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation
                        }
                    }
                }




                if (memCLearIsClicked)
                {
                    mem8FalsiHolder.clear()
                    mem8Value.value =
                            mem8FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                    memCLearIsClicked = false
                }

                quadraticNum1Result.value = falsiNum1Holder
                secondOperationResult.value = secondOperation
                quadraticNum2Result.value = falsiNum2Holder
                firstOperationResult.value = firstOperation
                x1Result.value = x1
                x2Result.value = x2
                quadraticNum3Result.value = falsiNum3Holder

            }
            else
            {

                memIsClickedCount += 1

                if (mem8Holder == "0")
                {

                    resultHolder = "0"
                }

                if (memCLearIsClicked)
                {
                    mem8Holder = ""
                    memCLearIsClicked = false
                }

                if (memRecordIsClicked)
                {
                    mem8Holder = ansHolder
                    memRecordIsClicked = false
                    mem8FalsiHolder.clear()
                    Log.e("message", mem8FalsiHolder.toString())
                    Log.e("message", mem8Holder.toString())
                }

                if (memIsClickedCount == 2)
                {
                    if (mem8FalsiHolder.isEmpty())
                    {
                        if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                "*"
                            ) || processHolder.contains(
                                "/"
                            )
                        )
                        {
                            processHolder += mem8Holder
                            proccessResult.value = processHolder

                        }
                        else if (processHolder == "")
                        {

                            processHolder = mem8Holder
                        }

                        if (resultHolder == "0")
                        {

                            resultHolder = "0"

                        }
                        result.value = resultHolder
                        proccessResult.value = processHolder
                        memIsClickedCount = 1

                        mem8Value.value = mem8Holder
                    }
                }
            }
        }
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun mem9()
    {
        try
        {
            if (macroRecordIsClicked)
            {
                isClicked = true

                isClicked = false
                if (macroRecordIsClicked)
                {

                    if (macroSet == "1")
                    {

                        array1Holder.add("M9")
                        Log.e(
                            "array",
                            array1Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array1Holder.size.toString()
                        )


                    }
                    else if (macroSet == "2")
                    {

                        array2Holder.add("M9")
                        Log.e(
                            "array",
                            array2Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array2Holder.size.toString()
                        )

                    }
                    else if (macroSet == "3")
                    {

                        array3Holder.add("M9")
                        Log.e(
                            "array",
                            array3Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array3Holder.size.toString()
                        )

                    }
                    else if (macroSet == "4")
                    {

                        array4Holder.add("M9")
                        Log.e(
                            "array",
                            array4Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array4Holder.size.toString()
                        )

                    }
                    else if (macroSet == "5")
                    {

                        array5Holder.add("M9")
                        Log.e(
                            "array",
                            array5Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array5Holder.size.toString()
                        )

                    }
                    else if (macroSet == "6")
                    {

                        array6Holder.add("M9")
                        Log.e(
                            "array",
                            array6Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array6Holder.size.toString()
                        )

                    }
                    else if (macroSet == "7")
                    {

                        array7Holder.add("M9")
                        Log.e(
                            "array",
                            array7Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array7Holder.size.toString()
                        )

                    }
                    else if (macroSet == "8")
                    {

                        array8Holder.add("M9")
                        Log.e(
                            "array",
                            array8Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array8Holder.size.toString()
                        )

                    }
                    else if (macroSet == "9")
                    {

                        array9Holder.add("M9")
                        Log.e(
                            "array",
                            array9Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array9Holder.size.toString()
                        )
                    }
                }
            }
            else if (falsiMethodIsClicked)
            {
                if (memRecordIsClicked)
                {
                    mem9FalsiHolder.clear()

                    mem9FalsiHolder.add(falsiNum1Holder)
                    mem9FalsiHolder.add(x1)
                    mem9FalsiHolder.add(firstOperation)
                    mem9FalsiHolder.add(falsiNum2Holder)
                    mem9FalsiHolder.add(x2)
                    mem9FalsiHolder.add(secondOperation)
                    mem9FalsiHolder.add(falsiNum3Holder)

                    Log.e("message", mem9FalsiHolder.toString())
                    mem9Value.value =
                            mem9FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                                .replace(",", "")
                                .replace(" ", "")
                    mem9Holder = ""
                    memRecordIsClicked = false
                }

                if (mem9FalsiHolder.isNotEmpty() && !memRecordIsClicked)
                {
                    Log.e("message", mem9FalsiHolder.toString())
                    secondOperation = mem9FalsiHolder[5].toString()
                    falsiNum3Holder = mem9FalsiHolder[6].toString()
                    falsiNum1Holder = mem9FalsiHolder[0].toString()
                    x1 = mem9FalsiHolder[1].toString()
                    firstOperation = mem9FalsiHolder[2].toString()
                    falsiNum2Holder = mem9FalsiHolder[3].toString()
                    x2 = mem9FalsiHolder[4].toString()
                }
                else
                {

                    if (falsiNum1Holder.isEmpty())
                    {
                        falsiNum1Holder = mem9Holder.toString()
                        quadraticNum1Result.value = falsiNum1Holder
                    }
                    else if (firstOperation.isEmpty())
                    {
                        if (mem9Holder.toString()
                                .contains("-")
                        )
                        {

                            firstOperation = "-"
                            stringHolder = mem9Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation

                        }
                        else
                        {
                            firstOperation = "+"
                            stringHolder = mem9Holder
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation
                        }
                    }
                    else
                    {

                        if (mem9Holder.toString()
                                .contains("-")
                        )
                        {
                            secondOperation = "-"
                            stringHolder = mem9Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation

                        }
                        else
                        {
                            secondOperation = "+"
                            stringHolder = mem9Holder
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation
                        }
                    }
                }




                if (memCLearIsClicked)
                {
                    mem9FalsiHolder.clear()
                    mem9Value.value =
                            mem9FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                    memCLearIsClicked = false
                }

                quadraticNum1Result.value = falsiNum1Holder
                secondOperationResult.value = secondOperation
                quadraticNum2Result.value = falsiNum2Holder
                firstOperationResult.value = firstOperation
                x1Result.value = x1
                x2Result.value = x2
                quadraticNum3Result.value = falsiNum3Holder

            }
            else
            {

                memIsClickedCount += 1

                if (mem9Holder == "0")
                {

                    resultHolder = "0"
                }

                if (memCLearIsClicked)
                {
                    mem9Holder = ""
                    memCLearIsClicked = false
                }

                if (memRecordIsClicked)
                {
                    mem9Holder = ansHolder
                    memRecordIsClicked = false
                    mem9FalsiHolder.clear()
                    Log.e("message", mem9FalsiHolder.toString())
                    Log.e("message", mem9Holder.toString())
                }

                if (memIsClickedCount == 2)
                {
                    if (mem9FalsiHolder.isEmpty())
                    {
                        if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                "*"
                            ) || processHolder.contains(
                                "/"
                            )
                        )
                        {
                            processHolder += mem9Holder
                            proccessResult.value = processHolder

                        }
                        else if (processHolder == "")
                        {

                            processHolder = mem9Holder
                        }

                        if (resultHolder == "0")
                        {

                            resultHolder = "0"

                        }
                        result.value = resultHolder
                        proccessResult.value = processHolder
                        memIsClickedCount = 1

                        mem9Value.value = mem9Holder
                    }
                }
            }
        }
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun mem10()
    {
        try
        {
            if (macroRecordIsClicked)
            {
                isClicked = true

                isClicked = false
                if (macroRecordIsClicked)
                {

                    if (macroSet == "1")
                    {

                        array1Holder.add("M10")
                        Log.e(
                            "array",
                            array1Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array1Holder.size.toString()
                        )


                    }
                    else if (macroSet == "2")
                    {

                        array2Holder.add("M10")
                        Log.e(
                            "array",
                            array2Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array2Holder.size.toString()
                        )

                    }
                    else if (macroSet == "3")
                    {

                        array3Holder.add("M10")
                        Log.e(
                            "array",
                            array3Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array3Holder.size.toString()
                        )

                    }
                    else if (macroSet == "4")
                    {

                        array4Holder.add("M10")
                        Log.e(
                            "array",
                            array4Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array4Holder.size.toString()
                        )

                    }
                    else if (macroSet == "5")
                    {

                        array5Holder.add("M10")
                        Log.e(
                            "array",
                            array5Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array5Holder.size.toString()
                        )

                    }
                    else if (macroSet == "6")
                    {

                        array6Holder.add("M10")
                        Log.e(
                            "array",
                            array6Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array6Holder.size.toString()
                        )

                    }
                    else if (macroSet == "7")
                    {

                        array7Holder.add("M10")
                        Log.e(
                            "array",
                            array7Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array7Holder.size.toString()
                        )

                    }
                    else if (macroSet == "8")
                    {

                        array8Holder.add("M10")
                        Log.e(
                            "array",
                            array8Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array8Holder.size.toString()
                        )

                    }
                    else if (macroSet == "9")
                    {

                        array9Holder.add("M10")
                        Log.e(
                            "array",
                            array9Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array9Holder.size.toString()
                        )
                    }
                }
            }
            else if (falsiMethodIsClicked)
            {
                if (memRecordIsClicked)
                {
                    mem10FalsiHolder.clear()

                    mem10FalsiHolder.add(falsiNum1Holder)
                    mem10FalsiHolder.add(x1)
                    mem10FalsiHolder.add(firstOperation)
                    mem10FalsiHolder.add(falsiNum2Holder)
                    mem10FalsiHolder.add(x2)
                    mem10FalsiHolder.add(secondOperation)
                    mem10FalsiHolder.add(falsiNum3Holder)

                    Log.e("message", mem10FalsiHolder.toString())
                    mem10Value.value =
                            mem10FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                                .replace(",", "")
                                .replace(" ", "")
                    mem10Holder = ""
                    memRecordIsClicked = false
                }

                if (mem10FalsiHolder.isNotEmpty() && !memRecordIsClicked)
                {
                    Log.e("message", mem10FalsiHolder.toString())
                    secondOperation = mem10FalsiHolder[5].toString()
                    falsiNum3Holder = mem10FalsiHolder[6].toString()
                    falsiNum1Holder = mem10FalsiHolder[0].toString()
                    x1 = mem10FalsiHolder[1].toString()
                    firstOperation = mem10FalsiHolder[2].toString()
                    falsiNum2Holder = mem10FalsiHolder[3].toString()
                    x2 = mem10FalsiHolder[4].toString()
                }
                else
                {

                    if (falsiNum1Holder.isEmpty())
                    {
                        falsiNum1Holder = mem10Holder.toString()
                        quadraticNum1Result.value = falsiNum1Holder
                    }
                    else if (firstOperation.isEmpty())
                    {
                        if (mem10Holder.toString()
                                .contains("-")
                        )
                        {

                            firstOperation = "-"
                            stringHolder = mem10Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation

                        }
                        else
                        {
                            firstOperation = "+"
                            stringHolder = mem10Holder
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation
                        }
                    }
                    else
                    {

                        if (mem10Holder.toString()
                                .contains("-")
                        )
                        {
                            secondOperation = "-"
                            stringHolder = mem10Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation

                        }
                        else
                        {
                            secondOperation = "+"
                            stringHolder = mem10Holder
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation
                        }
                    }
                }




                if (memCLearIsClicked)
                {
                    mem10FalsiHolder.clear()
                    mem10Value.value =
                            mem10FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                    memCLearIsClicked = false
                }

                quadraticNum1Result.value = falsiNum1Holder
                secondOperationResult.value = secondOperation
                quadraticNum2Result.value = falsiNum2Holder
                firstOperationResult.value = firstOperation
                x1Result.value = x1
                x2Result.value = x2
                quadraticNum3Result.value = falsiNum3Holder

            }
            else
            {

                memIsClickedCount += 1

                if (mem10Holder == "0")
                {

                    resultHolder = "0"
                }

                if (memCLearIsClicked)
                {
                    mem10Holder = ""
                    memCLearIsClicked = false
                }

                if (memRecordIsClicked)
                {
                    mem10Holder = ansHolder
                    memRecordIsClicked = false
                    mem10FalsiHolder.clear()
                    Log.e("message", mem10FalsiHolder.toString())
                    Log.e("message", mem10Holder.toString())
                }

                if (memIsClickedCount == 2)
                {
                    if (mem10FalsiHolder.isEmpty())
                    {
                        if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                "*"
                            ) || processHolder.contains(
                                "/"
                            )
                        )
                        {
                            processHolder += mem10Holder
                            proccessResult.value = processHolder

                        }
                        else if (processHolder == "")
                        {

                            processHolder = mem10Holder
                        }

                        if (resultHolder == "0")
                        {

                            resultHolder = "0"

                        }
                        result.value = resultHolder
                        proccessResult.value = processHolder
                        memIsClickedCount = 1

                        mem10Value.value = mem10Holder
                    }
                }
            }
        }
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun mem11()
    {
        try
        {
            if (macroRecordIsClicked)
            {
                isClicked = true

                isClicked = false
                if (macroRecordIsClicked)
                {

                    if (macroSet == "1")
                    {

                        array1Holder.add("M11")
                        Log.e(
                            "array",
                            array1Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array1Holder.size.toString()
                        )


                    }
                    else if (macroSet == "2")
                    {

                        array2Holder.add("M11")
                        Log.e(
                            "array",
                            array2Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array2Holder.size.toString()
                        )

                    }
                    else if (macroSet == "3")
                    {

                        array3Holder.add("M11")
                        Log.e(
                            "array",
                            array3Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array3Holder.size.toString()
                        )

                    }
                    else if (macroSet == "4")
                    {

                        array4Holder.add("M11")
                        Log.e(
                            "array",
                            array4Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array4Holder.size.toString()
                        )

                    }
                    else if (macroSet == "5")
                    {

                        array5Holder.add("M11")
                        Log.e(
                            "array",
                            array5Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array5Holder.size.toString()
                        )

                    }
                    else if (macroSet == "6")
                    {

                        array6Holder.add("M11")
                        Log.e(
                            "array",
                            array6Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array6Holder.size.toString()
                        )

                    }
                    else if (macroSet == "7")
                    {

                        array7Holder.add("M11")
                        Log.e(
                            "array",
                            array7Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array7Holder.size.toString()
                        )

                    }
                    else if (macroSet == "8")
                    {

                        array8Holder.add("M11")
                        Log.e(
                            "array",
                            array8Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array8Holder.size.toString()
                        )

                    }
                    else if (macroSet == "9")
                    {

                        array9Holder.add("M11")
                        Log.e(
                            "array",
                            array9Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array9Holder.size.toString()
                        )
                    }
                }
            }
            else if (falsiMethodIsClicked)
            {
                if (memRecordIsClicked)
                {
                    mem11FalsiHolder.clear()

                    mem11FalsiHolder.add(falsiNum1Holder)
                    mem11FalsiHolder.add(x1)
                    mem11FalsiHolder.add(firstOperation)
                    mem11FalsiHolder.add(falsiNum2Holder)
                    mem11FalsiHolder.add(x2)
                    mem11FalsiHolder.add(secondOperation)
                    mem11FalsiHolder.add(falsiNum3Holder)

                    Log.e("message", mem11FalsiHolder.toString())
                    mem11Value.value =
                            mem11FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                                .replace(",", "")
                                .replace(" ", "")
                    mem11Holder = ""
                    memRecordIsClicked = false
                }

                if (mem11FalsiHolder.isNotEmpty() && !memRecordIsClicked)
                {
                    Log.e("message", mem11FalsiHolder.toString())
                    secondOperation = mem11FalsiHolder[5].toString()
                    falsiNum3Holder = mem11FalsiHolder[6].toString()
                    falsiNum1Holder = mem11FalsiHolder[0].toString()
                    x1 = mem11FalsiHolder[1].toString()
                    firstOperation = mem11FalsiHolder[2].toString()
                    falsiNum2Holder = mem11FalsiHolder[3].toString()
                    x2 = mem11FalsiHolder[4].toString()
                }
                else
                {

                    if (falsiNum1Holder.isEmpty())
                    {
                        falsiNum1Holder = mem11Holder.toString()
                        quadraticNum1Result.value = falsiNum1Holder
                    }
                    else if (firstOperation.isEmpty())
                    {
                        if (mem11Holder.toString()
                                .contains("-")
                        )
                        {

                            firstOperation = "-"
                            stringHolder = mem11Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation

                        }
                        else
                        {
                            firstOperation = "+"
                            stringHolder = mem11Holder
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation
                        }
                    }
                    else
                    {

                        if (mem11Holder.toString()
                                .contains("-")
                        )
                        {
                            secondOperation = "-"
                            stringHolder = mem11Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation

                        }
                        else
                        {
                            secondOperation = "+"
                            stringHolder = mem11Holder
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation
                        }
                    }
                }




                if (memCLearIsClicked)
                {
                    mem11FalsiHolder.clear()
                    mem11Value.value =
                            mem11FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                    memCLearIsClicked = false
                }

                quadraticNum1Result.value = falsiNum1Holder
                secondOperationResult.value = secondOperation
                quadraticNum2Result.value = falsiNum2Holder
                firstOperationResult.value = firstOperation
                x1Result.value = x1
                x2Result.value = x2
                quadraticNum3Result.value = falsiNum3Holder

            }
            else
            {

                memIsClickedCount += 1

                if (mem11Holder == "0")
                {

                    resultHolder = "0"
                }

                if (memCLearIsClicked)
                {
                    mem11Holder = ""
                    memCLearIsClicked = false
                }

                if (memRecordIsClicked)
                {
                    mem11Holder = ansHolder
                    memRecordIsClicked = false
                    mem11FalsiHolder.clear()
                    Log.e("message", mem11FalsiHolder.toString())
                    Log.e("message", mem11Holder.toString())
                }

                if (memIsClickedCount == 2)
                {
                    if (mem11FalsiHolder.isEmpty())
                    {
                        if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                "*"
                            ) || processHolder.contains(
                                "/"
                            )
                        )
                        {
                            processHolder += mem11Holder
                            proccessResult.value = processHolder

                        }
                        else if (processHolder == "")
                        {

                            processHolder = mem11Holder
                        }

                        if (resultHolder == "0")
                        {

                            resultHolder = "0"

                        }
                        result.value = resultHolder
                        proccessResult.value = processHolder
                        memIsClickedCount = 1

                        mem11Value.value = mem11Holder
                    }
                }
            }
        }
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun mem12()
    {
        try
        {
            if (macroRecordIsClicked)
            {
                isClicked = true

                isClicked = false
                if (macroRecordIsClicked)
                {

                    if (macroSet == "1")
                    {

                        array1Holder.add("M12")
                        Log.e(
                            "array",
                            array1Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array1Holder.size.toString()
                        )


                    }
                    else if (macroSet == "2")
                    {

                        array2Holder.add("M12")
                        Log.e(
                            "array",
                            array2Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array2Holder.size.toString()
                        )

                    }
                    else if (macroSet == "3")
                    {

                        array3Holder.add("M12")
                        Log.e(
                            "array",
                            array3Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array3Holder.size.toString()
                        )

                    }
                    else if (macroSet == "4")
                    {

                        array4Holder.add("M12")
                        Log.e(
                            "array",
                            array4Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array4Holder.size.toString()
                        )

                    }
                    else if (macroSet == "5")
                    {

                        array5Holder.add("M12")
                        Log.e(
                            "array",
                            array5Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array5Holder.size.toString()
                        )

                    }
                    else if (macroSet == "6")
                    {

                        array6Holder.add("M12")
                        Log.e(
                            "array",
                            array6Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array6Holder.size.toString()
                        )

                    }
                    else if (macroSet == "7")
                    {

                        array7Holder.add("M12")
                        Log.e(
                            "array",
                            array7Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array7Holder.size.toString()
                        )

                    }
                    else if (macroSet == "8")
                    {

                        array8Holder.add("M12")
                        Log.e(
                            "array",
                            array8Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array8Holder.size.toString()
                        )

                    }
                    else if (macroSet == "9")
                    {

                        array9Holder.add("M12")
                        Log.e(
                            "array",
                            array9Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array9Holder.size.toString()
                        )
                    }
                }
            }
            else if (falsiMethodIsClicked)
            {
                if (memRecordIsClicked)
                {
                    mem12FalsiHolder.clear()

                    mem12FalsiHolder.add(falsiNum1Holder)
                    mem12FalsiHolder.add(x1)
                    mem12FalsiHolder.add(firstOperation)
                    mem12FalsiHolder.add(falsiNum2Holder)
                    mem12FalsiHolder.add(x2)
                    mem12FalsiHolder.add(secondOperation)
                    mem12FalsiHolder.add(falsiNum3Holder)

                    Log.e("message", mem12FalsiHolder.toString())
                    mem12Value.value =
                            mem12FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                                .replace(",", "")
                                .replace(" ", "")
                    mem12Holder = ""
                    memRecordIsClicked = false
                }

                if (mem12FalsiHolder.isNotEmpty() && !memRecordIsClicked)
                {
                    Log.e("message", mem12FalsiHolder.toString())
                    secondOperation = mem12FalsiHolder[5].toString()
                    falsiNum3Holder = mem12FalsiHolder[6].toString()
                    falsiNum1Holder = mem12FalsiHolder[0].toString()
                    x1 = mem12FalsiHolder[1].toString()
                    firstOperation = mem12FalsiHolder[2].toString()
                    falsiNum2Holder = mem12FalsiHolder[3].toString()
                    x2 = mem12FalsiHolder[4].toString()
                }
                else
                {

                    if (falsiNum1Holder.isEmpty())
                    {
                        falsiNum1Holder = mem12Holder.toString()
                        quadraticNum1Result.value = falsiNum1Holder
                    }
                    else if (firstOperation.isEmpty())
                    {
                        if (mem12Holder.toString()
                                .contains("-")
                        )
                        {

                            firstOperation = "-"
                            stringHolder = mem12Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation

                        }
                        else
                        {
                            firstOperation = "+"
                            stringHolder = mem12Holder
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation
                        }
                    }
                    else
                    {

                        if (mem12Holder.toString()
                                .contains("-")
                        )
                        {
                            secondOperation = "-"
                            stringHolder = mem12Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation

                        }
                        else
                        {
                            secondOperation = "+"
                            stringHolder = mem12Holder
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation
                        }
                    }
                }




                if (memCLearIsClicked)
                {
                    mem12FalsiHolder.clear()
                    mem12Value.value =
                            mem12FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                    memCLearIsClicked = false
                }

                quadraticNum1Result.value = falsiNum1Holder
                secondOperationResult.value = secondOperation
                quadraticNum2Result.value = falsiNum2Holder
                firstOperationResult.value = firstOperation
                x1Result.value = x1
                x2Result.value = x2
                quadraticNum3Result.value = falsiNum3Holder

            }
            else
            {

                memIsClickedCount += 1

                if (mem12Holder == "0")
                {

                    resultHolder = "0"
                }

                if (memCLearIsClicked)
                {
                    mem12Holder = ""
                    memCLearIsClicked = false
                }

                if (memRecordIsClicked)
                {
                    mem12Holder = ansHolder
                    memRecordIsClicked = false
                    mem12FalsiHolder.clear()
                    Log.e("message", mem12FalsiHolder.toString())
                    Log.e("message", mem12Holder.toString())
                }

                if (memIsClickedCount == 2)
                {
                    if (mem12FalsiHolder.isEmpty())
                    {
                        if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                "*"
                            ) || processHolder.contains(
                                "/"
                            )
                        )
                        {
                            processHolder += mem12Holder
                            proccessResult.value = processHolder

                        }
                        else if (processHolder == "")
                        {

                            processHolder = mem12Holder
                        }

                        if (resultHolder == "0")
                        {

                            resultHolder = "0"

                        }
                        result.value = resultHolder
                        proccessResult.value = processHolder
                        memIsClickedCount = 1

                        mem2Value.value = mem12Holder
                    }
                }
            }
        }
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun mem13()
    {
        try
        {
            if (macroRecordIsClicked)
            {
                isClicked = true

                isClicked = false
                if (macroRecordIsClicked)
                {

                    if (macroSet == "1")
                    {

                        array1Holder.add("M13")
                        Log.e(
                            "array",
                            array1Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array1Holder.size.toString()
                        )


                    }
                    else if (macroSet == "2")
                    {

                        array2Holder.add("M13")
                        Log.e(
                            "array",
                            array2Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array2Holder.size.toString()
                        )

                    }
                    else if (macroSet == "3")
                    {

                        array3Holder.add("M13")
                        Log.e(
                            "array",
                            array3Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array3Holder.size.toString()
                        )

                    }
                    else if (macroSet == "4")
                    {

                        array4Holder.add("M13")
                        Log.e(
                            "array",
                            array4Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array4Holder.size.toString()
                        )

                    }
                    else if (macroSet == "5")
                    {

                        array5Holder.add("M13")
                        Log.e(
                            "array",
                            array5Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array5Holder.size.toString()
                        )

                    }
                    else if (macroSet == "6")
                    {

                        array6Holder.add("M13")
                        Log.e(
                            "array",
                            array6Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array6Holder.size.toString()
                        )

                    }
                    else if (macroSet == "7")
                    {

                        array7Holder.add("M13")
                        Log.e(
                            "array",
                            array7Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array7Holder.size.toString()
                        )

                    }
                    else if (macroSet == "8")
                    {

                        array8Holder.add("M13")
                        Log.e(
                            "array",
                            array8Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array8Holder.size.toString()
                        )

                    }
                    else if (macroSet == "9")
                    {

                        array9Holder.add("M13")
                        Log.e(
                            "array",
                            array9Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array9Holder.size.toString()
                        )
                    }
                }
            }
            else if (falsiMethodIsClicked)
            {
                if (memRecordIsClicked)
                {
                    mem13FalsiHolder.clear()

                    mem13FalsiHolder.add(falsiNum1Holder)
                    mem13FalsiHolder.add(x1)
                    mem13FalsiHolder.add(firstOperation)
                    mem13FalsiHolder.add(falsiNum2Holder)
                    mem13FalsiHolder.add(x2)
                    mem13FalsiHolder.add(secondOperation)
                    mem13FalsiHolder.add(falsiNum3Holder)

                    Log.e("message", mem13FalsiHolder.toString())
                    mem13Value.value =
                            mem13FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                                .replace(",", "")
                                .replace(" ", "")
                    mem13Holder = ""
                    memRecordIsClicked = false
                }

                if (mem13FalsiHolder.isNotEmpty() && !memRecordIsClicked)
                {
                    Log.e("message", mem13FalsiHolder.toString())
                    secondOperation = mem13FalsiHolder[5].toString()
                    falsiNum3Holder = mem13FalsiHolder[6].toString()
                    falsiNum1Holder = mem13FalsiHolder[0].toString()
                    x1 = mem13FalsiHolder[1].toString()
                    firstOperation = mem13FalsiHolder[2].toString()
                    falsiNum2Holder = mem13FalsiHolder[3].toString()
                    x2 = mem13FalsiHolder[4].toString()
                }
                else
                {

                    if (falsiNum1Holder.isEmpty())
                    {
                        falsiNum1Holder = mem13Holder.toString()
                        quadraticNum1Result.value = falsiNum1Holder
                    }
                    else if (firstOperation.isEmpty())
                    {
                        if (mem13Holder.toString()
                                .contains("-")
                        )
                        {

                            firstOperation = "-"
                            stringHolder = mem13Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation

                        }
                        else
                        {
                            firstOperation = "+"
                            stringHolder = mem13Holder
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation
                        }
                    }
                    else
                    {

                        if (mem13Holder.toString()
                                .contains("-")
                        )
                        {
                            secondOperation = "-"
                            stringHolder = mem13Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation

                        }
                        else
                        {
                            secondOperation = "+"
                            stringHolder = mem13Holder
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation
                        }
                    }
                }




                if (memCLearIsClicked)
                {
                    mem13FalsiHolder.clear()
                    mem13Value.value =
                            mem13FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                    memCLearIsClicked = false
                }

                quadraticNum1Result.value = falsiNum1Holder
                secondOperationResult.value = secondOperation
                quadraticNum2Result.value = falsiNum2Holder
                firstOperationResult.value = firstOperation
                x1Result.value = x1
                x2Result.value = x2
                quadraticNum3Result.value = falsiNum3Holder

            }
            else
            {

                memIsClickedCount += 1

                if (mem13Holder == "0")
                {

                    resultHolder = "0"
                }

                if (memCLearIsClicked)
                {
                    mem13Holder = ""
                    memCLearIsClicked = false
                }

                if (memRecordIsClicked)
                {
                    mem13Holder = ansHolder
                    memRecordIsClicked = false
                    mem13FalsiHolder.clear()
                    Log.e("message", mem13FalsiHolder.toString())
                    Log.e("message", mem13Holder.toString())
                }

                if (memIsClickedCount == 2)
                {
                    if (mem13FalsiHolder.isEmpty())
                    {
                        if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                "*"
                            ) || processHolder.contains(
                                "/"
                            )
                        )
                        {
                            processHolder += mem13Holder
                            proccessResult.value = processHolder

                        }
                        else if (processHolder == "")
                        {

                            processHolder = mem13Holder
                        }

                        if (resultHolder == "0")
                        {

                            resultHolder = "0"

                        }
                        result.value = resultHolder
                        proccessResult.value = processHolder
                        memIsClickedCount = 1

                        mem13Value.value = mem13Holder
                    }
                }
            }
        }
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun mem14()
    {
        try
        {
            if (macroRecordIsClicked)
            {
                isClicked = true

                isClicked = false
                if (macroRecordIsClicked)
                {

                    if (macroSet == "1")
                    {

                        array1Holder.add("M14")
                        Log.e(
                            "array",
                            array1Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array1Holder.size.toString()
                        )


                    }
                    else if (macroSet == "2")
                    {

                        array2Holder.add("M14")
                        Log.e(
                            "array",
                            array2Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array2Holder.size.toString()
                        )

                    }
                    else if (macroSet == "3")
                    {

                        array3Holder.add("M14")
                        Log.e(
                            "array",
                            array3Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array3Holder.size.toString()
                        )

                    }
                    else if (macroSet == "4")
                    {

                        array4Holder.add("M14")
                        Log.e(
                            "array",
                            array4Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array4Holder.size.toString()
                        )

                    }
                    else if (macroSet == "5")
                    {

                        array5Holder.add("M14")
                        Log.e(
                            "array",
                            array5Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array5Holder.size.toString()
                        )

                    }
                    else if (macroSet == "6")
                    {

                        array6Holder.add("M14")
                        Log.e(
                            "array",
                            array6Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array6Holder.size.toString()
                        )

                    }
                    else if (macroSet == "7")
                    {

                        array7Holder.add("M14")
                        Log.e(
                            "array",
                            array7Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array7Holder.size.toString()
                        )

                    }
                    else if (macroSet == "8")
                    {

                        array8Holder.add("M14")
                        Log.e(
                            "array",
                            array8Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array8Holder.size.toString()
                        )

                    }
                    else if (macroSet == "9")
                    {

                        array9Holder.add("M14")
                        Log.e(
                            "array",
                            array9Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array9Holder.size.toString()
                        )
                    }
                }
            }
            else if (falsiMethodIsClicked)
            {
                if (memRecordIsClicked)
                {
                    mem14FalsiHolder.clear()

                    mem14FalsiHolder.add(falsiNum1Holder)
                    mem14FalsiHolder.add(x1)
                    mem14FalsiHolder.add(firstOperation)
                    mem14FalsiHolder.add(falsiNum2Holder)
                    mem14FalsiHolder.add(x2)
                    mem14FalsiHolder.add(secondOperation)
                    mem14FalsiHolder.add(falsiNum3Holder)

                    Log.e("message", mem14FalsiHolder.toString())
                    mem14Value.value =
                            mem14FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                                .replace(",", "")
                                .replace(" ", "")
                    mem14Holder = ""
                    memRecordIsClicked = false
                }

                if (mem14FalsiHolder.isNotEmpty() && !memRecordIsClicked)
                {
                    Log.e("message", mem14FalsiHolder.toString())
                    secondOperation = mem14FalsiHolder[5].toString()
                    falsiNum3Holder = mem14FalsiHolder[6].toString()
                    falsiNum1Holder = mem14FalsiHolder[0].toString()
                    x1 = mem14FalsiHolder[1].toString()
                    firstOperation = mem14FalsiHolder[2].toString()
                    falsiNum2Holder = mem14FalsiHolder[3].toString()
                    x2 = mem14FalsiHolder[4].toString()
                }
                else
                {

                    if (falsiNum1Holder.isEmpty())
                    {
                        falsiNum1Holder = mem14Holder.toString()
                        quadraticNum1Result.value = falsiNum1Holder
                    }
                    else if (firstOperation.isEmpty())
                    {
                        if (mem14Holder.toString()
                                .contains("-")
                        )
                        {

                            firstOperation = "-"
                            stringHolder = mem14Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation

                        }
                        else
                        {
                            firstOperation = "+"
                            stringHolder = mem14Holder
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation
                        }
                    }
                    else
                    {

                        if (mem14Holder.toString()
                                .contains("-")
                        )
                        {
                            secondOperation = "-"
                            stringHolder = mem14Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation

                        }
                        else
                        {
                            secondOperation = "+"
                            stringHolder = mem14Holder
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation
                        }
                    }
                }




                if (memCLearIsClicked)
                {
                    mem14FalsiHolder.clear()
                    mem14Value.value =
                            mem14FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                    memCLearIsClicked = false
                }

                quadraticNum1Result.value = falsiNum1Holder
                secondOperationResult.value = secondOperation
                quadraticNum2Result.value = falsiNum2Holder
                firstOperationResult.value = firstOperation
                x1Result.value = x1
                x2Result.value = x2
                quadraticNum3Result.value = falsiNum3Holder

            }
            else
            {

                memIsClickedCount += 1

                if (mem14Holder == "0")
                {

                    resultHolder = "0"
                }

                if (memCLearIsClicked)
                {
                    mem14Holder = ""
                    memCLearIsClicked = false
                }

                if (memRecordIsClicked)
                {
                    mem14Holder = ansHolder
                    memRecordIsClicked = false
                    mem14FalsiHolder.clear()
                    Log.e("message", mem14FalsiHolder.toString())
                    Log.e("message", mem14Holder.toString())
                }

                if (memIsClickedCount == 2)
                {
                    if (mem14FalsiHolder.isEmpty())
                    {
                        if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                "*"
                            ) || processHolder.contains(
                                "/"
                            )
                        )
                        {
                            processHolder += mem14Holder
                            proccessResult.value = processHolder

                        }
                        else if (processHolder == "")
                        {

                            processHolder = mem14Holder
                        }

                        if (resultHolder == "0")
                        {

                            resultHolder = "0"

                        }
                        result.value = resultHolder
                        proccessResult.value = processHolder
                        memIsClickedCount = 1

                        mem14Value.value = mem14Holder
                    }
                }
            }
        }
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    fun mem15()
    {
        try
        {
            if (macroRecordIsClicked)
            {
                isClicked = true

                isClicked = false
                if (macroRecordIsClicked)
                {

                    if (macroSet == "1")
                    {

                        array1Holder.add("M15")
                        Log.e(
                            "array",
                            array1Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array1Holder.size.toString()
                        )


                    }
                    else if (macroSet == "2")
                    {

                        array2Holder.add("M15")
                        Log.e(
                            "array",
                            array2Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array2Holder.size.toString()
                        )

                    }
                    else if (macroSet == "3")
                    {

                        array3Holder.add("M15")
                        Log.e(
                            "array",
                            array3Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array3Holder.size.toString()
                        )

                    }
                    else if (macroSet == "4")
                    {

                        array4Holder.add("M15")
                        Log.e(
                            "array",
                            array4Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array4Holder.size.toString()
                        )

                    }
                    else if (macroSet == "5")
                    {

                        array5Holder.add("M15")
                        Log.e(
                            "array",
                            array5Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array5Holder.size.toString()
                        )

                    }
                    else if (macroSet == "6")
                    {

                        array6Holder.add("M15")
                        Log.e(
                            "array",
                            array6Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array6Holder.size.toString()
                        )

                    }
                    else if (macroSet == "7")
                    {

                        array7Holder.add("M15")
                        Log.e(
                            "array",
                            array7Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array7Holder.size.toString()
                        )

                    }
                    else if (macroSet == "8")
                    {

                        array8Holder.add("M15")
                        Log.e(
                            "array",
                            array8Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array8Holder.size.toString()
                        )

                    }
                    else if (macroSet == "9")
                    {

                        array9Holder.add("M15")
                        Log.e(
                            "array",
                            array9Holder.toString()
                        )
                        Log.e(
                            "set",
                            macroSet.toString()
                        )
                        Log.e(
                            "length",
                            array9Holder.size.toString()
                        )
                    }
                }
            }
            else if (falsiMethodIsClicked)
            {
                if (memRecordIsClicked)
                {
                    mem15FalsiHolder.clear()

                    mem15FalsiHolder.add(falsiNum1Holder)
                    mem15FalsiHolder.add(x1)
                    mem15FalsiHolder.add(firstOperation)
                    mem15FalsiHolder.add(falsiNum2Holder)
                    mem15FalsiHolder.add(x2)
                    mem15FalsiHolder.add(secondOperation)
                    mem15FalsiHolder.add(falsiNum3Holder)

                    Log.e("message", mem15FalsiHolder.toString())
                    mem15Value.value =
                            mem15FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                                .replace(",", "")
                                .replace(" ", "")
                    mem15Holder = ""
                    memRecordIsClicked = false
                }

                if (mem15FalsiHolder.isNotEmpty() && !memRecordIsClicked)
                {
                    Log.e("message", mem15FalsiHolder.toString())
                    secondOperation = mem15FalsiHolder[5].toString()
                    falsiNum3Holder = mem15FalsiHolder[6].toString()
                    falsiNum1Holder = mem15FalsiHolder[0].toString()
                    x1 = mem15FalsiHolder[1].toString()
                    firstOperation = mem15FalsiHolder[2].toString()
                    falsiNum2Holder = mem15FalsiHolder[3].toString()
                    x2 = mem15FalsiHolder[4].toString()
                }
                else
                {

                    if (falsiNum1Holder.isEmpty())
                    {
                        falsiNum1Holder = mem15Holder.toString()
                        quadraticNum1Result.value = falsiNum1Holder
                    }
                    else if (firstOperation.isEmpty())
                    {
                        if (mem15Holder.toString()
                                .contains("-")
                        )
                        {

                            firstOperation = "-"
                            stringHolder = mem15Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation

                        }
                        else
                        {
                            firstOperation = "+"
                            stringHolder = mem15Holder
                            falsiNum2Holder = stringHolder.toString()
                            quadraticNum2Result.value = falsiNum2Holder
                            firstOperationResult.value = firstOperation
                        }
                    }
                    else
                    {

                        if (mem15Holder.toString()
                                .contains("-")
                        )
                        {
                            secondOperation = "-"
                            stringHolder = mem15Holder
                            stringHolder = stringHolder.drop(1)
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation

                        }
                        else
                        {
                            secondOperation = "+"
                            stringHolder = mem15Holder
                            falsiNum3Holder = stringHolder.toString()
                            quadraticNum3Result.value = falsiNum3Holder
                            secondOperationResult.value = secondOperation
                        }
                    }
                }




                if (memCLearIsClicked)
                {
                    mem15FalsiHolder.clear()
                    mem15Value.value =
                            mem15FalsiHolder.toString()
                                .dropLast(1)
                                .drop(1)
                    memCLearIsClicked = false
                }

                quadraticNum1Result.value = falsiNum1Holder
                secondOperationResult.value = secondOperation
                quadraticNum2Result.value = falsiNum2Holder
                firstOperationResult.value = firstOperation
                x1Result.value = x1
                x2Result.value = x2
                quadraticNum3Result.value = falsiNum3Holder

            }
            else
            {

                memIsClickedCount += 1

                if (mem15Holder == "0")
                {

                    resultHolder = "0"
                }

                if (memCLearIsClicked)
                {
                    mem15Holder = ""
                    memCLearIsClicked = false
                }

                if (memRecordIsClicked)
                {
                    mem15Holder = ansHolder
                    memRecordIsClicked = false
                    mem15FalsiHolder.clear()
                    Log.e("message", mem15FalsiHolder.toString())
                    Log.e("message", mem15Holder.toString())
                }

                if (memIsClickedCount == 2)
                {
                    if (mem15FalsiHolder.isEmpty())
                    {
                        if (processHolder.contains("+") || processHolder.contains("-") || processHolder.contains(
                                "*"
                            ) || processHolder.contains(
                                "/"
                            )
                        )
                        {
                            processHolder += mem15Holder
                            proccessResult.value = processHolder

                        }
                        else if (processHolder == "")
                        {

                            processHolder = mem15Holder
                        }

                        if (resultHolder == "0")
                        {

                            resultHolder = "0"

                        }
                        result.value = resultHolder
                        proccessResult.value = processHolder
                        memIsClickedCount = 1

                        mem15Value.value = mem15Holder
                    }
                }
            }
        }
        catch (e : Exception)
        {
            deleteAll()
            result.value = "Error"
        }
    }

    suspend fun falsiMethod(a : Double, b : Double) : Double
    {

        var aa = a
        var bb = b
        var c : Double = 0.0
        if (func(a) * func(b) >= 0)
        {
            println("You have not assumed right a and b")
        }
        // Initialize result
        // Initialize result
        c = aa

        for (i in 0 until 1000000)
        {
            // Find the point that touches x axis
            c = ((aa * func(bb) - b * func(aa)) / (func(bb) - func(aa)))

            // Check if the above found point is root
            if (func(c) == 0.0) break else if (func(c) * func(aa) < 0) bb = c else aa = c
            println("The value of root is : " + c.toDouble())
        }

        return c

    }

    suspend fun falsiMethodforQuad(a : Double, b : Double) : Double
    {

        var aa = a
        var bb = b
        var c : Double = 0.0
        if (func(a) * func(b) >= 0)
        {
            println("You have not assumed right a and b")
        }
        // Initialize result
        // Initialize result
        c = aa

        for (i in 0 until 10000)
        {
            // Find the point that touches x axis
            c = ((aa * func(bb) - b * func(aa)) / (func(bb) - func(aa)))

            // Check if the above found point is root
            if (func(c) == 0.0) break else if (func(c) * func(aa) < 0) bb = c else aa = c
            println("The value of root is : " + c.toDouble())
        }

        return c
    }

    fun equal()
    {
try{
        if (falsiMethodIsClicked)
        {
            var x1x : Double = 0.0
            var x2x : Double = 0.0
            var result : Double = 0.0


            if (x1 == "x")
            {
                x1x = 100.0
            }
            if (x1 == "x²")
            {
                x1x = 200.0
            }
            if (x1 == "x³")
            {
                x1x = 300.0
            }
            if (x1 == "x⁴")
            {
                x1x = 400.0
            }
            if (x1 == "x⁵")
            {
                x1x = 500.0
            }

            if (x2 == "x")
            {
                x2x = 100.0
            }
            if (x2 == "x²")
            {
                x2x = 200.0
            }
            if (x2 == "x³")
            {
                x2x = 300.0
            }
            if (x2 == "x⁴")
            {
                x2x = 400.0
            }
            if (x2 == "x⁵")
            {
                x2x = 500.0
            }

            a = falsiNum1Holder.toDouble()
            b = falsiNum2Holder.toDouble()

            var firsNumber = 0.0
            var secondNumber = 0.0

            if (secondOperation == "+")
            {
                secondNumber = b * x1x
            }

            if (secondOperation == "-")
            {
                secondNumber = -b * x1x
            }

            if (firstOperation == "+")
            {
                firsNumber = a * x2x
            }

            if (firstOperation == "-")
            {
                firsNumber = -a * x2x
            }



            if (x1 == "x³" || x1 == "x⁴" || x1 == "x⁵" || x2 == "x³" || x2 == "x⁴" || x2 == "x⁵")
            {
                CoroutineScope(Dispatchers.Default).launch {
                    x1RootResult.postValue(falsiMethod(firsNumber, secondNumber).toString())
                    message.postValue("Please wait till the math operation is over")
                }
            }
            else
            {
                CoroutineScope(Dispatchers.Default).launch {
                    x1RootResult.postValue(falsiMethodforQuad(secondNumber, firsNumber).toString())
                    message.postValue("Please wait till the math operation is over")
                }
            }


        }
        else
        {
            try
            {
                if (processHolder.isEmpty())
                {

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
                        .contains(".0")
                )
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
}catch (e : Exception){
    deleteAll()
    result.value = "Error"
}
    }

    fun falsiMethod()
    {
        try{
        click += 1

        if (click == 1)
        {
            falsiMethodIsClicked = true
        }
        else if (click == 2)
        {
            falsiMethodIsClicked = false
            click = 0
        }
        }catch (e : Exception){
            deleteAll()
            result.value = "Error"
        }
    }

    private fun func(x : Double) : Double
    {

        a = falsiNum1Holder.toDouble()
        b = falsiNum2Holder.toDouble()
        c = falsiNum3Holder.toDouble()
        var x1x : Double = x
        var x2x : Double = x
        var func : Double = 0.0

        if (x1 == "x")
        {
            x1x = x
        }
        if (x1 == "x²")
        {
            x1x = x * x
        }
        if (x1 == "x³")
        {
            x1x = x * x * x
        }
        if (x1 == "x⁴")
        {
            x1x = x * x * x * x
        }
        if (x1 == "x⁵")
        {
            x1x = x * x * x * x * x

        }
        if (x2 == "x")
        {
            x2x = x
        }
        if (x2 == "x²")
        {
            x2x = x * x
        }
        if (x2 == "x³")
        {
            x2x = x * x * x
        }
        if (x2 == "x⁴")
        {
            x2x = x * x * x * x
        }
        if (x2 == "x⁵")
        {
            x2x = x * x * x * x * x

        }



        if (firstOperation == "+" && secondOperation == "+")
        {
            func = a * x1x + b * x2x + c
        }
        if (firstOperation == "-" && secondOperation == "+")
        {
            func = a * x1x - b * x2x + c
        }
        if (firstOperation == "+" && secondOperation == "-")
        {
            func = a * x1x + b * x2x - c
        }
        if (firstOperation == "-" && secondOperation == "-")
        {
            func = a * x1x - b * x2x - c
        }

        return func
    }

    fun ansShow()
    {
        try{
        if (falsiMethodIsClicked)
        {

            if (falsiNum1Holder.isEmpty())
            {

                falsiNum1Holder = ansHolder.toString()
                quadraticNum1Result.value = falsiNum1Holder
            }
            else if (firstOperation.isEmpty() && falsiNum2Holder.isEmpty())
            {
                if (ansHolder.toString()
                        .contains("-")
                )
                {

                    firstOperation = "-"
                    stringHolder = ansHolder
                    stringHolder = stringHolder.drop(1)
                    falsiNum2Holder = stringHolder.toString()
                    quadraticNum2Result.value = falsiNum2Holder
                    firstOperationResult.value = firstOperation

                }
                else
                {
                    firstOperation = "+"
                    stringHolder = ansHolder
                    falsiNum2Holder = stringHolder.toString()
                    quadraticNum2Result.value = falsiNum2Holder
                    firstOperationResult.value = firstOperation
                }

            }
            else
            {

                if (ansHolder.toString()
                        .contains("-")
                )
                {
                    secondOperation = "-"
                    stringHolder = ansHolder
                    stringHolder = stringHolder.drop(1)
                    falsiNum3Holder = stringHolder.toString()
                    quadraticNum3Result.value = falsiNum3Holder
                    secondOperationResult.value = secondOperation

                }
                else
                {
                    secondOperation = "+"
                    stringHolder = ansHolder
                    falsiNum3Holder = stringHolder.toString()
                    quadraticNum3Result.value = falsiNum3Holder
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
                    "*"
                ) || processHolder.contains(
                    "/"
                )
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
        }catch (e : Exception){
            deleteAll()
            result.value = "Error"
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
        var value : String? = null
        if (mem1Holder.isEmpty())
        {
            value = mem1FalsiHolder.toString()
                .dropLast(1)
                .drop(1)
                .replace(",", "")
                .replace(" ", "")
        }
        else
        {
            value = mem1Holder
        }

        mem1Value.value = value
        return mem1Value
    }

    fun getM2() : LiveData<String>
    {
        var value : String? = null
        if (mem2Holder.isEmpty())
        {
            value = mem2FalsiHolder.toString()
                .dropLast(1)
                .drop(1)
                .replace(",", "")
                .replace(" ", "")
        }
        else
        {
            value = mem2Holder
        }

        mem2Value.value = value
        return mem2Value
    }

    fun getM3() : LiveData<String>
    {
        var value : String? = null
        if (mem3Holder.isEmpty())
        {
            value = mem3FalsiHolder.toString()
                .dropLast(1)
                .drop(1)
                .replace(",", "")
                .replace(" ", "")
        }
        else
        {
            value = mem3Holder
        }

        mem3Value.value = value
        return mem3Value
    }

    fun getM4() : LiveData<String>
    {
        var value : String? = null
        if (mem4Holder.isEmpty())
        {
            value = mem4FalsiHolder.toString()
                .dropLast(1)
                .drop(1)
                .replace(",", "")
                .replace(" ", "")
        }
        else
        {
            value = mem4Holder
        }

        mem4Value.value = value
        return mem4Value
    }

    fun getM5() : LiveData<String>
    {
        var value : String? = null
        if (mem5Holder.isEmpty())
        {
            value = mem5FalsiHolder.toString()
                .dropLast(1)
                .drop(1)
                .replace(",", "")
                .replace(" ", "")
        }
        else
        {
            value = mem5Holder
        }

        mem5Value.value = value
        return mem5Value
    }

    fun getM6() : LiveData<String>
    {
        var value : String? = null
        if (mem6Holder.isEmpty())
        {
            value = mem6FalsiHolder.toString()
                .dropLast(1)
                .drop(1)
                .replace(",", "")
                .replace(" ", "")
        }
        else
        {
            value = mem6Holder
        }

        mem6Value.value = value
        return mem6Value
    }

    fun getM7() : LiveData<String>
    {
        var value : String? = null
        if (mem7Holder.isEmpty())
        {
            value = mem7FalsiHolder.toString()
                .dropLast(1)
                .drop(1)
                .replace(",", "")
                .replace(" ", "")
        }
        else
        {
            value = mem7Holder
        }

        mem7Value.value = value
        return mem7Value
    }

    fun getM8() : LiveData<String>
    {
        var value : String? = null
        if (mem8Holder.isEmpty())
        {
            value = mem8FalsiHolder.toString()
                .dropLast(1)
                .drop(1)
                .replace(",", "")
                .replace(" ", "")
        }
        else
        {
            value = mem8Holder
        }

        mem8Value.value = value
        return mem8Value
    }

    fun getM9() : LiveData<String>
    {
        var value : String? = null
        if (mem9Holder.isEmpty())
        {
            value = mem9FalsiHolder.toString()
                .dropLast(1)
                .drop(1)
                .replace(",", "")
                .replace(" ", "")
        }
        else
        {
            value = mem9Holder
        }

        mem9Value.value = value
        return mem9Value
    }

    fun getM10() : LiveData<String>
    {
        var value : String? = null
        if (mem10Holder.isEmpty())
        {
            value = mem10FalsiHolder.toString()
                .dropLast(1)
                .drop(1)
                .replace(",", "")
                .replace(" ", "")
        }
        else
        {
            value = mem10Holder
        }

        mem10Value.value = value
        return mem10Value
    }

    fun getM11() : LiveData<String>
    {
        var value : String? = null
        if (mem11Holder.isEmpty())
        {
            value = mem11FalsiHolder.toString()
                .dropLast(1)
                .drop(1)
                .replace(",", "")
                .replace(" ", "")
        }
        else
        {
            value = mem11Holder
        }

        mem11Value.value = value
        return mem11Value
    }

    fun getM12() : LiveData<String>
    {
        var value : String? = null
        if (mem12Holder.isEmpty())
        {
            value = mem12FalsiHolder.toString()
                .dropLast(1)
                .drop(1)
                .replace(",", "")
                .replace(" ", "")
        }
        else
        {
            value = mem12Holder
        }

        mem12Value.value = value
        return mem12Value
    }

    fun getM13() : LiveData<String>
    {
        var value : String? = null
        if (mem13Holder.isEmpty())
        {
            value = mem13FalsiHolder.toString()
                .dropLast(1)
                .drop(1)
                .replace(",", "")
                .replace(" ", "")
        }
        else
        {
            value = mem13Holder
        }

        mem13Value.value = value
        return mem13Value
    }

    fun getM14() : LiveData<String>
    {
        var value : String? = null
        if (mem14Holder.isEmpty())
        {
            value = mem14FalsiHolder.toString()
                .dropLast(1)
                .drop(1)
                .replace(",", "")
                .replace(" ", "")
        }
        else
        {
            value = mem14Holder
        }

        mem14Value.value = value
        return mem14Value
    }

    fun getM15() : LiveData<String>
    {
        var value : String? = null
        if (mem15Holder.isEmpty())
        {
            value = mem15FalsiHolder.toString()
                .dropLast(1)
                .drop(1)
                .replace(",", "")
                .replace(" ", "")
        }
        else
        {
            value = mem15Holder
        }

        mem15Value.value = value
        return mem15Value
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

    fun x1Result() : LiveData<String>
    {
        return x1Result
    }

    fun x2Result() : LiveData<String>
    {
        return x2Result
    }

    fun getMessage() : LiveData<String>
    {
        return message
    }

    fun getMacroContains() : LiveData<String>
    {
        return macroContainsResult
    }
}