package com.example.programovatelna_kalkulacka.presentation.view_model

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

    private var macroRecordIsClicked : Boolean = false
    private var macroRecallIsClicked : Boolean = false
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
        if (macroRecallIsClicked)
        {
            arraySize = array1Holder.size
            resultHolder.plus(1)
            macroChoosed = "1"
            macroRecallIsClicked = false

        }
        else if (macroRecordIsClicked)
        {

            macroSet = "1"

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

    fun addNumber2()
    {
        if (macroRecallIsClicked)
        {
            arraySize = array2Holder.size
            resultHolder.plus(1)
            macroChoosed = "2"
            macroRecallIsClicked = false

        }
        else if (macroRecordIsClicked)
        {

            macroSet = "2"

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

    fun addNumber3()
    {
        if (macroRecallIsClicked)
        {
            arraySize = array3Holder.size
            resultHolder.plus(1)
            macroChoosed = "3"
            macroRecallIsClicked = false

        }
        else if (macroRecordIsClicked)
        {

            macroSet = "3"

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

    fun addNumber4()
    {
        if (macroRecallIsClicked)
        {
            arraySize = array4Holder.size
            resultHolder.plus(1)
            macroChoosed = "4"
            macroRecallIsClicked = false

        }
        else if (macroRecordIsClicked)
        {

            macroSet = "4"

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

    fun addNumber5()
    {
        if (macroRecallIsClicked)
        {
            arraySize = array5Holder.size
            resultHolder.plus(1)
            macroChoosed = "5"
            macroRecallIsClicked = false

        }
        else if (macroRecordIsClicked)
        {

            macroSet = "5"

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

    fun addNumber6()
    {
        if (macroRecallIsClicked)
        {
            arraySize = array6Holder.size
            resultHolder.plus(1)
            macroChoosed = "6"
            macroRecallIsClicked = false

        }
        else if (macroRecordIsClicked)
        {

            macroSet = "6"

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

    fun addNumber7()
    {
        if (macroRecallIsClicked)
        {
            arraySize = array7Holder.size
            resultHolder.plus(1)
            macroChoosed = "7"
            macroRecallIsClicked = false

        }
        else if (macroRecordIsClicked)
        {

            macroSet = "7"

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

    fun addNumber8()
    {
        if (macroRecallIsClicked)
        {
            arraySize = array8Holder.size
            resultHolder.plus(1)
            macroChoosed = "8"
            macroRecallIsClicked = false

        }
        else if (macroRecordIsClicked)
        {

            macroSet = "8"

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

    fun addNumber9()
    {
        if (macroRecallIsClicked)
        {
            arraySize = array9Holder.size
            resultHolder.plus(1)
            macroChoosed = "9"
            macroRecallIsClicked = false

        }
        else if (macroRecordIsClicked)
        {

            macroSet = "9"

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

    fun addNumber0()
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

                processHolder = "0"
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
            c= 0.0
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
            numberArrayHolder.removeAll(numberArrayHolder)
            count = -1
            macroChoosed = "0"
            arraySize = 0
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

    fun plus()
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
            else
            {

                numberArrayHolder.add(resultHolder + array1Holder[count])
            }

            resultHolder = "0"
            processHolder = "0"

            result.value = resultHolder

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

            }
            Log.e(
                "message",
                numberArrayHolder.toString()
            )


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

            }
            else
            {

                numberArrayHolder.add(resultHolder + array2Holder[count])
            }

            resultHolder = "0"
            processHolder = "0"

            result.value = resultHolder

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

            }
            Log.e(
                "message",
                numberArrayHolder.toString()
            )


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

            }
            else
            {

                numberArrayHolder.add(resultHolder + array3Holder[count])
            }
            resultHolder = "0"
            processHolder = "0"

            result.value = resultHolder

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

            }
            Log.e(
                "message",
                numberArrayHolder.toString()
            )


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

            }
            else
            {

                numberArrayHolder.add(resultHolder + array4Holder[count])
            }
            resultHolder = "0"
            processHolder = "0"

            result.value = resultHolder

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

            }
            Log.e(
                "message",
                numberArrayHolder.toString()
            )


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

            }
            else
            {

                numberArrayHolder.add(resultHolder + array5Holder[count])
            }
            resultHolder = "0"
            processHolder = "0"

            result.value = resultHolder

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

            }
            Log.e(
                "message",
                numberArrayHolder.toString()
            )


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

            }
            else
            {

                numberArrayHolder.add(resultHolder + array6Holder[count])
            }
            resultHolder = "0"
            processHolder = "0"

            result.value = resultHolder

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

            }
            Log.e(
                "message",
                numberArrayHolder.toString()
            )


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

            }
            else
            {

                numberArrayHolder.add(resultHolder + array7Holder[count])
            }
            resultHolder = "0"
            processHolder = "0"

            result.value = resultHolder

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

            }
            Log.e(
                "message",
                numberArrayHolder.toString()
            )


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

            }
            else
            {

                numberArrayHolder.add(resultHolder + array8Holder[count])
            }
            resultHolder = "0"
            processHolder = "0"

            result.value = resultHolder

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

            }
            Log.e(
                "message",
                numberArrayHolder.toString()
            )


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

            }
            else
            {

                numberArrayHolder.add(resultHolder + array9Holder[count])
            }
            resultHolder = "0"
            processHolder = "0"

            result.value = resultHolder

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

            }
            Log.e(
                "message",
                numberArrayHolder.toString()
            )

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

    fun minus()
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

    fun multiply()
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

    fun divide()
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

    fun percent()
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

    fun power2()
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

    fun power3()
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

    fun squareRoot()
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

    fun macroRecord()
    {

        macroRecordIsClicked = true
        processHolder = ""
        resultHolder = "0"
        result.value = resultHolder
        proccessResult.value = processHolder
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

        if (falsiMethodIsClicked)
        {

            if (falsiNum1Holder.isEmpty())
            {

                falsiNum1Holder = mem1Holder.toString()
                quadraticNum1Result.value = falsiNum1Holder
            }
            else if (firstOperation.isEmpty() && falsiNum2Holder.isEmpty())
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


            }

            if (memIsClickedCount == 2)
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
            }
            mem1Value.value = mem1Holder
        }
    }


    fun mem2()
    {

        if (falsiMethodIsClicked)
        {

            if (falsiNum1Holder.isEmpty())
            {

                falsiNum1Holder = mem2Holder.toString()
                quadraticNum1Result.value = falsiNum1Holder
            }
            else if (firstOperation.isEmpty() && falsiNum2Holder.isEmpty())
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
                Log.e(
                    "message",
                    mem2Holder.toString()
                )
                Log.e(
                    "message",
                    memRecordIsClicked.toString()
                )
                memRecordIsClicked = false

            }

            if (memIsClickedCount == 2)
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
            }
            mem2Value.value = mem2Holder
        }
    }

    fun mem3()
    {

        if (falsiMethodIsClicked)
        {

            if (falsiNum1Holder.isEmpty())
            {

                falsiNum1Holder = mem3Holder.toString()
                quadraticNum1Result.value = falsiNum1Holder
            }
            else if (firstOperation.isEmpty() && falsiNum2Holder.isEmpty())
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
                Log.e(
                    "message",
                    mem3Holder.toString()
                )
                Log.e(
                    "message",
                    memRecordIsClicked.toString()
                )
                memRecordIsClicked = false
            }

            if (memIsClickedCount == 2)
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
            }
            mem3Value.value = mem3Holder
        }
    }

    fun mem4()
    {

        if (falsiMethodIsClicked)
        {

            if (falsiNum1Holder.isEmpty())
            {

                falsiNum1Holder = mem4Holder.toString()
                quadraticNum1Result.value = falsiNum1Holder
            }
            else if (firstOperation.isEmpty() && falsiNum2Holder.isEmpty())
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
                Log.e(
                    "message",
                    mem4Holder.toString()
                )
                Log.e(
                    "message",
                    memRecordIsClicked.toString()
                )
                memRecordIsClicked = false

                /*if (connect != null)
                { //pokud se pripojeni k dbs zdarilo stane se podminka

                    var statement : Statement? = null
                    var count : Int
                    try
                    {
                        statement = connect!!.createStatement()
                        var query1 : ResultSet =
                                statement.executeQuery("Update MemoryHolder set value = ${ansHolder.toInt()} where id = ('4')")
                    }
                    catch (e : Exception)
                    {
                        Log.e("message", "An Error has occured")
                    }
                }

                 */
            }

            if (memIsClickedCount == 2)
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
            }
            mem4Value.value = mem4Holder
        }
    }

    fun mem5()
    {

        if (falsiMethodIsClicked)
        {

            if (falsiNum1Holder.isEmpty())
            {

                falsiNum1Holder = mem5Holder.toString()
                quadraticNum1Result.value = falsiNum1Holder
            }
            else if (firstOperation.isEmpty() && falsiNum2Holder.isEmpty())
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
                Log.e(
                    "message",
                    mem5Holder.toString()
                )
                Log.e(
                    "message",
                    memRecordIsClicked.toString()
                )
                memRecordIsClicked = false

                /*if (connect != null)
                { //pokud se pripojeni k dbs zdarilo stane se podminka

                    var statement : Statement? = null
                    var count : Int
                    try
                    {
                        statement = connect!!.createStatement()
                        var query1 : ResultSet =
                                statement.executeQuery("Update MemoryHolder set value = ${ansHolder.toInt()} where id = ('5')")
                    }
                    catch (e : Exception)
                    {
                        Log.e("message", "An Error has occured")
                    }
                }

                 */
            }

            if (memIsClickedCount == 2)
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
            }
            mem5Value.value = mem5Holder
        }
    }

    fun mem6()
    {

        if (falsiMethodIsClicked)
        {

            if (falsiNum1Holder.isEmpty())
            {

                falsiNum1Holder = mem6Holder.toString()
                quadraticNum1Result.value = falsiNum1Holder
            }
            else if (firstOperation.isEmpty() && falsiNum2Holder.isEmpty())
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

                /*if (connect != null)
                { //pokud se pripojeni k dbs zdarilo stane se podminka

                    var statement : Statement? = null
                    var count : Int
                    try
                    {
                        statement = connect!!.createStatement()
                        var query1 : ResultSet =
                                statement.executeQuery("Update MemoryHolder set value = ${ansHolder.toInt()} where id = ('6')")
                    }
                    catch (e : Exception)
                    {
                        Log.e("message", "An Error has occured")
                    }
                }

                 */
            }

            if (memIsClickedCount == 2)
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
            }
            mem6Value.value = mem6Holder
        }
    }

    fun mem7()
    {

        if (falsiMethodIsClicked)
        {

            if (falsiNum1Holder.isEmpty())
            {

                falsiNum1Holder = mem7Holder.toString()
                quadraticNum1Result.value = falsiNum1Holder
            }
            else if (firstOperation.isEmpty() && falsiNum2Holder.isEmpty())
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
        else
        {

            memIsClickedCount += 1

            if (mem7Holder == "")
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


            }

            if (memIsClickedCount == 2)
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
            }
            mem7Value.value = mem7Holder
        }
    }

    fun mem8()
    {

        if (falsiMethodIsClicked)
        {

            if (falsiNum1Holder.isEmpty())
            {

                falsiNum1Holder = mem8Holder.toString()
                quadraticNum1Result.value = falsiNum1Holder
            }
            else if (firstOperation.isEmpty() && falsiNum2Holder.isEmpty())
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
        else
        {

            memIsClickedCount += 1

            if (mem8Holder == "")
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

            }

            if (memIsClickedCount == 2)
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
            }
            mem8Value.value = mem8Holder
        }
    }

    fun mem9()
    {

        if (falsiMethodIsClicked)
        {

            if (falsiNum1Holder.isEmpty())
            {

                falsiNum1Holder = mem9Holder.toString()
                quadraticNum1Result.value = falsiNum1Holder
            }
            else if (firstOperation.isEmpty() && falsiNum2Holder.isEmpty())
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
        else
        {

            memIsClickedCount += 1

            if (mem9Holder == "")
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

            }

            if (memIsClickedCount == 2)
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
            }
            mem9Value.value = mem9Holder
        }
    }

    fun mem10()
    {

        if (falsiMethodIsClicked)
        {

            if (falsiNum1Holder.isEmpty())
            {

                falsiNum1Holder = mem10Holder.toString()
                quadraticNum1Result.value = falsiNum1Holder
            }
            else if (firstOperation.isEmpty() && falsiNum2Holder.isEmpty())
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
        else
        {

            memIsClickedCount += 1

            if (mem10Holder == "")
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


            }

            if (memIsClickedCount == 2)
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
            }
            mem10Value.value = mem10Holder
        }
    }

    fun mem11()
    {

        if (falsiMethodIsClicked)
        {

            if (falsiNum1Holder.isEmpty())
            {

                falsiNum1Holder = mem11Holder.toString()
                quadraticNum1Result.value = falsiNum1Holder
            }
            else if (firstOperation.isEmpty() && falsiNum2Holder.isEmpty())
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
        else
        {

            memIsClickedCount += 1

            if (mem11Holder == "0")
            {

                resultHolder = "0"
            }

            if (memCLearIsClicked)
            {
                mem11Holder = "0"
                memCLearIsClicked = false
            }

            if (memRecordIsClicked)
            {
                mem11Holder = ansHolder
                memRecordIsClicked = false


            }

            if (memIsClickedCount == 2)
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
            }
            mem11Value.value = mem11Holder
        }
    }

    fun mem12()
    {

        if (falsiMethodIsClicked)
        {

            if (falsiNum1Holder.isEmpty())
            {

                falsiNum1Holder = mem12Holder.toString()
                quadraticNum1Result.value = falsiNum1Holder
            }
            else if (firstOperation.isEmpty() && falsiNum2Holder.isEmpty())
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
        else
        {

            memIsClickedCount += 1

            if (mem12Holder == "")
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


            }

            if (memIsClickedCount == 2)
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
            }
            mem12Value.value = mem12Holder
        }
    }

    fun mem13()
    {

        if (falsiMethodIsClicked)
        {

            if (falsiNum1Holder.isEmpty())
            {

                falsiNum1Holder = mem13Holder.toString()
                quadraticNum1Result.value = falsiNum1Holder
            }
            else if (firstOperation.isEmpty() && falsiNum2Holder.isEmpty())
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
        else
        {

            memIsClickedCount += 1

            if (mem13Holder == "")
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


            }

            if (memIsClickedCount == 2)
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
            }
            mem13Value.value = mem13Holder
        }
    }

    fun mem14()
    {

        if (falsiMethodIsClicked)
        {

            if (falsiNum1Holder.isEmpty())
            {

                falsiNum1Holder = mem14Holder.toString()
                quadraticNum1Result.value = falsiNum1Holder
            }
            else if (firstOperation.isEmpty() && falsiNum2Holder.isEmpty())
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
        else
        {

            memIsClickedCount += 1

            if (mem14Holder == "")
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

            }

            if (memIsClickedCount == 2)
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
            }
            mem14Value.value = mem14Holder
        }
    }

    fun mem15()
    {

        if (falsiMethodIsClicked)
        {

            if (falsiNum1Holder.isEmpty())
            {

                falsiNum1Holder = mem15Holder.toString()
                quadraticNum1Result.value = falsiNum1Holder
            }
            else if (firstOperation.isEmpty() && falsiNum2Holder.isEmpty())
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
        else
        {

            memIsClickedCount += 1

            if (mem15Holder == "")
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

            }

            if (memIsClickedCount == 2)
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
            }
            mem15Value.value = mem15Holder
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

        if (falsiMethodIsClicked)
        {
            var x1x : Double = 0.0
            var x2x : Double = 0.0
            var result  : Double = 0.0


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

            if(x1 == "x³" || x1 == "x⁴"|| x1 == "x⁵" || x2 == "x³" || x2 == "x⁴"|| x2 == "x⁵") {
                CoroutineScope(Dispatchers.Default).launch {
                    x1RootResult.postValue(falsiMethod(firsNumber,secondNumber).toString())
                    message.postValue("Please wait till the math operation is over")
                }
            }else{
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
    }

    fun falsiMethod()
    {
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
        if(firstOperation == "-" && secondOperation == "-")
        {
            func = a * x1x - b * x2x - c
        }

        return func
    }

    fun ansShow()
    {
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
        mem1Value.value = mem1Holder
        return mem1Value
    }

    fun getM2() : LiveData<String>
    {
        mem2Value.value = mem2Holder
        return mem2Value
    }

    fun getM3() : LiveData<String>
    {
        mem3Value.value = mem3Holder
        return mem3Value
    }

    fun getM4() : LiveData<String>
    {
        mem4Value.value = mem4Holder
        return mem4Value
    }

    fun getM5() : LiveData<String>
    {
        mem5Value.value = mem5Holder
        return mem5Value
    }

    fun getM6() : LiveData<String>
    {
        mem6Value.value = mem6Holder
        return mem6Value
    }

    fun getM7() : LiveData<String>
    {
        mem7Value.value = mem7Holder
        return mem7Value
    }

    fun getM8() : LiveData<String>
    {
        mem8Value.value = mem8Holder
        return mem8Value
    }

    fun getM9() : LiveData<String>
    {
        mem9Value.value = mem9Holder
        return mem9Value
    }

    fun getM10() : LiveData<String>
    {
        mem10Value.value = mem10Holder
        return mem10Value
    }

    fun getM11() : LiveData<String>
    {
        mem11Value.value = mem11Holder
        return mem11Value
    }

    fun getM12() : LiveData<String>
    {
        mem12Value.value = mem12Holder
        return mem12Value
    }

    fun getM13() : LiveData<String>
    {
        mem13Value.value = mem13Holder
        return mem13Value
    }

    fun getM14() : LiveData<String>
    {
        mem14Value.value = mem14Holder
        return mem14Value
    }

    fun getM15() : LiveData<String>
    {
        mem15Value.value = mem15Holder
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

    fun getMessage() : LiveData<String>{

        return message
    }
}