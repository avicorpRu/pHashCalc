package ru.avicorp.checkphashcalc

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import ru.avicorp.phashcalc.pHashCalc

//*************************************** pHashCalk testing ****************************************

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("ru.avicorp.checkphashcalc", appContext.packageName)
    }
    @Test
    fun loadEmptyFiles(){//check condition
        val phashCalc = pHashCalc()
        phashCalc.loadSourceFile("","")
        assertEquals(phashCalc.checkCondition(),false)
    }
    @Test
    fun checkEmtpyJPEG(){//emtpty JPEG
        val phashCalc = pHashCalc()
        phashCalc.validJPEGStruct("")
        assertEquals(phashCalc.checkCondition(),false)
    }

    @Test
    fun checkEmtpyHash(){//empty HASH
        val phashCalc = pHashCalc()
        phashCalc.validJPEGStruct("")
        assertEquals(phashCalc.getHashOne(),"File not found")
    }

    @Test
    fun checkEmtpyAveragePixel(){//empty averagePixel
        val phashCalc = pHashCalc()
        phashCalc.validJPEGStruct("")
        assertEquals(phashCalc.getAveragePixelOne(),"File not found")
    }

}