package com.example.easygoband2

//import org.junit.Assert.*
import com.google.common.truth.Truth.assertThat
import org.junit.Test


class VerifyIDTest{

    @Test
    fun `input is empty`(){

        val result =  VerifyID.isNumber(
                ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `input has space inside`(){

        val result =  VerifyID.isNumber(
                "12 34"
        )

        assertThat(result).isFalse()
    }


    @Test
    fun `input has space at start`(){

        val result =  VerifyID.isNumber(
                " 123"
        )

        assertThat(result).isFalse()
    }


    @Test
    fun `input has space at end`(){

        val result =  VerifyID.isNumber(
                " 123 "
        )

        assertThat(result).isFalse()
    }


}