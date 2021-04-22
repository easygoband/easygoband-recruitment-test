package com.example.android.data.local

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.example.android.data.models.EventDTO
import com.example.android.data.models.EventType
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.IOException


class EventDatabaseTest {

    private lateinit var eventDao: EventDatabaseDao
    private lateinit var eventdb: EventDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        eventdb = Room.inMemoryDatabaseBuilder(context, EventDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        eventDao = eventdb.eventDatabaseDao()

        saveDataIntoDatabase()
    }

    @Test
    fun saveDataIntoDatabase(){
        eventDao.saveEvents(listOf(
                EventDTO(
                        "Abono",
                        1,
                        1,
                        listOf(
                                EventType(
                                        "Caju",
                                        1
                                )
                        ),
                        1,
                        true,
                        "Martes",
                        "Abono",
                        1,
                        1
                ),
                EventDTO(
                        "Abono",
                        1,
                        1,
                        listOf(
                                EventType(
                                        "Viernes",
                                        1
                                )
                        ),
                        1,
                        true,
                        "Viernes",
                        "Abono",
                        2,
                        1
                ),EventDTO(
                "Abono",
                1,
                1,
                listOf(
                        EventType(
                                "Juanjo",
                                1
                        )
                ),
                1,
                true,
                "Viernes",
                "Abono",
                3,
                1
        ),
        ))
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        eventdb.close()
    }

    @Test
    @Throws(Exception::class)
    fun testExistingData() {
        val list = eventDao.loadEventsByName("%Mar%")
        Assert.assertEquals(1, list.size)
    }

    @Test
    @Throws(Exception::class)
    fun testNonExistingData() {
        val list = eventDao.loadEventsByName("%Lu%")
        Assert.assertEquals(0, list.size)
    }

    @Test
    @Throws(Exception::class)
    fun testEmptyStrParameter() {
        val list = eventDao.loadEventsByName("%%")
        Assert.assertEquals(3, list.size)
    }

    @Test
    @Throws(Exception::class)
    fun testGetSessionsFilteredByName(){
        val list = eventDao.loadEventsBySessionName("%ju%")
        Assert.assertEquals(2, list.size)
    }




}